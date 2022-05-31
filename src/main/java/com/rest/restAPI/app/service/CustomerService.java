package com.rest.restAPI.app.service;

import com.rest.restAPI.app.mapping.Customer;
import com.rest.restAPI.app.repo.CusRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class CustomerService {


    @Autowired
    private CusRepo cusRepo;

    public Customer register(Customer customer){

        return cusRepo.save(customer);

    }

    public List<Customer> findAll(){

        return cusRepo.findAll();
    }

    public Customer login(String username, String password){

       return cusRepo.findCustomerByUsernameAndPassword(username, password);

    }

    public String getCustomerID(String username){
        Customer customer = cusRepo.findCustomerByUsername(username);
        String customer_id = String.valueOf(customer.getId());
        return customer_id;
    }

    public boolean alreadyExists(String username){
        Customer customer = cusRepo.findByUsername(username);
        boolean isCustomer = false;
        try {
            if(customer!= null){
                isCustomer = true;
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return isCustomer;
    }




}
