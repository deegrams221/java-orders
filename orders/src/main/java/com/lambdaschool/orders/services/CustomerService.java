package com.lambdaschool.orders.services;

import com.lambdaschool.orders.models.Customer;

import java.util.List;

public interface CustomerService
{
    // find all
    List<Customer> findAll();

    // dont need find by id - was causing errors

    // save
    Customer save(Customer customer);

    // update by id
    Customer update(Customer customer, long id);

    // delete
    void delete(long id);
}