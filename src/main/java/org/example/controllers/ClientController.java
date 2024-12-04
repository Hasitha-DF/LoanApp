package org.example.controllers;

import io.swagger.annotations.ApiOperation;
import org.example.dao.ClientDAO;
import org.example.dto.ClientDTO;
import org.example.entities.Client;
import org.example.exception.DataNotFoundException;
import org.example.exception.RecordAlreadyExsistException;
import org.example.exception.RequestArgumentsNotFoundException;
import org.example.exception.RequestNotAuthroizedException;
import org.example.services.ClientServices;
import org.example.services.SavingsServices;
import org.hibernate.HibernateException;
import org.json.JSONException;
import org.json.JSONObject;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Path("/api/clients")
public class ClientController {


    @POST
    @Path("/register")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createClient(Client client) {
        ClientServices clientServices = new ClientServices();
        ClientDAO clientDAO = new ClientDAO();
        JSONObject object = new JSONObject();
        try {
            clientServices.saveClient(client);
            object.put("Status", "SUCCESS");
            object.put("code", "200");
            object.put("Massage", "User registered");
            return Response.status(Response.Status.OK).entity(object.toString()).build();
        } catch (RuntimeException | RequestArgumentsNotFoundException e) {
            object.put("Status", "Failed");
            object.put("Massage", e.getLocalizedMessage());
            return Response.status(Response.Status.BAD_REQUEST).entity(object.toString()).build();
        }

    }

    @PUT
    @Path("/update-client")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateClient(Client client) {
        ClientServices clientServices = new ClientServices();
        try {
            JSONObject object = new JSONObject();
            clientServices.updateClient(client);
            object.put("Status", "SUCCESS");
            object.put("code", "200");
            object.put("Massage", "Client Updated");
            return Response.status(Response.Status.OK).entity(object.toString()).build();
        } catch (RequestArgumentsNotFoundException | DataNotFoundException e) {
            JSONObject object = new JSONObject();
            object.put("Status", "FAILED");
            object.put("Massage", e.getLocalizedMessage());
            return Response.status(Response.Status.EXPECTATION_FAILED).entity(object.toString()).build();
        }
    }

    @POST
    @Path("/new-savings-account")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createSavingsAccount(Client client) {
        SavingsServices savingsServices = new SavingsServices();
        try {
            JSONObject object = new JSONObject();
            savingsServices.saveSavingsAccount(client.getUserId());
            object.put("Status", "SUCCESS");
            object.put("code", "200");
            object.put("Massage", "User registered");
            return Response.status(Response.Status.OK).entity(object.toString()).build();
        } catch (RecordAlreadyExsistException | RequestNotAuthroizedException | DataNotFoundException e) {
            JSONObject object = new JSONObject();
            object.put("Status", "FAILED");
            object.put("Massage", e.getLocalizedMessage());
            return Response.status(Response.Status.EXPECTATION_FAILED).entity(object.toString()).build();
        }
    }

    @GET
    @Path("/view/client")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getClient(@QueryParam("id") int id) {
        try {
            ClientServices clientServices = new ClientServices();
            ClientDTO clientDTO = new ClientDTO(clientServices.getClient(id));
            JSONObject object = new JSONObject();
            object.put("Status", "SUCCESS");
            object.put("code", "200");
            object.put("Client", new JSONObject(clientDTO));
            return Response.status(Response.Status.OK).entity(object.toString()).build();
        } catch (DataNotFoundException | RequestNotAuthroizedException e) {
            JSONObject object = new JSONObject();
            object.put("Status", "FAILED");
            object.put("Massage", e.getLocalizedMessage());
            return Response.status(Response.Status.EXPECTATION_FAILED).entity(object.toString()).build();
        }
    }


    @GET
    @Path("/view/all-clients")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllClients(@QueryParam("id") int id) {
        ClientServices clientServices = new ClientServices();
        try {
            List<Client> clients = clientServices.getAllClients(id);
            JSONObject object = new JSONObject();
            object.put("Status", "SUCCESS");
            object.put("code", "200");
            object.put("Clients", new JSONObject(clients));
            return Response.status(Response.Status.OK).entity(object.toString()).build();
        } catch (DataNotFoundException | RequestNotAuthroizedException e) {
            JSONObject object = new JSONObject();
            object.put("Status", "FAILED");
            object.put("Massage", e.getLocalizedMessage());
            return Response.status(Response.Status.EXPECTATION_FAILED).entity(object.toString()).build();
        }
    }
}
