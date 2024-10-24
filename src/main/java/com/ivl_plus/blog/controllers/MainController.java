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
public class MainController {

	@GetMapping("/")
	public String home(Model model) {
		List<Product> products = new ArrayList<>();

		// Добавляем продукты в список !!!!!
		products.add(new Product("Доска обрезная (1м.куб.)", "img/1.обрез.jpg","Обрезная доска — пиломатериал размерами сечений от 16 × 8 мм до 250 × 100 мм. Обрезные доски изготавливаются из древесины разных пород. Основное отличие обрезной доски — это наличие обзола, не более допустимого по соответствующей нормативно-технической документации.", BigDecimal.valueOf(300),new Category(1L,"Доска")));
		products.add(new Product("Доска обрезная сухая (1м.куб.)", "img/2.обрез_сух.jpg", "Описание2", BigDecimal.valueOf(500),new Category(1L,"Доска")));
		products.add(new Product("Доска необрезная (1м.куб.)", "img/3.необрез.jpg","Описание3", BigDecimal.valueOf(300),new Category(1L,"Доска")));
		products.add(new Product("Доска необрезная сухая (1м.куб.)", "img/4.необрез_сух.jpg","Описание4", BigDecimal.valueOf(500),new Category(1L,"Доска")));
		products.add(new Product("Вагонка (1м.кв.)", "img/5.вагонка.jpg","Описание5", BigDecimal.valueOf(10),new Category(1L,"Доска")));
		products.add(new Product("Имитация бруса (1м.кв.)", "img/6.имитация.jpg","Описание6", BigDecimal.valueOf(20),new Category(1L,"Доска")));
		products.add(new Product("Блок-хаус (1м.кв.)", "img/7.блок-хаус.jpg","Описание7", BigDecimal.valueOf(25),new Category(1L,"Доска")));
		products.add(new Product("Доска пола (1м.кв.)", "img/8.доска пола.jpg","Описание8", BigDecimal.valueOf(25),new Category(1L,"Доска")));
		products.add(new Product("Террасная доска (1м.кв.)", "img/9.террасная доска.jpg","Описание9", BigDecimal.valueOf(30),new Category(1L,"Доска")));
		products.add(new Product("Туалет односкатный", "img/10.туал_односк1.jpg","Описание10", BigDecimal.valueOf(420),new Category(1L,"Туалет")));
		products.add(new Product("Туалет двухскатный", "img/11.туал_двухск1.jpg","Описание11", BigDecimal.valueOf(500),new Category(1L,"Туалет")));
		products.add(new Product("Туалет-кукушка", "img/12.туал_кукушка1.jpg","Описание12", BigDecimal.valueOf(700),new Category(1L,"Туалет")));
		products.add(new Product("Будка", "img/13.будка1.jpg","Описание13", BigDecimal.valueOf(250),new Category(1L,"Будка")));
		products.add(new Product("Колодец", "img/14.колодец1.jpg","Описание14", BigDecimal.valueOf(450),new Category(1L,"Колодец")));
		products.add(new Product("Душевая кабина", "img/15.душ_каб1.jpg","Описание15", BigDecimal.valueOf(700),new Category(1L,"Душевая кабина")));


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

}
//подключить авторизацию   https://github.com/KirillovItstep/a0
//https://github.com/KirillovItstep/a1
//https://github.com/KirillovItstep/a1
//https://github.com/KirillovItstep/spring-thymeleaf-users
//пагинация