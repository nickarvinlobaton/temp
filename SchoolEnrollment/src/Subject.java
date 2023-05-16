import java.util.HashMap;
import java.util.Map;

public class Subject {
    private String subjectName;
    private Teacher teacher;
    private HashMap<Integer, Student> students = new HashMap<Integer, Student>();

    public Subject(String subjectName) {
        this.subjectName = subjectName;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Teacher getTeacher() {
        return this.teacher;
    }

    public void removeTeacher() {
        this.teacher = null;
    }

    public void addStudent(int studentId, Student student) {
        this.students.put(studentId, student);
    }

    public void removeStudent(int studentId) {
        this.students.remove(studentId);
    }

    HashMap<String, Object> getData() {
        HashMap<String, Object> data = new HashMap<String, Object>();
        data.put("subjectName", this.subjectName);
        data.put("teacher", this.teacher);
        data.put("students", this.students);

        return data;
    }

    public void printData() {
        System.out.println("------------");
        System.out.println("subjectName: " + this.subjectName);

        if (this.teacher == null) {
            System.out.println("teacher: Not Assigned yet");
        } else {
            System.out.println("teacher: " + this.teacher.getData());
        }

        if (students == null) {
            System.out.println("No Students enrolled.");
            return;
        }

        System.out.println("Students...");
        for(Map.Entry<Integer, Student> entry : students.entrySet()) {
            int key = entry.getKey();
            Student value = entry.getValue();

            System.out.println(key + ": " + value.getData());
        }
    }
}
