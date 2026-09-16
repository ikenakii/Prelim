while True:
    print("\nARITHMETIC CALCULATOR")
    print("1. Addition          2. Subtraction       3. Multiplication")
    print("4. Division          5. Modulus           6. Increment")
    print("7. Decrement\n")
    
    choice = input("Select an arithmetic operation: ").strip()
    
    if choice not in ["1", "2", "3", "4", "5", "6", "7"]:
        print("Error: Invalid menu choice! Please select a number from 1 to 7.")
        cont = input("\nDo you want to continue? (YES/NO): ").strip().upper()
        if cont == "NO":
            print("Program terminated. Thank you!")
            break
        continue
        
    operation = int(choice)
    
    if operation <= 5:
        x = float(input("Enter the value of x: "))
        y = float(input("Enter the value of y: "))
        print(f"\nVariable Values: x = {x}, y = {y}")
    else:
        x = float(input("Enter the value of x: "))
        print(f"\nVariable Values: x = {x}")
        
    if operation == 1:
        print(f"Addition: x + y = {x + y}")
    elif operation == 2:
        print(f"Subtraction: x - y = {x - y}")
    elif operation == 3:
        print(f"Multiplication: x * y = {x * y}")
    elif operation == 4:
        if y == 0:
            print("Error: Division by zero is not allowed.")
        else:
            print(f"Division: x / y = {x / y}")
    elif operation == 5:
        if y == 0:
            print("Error: Modulus by zero is not allowed.")
        else:
            print(f"Modulus: x % y = {x % y}")
    elif operation == 6:
        print(f"Increment: x + 1 = {x + 1}")
    elif operation == 7:
        print(f"Decrement: x - 1 = {x - 1}")

    cont = input("Do you want to continue? (YES/NO): ").strip().upper()
    if cont == "NO":
        print("Program terminated. Thank you!")
        break
