import java.util.HashMap;
import java.util.Objects;

public class Student {
    private User user;
    private int studentId;
    private String year;
    private String course;
    public Student(User user, int studentId, String year, String course) {
        this.user = user;
        this.studentId = studentId;
        this.year = year;
        this.course = course;
    }

    HashMap<String, Object> getData() {
        HashMap<String, Object> data = new HashMap<String, Object>();
        data.put("studentId", this.studentId);
        data.put("year", this.year);
        data.put("course", this.course);
        data.putAll(this.user.getData());

        return data;
    }

    public String getFullName() {
        return this.user.getFullName();
    }
}
