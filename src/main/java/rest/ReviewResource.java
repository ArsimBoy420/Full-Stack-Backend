package rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/reviews")  // Definerer stien for denne REST-ressource
public class ReviewResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)  // Angiver at svaret er i JSON-format
    public String getAllReviews() {
        // Din logik til at hente anmeldelser
        return "[{\"reviewID\": 1, \"score\": 5}]";  // Eksempel
    }
}
