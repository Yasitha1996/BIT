package com.rest.restAPI.app.bean;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class CartBean {
    private int amount;
    private String address;
    private int customer_id;

    private List<Map<String, Object>> items;

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    //private Date date;

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
