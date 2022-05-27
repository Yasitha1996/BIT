package com.rest.restAPI.app.mapping;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
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


}
