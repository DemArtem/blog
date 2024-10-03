package com.ivl_plus.blog.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "Orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "order_date")
    private LocalDateTime date;
    private String status;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer order;

}
