package facades;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManagerFactory;

import dtos.AccountDTO;
import dtos.LoginDTO;
import dtos.ReviewDTO;
import dtos.UserDTO;
import utils.EMF_Creator;

public class Populator {

    public static void populate() {
        EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();
        AccountFacade accountFacade = AccountFacade.getFacadeExample(emf);

        // Opretter UserDTO'er
        UserDTO user1 = new UserDTO(1, "user1", "First 1", "Last 1");
        UserDTO user2 = new UserDTO(2, "user2", "First 2", "Last 2");
        UserDTO user3 = new UserDTO(3, "user3", "First 3", "Last 3");

        // Opretter LoginDTO'er for brugere
        LoginDTO login1 = new LoginDTO(1, "user1@example.com", "password1");
        LoginDTO login2 = new LoginDTO(2, "user2@example.com", "password2");
        LoginDTO login3 = new LoginDTO(3, "user3@example.com", "password3");

        // Opretter ReviewDTO'er for anmeldelser
        List<ReviewDTO> reviews1 = Arrays.asList(
            new ReviewDTO(1, 5, new Date(), "user1", "Amazing experience!", "imgURL1", "Great service and food!")
        );
        List<ReviewDTO> reviews2 = Arrays.asList(
            new ReviewDTO(2, 4, new Date(), "user2", "Good experience", "imgURL2", "Nice ambiance and friendly staff.")
        );
        List<ReviewDTO> reviews3 = Arrays.asList(
            new ReviewDTO(3, 3, new Date(), "user3", "Average experience", "imgURL3", "Food was okay, but a bit pricey.")
        );

        // Opretter AccountDTO'er og tilføjer dem til facaden
        AccountDTO account1 = new AccountDTO(1, new Date(), user1, login1, reviews1); // Tilføjer creationDate
        AccountDTO account2 = new AccountDTO(2, new Date(), user2, login2, reviews2); // Tilføjer creationDate
        AccountDTO account3 = new AccountDTO(3, new Date(), user3, login3, reviews3); // Tilføjer creationDate

        accountFacade.createAccount(account1);
        accountFacade.createAccount(account2);
        accountFacade.createAccount(account3);
    }

    public static void main(String[] args) {
        populate();
    }
}
