package com.ivl_plus.blog.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    public Category(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Category() {}
}
