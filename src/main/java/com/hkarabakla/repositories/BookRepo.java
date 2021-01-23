package com.hkarabakla.repositories;

import com.hkarabakla.entities.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepo extends CrudRepository<Book, Integer> {

    List<Book> findAllByAuthors_NameContainingIgnoreCase(String authorsName);
    List<Book> findAllByNameContainingIgnoreCase(String name);


}
