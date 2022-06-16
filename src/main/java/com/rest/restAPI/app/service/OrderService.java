package com.rest.restAPI.app.service;

import com.rest.restAPI.app.bean.JobItemBean;
import com.rest.restAPI.app.mapping.Cart;
import com.rest.restAPI.app.mapping.Order;
import com.rest.restAPI.app.mapping.Product;
import com.rest.restAPI.app.repo.CartRepo;
import com.rest.restAPI.app.repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private CartRepo cartRepo;

    public String add(Order order) {
        String msg ="";
    try {
        Product p = new Product();
        p.setProduct_name("kh");
        Order o = new Order();
        o.setOrder_id(1);

        Cart c = new Cart();
        c.setOrder(order);
        c.setProduct(p);

        cartRepo.save(c);
//        return orderRepo.save(order);
    }catch (Exception e){
        System.out.println(e);
    }
    return msg;
    }

    public List<Order> findAll() {
        List<Order> orders = new ArrayList<>();
        try {
             orders = orderRepo.findAll();
        } catch (Exception e) {
            System.out.println(e);
        }
        return orders;
    }

    public List<JobItemBean> getJobList(){
        List<JobItemBean> jobList = new ArrayList<>();
        try {
            List<Order> list = orderRepo.getJobItemList();
            for (Order o :
                    list) {
                JobItemBean jobItemBean = new JobItemBean();
                jobItemBean.setOrder_id(o.getOrder_id());
                jobItemBean.setDelivery_address(o.getDelivery_address());
                jobItemBean.setDelivery_location(o.getDelivery_location());
                jobItemBean.setStatus(o.getStatus());
                jobItemBean.setPay_method(o.getPay_method());
                jobItemBean.setTotal(o.getTotal());
                jobItemBean.setFirstName(o.getCustomer().getFirstname());
                jobItemBean.setLastName(o.getCustomer().getLastname());
                jobItemBean.setContact(o.getCustomer().getPhone());
                jobItemBean.setUsername(o.getCustomer().getUsername());
                jobList.add(jobItemBean);

            }
        }catch (Exception e){
            System.out.println(e);
        }
       return jobList;
    }

    public String jobUpdated(int order_id){
        String result = "";
        try {
             //orderRepo.jobUpdated(order_id);
             result = "Success";
         /*if(orderRepo.jobUpdated(order_id)){
             result = "successful";
         }else {
             result = "unsuccessful";
         }*/
        }catch (Exception e){
            System.out.println(e);
            result = "Failed";
        }
        return result;
    }

    public List<JobItemBean> getAddedJobList(int deliverer_id){
        List<JobItemBean> jobList = new ArrayList<>();
        try {
            List<Order> list = orderRepo.getJobList(deliverer_id);
            for (Order o :
                    list) {
                JobItemBean jobItemBean = new JobItemBean();
                jobItemBean.setOrder_id(o.getOrder_id());
                jobItemBean.setDelivery_address(o.getDelivery_address());
                jobItemBean.setDelivery_location(o.getDelivery_location());
                jobItemBean.setStatus(o.getStatus());
                jobItemBean.setPay_method(o.getPay_method());
                jobItemBean.setTotal(o.getTotal());
                jobItemBean.setFirstName(o.getCustomer().getFirstname());
                jobItemBean.setLastName(o.getCustomer().getLastname());
                jobItemBean.setContact(o.getCustomer().getPhone());
                jobItemBean.setUsername(o.getCustomer().getUsername());
                jobList.add(jobItemBean);

            }
        }catch (Exception e){
            System.out.println(e);
        }
        return jobList;
    }
}
