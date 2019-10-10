package com.lambdaschool.orders.controllers;

import com.lambdaschool.orders.model.Agents;
import com.lambdaschool.orders.services.AgentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/agents")
public class AgentsController
{
    // inject services into this class
    @Autowired
    private AgentsService agentsService;

    //http://localhost:2019/agent/{agentcode}
    @DeleteMapping(value = "/agent/{agentcode}", produces = {"application/json"})
    public ResponseEntity<?> deleteAgent(@PathVariable long agentcode) {
        Agents currentAgent = new Agents();

        agentsService.delete(agentcode);
        return new ResponseEntity<>("Delete Successful", HttpStatus.OK);
    }

}
