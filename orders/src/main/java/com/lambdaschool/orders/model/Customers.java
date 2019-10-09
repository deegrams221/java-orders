package com.lambdaschool.orders.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;

// Customers has a foreign key to Agents (agentcode) this means:
// Customers has a Many to One relationship to Agents and
// Agents has a One to Many relationship to Customers

@Entity
@Table(name = "customers")
public class Customers
{
    @Id // all ids have this annotation throughout the app
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long custcode;

    @Column(nullable = false) // custname has to have a name
    private String custname;

    private String custcity;
    private String workingarea;
    private String custcountry;
    private String grade;
    private double openingamt;
    private double paymentamt;
    private double outstandingamt;
    private String phone;

    @ManyToOne // ties menu and restaurant together
    @JoinColumn(name = "agentcode", nullable = false)
    // ^ tells spring how to join them together
    @JsonIgnoreProperties("customers") // tells it not keep repeating
    private Agents agents;

    // default constructor
    public Customers()
    {

    }

    // constructors
    public Customers(String custname,
                     String custcity,
                     String workingarea,
                     String custcountry,
                     String grade,
                     double openingamt,
                     double paymentamt,
                     double outstandingamt,
                     String phone,
                     Agents agents)
    {
        this.custname = custname;
        this.custcity = custcity;
        this.workingarea = workingarea;
        this.custcountry = custcountry;
        this.grade = grade;
        this.openingamt = openingamt;
        this.paymentamt = paymentamt;
        this.outstandingamt = outstandingamt;
        this.phone = phone;
        this.agents = agents;
    }

    // generate getters and setters - including id
    public long getCustcode()
    {
        return custcode;
    }

    public void setCustcode(long custcode)
    {
        this.custcode = custcode;
    }

    public String getCustname()
    {
        return custname;
    }

    public void setCustname(String custname)
    {
        this.custname = custname;
    }

    public String getCustcity()
    {
        return custcity;
    }

    public void setCustcity(String custcity)
    {
        this.custcity = custcity;
    }

    public String getWorkingarea()
    {
        return workingarea;
    }

    public void setWorkingarea(String workingarea)
    {
        this.workingarea = workingarea;
    }

    public String getCustcountry()
    {
        return custcountry;
    }

    public void setCustcountry(String custcountry)
    {
        this.custcountry = custcountry;
    }

    public String getGrade()
    {
        return grade;
    }

    public void setGrade(String grade)
    {
        this.grade = grade;
    }

    public double getOpeningamt()
    {
        return openingamt;
    }

    public void setOpeningamt(double openingamt)
    {
        this.openingamt = openingamt;
    }

    public double getPaymentamt()
    {
        return paymentamt;
    }

    public void setPaymentamt(double paymentamt)
    {
        this.paymentamt = paymentamt;
    }

    public double getOutstandingamt()
    {
        return outstandingamt;
    }

    public void setOutstandingamt(double outstandingamt)
    {
        this.outstandingamt = outstandingamt;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public Agents getAgents()
    {
        return agents;
    }

    public void setAgents(Agents agents)
    {
        this.agents = agents;
    }
}
