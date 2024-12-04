package org.example.dao;

import org.example.entities.Client;
import org.example.entities.SavingsAccount;
import org.example.entities.LoanType;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SavingsDAO {

    private static final Logger logger = LoggerFactory.getLogger(SavingsDAO.class);

    public Boolean generatedAccountNumberExists(String accNo) {
        logger.info("Starting .generatedAccountNumberExists to check if the account number exists");
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String existsASavingAccQuery = "SELECT COUNT(sa) FROM SavingsAccount sa WHERE sa.accountNumber = :accNo";
            Long count = session.createQuery(existsASavingAccQuery, Long.class)
                    .setParameter("accNo", accNo)
                    .uniqueResult();
            return count > 0;
        }
    }

    public SavingsAccount getSavingsAcc(int id) {
        logger.info("Starting .getSavingsAcc to fetch savings account by id");
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(SavingsAccount.class, id);
        }
    }

    public void saveSavingsAccount(SavingsAccount savingsAccount) {
        logger.info("Starting .saveSavingsAccount to save savings account");
        Transaction transaction = null;
        LoanType loanType = new LoanType();
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(savingsAccount);
            session.save(loanType);
            transaction.commit();
            logger.info("Savings account and associated loan type saved successfully");
        }
    }

    public Boolean clientHaveSavingsAcc(Client client) {
        logger.info("Stating .clientHaveSavingsAcc to check if client has a savings account");

        try (Session session = HibernateUtil.getSessionFactory().openSession();) {
            String existsASavingAccQuery = "SELECT COUNT(sa) FROM SavingsAccount sa WHERE sa.client = :client";
            Query<Long> query = session.createQuery(existsASavingAccQuery, Long.class);
            query.setParameter("client", client);
            Long count = query.uniqueResult();
            if (count > 0) {
                logger.info("Sorry savings acc already exists!");
            }
            return count > 0;
        }
    }
}
