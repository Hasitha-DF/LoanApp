package org.example.entities;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Table(name = "loan" ,schema = "Loans")
public class Loan {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "loan_id")
    private int loanId;

    @Column(name = "loan_number")
    private String loanNumber;

    @Column(name = "loan_amount")
    private Double loanAmount;

    @Column(name = "created_at")
    private Time createdAt;

    @Column(name = "acquired_by")
    private String acquiredBy;

    @Column(name = "repayment_method")
    private String repaymentMethod;

    @Column(name = "guarantor_id")
    private Integer guarantorId;

    @Column(name = "type_loan")
    private String typeLoan;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private Client client;

    public String getLoanNumber() {
        return loanNumber;
    }

    public void setLoanNumber(String loanNumber) {
        this.loanNumber = loanNumber;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public int getLoanId() {
        return loanId;
    }

    public void setLoanId(int loanId) {
        this.loanId = loanId;
    }

    public Double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(Double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public Time getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Time createdAt) {
        this.createdAt = createdAt;
    }

    public String getAcquiredBy() {
        return acquiredBy;
    }

    public void setAcquiredBy(String acquiredBy) {
        this.acquiredBy = acquiredBy;
    }

    public String getRepaymentMethod() {
        return repaymentMethod;
    }

    public void setRepaymentMethod(String repaymentMethod) {
        this.repaymentMethod = repaymentMethod;
    }

    public Integer getGuarantorId() {
        return guarantorId;
    }

    public void setGuarantorId(Integer guarantorId) {
        this.guarantorId = guarantorId;
    }

    public int getUserId() {
        return client.getUserId();
    }

    public String getTypeLoan() {
        return typeLoan;
    }

    public void setTypeLoan(String typeLoan) {
        this.typeLoan = typeLoan;
    }
}
