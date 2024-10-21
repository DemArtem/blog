package com.ivl_plus.blog.controllers;

import com.ivl_plus.blog.models.Category;
import com.ivl_plus.blog.models.Product;
import com.ivl_plus.blog.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/products")
    public String getProducts(Model model) {
        List<Product> products = new ArrayList<>();

        // Добавляем продукты в список !!!!!
        products.add(new Product("Доска обрезная", "img/1.обрез.jpg", BigDecimal.valueOf(300),new Category(1L,"Доска")));
        products.add(new Product("Доска обрезная сухая", "img/2.обрез_сух.jpg",BigDecimal.valueOf(300),new Category(1L,"Доска")));


        // Добавляем список продуктов в модель
        model.addAttribute("products", products);
        return "products"; // Имя шаблона
    }
}

//подключить авторизацию   https://github.com/KirillovItstep/a0
//https://github.com/KirillovItstep/a1
//https://github.com/KirillovItstep/a1
//https://github.com/KirillovItstep/spring-thymeleaf-users
// http://localhost:8080/api/v1/products
// обычный контроллер
// bootstrap modal пробовать в VSCode

