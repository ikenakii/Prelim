import java.util.Scanner;

public class Program2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[5];

        System.out.print("enter five numbers: ");
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = scanner.nextInt();
        }

        int highest = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > highest) {
                highest = numbers[i];
            }
        }

        System.out.println("\nthe highest is: " + highest);
        System.out.println("\nthe difference from the highest are:\n");

        for (int i = 0; i < numbers.length; i++) {
            int difference = highest - numbers[i];
            System.out.println(highest + " - " + numbers[i] + " = " + difference);
        }

        scanner.close();
    }
}
