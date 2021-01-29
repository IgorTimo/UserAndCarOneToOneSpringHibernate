package com.spring.service;

import com.spring.dao.UserDao;
import com.spring.dao.UserDaoImp;
import com.spring.model.Car;
import com.spring.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService{

    @Autowired
    UserDao userDao;

    @Override
    @Transactional
    public void add(User user) {
        userDao.add(user);

    }

    @Override
    @Transactional(readOnly = true)
    public List<User> listUsers() {
        return userDao.listUsers();
    }

    @Override
    @Transactional
    public void addUserAndCar(User user, Car car) {
        userDao.addUserAndCar(user, car);
    }

    @Override
    @Transactional(readOnly = true)
    public User getUserByModelAndSeriesHisCar(String model, int series) {
        return userDao.getUserByModelAndSeriesHisCar(model, series);
    }
}
