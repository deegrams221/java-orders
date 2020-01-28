package com.lambdaschool.orders;

import com.lambdaschool.orders.models.Agent;
import com.lambdaschool.orders.models.Customer;
import com.lambdaschool.orders.models.Order;
import com.lambdaschool.orders.repositories.AgentRepository;
import com.lambdaschool.orders.repositories.CustomerRepository;
import com.lambdaschool.orders.repositories.OrderRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
// note: had to reformat a little, http requests wouldn't work before

@Transactional
@Component
public class SeedData implements CommandLineRunner
{
    private CustomerRepository custrepo;
    private AgentRepository agentrepo;
    private OrderRepository ordersrepo;

    public SeedData(CustomerRepository custrepo, AgentRepository agentrepo, OrderRepository ordersrepo)
    {
        this.custrepo = custrepo;
        this.agentrepo = agentrepo;
        this.ordersrepo = ordersrepo;
    }

    @Override
    public void run(String[] args) throws Exception
    {
        Agent a01 = new Agent("Ramasundar", "Bangalore", 0.15, "077-25814763", "");
        Agent a02 = new Agent("Alex", "London", 0.13, "075-12458969", "");
        Agent a03 = new Agent("Alford", "New York", 0.12, "044-25874365", "");
        Agent a04 = new Agent("Ravi", "Bangalore", 0.15, "077-45625874", "");
        Agent a05 = new Agent("Santakumar", "Chennai", 0.14, "007-22388644", "");
        Agent a06 = new Agent("Lucida", "San Jose", 0.12, "044-52981425", "");
        Agent a07 = new Agent("Anderson", "Brisban", 0.13, "045-21447739", "");
        Agent a08 = new Agent("Subbarao", "Bangalore", 0.14, "077-12346674", "");
        Agent a09 = new Agent("Mukesh", "Mumbai", 0.11, "029-12358964", "");
        Agent a10 = new Agent("McDen", "London", 0.15, "078-22255588", "");
        Agent a11 = new Agent("Ivan", "Torento", 0.15, "008-22544166", "");
        Agent a12 = new Agent("Benjamin", "Hampshair", 0.11, "008-22536178", "");

        Customer c01 = new Customer("Holmes", "London", "London", "UK", "2", 6000.00, 5000.00, 7000.00, 4000.00, "BBBBBBB", a03);
        Customer c02 = new Customer("Micheal", "New York", "New York", "USA", "2", 3000.00, 5000.00, 2000.00, 6000.00, "CCCCCCC", a08);
        Customer c03 = new Customer("Albert", "New York", "New York", "USA", "3", 5000.00, 7000.00, 6000.00, 6000.00, "BBBBSBB", a08);
        Customer c04 = new Customer("Ravindran", "Bangalore", "Bangalore", "India", "2", 5000.00, 7000.00, 4000.00, 8000.00, "AVAVAVA", a11);
        Customer c05 = new Customer("Cook", "London", "London", "UK", "2", 4000.00, 9000.00, 7000.00, 6000.00, "FSDDSDF", a06);
        Customer c06 = new Customer("Stuart", "London", "London", "UK", "1", 6000.00, 8000.00, 3000.00, 11000.00, "GFSGERS", a03);
        Customer c07 = new Customer("Bolt", "New York", "New York", "USA", "3", 5000.00, 7000.00, 9000.00, 3000.00, "DDNRDRH", a08);
        Customer c08 = new Customer("Fleming", "Brisban", "Brisban", "Australia", "2", 7000.00, 7000.00, 9000.00, 5000.00, "NHBGVFC", a05);
        Customer c09 = new Customer("Jacks", "Brisban", "Brisban", "Australia", "1", 7000.00, 7000.00, 7000.00, 7000.00, "WERTGDF", a05);
        Customer c10 = new Customer("Yearannaidu", "Chennai", "Chennai", "India", "1", 8000.00, 7000.00, 7000.00, 8000.00, "ZZZZBFV", a10);
        Customer c11 = new Customer("Sasikant", "Mumbai", "Mumbai", "India", "1", 7000.00, 11000.00, 7000.00, 11000.00, "147-25896312", a02);
        Customer c12 = new Customer("Ramanathan", "Chennai", "Chennai", "India", "1", 7000.00, 11000.00, 9000.00, 9000.00, "GHRDWSD", a10);
        Customer c13 = new Customer("Avinash", "Mumbai", "Mumbai", "India", "2", 7000.00, 11000.00, 9000.00, 9000.00, "113-12345678",a02);
        Customer c14 = new Customer("Winston", "Brisban", "Brisban", "Australia", "1", 5000.00, 8000.00, 7000.00, 6000.00, "AAAAAAA", a05);
        Customer c15 = new Customer("Karl", "London", "London", "UK", "0", 4000.00, 6000.00, 7000.00, 3000.00, "AAAABAA", a06);
        Customer c16 = new Customer("Shilton", "Torento", "Torento", "Canada", "1", 10000.00, 7000.00, 6000.00, 11000.00, "DDDDDDD", a04);
        Customer c17 = new Customer("Charles", "Hampshair", "Hampshair", "UK", "3", 6000.00, 4000.00, 5000.00, 5000.00, "MMMMMMM", a09);
        Customer c18 = new Customer("Srinivas", "Bangalore", "Bangalore", "India", "2", 8000.00, 4000.00, 3000.00, 9000.00, "AAAAAAB", a07);
        Customer c19 = new Customer("Steven", "San Jose", "San Jose", "USA", "1", 5000.00, 7000.00, 9000.00, 3000.00, "KRFYGJK", a10);
        Customer c20 = new Customer("Karolina", "Torento", "Torento", "Canada", "1", 7000.00, 7000.00, 9000.00, 5000.00, "HJKORED", a04);
        Customer c21 = new Customer("Martin", "Torento", "Torento", "Canada", "2", 8000.00, 7000.00, 7000.00, 8000.00, "MJYURFD", a04);
        Customer c22 = new Customer("Ramesh", "Mumbai", "Mumbai", "India", "3", 8000.00, 7000.00, 3000.00, 12000.00, "Phone No", a02);
        Customer c23 = new Customer("Rangarappa", "Bangalore", "Bangalore", "India", "2", 8000.00, 11000.00, 7000.00, 12000.00, "AAAATGF", a01);
        Customer c24 = new Customer("Venkatpati", "Bangalore", "Bangalore", "India", "2", 8000.00, 11000.00, 7000.00, 12000.00, "JRTVFDD", a07);
        Customer c25 = new Customer("Sundariya", "Chennai", "Chennai", "India", "3", 7000.00, 11000.00, 7000.00, 11000.00, "PPHGRTS", a10);

        Order o01 = new Order(1000.00, 600.00, c13, "SOD");
        Order o02 = new Order(3000.00, 500.00, c19, "SOD");
        Order o03 = new Order(4500.00, 900.00, c07, "SOD");
        Order o04 = new Order(2000.00, 400.00, c16, "SOD");
        Order o05 = new Order(4000.00, 600.00, c22, "SOD");
        Order o06 = new Order(2000.00, 300.00, c12, "SOD");
        Order o07 = new Order(3500.00, 2000.00, c02, "SOD");
        Order o08 = new Order(2500.00, 400.00, c03, "SOD");
        Order o09 = new Order(500.00, 100.00, c23, "SOD");
        Order o10 = new Order(4000.00, 700.00, c07, "SOD");
        Order o11 = new Order(1500.00, 600.00, c08, "SOD");
        Order o12 = new Order(2500.00, 400.00, c25, "SOD");

        agentrepo.save(a01);
        agentrepo.save(a02);
        agentrepo.save(a03);
        agentrepo.save(a04);
        agentrepo.save(a05);
        agentrepo.save(a06);
        agentrepo.save(a07);
        agentrepo.save(a08);
        agentrepo.save(a09);
        agentrepo.save(a10);
        agentrepo.save(a11);
        agentrepo.save(a12);

        custrepo.save(c01);
        custrepo.save(c02);
        custrepo.save(c03);
        custrepo.save(c04);
        custrepo.save(c05);
        custrepo.save(c06);
        custrepo.save(c07);
        custrepo.save(c08);
        custrepo.save(c09);
        custrepo.save(c10);
        custrepo.save(c11);
        custrepo.save(c12);
        custrepo.save(c13);
        custrepo.save(c14);
        custrepo.save(c15);
        custrepo.save(c16);
        custrepo.save(c17);
        custrepo.save(c18);
        custrepo.save(c19);
        custrepo.save(c20);
        custrepo.save(c21);
        custrepo.save(c22);
        custrepo.save(c23);
        custrepo.save(c24);
        custrepo.save(c25);

        ordersrepo.save(o01);
        ordersrepo.save(o02);
        ordersrepo.save(o03);
        ordersrepo.save(o04);
        ordersrepo.save(o05);
        ordersrepo.save(o06);
        ordersrepo.save(o07);
        ordersrepo.save(o08);
        ordersrepo.save(o09);
        ordersrepo.save(o10);
        ordersrepo.save(o11);
        ordersrepo.save(o12);
    }
}
