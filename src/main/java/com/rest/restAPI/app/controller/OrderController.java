package com.rest.restAPI.app.controller;

import com.rest.restAPI.app.mapping.Order;
import com.rest.restAPI.app.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderProductService;

    @PostMapping("/add")
    public Order orderProduct(@RequestBody Order orderProduct){
        return orderProductService.add(orderProduct);
    }

    @GetMapping("/fetch")
    public List<Order> findAll(){
        return orderProductService.findAll();
    }

}
