package com.spring;


import com.spring.config.AppConfig;
import com.spring.model.Car;
import com.spring.model.User;
import com.spring.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;
import java.util.List;

public class App {


    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

//        userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
//        userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
//        userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
//        userService.add(new User("User4", "Lastname4", "user4@mail.ru"));

        User user1 = new User("User1", "Lastname1", "user1@mail.ru");
        User user2 = new User("User2", "Lastname2", "user2@mail.ru");
        User user3 = new User("User3", "Lastname3", "user2@mail.ru");

        Car car1 = new Car("Model 1", 1);
        Car car2 = new Car("Model 2", 2);
        Car car3 = new Car("Model 3", 3);

        userService.addUserAndCar(user1, car1);
        userService.addUserAndCar(user2, car2);
        userService.addUserAndCar(user3, car3);

        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println("His car: " + user.getCar().toString());
            System.out.println();
        }

        User user = userService.getUserByModelAndSeriesHisCar("Model 2", 2);

        System.out.println("User who ones car: ");
        System.out.println("Id = " + user.getId());
        System.out.println("First Name = " + user.getFirstName());
        System.out.println("Last Name = " + user.getLastName());
        System.out.println("Email = " + user.getEmail());
        System.out.println();

        context.close();
    }
}
