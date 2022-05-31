package com.rest.restAPI.app.controller;

import com.rest.restAPI.app.bean.CartBean;
import com.rest.restAPI.app.mapping.Cart;
import com.rest.restAPI.app.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    /*@GetMapping("/showCart")
    public List<Cart> shoppingCart(@RequestParam Integer customer_id){
        List<Cart> cartList = cartService.listCartItems(customer_id);
        return cartList;
    }*/

    @PostMapping(value = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
    public String placeOrder(@RequestBody CartBean cartBean){
        String result=null;
        try{
            if(cartService.getCartItems(cartBean)){
                result = "Order has been placed!!";
            }else {
                result = "Order placement was not successful!";
            }
        }catch (Exception e){
            System.out.println(e);
            result = "System Error!";
        }

        return result;
    }
}
