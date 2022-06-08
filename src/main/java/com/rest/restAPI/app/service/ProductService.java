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

    public List<Product> findByCategory(Integer category) {
        List<Product> products = null;
        try {
            products = productRepo.findBYCategory(category);
        }catch (Exception e){
            System.out.println(e);
        }
        return products;
    }

    public String checkAvailability(Integer product_id, Integer qty) {
        String result =null;
        try {
            result = productRepo.checkAvailability(product_id);
            Integer available_stock = Integer.valueOf(result);
            if (qty <= available_stock) {
                Product product = productRepo.findProduct(product_id);
                product.setAvailable_stock(String.valueOf(available_stock - qty));
                productRepo.save(product);
                return "success";
            } else {
                return result;
            }
            // return result;
        }catch (Exception e){
            System.out.println(e);
        }
        return result;
    }

    public String updateInventory(Integer product_id, Integer qty) {
        String result =null;
        try {
            result = productRepo.checkAvailability(product_id);
            Integer available_stock = Integer.valueOf(result);

                Product product = productRepo.findProduct(product_id);
                product.setAvailable_stock(String.valueOf(available_stock + qty));
                productRepo.save(product);
                return "success";

            // return result;
        }catch (Exception e){
            System.out.println(e);
        }
        return result;
    }

    public Optional<Product> findProduct(Integer product_id) {
        return productRepo.findById(product_id);
    }
}
