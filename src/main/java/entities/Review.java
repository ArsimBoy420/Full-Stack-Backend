package entities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reviewID;
    private int score;
    private Date creationDate;
    private String author;
    private String title;
    private String imgURL;
    private String comment;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    // Constructors, getters, and setters

    public Review() {}

    public Review(int reviewID, int score, Date creationDate, String author, String title, String imgURL, String comment) {
        this.reviewID = reviewID;
        this.score = score;
        this.creationDate = new Date();
        this.author = author;
        this.title = title;
        this.imgURL = imgURL;
        this.comment = comment;

        // Debug information to check if account is correctly set
        System.out.println("Review created with account: " + (account != null ? account.getAccountID() : "No account set"));
    }

    public int getReviewID() { return reviewID; }
    public void setReviewID(int reviewID) { this.reviewID = reviewID; }
    public int getScore() { return score; }
    public void setScore(int score) { this.score = score; }
    public Date getCreationDate() { return creationDate; }
    public void setCreationDate(Date creationDate) { this.creationDate = creationDate; }
    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getImgURL() { return imgURL; }
    public void setImgURL(String imgURL) { this.imgURL = imgURL; }
    public String getComment() { return comment; }
    public void setComment(String comment) { this.comment = comment; }

    public void createReview() { 
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/sql_store?" +
            "user=root&password=ali1234");
            Statement statement = conn.createStatement();
            int rs = statement.executeUpdate("INSERT INTO sql_store.customers (customer_id, first_name, last_name, birth_date,"
            +"phone, address, city, state, points) VALUES (11, 'Ali', 'Khan', '1988-12-13', '23432432', 'some address',"+
            " 'some city', 'DK', 23432)");
            System.out.println(rs);

            
        }catch(Exception err)
        {
            System.out.println(err);
        }
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
