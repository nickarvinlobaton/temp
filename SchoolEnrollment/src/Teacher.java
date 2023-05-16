import java.util.HashMap;

public class Teacher {
    private User user;
    private int teacherId;
    private String position;

    public Teacher(User user, int teacherId, String position) {
        this.user = user;
        this.teacherId = teacherId;
        this.position = position;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public String getPosition() {
        return position;
    }

    public HashMap<String, Object> getData() {
        HashMap<String, Object> data = new HashMap<String, Object>();

        data.put("teacherId", this.teacherId);
        data.put("position", this.position);
        data.putAll(this.user.getData());

        return data;
    }

    public String getFullName() {
        return this.user.getFullName();
    }
}
