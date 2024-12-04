package org.example.dao;

import org.example.entities.Client;
import org.example.util.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ClientDAO {
    Logger logger = LoggerFactory.getLogger(ClientDAO.class);

    public void saveClient(Client client) {
        logger.info("Starting .saveClient(Client) to save a client to database");
        Transaction transaction ;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(client);
            transaction.commit();
        }

    }

    public Client getClient(int id) {
        logger.info("starting .getClient(int) to get a client by id");
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Client.class, id);
        }
    }

    public void updateClient(Client client) {
        logger.info("stating .updateClient(Client) to update the client with new client attributes provided via client ");
        Transaction transaction;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(client);
            transaction.commit();
        }
    }

    public List<Client> getClients(int id) {
        logger.info("starting .getClients to get all the clients the is available in the database");
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Client", Client.class).list();

        }

    }
}

