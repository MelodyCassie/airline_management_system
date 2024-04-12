package com.example.airlineManagementSystem.dtos.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class UserRegisterRequest {
   @NotBlank
   @NotEmpty
    private String firstName;
   @NotBlank
   @NotEmpty
    private String lastName;
   @NotBlank
   @NotEmpty
    private String emailAddress;
    @NotBlank
    @NotEmpty
    private String phoneNumber;
    @NotBlank
    @NotEmpty
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[!@#$%^&*])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}$")
    private String password;
}
