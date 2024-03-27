package com.example.usermanagement;

import com.example.usermanagement.model.UserModel;
import com.example.usermanagement.repository.UserRepository;
import com.example.usermanagement.service.UserService;
import org.junit.Ignore;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@Ignore
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @Test
    void testCreateUser() {
        // Setup mock repository
        UserModel userModel = new UserModel();
        userModel.setUserId(1);
        userModel.setSurName("xyz");
        userModel.setFirstName("abc");
        userModel.setEmail("abc@gmail.com");

        doReturn(userModel).when(userRepository).save(userModel);

        // Execute the service call
        UserModel returnedUser = userService.createUser(userModel);

        // Assert the response
        Assertions.assertTrue(returnedUser.getUserId().equals(userModel.getUserId()));
        Assertions.assertTrue(returnedUser.getSurName().equals(userModel.getSurName()));
        Assertions.assertTrue(returnedUser.getFirstName().equals(userModel.getFirstName()));
        Assertions.assertTrue(returnedUser.getEmail().equals(userModel.getEmail()));
    }

    @Test
    void testFindBySurName() {
        // Setup mock repository
        UserModel userModel = new UserModel();
        userModel.setUserId(1);
        userModel.setSurName("xyz");
        userModel.setFirstName("abc");
        userModel.setEmail("abc@gmail.com");

        UserModel userModel2 = new UserModel();
        userModel2.setUserId(2);
        userModel2.setSurName("xyz");
        userModel2.setFirstName("anne");
        userModel2.setEmail("anne@gmail.com");

        doReturn(Arrays.asList(userModel, userModel2)).when(userRepository).findBySurName("xyz");

        // Execute the service call
        List<UserModel> returnedUsers = userService.findBySurName("xyz");

        // Assert the response
        Assertions.assertEquals(2, returnedUsers.size());
    }
}
