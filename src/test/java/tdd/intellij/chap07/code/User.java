package tdd.intellij.chap07.code;

public class User {

    private String id;
    private String pw;
    private String email;

    public User(){} // Default Cons

    public User(String id) {
        this.id = id;
    }

    public User(String id, String pw) {
        this.id = id;
        this.pw = pw;
    }

    public User(String id, String pw, String email) {
        this.id = id;
        this.pw = pw;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getPw() {
        return pw;
    }

    public String getEmail() {
        return email;
    }
}
