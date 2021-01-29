package com.spring.dao;

import com.spring.model.Car;
import com.spring.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public List<User> listUsers() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }

    @Override
    public void addUserAndCar(User user, Car car) {
        user.setCar(car);
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public User getUserByModelAndSeriesHisCar(String model, int series) {
        TypedQuery<Car> query =  sessionFactory.getCurrentSession().createQuery("from Car where model = '" + model + "' and series = " + series);
        Car car = query.getResultList().get(0);
        System.out.println("-------- " + car.toString());
        return car.getUser();
    }
}
