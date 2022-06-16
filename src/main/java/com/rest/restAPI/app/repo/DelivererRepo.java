package com.rest.restAPI.app.repo;

import com.rest.restAPI.app.mapping.Deliverer;
import com.rest.restAPI.app.mapping.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DelivererRepo extends JpaRepository<Deliverer, Integer> {

    Deliverer findByUsername(String username);

    Deliverer findByUsernameAndPassword(String username, String password);

    public Deliverer findDelivererByUsername(String username);

    @Query(value = "SELECT * FROM deliverer d where d.del_id=?", nativeQuery = true)
    public Deliverer findDeliverer(int del_id);

}
