package org.example.entities;


import javax.persistence.*;

@Entity
@Table(name = "log_record", schema = "Loans")
public class LogRecord {


    @Id
    private int userId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private Client client;


    @Column(name = "log_status")
    private Boolean logStatus;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
    public Boolean getLogStatus() {
        return logStatus;
    }

    public void setLogStatus(Boolean logStatus) {
        this.logStatus = logStatus;
    }

    public int getUserId() {
        return client.getUserId();
    }

}
