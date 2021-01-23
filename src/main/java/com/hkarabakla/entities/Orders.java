package com.hkarabakla.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
public class Orders {

    @Id
    @GeneratedValue
    private int id;

    private LocalDate created_at;

    private double total;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @ManyToMany(mappedBy = "ordersSet", fetch = FetchType.EAGER)
    private Set<Book> orderedBooks;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDate created_at) {
        this.created_at = created_at;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Book> getOrderedBooks() {
        return orderedBooks;
    }

    public void setOrderedBooks(Set<Book> orderedBooks) {
        this.orderedBooks = orderedBooks;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", created_at=" + created_at +
                ", total=" + total +
                ", user=" + user +
                ", orderedBooks=" + orderedBooks +
                '}';
    }
}
