package entities;

public class Login {
    private int loginID;
    private String email;
    private String password;

    // Constructors, getters, setters, and auth method
    public Login() {}

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

    public boolean auth() {
        // Logic for authentication (usually, this would involve hashing passwords)
        return true;
    }
}
