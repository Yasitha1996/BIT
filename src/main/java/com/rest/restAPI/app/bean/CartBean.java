package com.rest.restAPI.app.bean;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class CartBean {
    private double amount;
    private String address;
    private int customer_id;

    private String pay_method;

    private String date_initiated;

    public String getDate_initiated() {
        return date_initiated;
    }

    public void setDate_initiated(String date_initiated) {
        this.date_initiated = date_initiated;
    }

    public String getPay_method() {
        return pay_method;
    }

    public void setPay_method(String pay_method) {
        this.pay_method = pay_method;
    }

    private String delivery_location;

    public String getDelivery_location() {
        return delivery_location;
    }

    public void setDelivery_location(String delivery_location) {
        this.delivery_location = delivery_location;
    }
    /* private java.util.Date date;

    public java.util.Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }*/

    private List<Map<String, Object>> items;

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }


    public List<Map<String, Object>> getItems() {
        return items;
    }

    public void setItems(List<Map<String, Object>> items) {
        this.items = items;
    }


}
