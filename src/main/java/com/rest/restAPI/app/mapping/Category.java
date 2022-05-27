package com.rest.restAPI.app.mapping;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "category")
public class Category {

    @Column(name = "category_id")
    private int category_id;

    @Id
    @Column(name = "category_name")
    private String category_name;

    @OneToMany(targetEntity = Product.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "category", referencedColumnName = "category_name")
    private List<Product> products;
}
