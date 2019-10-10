package com.lambdaschool.orders.services;

import com.lambdaschool.orders.model.Orders;

import java.util.List;

public interface OrderService
{
    // find all
    List<Orders> findAll();

    // find by id
    Orders findById(long ordnum);

    // save
    Orders save(Orders orders);

    // update by id
    Orders update(Orders orders, long ordnum);

    // delete
    void delete(long ordnum);
}

// this files should never change... can only add to it