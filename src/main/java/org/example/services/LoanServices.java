package org.example.services;


import org.example.Utilities.AccountNumberGenerator;
import org.example.dao.LoanDAO;
import org.example.dao.LoanTypeDAO;
import org.example.entities.Loan;
import org.example.entities.LoanType;
import org.example.exception.DataNotFoundException;
import org.example.exception.RecordAlreadyExsistException;
import org.example.exception.RequestArgumentsNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoanServices {
    static Logger logger = LoggerFactory.getLogger(LoanServices.class);

    public boolean loanExists(int id, String type) throws RequestArgumentsNotFoundException {
        LoanType loanType = new LoanType();
        LoanDAO loanDAO = new LoanDAO();
        LoanTypeDAO loanTypeDAO = new LoanTypeDAO();
        logger.info("checking if user have a loan of type {}", type);
        loanType = loanTypeDAO.getLoanType(id);
        if (loanType != null && type.equalsIgnoreCase("car")) {
            return ifNull(loanType.getCarLoan());
        } else if (loanType != null && type.equalsIgnoreCase("jewellery")) {
            return ifNull(loanType.getJewelleryLoan());
        } else if (loanType != null && type.equalsIgnoreCase("education"))
            return ifNull(loanType.getEducationLoan());
        else throw new RequestArgumentsNotFoundException("User doesn't have a savings account ");
    }


    public boolean ifNull(Boolean bool) {
        if (bool == null) {
            bool = false;
        }
        return bool;
    }

    public void createLoan(Loan loan) throws RequestArgumentsNotFoundException, DataNotFoundException, RecordAlreadyExsistException {
        LoanDAO loanDAO = new LoanDAO();
        LoanTypeServices loanTypeServices = new LoanTypeServices();
        LoanType loanType = loanTypeServices.getLoanType(loan.getUserId());
        //checks if there's a loan to the specific user and the loan type
        if (!loanExists(loan.getClient().getUserId(), loan.getTypeLoan())) {
            logger.info("Eligible");
            loan.setLoanNumber(AccountNumberGenerator.generateLoanId());
            loanDAO.saveLoan(loan);
            switch (loan.getTypeLoan()) {
                case "car":
                    loanType.setCarLoan(true);
                    break;
                case "education":
                    loanType.setEducationLoan(true);
                    break;
                case "jewellery":
                    loanType.setJewelleryLoan(true);
                    break;
                default:
                    logger.info("Wrong loan type");
            }
            logger.info("saving loanType changes");
            loanTypeServices.saveType(loanType);
        }
        else throw new RecordAlreadyExsistException("You have an existing "+loan.getTypeLoan()+" loan ");
    }
}



