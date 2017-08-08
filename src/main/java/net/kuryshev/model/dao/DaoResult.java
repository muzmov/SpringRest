package net.kuryshev.model.dao;

import net.kuryshev.model.entity.Status;
import net.kuryshev.model.entity.User;

public class DaoResult {
    Status status;
    User user;

    public DaoResult(Status status, User user) {
        this.status = status;
        this.user = user;
    }

    public DaoResult() {
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
