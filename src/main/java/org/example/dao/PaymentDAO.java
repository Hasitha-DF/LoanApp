package org.example.dao;

import org.example.entities.PaymentPlan;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class PaymentDAO {

    private static final Logger logger = LoggerFactory.getLogger(PaymentDAO.class);

    public void savePaymentRecord(PaymentPlan paymentPlan) {
        logger.info("Starting .savePaymentRecord to save a payment record to the database");
        Transaction transaction;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(paymentPlan);
            transaction.commit();
            logger.info("Payment record saved successfully");
        }
    }

    public PaymentPlan getPaymentRecord(String PaymentNo) {
        logger.info("Starting .getPaymentRecord to fetch payment record of the paymentNumber - {}", PaymentNo);
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(PaymentPlan.class, PaymentNo);
        }
    }

    public void updatePaymentRecord(PaymentPlan paymentPlan) {
        logger.info("Starting .updatePaymentRecord to update payment record for plan {}", paymentPlan);
        Transaction transaction;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(paymentPlan);
            transaction.commit();
            logger.info("Payment record updated successfully");
        }
    }

    public List<PaymentPlan> getPayRecords() {
        logger.info("Starting .getPayRecords to fetch all payment records");
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from PaymentPlan", PaymentPlan.class).list();

        }
    }
}

