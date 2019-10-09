package com.lambdaschool.orders.controllers;

import com.lambdaschool.orders.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController
{
    // inject services into this class
    @Autowired
    private CustomerService customerService;

    // https://localhost:2019/
    // GET /customer/order - Returns all customers with their orders


    // POST /customer/new - Adds a new customer including any new orders


    // PUT /customer/update/{custcode} - Updates the customer based off of custcode.
    // Does not have to do anything with Orders!


    // DELETE /customer/delete/{custcode} - Deletes the customer based off of custcode
    //this should also delete the orders of that customer
}
