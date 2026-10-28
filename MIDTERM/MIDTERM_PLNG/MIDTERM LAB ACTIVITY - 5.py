class CustomerNode:
    def __init__(self, name):
        self.name = name
        self.next = None

class WaitingList:
    def __init__(self):
        self.head = None
        self.tail = None

    def add_customer(self, name):
        new_node = CustomerNode(name)
        if not self.head:
            self.head = new_node
            self.tail = new_node
        else:
            self.tail.next = new_node
            self.tail = new_node

    def serve_customer(self):
        if not self.head:
            print("Waiting list is empty.")
            return None
        served_name = self.head.name
        self.head = self.head.next
        if not self.head:
            self.tail = None
        return served_name

    def cancel_customer(self, name):
        if not self.head:
            print("Waiting list is empty.")
            return
        if self.head.name == name:
            self.head = self.head.next
            if not self.head:
                self.tail = None
            print(f"Cancelled: {name}")
            return
        current = self.head
        while current.next:
            if current.next.name == name:
                if current.next == self.tail:
                    self.tail = current
                current.next = current.next.next
                print(f"Cancelled: {name}")
                return
            current = current.next
        print("Customer not found.")

    def display_waiting(self):
        if not self.head:
            print("Waiting: None")
            return
        current = self.head
        res = []
        while current:
            res.append(current.name)
            current = current.next
        print("Waiting: " + " -> ".join(res) + " -> None")

    def count_customers(self):
        count = 0
        current = self.head
        while current:
            count += 1
            current = current.next
        print(f"Customers waiting: {count}")

class SongNode:
    def __init__(self, title):
        self.title = title
        self.prev = None
        self.next = None

class Playlist:
    def __init__(self):
        self.head = None
        self.tail = None
        self.current = None

    def add_song(self, title):
        new_node = SongNode(title)
        if not self.head:
            self.head = new_node
            self.tail = new_node
            self.current = new_node
        else:
            self.tail.next = new_node
            new_node.prev = self.tail
            self.tail = new_node

    def next_song(self):
        if not self.current:
            print("Playlist is empty.")
        elif self.current.next:
            self.current = self.current.next
            print(f"Current: {self.current.title}")
        else:
            print("Already at the last song.")

    def previous_song(self):
        if not self.current:
            print("Playlist is empty.")
        elif self.current.prev:
            self.current = self.current.prev
            print(f"Current: {self.current.title}")
        else:
            print("Already at the first song.")

    def show_current(self):
        if self.current:
            print(f"Current: {self.current.title}")
        else:
            print("Playlist is empty.")

    def display_forward(self):
        if not self.head:
            print("Forward: None")
            return
        current = self.head
        res = []
        while current:
            res.append(current.title)
            current = current.next
        print("Forward: " + " <-> ".join(res))

    def display_backward(self):
        if not self.tail:
            print("Backward: None")
            return
        current = self.tail
        res = []
        while current:
            res.append(current.title)
            current = current.prev
        print("Backward: " + " <-> ".join(res))

    def remove_song(self, title):
        if not self.head:
            print("Playlist is empty.")
            return
        current = self.head
        while current:
            if current.title == title:
                if current == self.current:
                    if current.next:
                        self.current = current.next
                    else:
                        self.current = current.prev
                if current == self.head:
                    self.head = self.head.next
                    if self.head:
                        self.head.prev = None
                    else:
                        self.tail = None
                elif current == self.tail:
                    self.tail = self.tail.prev
                    if self.tail:
                        self.tail.next = None
                    else:
                        self.head = None
                else:
                    current.prev.next = current.next
                    current.next.prev = current.prev
                print(f"Removed: {title}")
                return
            current = current.next
        print("Song not found.")

def run_waiting_list():
    wl = WaitingList()
    while True:
        print("\nMenu: 1 Add customer | 2 Serve customer | 3 Cancel customer | 4 Display waiting list | 5 Count customers | 0 Exit")
        choice = input("Enter choice: ").strip()
        if choice == "1":
            name = input("Enter customer name: ").strip()
            if name:
                wl.add_customer(name)
            else:
                print("invalid")
        elif choice == "2":
            wl.serve_customer()
        elif choice == "3":
            name = input("Enter customer name to cancel: ").strip()
            if name:
                wl.cancel_customer(name)
            else:
                print("invalid")
        elif choice == "4":
            wl.display_waiting()
        elif choice == "5":
            wl.count_customers()
        elif choice == "0":
            break
        else:
            print("invalid")

def run_playlist():
    pl = Playlist()
    while True:
        print("\nMenu: 1 Add song | 2 Next song | 3 Previous song | 4 Show current | 5 Display forward | 6 Display backward | 7 Remove song | 0 Exit")
        choice = input("Enter choice: ").strip()
        if choice == "1":
            title = input("Enter song title: ").strip()
            if title:
                pl.add_song(title)
            else:
                print("invalid")
        elif choice == "2":
            pl.next_song()
        elif choice == "3":
            pl.previous_song()
        elif choice == "4":
            pl.show_current()
        elif choice == "5":
            pl.display_forward()
        elif choice == "6":
            pl.display_backward()
        elif choice == "7":
            title = input("Enter song title to remove: ").strip()
            if title:
                pl.remove_song(title)
            else:
                print("invalid")
        elif choice == "0":
            break
        else:
            print("invalid")

while True:
    main_choice = input("Select Application (1: Waiting List, 2: Playlist, or 'q' to quit): ").strip()
    if main_choice == 'q':
        break
    elif main_choice == "1":
        run_waiting_list()
    elif main_choice == "2":
        run_playlist()
    else:
        print("invalid")
