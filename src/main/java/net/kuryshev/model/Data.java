package net.kuryshev.model;

import net.kuryshev.model.entity.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Data {
    private static Data instance;
    private  List<User> users;

    private Data() {
        users = new ArrayList<>();
        users.add(new User("firstName", "secondName" , "email", "password", LocalDate.of(1992, 8, 4)));
        users.add(new User("firstName1", "secondName1" , "email1", "password1", LocalDate.of(1992, 8, 14)));
        users.add(new User("firstName2", "secondName2" , "email2", "password1", LocalDate.of(1992, 8, 24)));
    }

    public static synchronized Data getInstance() {
        if (instance == null) instance = new Data();
        return instance;
    }

    public synchronized boolean addUser(User user) {
        if (User.EMPTY_USER.equals(searchByEmail(user.getEmail()))) return users.add(user);
        else return false;
    }

    public synchronized boolean deleteUser(User user) {
        return users.remove(user);
    }

    public synchronized User searchByEmail(String email) {
        for (User user : users) {
            if (user.getEmail().equals(email)) return user;
        }
        return User.EMPTY_USER;
    }
}
