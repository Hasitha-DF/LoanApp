package org.example.dao;

import org.apache.log4j.Logger;
import org.example.entities.LogRecord;
import org.example.exception.DataNotFoundException;
import org.example.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.validation.ConstraintViolationException;
import javax.ws.rs.NotAuthorizedException;
import java.sql.SQLException;

public class LogDAO {

    private static final Logger logger = Logger.getLogger(LogDAO.class);

    public void saveLog(LogRecord logRecord) {
        logger.info("Starting .saveLog to save a log record");
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        session.save(logRecord);
        transaction.commit();

    }

    public void deleteLog(int id) throws DataNotFoundException {
        logger.info("Starting .deleteLog to delete a log by id");
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        LogRecord logRecord = session.get(LogRecord.class, id);
        session.delete(logRecord);
    }

    public LogRecord getLog(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return session.get(LogRecord.class, id);
    }

}
