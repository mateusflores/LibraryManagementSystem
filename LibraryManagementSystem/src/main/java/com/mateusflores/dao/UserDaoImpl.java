/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mateusflores.dao;

import com.mateusflores.entities.User;
import jakarta.persistence.EntityManager;
import java.util.List;

/**
 *
 * @author mateus
 */
public class UserDaoImpl implements UserDao {

    private EntityManager em;

    public UserDaoImpl() {
        em = DaoUtil.getEntityManagerFactory().createEntityManager();
    }

    @Override
    public User findById(Integer id) {
        User user = em.find(User.class, id);
        em.close();
        return user;
    }

    @Override
    public List<User> findAll() {
        List<User> list = em.createQuery("SELECT u FROM User u", User.class).getResultList();
        em.close();
        return list;
    }

    @Override
    public void createUser(User user) {
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void updateUser(User user) {
        em.getTransaction().begin();
        em.merge(user);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void removeUser(User user) {
        em.getTransaction().begin();
        User managedUser = em.merge(user);
        em.remove(managedUser);
        em.getTransaction().commit();
        em.close();
    }

}
