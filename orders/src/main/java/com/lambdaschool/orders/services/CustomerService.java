package com.lambdaschool.orders.services;

import com.lambdaschool.orders.model.Customers;
import java.util.List;

public interface CustomerService
{
    // find all
    List<Customers> findAll();

    // find by id
    Customers findById(long custcode);

    // save
    Customers save(Customers customers);

    // update by id
    Customers update(Customers customers, long custcode);

    // delete
    void delete(long custcode);
}

// this files should never change... can only add to it
