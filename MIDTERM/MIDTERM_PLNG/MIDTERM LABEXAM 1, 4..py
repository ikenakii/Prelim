class Book:
    def __init__(self, title, author, price):
        self.title = title
        self.author = author
        self.price = price

    def __str__(self):
        return f"Book: {self.title} | Author: {self.author} \nPrice: PHP {self.price:.2f}"


class EBook(Book):
    def __init__(self, title, author, price, file_size_mb):
        super().__init__(title, author, price)
        self.file_size_mb = file_size_mb

    def __str__(self):
        return f"EBook: {self.title} | Author: {self.author} \nPrice: PHP {self.price:.2f} | File size: {self.file_size_mb} MB"


def main():
    books = [
        Book("Python Basics", "Maria Santos", 450.00),
        EBook("Learning OOP", "Ana Cruz", 300.00, 5),
        EBook("Advanced Python", "Juan Dela Cruz", 550.00, 14)
    ]
    
    for book in books:
        print(book)

main()

print("\n\n")


class Student:
    def __init__(self, name, student_id, tuition_fee):
        self.name = name
        self.student_id = student_id
        self.tuition_fee = tuition_fee

    def __str__(self):
        return f"Name: {self.name} | Student ID: {self.student_id}\nTuition fee: PHP {self.tuition_fee:.2f}"


class ScholarStudent(Student):
    def __init__(self, name, student_id, tuition_fee, scholarship_percentage):
        super().__init__(name, student_id, tuition_fee)
        if not (0 <= scholarship_percentage <= 100):
            raise ValueError("Scholarship percentage must be between 0 and 100.")
        self.scholarship_percentage = scholarship_percentage

    def calculate_payable_fee(self):
        return self.tuition_fee - (self.tuition_fee * self.scholarship_percentage / 100)

    def __str__(self):
        payable_fee = self.calculate_payable_fee()
        return (f"Name: {self.name} | Student ID: {self.student_id}\n"
                f"Tuition fee: PHP {self.tuition_fee:.2f}\n"
                f"Scholarship: {self.scholarship_percentage}%\n"
                f"Payable fee: PHP {payable_fee:.2f}")


def main():
    scholar1 = ScholarStudent("Carlo Reyes", "2026-001", 40000.00, 50)
    scholar2 = ScholarStudent("Casimirmir FaeFae", "2026-002", 35000.00, 20)

    print(scholar1)
    print()
    print(scholar2)


main()
