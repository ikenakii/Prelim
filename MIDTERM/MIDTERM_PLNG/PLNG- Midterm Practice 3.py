def program_36():
    from random import randint
    rand = randint(1, 100)
    counter = 0
    while True:
        try:
            num = int(input("Enter values between 1 and 100 (0 exit):"))
            if num == 0:
                print("You canceled the game.")
                break
            elif 1 <= num <= 100:
                counter += 1
                if num < rand:
                    print("Enter a Higher Number.")
                elif num > rand:
                    print("Enter a Lower Number.")
                else:
                    print("Randomly selected number {0}!".format(rand))
                    print("Your guess number {0}".format(counter))
                    break
            else:
                print("invalid")
        except ValueError:
            print("invalid")

def program_45():
    while True:
        number = input("enter a number: ")
        if number.isdigit():
            total = 0
            for digit in number:
                total += int(digit)
            print("the sum of the digits of the number:", total)
            break
        else:
            print("invalid")

def program_46():
    while True:
        number = input("enter an number: ")
        if number.isdigit():
            multiplication = 1
            for digit in number:
                if int(digit) != 0:
                    multiplication *= int(digit)
            print("digits of the number: ", multiplication)
            break
        else:
            print("invalid")

def program_47():
    text = input("enter a name: ")
    for i in range(10):
        print(text)

def program_50():
    total = 0
    while True:
        try:
            num = float(input("enter a number: "))
            if num == 0:
                break
            total += num
        except ValueError:
            print("invalid")
    print("The sum of the numbers: ", total)

while True:
    choice = input("Enter program number (36, 45, 46, 47, 50, or 'q' to quit): ")
    if choice == 'q':
        break
    elif choice == '36':
        program_36()
    elif choice == '45':
        program_45()
    elif choice == '46':
        program_46()
    elif choice == '47':
        program_47()
    elif choice == '50':
        program_50()
    else:
        print("invalid")
