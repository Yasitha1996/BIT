package com.rest.restAPI.app.mapping;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {

    /*@ManyToOne
    private Category category;
*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int product_id;

    @Column(name = "product_name")
    private String product_name;

    @Column(name = "description")
    private String description;

    @Column(name = "product_img")
    private byte [] product_img;

    @Column(name = "unit_qty")
    private String unit_qty;

    @Column(name = "unit_price")
    private String unit_price;

    @Column(name = "available_stock")
    private String available_stock;

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getProduct_img() {
        return product_img;
    }

    public void setProduct_img(byte[] product_img) {
        this.product_img = product_img;
    }

    public String getUnit_qty() {
        return unit_qty;
    }

    public void setUnit_qty(String unit_qty) {
        this.unit_qty = unit_qty;
    }

    public String getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(String unit_price) {
        this.unit_price = unit_price;
    }

    public String getAvailable_stock() {
        return available_stock;
    }

    public void setAvailable_stock(String available_stock) {
        this.available_stock = available_stock;
    }
}
