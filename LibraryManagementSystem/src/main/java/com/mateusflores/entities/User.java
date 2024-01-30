/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mateusflores.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 *
 * @author mateus
 */
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String email;
    private String phoneNumer;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Map<Integer, Borrowing> borrowingList = new HashMap<>();

    public User() {
    }

    public User(Integer id, String name, String email, String phoneNumer) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumer = phoneNumer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumer() {
        return phoneNumer;
    }

    public void setPhoneNumer(String phoneNumer) {
        this.phoneNumer = phoneNumer;
    }

    public Map<Integer, Borrowing> getBorrowingList() {
        return borrowingList;
    }

    public void addBorrowing(Borrowing borrowing) {
        this.borrowingList.put(borrowing.getId(), borrowing);
    }

    public void removeBorrowing(Integer borrowingId) {
        if (this.borrowingList.containsKey(id)) {
            this.borrowingList.remove(id);
        } else {
            System.out.println("Cant remove borrow. Informed key doesnt exists.");
        }
    }

    @Override
    public String toString() {
        return "Book{" + "id=" + id + ", name=" + name + ", email=" + email + ", phoneNumer=" + phoneNumer + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.id);
        hash = 71 * hash + Objects.hashCode(this.name);
        hash = 71 * hash + Objects.hashCode(this.email);
        hash = 71 * hash + Objects.hashCode(this.phoneNumer);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        return Objects.equals(this.id, other.id);
    }

}
