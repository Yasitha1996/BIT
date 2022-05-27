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

    @Autowired
    CustomerVal val;

    @Autowired
    private CusRepo cusRepo;

    @PostMapping(path = "/save", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody HashMap<String, String> register(@RequestBody Customer customer) {
        // System.out.println(customer);
        HashMap<String, String> status = new HashMap<>();

        try {
            HashMap<String, String> validationRes = val.registerCus(customer.getUsername());

            if (validationRes == null) {
                Customer cus = new Customer();
                cus = customerService.register(customer);
                status.put("msg", "Registered Successfully");
                // return "Registered Successfully";
            } else {
                return validationRes;
            }
        } catch (Exception ex) {
            status.put("msg", "Registration failed");
            // return "Registration failed!";
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

        System.out.println(bean.getUsername());
        System.out.println(bean.getPassword());
        HashMap<String, String> status = new HashMap<>();

        try {

            Customer cus = customerService.login(bean.getUsername(), bean.getPassword());
            if (cus == null) {
                status.put("msg", "Invalid Credentials");
                status.put("code", "0");
            } else {
                System.out.println("Login");
                //String cusID = String.valueOf(customerService.getCustomerID(bean.getUsername()));
                status.put("msg", "Login Successful!");
                status.put("code", "1");
                //status.put("id", String.valueOf(id));
                //return new ResponseEntity<>("Login Successful!", HttpStatus.OK);
            }
        } catch (Exception e) {
            status.put("msg", "Something went wrong:" + e);
            status.put("code", "2");
        }
        return status;
    }
}



