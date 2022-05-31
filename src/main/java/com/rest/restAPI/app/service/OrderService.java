package com.rest.restAPI.app.service;

import com.rest.restAPI.app.mapping.Cart;
import com.rest.restAPI.app.mapping.Order;
import com.rest.restAPI.app.mapping.Product;
import com.rest.restAPI.app.repo.CartRepo;
import com.rest.restAPI.app.repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private CartRepo cartRepo;

    public String add(Order order) {
        String msg ="";
    try {
        Product p = new Product();
        p.setProduct_name("kh");
        Order o = new Order();
        o.setOrder_id(1);

        Cart c = new Cart();
        c.setOrder(order);
        c.setProduct(p);

        cartRepo.save(c);
//        return orderRepo.save(order);
    }catch (Exception e){
        System.out.println(e);
    }
    return msg;
    }

    public List<Order> findAll() {
        List<Order> orders = new ArrayList<>();
        try {
             orders = orderRepo.findAll();
        } catch (Exception e) {
            System.out.println(e);
        }
        return orders;
    }
}
