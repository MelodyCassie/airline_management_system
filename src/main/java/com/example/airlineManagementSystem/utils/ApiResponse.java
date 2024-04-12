package com.example.airlineManagementSystem.utils;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Builder
@Data
public class ApiResponse {
    private HttpStatus httpStatus;
    private int statusCode;
    private boolean isSuccessful;
    private Object data;

}
