package com.ivl_plus.blog.controllers;

import com.ivl_plus.blog.models.Product;
import com.ivl_plus.blog.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping("/products")
    public List<Product> saveProduct() {
        System.out.println("request ....");
        List<Product> product = productService.list();
        System.out.println(product);
        return product;
    }
}

//подключить авторизацию   https://github.com/KirillovItstep/a0
//https://github.com/KirillovItstep/a1
//https://github.com/KirillovItstep/a1
//https://github.com/KirillovItstep/spring-thymeleaf-users
// http://localhost:8080/api/v1/products
// обычный контроллер
// bootstrap modal пробовать в VSCode

