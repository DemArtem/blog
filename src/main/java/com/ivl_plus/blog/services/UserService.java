package com.ivl_plus.blog.services;

import com.ivl_plus.blog.models.User;

public interface UserService {

    boolean save(User user);

    User findByUsername(String username);
}