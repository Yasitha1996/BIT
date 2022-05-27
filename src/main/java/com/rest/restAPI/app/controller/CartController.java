package com.rest.restAPI.app.controller;

import com.rest.restAPI.app.mapping.Cart;
import com.rest.restAPI.app.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CartController {

    @Autowired
    private CartService cartService;

    /*@GetMapping("/showCart")
    public List<Cart> shoppingCart(@RequestParam Integer customer_id){
        List<Cart> cartList = cartService.listCartItems(customer_id);
        return cartList;
    }*/
}
