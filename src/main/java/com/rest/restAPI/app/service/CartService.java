package com.rest.restAPI.app.service;

import com.rest.restAPI.app.mapping.Cart;
import com.rest.restAPI.app.mapping.Customer;
import com.rest.restAPI.app.mapping.Product;
import com.rest.restAPI.app.repo.CartRepo;
import com.rest.restAPI.app.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartRepo cartRepo;

    @Autowired
    private ProductRepo productRepo;

    /*public List<Cart> listCartItems(Customer customer){
        return cartRepo.findCartByCustomer(customer);
    }*/
   /* public List<Cart> listCartItems(Integer id){//  return cartRepo.findCartByCustomer_Id(id);
    }

    public Integer addProduct(Integer pid, Integer qty, Customer customer){

        Integer addedQuantity = qty;
        Product product = productRepo.findById(pid).get();
        Cart cartItem = cartRepo.findCartByCustomerAndProduct(customer, product);

        if (cartItem != null){
            addedQuantity = cartItem.getQuantity() + qty;
            cartItem.setQuantity(addedQuantity);
        } else {
            cartItem = new Cart();
            cartItem.setQuantity(qty);
            //cartItem.setCustomer(customer);
            cartItem.setProduct(product);
        }

        cartRepo.save(cartItem);

        return addedQuantity;
    }*/
}
