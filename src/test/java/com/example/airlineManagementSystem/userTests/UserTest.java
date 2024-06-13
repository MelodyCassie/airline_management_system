package com.example.airlineManagementSystem.userTests;

import com.example.airlineManagementSystem.data.models.User;
import com.example.airlineManagementSystem.data.repositories.UserRepository;
import com.example.airlineManagementSystem.dtos.request.UserLoginRequest;
import com.example.airlineManagementSystem.dtos.request.UserLogoutRequest;
import com.example.airlineManagementSystem.dtos.request.UserRegisterRequest;
import com.example.airlineManagementSystem.dtos.response.UserLoginResponse;
import com.example.airlineManagementSystem.dtos.response.UserRegistrationResponse;
import com.example.airlineManagementSystem.exceptions.UserException;
import com.example.airlineManagementSystem.services.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
public class UserTest {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @Test
    public void testThatUserCanRegister() throws UserException {
        UserRegisterRequest request = new UserRegisterRequest();
        request.setFirstName("Melody");
        request.setLastName("Oluchi");
        request.setPassword("password12*");
        request.setEmailAddress("melody@gmail.com");
        request.setPhoneNumber("08174936593");

        UserRegistrationResponse response = userService.register(request);
        assertThat(response).isNotNull();


//        ApiResponse apiResponse = userService.register(request);
//        assertEqual(userService.register(request).getStatusCode(),ApiResponse(GenerateApiResponse.setStatusCode()));
//        assertNotNull(apiResponse);


    }

    @Test
    public void testThatARegisteredUserCanLogin() throws UserException {
        UserLoginRequest request = new UserLoginRequest();
        request.setEmail("melody@gmail.com");
        request.setPassword("password12*");
        UserLoginResponse response = userService.login(request);
        assertThat(response).isNotNull();

    }

    @Test
    public void testThatARegisteredUserCanLogout() throws UserException {
        UserLogoutRequest request = new UserLogoutRequest();
        request.setId(1L);

        userService.logout(request);

        User user = userRepository.findById(request.getId()).orElse(null);
        if (user==null) throw new UserException("User not found");
        assertFalse(user.isLogin());

    }
}
