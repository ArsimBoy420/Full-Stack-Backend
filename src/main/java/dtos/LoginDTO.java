package dtos;

public class LoginDTO {
    private int loginID;
    private String email;
    private String password;

    // Constructor
    public LoginDTO(int loginID, String email, String password) {
        this.loginID = loginID;
        this.email = email;
        this.password = password;
    }

    // Getters and Setters
    public int getLoginID() {
        return loginID;
    }

    public void setLoginID(int loginID) {
        this.loginID = loginID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
