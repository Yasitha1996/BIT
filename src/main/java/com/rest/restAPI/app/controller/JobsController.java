package com.rest.restAPI.app.controller;

import com.rest.restAPI.app.bean.AddJobBean;
import com.rest.restAPI.app.bean.CartBean;
import com.rest.restAPI.app.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class JobsController {

    @Autowired
    JobService jobService;

    @PostMapping(value = "/addJobs",
                produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody HashMap<String, String> addJob( int order_id, int deliverer_id, String date){
        System.out.println("test1");
        //String result = "null";
        HashMap<String, String> status = new HashMap<>();

        try{
            if(jobService.addJobs(order_id, deliverer_id,  date)){
                //result = "Order has been placed!!";
                status.put("msg", "Job is added!!");
            }else {
                // result = "Order placement was not successful!";
                status.put("msg", "Job is not added!");
            }
        }catch (Exception e){
            System.out.println(e);
            // result = "System Error!";
            status.put("msg", "System Error!");
        }

        return status;
    }

    /*@PostMapping(value = "/addJobs",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody HashMap<String, String> addJob(AddJobBean addJobBean){
        System.out.println("test1");
        //String result = "null";
        HashMap<String, String> status = new HashMap<>();

        try{
            if(jobService.addJobs(addJobBean)==true){
                //result = "Order has been placed!!";
                status.put("msg", "Job is added!!");
            }else {
                // result = "Order placement was not successful!";
                status.put("msg", "Job is not added!");
            }
        }catch (Exception e){
            System.out.println(e);
            // result = "System Error!";
            status.put("msg", "System Error!");
        }

        return status;
    }*/

    @PostMapping(value = "/updateStatus",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody HashMap<String, String> updateStatus( int order_id){
        System.out.println("test1");
        //String result = "null";
        HashMap<String, String> status = new HashMap<>();

        try{
            if(jobService.updateStatus(order_id)){
                //result = "Order has been placed!!";
                status.put("msg", "Order has been placed!!");
            }else {
                // result = "Order placement was not successful!";
                status.put("msg", "Order placement was not successful!");
            }
        }catch (Exception e){
            System.out.println(e);
            // result = "System Error!";
            status.put("msg", "System Error!");
        }
        return status;
    }
}
