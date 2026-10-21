import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 1. Get the user input once
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        
        // 2. FOR LOOP
        System.out.println("\n--- Using For Loop ---");
        for (int i = 1; i <= 5; i++) {
            System.out.println(name);
        }
        
        // 3. WHILE LOOP
        System.out.println("\n--- Using While Loop ---");
        int w = 1;
        while (w <= 5) {
            System.out.println(name);
            w++;
        }
        
        // 4. DO-WHILE LOOP
        System.out.println("\n--- Using Do-While Loop ---");
        int d = 1;
        do {
            System.out.println(name);
            d++;
        } while (d <= 5);
        
        scanner.close();
    }
}
