package com.example.airlineManagementSystem.data.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Admin {
    @Id
    private Long id;
    private String firstName;
    private String lastName;
    @OneToOne
    private BioData bioData;
    private String phoneNumber;
    private String emailAddress;
    private String password;
    private boolean login;
    @Enumerated(EnumType.STRING)
    private Role role;



}
