package com.mycompany.mavenproject1;

import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            char continueChoice;
            
            do {
                System.out.println("Choose the program you want to run");
                System.out.println("Number 1");
                System.out.println("Number 2");
                System.out.println("Number 3");
                System.out.println("Number 4");
                System.out.println("Number 5");
                System.out.println("Number 6");
                System.out.println("Number 7 (Import from data.txt to NetBeans)");
                System.out.print("Enter choice: ");
                int choice = input.nextInt();
                
                switch (choice) {
                    case 1 -> {
                        double[] numbers = new double[10];
                        System.out.println("Enter 10 real numbers: ");
                        for (int i = 0; i < 10; i++) {
                            numbers[i] = input.nextDouble();
                        }
                        double sum = 0;
                        int positiveCount = 0;
                        for (int i = 0; i < 10; i++) {
                            if (numbers[i] > 0) {
                                sum += numbers[i];
                                positiveCount++;
                            }
                        }
                        double average = (positiveCount > 0) ? sum / positiveCount : 0;
                        System.out.println("Sum of positive numbers: " + sum);
                        System.out.println("Average of positive numbers: " + average);
                        
                        int negativeCount = 0;
                        for (int i = 0; i < 10; i++) {
                            if (numbers[i] < 0) {
                                negativeCount++;
                            }
                        }
                        System.out.println("Negative numbers count: " + negativeCount);
                        
                        double min = numbers[0];
                        for (int i = 1; i < 10; i++) {
                            if (numbers[i] < min) {
                                min = numbers[i];
                            }
                        }
                        System.out.println("Minimum value: " + min);
                    }
                    case 2 -> {
                        int[] numbers = new int[8];
                        System.out.println("Enter 8 integer numbers: ");
                        for (int i = 0; i < 8; i++) {
                            numbers[i] = input.nextInt();
                        }
                        int uniqueCount = 0;
                        int[] uniqueArr = new int[8];
                        for (int i = 0; i < 8; i++) {
                            boolean isDuplicate = false;
                            for (int j = 0; j < uniqueCount; j++) {
                                if (numbers[i] == uniqueArr[j]) {
                                    isDuplicate = true;
                                    break;
                                }
                            }
                            if (!isDuplicate) {
                                uniqueArr[uniqueCount] = numbers[i];
                                uniqueCount++;
                            }
                        }
                        System.out.print("Array after removing duplicates: ");
                        for (int i = 0; i < uniqueCount; i++) {
                            System.out.print(uniqueArr[i] + " ");
                        }
                        System.out.println();
                        
                        for (int i = 0; i < uniqueCount - 1; i++) {
                            for (int j = 0; j < uniqueCount - i - 1; j++) {
                                if (uniqueArr[j] > uniqueArr[j + 1]) {
                                    int temp = uniqueArr[j];
                                    uniqueArr[j] = uniqueArr[j + 1];
                                    uniqueArr[j + 1] = temp;
                                }
                            }
                        }
                        if (uniqueCount >= 2) {
                            System.out.println("Second smallest: " + uniqueArr[1]);
                            System.out.println("Second largest: " + uniqueArr[uniqueCount - 2]);
                        } else {
                            System.out.println("Not enough unique elements to find second values.");
                        }
                    }
                    case 3 -> {
                        int[] arr = new int[5];
                        System.out.print("Enter Data in Array: ");
                        for (int i = 0; i < 5; i++) {
                            arr[i] = input.nextInt();
                        }
                        System.out.print("Stored Data in Array: ");
                        for (int i = 0; i < 5; i++) {
                            System.out.print(arr[i] + " ");
                        }
                        System.out.println();
                        System.out.print("Enter poss. of Element to Delete: ");
                        int pos = input.nextInt();
                        
                        System.out.print("New data in Array: ");
                        for (int i = 0; i < 5; i++) {
                            if (i != pos) {
                                System.out.print(arr[i] + " ");
                            }
                        }
                        System.out.println();
                    }
                    case 4 -> {
                        System.out.print("Enter Size of Array: ");
                        int size = input.nextInt();
                        int[] arr = new int[size];
                        System.out.println("Enter any " + size + " elements in Array: ");
                        for (int i = 0; i < size; i++) {
                            arr[i] = input.nextInt();
                        }
                        System.out.print("Even Elements: ");
                        for (int i = 0; i < size; i++) {
                            if (arr[i] % 2 == 0) {
                                System.out.print(arr[i] + " ");
                            }
                        }
                        System.out.println();
                        System.out.print("Odd Elements: ");
                        for (int i = 0; i < size; i++) {
                            if (arr[i] % 2 != 0) {
                                System.out.print(arr[i] + " ");
                            }
                        }
                        System.out.println();
                    }
                    case 5 -> {
                        System.out.println("*");
                        System.out.println("*A*");
                        System.out.println("*A*A*");
                        System.out.println("*A*A*A*");
                    }
                    case 6 -> {
                        System.out.println("--- Instantiating using Default Constructor ---");
                        Student s1 = new Student();
                        System.out.println("Student 1 No: " + s1.getStudentNo());
                        System.out.println("Student 1 Name: " + s1.getStudentName());
                        System.out.println("Student 1 DOB: " + s1.getDateOfBirth());
                        System.out.println("Student 1 Tariff: " + s1.getTariffPoints());
                        
                        System.out.println("\n--- Instantiating using Parameterized Constructor ---");
                        Student s2 = new Student("S101", "John Doe", "15th August 1996", 15);
                        System.out.println("Student 2 Tariff (Should default to 20 due to check): " + s2.getTariffPoints());
                        
                        System.out.println("\n--- Modifying Student 2 using Setters ---");
                        s2.setStudentNo("S102");
                        s2.setStudentName("DELA ROSA, BRIX GIOVANN D.");
                        s2.setDateOfBirth("01 March 2007");
                        s2.setTariffPoints(250);
                        System.out.println("Student 2 No: " + s2.getStudentNo());
                        System.out.println("Student 2 Name: " + s2.getStudentName());
                        System.out.println("Student 2 DOB: " + s2.getDateOfBirth());
                        System.out.println("Student 2 Tariff: " + s2.getTariffPoints());
                        System.out.println("\nTotal students created: " + Student.getNoOfStudents());
                    }
                    case 7 -> {
                        try {
                            File file = new File("C:\\Users\\SBH-CL3-WS01\\Documents\\NetBeansProjects\\mavenproject1\\src\\main\\java\\com\\mycompany\\mavenproject1\\data.txt");
                            if (!file.exists()) {
                                System.out.println("Error: data.txt does not exist.");
                                break;
                            }

                            List<String> fixedLines = new ArrayList<>();
                            int autoEno = 101; 

                            try (Scanner fileScanner = new Scanner(file)) {
                                while (fileScanner.hasNextLine()) {
                                    String line = fileScanner.nextLine().trim();
                                    
                                    if (line.isEmpty() || line.startsWith("Simulating") || line.contains("ENO") || line.contains("---")) {
                                        continue;
}
String cleanLine = line.replace("Inserted:", "");
String[] tokens = cleanLine.split("[|\s]+");
StringBuilder nameBuilder = new StringBuilder();
String phone = "";
for (String token : tokens) {
String t = token.trim();
if (t.isEmpty() || t.equals("|")) continue;
if (t.matches("\\d+")) {
if (t.length() >= 4) {
phone = t;
}
} else {
if (nameBuilder.length() > 0) {
nameBuilder.append(" ");
}
nameBuilder.append(t);
}
}
String ename = nameBuilder.toString();
if (!ename.isEmpty() || !phone.isEmpty()) {
String formattedLine = String.format("Inserted: %-3d | %-25s | %s", autoEno, ename, phone);
fixedLines.add(formattedLine);
autoEno++;
}
}
}
try (FileWriter writer = new FileWriter(file)) {
writer.write("Simulating DB Record Inserts:\n");
for (String fixedLine : fixedLines) {
writer.write(fixedLine + "\n");
}
}
System.out.println("--- Printing Records Imported from data.txt ---");
System.out.printf("%-6s | %-25s | %s\n", "ENO", "ENAME", "NUMBER");
System.out.println("---------------------------------------------------------");
for (String fixedLine : fixedLines) {
String clean = fixedLine.replace("Inserted:", "").trim();
String[] parts = clean.split("\\|");
if (parts.length == 3) {
System.out.printf("%-6s | %-25s | %s\n", parts[0].trim(), parts[1].trim(), parts[2].trim());
}
}
} catch (IOException e) {
System.out.println("Error: data.txt file could not be processed.");
}
}
default -> System.out.println("Invalid Choice!");
}
System.out.print("Do you want to continue? Y/N: ");
continueChoice = input.next().charAt(0);
} while (continueChoice == 'Y' || continueChoice == 'y');
}
}
}
class Student {
private String studentNo;
private String studentName;
private String dateOfBirth;
private int tariffPoints;
private static int noOfStudents = 0;
public Student() {
this.studentNo = "not known";
this.studentName = "not known";
this.dateOfBirth = "1st January 1995";
this.tariffPoints = 20;
noOfStudents++;
}
public Student(String studentNo, String studentName, String dateOfBirth, int tariffPoints) {
setStudentNo(studentNo);
setStudentName(studentName);
setDateOfBirth(dateOfBirth);
setTariffPoints(tariffPoints);
noOfStudents++;
}
public String getStudentNo() { return studentNo; }
public void setStudentNo(String studentNo) { this.studentNo = studentNo; }
public String getStudentName() { return studentName; }
public void setStudentName(String studentName) { this.studentName = studentName; }
public String getDateOfBirth() { return dateOfBirth; }
public void setDateOfBirth(String dateOfBirth) { this.dateOfBirth = dateOfBirth; }
public int getTariffPoints() { return tariffPoints; }
public void setTariffPoints(int tariffPoints) {
if (tariffPoints >= 20 && tariffPoints <= 280) {
this.tariffPoints = tariffPoints;
} else {
System.out.println("Warning: Tariff points must be between 20 and 280. Defaulting to 20.");
this.tariffPoints = 20;
}
}
public static int getNoOfStudents() { return noOfStudents; }
}
