package com.rest.restAPI.app.controller;

import com.rest.restAPI.app.bean.LoginBean;
import com.rest.restAPI.app.mapping.Customer;
import com.rest.restAPI.app.mapping.Deliverer;
import com.rest.restAPI.app.service.DelivererService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/deliverer")
public class DelivererController {

    @Autowired
    DelivererService delivererService;

    @PostMapping(path = "/save", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody HashMap<String, String> register(@RequestBody Deliverer deliverer) {
        // System.out.println(customer);
        HashMap<String, String> status = new HashMap<>();

        try {
            //HashMap<String, String> validationRes = val.registerCus(customer.getUsername());

            if (delivererService.alreadyExists(deliverer.getUsername()) == false) {
                Deliverer del = new Deliverer();
                del = delivererService.register(deliverer);
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

    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    HashMap<String, String> login(@RequestBody LoginBean bean) {

        System.out.println(bean.getUsername());
        System.out.println(bean.getPassword());
        HashMap<String, String> status = new HashMap<>();

        try {

            Deliverer del = delivererService.login(bean.getUsername(), bean.getPassword());
            String deliverer_id = delivererService.getDelivererId(bean.getUsername());

            if(del == null) {
                status.put("msg", "Invalid Credentials");
                status.put("code", "0");
            } else {
                System.out.println("Login");
                //String cusID = String.valueOf(customerService.getCustomerID(bean.getUsername()));
                status.put("msg", "Login Successful!");
                status.put("code", "1");
                status.put("id", deliverer_id);
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
