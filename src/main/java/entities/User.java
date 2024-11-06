package entities;

public class User {
    private int userID;
    private String username;
    private String firstname;
    private String lastname;

    // Constructors, getters, and setters
    public User() {}

    public User(int userID, String username, String firstname, String lastname) {
        this.userID = userID;
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public int getUserID() { return userID; }
    public void setUserID(int userID) { this.userID = userID; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getFirstname() { return firstname; }
    public void setFirstname(String firstname) { this.firstname = firstname; }
    public String getLastname() { return lastname; }
    public void setLastname(String lastname) { this.lastname = lastname; }
}
