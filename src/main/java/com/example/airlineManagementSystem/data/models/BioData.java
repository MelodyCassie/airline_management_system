package com.example.airlineManagementSystem.data.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
@Entity
@Data
public class BioData {
    @Id
    private Long id;
    private String password;
    private String emailAddress;
    private boolean login;
    private String phoneNumber;

}
