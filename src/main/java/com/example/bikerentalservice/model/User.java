package com.example.bikerentalservice.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "hashed_password")
    private String hashedPassword;

    @OneToOne()
    @JoinColumn(name = "client_data_id")
    private ClientData clientData;

    @ManyToOne()
    @JoinColumn(name = "role_id")
    private Role role;

    public User() {
    }

    public User(String username, String hashedPassword, ClientData clientData, Role role) {
        this.username = username;
        this.hashedPassword = hashedPassword;
        this.clientData = clientData;
        this.role = role;
    }

    public Long getId(){
        return id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public ClientData getClientData() {
        return clientData;
    }

    public void setClientData(ClientData clientData) {
        this.clientData = clientData;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

}
