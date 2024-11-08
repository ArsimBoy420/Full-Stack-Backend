package entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int accountID;

    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;

    @OneToOne(cascade = CascadeType.ALL)
    private User user;

    @OneToOne(cascade = CascadeType.ALL)
    private Login login;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private List<Review> reviews;

    // Constructors, getters, and setters

    public Account() {}

    public Account(Date creationDate) {
        this.creationDate = creationDate;
    }

    public int getAccountID() { return accountID; }
    public void setAccountID(int accountID) { this.accountID = accountID; }

    public Date getCreationDate() { return creationDate; }
    public void setCreationDate(Date creationDate) { this.creationDate = creationDate; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public Login getLogin() { return login; }
    public void setLogin(Login login) { this.login = login; }

    public List<Review> getReviews() { return reviews; }
    public void setReviews(List<Review> reviews) { this.reviews = reviews; }
}
