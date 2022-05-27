package com.rest.restAPI.app.repo;

import com.rest.restAPI.app.mapping.Cart;
import com.rest.restAPI.app.mapping.Customer;
import com.rest.restAPI.app.mapping.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepo extends JpaRepository<Cart, Integer> {

    //public List<Cart> findCartByCustomer(Customer customer);

   // public List<Cart> findCartByCustomer_Id(Integer id);

   // public Cart findCartByCustomerAndProduct(Customer customer, Product product);
}
