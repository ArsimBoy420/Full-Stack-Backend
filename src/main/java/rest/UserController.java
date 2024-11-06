package rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import dtos.UserDTO;
import facades.UserFacade;

@Path("/user")
public class UserController {
    private UserFacade facade = new UserFacade();

    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createUser(UserDTO userDTO) {
        // Konverter UserDTO til User og kald facade.createUser()
        return Response.ok().build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser(@PathParam("id") int id) {
        // Hent brugeren med facade.getUserById()
        return Response.ok().build();
    }

    @DELETE
    @Path("/delete/{id}")
    public Response deleteUser(@PathParam("id") int id) {
        // Slet brugeren
        return Response.ok().build();
    }
}
