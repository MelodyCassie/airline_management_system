package com.example.airlineManagementSystem.dtos.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

//@Data

@Setter
@Getter

public class UserLoginRequest {
    private String email;
    private String password;


//    @NotBlank
//    @NotEmpty
//    private String userName;
//    @NotBlank
//    @NotEmpty
//    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$")
//    @Pattern(regexp = "^(?=.*[0-9])(?=.*[!@#$%^&*])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}$")
//    private String password;

}
