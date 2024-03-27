package com.example.usermanagement;

import com.example.usermanagement.controller.UserController;
import com.example.usermanagement.model.UserModel;
import com.example.usermanagement.service.UserService;
import org.junit.Ignore;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@Ignore
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {

    protected MockMvc mvc;

    @InjectMocks
    UserController userController;

    @Mock
    private UserService userService;

    @Test
    void testCreateUser() {
        // Setup mock repository
        UserModel userModel = new UserModel();
        userModel.setUserId(1);
        userModel.setSurName("xyz");
        userModel.setFirstName("abc");
        userModel.setEmail("abc@gmail.com");

        doReturn(userModel).when(userService).createUser(userModel);

        // Execute the service call
        UserModel returnedUser = userController.createUser(userModel);

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

        List<UserModel> users = Arrays.asList(userModel, userModel2);

        when(userService.findBySurName("xyz")).thenReturn(users);

        // Execute the service call
        List<UserModel> returnedUsers = userController.findBySurName("xyz");

        Assertions.assertEquals(2, returnedUsers.size());
        Assertions.assertEquals(returnedUsers.get(0).getSurName(),userModel.getSurName());
    }
}
