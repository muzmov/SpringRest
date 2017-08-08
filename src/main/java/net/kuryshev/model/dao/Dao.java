package net.kuryshev.model.dao;

import net.kuryshev.model.entity.Status;
import net.kuryshev.model.entity.User;

public interface Dao {

   Status addUser(User user);

   Status deleteUser(String email);

   DaoResult searchByEmail(String email);
}
