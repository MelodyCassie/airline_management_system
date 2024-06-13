package com.example.airlineManagementSystem.data.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Entity
@Setter
@Getter
//@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String email;
    private String firstName;
    private String lastName;
//    @OneToOne
//    private BioData bioData;
    private String password;
//    private String userName;
    private String phoneNumber;

//    @Enumerated(EnumType.STRING)
//    private Role role;
//    private String emailAddress;
    private boolean isLogin;
    private LocalDateTime createdAt;








}
