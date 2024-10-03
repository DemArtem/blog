package com.ivl_plus.blog.repo;

import com.ivl_plus.blog.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
