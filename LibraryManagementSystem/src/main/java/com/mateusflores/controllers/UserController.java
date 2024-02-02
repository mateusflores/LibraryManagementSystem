/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mateusflores.controllers;

import com.mateusflores.dao.UserDao;
import com.mateusflores.dao.UserDaoImpl;
import com.mateusflores.entities.User;
import java.util.List;

/**
 *
 * @author mateus
 */
public class UserController {
    private UserDao dao;
    
    public UserController() {
        dao = new UserDaoImpl();
    }
    
    public User findById(Integer id) {
        return dao.findById(id);
    }
    
    public List<User> findAll() {
        return dao.findAll();
    }
    
    public void createUser(User user) {
        dao.createUser(user);
    }
    
    public void updateUser(User user) {
        dao.updateUser(user);
    }
    
    public void deleteUser(User user) {
        dao.removeUser(user);
    }
    
}
