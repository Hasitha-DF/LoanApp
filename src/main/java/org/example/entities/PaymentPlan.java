package org.example.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "payment_plan", schema = "Loans")
public class PaymentPlan {

    @Id
    @Column(name = "installment_id")
    private String installmentId;

    @Column(name = "installment_date")
    private Date installmentDate;

    @Column(name = "installment_method")
    private String installmentMethod;

    @Column(name = "installment_time")
    private Date installmentTime;

    @Column(name = "installment_amount")
    private Double installmentAmount;

    @Column(name = "installment_status")
    private String installmentStatus;

    @Column(name = "outstanding_loan")
    private Double outstandingLoan;

    @Column(name = "loan_id" , updatable = false,insertable = false)
    private int loanId;

    @ManyToOne
    @JoinColumn( name = "loan_id", referencedColumnName = "loan_id" )
    private Loan loan;

    public String getInstallmentId() {
        return installmentId;
    }

    public void setInstallmentId(String installmentId) {
        this.installmentId = installmentId;
    }

    public Date getInstallmentDate() {
        return installmentDate;
    }

    public void setInstallmentDate(Date installmentDate) {
        this.installmentDate = installmentDate;
    }

    public String getInstallmentMethod() {
        return installmentMethod;
    }

    public void setInstallmentMethod(String installmentMethod) {
        this.installmentMethod = installmentMethod;
    }

    public Date getInstallmentTime() {
        return installmentTime;
    }

    public void setInstallmentTime(Date installmentTime) {
        this.installmentTime = installmentTime;
    }

    public Double getInstallmentAmount() {
        return installmentAmount;
    }

    public void setInstallmentAmount(Double installmentAmount) {
        this.installmentAmount = installmentAmount;
    }

    public String getInstallmentStatus() {
        return installmentStatus;
    }

    public void setInstallmentStatus(String installmentStatus) {
        this.installmentStatus = installmentStatus;
    }

    public Double getOutstandingLoan() {
        return outstandingLoan;
    }

    public void setOutstandingLoan(Double outstandingLoan) {
        this.outstandingLoan = outstandingLoan;
    }

    public int getLoanId() {
        return loanId;
    }



}

