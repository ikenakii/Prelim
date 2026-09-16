def get_valid_score(subject_name):
    while True:
        try:
            score = float(input(f"{subject_name} Score: "))
            if 0 <= score <= 100:
                return score
            else:
                print("Invalid input. Score must be between 0 and 100.")
        except ValueError:
            print("Invalid input. Please enter a valid numerical score.")

def main():
    while True:
        print("\n--- Student Grade Calculator ---")
        
        java_score = get_valid_score("Java Programming")
        c_score = get_valid_score("C Programming")
        db_score = get_valid_score("Database Handling")
        
        average_score = (java_score + c_score + db_score) / 3
        
        if 90 <= average_score <= 100:
            grade = "A"
            rationale = "between 90 and 100"
        elif 80 <= average_score < 90:
            grade = "B"
            rationale = "between 80 and 89"
        elif 75 <= average_score < 80:
            grade = "C"
            rationale = "between 75 and 79"
        else:
            grade = "F"
            rationale = "below 75"
            
        print(f"\nAverage: {average_score:.2f}   |   Grade: {grade} because the average is {rationale}")
        
        while True:
            choice = input("\nDo you want to continue? (YES/NO): ").strip().upper()
            if choice in ["YES", "NO"]:
                break
            print("Invalid choice. Please enter exactly 'YES' or 'NO'.")
            
        if choice == "NO":
            print("Program terminated. Thank you!")
            break

if __name__ == "__main__":
    main()