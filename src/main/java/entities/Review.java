package entities;

import java.util.Date;

public class Review {
    private int reviewID;
    private int score;
    private Date creationDate;
    private String author;
    private String title;
    private String imgURL;
    private String comment;

    // Constructors, getters, and setters
    public Review() {}

    public Review(int reviewID, int score, Date creationDate, String author, String title, String imgURL, String comment) {
        this.reviewID = reviewID;
        this.score = score;
        this.creationDate = creationDate;
        this.author = author;
        this.title = title;
        this.imgURL = imgURL;
        this.comment = comment;
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

    public void createReview() {}
    public Review getReview(int reviewID) { return this; }
    public void updateReview(int reviewID) {}
}
