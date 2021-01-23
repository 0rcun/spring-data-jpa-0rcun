package com.hkarabakla.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Authors {

    @Id
    private String id;

    private String name;

    @ManyToMany
    @JoinTable(
            name = "authors_books",
            joinColumns = @JoinColumn(name = "authors_id"),
            inverseJoinColumns = @JoinColumn(name= "book_isbn"))
    private Set<Book> writedBooks;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Book> getWritedBooks() {
        return writedBooks;
    }

    public void setWritedBooks(Set<Book> writedBooks) {
        this.writedBooks = writedBooks;
    }

    @Override
    public String toString() {
        return "Authors{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
