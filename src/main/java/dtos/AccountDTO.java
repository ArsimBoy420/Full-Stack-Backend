package dtos;

import java.util.Date;

public class AccountDTO {
    private int accountID;
    private Date creationDate;
    private UserDTO user;
    private LoginDTO login;

    // Constructor
    public AccountDTO(int accountID, Date creationDate, UserDTO user, LoginDTO login) {
        this.accountID = accountID;
        this.creationDate = creationDate;
        this.user = user;
        this.login = login;
    }

    // Getters and Setters
    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public LoginDTO getLogin() {
        return login;
    }

    public void setLogin(LoginDTO login) {
        this.login = login;
    }
}
