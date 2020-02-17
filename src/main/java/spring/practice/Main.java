package spring.practice;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.practice.config.AppConfig;
import spring.practice.model.User;
import spring.practice.service.UserService;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = context.getBean(UserService.class);
        User user = new User();
        user.setEmail("user1@gmail.com");
        user.setPassword("Password1");
        userService.add(user);
        user.setEmail("user2@gmail.com");
        user.setPassword("Password2");
        userService.add(user);

        userService.getListOfUsers().forEach(System.out::println);
    }
}
