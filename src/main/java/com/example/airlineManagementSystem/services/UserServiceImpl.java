package com.example.airlineManagementSystem.services;

import ch.qos.logback.classic.encoder.JsonEncoder;
import com.example.airlineManagementSystem.data.models.User;
import com.example.airlineManagementSystem.data.repositories.UserRepository;
import com.example.airlineManagementSystem.dtos.request.UserLoginRequest;
import com.example.airlineManagementSystem.dtos.request.UserLogoutRequest;
import com.example.airlineManagementSystem.dtos.request.UserRegisterRequest;
import com.example.airlineManagementSystem.dtos.response.UserLoginResponse;
import com.example.airlineManagementSystem.dtos.response.UserRegistrationResponse;
import com.example.airlineManagementSystem.exceptions.UserException;
import com.example.airlineManagementSystem.utils.ApiResponse;
import com.example.airlineManagementSystem.utils.GenerateApiResponse;
import lombok.AllArgsConstructor;
import org.modelmapper.Converters;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{

//    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private static final ModelMapper mapper = new ModelMapper();


    @Override
    public UserRegistrationResponse register(UserRegisterRequest request) throws UserException {
        boolean isRegistered = userRepository.findByEmail(request.getEmailAddress())!=null;
        if (isRegistered) throw new UserException(GenerateApiResponse.USER_ALREADY_EXIST);
        User user = new User();
        user.setEmail(request.getEmailAddress());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setPhoneNumber(request.getPhoneNumber());
        user.setPassword(request.getPassword());
        user.setCreatedAt(LocalDateTime.now());

        userRepository.save(user);

        UserRegistrationResponse response = new UserRegistrationResponse();
        response.setId(user.getUserId());
        response.setMessage("Registration successful");

        return response;


//        if(userRepository.existsByEmailAddress(request.getEmailAddress())){
//            throw new UserException(GenerateApiResponse.USER_ALREADY_EXIST);
//        }
//        User user = mapper.map(request,User.class);
//        user.setPassword(passwordEncoder.encode(request.getPassword()));
//        userRepository.save(user);

//        return GenerateApiResponse.create(GenerateApiResponse.REGISTRATION_SUCCESSFUL);
    }

    @Override
    public UserLoginResponse login(UserLoginRequest request) throws UserException {
        User existingUser = userRepository.findByEmail(request.getEmail());

        if (existingUser==null) throw new UserException("User not found");

        String password = existingUser.getPassword();

        if (!password.equals(request.getPassword())) throw new UserException("Invalid password");

       existingUser.setLogin(true);

        userRepository.save(existingUser);

        UserLoginResponse response = new UserLoginResponse();
        response.setMessage("Login successful");
        return response;
    }

    @Override
    public void logout(UserLogoutRequest request) throws UserException {
        User existingUser = userRepository.findById(request.getId()).orElse(null);
        if (existingUser == null) throw new UserException("User not found");
        existingUser.setLogin(false);
        userRepository.save(existingUser);
    }

}
