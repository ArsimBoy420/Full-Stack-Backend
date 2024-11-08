package dtos;

import java.util.Date;
import java.util.List;

public class AccountDTO {
    private int accountID;
    private Date creationDate;
    private UserDTO user;
    private LoginDTO login;
    private List<ReviewDTO> reviews; // Tilføjelse af reviews

    // Constructor
    public AccountDTO(int accountID, Date creationDate, UserDTO user, LoginDTO login, List<ReviewDTO> reviews) {
        this.accountID = accountID;
        this.creationDate = creationDate;
        this.user = user;
        this.login = login;
        this.reviews = reviews;
    }

    // Getters and Setters
    public int getAccountID() { return accountID; }
    public void setAccountID(int accountID) { this.accountID = accountID; }
    
    public Date getCreationDate() { return creationDate; }
    public void setCreationDate(Date creationDate) { this.creationDate = creationDate; }

    public UserDTO getUser() { return user; }
    public void setUser(UserDTO user) { this.user = user; }

    public LoginDTO getLogin() { return login; }
    public void setLogin(LoginDTO login) { this.login = login; }

    public List<ReviewDTO> getReviews() { return reviews; }
    public void setReviews(List<ReviewDTO> reviews) { this.reviews = reviews; }
}
