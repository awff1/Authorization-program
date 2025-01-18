public class User {
    public String password;
    public String login;
    public Role role;

    public User(String password, String login, Role role) {
        this.login = login;
        this.password = password;
        this.role = role;
    }
}