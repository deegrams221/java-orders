package com.lambdaschool.orders.services;

import com.lambdaschool.orders.model.Agents;

import java.util.List;

public interface AgentsService
{
    // find all
    List<Agents>findAll();

    // find by id
    Agents findById(long id);

    // save
    Agents save(Agents agents);

    // update by id
    Agents update(Agents agents, long id);

    // delete
    void delete(long id);
}

// this files should never change... can only add to it