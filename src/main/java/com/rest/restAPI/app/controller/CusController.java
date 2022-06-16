package com.rest.restAPI.app.controller;

import com.rest.restAPI.app.bean.LoginBean;
import com.rest.restAPI.app.repo.CusRepo;
import com.rest.restAPI.app.service.CustomerService;
import com.rest.restAPI.app.mapping.Customer;
import com.rest.restAPI.app.validation.CustomerVal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CusController {

    @Autowired
    private CustomerService customerService;

   /* @Autowired
    CustomerVal val;*/


    @PostMapping(path = "/save", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody HashMap<String, String> register(@RequestBody Customer customer) {
        // System.out.println(customer);
        HashMap<String, String> status = new HashMap<>();

        try {
            //HashMap<String, String> validationRes = val.registerCus(customer.getUsername());

            if (customerService.alreadyExists(customer.getUsername()) == false) {
                Customer cus = new Customer();
                cus = customerService.register(customer);
                status.put("msg", "Registered Successfully");
                // return "Registered Successfully";
            } else {
                //return validationRes;
                status.put("msg", "Username already taken");
            }
        } catch (Exception ex) {
            status.put("msg", "Registration failed");
            // return "Registration failed!";
        }
        return status;
    }

    @PostMapping(path = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody HashMap<String, String> updateCustomer(@RequestBody Customer customer) {

        HashMap<String, String> status = new HashMap<>();

        try {
            if (customerService.updateCustomer(customer) == true) {
                status.put("msg", "Update Successful");
            } else {
                status.put("msg", "update failed");
            }
        } catch (Exception ex) {
            status.put("msg", "System error");
        }
        return status;
    }

   /* @PostMapping("/save")
    public @ResponseBody String res(@RequestBody Customer customer){
        Customer cus = cusRepo.save(customer);
        return "Registered Successfully!";
    }*/

    @GetMapping("/all")
    public List<Customer> findAll() {

        return customerService.findAll();
    }

    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    HashMap<String, String> login(@RequestBody LoginBean bean) {

        HashMap<String, String> status = new HashMap<>();
        // HashMap<String, Object> result = new HashMap<>();

        try {

            Customer cus = customerService.login(bean.getUsername(), bean.getPassword());


            if (cus == null) {
                status.put("msg", "Invalid Credentials");
                status.put("code", "0");
            } else {
                String customer_id = customerService.getCustomerID(bean.getUsername());
                status.put("msg", "Login Successful!");
                status.put("code", "1");
                status.put("id", customer_id);
                //  result.put("customer", cus);
            }
        } catch (Exception e) {
            status.put("msg", "Something went wrong");
            status.put("code", "2");
            System.out.println("Exception login: " + e);
        }
        return status;
    }
}



