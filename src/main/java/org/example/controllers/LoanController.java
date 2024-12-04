package org.example.controllers;

import org.example.entities.Loan;
import org.example.entities.PaymentPlan;
import org.example.services.LoanServices;
import org.example.services.PaymentServices;
import org.json.JSONObject;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/api/loan")
public class LoanController {

    @POST
    @Path("/apply")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createLoan(Loan loan){
        LoanServices loanServices = new LoanServices();
        JSONObject object = new JSONObject();
        try {
            loanServices.createLoan(loan);
            object.put("Status", "SUCCESS");
            object.put("code", "200");
            object.put("Massage", "Loan created");
            return Response.status(Response.Status.OK).entity(object.toString()).build();
        } catch (Exception e) {
            object.put("Status", "FAILED");
            object.put("Massage", e.getLocalizedMessage());
            return Response.status(Response.Status.OK).entity(object.toString()).build();
        }
    }

    @POST
    @Path("/register-payment")
    @Produces(MediaType.APPLICATION_JSON)
    public Response registerPayment(PaymentPlan paymentPlan){
        PaymentServices paymentServices = new PaymentServices();
        JSONObject object = new JSONObject();
        try {
            paymentServices.savePaymentRecord(paymentPlan);
            object.put("Status", "SUCCESS");
            object.put("code", "200");
            object.put("Massage", "registered Payment ");
            return Response.status(Response.Status.OK).entity(object.toString()).build();
        } catch (Exception e) {
            object.put("Status", "FAILED");
            object.put("Massage", e.getLocalizedMessage());
            return Response.status(Response.Status.OK).entity(object.toString()).build();
        }
    }

    @POST
    @Path("/view-details/payment-plan")
    @Produces(MediaType.APPLICATION_JSON)
    public List<PaymentPlan> viewPaymentPlan(String loanNo){
        return null;
    }
}
