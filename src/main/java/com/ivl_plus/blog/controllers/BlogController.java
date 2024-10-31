package com.ivl_plus.blog.controllers;

import com.ivl_plus.blog.models.Post;
import com.ivl_plus.blog.models.Product;
import com.ivl_plus.blog.repo.PostRepository;
import com.ivl_plus.blog.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class BlogController {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private PostRepository postRepository;

    @GetMapping("/blog")
    public String blogMain(Model model) {

        List<Product> products = productRepository.findAll();
        model.addAttribute("products", products);

        try {
            UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            model.addAttribute("role", principal.getAuthorities().stream().findFirst().get());
            model.addAttribute("username", principal.getUsername());
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
        Iterable<Post> posts = postRepository.findAll();
        model.addAttribute("posts", posts);
        return "blog-main";
    }

    @GetMapping("/blog/add")
    public String blogAdd(Model model) {
        try {
            UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            model.addAttribute("role", principal.getAuthorities().stream().findFirst().get());
            model.addAttribute("username", principal.getUsername());
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
        return "blog-add";
    }

    @PostMapping("/blog/add") //добавление новой записи
    public String blogPostAdd(@RequestParam String title, @RequestParam String anons, @RequestParam String full_text, Model model) {
        Post post = new Post(title, anons, full_text);
        postRepository.save(post);
        try {
            UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            model.addAttribute("role", principal.getAuthorities().stream().findFirst().get());
            model.addAttribute("username", principal.getUsername());
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
        return "redirect:/blog";
    }

    @GetMapping("/blog/{id}")
    public String blogDetails(@PathVariable(value = "id") long id, Model model) {
        if (!postRepository.existsById(id)) { //если запись не найдена в БД, переход на blog
            return "redirect:/blog";
        }
        Optional<Post> post = postRepository.findById(id); //передаем запись в шаблон
        ArrayList<Post> res = new ArrayList<>();
        post.ifPresent(res::add);
        model.addAttribute("post", res);
        try {
            UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            model.addAttribute("role", principal.getAuthorities().stream().findFirst().get());
            model.addAttribute("username", principal.getUsername());
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
        return "blog-details";
    }

    @GetMapping("/blog/{id}/edit") //редактирование статьи
    public String blogEdit(@PathVariable(value = "id") long id, Model model) {
        if (!postRepository.existsById(id)) {
            return "redirect:/blog";
        }
        Optional<Post> post = postRepository.findById(id);
        ArrayList<Post> res = new ArrayList<>();
        post.ifPresent(res::add);
        model.addAttribute("post", res);
        try {
            UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            model.addAttribute("role", principal.getAuthorities().stream().findFirst().get());
            model.addAttribute("username", principal.getUsername());
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
        return "blog-edit";
    }

    @PostMapping("/blog/{id}/edit") //функция для обработки данных из таблицы
    public String blogPostUpdate(@PathVariable(value = "id") long id, @RequestParam String title, @RequestParam String anons, @RequestParam String full_text, Model model) {
        Post post = postRepository.findById(id).orElseThrow(); //вызов исключения, если запись не найдена
        post.setTitle(title);
        post.setAnons(anons);
        post.setFull_text(full_text);
        postRepository.save(post);
        try {
            UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            model.addAttribute("role", principal.getAuthorities().stream().findFirst().get());
            model.addAttribute("username", principal.getUsername());
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
        return "redirect:/blog";
    }

    @PostMapping("/blog/{id}/remove") //функция для удаления данных
    public String blogPostDelete(@PathVariable(value = "id") long id, Model model) {
        Post post = postRepository.findById(id).orElseThrow();
        postRepository.delete(post);
        try {
            UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            model.addAttribute("role", principal.getAuthorities().stream().findFirst().get());
            model.addAttribute("username", principal.getUsername());
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
        return "redirect:/blog";
    }

}
