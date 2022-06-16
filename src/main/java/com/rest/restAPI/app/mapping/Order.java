package com.rest.restAPI.app.mapping;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.text.DateFormat;
import java.util.Date;

@Entity
@Table(name = "order_p")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int order_id;

    @Column(name = "total")
    private double total;

    @Column(name = "date_initiated")
    private String date_initiated;

    @Column(name = "delivery_address")
    private String delivery_address;

    @Column(name = "delivery_location")
    private String delivery_location;

    @Column(name = "status")
    private String status;

    @Column(name = "pay_method")
    private String pay_method;

    /*@Column(name = "date_initiated")
    private Date date_initiated;*/

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
