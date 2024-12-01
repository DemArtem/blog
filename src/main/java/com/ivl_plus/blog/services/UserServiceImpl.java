package com.ivl_plus.blog.services;

import com.ivl_plus.blog.models.Role;
import com.ivl_plus.blog.models.User;
import com.ivl_plus.blog.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public String save(User user) { // Изменяем возвращаемый тип на String
        User userFromDB = userRepository.findByUsername(user.getUsername());

        if (userFromDB != null) {
            return "Пользователь с таким именем уже зарегистрирован"; // Возвращаем сообщение об ошибке
        }

        user.setPassword(passwordEncoder.encode(user.getPassword())); // Шифрование пароля
        user.setRole(Role.USER); // Установка роли пользователя
        userRepository.save(user); // Сохранение пользователя в базе данных
        return null; // Успешное сохранение, возвращаем null
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

}