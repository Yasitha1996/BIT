package com.rest.restAPI.app.mapping;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "order_p")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int order_id;

    @Column(name = "total")
    private Integer total;

   /* @Column(name = "date")
    private Date date;*/

    @Column(name = "delivery_address")
    private String delivery_address;

    @Column(name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
