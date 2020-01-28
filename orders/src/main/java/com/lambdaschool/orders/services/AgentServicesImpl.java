package com.lambdaschool.orders.services;

import com.lambdaschool.orders.models.Agent;
import com.lambdaschool.orders.models.Customer;
import com.lambdaschool.orders.repositories.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Transactional // spring framework transactional - needs to be here and at save method
@Service(value = "agentService")
// Bean - POJO
public class AgentServicesImpl implements AgentService
{
    @Autowired
    // to access the agents repository
    private AgentRepository agentrepo;

    // generate override methods from agents
    // find all
    @Override
    public List<Agent> findAll()
    {
        List<Agent> rtnList = new ArrayList<>();
        agentrepo.findAll().iterator().forEachRemaining(rtnList::add);
        return rtnList;
    }

    // find by id
    @Override
    public Agent findById(long agentcode)
    {
        return agentrepo.findById(agentcode).orElseThrow(() -> new EntityNotFoundException("Not Found " + agentcode));
    }

    @Transactional
    // save
    @Override
    public Agent save(Agent agents)
    {
        Agent newAgents = new Agent();

        newAgents.setAgentname(agents.getAgentname());
        newAgents.setWorkingarea(agents.getWorkingarea());
        newAgents.setCommission(agents.getCommission());
        newAgents.setPhone(agents.getPhone());
        newAgents.setCountry(agents.getCountry());

        for (Customer c : agents.getCustomers())
        {
            newAgents.getCustomers().add(new Customer(c.getCustname(),
                    c.getCustcity(), c.getWorkingarea(), c.getCustcountry(),
                    c.getGrade(), c.getOpeningamt(), c.getReceiveamt(), c.getPaymentamt(),
                    c.getOutstandingamt(), c.getPhone(), newAgents));
        }
        return agentrepo.save(newAgents);
    }

    // update by id
    @Override
    public Agent update(Agent agents, long agentcode)
    {
        return agentrepo.save(agents);
    }

    // delete
    @Override
    public void delete(long agentcode)
    {
        agentrepo.deleteById(agentcode);
    }
}
