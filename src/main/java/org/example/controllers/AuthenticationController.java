package org.example.controllers;

import org.apache.log4j.Logger;
import org.example.dao.LogDAO;
import org.example.entities.Client;
import org.example.exception.DataNotFoundException;
import org.example.services.ClientAuthenticate;
import org.hibernate.HibernateException;
import org.json.JSONObject;

import javax.security.auth.login.CredentialException;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/api/auth")
public class AuthenticationController {


    private static final Logger logger = Logger.getLogger(LogDAO.class);

    @POST
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(Client client) {
        ClientAuthenticate authenticate = new ClientAuthenticate();
        LogDAO logDAO = new LogDAO();
        JSONObject object = new JSONObject();
        try {
            authenticate.logIn(client.getUserId(), client.getPassword());
            object.put("Status", "SUCCESS");
            object.put("code", "200");
            object.put("Massage", "User Logged In");
            return Response.status(Response.Status.OK).entity(object.toString()).build();
        } catch (DataNotFoundException | CredentialException | HibernateException e) {
            object.put("Status", "FAILED");
            object.put("Massage", e.getLocalizedMessage());
            return Response.status(Response.Status.OK).entity(object.toString()).build();
        }

    }

    @DELETE
    @Path("/logout")
    @Produces(MediaType.APPLICATION_JSON)
    public Response logout(@QueryParam("id") int id) {
        JSONObject object = new JSONObject();
        ClientAuthenticate clientAuthenticate = new ClientAuthenticate();
        try {
            clientAuthenticate.logOut(id);
            object.put("Status", "SUCCESS");
            object.put("Massage", "Logged out");
            return Response.status(Response.Status.OK).entity(object.toString()).build();
        } catch (DataNotFoundException e) {
            object.put("Status", "FAILED");
            object.put("Massage", e.getLocalizedMessage());
            return Response.status(Response.Status.NOT_FOUND).entity(object.toString()).build();
        }
    }
}
