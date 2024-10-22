package com.ivl_plus.blog.controllers;

import com.ivl_plus.blog.models.Category;
import com.ivl_plus.blog.models.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Controller
//@RestController
//@RequestMapping("/api/v1")
//@RequiredArgsConstructor
public class MainController {

	@GetMapping("/")
	public String home(Model model) {
		List<Product> products = new ArrayList<>();

		// Добавляем продукты в список !!!!!
		products.add(new Product("Доска обрезная", "img/1.обрез.jpg", BigDecimal.valueOf(300),new Category(1L,"Доска")));
		products.add(new Product("Доска обрезная сухая", "img/2.обрез_сух.jpg",BigDecimal.valueOf(300),new Category(1L,"Доска")));
		products.add(new Product("Доска обрезная сухая", "img/2.обрез_сух.jpg",BigDecimal.valueOf(300),new Category(1L,"Доска")));
		products.add(new Product("Доска обрезная сухая", "img/2.обрез_сух.jpg",BigDecimal.valueOf(300),new Category(1L,"Доска")));
		products.add(new Product("Доска обрезная сухая", "img/2.обрез_сух.jpg",BigDecimal.valueOf(300),new Category(1L,"Доска")));
		products.add(new Product("Доска обрезная сухая", "img/2.обрез_сух.jpg",BigDecimal.valueOf(300),new Category(1L,"Доска")));
		products.add(new Product("Доска обрезная сухая", "img/2.обрез_сух.jpg",BigDecimal.valueOf(300),new Category(1L,"Доска")));
		products.add(new Product("Доска обрезная сухая", "img/2.обрез_сух.jpg",BigDecimal.valueOf(300),new Category(1L,"Доска")));


		// Добавляем список продуктов в модель
		model.addAttribute("products", products);
		model.addAttribute("title", "Главная страница");
		return "home";
	}

	@GetMapping("/about")
	public String about(Model model) {
		model.addAttribute("title", "Cтраница про нас");
		return "about";
	}

	@GetMapping("/products")
	public String products(Model model) {
		List<Product> products = new ArrayList<>();

		// Добавляем продукты в список !!!!!
		products.add(new Product("Доска обрезная", "img/1.обрез.jpg", BigDecimal.valueOf(300),new Category(1L,"Доска")));
		products.add(new Product("Доска обрезная сухая", "img/2.обрез_сух.jpg",BigDecimal.valueOf(300),new Category(1L,"Доска")));
		products.add(new Product("Доска обрезная сухая", "img/2.обрез_сух.jpg",BigDecimal.valueOf(300),new Category(1L,"Доска")));
		products.add(new Product("Доска обрезная сухая", "img/2.обрез_сух.jpg",BigDecimal.valueOf(300),new Category(1L,"Доска")));


		// Добавляем список продуктов в модель
		model.addAttribute("products", products);
		return "products"; // Имя шаблона
	}

}