package com.rest.restAPI.app.service;

import com.rest.restAPI.app.mapping.Deliverer;
import com.rest.restAPI.app.mapping.Jobs;
import com.rest.restAPI.app.mapping.Order;
import com.rest.restAPI.app.repo.DelivererRepo;
import com.rest.restAPI.app.repo.JobRepo;
import com.rest.restAPI.app.repo.OrderRepo;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobService {
    @Autowired
    JobRepo jobRepo;

    @Autowired
    OrderRepo orderRepo;

    @Autowired
    DelivererRepo delivererRepo;

    public boolean updateStatus(int order_id){
        Order order = new Order();
        try {
            order = orderRepo.findOrder(order_id);
            order.setStatus("3");
            orderRepo.save(order);
            return true;
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
    }

    public boolean addJobs(Integer order_id, Integer deliverer_id, String date){
        boolean result = false;

        try {
            if(updateStatus(order_id)){
                Order order = new Order();
                order = orderRepo.findOrder(order_id);
                Deliverer deliverer = new Deliverer();
                deliverer = delivererRepo.findDeliverer(deliverer_id);

                Jobs jobs = new Jobs();
                //order.setOrder_id(order_id);
                jobs.setOrder(order);
                jobs.setDeliverer(deliverer);
                jobs.setJob_status("1");
                jobs.setJob_taken_date(date);
                jobs.setJob_finished_date("NOT_YET");
                jobRepo.save(jobs);
                result = true;
            }else {
                result =false;
            }
        }catch (Exception e){
            System.out.println(e);
        }

        return result;
    }

}
