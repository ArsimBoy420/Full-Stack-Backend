package facades;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.Review;

public class ReviewFacade {

    public Review createReview(int score, String author, String title, String imgURL, String comment) {
        Review review = new Review(0, score, new Date(), author, title, imgURL, comment);
        // Tilføj kode til at gemme anmeldelsen i databasen
        return review;
    }

    public Review getReviewById(int reviewID) {
        // Logik til at hente en anmeldelse baseret på ID
        return new Review(); // Dummy return - erstattes med reel forespørgsel
    }

    public List<Review> getAllReviews() {
        // Logik til at hente alle anmeldelser fra databasen
        return new ArrayList<>(); // Dummy return
    }

    public void updateReview(Review review) {
        // Logik til at opdatere en anmeldelse
    }

    public void deleteReview(int reviewID) {
        // Logik til at slette en anmeldelse
    }
}
