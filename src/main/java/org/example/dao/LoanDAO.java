package org.example.dao;

import org.example.entities.Loan;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoanDAO {

    private static final Logger logger = LoggerFactory.getLogger(LoanDAO.class);

    public void saveLoan(Loan loan) {
        logger.info("Starting .saveLoan to save a loan to the database");
        Transaction transaction;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(loan);
            transaction.commit();
            logger.info("Loan saved successfully");
        }
    }
}
