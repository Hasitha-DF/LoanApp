package org.example.services;

import org.example.Utilities.AccountNumberGenerator;
import org.example.dao.SavingsDAO;
import org.example.entities.LoanType;
import org.example.entities.SavingsAccount;
import org.example.exception.DataNotFoundException;
import org.example.exception.RecordAlreadyExsistException;
import org.example.exception.RequestNotAuthroizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.ConstraintViolationException;

public class SavingsServices {

    private static final Logger logger = LoggerFactory.getLogger(SavingsServices.class);

    public void saveSavingsAccount(int id) throws DataNotFoundException, RecordAlreadyExsistException, RequestNotAuthroizedException {
        LoanTypeServices loanTypeServices = new LoanTypeServices();
        LoanType loanType = new LoanType();
        SavingsDAO savingsDAO = new SavingsDAO();
        ClientServices clientServices = new ClientServices();
        SavingsAccount savingsAccount = new SavingsAccount();
        logger.info("Starting .saveSavingsAccount in SavingsService");
        String accNo;

        try {
            do{
                accNo = AccountNumberGenerator.generateAccountNumber();
            } while ((savingsDAO.generatedAccountNumberExists(accNo)));
            logger.info("new acc No generated -{}",accNo);
            logger.info("checking if user {} have a already exisisint acc no",id);
            if (!savingsDAO.clientHaveSavingsAcc(clientServices.getClient(id))){
                logger.info("user have saving acc = false");
                savingsAccount.setClient(clientServices.getClient(id));
                savingsAccount.setAccountNumber(accNo);
                logger.info("assinging a loan type");
                loanType.setClient(savingsAccount.getClient());
                logger.info("saving loan type");
                loanTypeServices.saveType(loanType);
                logger.info("saving new acc number to use   {}",id);
                savingsDAO.saveSavingsAccount(savingsAccount);
                logger.info("Savings account created successfully");
            }else throw new RecordAlreadyExsistException("User already have a savings account");
        } catch (RequestNotAuthroizedException | RecordAlreadyExsistException e) {
            throw e;
        }

    }

    public SavingsAccount getSavingsAcc(int id) throws DataNotFoundException {
        SavingsDAO savingsDAO = new SavingsDAO();
        logger.info("Starting .getSavingsAcc in SavingsService");
        SavingsAccount savingsAccount = savingsDAO.getSavingsAcc(id);

        if (savingsAccount == null) {
            throw new DataNotFoundException("Savings account not found for id " + id);
        }else return savingsAccount;
    }



}
