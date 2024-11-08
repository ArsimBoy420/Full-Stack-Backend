package facades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import dtos.AccountDTO;
import dtos.LoginDTO;
import dtos.ReviewDTO;
import dtos.UserDTO;
import entities.Account;
import entities.Login;
import entities.Review;
import entities.User;

public class AccountFacade {

    private static AccountFacade instance;
    private static EntityManagerFactory emf;

    private AccountFacade() {}

    public static AccountFacade getFacadeExample(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new AccountFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public AccountDTO createAccount(AccountDTO accountDTO) {
        EntityManager em = getEntityManager();
        Account account = new Account();

        try {
            em.getTransaction().begin();

            // Konverterer UserDTO til User entitet
            User user = new User(accountDTO.getUser().getUsername(), accountDTO.getUser().getFirstname(), accountDTO.getUser().getLastname());
            em.persist(user);

            // Konverterer LoginDTO til Login entitet
            Login login = new Login(accountDTO.getLogin().getEmail(), hashPassword(accountDTO.getLogin().getPassword()));
            em.persist(login);

            // Opretter Account med User og Login
            account.setUser(user);
            account.setLogin(login);
            account.setCreationDate(accountDTO.getCreationDate());
            em.persist(account);

            // Gemmer anmeldelser til kontoen
            List<Review> reviews = new ArrayList<>();
            for (ReviewDTO reviewDTO : accountDTO.getReviews()) {
                Review review = new Review(reviewDTO.getReviewID(), reviewDTO.getScore(), reviewDTO.getCreationDate(), reviewDTO.getAuthor(), reviewDTO.getTitle(), reviewDTO.getImgURL(), reviewDTO.getComment());
                review.setAccount(account);
                em.persist(review);
                reviews.add(review);
            }
            account.setReviews(reviews);

            em.getTransaction().commit();

            // Returnerer den nye Account som DTO
            return new AccountDTO(account.getAccountID(), account.getCreationDate(), new UserDTO(user), new LoginDTO(login.getLoginID(), login.getEmail(), login.getPassword()), accountDTO.getReviews());
        } finally {
            em.close();
        }
    }

    public AccountDTO getAccount(int id) {
        EntityManager em = getEntityManager();
        try {
            // Find Account baseret på id
            Account account = em.find(Account.class, id);
            if (account != null) {
                // Hent relevante data fra Account entiteten og konverter dem til DTO'er
                UserDTO userDTO = new UserDTO(account.getUser());  // Konverter User entitet til UserDTO
                
                // Konverter Login entitet til LoginDTO
                LoginDTO loginDTO = new LoginDTO(account.getLogin().getLoginID(), account.getLogin().getEmail(), account.getLogin().getPassword());
    
                // Konverter Review entiteter til ReviewDTO
                List<ReviewDTO> reviewDTOs = new ArrayList<>();
                for (Review review : account.getReviews()) {
                    reviewDTOs.add(new ReviewDTO(review.getReviewID(), review.getScore(), review.getCreationDate(), review.getAuthor(), review.getTitle(), review.getImgURL(), review.getComment()));
                }
        
                // Opret og returner AccountDTO
                return new AccountDTO(account.getAccountID(), account.getCreationDate(), userDTO, loginDTO, reviewDTOs);
            }
            return null; // Hvis account ikke findes
        } finally {
            em.close();
        }
    }
    
    // Placeholder for hashing af password (brug en rigtig hashing-algoritme som BCrypt i produktion)
    private String hashPassword(String password) {
        return "hashed_" + password; // Her bør du tilføje en hashing funktion
    }
}
