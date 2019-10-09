package com.lambdaschool.orders.services;

import com.lambdaschool.orders.model.Customers;
import com.lambdaschool.orders.model.Orders;
import com.lambdaschool.orders.repos.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "customerservice")
public class CustomerServiceImpl implements CustomerService
{
    @Autowired
    // to access the customers repository
    private CustomersRepository custrepos;

    // generate override methods from customers
    // find all
    @Override
    public List<Customers> findAll()
    {
        List<Customers> rtnList = new ArrayList<>();
        custrepos.findAll().iterator().forEachRemaining(rtnList::add);
        return rtnList;
    }

    // find by id
    @Override
    public Customers findById(long custcode)
    {
        return custrepos.findById(custcode).orElseThrow(() -> new EntityNotFoundException("Not Found " + custcode));
    }

    // spring framework transactional - all steps have to happen correctly otherwise nothing with work
    @Transactional
    // save
    @Override
    public Customers save(Customers customers)
    {
        Customers newCustomer = new Customers();
        newCustomer.setAgents(customers.getAgents());
        newCustomer.setCustname(customers.getCustname());
        newCustomer.setCustcity(customers.getCustcity());
        newCustomer.setWorkingarea(customers.getWorkingarea());
        newCustomer.setCustcountry(customers.getCustcountry());
        newCustomer.setGrade(customers.getGrade());
        newCustomer.setOpeningamt(customers.getOpeningamt());
        newCustomer.setReceiveamt(customers.getReceiveamt());
        newCustomer.setOutstandingamt(customers.getOutstandingamt());
        newCustomer.setPhone(customers.getPhone());

        for(Orders o: customers.getOrders())
        {
            newCustomer.getOrders().add(new Orders(o.getOrdamount(), o.getAdcanceamount(), o.getOrddescription(), newCustomer));
        }

        return custrepos.save(newCustomer);
    }

    // update by id
    @Override
    public Customers update(Customers customer, long custcode) {

        return custrepos.save(customer);
    }

    // delete
    @Override
    public void delete(long custcode)
    {
        custrepos.deleteById(custcode);
    }
}
