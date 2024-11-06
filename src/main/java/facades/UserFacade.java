package facades;

import entities.User;

public class UserFacade {

    public User createUser(String username, String firstname, String lastname) {
        User user = new User(0, username, firstname, lastname); // Dummy id for eksemplet
        // Tilføj kode til at gemme brugeren i databasen
        return user;
    }

    public User getUserById(int userID) {
        // Logik til at hente en bruger baseret på ID
        return new User(); // Dummy return - erstattes med reel forespørgsel
    }

    public void updateUser(User user) {
        // Logik til at opdatere brugerinformationer
    }

    public void deleteUser(int userID) {
        // Logik til at slette en bruger baseret på ID
    }
}
