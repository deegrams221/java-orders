package com.lambdaschool.orders.controllers;

import com.lambdaschool.orders.models.Agent;
import com.lambdaschool.orders.services.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/agents")
public class AgentController
{
    // inject services into this class
    @Autowired
    private AgentService agentsService;

    //http://localhost:2019/agent/{agentcode}
    @DeleteMapping(value = "/agent/{agentcode}", produces = {"application/json"})
    public ResponseEntity<?> deleteAgent(@PathVariable long agentcode) {
        Agent currentAgent = new Agent();

        agentsService.delete(agentcode);
        return new ResponseEntity<>("Delete Successful", HttpStatus.OK);
    }

}
