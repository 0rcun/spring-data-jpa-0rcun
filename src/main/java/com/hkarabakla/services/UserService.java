package com.hkarabakla.services;

import com.hkarabakla.entities.Address;
import com.hkarabakla.entities.Book;
import com.hkarabakla.entities.Orders;
import com.hkarabakla.entities.User;
import com.hkarabakla.repositories.BookRepo;
import com.hkarabakla.repositories.OrdersRepo;
import com.hkarabakla.repositories.UserRepo;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Component
public class UserService {

    private final UserRepo userRepo;
    private final OrdersRepo ordersRepo;
    private final BookRepo bookRepo;

    public UserService(UserRepo repo, OrdersRepo ordersRepo, BookRepo bookRepo) {
        this.userRepo = repo;
        this.ordersRepo = ordersRepo;
        this.bookRepo = bookRepo;
    }

    public void userOperations() {
        List<Book> books = (List<Book>) bookRepo.findAll();

        User user1 = new User();
        user1.setName("user");
        Address address1 = new Address();
        address1.setStreet("Gazi sokak");
        address1.setNumber("7");
        address1.setCity("Istanbul");
        user1.setAddress(address1);

        User user2 = new User();
        user2.setName("Orcun");
        Address address2 = new Address();
        address2.setStreet("1234 sokak");
        address2.setNumber("5");
        address2.setCity("Mersin");
        user2.setAddress(address2);

        userRepo.save(user1);
        userRepo.save(user2);



        Orders order1 = new Orders();
        order1.setUser(user1);
        order1.setOrderedBooks(Set.of(books.get(0), books.get(4), books.get(2)));

        Orders order2 = new Orders();
        order2.setUser(user2);
        order2.setOrderedBooks(Set.of(books.get(1), books.get(3)));

        ordersRepo.save(order1);
        ordersRepo.save(order2);

        System.out.println("----------------Orders-----------------");
        System.out.println(ordersRepo.findAll());
        System.out.println("---------------------------------------------");
        System.out.println("----------------Orders "+userRepo.findByName("Orcun")+"-----------------");
        System.out.println(ordersRepo.findAllByUser_Id(userRepo.findByName("Orcun").getId()).toString());
        System.out.println("---------------------------------------------");
        System.out.println("----------------Orders "+userRepo.findByName("user")+"-----------------");
        System.out.println(ordersRepo.findAllByUser_Id(userRepo.findByName("user").getId()).toString());
        System.out.println("---------------------------------------------");







    }
}
