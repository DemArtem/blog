package com.ivl_plus.blog.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@Table(name = "Products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private Integer stock;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Product(String name, String description, BigDecimal price, Integer stock, Category category) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.category = category;
    }

    public Product() {}
}