package com.rest.restAPI.app.controller;

import com.rest.restAPI.app.bean.CartBean;
import com.rest.restAPI.app.bean.JobItemBean;
import com.rest.restAPI.app.mapping.Order;
import com.rest.restAPI.app.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    /*@PostMapping("/checkout")
    public Order order(@RequestBody Order order){
        return orderProductService.add(order);
    }*/

    @GetMapping(value = "/jobItems", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<JobItemBean> getJobList(){
        List<JobItemBean> jobList = new ArrayList<>();
        System.out.println("list1");
        try {
            jobList = orderService.getJobList();
        }catch (Exception e){
            System.out.println(e);
        }
        return jobList;
    }

    @GetMapping("/fetch")
    public List<Order> findAll(){
        return orderService.findAll();
    }

    @PostMapping("/addJob")
    public @ResponseBody HashMap<String, String> addJob(int order_id){
        HashMap<String, String> result = new HashMap<>();
        try {
            String status = orderService.jobUpdated(order_id);
            if (status.equals("successful")){
                result.put("msg", "Added to cart successfully");
            }else if(status.equals("unsuccessful")){
                result.put("msg", status+" item(s) are available at the moment");
            }

        }catch (Exception e){
            result.put("msg", "System Error");
        }
        return result;
    }

    @GetMapping(value = "/addedJobItems", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<JobItemBean> addedJobItems(int deliverer_id){
        List<JobItemBean> jobList = new ArrayList<>();
        System.out.println("list1");
        try {
            jobList = orderService.getAddedJobList(deliverer_id);
        }catch (Exception e){
            System.out.println(e);
        }
        return jobList;
    }

}
