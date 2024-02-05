package model.dao;

import model.entities.User;

import java.util.Map;

public interface UserDao {
    public User findById(Integer id);
    public Map<Integer, User> findAll();
    public void create(User user);
    public User update(User user);
    public void delete(User user);
}
