package com.flow.practice2.entity;

import javax.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
  //  @Column(name = "id")
    private final String id;

    private final String email;
    private final String fullAddress;


    public User(String id, String email, String fullAddress) {
        this.id = id;
        this.email = email;
        this.fullAddress = fullAddress;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getFullAddress() {
        return fullAddress;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                ", fullAddress='" + fullAddress + '\'' +
                '}';
    }
}
