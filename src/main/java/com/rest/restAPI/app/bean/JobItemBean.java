package com.rest.restAPI.app.bean;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class JobItemBean {

    private int order_id;
    private double total;
    private String delivery_address;
    private String status;
    private String delivery_location;
    private String pay_method;
    private String firstName;
    private String lastName;
    private String username;
    private String contact;
}
