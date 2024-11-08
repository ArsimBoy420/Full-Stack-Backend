package rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/users")  // Definerer stien for denne REST-ressource
public class UserResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)  // Angiver at svaret er i JSON-format
    public String getAllUsers() {
        // Din logik til at hente brugere
        return "[{\"username\": \"user1\"}, {\"username\": \"user2\"}]";  // Eksempel
    }
}
