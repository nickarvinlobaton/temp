import java.util.HashMap;

public class User {
    private String firstName;
    private String lastName;
    private int age;

    public User(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public HashMap<String, Object> getData() {
        HashMap<String, Object> data = new HashMap<String, Object>();
        data.put("firstname", this.firstName);
        data.put("lastName", this.lastName);
        data.put("age", this.age);
        return data;
    }

    public String getFullName() {
        return this.getFirstName() + ' ' + this.getLastName();
    }

}
