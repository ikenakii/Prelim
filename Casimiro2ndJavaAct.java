package com.mycompany.Casimiro4yh;

import java.util.Scanner;

public class Casimiro4th {
    public static void main(String[] args) {
        String name;
        int answer;
        Scanner scan = new Scanner(System.in);

        do {
            System.out.println("please insert your name");
            name = scan.nextLine();
            System.out.println("Hello Mr. " + name);
            System.out.println("would you like to change your name? insert 1 for yes and 2 for no");
            answer = scan.nextInt();
            scan.nextLine();
        } while (answer == 1);

        scan.close();
    }
}