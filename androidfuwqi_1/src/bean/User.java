package bean;

public class User {
    private int id;
    private String username;
    private String password;
    private String school;

    public User(int id, String username, String password, String school) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.school = school;
    }

    public User() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSchool() {
        return this.school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

}
