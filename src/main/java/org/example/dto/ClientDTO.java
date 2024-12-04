package org.example.dto;

import org.example.entities.Client;

public class ClientDTO {

    private String firstname;
    private String lastname;
    private String occupation;
    private String nic;
    private String address;
    private String email;


    public ClientDTO(Client client) {
        this.firstname = client.getFirstname();
        this.lastname = client.getLastname();
        this.occupation = client.getOccupation();
        this.nic = client.getNic();
        this.address = client.getAddress();
        this.email = client.getEmail();
    }

    public String getFirstname() {


        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
