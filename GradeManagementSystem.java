import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String name;
    private double marks;

    public Student(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public double getMarks() {
        return marks;
    }
}

public class GradeManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();
        boolean exit = false;

        while (!exit) {
            System.out.println("\n=== Student Grade Management System ===");
            System.out.println("1. Add Student Record");
            System.out.println("2. Display Summary Report");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter student marks: ");
                    double marks = scanner.nextDouble();
                    students.add(new Student(name, marks));
                    System.out.println("Student record added successfully.");
                    break;

                case 2:
                    if (students.isEmpty()) {
                        System.out.println("No student records available.");
                    } else {
                        displayReport(students);
                    }
                    break;

                case 3:
                    exit = true;
                    System.out.println("Exiting system. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
        scanner.close();
    }

    private static void displayReport(ArrayList<Student> students) {
        double sum = 0;
        double highest = students.get(0).getMarks();
        double lowest = students.get(0).getMarks();
        String topScorer = students.get(0).getName();
        String lowestScorer = students.get(0).getName();

        System.out.println("\n-------------------------------------------");
        System.out.printf("%-20s %-10s\n", "Student Name", "Marks");
        System.out.println("-------------------------------------------");

        for (Student s : students) {
            System.out.printf("%-20s %-10.2f\n", s.getName(), s.getMarks());
            sum += s.getMarks();

            if (s.getMarks() > highest) {
                highest = s.getMarks();
                topScorer = s.getName();
            }
            if (s.getMarks() < lowest) {
                lowest = s.getMarks();
                lowestScorer = s.getName();
            }
        }

        double average = sum / students.size();

        System.out.println("-------------------------------------------");
        System.out.printf("Total Students : %d\n", students.size());
        System.out.printf("Average Marks  : %.2f\n", average);
        System.out.printf("Highest Marks  : %.2f (%s)\n", highest, topScorer);
        System.out.printf("Lowest Marks   : %.2f (%s)\n", lowest, lowestScorer);
        System.out.println("-------------------------------------------");
    }
}
