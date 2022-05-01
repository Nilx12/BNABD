package com.example.bikerentalservice.model;

import javax.persistence.*;

@Entity
@Table(name = "client_data")
public class ClientData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "client_data_id")
    private Long id;
    @Column(name = "firstname")
    private String firstname;
    @Column(name = "lastname")
    private String lastname;
    @Column(name = "email")
    private String email;
    @Column(name = "card_number")
    private String card_number;

    @OneToOne()
    @JoinColumn(name = "address_id")
    private Address address;

    public ClientData(String firstname, String lastname, String email, String card_number, Address address) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.card_number = card_number;
        this.address = address;
    }

    public ClientData() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCard_number() {
        return card_number;
    }

    public void setCard_number(String card_number) {
        this.card_number = card_number;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
