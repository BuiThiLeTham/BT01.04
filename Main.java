package BTGK;
import java.io.*;
import java.util.*;
import java.util.stream.*;
public class Main {
    public static void main(String[] args) {
        StudentController controller = new StudentController();
        StudentView view = new StudentView();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            view.displayMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter student age: ");
                    int age = scanner.nextInt();
                    controller.addStudent(name, age);
                    break;
                case 2:
                    controller.saveStudentsToFile();
                    System.out.println("Students saved to file.");
                    break;
                case 3:
                    controller.loadStudentsFromFile();
                    System.out.println("Students loaded from file.");
                    break;
                case 4:
                    controller.displayStudents();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
    }
}
