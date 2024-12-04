package org.example.entities;


import javax.persistence.*;

@Entity
@Table(name = "savings_account", schema = "loans")
public class SavingsAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="savings_account_id")
    private int id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private Client client;

    @Column(name = "savings_acc_no")
    private String accountNumber;

    public SavingsAccount() {
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getUserId() {
        return client.getUserId();
    }

}
