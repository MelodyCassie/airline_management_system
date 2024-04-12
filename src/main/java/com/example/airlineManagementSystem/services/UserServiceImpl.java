package com.example.airlineManagementSystem.services;

import com.example.airlineManagementSystem.data.models.User;
import com.example.airlineManagementSystem.data.repositories.UserRepository;
import com.example.airlineManagementSystem.dtos.request.UserLoginRequest;
import com.example.airlineManagementSystem.dtos.request.UserRegisterRequest;
import com.example.airlineManagementSystem.exceptions.UserException;
import com.example.airlineManagementSystem.utils.ApiResponse;
import com.example.airlineManagementSystem.utils.GenerateApiResponse;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;


    @Override
    public ApiResponse register(UserRegisterRequest userRegisterRequest) throws UserException {
        if(checkIfUserExist(userRegisterRequest.getEmailAddress())){
            throw new UserException(GenerateApiResponse.USER_ALREADY_EXIST);
        }
        User user = modelMapper.map(userRegisterRequest, User.class);
        userRepository.save(user);
        return GenerateApiResponse.create(GenerateApiResponse.REGISTRATION_SUCCESSFUL);
    }

    private boolean checkIfUserExist(String emailAddress) {
        User user = userRepository.findByEmailAddress(emailAddress);
        return user != null;
    }
    ApiResponse login(UserLoginRequest userLoginRequest){
        User user = userRepository.findByEmailAddress()


        return null ;
    }
}
