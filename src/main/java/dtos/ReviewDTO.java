package dtos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.Review;

public class ReviewDTO {
    private int reviewID;
    private int score;
    private Date creationDate;
    private String author;
    private String title;
    private String imgURL;
    private String comment;

    // Constructor
    public ReviewDTO(int reviewID, int score, Date creationDate, String author, String title, String imgURL, String comment) {
        this.reviewID = reviewID;
        this.score = score;
        this.creationDate = creationDate;
        this.author = author;
        this.title = title;
        this.imgURL = imgURL;
        this.comment = comment;
    }

    // EntityManagerFactory og getEntityManager()
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("yourPersistenceUnit");

    private static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    // Hent alle anmeldelser og konverter til ReviewDTO
    public static List<ReviewDTO> getAllReviews() {
        EntityManager em = getEntityManager();
        try {
            List<Review> reviews = em.createQuery("SELECT r FROM Review r", Review.class).getResultList();
            List<ReviewDTO> reviewDTOs = new ArrayList<>();
            
            for (Review review : reviews) {
                reviewDTOs.add(new ReviewDTO(
                    review.getReviewID(),
                    review.getScore(),
                    review.getCreationDate(),
                    review.getAuthor(),
                    review.getTitle(),
                    review.getImgURL(),
                    review.getComment()
                ));
            }
            return reviewDTOs;
        } finally {
            em.close();
        }
    }

    // Getters and Setters
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
}
