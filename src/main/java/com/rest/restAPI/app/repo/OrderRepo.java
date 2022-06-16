package com.rest.restAPI.app.repo;

import com.rest.restAPI.app.bean.JobItemBean;
import com.rest.restAPI.app.mapping.Order;
import org.aspectj.weaver.ast.Or;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface OrderRepo extends JpaRepository<Order, Integer> {

    @Query(value = "SELECT * FROM order_p o where o.status='2'", nativeQuery = true)
    public List<Order> getJobItemList();


    @Modifying
    @Transactional
    @Query(value = "UPDATE order_p o SET o.ststus='3' WHERE o.order_id=?", nativeQuery = true)
    void jobUpdated(int order_id);

    @Query(value = "SELECT * FROM order_p o where o.status='3' AND o.customer_id=?", nativeQuery = true)
    public List<Order> getJobList(int customer_id);

    @Query(value = "SELECT * FROM order_p o where o.order_id=?", nativeQuery = true)
    public Order findOrder(int order_id);

}
