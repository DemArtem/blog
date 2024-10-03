package com.ivl_plus.blog.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String email;
    private String phone;
    private String address;
}
