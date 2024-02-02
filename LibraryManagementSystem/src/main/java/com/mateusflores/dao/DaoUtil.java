/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mateusflores.dao;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 *
 * @author mateus
 */
public class DaoUtil {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("librarymanagementsystem");
    
    public static EntityManagerFactory getEntityManagerFactory() {
        return emf;
    }
    
}
