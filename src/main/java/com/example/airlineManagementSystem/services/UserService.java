package com.example.airlineManagementSystem.services;

import com.example.airlineManagementSystem.dtos.request.UserLoginRequest;
import com.example.airlineManagementSystem.dtos.request.UserLogoutRequest;
import com.example.airlineManagementSystem.dtos.request.UserRegisterRequest;
import com.example.airlineManagementSystem.dtos.response.UserLoginResponse;
import com.example.airlineManagementSystem.dtos.response.UserRegistrationResponse;
import com.example.airlineManagementSystem.exceptions.UserException;
import com.example.airlineManagementSystem.utils.ApiResponse;

public interface UserService {


    UserRegistrationResponse register(UserRegisterRequest request) throws UserException;

    UserLoginResponse login(UserLoginRequest request) throws UserException;

    void logout(UserLogoutRequest request) throws UserException;
}
