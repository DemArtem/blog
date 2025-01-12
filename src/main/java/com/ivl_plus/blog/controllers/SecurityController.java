package com.ivl_plus.blog.controllers;

import com.ivl_plus.blog.models.User;
import com.ivl_plus.blog.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class SecurityController {
 
    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(User user, Model model) {
        model.addAttribute("user", user);
        String result = userService.save(user); //получаем результат сохранения

        if (result != null) { //если результат не null, значит, произошла ошибка
            model.addAttribute("errorMessage", result); //добавляем сообщение об ошибке
            model.addAttribute("user", new User()); //очищаем форму
            return "register"; //возвращаемся к форме регистрации
        }
        return "redirect:/login"; //успешная регистрация
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}