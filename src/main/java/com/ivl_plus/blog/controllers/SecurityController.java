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
        String result = userService.save(user); // Получаем результат сохранения

        if (result != null) { // Если результат не null, значит, произошла ошибка
            model.addAttribute("errorMessage", result); // Добавляем сообщение об ошибке
            model.addAttribute("user", new User()); // Очищаем форму
            return "register"; // Возвращаемся к форме регистрации
        }
        return "redirect:/login"; // Успешная регистрация
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}