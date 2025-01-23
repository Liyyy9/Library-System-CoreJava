package Model;

public class Staff extends Members {
    private String role;

    public Staff() {
        super();
    }

    public Staff(String name, String email, String role) {
        super(name, email);
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
