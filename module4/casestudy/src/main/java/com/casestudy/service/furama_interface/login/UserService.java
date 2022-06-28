package com.casestudy.service.furama_interface.login;

import com.casestudy.model.login.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User findById(String username);

    void save(User user);

    void saveUserRole(int id, String name);
}
