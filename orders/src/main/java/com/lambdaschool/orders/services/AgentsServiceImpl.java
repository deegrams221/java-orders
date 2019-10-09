package com.lambdaschool.orders.services;

import com.lambdaschool.orders.model.Agents;
import com.lambdaschool.orders.model.Customers;
import com.lambdaschool.orders.model.Orders;
import com.lambdaschool.orders.repos.AgentsRepository;
import org.aspectj.weaver.loadtime.Agent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Transactional // spring framework transactional - needs to be here and at save method
@Service(value = "agentsService")
// Bean - POJO
public class AgentsServiceImpl implements AgentsService
{
    @Autowired
    // to access the agents repository
    private AgentsRepository agentrepos;

    // generate override methods from agents
    // find all
    @Override
    public List<Agents> findAll()
    {
        List<Agents> rtnList = new ArrayList<>();
        agentrepos.findAll().iterator().forEachRemaining(rtnList::add);
        return rtnList;
    }

    // find by id
    @Override
    public Agents findById(long agentcode)
    {
        return agentrepos.findById(agentcode).orElseThrow(() -> new EntityNotFoundException("Not Found " + agentcode));
    }

    @Transactional
    // save
    @Override
    public Agents save(Agents agents)
    {
        Agents newAgents = new Agents();

        newAgents.setAgentname(agents.getAgentname());
        newAgents.setWorkingarea(agents.getWorkingarea());
        newAgents.setCommission(agents.getCommission());
        newAgents.setPhone(agents.getPhone());
        newAgents.setCountry(agents.getCountry());

        for (Customers c : agents.getCustomers())
        {
            newAgents.getCustomers().add(new Customers(c.getCustname(),
                    c.getCustcity(), c.getWorkingarea(), c.getCustcountry(),
                    c.getGrade(), c.getOpeningamt(), c.getReceiveamt(), c.getPaymentamt(),
                    c.getOutstandingamt(), c.getPhone(), newAgents));
        }
        return agentrepos.save(newAgents);
    }

    // update by id
    @Override
    public Agents update(Agents agents, long agentcode)
    {
        return agentrepos.save(agents);
    }

    // delete
    @Override
    public void delete(long agentcode)
    {
        agentrepos.deleteById(agentcode);
    }
}
