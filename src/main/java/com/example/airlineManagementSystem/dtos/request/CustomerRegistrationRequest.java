package com.example.airlineManagementSystem.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CustomerRegistrationRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phoneNumber;
    private String address;

}
