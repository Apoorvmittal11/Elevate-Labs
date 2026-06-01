import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String id;
    private String name;
    private double marks;

    public Student(String id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    public String getId() { return id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getMarks() { return marks; }
    public void setMarks(double marks) { this.marks = marks; }

    @Override
    public String toString() {
        return "ID: " + id + " | Name: " + name + " | Marks: " + marks;
    }
}

public class StudentManager {
    private static ArrayList<Student> studentList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            System.out.println("\n=== Student Record Management System ===");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewStudents();
                    break;
                case 3:
                    updateStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    running = false;
                    System.out.println("Exiting system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        scanner.close();
    }

    private static void addStudent() {
        System.out.print("Enter Student ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Student Marks: ");
        double marks = scanner.nextDouble();

        studentList.add(new Student(id, name, marks));
        System.out.println("Student added successfully!");
    }

    private static void viewStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No student records found.");
        } else {
            System.out.println("\n--- Student List ---");
            for (Student student : studentList) {
                System.out.println(student.toString());
            }
        }
    }

    private static void updateStudent() {
        System.out.print("Enter the ID of the student to update: ");
        String id = scanner.nextLine();
        boolean found = false;

        for (Student student : studentList) {
            if (student.getId().equals(id)) {
                System.out.print("Enter new Name: ");
                student.setName(scanner.nextLine());
                System.out.print("Enter new Marks: ");
                student.setMarks(scanner.nextDouble());
                System.out.println("Student record updated successfully!");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student ID not found.");
        }
    }

    private static void deleteStudent() {
        System.out.print("Enter the ID of the student to delete: ");
        String id = scanner.nextLine();
        boolean removed = studentList.removeIf(student -> student.getId().equals(id));

        if (removed) {
            System.out.println("Student deleted successfully!");
        } else {
            System.out.println("Student ID not found.");
        }
    }
}