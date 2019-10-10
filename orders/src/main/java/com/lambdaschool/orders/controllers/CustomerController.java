package com.lambdaschool.orders.controllers;

import com.lambdaschool.orders.model.Customers;
import com.lambdaschool.orders.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController
{
    // inject services into this class
    @Autowired
    private CustomerService customerService;

    // https://localhost:2019/
    // GET /customer/order - Returns all customers with their orders
    @GetMapping(value = "/customer/order", produces = {"application/json"})
    public ResponseEntity<?> ListAllCustomersWithOrders()
    {
        List<Customers> myCustomers = customerService.findAll();
        return new ResponseEntity<>(myCustomers, HttpStatus.OK);
    }

    // POST /customer/new - Adds a new customer including any new orders
    @PostMapping(value = "/customer/new", produces = {"application/json"})
    public ResponseEntity<?> addNewCustomer(@Valid @RequestBody Customers newCustomer)
    {
        customerService.save(newCustomer);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // PUT /customer/update/{custcode} - Updates the customer based off of custcode
    // Does not have to do anything with Orders!
    @PutMapping(value = "/customer/update/{custcode}", produces = {"application/json"}, consumes = {"application/json"})
    public ResponseEntity<?> updateCustomer(@RequestBody Customers updateCustomer, @PathVariable long custcode)
    {
        customerService.update(updateCustomer, custcode);
        return new ResponseEntity<>("Successfully Updated", HttpStatus.OK);
    }

    // DELETE /customer/delete/{custcode} - Deletes the customer based off of custcode
    //this should also delete the orders of that customer
    @DeleteMapping(value = "/customer/delete/{custcode}", produces = {"application/json"})
    public ResponseEntity<?> deleteCustomer(@PathVariable long custcode)
    {
        customerService.delete(custcode);
        return new ResponseEntity<>("Successfully Deleted", HttpStatus.OK);
    }
}
