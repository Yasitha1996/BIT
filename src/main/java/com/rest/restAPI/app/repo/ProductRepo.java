package com.rest.restAPI.app.repo;

import com.rest.restAPI.app.mapping.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {


    @Query(value = "SELECT * FROM product p where p.category=?", nativeQuery = true)
    List<Product>  findBYCategory(String category);

    @Query(value = "SELECT available_stock FROM product p where p.product_id=?", nativeQuery = true)
    String checkAvailability(Integer id);

    //Product findByProduct_id(Integer product_id);

}
