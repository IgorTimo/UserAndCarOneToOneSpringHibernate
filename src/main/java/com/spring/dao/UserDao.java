package com.spring.dao;

import com.spring.model.Car;
import com.spring.model.User;

import java.util.List;

public interface UserDao {
    void add(User user);
    List<User> listUsers();
    void addUserAndCar(User user, Car car);
    User getUserByModelAndSeriesHisCar(String model, int series);
}
