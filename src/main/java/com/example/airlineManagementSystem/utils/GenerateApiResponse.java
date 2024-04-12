package com.example.airlineManagementSystem.utils;

import org.springframework.http.HttpStatus;

public class GenerateApiResponse {
    public static final String USER_ALREADY_EXIST = "User already exist.";
    public static final String REGISTRATION_SUCCESSFUL = "Registration successful";


    public static ApiResponse create (Object data){
    return ApiResponse.builder()
            .data(data)
            .httpStatus(HttpStatus.CREATED)
            .statusCode(HttpStatus.CREATED.value())
            .isSuccessful(true)

            .build();


    }

}
