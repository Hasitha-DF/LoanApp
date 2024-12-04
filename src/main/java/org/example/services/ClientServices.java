package org.example.services;

import org.example.dao.ClientDAO;
import org.example.entities.Client;
import org.example.exception.DataNotFoundException;
import org.example.exception.RequestNotAuthroizedException;
import org.example.exception.RequestArgumentsNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ClientServices {

    Logger logger = LoggerFactory.getLogger(ClientServices.class);

    public void updateClient(Client client1) throws RequestArgumentsNotFoundException, DataNotFoundException {
        ClientDAO clientDAO = new ClientDAO();
        int id = client1.getUserId();
        Client client0 = clientDAO.getClient(id);
        if (id < 0) {
            throw new RequestArgumentsNotFoundException("User " + id + " isnt an existing user!");
        } else {
            if (null == clientDAO.getClient(id)) {
                throw new DataNotFoundException("User not found!");
            } else {

                if (client1.getFirstname() != null && !client1.getFirstname().isEmpty()) {
                    client0.setFirstname(client1.getFirstname());
                }
                if (client1.getLastname() != null && !client1.getLastname().isEmpty()) {
                    client0.setLastname(client1.getLastname());
                }
                if (client1.getOccupation() != null && !client1.getOccupation().isEmpty()) {
                    client0.setOccupation(client1.getOccupation());
                }
                if (client1.getAddress() != null && !client1.getAddress().isEmpty()) {
                    client0.setAddress(client1.getAddress());
                }
                if (client1.getEmail() != null && !client1.getEmail().isEmpty()) {
                    client0.setEmail(client1.getEmail());
                }
                if (client1.getPassword() != null && !client1.getPassword().isEmpty()) {
                    client0.setPassword(client1.getPassword());
                }
                if (client1.getNic() != null && !client1.getNic().isEmpty()) {
                    client0.setNic(client1.getNic());
                }

                clientDAO.updateClient(client0);
            }

        }
    }

    public void saveClient(Client client) throws RequestArgumentsNotFoundException {
        logger.info("Starting .saveClient(Client) to save a client to database");
        ClientDAO clientDAO = new ClientDAO();
        if (client.getUserId() > 0) {
            throw new RuntimeException("user Id is an auto assigned value , " +
                    "if u want to update an existing use pls use Update Endpoint ");
        } else if (client.getNic() == null) {
            throw new RequestArgumentsNotFoundException("Empty or invalid NIC");
        } else {
            clientDAO.saveClient(client);
        }

    }

    public List<Client> getAllClients(int id) throws DataNotFoundException, RequestNotAuthroizedException {
        ClientAuthenticate clientAuthenticate = new ClientAuthenticate();
        ClientDAO clientDAO = new ClientDAO();
        if (clientAuthenticate.logStatus(id)) {
            return clientDAO.getClients(id);
        } else throw new RequestNotAuthroizedException("user not authorized to view this data");

    }

    public Client getClient(int id) throws DataNotFoundException, RequestNotAuthroizedException {
        ClientAuthenticate clientAuthenticate = new ClientAuthenticate();
        ClientDAO clientDAO = new ClientDAO();
        if (clientAuthenticate.logStatus(id)) {
            return clientDAO.getClient(id);
        } else throw new RequestNotAuthroizedException("user not authorized to view this data");


    }
}


