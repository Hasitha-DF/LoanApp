package org.example.services;

import org.example.dao.LoanTypeDAO;
import org.example.entities.LoanType;
import org.example.exception.DataNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoanTypeServices {

    private static final Logger logger = LoggerFactory.getLogger(LoanTypeServices.class);

    public void saveType(LoanType loanType) {
        LoanTypeDAO loanTypeDAO = new LoanTypeDAO();
        LoanType loanTypeOld = loanTypeDAO.getLoanType(loanType.getClient().getUserId());
        logger.info("Starting .saveType in LoanTypeService");
        if (loanType == null) {
            throw new IllegalArgumentException("Loan type cannot be null");
        } else {
            loanTypeDAO.updateType(loanType);
            logger.info("Loan type updated successfully through LoanTypeService");
        }
    }

    public LoanType getLoanType(int id) throws DataNotFoundException {
        LoanTypeDAO loanTypeDAO = new LoanTypeDAO();
        logger.info("Starting .getLoanType in LoanTypeService");
        LoanType loanType = loanTypeDAO.getLoanType(id);
        if (loanType == null) {
            throw new DataNotFoundException("Loan type not found for id " + id);
        } else return loanType;

    }
}
