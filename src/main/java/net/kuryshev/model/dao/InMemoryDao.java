package net.kuryshev.model.dao;

import net.kuryshev.model.Data;
import net.kuryshev.model.entity.Status;
import net.kuryshev.model.entity.User;

public class InMemoryDao implements Dao {
    private Data dataInstance = Data.getInstance();

    @Override
    public Status addUser(User user) {
        if (dataInstance.addUser(user)) return new Status("ok");
        else return new Status("user wasn't added");
    }

    @Override
    public Status deleteUser(String email) {
        User user = dataInstance.searchByEmail(email);
        if (!user.equals(User.EMPTY_USER)) {
            dataInstance.deleteUser(user);
            return new Status("ok");
        }
        else
            return new Status("not found");
    }

    @Override
    public DaoResult searchByEmail(String email) {
        User foundUser = dataInstance.searchByEmail(email);
        if (foundUser.equals(User.EMPTY_USER)) return new DaoResult(new Status("not found"), foundUser);
        else return new DaoResult(new Status("ok"), foundUser);
    }
}
