package facades;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dtos.ReviewDTO;
import entities.Review;

public class ReviewFacade {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("yourPersistenceUnit");

    // Opretter en EntityManager
    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public ReviewDTO createReview(int reviewID, Date creationDate, int score, String author, String title, String imgURL, String comment) {
        // Tilføj kode til at gemme anmeldelsen i databasen
        Review review = new Review(reviewID, score, creationDate, author, title, imgURL, comment);
        EntityManager em = getEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(review); // Gem anmeldelsen i databasen
            em.getTransaction().commit();
        } finally {
            em.close();
        }

        // Returner en ReviewDTO i stedet for Review
        return new ReviewDTO(
            review.getReviewID(),
            review.getScore(),
            review.getCreationDate(),
            review.getAuthor(),
            review.getTitle(),
            review.getImgURL(),
            review.getComment()
        );
    }

    public ReviewDTO getReviewById(int reviewID) {
        EntityManager em = getEntityManager();
        try {
            Review review = em.find(Review.class, reviewID); // Hent anmeldelse baseret på ID
            if (review != null) {
                // Returner en ReviewDTO i stedet for Review
                return new ReviewDTO(
                    review.getReviewID(),
                    review.getScore(),
                    review.getCreationDate(),
                    review.getAuthor(),
                    review.getTitle(),
                    review.getImgURL(),
                    review.getComment()
                );
            } else {
                return null;
            }
        } finally {
            em.close();
        }
    }

    public List<ReviewDTO> getAllReviews() {
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

    public void updateReview(ReviewDTO reviewDTO) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            // Hent den eksisterende anmeldelse
            Review review = em.find(Review.class, reviewDTO.getReviewID());
            if (review != null) {
                review.setScore(reviewDTO.getScore());
                review.setCreationDate(reviewDTO.getCreationDate());
                review.setAuthor(reviewDTO.getAuthor());
                review.setTitle(reviewDTO.getTitle());
                review.setImgURL(reviewDTO.getImgURL());
                review.setComment(reviewDTO.getComment());
                em.merge(review); // Opdater anmeldelsen i databasen
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void deleteReview(int reviewID) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            Review review = em.find(Review.class, reviewID);
            if (review != null) {
                em.remove(review); // Slet anmeldelsen fra databasen
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}
