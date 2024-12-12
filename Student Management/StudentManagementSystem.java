import java.util.*;

public class StudentManagementSystem {
    private Map<Integer, Student> students;

    public StudentManagementSystem() {
        students = new HashMap<>();
    }

    // Add a new student
    public void addStudent(int id, String name, int age) {
        students.put(id, new Student(id, name, age));
    }

    // Display all students
    public void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students to display.");
            return;
        }

        List<Student> studentList = new ArrayList<>(students.values());
        studentList.sort(Comparator.comparing(Student::getName)); // Sort by name

        for (Student student : studentList) {
            System.out.println(student);
        }
    }

    // Search a student by ID
    public Student searchStudentById(int id) {
        return students.get(id);
    }

    // Remove a student by ID
    public void removeStudent(int id) {
        students.remove(id);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManagementSystem sms = new StudentManagementSystem();

        while (true) {
            System.out.println("\n1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Remove Student by ID");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter student ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter student age: ");
                    int age = scanner.nextInt();
                    sms.addStudent(id, name, age);
                    break;

                case 2:
                    sms.displayStudents();
                    break;

                case 3:
                    System.out.print("Enter student ID to search: ");
                    id = scanner.nextInt();
                    Student student = sms.searchStudentById(id);
                    if (student != null) {
                        System.out.println("Student found: " + student);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter student ID to remove: ");
                    id = scanner.nextInt();
                    sms.removeStudent(id);
                    System.out.println("Student removed.");
                    break;

                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
