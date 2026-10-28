import copy
import sys
import unittest

VALID_PURPOSES = {"Enrollment", "Records", "Payment"}
VALID_SERVICE_TYPES = {"regular", "priority"}

_ticket_counter = 0

def reset_ticket_counter():
    global _ticket_counter
    _ticket_counter = 0

def issue_ticket(purpose, service_type="regular"):
    global _ticket_counter

    formatted_purpose = purpose.strip().capitalize() if isinstance(purpose, str) else ""
    formatted_service = service_type.strip().lower() if isinstance(service_type, str) else ""

    if formatted_purpose not in VALID_PURPOSES:
        raise ValueError(
            f"Invalid purpose '{purpose}'. Must be one of: {', '.join(VALID_PURPOSES)}"
        )

    if formatted_service not in VALID_SERVICE_TYPES:
        raise ValueError(
            f"Invalid service type '{service_type}'. Must be 'regular' or 'priority'."
        )

    _ticket_counter += 1
    ticket = {
        "id": _ticket_counter,
        "purpose": formatted_purpose,
        "service_type": formatted_service,
        "status": "waiting",
    }
    return ticket

def issue_many(*requests):
    validated_args = []
    for req in requests:
        if not isinstance(req, (tuple, list)) or len(req) < 1:
            raise ValueError("Each request must be a tuple of (purpose, [service_type]).")

        purpose = req[0]
        service_type = req[1] if len(req) > 1 else "regular"

        formatted_purpose = purpose.strip().capitalize() if isinstance(purpose, str) else ""
        formatted_service = service_type.strip().lower() if isinstance(service_type, str) else ""

        if formatted_purpose not in VALID_PURPOSES or formatted_service not in VALID_SERVICE_TYPES:
            raise ValueError(f"Batch creation aborted. Invalid request payload: {req}")

        validated_args.append((formatted_purpose, formatted_service))

    created_tickets = []
    for p, s in validated_args:
        created_tickets.append(issue_ticket(p, s))

    return created_tickets

def next_ticket(tickets, priority_streak):
    waiting_tickets = [t for t in tickets if t["status"] == "waiting"]
    if not waiting_tickets:
        return None, priority_streak

    p_waiting = [t for t in waiting_tickets if t["service_type"] == "priority"]
    r_waiting = [t for t in waiting_tickets if t["service_type"] == "regular"]

    if priority_streak >= 2 and r_waiting:
        chosen = r_waiting[0]
        new_streak = 0
    elif p_waiting:
        chosen = p_waiting[0]
        new_streak = priority_streak + 1
    else:
        chosen = r_waiting[0]
        new_streak = 0

    return chosen, new_streak

def report(**kwargs):
    print("\n--- QUEUE REPORT SUMMARY ---")
    for key, val in kwargs.items():
        formatted_key = key.replace("_", " ").title()
        print(f"  {formatted_key}: {val}")
    print("----------------------------\n")

def estimate_waiting_position(tickets, target_ticket_id, current_streak=0):
    simulated_tickets = copy.deepcopy(tickets)
    streak = current_streak
    position = 0

    target = next((t for t in simulated_tickets if t["id"] == target_ticket_id), None)
    if not target or target["status"] != "waiting":
        return None

    while True:
        nxt, streak = next_ticket(simulated_tickets, streak)
        if not nxt:
            break
        position += 1
        if nxt["id"] == target_ticket_id:
            return position
        nxt["status"] = "served"

    return None

class WaitingTicketIterator:
    def __init__(self, tickets):
        self.tickets = tickets
        self.index = 0

    def __iter__(self):
        return self

    def __next__(self):
        while self.index < len(self.tickets):
            ticket = self.tickets[self.index]
            self.index += 1
            if ticket["status"] == "waiting":
                return ticket
        raise StopIteration

class CampusQueueApp:
    def __init__(self):
        self.tickets = []
        self.counters = {i + 1: None for i in range(2)}
        self.priority_streak = 0

    def display_menu(self):
        print("==================================")
        print("  CAMPUS SERVICE QUEUE MANAGER")
        print("==================================")
        print("1 Issue a ticket")
        print("2 Call the next ticket")
        print("3 Complete a service")
        print("4 Cancel a waiting ticket")
        print("5 Show waiting tickets")
        print("6 Show counter status & history")
        print("7 Show a summary report")
        print("8 Exit")

    def run(self):
        while True:
            self.display_menu()
            choice = input("Enter option (1-8): ").strip()

            if choice == "1":
                self.handle_issue_ticket()
            elif choice == "2":
                self.handle_call_next()
            elif choice == "3":
                self.handle_complete_service()
            elif choice == "4":
                self.handle_cancel_ticket()
            elif choice == "5":
                self.handle_show_waiting()
            elif choice == "6":
                self.handle_show_counters_and_history()
            elif choice == "7":
                self.handle_summary_report()
            elif choice == "8":
                print("\nExiting Campus Queue Manager. Goodbye!")
                break
            else:
                print("\n[ERROR] Invalid choice. Please enter a number between 1 and 8.")

    def handle_issue_ticket(self):
        print("\n-- Purpose Options: Enrollment, Records, Payment --")
        purpose = input("Enter Purpose: ").strip()
        service_type = input("Enter Service Type (regular/priority) [default: regular]: ").strip()
        if not service_type:
            service_type = "regular"

        try:
            t = issue_ticket(purpose, service_type)
            self.tickets.append(t)
            pos = estimate_waiting_position(self.tickets, t["id"], self.priority_streak)
            print(f"\n[SUCCESS] Ticket #{t['id']} issued for {t['purpose']} ({t['service_type']}). Estimated Queue Position: {pos}")
        except ValueError as e:
            print(f"\n[ERROR] {e}")

    def handle_call_next(self):
        free_counter = None
        for c_id in range(1, len(self.counters) + 1):
            if self.counters[c_id] is None:
                free_counter = c_id
                break

        if free_counter is None:
            print("\n[ALERT] All service counters are currently busy. Complete a service first!")
            return

        nxt, self.priority_streak = next_ticket(self.tickets, self.priority_streak)
        if nxt is None:
            print("\n[INFO] No waiting tickets available in the queue.")
            return

        nxt["status"] = "calling"
        self.counters[free_counter] = nxt
        print(f"\n[ACTION] Counter {free_counter} is now serving Ticket #{nxt['id']} ({nxt['service_type'].upper()} - {nxt['purpose']}).")

    def handle_complete_service(self):
        try:
            c_input = input("Enter Counter ID to complete service (1 or 2): ").strip()
            if not c_input.isdigit():
                print("\n[ERROR] Counter ID must be numeric.")
                return
            c_id = int(c_input)

            if c_id not in self.counters:
                print(f"\n[ERROR] Invalid Counter ID. Available counters: {list(self.counters.keys())}")
                return

            ticket = self.counters[c_id]
            if ticket is None:
                print(f"\n[ERROR] Counter {c_id} is already free. No active service to complete.")
                return

            ticket["status"] = "served"
            self.counters[c_id] = None
            print(f"\n[SUCCESS] Ticket #{ticket['id']} completed service at Counter {c_id}.")

        except Exception as e:
            print(f"\n[ERROR] Unexpected error: {e}")

    def handle_cancel_ticket(self):
        t_input = input("Enter Ticket Number to cancel: ").strip()
        if not t_input.isdigit():
            print("\n[ERROR] Ticket number must be a valid integer.")
            return
        t_id = int(t_input)

        ticket = next((t for t in self.tickets if t["id"] == t_id), None)
        if ticket is None:
            print(f"\n[ERROR] Ticket #{t_id} does not exist.")
            return

        if ticket["status"] != "waiting":
            print(f"\n[ERROR] Cannot cancel Ticket #{t_id}. Current status is '{ticket['status']}'.")
            return

        ticket["status"] = "cancelled"
        print(f"\n[SUCCESS] Ticket #{t_id} has been cancelled.")

    def handle_show_waiting(self):
        print("\n--- CURRENT WAITING TICKETS ---")
        iterator = WaitingTicketIterator(self.tickets)
        count = 0
        try:
            for idx in range(1, len(self.tickets) + 1):
                t = next(iterator)
                count += 1
                pos_est = estimate_waiting_position(self.tickets, t["id"], self.priority_streak)
                print(f" Pos {count} | Ticket #{t['id']} | {t['service_type'].upper()} | {t['purpose']} | Est. Call Pos: {pos_est}")
        except StopIteration:
            pass

        if count == 0:
            print("  No waiting tickets found.")
        print("-------------------------------")

    def handle_show_counters_and_history(self):
        print("\n--- COUNTER STATUS ---")
        for c_id, ticket in self.counters.items():
            status = f"BUSY (Serving Ticket #{ticket['id']})" if ticket else "FREE"
            print(f" Counter {c_id}: {status}")

        print("\n--- COMPLETED SERVICE HISTORY ---")
        served = [t for t in self.tickets if t["status"] == "served"]
        if not served:
            print("  No completed services yet.")
        else:
            for t in served:
                print(f" Ticket #{t['id']} | {t['service_type'].upper()} | {t['purpose']}")

    def handle_summary_report(self):
        waiting_count = sum(1 for t in self.tickets if t["status"] == "waiting")
        served_count = sum(1 for t in self.tickets if t["status"] == "served")
        cancelled_count = sum(1 for t in self.tickets if t["status"] == "cancelled")
        free_counters = sum(1 for t in self.counters.values() if t is None)

        report(
            total_tickets_created=len(self.tickets),
            waiting_tickets=waiting_count,
            served_tickets=served_count,
            cancelled_tickets=cancelled_count,
            free_counters=free_counters,
            priority_streak=self.priority_streak,
        )

class TestCampusQueueManager(unittest.TestCase):
    def setUp(self):
        reset_ticket_counter()

    def test_ticket_numbering(self):
        t1 = issue_ticket("Enrollment", "regular")
        t2 = issue_ticket("Records", "priority")
        self.assertEqual(t1["id"], 1)
        self.assertEqual(t2["id"], 2)

    def test_fairness_rule(self):
        tickets = [
            issue_ticket("Enrollment", "priority"),
            issue_ticket("Records", "priority"),
            issue_ticket("Payment", "priority"),
            issue_ticket("Enrollment", "regular"),
        ]
        streak = 0

        nxt, streak = next_ticket(tickets, streak)
        self.assertEqual(nxt["id"], 1)
        nxt["status"] = "calling"

        nxt, streak = next_ticket(tickets, streak)
        self.assertEqual(nxt["id"], 2)
        nxt["status"] = "calling"

        nxt, streak = next_ticket(tickets, streak)
        self.assertEqual(nxt["id"], 4)
        self.assertEqual(streak, 0)

    def test_both_counters_busy(self):
        app = CampusQueueApp()
        t1 = issue_ticket("Enrollment")
        t2 = issue_ticket("Records")
        app.tickets.extend([t1, t2])

        app.handle_call_next()
        app.handle_call_next()

        self.assertIsNotNone(app.counters[1])
        self.assertIsNotNone(app.counters[2])

        free_counter = next((c for c, t in app.counters.items() if t is None), None)
        self.assertIsNone(free_counter)

    def test_cancellation_skipped(self):
        tickets = [
            issue_ticket("Enrollment", "regular"),
            issue_ticket("Records", "regular"),
        ]
        tickets[0]["status"] = "cancelled"

        nxt, _ = next_ticket(tickets, 0)
        self.assertEqual(nxt["id"], 2)

    def test_iterator_exhaustion(self):
        tickets = [issue_ticket("Enrollment", "regular")]
        it = WaitingTicketIterator(tickets)

        item = next(it)
        self.assertEqual(item["id"], 1)

        with self.assertRaises(StopIteration):
            next(it)

if __name__ == "__main__":
    if len(sys.argv) > 1 and sys.argv[1] == "--test":
        unittest.main(argv=[sys.argv[0]])
    else:
        app = CampusQueueApp()
        app.run()