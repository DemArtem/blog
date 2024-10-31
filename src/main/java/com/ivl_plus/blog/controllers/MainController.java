package com.ivl_plus.blog.controllers;

import com.ivl_plus.blog.models.Product;
import com.ivl_plus.blog.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@Controller
public class MainController {
	@Autowired
	private ProductRepository productRepository;

	@GetMapping("/")
	public String home(Model model) {
		List<Product> products = productRepository.findAll();
		model.addAttribute("products", products);
		model.addAttribute("title", "Главная страница");
		try {
			UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			model.addAttribute("role", principal.getAuthorities().stream().findFirst().get());
			System.out.println(principal.getAuthorities().stream().findFirst().get());
			model.addAttribute("username", principal.getUsername());
		}catch (Exception exception){
			System.out.println(exception.getMessage());
		}
		return "home";
	}

	@GetMapping("/about")
	public String about(Model model) {
		List<Product> products = productRepository.findAll();
		model.addAttribute("products", products);

		try {
			UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			model.addAttribute("role", principal.getAuthorities().stream().findFirst().get());
			model.addAttribute("username", principal.getUsername());
		}catch (Exception exception){
			System.out.println(exception.getMessage());
		}
		model.addAttribute("title", "Cтраница про нас");
		return "about";
	}
}
