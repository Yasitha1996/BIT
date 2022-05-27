package com.rest.restAPI.app.service;

import com.rest.restAPI.app.mapping.Product;
import com.rest.restAPI.app.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public Product save(Product product) {

        return productRepo.save(product);
    }

    public List<Product> findAll() {

        return productRepo.findAll();

    }

    public List<Product> findByCategory(String category) {
        return productRepo.findBYCategory(category);
    }

    public String checkAvailability(Integer product_id) {
        String result = productRepo.checkAvailability(product_id);
        //Integer available_stock = Integer.valueOf(result);
      /* if (qty<= available_stock){
           Product product = productRepo.findProductByProduct_id(product_id);
           product.setAvailable_stock(String.valueOf(available_stock-qty));
           productRepo.save(product);
           return "success";
       } else {
           return result;
       }*/
        return result;
    }

    public Optional<Product> findProduct(Integer product_id) {
        return productRepo.findById(product_id);
    }
}
