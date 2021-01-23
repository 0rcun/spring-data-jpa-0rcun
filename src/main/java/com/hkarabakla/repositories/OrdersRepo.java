package com.hkarabakla.repositories;

import com.hkarabakla.entities.Orders;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrdersRepo extends CrudRepository<Orders, Integer> {

    List<Orders> findAllByUser_Id(int userId);
}
