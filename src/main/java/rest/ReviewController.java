package rest;

import facades.ReviewFacade;
import dtos.ReviewDTO;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/review")
public class ReviewController {
    private ReviewFacade facade = new ReviewFacade();

    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createReview(ReviewDTO reviewDTO) {
        // Konverter ReviewDTO til Review og kald facade.createReview()
        return Response.ok().build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getReview(@PathParam("id") int id) {
        // Hent anmeldelsen med facade.getReviewById()
        return Response.ok().build();
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllReviews() {
        List<ReviewDTO> reviews = facade.getAllReviews(); // Brug facaden til at hente alle anmeldelser
        return Response.ok(reviews).build();
    }

    @PUT
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateReview(ReviewDTO reviewDTO) {
        // Opdater anmeldelsen
        return Response.ok().build();
    }

    @DELETE
    @Path("/delete/{id}")
    public Response deleteReview(@PathParam("id") int id) {
        // Slet anmeldelsen
        return Response.ok().build();
    }
}
