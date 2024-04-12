package com.example.airlineManagementSystem.data.models;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String firstName;
    private String lastName;
    @OneToOne
    private BioData bioData;
    private String password;
    private String userName;
    private String phoneNumber;
    private String email;
    @Enumerated(EnumType.STRING)
    private Role role;
    private String emailAddress;
    private boolean isLocked = true;
    private LocalDateTime localDateTime;








}
