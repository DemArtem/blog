package com.ivl_plus.blog.controllers;

import com.ivl_plus.blog.models.Product;
import com.ivl_plus.blog.serviсes.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(name = "/api/v1")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping("/products")
    public String saveProduct() {
        Product product = productService.save();
        System.out.println(product);
        return "";
    }
}

//  http://localhost:8080/api/v1/products
// нужно через рест контроллер
