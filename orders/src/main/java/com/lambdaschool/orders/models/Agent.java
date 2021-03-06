package com.lambdaschool.orders.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

// Customers has a foreign key to Agents (agentcode) this means:
// Customers has a Many to One relationship to Agents and
// Agents has a One to Many relationship to Customers

@Entity
@Table(name = "agents")
public class Agent
{
    // fields - table columns
    @Id // effects the field immediately after the annotation
    @GeneratedValue(strategy = GenerationType.AUTO) // auto is best practice
    private long agentcode; // all lowercase is best practice to make this database independent

    // don't need '@Column(unique = true, nullable = false)' here
    private String agentname;

    private String workingarea;
    private double commission;
    private String phone;
    private String country;

    // One to Many
    @OneToMany(mappedBy = "agent",
            cascade=CascadeType.ALL)
    @JsonIgnoreProperties("agent")
    private List<Customer> customers = new ArrayList<>();

    // default constructor
    public Agent()
    {

    }

    // constructor - all but list
    public Agent(String agentname,
                 String workingarea,
                 double commission,
                 String phone,
                 String country)
    {
        this.agentname = agentname;
        this.workingarea = workingarea;
        this.commission = commission;
        this.phone = phone;
        this.country = country;
    }

    // generate getters and setters - including id
    public long getAgentcode()
    {
        return agentcode;
    }

    public void setAgentcode(long agentcode)
    {
        this.agentcode = agentcode;
    }

    public String getAgentname()
    {
        return agentname;
    }

    public void setAgentname(String agentname)
    {
        this.agentname = agentname;
    }

    public String getWorkingarea()
    {
        return workingarea;
    }

    public void setWorkingarea(String workingarea)
    {
        this.workingarea = workingarea;
    }

    public double getCommission()
    {
        return commission;
    }

    public void setCommission(double commission)
    {
        this.commission = commission;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getCountry()
    {
        return country;
    }

    public void setCountry(String country)
    {
        this.country = country;
    }

    public List<Customer> getCustomers()
    {
        return customers;
    }

    public void setCustomers(List<Customer> customers)
    {
        this.customers = customers;
    }
}