package com.lambdaschool.orders.controllers;

import com.lambdaschool.orders.models.Customer;
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
    @GetMapping(value="/order",produces = {"application/json"})
    public ResponseEntity<?> listAllCustomers()
    {
        List<Customer> myList=customerService.findAll();
        return new ResponseEntity<>(myList, HttpStatus.OK);
    }

    // POST /customer/new - Adds a new customer including any new orders
    @PostMapping(value="/new",consumes = {"application/json"})
    public ResponseEntity<?> addNewCustomer(@Valid @RequestBody Customer newCustomer)
    {
        newCustomer=customerService.save(newCustomer);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // PUT /customer/update/{custcode} - Updates the customer based off of custcode
    // Does not have to do anything with Orders!
    @PutMapping(value = "/update/{custcode}",consumes = {"application/json"})
    public ResponseEntity<?> updateCustomer(@RequestBody Customer customer,@PathVariable long custcode)
    {
        customerService.update(customer,custcode);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // DELETE /customer/delete/{custcode} - Deletes the customer based off of custcode
    // this should also delete the orders of that customer
    @DeleteMapping("/delete/{custcode}")
    public ResponseEntity<?> deleteCustomerById(@PathVariable long custcode)
    {
        customerService.delete(custcode);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}