import java.util.Scanner;
import java.util.ArrayList;

class Date {
    int year;
    int month;
    int day;

    public Date(int y, int m, int d) {
        this.year = y;
        this.month = m;
        this.day = d;
    }

    @Override
    public String toString() {
        return year + "-" + month + "-" + day;
    }
}

class Patient {
    String name;
    Date admissionDate;
    String disease;
    Date dischargeDate;

    public Patient(String name, Date admissionDate, String disease, Date dischargeDate) {
        this.name = name;
        this.admissionDate = admissionDate;
        this.disease = disease;
        this.dischargeDate = dischargeDate;
    }

    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Date of admission: " + admissionDate);
        System.out.println("Disease: " + disease);
        System.out.println("Date of discharge: " + dischargeDate);
    }
}

class PediatricPatient extends Patient {
    int age;

    public PediatricPatient(String name, Date admissionDate, String disease, Date dischargeDate, int age) {
        super(name, admissionDate, disease, dischargeDate);
        this.age = age;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Age: " + age);
    }
}

class Professor {
    String name;
    double salary;

    public Professor(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }
}

class Dean extends Professor {
    String department;

    public Dean(String name, double salary, String department) {
        super(name, salary);
        this.department = department;
    }

    public void printInfo() {
        System.out.println("Status");
        System.out.println("Rank: Dean");
        System.out.println("Name: " + name);
        System.out.println("Department: " + department);
        System.out.println("Salary: " + (int)salary);
    }
}

class Executive extends Dean {
    public Executive(String name, double salary, String department) {
        super(name, salary, department);
    }

    @Override
    public void printInfo() {
        System.out.println("Status");
        System.out.println("Rank: Executive");
        System.out.println("Name: " + name);
        System.out.println("Department: " + department);
        System.out.println("Salary: " + (int)salary);
    }
}

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("=================================");
            System.out.println("OOP MIDTERM LAB ACTIVITY 6");
            System.out.println("=================================");
            System.out.println("1. Program 1: Bank Account");
            System.out.println("2. Program 2: Hospital Database");
            System.out.println("3. Program 3: Professor Hierarchy");
            System.out.println("4. Exit");
            choice = getValidInt("Select a program (1-4): ", 1, 4);

            if (choice == 1) {
                runProgram1();
            } else if (choice == 2) {
                runProgram2();
            } else if (choice == 3) {
                runProgram3();
            } else if (choice == 4) {
                break;
            }
        } while (true);
    }

    private static int getValidInt(String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                int val = scanner.nextInt();
                scanner.nextLine();
                if (val >= min && val <= max) {
                    return val;
                }
            } else {
                scanner.next();
            }
            System.out.println("invalid");
        }
    }

    private static double getValidDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextDouble()) {
                double val = scanner.nextDouble();
                scanner.nextLine();
                if (val >= 0) {
                    return val;
                }
            } else {
                scanner.next();
            }
            System.out.println("invalid");
        }
    }

    private static String getValidString(String prompt) {
        while (true) {
            System.out.print(prompt);
            String val = scanner.nextLine().trim();
            if (!val.isEmpty()) {
                return val;
            }
            System.out.println("invalid");
        }
    }

    private static void runProgram1() {
        System.out.println("Welcome!");
        double balance = getValidDouble("Enter your balance: ");
        
        System.out.println("Select an option:");
        System.out.println("1. Withdraw Amount");
        System.out.println("2. Deposit Amount");
        System.out.println("3. Exit");
        
        int opt = getValidInt("Enter option: ", 1, 3);
        if (opt == 1 || opt == 2 || opt == 3) {
            double withdraw = getValidDouble("How much amount you want to withdraw from your account?\nAmount: ");
            balance -= withdraw;
            System.out.println("Your new balance is: " + (int)balance);

            double deposit = getValidDouble("How much amount you want to deposit in your account?\nAmount: ");
            balance += deposit;
            System.out.println("Your new balance is: " + (int)balance);
        }
        System.out.println("Thank you for using the system!");
    }

    private static void runProgram2() {
        ArrayList<PediatricPatient> patients = new ArrayList<>();
        int choice;
        do {
            System.out.println("\n1. Insert New Patient");
            System.out.println("2. Display all Patient");
            System.out.println("3. Display pediatric patient");
            System.out.println("4. Exit");
            choice = getValidInt("Select an option: ", 1, 4);

            if (choice == 1) {
                String name = getValidString("1. Name of the patient: ");
                
                System.out.println("Date of admission:");
                int adYear = getValidInt("Year: ", 2000, 2100);
                int adMonth = getValidInt("Month: ", 1, 12);
                int adDay = getValidInt("Day: ", 1, 31);
                Date admission = new Date(adYear, adMonth, adDay);

                String disease = getValidString("Disease: ");

                System.out.println("Date of discharge:");
                int dcYear = getValidInt("Year: ", 2000, 2100);
                int dcMonth = getValidInt("Month: ", 1, 12);
                int dcDay = getValidInt("Day: ", 1, 31);
                Date discharge = new Date(dcYear, dcMonth, dcDay);

                int age = getValidInt("Age of the patient: ", 0, 120);

                patients.add(new PediatricPatient(name, admission, disease, discharge, age));
                System.out.println("Patient added successfully!");
            } else if (choice == 2) {
                if (patients.isEmpty()) {
                    System.out.println("No patients stored.");
                } else {
                    for (int i = 0; i < patients.size(); i++) {
                        System.out.println("\nPatient " + (i + 1) + ":");
                        patients.get(i).display();
                    }
                }
            } else if (choice == 3) {
                boolean found = false;
                for (PediatricPatient p : patients) {
                    if (p.age < 12) {
                        System.out.println("\nPediatric Patient:");
                        p.display();
                        found = true;
                    }
                }
                if (!found) {
                    System.out.println("No pediatric patients found.");
                }
            }
        } while (choice != 4);
    }

    private static void runProgram3() {
        Dean dean = new Dean("John Cena", 32000, "English");
        Executive exec = new Executive("Ronald McDonald", 42000, "Computer Science");

        dean.printInfo();
        System.out.println();
        exec.printInfo();
    }
}
