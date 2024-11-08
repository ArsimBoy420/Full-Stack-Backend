package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Login {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int loginID;
    private String email;
    private String password;

    // Default constructor required by JPA
    public Login() {}

    // Constructor without loginID for creating new instances (ID will be auto-generated)
    public Login(String email, String password) {
        this.email = email;
        this.password = password;
    }

    // Full constructor (used only if you need to set the ID manually, which is uncommon)
    public Login(int loginID, String email, String password) {
        this.loginID = loginID;
        this.email = email;
        this.password = password;
    }

    public int getLoginID() { return loginID; }
    public void setLoginID(int loginID) { this.loginID = loginID; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public boolean auth(String inputPassword) {
        // Basic placeholder for password authentication logic
        return password.equals(inputPassword);
    }
}
