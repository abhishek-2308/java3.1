import java.util.*;

// MODEL
class Student {
    int id;
    String name;
    int age;

    Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return id + " | " + name + " | " + age;
    }
}

class StudentView {
    void displayStudent(Student s) {
        System.out.println("Student Details → " + s);
    }

    void displayAll(List<Student> list) {
        System.out.println("\nAll Students:");
        for (Student s : list) System.out.println(s);
    }
}

// CONTROLLER
class StudentController {
    private List<Student> students = new ArrayList<>();
    private StudentView view;

    StudentController(StudentView view) {
        this.view = view;
    }

    void addStudent(int id, String name, int age) {
        students.add(new Student(id, name, age));
        System.out.println("✅ Student added successfully!");
    }

    void showAll() {
        view.displayAll(students);
    }
}

// MAIN APP
public class StudentMVC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentView view = new StudentView();
        StudentController controller = new StudentController(view);

        while (true) {
            System.out.println("\n=== Student Management System ===");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    System.out.print("Enter Name: ");
                    String name = sc.next();
                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();
                    controller.addStudent(id, name, age);
                    break;

                case 2:
                    controller.showAll();
                    break;

                case 3:
                    System.out.println("Bye 👋");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
