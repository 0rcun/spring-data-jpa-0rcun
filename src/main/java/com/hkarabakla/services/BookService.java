package com.hkarabakla.services;

import com.hkarabakla.entities.Authors;
import com.hkarabakla.entities.Book;
import com.hkarabakla.entities.Category;
import com.hkarabakla.repositories.AuthorsRepo;
import com.hkarabakla.repositories.BookRepo;
import com.hkarabakla.repositories.CategoryRepo;
import org.springframework.stereotype.Component;

import javax.xml.catalog.Catalog;
import java.util.Set;
import java.util.UUID;

@Component
public class BookService {

    private final BookRepo bookRepo;
    private final CategoryRepo categoryRepo;
    private final AuthorsRepo authorsRepo;

    public BookService(BookRepo bookRepo, CategoryRepo categoryRepo, AuthorsRepo authorsRepo) {
        this.bookRepo = bookRepo;
        this.categoryRepo = categoryRepo;
        this.authorsRepo = authorsRepo;
    }

    public void bookOperations(){
        Authors authors1 = new Authors();
        authors1.setId(UUID.randomUUID().toString());
        authors1.setName("George Orwell");

        Authors authors2 = new Authors();
        authors2.setId(UUID.randomUUID().toString());
        authors2.setName("Grigory Petrov");

        Authors authors3 = new Authors();
        authors3.setId(UUID.randomUUID().toString());
        authors3.setName("Stephen Hawking");

        Authors authors4 = new Authors();
        authors4.setId(UUID.randomUUID().toString());
        authors4.setName("Georges Perec");

        authorsRepo.save(authors1);
        authorsRepo.save(authors2);
        authorsRepo.save(authors3);
        authorsRepo.save(authors4);
//  #################################

        Category category1 = new Category();
        category1.setName("Science");

        Category category2 = new Category();
        category2.setName("Novel");

        categoryRepo.save(category1);
        categoryRepo.save(category2);
//  #################################

        Book book1 = new Book();
        book1.setIsbn(UUID.randomUUID().toString());
        book1.setName("Papazın Kızı");
        book1.setAuthors(Set.of(authors1));
        book1.setCategory(category2);

        Book book2 = new Book();
        book2.setIsbn(UUID.randomUUID().toString());
        book2.setName("1984");
        book2.setAuthors(Set.of(authors1));
        book2.setCategory(category2);

        Book book3 = new Book();
        book3.setIsbn(UUID.randomUUID().toString());
        book3.setName("Beyaz Zambaklar Ülkesinde");
        book3.setAuthors(Set.of(authors2));
        book3.setCategory(category2);

        Book book4 = new Book();
        book4.setIsbn(UUID.randomUUID().toString());
        book4.setName("Zamanın Kısa Tarihi");
        book4.setAuthors(Set.of(authors3));
        book4.setCategory(category1);

        Book book5 = new Book();
        book5.setIsbn(UUID.randomUUID().toString());
        book5.setName("Harikalar Odası");
        book5.setAuthors(Set.of(authors4));
        book5.setCategory(category2);

        bookRepo.save(book1);
        bookRepo.save(book2);
        bookRepo.save(book3);
        bookRepo.save(book4);
        bookRepo.save(book5);

        System.out.println("------------------All Books------------------");
        System.out.println(bookRepo.findAll());
        System.out.println("---------------------------------------------");

        System.out.println("------------------Search Books starts 'Bey'------------------");
        System.out.println(bookRepo.findAllByNameContainingIgnoreCase("Bey"));
        System.out.println("---------------------------------------------");


        System.out.println("------------------Search Books starts '19'------------------");
        System.out.println(bookRepo.findAllByNameContainingIgnoreCase("19"));
        System.out.println("---------------------------------------------");


        System.out.println("------------------Search Books Author name starts Georges------------------");
        System.out.println(bookRepo.findAllByAuthors_NameContainingIgnoreCase("Georges"));
        System.out.println("---------------------------------------------");

        System.out.println("------------------Search Books Author name starts Stephen------------------");
        System.out.println(bookRepo.findAllByAuthors_NameContainingIgnoreCase("Stephen"));
        System.out.println("---------------------------------------------");

    }
}
