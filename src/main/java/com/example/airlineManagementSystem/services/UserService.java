package com.example.airlineManagementSystem.services;

import com.example.airlineManagementSystem.dtos.request.UserRegisterRequest;
import com.example.airlineManagementSystem.exceptions.UserException;
import com.example.airlineManagementSystem.utils.ApiResponse;

public interface UserService {

    ApiResponse register(UserRegisterRequest userRegisterRequest) throws UserException;


}
