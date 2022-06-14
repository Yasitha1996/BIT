package com.rest.restAPI.app.repo;

import com.rest.restAPI.app.mapping.Deliverer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DelivererRepo extends JpaRepository<Deliverer, Integer> {

    Deliverer findByUsername(String username);

    Deliverer findByUsernameAndPassword(String username, String password);

    public Deliverer findDelivererByUsername(String username);

}
