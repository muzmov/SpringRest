package net.kuryshev.controller;

import net.kuryshev.model.*;
import net.kuryshev.model.dao.Dao;
import net.kuryshev.model.dao.DaoResult;
import net.kuryshev.model.dao.InMemoryDao;
import net.kuryshev.model.entity.Status;
import net.kuryshev.model.entity.User;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
public class MainController {

    Dao dao = new InMemoryDao();

    @RequestMapping("/search")
    public DaoResult getUser(@RequestParam(value = "email") String email) {
        return dao.searchByEmail(email);
    }

    @RequestMapping("/add")
    public Status addUser(@RequestParam(value = "name") String name, @RequestParam(value = "surname") String surname,
                          @RequestParam(value = "email") String email, @RequestParam(value = "password") String password,
                          @RequestParam(value = "date") String date) {
        String[] dateParts = date.split("_");
        LocalDate localDate;
        try {
            int day = Integer.parseInt(dateParts[0]);
            int month = Integer.parseInt(dateParts[1]);
            int year = Integer.parseInt(dateParts[2]);
            localDate = LocalDate.of(year, month, day);
        } catch (NumberFormatException e) {
            localDate = LocalDate.now();
        }
        User user = new User(name, surname, email, PasswordUtils.hash(password), localDate);
        return dao.addUser(user);
    }

    @RequestMapping("/delete")
    public Status deleteUser(@RequestParam(value = "email") String email) {
        return dao.deleteUser(email);
    }
}