package com.rest.restAPI.app.repo;

import com.rest.restAPI.app.mapping.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CusRepo extends JpaRepository<Customer, Integer> {
    Customer findByUsername(String username);

    Customer findCustomerByUsernameAndPassword(String username, String password);

    public Customer findCustomerByUsername(String username);
}
