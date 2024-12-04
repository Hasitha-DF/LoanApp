package org.example.entities;


import javax.persistence.*;

@Entity
@Table(name = "loan_type" , schema = "Loans")
public class LoanType {

    @Id
    @Column(name = "user_id")
    private int loanTypeId;

    @Column(name = "car")
    private Boolean carLoan;

    @Column(name = "jewellery")
    private Boolean jewelleryLoan;

    @Column(name = "education")
    private Boolean educationLoan;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private Client client;

//    public String getLoanTypeId() {
//        return loanTypeId;
//    }
//
//    public void setLoanTypeId(String loanTypeId) {
//        this.loanTypeId = loanTypeId;
//    }

    public Boolean getCarLoan() {
        return carLoan;
    }

    public void setCarLoan(Boolean carLoan) {
        this.carLoan = carLoan;
    }

    public Boolean getJewelleryLoan() {
        return jewelleryLoan;
    }

    public void setJewelleryLoan(Boolean jewelleryLoan) {
        this.jewelleryLoan = jewelleryLoan;
    }

    public Boolean getEducationLoan() {
        return educationLoan;
    }

    public void setEducationLoan(Boolean educationLoan) {
        this.educationLoan = educationLoan;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
