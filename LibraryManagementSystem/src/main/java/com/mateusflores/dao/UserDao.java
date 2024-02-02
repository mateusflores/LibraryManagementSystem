/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mateusflores.dao;

import com.mateusflores.entities.User;
import java.util.List;

/**
 *
 * @author mateus
 */
public interface UserDao {
    public User findById(Integer id);
    public List<User> findAll();
    public void createUser(User user);
    public void updateUser(User user);
    public void removeUser(User user);
}
