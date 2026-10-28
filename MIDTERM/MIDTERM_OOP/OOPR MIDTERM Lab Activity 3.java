import java.util.Scanner;

public class LabActivity {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n========================================");
            System.out.println("   OOPR MIDTERM LAB ACTIVITIES (1-31)   ");
            System.out.println("========================================");
            System.out.print("Enter activity number (1-31) or 0 to exit: ");
            while (!scanner.hasNextInt()) {
                scanner.next();
                System.out.print("Invalid input. Enter activity number (1-31) or 0 to exit: ");
            }
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 0:
                    System.out.println("Exiting program. Goodbye!");
                    break;
                case 1: activity1(); break;
                case 2: activity2(); break;
                case 3: activity3(); break;
                case 4: activity4(); break;
                case 5: activity5(); break;
                case 6: activity6(); break;
                case 7: activity7(); break;
                case 8: activity8(); break;
                case 9: activity9(); break;
                case 10: activity10(); break;
                case 11: activity11(); break;
                case 12: activity12(); break;
                case 13: activity13(); break;
                case 14: activity14(); break;
                case 15: activity15(); break;
                case 16: activity16(); break;
                case 17: activity17(); break;
                case 18: activity18(); break;
                case 19: activity19(); break;
                case 20: activity20(); break;
                case 21: activity21(); break;
                case 22: activity22(); break;
                case 23: activity23(); break;
                case 24: activity24(); break;
                case 25: activity25(); break;
                case 26: activity26(); break;
                case 27: activity27(); break;
                case 28: activity28(); break;
                case 29: activity29(); break;
                case 30: activity30(); break;
                case 31: activity31(); break;
                default:
                    System.out.println("Invalid choice! Please select between 1 and 31.");
            }
        } while (choice != 0);
    }

    public static void activity1() {
        char ch;
        while (true) {
            System.out.print("Enter a letter: ");
            String input = scanner.next();
            if (input.length() == 1 && Character.isLetter(input.charAt(0))) {
                ch = input.charAt(0);
                break;
            }
            System.out.println("Invalid input. Please enter a single letter.");
        }
        char lower = Character.toLowerCase(ch);

        System.out.println("--- Solution 1: Ladderized If/Else ---");
        if (lower == 'a' || lower == 'e' || lower == 'i' || lower == 'o' || lower == 'u') {
            System.out.println(ch + " is a VOWEL.");
        } else {
            System.out.println(ch + " is a CONSONANT.");
        }

        System.out.println("--- Solution 2: Switch/Case ---");
        switch (lower) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
                System.out.println(ch + " is a VOWEL.");
                break;
            default:
                System.out.println(ch + " is a CONSONANT.");
        }
    }

    public static void activity2() {
        int m, d, y;
        while (true) {
            System.out.print("Enter month (1-12): ");
            while (!scanner.hasNextInt()) { scanner.next(); System.out.print("Enter month (1-12): "); }
            m = scanner.nextInt();
            if (m >= 1 && m <= 12) break;
            System.out.println("Invalid month. Try again.");
        }
        while (true) {
            System.out.print("Enter day (1-31): ");
            while (!scanner.hasNextInt()) { scanner.next(); System.out.print("Enter day (1-31): "); }
            d = scanner.nextInt();
            if (d >= 1 && d <= 31) break;
            System.out.println("Invalid day. Try again.");
        }
        while (true) {
            System.out.print("Enter year: ");
            while (!scanner.hasNextInt()) { scanner.next(); System.out.print("Enter year: "); }
            y = scanner.nextInt();
            if (y > 0) break;
            System.out.println("Invalid year. Try again.");
        }

        String monthName = "";
        System.out.println("--- Solution 1: Ladderized If/Else ---");
        if (m == 1) monthName = "January";
        else if (m == 2) monthName = "February";
        else if (m == 3) monthName = "March";
        else if (m == 4) monthName = "April";
        else if (m == 5) monthName = "May";
        else if (m == 6) monthName = "June";
        else if (m == 7) monthName = "July";
        else if (m == 8) monthName = "August";
        else if (m == 9) monthName = "September";
        else if (m == 10) monthName = "October";
        else if (m == 11) monthName = "November";
        else monthName = "December";

        System.out.println(monthName + " " + d + ", " + y);

        System.out.println("--- Solution 2: Switch/Case ---");
        switch (m) {
            case 1: monthName = "January"; break;
            case 2: monthName = "February"; break;
            case 3: monthName = "March"; break;
            case 4: monthName = "April"; break;
            case 5: monthName = "May"; break;
            case 6: monthName = "June"; break;
            case 7: monthName = "July"; break;
            case 8: monthName = "August"; break;
            case 9: monthName = "September"; break;
            case 10: monthName = "October"; break;
            case 11: monthName = "November"; break;
            case 12: monthName = "December"; break;
        }
        System.out.println(monthName + " " + d + ", " + y);
    }

    public static void activity3() {
        double temp;
        while (true) {
            System.out.print("Enter temperature value: ");
            if (scanner.hasNextDouble()) {
                temp = scanner.nextDouble();
                break;
            }
            scanner.next();
            System.out.println("Invalid input. Try again.");
        }
        if (temp < 0) {
            System.out.println("ICE");
        } else if (temp <= 100) {
            System.out.println("WATER");
        } else {
            System.out.println("STEAM");
        }
    }

    public static void activity4() {
        double speed, length;
        while (true) {
            System.out.print("Enter observed speed (km/h): ");
            if (scanner.hasNextDouble()) {
                speed = scanner.nextDouble();
                if (speed >= 0) break;
            } else {
                scanner.next();
            }
            System.out.println("Invalid speed. Try again.");
        }
        while (true) {
            System.out.print("Enter estimated length (meters): ");
            if (scanner.hasNextDouble()) {
                length = scanner.nextDouble();
                if (length >= 0) break;
            } else {
                scanner.next();
            }
            System.out.println("Invalid length. Try again.");
        }

        if (speed > 1100 && length > 52) {
            System.out.println("civilian");
        } else if (speed == 500 && length == 20) {
            System.out.println("military");
        } else {
            System.out.println("It's a bird");
        }
    }

    public static void activity5() {
        char id;
        while (true) {
            System.out.print("Enter Class ID (B or b, C or c, D or d, F or f): ");
            String input = scanner.next();
            if (input.length() == 1) {
                char c = input.charAt(0);
                if (c == 'B' || c == 'b' || c == 'C' || c == 'c' || c == 'D' || c == 'd' || c == 'F' || c == 'f') {
                    id = c;
                    break;
                }
            }
            System.out.println("Invalid Class ID. Try again.");
        }

        System.out.println("--- Solution 1: Ladderized If/Else ---");
        if (id == 'B' || id == 'b') System.out.println("Battleship");
        else if (id == 'C' || id == 'c') System.out.println("Cruiser");
        else if (id == 'D' || id == 'd') System.out.println("Destroyer");
        else if (id == 'F' || id == 'f') System.out.println("Frigate");

        System.out.println("--- Solution 2: Switch/Case ---");
        switch (Character.toLowerCase(id)) {
            case 'b': System.out.println("Battleship"); break;
            case 'c': System.out.println("Cruiser"); break;
            case 'd': System.out.println("Destroyer"); break;
            case 'f': System.out.println("Frigate"); break;
        }
    }

    public static void activity6() {
        double n;
        while (true) {
            System.out.print("Enter Richter scale number (n): ");
            if (scanner.hasNextDouble()) {
                n = scanner.nextDouble();
                break;
            }
            scanner.next();
            System.out.println("Invalid input. Try again.");
        }
        if (n <= 5.0) {
            System.out.println("Little or no damage");
        } else if (n < 5.5) {
            System.out.println("Some damage");
        } else if (n < 6.5) {
            System.out.println("Serious damage");
        } else if (n < 7.5) {
            System.out.println("Disaster");
        } else {
            System.out.println("Catastrophe");
        }
    }

    public static void activity7() {
        int num;
        while (true) {
            System.out.print("Enter a number (max 3000): ");
            if (scanner.hasNextInt()) {
                num = scanner.nextInt();
                if (num >= 0 && num <= 3000) break;
            } else {
                scanner.next();
            }
            System.out.println("Invalid input. Maximum input number is 3000.");
        }
        if (num == 0) {
            System.out.println("zero");
            return;
        }
        String result = "";
        if (num == 3000) {
            result = "three thousand";
        } else {
            int thousands = num / 1000;
            int remainder = num % 1000;
            int hundreds = remainder / 100;
            int tensUnits = remainder % 100;

            if (thousands > 0) {
                result += getDigitWord(thousands) + " thousand ";
            }
            if (hundreds > 0) {
                result += getDigitWord(hundreds) + " hundred ";
            }
            if (tensUnits > 0) {
                if (tensUnits < 20) {
                    result += getBelow20Word(tensUnits);
                } else {
                    int t = tensUnits / 10;
                    int u = tensUnits % 10;
                    result += getTensWord(t) + " ";
                    if (u > 0) result += getDigitWord(u);
                }
            }
        }
        System.out.println(result.trim());
    }

    private static String getDigitWord(int n) {
        switch (n) {
            case 1: return "one";
            case 2: return "two";
            case 3: return "three";
            case 4: return "four";
            case 5: return "five";
            case 6: return "six";
            case 7: return "seven";
            case 8: return "eight";
            case 9: return "nine";
            default: return "";
        }
    }

    private static String getBelow20Word(int n) {
        switch (n) {
            case 10: return "ten";
            case 11: return "eleven";
            case 12: return "twelve";
            case 13: return "thirteen";
            case 14: return "fourteen";
            case 15: return "fifteen";
            case 16: return "sixteen";
            case 17: return "seventeen";
            case 18: return "eighteen";
            case 19: return "nineteen";
            default: return "";
        }
    }

    private static String getTensWord(int n) {
        switch (n) {
            case 2: return "twenty";
            case 3: return "thirty";
            case 4: return "forty";
            case 5: return "fifty";
            case 6: return "sixty";
            case 7: return "seventy";
            case 8: return "eighty";
            case 9: return "ninety";
            default: return "";
        }
    }

    public static void activity8() {
        int num;
        while (true) {
            System.out.print("Enter a number (max 3000): ");
            if (scanner.hasNextInt()) {
                num = scanner.nextInt();
                if (num >= 1 && num <= 3000) break;
            } else {
                scanner.next();
            }
            System.out.println("Invalid input. Maximum input number is 3000.");
        }
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] numerals = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder roman = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                num -= values[i];
                roman.append(numerals[i]);
            }
        }
        System.out.println(roman.toString());
    }

    public static void activity9() {
        double tuition;
        while (true) {
            System.out.print("Enter tuition fee: ");
            if (scanner.hasNextDouble()) {
                tuition = scanner.nextDouble();
                if (tuition >= 0) break;
            } else {
                scanner.next();
            }
            System.out.println("Invalid tuition fee. Try again.");
        }
        int mode;
        while (true) {
            System.out.println("(Press 1 for Cash, 2 for Two-Installment, 3 for Three-Installment)");
            System.out.print("Enter mode of payment: ");
            if (scanner.hasNextInt()) {
                mode = scanner.nextInt();
                if (mode >= 1 && mode <= 3) break;
            } else {
                scanner.next();
            }
            System.out.println("Invalid mode of payment. Please choose 1, 2, or 3.");
        }

        double total = tuition;
        if (mode == 1) {
            total = tuition - (tuition * 0.10);
        } else if (mode == 2) {
            total = tuition - (tuition * 0.05);
        } else if (mode == 3) {
            total = tuition + (tuition * 0.10);
        }
        System.out.println("Your total tuition fee is: " + total);
    }

    public static void activity10() {
        int grade;
        while (true) {
            System.out.print("Enter input grade in percentile form: ");
            if (scanner.hasNextInt()) {
                grade = scanner.nextInt();
                if (grade >= 0 && grade <= 100) break;
            } else {
                scanner.next();
            }
            System.out.println("Invalid percentile grade. Try again.");
        }
        if (grade >= 98 && grade <= 100) System.out.println("1.00");
        else if (grade >= 95 && grade <= 97) System.out.println("1.25");
        else if (grade >= 92 && grade <= 94) System.out.println("1.50");
        else if (grade >= 89 && grade <= 91) System.out.println("1.75");
        else if (grade >= 85 && grade <= 88) System.out.println("2.00");
        else if (grade >= 82 && grade <= 84) System.out.println("2.25");
        else if (grade >= 80 && grade <= 81) System.out.println("2.50");
        else if (grade >= 77 && grade <= 79) System.out.println("2.75");
        else if (grade >= 75 && grade <= 76) System.out.println("3.00");
        else System.out.println("\"Out-of-Range\"");
    }

    public static void activity11() {
        System.out.println("Sequence nos. Squared");
        System.out.println("--- For Loop ---");
        for (int i = 1; i <= 5; i++) {
            System.out.println(i + "\t" + (i * i));
        }
        System.out.println("--- While Loop ---");
        int i = 1;
        while (i <= 5) {
            System.out.println(i + "\t" + (i * i));
            i++;
        }
        System.out.println("--- Do-While Loop ---");
        i = 1;
        do {
            System.out.println(i + "\t" + (i * i));
            i++;
        } while (i <= 5);
    }

    public static void activity12() {
        System.out.println("--- For Loop ---");
        for (int i = 1; i <= 5; i++) {
            System.out.print(i + " " + (6 - i) + " ");
        }
        System.out.println();

        System.out.println("--- While Loop ---");
        int i = 1;
        while (i <= 5) {
            System.out.print(i + " " + (6 - i) + " ");
            i++;
        }
        System.out.println();

        System.out.println("--- Do-While Loop ---");
        i = 1;
        do {
            System.out.print(i + " " + (6 - i) + " ");
            i++;
        } while (i <= 5);
        System.out.println();
    }

    public static void activity13() {
        System.out.println("--- For Loop ---");
        for (int i = 5; i >= 1; i--) {
            System.out.print(i + " " + (6 - i) + " ");
        }
        System.out.println();

        System.out.println("--- While Loop ---");
        int i = 5;
        while (i >= 1) {
            System.out.print(i + " " + (6 - i) + " ");
            i--;
        }
        System.out.println();

        System.out.println("--- Do-While Loop ---");
        i = 5;
        do {
            System.out.print(i + " " + (6 - i) + " ");
            i--;
        } while (i >= 1);
        System.out.println();
    }

    public static void activity14() {
        int n;
        while (true) {
            System.out.print("Enter a no.: ");
            if (scanner.hasNextInt()) {
                n = scanner.nextInt();
                if (n >= 0) break;
            } else {
                scanner.next();
            }
            System.out.println("Invalid input. Try again.");
        }
        
        long fact1 = 1;
        for (int i = 1; i <= n; i++) {
            fact1 *= i;
        }
        System.out.println("For Loop - Factorial value: " + fact1);

        long fact2 = 1;
        int i = 1;
        while (i <= n) {
            fact2 *= i;
            i++;
        }
        System.out.println("While Loop - Factorial value: " + fact2);

        long fact3 = 1;
        i = 1;
        if (n > 0) {
            do {
                fact3 *= i;
                i++;
            } while (i <= n);
        }
        System.out.println("Do-While Loop - Factorial value: " + fact3);
    }

    public static void activity15() {
        int n;
        while (true) {
            System.out.print("Enter a no.: ");
            if (scanner.hasNextInt()) {
                n = scanner.nextInt();
                if (n > 0) break;
            } else {
                scanner.next();
            }
            System.out.println("Invalid input. Try again.");
        }

        System.out.print("For Loop Fibonacci: ");
        int a = 1, b = 1;
        for (int i = 1; i <= n; i++) {
            System.out.print(a + " ");
            int next = a + b;
            a = b;
            b = next;
        }
        System.out.println();
    }

    public static void activity16() {
        int base, exp;
        while (true) {
            System.out.print("Enter base no.: ");
            if (scanner.hasNextInt()) {
                base = scanner.nextInt();
                break;
            }
            scanner.next();
            System.out.println("Invalid input. Try again.");
        }
        while (true) {
            System.out.print("Enter exponent no.: ");
            if (scanner.hasNextInt()) {
                exp = scanner.nextInt();
                if (exp >= 0) break;
            } else {
                scanner.next();
            }
            System.out.println("Invalid input. Try again.");
        }

        long result = 1;
        for (int i = 1; i <= exp; i++) {
            result *= base;
        }
        System.out.println("Power value: " + result);
    }

    public static void activity17() {
        int n;
        while (true) {
            System.out.print("Enter number n: ");
            if (scanner.hasNextInt()) {
                n = scanner.nextInt();
                if (n > 0) break;
            } else {
                scanner.next();
            }
            System.out.println("Invalid input. Try again.");
        }
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += (i * i);
        }
        System.out.println("Sum of squares: " + sum);
    }

    public static void activity18() {
        int n;
        while (true) {
            System.out.print("Enter number n: ");
            if (scanner.hasNextInt()) {
                n = scanner.nextInt();
                if (n > 0) break;
            } else {
                scanner.next();
            }
            System.out.println("Invalid input. Try again.");
        }
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        System.out.println("Sum of sequence: " + sum);
    }

    public static void activity19() {
        int n;
        while (true) {
            System.out.print("Enter a number: ");
            if (scanner.hasNextInt()) {
                n = scanner.nextInt();
                break;
            }
            scanner.next();
            System.out.println("Invalid input. Try again.");
        }
        int rev = 0;
        for (int temp = n; temp != 0; temp /= 10) {
            int digit = temp % 10;
            rev = rev * 10 + digit;
        }
        System.out.println("Reverse number: " + rev);
    }

    public static void activity20() {
        int n;
        while (true) {
            System.out.print("Enter number n: ");
            if (scanner.hasNextInt()) {
                n = scanner.nextInt();
                if (n > 0) break;
            } else {
                scanner.next();
            }
            System.out.println("Invalid input. Try again.");
        }
        long sum = 0;
        for (int i = 1; i <= n; i++) {
            long p = 1;
            for (int j = 1; j <= i; j++) {
                p *= i;
            }
            sum += p;
        }
        System.out.println("Sum of powers: " + sum);
    }

    public static void activity21() {
        int rows;
        while (true) {
            System.out.print("Number of rows: ");
            if (scanner.hasNextInt()) {
                rows = scanner.nextInt();
                if (rows > 0) break;
            } else {
                scanner.next();
            }
            System.out.println("Invalid input. Try again.");
        }
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void activity22() {
        int rows;
        while (true) {
            System.out.print("Number of rows: ");
            if (scanner.hasNextInt()) {
                rows = scanner.nextInt();
                if (rows > 0) break;
            } else {
                scanner.next();
            }
            System.out.println("Invalid input. Try again.");
        }
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print((i + j) % 2 == 0 ? "1" : "0");
            }
            System.out.println();
        }
    }

    public static void activity23() {
        int rows;
        while (true) {
            System.out.print("Number of rows: ");
            if (scanner.hasNextInt()) {
                rows = scanner.nextInt();
                if (rows > 0) break;
            } else {
                scanner.next();
            }
            System.out.println("Invalid input. Try again.");
        }
        for (int i = 1; i <= rows; i++) {
            for (int j = i; j < rows; j++) System.out.print(" ");
            for (int j = 1; j <= (2 * i - 1); j++) System.out.print("*");
            System.out.println();
        }
    }

    public static void activity24() {
        int rows;
        while (true) {
            System.out.print("Number of rows: ");
            if (scanner.hasNextInt()) {
                rows = scanner.nextInt();
                if (rows > 0) break;
            } else {
                scanner.next();
            }
            System.out.println("Invalid input. Try again.");
        }
        for (int i = 1; i <= rows; i++) {
            for (int j = i; j < rows; j++) System.out.print(" ");
            for (int j = 1; j <= i; j++) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public static void activity25() {
        int rows;
        while (true) {
            System.out.print("Number of rows: ");
            if (scanner.hasNextInt()) {
                rows = scanner.nextInt();
                if (rows > 0) break;
            } else {
                scanner.next();
            }
            System.out.println("Invalid input. Try again.");
        }
        for (int i = 1; i <= rows; i++) {
            for (int j = i; j < rows; j++) System.out.print(" ");
            for (int j = 1; j <= i; j++) System.out.print("* ");
            System.out.println();
        }
    }

    public static void activity26() {
        int rows;
        while (true) {
            System.out.print("Number of rows: ");
            if (scanner.hasNextInt()) {
                rows = scanner.nextInt();
                if (rows > 0) break;
            } else {
                scanner.next();
            }
            System.out.println("Invalid input. Try again.");
        }
        int num = 1;
        for (int i = 1; i <= rows; i++) {
            for (int j = i; j < rows; j++) System.out.print(" ");
            for (int j = 1; j <= i; j++) {
                System.out.print(num++ + " ");
            }
            System.out.println();
        }
    }

    public static void activity27() {
        int rows;
        while (true) {
            System.out.print("Number of rows: ");
            if (scanner.hasNextInt()) {
                rows = scanner.nextInt();
                if (rows > 0) break;
            } else {
                scanner.next();
            }
            System.out.println("Invalid input. Try again.");
        }
        int num = 1;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(num++ + " ");
            }
            System.out.println();
        }
    }

    public static void activity28() {
        int rows;
        while (true) {
            System.out.print("Number of rows: ");
            if (scanner.hasNextInt()) {
                rows = scanner.nextInt();
                if (rows > 0) break;
            } else {
                scanner.next();
            }
            System.out.println("Invalid input. Try again.");
        }
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public static void activity29() {
        int rows;
        while (true) {
            System.out.print("Number of rows: ");
            if (scanner.hasNextInt()) {
                rows = scanner.nextInt();
                if (rows > 0) break;
            } else {
                scanner.next();
            }
            System.out.println("Invalid input. Try again.");
        }
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    public static void activity30() {
        int rows;
        while (true) {
            System.out.print("Number of rows (half diamond): ");
            if (scanner.hasNextInt()) {
                rows = scanner.nextInt();
                if (rows > 0) break;
            } else {
                scanner.next();
            }
            System.out.println("Invalid input. Try again.");
        }
        for (int i = 1; i <= rows; i++) {
            for (int j = i; j < rows; j++) System.out.print(" ");
            for (int j = 1; j <= (2 * i - 1); j++) System.out.print("*");
            System.out.println();
        }
        for (int i = rows - 1; i >= 1; i--) {
            for (int j = rows; j > i; j--) System.out.print(" ");
            for (int j = 1; j <= (2 * i - 1); j++) System.out.print("*");
            System.out.println();
        }
    }

    public static void activity31() {
        int rows;
        while (true) {
            System.out.print("Number of rows: ");
            if (scanner.hasNextInt()) {
                rows = scanner.nextInt();
                if (rows > 0) break;
            } else {
                scanner.next();
            }
            System.out.println("Invalid input. Try again.");
        }
        for (int i = 1; i <= rows; i++) {
            for (int j = i; j < rows; j++) System.out.print("  ");
            for (int j = 1; j <= i; j++) System.out.print(j + " ");
            for (int j = i - 1; j >= 1; j--) System.out.print(j + " ");
            System.out.println();
        }
    }
}
