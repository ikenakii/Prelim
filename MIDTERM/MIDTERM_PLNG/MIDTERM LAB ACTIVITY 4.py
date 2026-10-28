class Patient:
    def __init__(self, name, admission_date, disease, discharge_date, age):
        self.name = name
        self.admission_date = admission_date
        self.disease = disease
        self.discharge_date = discharge_date
        self.age = age

    def display(self):
        print(f"Name: {self.name}, Age: {self.age}, Admission: {self.admission_date}, Disease: {self.disease}, Discharge: {self.discharge_date}")

class PediatricPatient(Patient):
    def __init__(self, name, admission_date, disease, discharge_date, age):
        super().__init__(name, admission_date, disease, discharge_date, age)

class Professor:
    def __init__(self, name, salary):
        self.name = name
        self.salary = salary

class Dean(Professor):
    def __init__(self, name, salary, department):
        super().__init__(name, salary)
        self.department = department

    def __str__(self):
        return f"Status\nRank: Dean\nName: {self.name}\nDepartment: {self.department}\nSalary: {self.salary}"

class Executive(Dean):
    def __init__(self, name, salary, department):
        super().__init__(name, salary, department)

    def __str__(self):
        return f"Status\nRank: Executive\nName: {self.name}\nDepartment: {self.department}\nSalary: {self.salary}"

def run_program_one():
    print("Welcome!")
    balance = 0.0
    while True:
        val = input("Enter your balance: ")
        try:
            balance = float(val)
            if balance >= 0:
                break
        except ValueError:
            pass
        print("invalid")

    while True:
        print("Select an option:")
        print("1. Withdraw Amount")
        print("2. Deposit Amount")
        print("3. Exit")
        opt = input("Enter option (1-3): ")
        if opt == "1":
            while True:
                w_val = input("How much amount you want to withdraw from your account?\nAmount: ")
                try:
                    w_amt = float(w_val)
                    if 0 <= w_amt <= balance:
                        balance -= w_amt
                        print(f"Your new balance is: {balance}")
                        break
                    elif w_amt > balance:
                        print("Insufficient funds.")
                        break
                except ValueError:
                    pass
                print("invalid")
        elif opt == "2":
            while True:
                d_val = input("How much amount you want to deposit in your account?\nAmount: ")
                try:
                    d_amt = float(d_val)
                    if d_amt >= 0:
                        balance += d_amt
                        print(f"Your new balance is: {balance}")
                        break
                except ValueError:
                    pass
                print("invalid")
        elif opt == "3":
            print("Thank you for using the system!")
            break
        else:
            print("invalid")

def run_program_two():
    patients = []
    while True:
        print("1. Insert New Patient")
        print("2. Display all Patient")
        print("3. Display pediatric patient")
        print("4. Exit")
        opt = input("Enter option (1-4): ")
        if opt == "1":
            name = input("1. Name of the patient: ")
            admission_date = input("2. Date of admission: ")
            disease = input("3. Disease: ")
            discharge_date = input("4. Date of discharge: ")
            while True:
                age_val = input("Age of the patient: ")
                try:
                    age = int(age_val)
                    if age >= 0:
                        break
                except ValueError:
                    pass
                print("invalid")
            if age < 12:
                p = PediatricPatient(name, admission_date, disease, discharge_date, age)
            else:
                p = Patient(name, admission_date, disease, discharge_date, age)
            patients.append(p)
        elif opt == "2":
            for p in patients:
                p.display()
        elif opt == "3":
            for p in patients:
                if p.age < 12:
                    p.display()
        elif opt == "4":
            break
        else:
            print("invalid")

def run_program_three():
    d = Dean("John Cena", 32000, "English")
    e = Executive("Ronald McDonald", 42000, "Computer Science")
    print(d)
    print(e)

while True:
    prog = input("Select Program (1: Bank, 2: Hospital, 3: Professor/Executive, or 'q' to quit): ")
    if prog == 'q':
        break
    elif prog == "1":
        run_program_one()
    elif prog == "2":
        run_program_two()
    elif prog == "3":
        run_program_three()
    else:
        print("invalid")
