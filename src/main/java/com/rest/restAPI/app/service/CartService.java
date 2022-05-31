package com.rest.restAPI.app.service;

import com.rest.restAPI.app.bean.CartBean;
import com.rest.restAPI.app.mapping.Cart;
import com.rest.restAPI.app.mapping.Customer;
import com.rest.restAPI.app.mapping.Order;
import com.rest.restAPI.app.mapping.Product;
import com.rest.restAPI.app.repo.CartRepo;
import com.rest.restAPI.app.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CartService {

    @Autowired
    private CartRepo cartRepo;

   public Boolean getCartItems(CartBean cartBean){
       boolean status = false;
    try {
        Order order = new Order();
        Customer customer = new Customer();
        customer.setId(cartBean.getCustomer_id());
        order.setCustomer(customer);
        order.setDelivery_address(cartBean.getAddress());
        order.setTotal(cartBean.getAmount());
        order.setStatus("2");


        for (Map<String, Object> map: cartBean.getItems()) {
            Cart c = new Cart();
            c.setOrder(order);
            Product p = new Product();
            p.setProduct_id((Integer) map.get("product_id"));
            c.setProduct(p);
            c.setQuantity((Integer) map.get("qty"));
            cartRepo.save(c);
        }
        status = true;

    }catch (Exception e){
        System.out.println(e);
    }
       return status;
   }

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
