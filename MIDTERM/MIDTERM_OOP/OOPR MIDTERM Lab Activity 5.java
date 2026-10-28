import java.util.Scanner;

abstract class Account {
    private String accountNumber;
    private double balance;

    public Account(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    // kunin ang balanse
    public double getBalance() {
        return balance;
    }

    // deposito ng pera
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.printf("New %s balance: P%.2f\n", getAccountType(), balance);
        } else {
            System.out.println("Invalid amount.");
        }
    }

    // withdraw ng pera
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount.");
            return;
        }
        double fee = calculateWithdrawalFee();
        if (balance >= amount + fee) {
            balance -= (amount + fee);
            System.out.printf("Withdrawal fee: P%.2f | New %s balance: P%.2f\n", fee, getAccountType(), balance);
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    public abstract double calculateWithdrawalFee();
    public abstract String getAccountType();
}

// savings ng account
class SavingsAccount extends Account {
    
    public SavingsAccount(String accountNumber, double initialBalance) {
        super(accountNumber, initialBalance);
    }

    @Override
    public double calculateWithdrawalFee() {
        return 0.0;
    }

    @Override
    public String getAccountType() {
        return "Savings";
    }
}

// checking the account
class CheckingAccount extends Account {
    
    public CheckingAccount(String accountNumber, double initialBalance) {
        super(accountNumber, initialBalance);
    }

    @Override
    public double calculateWithdrawalFee() {
        return 10.0;
    }

    @Override
    public String getAccountType() {
        return "Checking";
    }
}

public class Main {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the OOP Banking System");

        double openingBalance = readNonNegativeBalance(scanner);

        SavingsAccount savingsAccount = new SavingsAccount("SAV-001", openingBalance);
        CheckingAccount checkingAccount = new CheckingAccount("CHK-001", openingBalance);
        Account selectedAccount = savingsAccount; 

        int choice = 0;
        do {
            printAccountSummary(selectedAccount);
            showMenu();
            choice = readMenuChoice(scanner);

            switch (choice) {
                case 1:
                    System.out.print("Amount to withdraw: ");
                    double withdrawAmount = readPositiveAmount(scanner);
                    selectedAccount.withdraw(withdrawAmount);
                    break;
                case 2:
                    System.out.print("Amount to deposit: ");
                    double depositAmount = readPositiveAmount(scanner);
                    selectedAccount.deposit(depositAmount);
                    break;
                case 3:
                    // show the balanse
                    System.out.printf("Current %s balance: P%.2f\n", selectedAccount.getAccountType(), selectedAccount.getBalance());
                    break;
                case 4:
                    if (selectedAccount instanceof SavingsAccount) {
                        selectedAccount = checkingAccount;
                    } else {
                        selectedAccount = savingsAccount;
                    }
                    break;
                case 5:
                    System.out.println("Thank you for using the system!");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 5);

        scanner.close();
    }

    // menu
    public static void showMenu() {
        System.out.println("1 Withdraw\t2 Deposit");
        System.out.println("3 Show balance\t4 Switch account\t5 Exit");
    }

    // balanse
    public static double readNonNegativeBalance(Scanner scanner) {
        double balance = -1;
        while (true) {
            System.out.print("Opening balance: ");
            if (scanner.hasNextDouble()) {
                balance = scanner.nextDouble();
                if (balance >= 0) {
                    break;
                }
            } else {
                scanner.next(); 
            }
            System.out.println("Invalid input. Try again.");
        }
        return balance;
    }

    // halaga
    public static double readPositiveAmount(Scanner scanner) {
        double amount = -1;
        while (true) {
            if (scanner.hasNextDouble()) {
                amount = scanner.nextDouble();
                if (amount > 0) {
                    break;
                }
            } else {
                scanner.next(); 
            }
            System.out.println("Invalid amount. Try again.");
        }
        return amount;
    }

    public static int readMenuChoice(Scanner scanner) {
        int choice = -1;
        while (true) {
            System.out.print("Choice: ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice >= 1 && choice <= 5) {
                    break;
                }
            } else {
                scanner.next(); 
            }
            System.out.println("Invalid choice. Try again.");
        }
        return choice;
    }

    public static void printAccountSummary(Account account) {
        System.out.printf("Current account: %s | Balance: P%.2f\n", account.getAccountType(), account.getBalance());
    }
}
