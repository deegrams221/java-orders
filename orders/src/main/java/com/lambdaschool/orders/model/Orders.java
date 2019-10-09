package com.lambdaschool.orders.model;


// Orders has a foreign key to Customers (custcode)
// Orders has a Many to One relationship to Customers and
// Customers has a One to Many relationship to Orders

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Orders
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ordnum;

    @Column
    private double ordamount;
    private double adcanceamount;
    private String orddescription;

    @ManyToOne
    @JoinColumn(name = "custcode", nullable = false)
    @JsonIgnoreProperties("orders")
    private Customers customers;

    // default constrictor
    public Orders()
    {

    }

    // constrictors
    public Orders(double ordamount,
                  double adcanceamount,
                  String orddescription,
                  Customers customers) {
        this.ordamount = ordamount;
        this.adcanceamount = adcanceamount;
        this.orddescription = orddescription;
        this.customers = customers;
    }

    // getters and setters - including id
    public long getOrdnum()
    {
        return ordnum;
    }

    public void setOrdnum(long ordnum)
    {
        this.ordnum = ordnum;
    }

    public double getOrdamount()
    {
        return ordamount;
    }

    public void setOrdamount(double ordamount)
    {
        this.ordamount = ordamount;
    }

    public double getAdcanceamount()
    {
        return adcanceamount;
    }

    public void setAdcanceamount(double adcanceamount)
    {
        this.adcanceamount = adcanceamount;
    }

    public String getOrddescription()
    {
        return orddescription;
    }

    public void setOrddescription(String orddescription)
    {
        this.orddescription = orddescription;
    }

    public Customers getCustomers()
    {
        return customers;
    }

    public void setCustomers(Customers customers)
    {
        this.customers = customers;
    }
}
