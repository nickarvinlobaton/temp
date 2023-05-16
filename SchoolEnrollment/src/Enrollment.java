import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Enrollment {
    private static HashMap<Integer, Student> students = new HashMap<Integer, Student>();
    private static HashMap<Integer, Teacher> teachers = new HashMap<Integer, Teacher>();
    private static HashMap<String, Subject> subjects = new HashMap<String, Subject>();
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        showMenu();

    }

    public static void showMenu() {
        // Menu
        System.out.println("=========Enrollment System============");
        System.out.println("1. Enroll Students");
        System.out.println("2. Print All Students List");
        System.out.println("3. Add a Teacher");
        System.out.println("4. List All Teachers");
        System.out.println("5. Add a Subject");
        System.out.println("6. List All Subjects");
        System.out.println("7. Assign a Teacher to a Subject");
        System.out.println("8. Add a Student to Subject");
        System.out.println("9. Delete Student Record");
        System.out.println("10. Delete Teacher Record");
        System.out.println("11. Exit");
        System.out.println("Enter a number to select from the menu.");

        int mode = in.nextInt();
        in.nextLine();

        switch (mode) {
            case 1:
                enrollStudents();
                break;
            case 2:
                listAllStudents();
                break;
            case 3:
                addTeacher();
                break;
            case 4:
                listAllTeachers();
                break;
            case 5:
                addSubject();
                break;
            case 6:
                listSubjects();
                break;
            case 7:
                assignTeacherToSubject();
                break;
            case 8:
                addStudentToSubject();
                break;
            case 9:
                deleteStudent();
                break;
            case 10:
                deleteTeacher();
                break;
            case 11:
                in.close();
                System.exit(0);
                break;
            default:
                showMenu();
                break;
        }
    }

    public static void addSubject() {
        System.out.println("Enter Subject name:");
        String subjectName = in.nextLine();

        subjects.put(subjectName, new Subject(subjectName));
        System.out.println("Added new subject: " + subjectName);

        showMenu();
    }

    public static void listSubjects() {
        if (subjects == null) {
            System.out.println("No subjects added.");
            showMenu();
            return;
        }
        for(Map.Entry<String, Subject> entry : subjects.entrySet()) {
            String key = entry.getKey();
            Subject value = entry.getValue();

            value.printData();
        }
        showMenu();
    }

    public static void assignTeacherToSubject() {
        System.out.println("Enter Subject Name:");
        String subjectName = in.nextLine();
        if (!subjects.containsKey(subjectName)) {
            System.out.println("No subject with name of " + subjectName + " found.");
            showMenu();
            return;
        }

        System.out.println("Enter Teacher ID:");
        int teacherId = in.nextInt();
        in.nextLine();

        if (!teachers.containsKey(teacherId)) {
            System.out.println("No teacher with ID of " + teacherId + " found.");
            showMenu();
            return;
        }

        Subject subject = subjects.get(subjectName);
        Teacher teacher = teachers.get(teacherId);
        subject.setTeacher(teacher);

        System.out.println("Assigned " + teacher.getFullName() + " to " + subjectName + " subject.");
        showMenu();
    }

    public static void addStudentToSubject() {
        System.out.println("Enter Subject Name:");
        String subjectName = in.nextLine();
        if (!subjects.containsKey(subjectName)) {
            System.out.println("No subject with name of " + subjectName + " found.");
            showMenu();
            return;
        }

        System.out.println("Enter Student ID:");
        int studentId = in.nextInt();
        in.nextLine();

        if (!students.containsKey(studentId)) {
            System.out.println("No student with ID of " + studentId + " found.");
            showMenu();
            return;
        }

        Subject subject = subjects.get(subjectName);
        Student student = students.get(studentId);
        subject.addStudent(studentId, student);


        System.out.println("Enrolled " + student.getFullName() + " to " + subjectName + " subject.");
        showMenu();
    }

    public static void addTeacher() {
        System.out.println("How many teachers do you wish to add?");
        int length = in.nextInt();
        in.nextLine();

        for(int i=0; i < length; i++) {
            System.out.println("Enter firstname:");
            String firstName = in.nextLine();
            System.out.println("Enter lastname:");
            String lastName = in.nextLine();
            System.out.println("Enter age:");
            int age = in.nextInt();
            System.out.println("Enter teacherId:");
            int teacherId = in.nextInt();
            in.nextLine();
            System.out.println("Enter position:");
            String position = in.nextLine();
            System.out.println("Next teacher...");

            User user = new User(firstName, lastName, age);
            Teacher teacher = new Teacher(user, teacherId, position);
            teachers.put(teacherId, teacher);
        }

        showMenu();
    }

    public static void deleteTeacher() {
        System.out.println("Enter teacherId:");
        int teacherId = in.nextInt();
        in.nextLine();

        if (!teachers.containsKey(teacherId)) {
            System.out.println("Teacher id not found.");
            showMenu();
            return;
        }

        Teacher teacher = teachers.get(teacherId);

        teachers.remove(teacherId);
        for(Map.Entry<String, Subject> entry : subjects.entrySet()) {
            Subject subject = entry.getValue();

            if (subject.getTeacher().getTeacherId() == teacherId) {
                subject.removeTeacher();
            }
        }

        System.out.println("Deleted teacher: " + teacher.getFullName());
        showMenu();
    }

    public static void listAllTeachers() {
        if (teachers == null) {
            System.out.println("No Teachers enrolled.");
            showMenu();
            return;
        }
        for(Map.Entry<Integer, Teacher> entry : teachers.entrySet()) {
            int key = entry.getKey();
            Teacher value = entry.getValue();

            System.out.println(key + ": " + value.getData());
        }
        showMenu();
    }

    public static void enrollStudents() {
        System.out.println("How many students do you wish to enroll?");
        int length = in.nextInt();
        in.nextLine();

        for(int i=0; i < length; i++) {
            System.out.println("Enter firstname:");
            String firstName = in.nextLine();
            System.out.println("Enter lastname:");
            String lastName = in.nextLine();
            System.out.println("Enter age:");
            int age = in.nextInt();
            System.out.println("Enter studentId:");
            int studentId = in.nextInt();
            in.nextLine();
            System.out.println("Enter year:");
            String year = in.nextLine();
            System.out.println("Enter course:");
            String course = in.nextLine();
            System.out.println("Next student...");

            User user = new User(firstName, lastName, age);
            Student student = new Student(user, studentId, year, course);
            students.put(studentId, student);
        }

        showMenu();
    }

    public static void listAllStudents() {
        if (students == null) {
            System.out.println("No Students enrolled.");
            showMenu();
            return;
        }
        for(Map.Entry<Integer, Student> entry : students.entrySet()) {
            int key = entry.getKey();
            Student value = entry.getValue();

            System.out.println(key + ": " + value.getData());
        }
        showMenu();
    }

    public static void deleteStudent() {
        System.out.println("Enter studentId:");
        int studentId = in.nextInt();
        in.nextLine();

        if (!students.containsKey(studentId)) {
            System.out.println("Student id not found.");
            showMenu();
            return;
        }

        Student student = students.get(studentId);

        students.remove(studentId);
        for(Map.Entry<String, Subject> entry : subjects.entrySet()) {
            Subject subject = entry.getValue();
            subject.removeStudent(studentId);
        }

        System.out.println("Deleted student: " + student.getFullName());
        showMenu();
    }
}
