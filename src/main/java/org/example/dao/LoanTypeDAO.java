package org.example.dao;

import org.example.entities.LoanType;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoanTypeDAO {

    private static final Logger logger = LoggerFactory.getLogger(LoanTypeDAO.class);

    public void saveType(LoanType loanType) {
        logger.info("Starting .saveType to save a loan type to the database");
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(loanType);
            transaction.commit();
            logger.info("Loan type saved successfully");
        }

    }


    public void updateType(LoanType loanType) {
        logger.info("Starting .updateType to update a loan type ");
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(loanType);
            transaction.commit();
            logger.info("Loan type saved successfully");
        }

    }

    public LoanType getLoanType(int id) {
        logger.info("Starting .getLoanType to fetch loan type by id {}", id);
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(LoanType.class, id);
        }
    }
}
