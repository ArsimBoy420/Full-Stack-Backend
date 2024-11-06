package rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import dtos.UserDTO;
import facades.AccountFacade;

@Path("/account")
public class AccountController {
    private AccountFacade facade = new AccountFacade();

    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createAccount(UserDTO userDTO) {
        // Konverter UserDTO til User og kald facade.createAccount()
        return Response.ok().build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAccount(@PathParam("id") int id) {
        // Hent kontoen med facade.getAccount()
        return Response.ok().build();
    }

    @PUT
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateAccount(UserDTO userDTO) {
        // Opdater konto
        return Response.ok().build();
    }

    @DELETE
    @Path("/delete/{id}")
    public Response deleteAccount(@PathParam("id") int id) {
        // Slet konto
        return Response.ok().build();
    }
}
