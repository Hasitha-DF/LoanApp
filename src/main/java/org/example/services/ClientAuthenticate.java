package org.example.services;

import org.example.dao.ClientDAO;
import org.example.dao.LogDAO;
import org.example.entities.Client;
import org.example.entities.LogRecord;
import org.example.exception.DataNotFoundException;
import org.hibernate.HibernateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.security.auth.login.CredentialException;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.NotAuthorizedException;
import java.util.Objects;

public class ClientAuthenticate {
    ClientDAO clientDAO = new ClientDAO();
    Logger logger = LoggerFactory.getLogger(ClientAuthenticate.class);

    public void logIn(int id, String password) throws DataNotFoundException, CredentialException {
        LogRecord logRecord = new LogRecord();
        ClientAuthenticate clientAuthenticate = new ClientAuthenticate();
        LogDAO logDAO = new LogDAO();
            Client client = clientDAO.getClient(id);
        if (clientDAO.getClient(id) == null) {
            throw new DataNotFoundException("Client with user id " + id + " not available");
        } else if(clientAuthenticate.logStatus(id)!=null){
            throw new HibernateException("user already logged in");
        }
            logRecord.setClient(client);
            logRecord.setLogStatus(true);
            logDAO.saveLog(logRecord);

    }

    public void logOut(int id) throws DataNotFoundException {
        LogRecord logRecord = new LogRecord();
        LogDAO logDAO = new LogDAO();
        logRecord = logDAO.getLog(id);
        if (logRecord != null) {
            logger.info("Log deleted successfully");
            logger.info("Log out -> {}", "SUCCESS");
        } else {
            logger.info("Failed to delete log record");
            throw new DataNotFoundException("Log record not found");
        }

    }

    public Boolean logStatus(int id) throws DataNotFoundException {
        LogDAO logDAO = new LogDAO();
        LogRecord logRecord = new LogRecord();
        logger.info("Checking log status for id -> {} ",id);
        logRecord = logDAO.getLog(id);
        try {
            if (logRecord != null) {
                if (logRecord.getLogStatus()) {
                    logger.info(" user authenticated! ");
                    return logRecord.getLogStatus();
                } else throw new NotAuthorizedException("You need permission to access this information");
            } else {
                throw new DataNotFoundException("Log record not found");
            }
        } catch (NotAuthorizedException | DataNotFoundException e) {
            return null;
        }
    }


}
