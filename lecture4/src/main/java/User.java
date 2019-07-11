public class User {
    public String password;
    public String email;

    public User() {
        this.email = "Lera" + System.currentTimeMillis() + "@gmail.com";
        this.password = "password" + System.currentTimeMillis();
    }
}
