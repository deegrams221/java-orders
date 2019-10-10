package com.lambdaschool.orders.services;

import com.lambdaschool.orders.model.Orders;
import com.lambdaschool.orders.repos.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "orderservice")
public class OrderServiceImpl implements OrderService
{
    @Autowired
    // to access the orders repository
    private OrdersRepository ordersrepos;

    // generate override methods from orders
    // find all
    @Override
    public List<Orders> findAll()
    {
        List<Orders> rtnList = new ArrayList<>();
        ordersrepos.findAll().iterator().forEachRemaining(rtnList::add);
        return rtnList;
    }

    // find by id
    @Override
    public Orders findById(long ordnum)
    {
        return ordersrepos.findById(ordnum).orElseThrow(() ->
                new EntityNotFoundException("Not Found " + ordnum));
    }

    // spring framework transactional - all steps have to happen correctly otherwise nothing will work
    @Transactional
    // save
    @Override
    public Orders save(Orders orders)
    {
        Orders newOrder = new Orders();
        newOrder.setAdvanceamount(orders.getAdvanceamount());
        newOrder.setCustomers(orders.getCustomers());
        newOrder.setOrdamount(orders.getOrdamount());
        newOrder.setOrddescription(orders.getOrddescription());

        return ordersrepos.save(newOrder);
    }

    // update by id
    @Override
    public Orders update(Orders orders, long ordnum)
    {
        return ordersrepos.save(orders);
    }

    // delete by id
    @Override
    public void delete(long ordnum)
    {
        ordersrepos.deleteById(ordnum);
    }
}
