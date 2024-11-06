package entities;

import java.util.Date;

public class Account {
    private int accountID;
    private Date creationDate;

    // Constructors, getters, and setters
    public Account() {}

    public Account(int accountID, Date creationDate) {
        this.accountID = accountID;
        this.creationDate = creationDate;
    }

    public int getAccountID() { return accountID; }
    public void setAccountID(int accountID) { this.accountID = accountID; }
    public Date getCreationDate() { return creationDate; }
    public void setCreationDate(Date creationDate) { this.creationDate = creationDate; }

    // Business logic methods
    public void createAccount(User user, Login login, Review review) {
        // Implementation for creating an account
    }

    public Account getAccount(Login login) {
        // Implementation for retrieving an account
        return this;
    }

    public void updateAccount(User user, Login login) {
        // Implementation for updating an account
    }

    public void deleteAccount(User user, Login login) {
        // Implementation for deleting an account
    }
}
