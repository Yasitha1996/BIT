package com.rest.restAPI.app.validation;

import com.rest.restAPI.app.mapping.Customer;
import com.rest.restAPI.app.repo.CusRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;


@Component
public class CustomerVal {
    HashMap<String, String> status = new HashMap<>();
    @Autowired
    CusRepo cusRepo;
    /*public HashMap<String, String> registerCus(String username){
        Customer already = cusRepo.findByUsername(username);
        if(already != null){
            status.put("msg","User already exits");
            //return "User already exits";
        }else {
            return null;
        }
        return status;
    }*/
}
