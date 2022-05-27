package com.rest.restAPI.app.service;

import com.rest.restAPI.app.mapping.Order;
import com.rest.restAPI.app.repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepo tranRepo;

    public Order add(Order orderProduct){

        return tranRepo.save(orderProduct);

    }

    public List<Order> findAll(){

        return tranRepo.findAll();
    }
}
