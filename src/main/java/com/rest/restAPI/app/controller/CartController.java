package com.rest.restAPI.app.controller;

import com.rest.restAPI.app.bean.CartBean;
import com.rest.restAPI.app.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

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

    @PostMapping(value = "/test", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody HashMap<String, String> placeOrder(@RequestBody CartBean cartBean){
        System.out.println("test1");
        //String result = "null";
        HashMap<String, String> status = new HashMap<>();

        try{
            if(cartService.getCartItems(cartBean)){
                //result = "Order has been placed!!";
                status.put("msg", "Order has been placed!!");
            }else {
               // result = "Order placement was not successful!";
                status.put("msg", "Order placement was not successful!");
            }
        }catch (Exception e){
            System.out.println(e);
           // result = "System Error!";
            status.put("msg", "System Error!");
        }

        return status;
    }
}
