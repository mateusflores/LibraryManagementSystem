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
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 *
 * @author mateus
 */
@Entity
@Table(name = "Borrowing")
public class Borrowing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToMany(mappedBy = "user")
    private User user;
    @ManyToMany
    @JoinTable(
        name = "borrowed_book",
        joinColumns = @JoinColumn(name = "borrow_id"),
        inverseJoinColumns = @JoinColumn(name = "book_id")
    )
    private Map<Integer, Book> borrowedBooks = new HashMap<>();
    private LocalDate borrowingDate;
    private LocalDate borrowingDeadline;

    public Borrowing() {
    }

    public Borrowing(User user, LocalDate borrowingDate, LocalDate borrowingDeadline) {
        this.user = user;
        this.borrowingDate = borrowingDate;
        this.borrowingDeadline = borrowingDeadline;
    }

    public Integer getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Map<Integer, Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void addBorrowedBook(Book book) {
        this.borrowedBooks.put(book.getId(), book);
    }
    
    public void removeBorrowedBook(Integer id) {
        if (this.borrowedBooks.containsKey(id)) {
            this.borrowedBooks.remove(id);
        } else {
            System.out.println("Can't remove borrowed book.");
        }
    }

    public LocalDate getBorrowingDate() {
        return borrowingDate;
    }

    public void setBorrowingDate(LocalDate borrowingDate) {
        this.borrowingDate = borrowingDate;
    }

    public LocalDate getBorrowingDeadline() {
        return borrowingDeadline;
    }

    public void setBorrowingDeadline(LocalDate borrowingDeadline) {
        this.borrowingDeadline = borrowingDeadline;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.id);
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
        final Borrowing other = (Borrowing) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Borrowing{" + "id=" + id + ", user=" + user + ", borrowedBooks=" + borrowedBooks + ", borrowingDate=" + borrowingDate + ", borrowingDeadline=" + borrowingDeadline + '}';
    }

}
