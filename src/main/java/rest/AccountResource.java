package rest;

import dtos.AccountDTO;
import facades.AccountFacade;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.persistence.EntityManagerFactory;
import utils.EMF_Creator;

@Path("account")
public class AccountResource {

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
    private static final AccountFacade FACADE = AccountFacade.getFacadeExample(EMF);

    @POST
    @Path("create")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createAccount(AccountDTO accountDTO) {
        AccountDTO createdAccount = FACADE.createAccount(accountDTO);
        return Response.ok(createdAccount).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAccount(@PathParam("id") int id) {
        AccountDTO account = FACADE.getAccount(id);
        if (account == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Account not found").build();
        }
        return Response.ok(account).build();
    }
}
