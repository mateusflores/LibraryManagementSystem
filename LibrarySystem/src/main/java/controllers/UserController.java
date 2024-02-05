package controllers;

import model.dao.UserDao;
import model.daoImpl.UserDaoImpl;
import model.entities.User;

import java.util.Map;

public class UserController {
    private final UserDao dao;

    public UserController() {
        this.dao = new UserDaoImpl();
    }

    public User findById(Integer id) {
        return dao.findById(id);
    }

    public Map<Integer, User> findAll() {
        return dao.findAll();
    }

    public void createUser(User user) {
        dao.create(user);
    }

    public User updateUser(User user) {
        return dao.update(user);
    }

    public void removeUser(User user) {
        dao.delete(user);
    }

}
