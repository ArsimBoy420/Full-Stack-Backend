package dtos;

import entities.User;

public class UserDTO {
    private int userID;
    private String username;
    private String firstname;
    private String lastname;

    // Constructor med alle felter
    public UserDTO(int userID, String username, String firstname, String lastname) {
        this.userID = userID;
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    // Constructor til at oprette fra User entitet
    public UserDTO(User user) {
        if (user != null) {
            this.userID = user.getUserID();
            this.username = user.getUsername();
            this.firstname = user.getFirstname();
            this.lastname = user.getLastname();
        }
    }

    // Konverter til User entitet (fx til brug i facaden)
    public User toEntity() {
        User user = new User();
        user.setUsername(this.username);
        user.setFirstname(this.firstname);
        user.setLastname(this.lastname);
        return user;
    }

    // Getters og Setters
    public int getUserID() { return userID; }
    public void setUserID(int userID) { this.userID = userID; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getFirstname() { return firstname; }
    public void setFirstname(String firstname) { this.firstname = firstname; }
    public String getLastname() { return lastname; }
    public void setLastname(String lastname) { this.lastname = lastname; }
}
