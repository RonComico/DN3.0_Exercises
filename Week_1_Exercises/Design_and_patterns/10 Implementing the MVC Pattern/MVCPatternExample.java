// MVCPatternExample.java

import java.util.Scanner;

// Step 2: Define Model Class
class Student {
    private String name;
    private String id;
    private String grade;

    public Student(String name, String id, String grade) {
        this.name = name;
        this.id = id;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}

// Step 3: Define View Class
class StudentView {
    public void displayStudentDetails(String studentName, String studentId, String studentGrade) {
        System.out.println("Student Details:");
        System.out.println("Name: " + studentName);
        System.out.println("ID: " + studentId);
        System.out.println("Grade: " + studentGrade);
    }
}

// Step 4: Define Controller Class
class StudentController {
    private Student model;
    private StudentView view;

    public StudentController(Student model, StudentView view) {
        this.model = model;
        this.view = view;
    }

    public String getStudentName() {
        return model.getName();
    }

    public void setStudentName(String name) {
        model.setName(name);
    }

    public String getStudentId() {
        return model.getId();
    }

    public void setStudentId(String id) {
        model.setId(id);
    }

    public String getStudentGrade() {
        return model.getGrade();
    }

    public void setStudentGrade(String grade) {
        model.setGrade(grade);
    }

    public void updateView() {
        view.displayStudentDetails(model.getName(), model.getId(), model.getGrade());
    }
}

// Step 5: Test the MVC Implementation with User Interaction
public class MVCPatternExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initial data
        Student model = new Student("John Doe", "001", "A");
        StudentView view = new StudentView();
        StudentController controller = new StudentController(model, view);

        while (true) {
            System.out.println("Select an option:");
            System.out.println("1. Display Student Details");
            System.out.println("2. Update Student Name");
            System.out.println("3. Update Student ID");
            System.out.println("4. Update Student Grade");
            System.out.println("5. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    controller.updateView();
                    break;
                case 2:
                    System.out.print("Enter new name: ");
                    String name = scanner.nextLine();
                    controller.setStudentName(name);
                    break;
                case 3:
                    System.out.print("Enter new ID: ");
                    String id = scanner.nextLine();
                    controller.setStudentId(id);
                    break;
                case 4:
                    System.out.print("Enter new grade: ");
                    String grade = scanner.nextLine();
                    controller.setStudentGrade(grade);
                    break;
                case 5:
                    System.out.println("Exiting.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
