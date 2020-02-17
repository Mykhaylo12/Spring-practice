package spring.practice.controllers;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.practice.dto.UserResponseDto;
import spring.practice.model.User;
import spring.practice.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/inject")
    public String inject() {
        User user = new User();
        user.setEmail("user1@gmail.com");
        user.setPassword("Password1");
        userService.add(user);
        user.setEmail("user2@gmail.com");
        user.setPassword("Password2");
        userService.add(user);
        user.setEmail("user3@gmail.com");
        user.setPassword("Password3");
        userService.add(user);
        user.setEmail("user4@gmail.com");
        user.setPassword("Password4");
        userService.add(user);
        return "Four users were injected";
    }

    @GetMapping("/get/{userId}")
    public UserResponseDto getByUserId(@PathVariable Long userId) {
        User user = userService.getUsersbyId(userId);
        return new UserResponseDto(user.getEmail(), user.getPassword());
    }

    @GetMapping("/")
    List<UserResponseDto> getAll() {
        List<UserResponseDto> listOfDtoUsers = new ArrayList<>();
        List<User> listOfUsers = userService.getListOfUsers();
        listOfUsers.forEach(u -> new UserResponseDto(u.getEmail(), u.getPassword()));
        return listOfDtoUsers;
    }
}
