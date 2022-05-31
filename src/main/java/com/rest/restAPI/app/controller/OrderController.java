package com.rest.restAPI.app.controller;

import com.rest.restAPI.app.bean.CartBean;
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

    /*@PostMapping("/checkout")
    public Order order(@RequestBody Order order){
        return orderProductService.add(order);
    }*/


    @GetMapping("/fetch")
    public List<Order> findAll(){
        return orderProductService.findAll();
    }

}
