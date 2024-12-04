package org.example.services;

import org.example.dao.PaymentDAO;
import org.example.entities.PaymentPlan;
import org.example.exception.DataNotFoundException;
import org.example.Utilities.AccountNumberGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class PaymentServices {

    private static final Logger logger = LoggerFactory.getLogger(PaymentServices.class);

    public void savePaymentRecord(PaymentPlan paymentPlan) {
        PaymentDAO paymentDAO = new PaymentDAO();
        logger.info("Starting .savePaymentRecord in PaymentServices");
        if (paymentPlan == null) {
            throw new IllegalArgumentException("Payment plan cannot be null");
        } else if (!paymentPlan.getInstallmentId().isEmpty()) {
            throw new IllegalArgumentException("User cannot define payment id");
        } else {
            paymentPlan.setInstallmentId(AccountNumberGenerator.generatePaymentId());
            paymentDAO.savePaymentRecord(paymentPlan);
            logger.info("Payment record saved successfully through PaymentServices");
        }
    }

    public PaymentPlan getPaymentRecord(String PaymentNo) throws DataNotFoundException {
        PaymentDAO paymentDAO = new PaymentDAO();
        logger.info("Starting .getPaymentRecord in PaymentServices");
        PaymentPlan paymentPlan = paymentDAO.getPaymentRecord(PaymentNo);
        if (paymentPlan == null) {
            throw new DataNotFoundException("Payment record not found for id " + PaymentNo);
        }else return paymentPlan;

    }

    public void updatePaymentRecord(PaymentPlan paymentPlan) {
        PaymentDAO paymentDAO = new PaymentDAO();
        logger.info("Starting .updatePaymentRecord in PaymentServices");
        if (paymentPlan == null) {
            throw new IllegalArgumentException("Payment plan cannot be null");
        }else if(paymentPlan.getInstallmentId()==null){
            throw new IllegalArgumentException("No plan found under the id "+paymentPlan.getInstallmentId());
        } else {
            paymentDAO.updatePaymentRecord(paymentPlan);
            logger.info("Payment record updated successfully through PaymentServices");
        }

    }

    public List<PaymentPlan> getPayRecords() throws DataNotFoundException {
        PaymentDAO paymentDAO = new PaymentDAO();
        logger.info("Starting .getPayRecords in PaymentServices");
        List<PaymentPlan> paymentPlans = paymentDAO.getPayRecords();
        if (paymentPlans == null || paymentPlans.isEmpty()) {
            throw new DataNotFoundException("No data found!");
        }else return paymentPlans;
    }
}
