import java.util.Scanner;

public class MachineProblemSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        do {
            System.out.println("\n========================================");
            System.out.println("   MACHINE PROBLEM SYSTEM (ACTIVITIES 18-27)");
            System.out.println("========================================");
            System.out.println("[18] Smart Payslip Generator");
            System.out.println("[19] Student Tuition Billing System");
            System.out.println("[20] Customer Purchase Order Receipt");
            System.out.println("[21] Ticketing System");
            System.out.println("[22] Reservation and Billing System");
            System.out.println("[23] Car Rental System (CRS)");
            System.out.println("[24] Restaurant Ordering System (ROS)");
            System.out.println("[25] Flower Reservation System");
            System.out.println("[26] KMART Korean Noodles Billing");
            System.out.println("[27] Parking Reservation System");
            System.out.println("[0]  Exit");
            
            choice = getValidInt(scanner, "piliin ang numero ng programa (0-27): ");

            switch (choice) {
                case 18:
                    runPayslipGenerator(scanner);
                    break;
                case 19:
                    runTuitionSystem(scanner);
                    break;
                case 20:
                    runPurchaseOrder(scanner);
                    break;
                case 21:
                    runTicketingSystem(scanner);
                    break;
                case 22:
                    runReservationSystem(scanner);
                    break;
                case 23:
                    runCarRentalSystem(scanner);
                    break;
                case 24:
                    runRestaurantSystem(scanner);
                    break;
                case 25:
                    runFlowerSystem(scanner);
                    break;
                case 26:
                    runKmartSystem(scanner);
                    break;
                case 27:
                    runParkingSystem(scanner);
                    break;
                case 0:
                    System.out.println("salamat sa paggamit ng sistema!");
                    break;
                default:
                    System.out.println("invalid ang pinili mo, mangyaring subukan muli.");
            }
        } while (choice != 0);

        scanner.close();
    }

    // validator para sa integer inputs
    public static int getValidInt(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                int val = scanner.nextInt();
                scanner.nextLine();
                return val;
            } else {
                System.out.println("invalid");
                scanner.next();
            }
        }
    }

    // validator para sa year level na dapat 1 hanggang 4 lamang
    public static int getValidYearLevel(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                int val = scanner.nextInt();
                scanner.nextLine();
                if (val >= 1 && val <= 4) {
                    return val;
                } else {
                    System.out.println("invalid");
                }
            } else {
                System.out.println("invalid");
                scanner.next();
            }
        }
    }

    // validator para sa double inputs
    public static double getValidDouble(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextDouble()) {
                double val = scanner.nextDouble();
                scanner.nextLine();
                return val;
            } else {
                System.out.println("invalid");
                scanner.next();
            }
        }
    }

    // validator para sa pangkalahatang text inputs
    public static String getValidString(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String val = scanner.nextLine().trim();
            if (!val.isEmpty()) {
                return val;
            } else {
                System.out.println("invalid");
            }
        }
    }

    // validator para sa mga pangalan na titik at espasyo lang ang pwede
    public static String getValidName(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String val = scanner.nextLine().trim();
            if (!val.isEmpty() && val.matches("[a-zA-Z ]+")) {
                return val;
            } else {
                System.out.println("invalid");
            }
        }
    }

    // validator para sa course format na tulad ng "BSCS 2-Y1-1"
    public static String getValidCourse(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String val = scanner.nextLine().trim();
            if (val.matches("^[A-Za-z]+\\s+\\d+-[A-Za-z0-9-]+$")) {
                return val;
            } else {
                System.out.println("invalid");
            }
        }
    }

    // programming 18: smart payslip generator
    public static void runPayslipGenerator(Scanner sc) {
        System.out.println("\n--- PROGRAMMING 18: SMART PAYSLIP ---");
        String name = getValidName(sc, "Employee Name: ");
        String id = getValidString(sc, "Employee ID: ");
        String dept = getValidString(sc, "Department: ");
        double salary = getValidDouble(sc, "Basic Monthly Salary: ");
        
        String startDate = getValidString(sc, "Start Date (YYYY-MM-DD): ");
        String endDate = getValidString(sc, "End Date (YYYY-MM-DD): ");
        String payoutDate = getValidString(sc, "Payout Date (YYYY-MM-DD): ");

        double regHours = getValidDouble(sc, "Total Regular Hours Worked: ");
        double otHours = getValidDouble(sc, "Overtime Hours Worked: ");
        int absentDays = getValidInt(sc, "Number of Absent Days: ");

        double rice = getValidDouble(sc, "Rice Allowance: ");
        double transpo = getValidDouble(sc, "Transportation Allowance: ");
        double comm = getValidDouble(sc, "Communication Allowance: ");

        double sss = getValidDouble(sc, "SSS Contribution: ");
        double philHealth = getValidDouble(sc, "PhilHealth Contribution: ");
        double pagIbig = getValidDouble(sc, "PAG-IBIG Contribution: ");
        double tax = getValidDouble(sc, "Withholding Tax: ");
        double otherDed = getValidDouble(sc, "Other Deductions: ");

        // computation
        double hourlyRate = salary / 160.0;
        double dailyRate = salary / 20.0;
        double regularPay = regHours * hourlyRate;
        double overtimePay = otHours * (hourlyRate * 1.25);
        double absenceDeduction = absentDays * dailyRate;
        double totalAllowances = rice + transpo + comm;
        double grossPay = regularPay + overtimePay + totalAllowances;
        double totalDeductions = sss + philHealth + pagIbig + tax + otherDed + absenceDeduction;
        double netPay = grossPay - totalDeductions;

        // output
        System.out.println("\n*** Smart Employee Payslip ***");
        System.out.println("Employee Details");
        System.out.println("• Name: " + name);
        System.out.println("• Employee ID: " + id);
        System.out.println("• Department: " + dept);
        System.out.println("Payroll Summary");
        System.out.println("• Pay Period: " + startDate + " to " + endDate);
        System.out.println("• Payout Date: " + payoutDate);
        System.out.println("Earnings");
        System.out.printf("• Regular Pay: %.2f\n", regularPay);
        System.out.printf("• Overtime Pay: %.2f\n", overtimePay);
        System.out.printf("• Total Allowances: %.2f\n", totalAllowances);
        System.out.printf("• Gross Pay: %.2f\n", grossPay);
        System.out.println("Allowances Breakdown");
        System.out.printf("  - Rice Allowance: %.2f\n", rice);
        System.out.printf("  - Transportation Allowance: %.2f\n", transpo);
        System.out.printf("  - Communication Allowance: %.2f\n", comm);
        System.out.println("Deductions");
        System.out.printf("  - SSS: %.2f\n", sss);
        System.out.printf("  - PhilHealth: %.2f\n", philHealth);
        System.out.printf("  - PAG-IBIG: %.2f\n", pagIbig);
        System.out.printf("  - Withholding Tax: %.2f\n", tax);
        System.out.printf("  - Absence Deduction: %.2f\n", absenceDeduction);
        System.out.printf("  - Other Deductions: %.2f\n", otherDed);
        System.out.printf("• Total Deductions: %.2f\n", totalDeductions);
        System.out.printf("• Net Pay: %.2f\n", netPay);
    }

    // programming 19: student tuition billing system
    public static void runTuitionSystem(Scanner sc) {
        System.out.println("\n--- PROGRAMMING 19: TUITION BILLING SYSTEM ---");
        String name = getValidName(sc, "Student Name: ");
        int id = getValidInt(sc, "Student ID (Integer): ");
        String course = getValidCourse(sc, "Course/Program (e.g., BSCS 2-Y1-1): ");
        int year = getValidYearLevel(sc, "Year Level (1-4): ");

        int units = getValidInt(sc, "Number of Units Enrolled: ");
        double feePerUnit = getValidDouble(sc, "Tuition Fee per Unit: ");
        double miscFee = getValidDouble(sc, "Miscellaneous Fee: ");
        double labFee = getValidDouble(sc, "Laboratory Fee: ");
        double libFee = getValidDouble(sc, "Library Fee: ");
        double otherFee = getValidDouble(sc, "Other Fees: ");
        double downpayment = getValidDouble(sc, "Down Payment: ");
        double scholarship = getValidDouble(sc, "Scholarship Discount: ");

        // computation
        double tuitionTotal = units * feePerUnit;
        double totalAddFees = labFee + libFee + otherFee;
        double grossTotal = tuitionTotal + miscFee + totalAddFees;
        double netTotal = grossTotal - scholarship;
        double balance = netTotal - downpayment;

        // output
        System.out.println("\n*** STUDENT TUITION BILLING SYSTEM ***");
        System.out.println("Student Details");
        System.out.println("• Name: " + name);
        System.out.println("• Student ID: " + id);
        System.out.println("• Course: " + course);
        System.out.println("• Year Level: " + year);
        System.out.println("Enrollment Summary");
        System.out.println("• Units Enrolled: " + units);
        System.out.printf("• Tuition per Unit: %.2f\n", feePerUnit);
        System.out.printf("• Tuition Fee Total: %.2f\n", tuitionTotal);
        System.out.println("Fees Breakdown");
        System.out.printf("  - Miscellaneous Fee: %.2f\n", miscFee);
        System.out.printf("  - Laboratory Fee: %.2f\n", labFee);
        System.out.printf("  - Library Fee: %.2f\n", libFee);
        System.out.printf("  - Other Fees: %.2f\n", otherFee);
        System.out.printf("• Gross Total Fee: %.2f\n", grossTotal);
        System.out.println("Payment Summary");
        System.out.printf("• Scholarship Discount: %.2f\n", scholarship);
        System.out.printf("• Net Total Fee: %.2f\n", netTotal);
        System.out.printf("• Down Payment: %.2f\n", downpayment);
        System.out.printf("• Remaining Balance: %.2f\n", balance);
    }

    // programming 20: customer purchase order receipt
    public static void runPurchaseOrder(Scanner sc) {
        System.out.println("\n--- PROGRAMMING 20: PURCHASE ORDER RECEIPT ---");
        String name = getValidName(sc, "Customer Name: ");
        String id = getValidString(sc, "Customer ID: ");

        String[] itemNames = new String[3];
        int[] itemQtys = new int[3];
        double[] itemPrices = new double[3];
        double subtotal = 0;

        for (int i = 0; i < 3; i++) {
            System.out.println("Item " + (i + 1) + ":");
            itemNames[i] = getValidString(sc, "  Item Name: ");
            itemQtys[i] = getValidInt(sc, "  Quantity: ");
            itemPrices[i] = getValidDouble(sc, "  Price per Item: ");
            subtotal += (itemQtys[i] * itemPrices[i]);
        }

        double discountPercent = getValidDouble(sc, "Discount (%): ");
        double amountTendered = getValidDouble(sc, "Amount Tendered: ");

        // computation
        double discountAmount = subtotal * (discountPercent / 100.0);
        double totalDue = subtotal - discountAmount;
        double change = amountTendered - totalDue;

        // output
        System.out.println("\n******** CUSTOMER RECEIPT ********");
        System.out.println("Customer Details");
        System.out.println("• Name: " + name);
        System.out.println("• Customer ID: " + id);
        System.out.println("Purchased Items");
        System.out.printf("%-15s %-8s %-10s %-10s\n", "Item Name", "Qty", "Price", "Total");
        for (int i = 0; i < 3; i++) {
            double itemTotal = itemQtys[i] * itemPrices[i];
            System.out.printf("%-15s %-8d %-10.2f %-10.2f\n", itemNames[i], itemQtys[i], itemPrices[i], itemTotal);
        }
        System.out.println("Payment Summary");
        System.out.printf("• Subtotal: %.2f\n", subtotal);
        System.out.printf("• Discount (%%): %.1f%%\n", discountPercent);
        System.out.printf("• Discount Amount: %.2f\n", discountAmount);
        System.out.printf("• Total Amount Due: %.2f\n", totalDue);
        System.out.printf("• Amount Tendered: %.2f\n", amountTendered);
        System.out.printf("• Change: %.2f\n", change);
    }

    // programming 21: ticketing system
    public static void runTicketingSystem(Scanner sc) {
        System.out.println("\n--- PROGRAMMING 21: TICKETING SYSTEM ---");
        String name = getValidName(sc, "Customer Name: ");
        String id = getValidString(sc, "Customer ID: ");
        String event = getValidString(sc, "Event Name: ");
        String type = getValidString(sc, "Ticket Type (Regular/VIP): ");
        double price = getValidDouble(sc, "Ticket Price: ");
        int qty = getValidInt(sc, "Number of Tickets: ");
        double discountPercent = getValidDouble(sc, "Discount (%): ");
        double tendered = getValidDouble(sc, "Amount Tendered: ");

        // computation
        double totalCost = price * qty;
        double discountAmt = totalCost * (discountPercent / 100.0);
        double finalDue = totalCost - discountAmt;
        double change = tendered - finalDue;

        // output
        System.out.println("\n******** EVENT TICKET ********");
        System.out.println("Customer Details");
        System.out.println("• Name: " + name);
        System.out.println("• Customer ID: " + id);
        System.out.println("Ticket Information");
        System.out.println("• Event Name: " + event);
        System.out.println("• Ticket Type: " + type);
        System.out.printf("• Ticket Price: %.2f\n", price);
        System.out.println("• Number of Tickets: " + qty);
        System.out.printf("• Total Ticket Cost: %.2f\n", totalCost);
        System.out.println("Payment Summary");
        System.out.printf("• Discount (%%): %.1f%%\n", discountPercent);
        System.out.printf("• Discount Amount: %.2f\n", discountAmt);
        System.out.printf("• Final Amount Due: %.2f\n", finalDue);
        System.out.printf("• Amount Tendered: %.2f\n", tendered);
        System.out.printf("• Change: %.2f\n", change);
    }

    // programming 22: reservation and billing system
    public static void runReservationSystem(Scanner sc) {
        System.out.println("\n--- PROGRAMMING 22: RESERVATION BILLING ---");
        String name = getValidName(sc, "Customer Name: ");
        String id = getValidString(sc, "Customer ID: ");
        String resType = getValidString(sc, "Reservation Type (Room/Cottage/Table): ");
        double duration = getValidDouble(sc, "Number of Days/Hours Reserved: ");
        double rate = getValidDouble(sc, "Rate per Day/Hour: ");
        double food = getValidDouble(sc, "Food Charges: ");
        double service = getValidDouble(sc, "Service Charges: ");
        double other = getValidDouble(sc, "Other Charges: ");
        double discountPercent = getValidDouble(sc, "Discount (%): ");
        double downpayment = getValidDouble(sc, "Down Payment: ");

        // computation
        double resCost = duration * rate;
        double totalAddCharges = food + service + other;
        double subtotal = resCost + totalAddCharges;
        double discountAmt = subtotal * (discountPercent / 100.0);
        double totalBill = subtotal - discountAmt;
        double balance = totalBill - downpayment;

        // output
        System.out.println("\n******** RESERVATION BILLING ********");
        System.out.println("Customer Details");
        System.out.println("• Name: " + name);
        System.out.println("• Customer ID: " + id);
        System.out.println("Reservation Details");
        System.out.println("• Reservation Type: " + resType);
        System.out.println("• Duration: " + duration);
        System.out.printf("• Rate: %.2f\n", rate);
        System.out.printf("• Reservation Cost: %.2f\n", resCost);
        System.out.println("Charges Breakdown");
        System.out.printf("  - Food Charges: %.2f\n", food);
        System.out.printf("  - Service Charges: %.2f\n", service);
        System.out.printf("  - Other Charges: %.2f\n", other);
        System.out.printf("• Subtotal: %.2f\n", subtotal);
        System.out.println("Payment Summary");
        System.out.printf("• Discount (%%): %.1f%%\n", discountPercent);
        System.out.printf("• Discount Amount: %.2f\n", discountAmt);
        System.out.printf("• Total Bill: %.2f\n", totalBill);
        System.out.printf("• Down Payment: %.2f\n", downpayment);
        System.out.printf("• Remaining Balance: %.2f\n", balance);
    }

    // programming 23: car rental system (crs)
    public static void runCarRentalSystem(Scanner sc) {
        System.out.println("\n--- PROGRAMMING 23: CAR RENTAL SYSTEM ---");
        String name = getValidName(sc, "Customer Name: ");
        String id = getValidString(sc, "Customer ID: ");
        String license = getValidString(sc, "Driver's License Number: ");
        String vType = getValidString(sc, "Vehicle Type (Sedan/SUV/Van): ");
        String vModel = getValidString(sc, "Vehicle Model: ");
        double ratePerDay = getValidDouble(sc, "Rental Rate per Day: ");
        int days = getValidInt(sc, "Number of Rental Days: ");
        String pickup = getValidString(sc, "Pickup Date (YYYY-MM-DD): ");
        String returnDate = getValidString(sc, "Return Date (YYYY-MM-DD): ");
        double insurance = getValidDouble(sc, "Insurance Fee: ");
        double fuel = getValidDouble(sc, "Fuel Charge: ");
        double other = getValidDouble(sc, "Other Charges: ");
        double discountPercent = getValidDouble(sc, "Discount (%): ");
        double amountPaid = getValidDouble(sc, "Amount Paid: ");

        // computation
        double rentalCost = ratePerDay * days;
        double totalAdd = insurance + fuel + other;
        double subtotal = rentalCost + totalAdd;
        double discountAmt = subtotal * (discountPercent / 100.0);
        double totalDue = subtotal - discountAmt;
        double change = 0;
        double remaining = 0;

        if (amountPaid >= totalDue) {
            change = amountPaid - totalDue;
        } else {
            remaining = totalDue - amountPaid;
        }

        // output
        System.out.println("\n******** CAR RENTAL RECEIPT ********");
        System.out.println("Customer Details");
        System.out.println("• Name: " + name);
        System.out.println("• Customer ID: " + id);
        System.out.println("• License Number: " + license);
        System.out.println("Vehicle Information");
        System.out.println("• Vehicle Type: " + vType);
        System.out.println("• Vehicle Model: " + vModel);
        System.out.printf("• Rate per Day: %.2f\n", ratePerDay);
        System.out.println("Rental Summary");
        System.out.println("• Pickup Date: " + pickup);
        System.out.println("• Return Date: " + returnDate);
        System.out.println("• Number of Days: " + days);
        System.out.printf("• Rental Cost: %.2f\n", rentalCost);
        System.out.println("Charges Breakdown");
        System.out.printf("  - Insurance Fee: %.2f\n", insurance);
        System.out.printf("  - Fuel Charge: %.2f\n", fuel);
        System.out.printf("  - Other Charges: %.2f\n", other);
        System.out.printf("• Subtotal: %.2f\n", subtotal);
        System.out.println("Payment Summary");
        System.out.printf("• Discount (%%): %.1f%%\n", discountPercent);
        System.out.printf("• Discount Amount: %.2f\n", discountAmt);
        System.out.printf("• Total Amount Due: %.2f\n", totalDue);
        System.out.printf("• Amount Paid: %.2f\n", amountPaid);
        if (amountPaid >= totalDue) {
            System.out.printf("• Change: %.2f\n", change);
        } else {
            System.out.printf("• Remaining Balance: %.2f\n", remaining);
        }
    }

    // programming 24: restaurant ordering system (ros)
    public static void runRestaurantSystem(Scanner sc) {
        System.out.println("\n--- PROGRAMMING 24: RESTAURANT ORDERING SYSTEM ---");
        String name = getValidName(sc, "Customer Name: ");
        String orderType = getValidString(sc, "Order Type (Dine-In or Takeout): ");

        String[] itemNames = new String[3];
        int[] itemQtys = new int[3];
        double[] itemPrices = new double[3];
        double subtotal = 0;

        for (int i = 0; i < 3; i++) {
            System.out.println("Item " + (i + 1) + ":");
            itemNames[i] = getValidString(sc, "  Item Name: ");
            itemQtys[i] = getValidInt(sc, "  Quantity: ");
            itemPrices[i] = getValidDouble(sc, "  Price per Item: ");
            subtotal += (itemQtys[i] * itemPrices[i]);
        }

        double serviceCharge = 0;
        double packagingFee = 0;

        if (orderType.equalsIgnoreCase("Dine-In")) {
            serviceCharge = getValidDouble(sc, "Service Charge: ");
        } else if (orderType.equalsIgnoreCase("Takeout")) {
            packagingFee = getValidDouble(sc, "Packaging Fee: ");
        }

        double discountPercent = getValidDouble(sc, "Discount (%): ");
        double amountTendered = getValidDouble(sc, "Amount Tendered: ");

        // computation
        double applicableCharge = (orderType.equalsIgnoreCase("Dine-In")) ? serviceCharge : packagingFee;
        double totalBeforeDiscount = subtotal + applicableCharge;
        double discountAmt = totalBeforeDiscount * (discountPercent / 100.0);
        double totalDue = totalBeforeDiscount - discountAmt;
        double change = amountTendered - totalDue;

        // output
        System.out.println("\n******** RESTAURANT RECEIPT ********");
        System.out.println("Customer Details");
        System.out.println("• Name: " + name);
        System.out.println("• Order Type: " + orderType);
        System.out.println("Order Summary");
        System.out.printf("%-15s %-8s %-10s %-10s\n", "Item Name", "Qty", "Price", "Total");
        for (int i = 0; i < 3; i++) {
            double itemTotal = itemQtys[i] * itemPrices[i];
            System.out.printf("%-15s %-8d %-10.2f %-10.2f\n", itemNames[i], itemQtys[i], itemPrices[i], itemTotal);
        }
        System.out.println("Billing Summary");
        System.out.printf("• Subtotal: %.2f\n", subtotal);
        if (orderType.equalsIgnoreCase("Dine-In")) {
            System.out.printf("• Service Charge: %.2f\n", serviceCharge);
        } else {
            System.out.printf("• Packaging Fee: %.2f\n", packagingFee);
        }
        System.out.printf("• Total Before Discount: %.2f\n", totalBeforeDiscount);
        System.out.printf("• Discount (%%): %.1f%%\n", discountPercent);
        System.out.printf("• Discount Amount: %.2f\n", discountAmt);
        System.out.printf("• Total Amount Due: %.2f\n", totalDue);
        System.out.printf("• Amount Tendered: %.2f\n", amountTendered);
        System.out.printf("• Change: %.2f\n", change);
    }

    // programming 25: flower reservation with billing system
    public static void runFlowerSystem(Scanner sc) {
        System.out.println("\n--- PROGRAMMING 25: FLOWER RESERVATION SYSTEM ---");
        String name = getValidName(sc, "Customer Name: ");
        String id = getValidString(sc, "Customer ID: ");
        String contact = getValidString(sc, "Contact Number: ");
        String flowerType = getValidString(sc, "Flower Type (e.g., Roses, Tulips): ");
        String arrangement = getValidString(sc, "Arrangement Type (Bouquet/Vase/Box): ");
        double pricePerArr = getValidDouble(sc, "Price per Arrangement: ");
        int qty = getValidInt(sc, "Quantity: ");
        String resDate = getValidString(sc, "Reservation Date (YYYY-MM-DD): ");
        String deliveryDate = getValidString(sc, "Pickup/Delivery Date (YYYY-MM-DD): ");
        double deliveryFee = getValidDouble(sc, "Delivery Fee: ");
        double customFee = getValidDouble(sc, "Customization Fee: ");
        double otherFee = getValidDouble(sc, "Other Charges: ");
        double discountPercent = getValidDouble(sc, "Discount (%): ");
        double downpayment = getValidDouble(sc, "Down Payment: ");

        // computation
        double resCost = pricePerArr * qty;
        double totalAddCharges = deliveryFee + customFee + otherFee;
        double subtotal = resCost + totalAddCharges;
        double discountAmt = subtotal * (discountPercent / 100.0);
        double totalBill = subtotal - discountAmt;
        double balance = totalBill - downpayment;

        // output
        System.out.println("\n******** FLOWER RESERVATION RECEIPT ********");
        System.out.println("Customer Details");
        System.out.println("• Name: " + name);
        System.out.println("• Customer ID: " + id);
        System.out.println("• Contact: " + contact);
        System.out.println("Reservation Summary");
        System.out.println("• Flower Type: " + flowerType);
        System.out.println("• Arrangement Type: " + arrangement);
        System.out.println("• Quantity: " + qty);
        System.out.printf("• Price per Arrangement: %.2f\n", pricePerArr);
        System.out.printf("• Reservation Cost: %.2f\n", resCost);
        System.out.println("• Reservation Date: " + resDate);
        System.out.println("• Pickup/Delivery Date: " + deliveryDate);
        System.out.println("Charges Breakdown");
        System.out.printf("  - Delivery Fee: %.2f\n", deliveryFee);
        System.out.printf("  - Customization Fee: %.2f\n", customFee);
        System.out.printf("  - Other Charges: %.2f\n", otherFee);
        System.out.printf("• Subtotal: %.2f\n", subtotal);
        System.out.println("Payment Summary");
        System.out.printf("• Discount (%%): %.1f%%\n", discountPercent);
        System.out.printf("• Discount Amount: %.2f\n", discountAmt);
        System.out.printf("• Total Bill: %.2f\n", totalBill);
        System.out.printf("• Down Payment: %.2f\n", downpayment);
        System.out.printf("• Remaining Balance: %.2f\n", balance);
    }

    // programming 26: kmart korean noodles purchase order with billing system
    public static void runKmartSystem(Scanner sc) {
        System.out.println("\n--- PROGRAMMING 26: KMART NOODLES BILLING ---");
        String name = getValidName(sc, "Customer Name: ");
        String id = getValidString(sc, "Customer ID: ");
        String contact = getValidString(sc, "Contact Number: ");
        String product = getValidString(sc, "Product Name: ");
        String brand = getValidString(sc, "Brand: ");
        double pricePerPack = getValidDouble(sc, "Price per Pack: ");
        int qty = getValidInt(sc, "Quantity: ");
        double packagingFee = getValidDouble(sc, "Packaging Fee: ");
        double deliveryFee = getValidDouble(sc, "Delivery Fee: ");
        double discountPercent = getValidDouble(sc, "Discount (%): ");
        double cashPayment = getValidDouble(sc, "Cash Payment: ");

        // computation
        double totalProductCost = pricePerPack * qty;
        double subtotal = totalProductCost + packagingFee + deliveryFee;
        double discountAmt = subtotal * (discountPercent / 100.0);
        double totalBill = subtotal - discountAmt;
        double change = 0;
        double remaining = 0;

        if (cashPayment >= totalBill) {
            change = cashPayment - totalBill;
        } else {
            remaining = totalBill - cashPayment;
        }

        // output
        System.out.println("\n******** KMART PURCHASE RECEIPT ********");
        System.out.println("Customer Details");
        System.out.println("• Name: " + name);
        System.out.println("• Customer ID: " + id);
        System.out.println("• Contact Number: " + contact);
        System.out.println("Order Summary");
        System.out.println("• Product Name: " + product);
        System.out.println("• Brand: " + brand);
        System.out.printf("• Price per Pack: %.2f\n", pricePerPack);
        System.out.println("• Quantity: " + qty);
        System.out.printf("• Total Product Cost: %.2f\n", totalProductCost);
        System.out.println("Charges");
        System.out.printf("  - Packaging Fee: %.2f\n", packagingFee);
        System.out.printf("  - Delivery Fee: %.2f\n", deliveryFee);
        System.out.printf("• Subtotal: %.2f\n", subtotal);
        System.out.println("Payment Summary");
        System.out.printf("• Discount (%%): %.1f%%\n", discountPercent);
        System.out.printf("• Discount Amount: %.2f\n", discountAmt);
        System.out.printf("• Total Bill: %.2f\n", totalBill);
        System.out.printf("• Cash Payment: %.2f\n", cashPayment);
        if (cashPayment >= totalBill) {
            System.out.printf("• Change: %.2f\n", change);
        } else {
            System.out.printf("• Remaining Balance: %.2f\n", remaining);
        }
    }

    // programming 27: car and motor parking reservation and billing system
    public static void runParkingSystem(Scanner sc) {
        System.out.println("\n--- PROGRAMMING 27: PARKING BILLING SYSTEM ---");
        String name = getValidName(sc, "Customer Name: ");
        String id = getValidString(sc, "Customer ID: ");
        String contact = getValidString(sc, "Contact Number: ");
        String vType = getValidString(sc, "Vehicle Type (Car/Motorcycle): ");
        String plate = getValidString(sc, "Plate Number: ");
        String entryTime = getValidString(sc, "Entry Time (HH:MM): ");
        String exitTime = getValidString(sc, "Exit Time (HH:MM): ");
        double hourlyRate = getValidDouble(sc, "Hourly Rate: ");
        double resFee = getValidDouble(sc, "Reservation Fee: ");
        double overnightFee = getValidDouble(sc, "Overnight Fee: ");
        double penaltyFee = getValidDouble(sc, "Penalty Fee: ");
        double discountPercent = getValidDouble(sc, "Discount (%): ");
        double cashPayment = getValidDouble(sc, "Cash Payment: ");

        // computation for total hours from HH:MM
        double totalHours = 1.0;
        try {
            String[] entryParts = entryTime.split(":");
            String[] exitParts = exitTime.split(":");
            int entryMinutes = Integer.parseInt(entryParts[0]) * 60 + Integer.parseInt(entryParts[1]);
            int exitMinutes = Integer.parseInt(exitParts[0]) * 60 + Integer.parseInt(exitParts[1]);
            int diffMinutes = exitMinutes - entryMinutes;
            if (diffMinutes < 0) diffMinutes += 24 * 60;
            totalHours = diffMinutes / 60.0;
        } catch (Exception e) {
            totalHours = 1.0;
        }

        double parkingFee = totalHours * hourlyRate;
        double subtotal = parkingFee + resFee + overnightFee + penaltyFee;
        double discountAmt = subtotal * (discountPercent / 100.0);
        double totalBill = subtotal - discountAmt;
        double change = 0;
        double remaining = 0;

        if (cashPayment >= totalBill) {
            change = cashPayment - totalBill;
        } else {
            remaining = totalBill - cashPayment;
        }

        // output
        System.out.println("\n******** PARKING RECEIPT ********");
        System.out.println("Customer Details");
        System.out.println("• Name: " + name);
        System.out.println("• Customer ID: " + id);
        System.out.println("• Contact Number: " + contact);
        System.out.println("Vehicle Details");
        System.out.println("• Vehicle Type: " + vType);
        System.out.println("• Plate Number: " + plate);
        System.out.println("Parking Summary");
        System.out.println("• Entry Time: " + entryTime);
        System.out.println("• Exit Time: " + exitTime);
        System.out.printf("• Total Hours: %.2f\n", totalHours);
        System.out.printf("• Hourly Rate: %.2f\n", hourlyRate);
        System.out.printf("• Parking Fee: %.2f\n", parkingFee);
        System.out.println("Charges Breakdown");
        System.out.printf("  - Reservation Fee: %.2f\n", resFee);
        System.out.printf("  - Overnight Fee: %.2f\n", overnightFee);
        System.out.printf("  - Penalty Fee: %.2f\n", penaltyFee);
        System.out.printf("• Subtotal: %.2f\n", subtotal);
        System.out.println("Payment Summary");
        System.out.printf("• Discount (%%): %.1f%%\n", discountPercent);
        System.out.printf("• Discount Amount: %.2f\n", discountAmt);
        System.out.printf("• Total Bill: %.2f\n", totalBill);
        System.out.printf("• Cash Payment: %.2f\n", cashPayment);
        if (cashPayment >= totalBill) {
            System.out.printf("• Change: %.2f\n", change);
        } else {
            System.out.printf("• Remaining Balance: %.2f\n", remaining);
        }
    }
}
