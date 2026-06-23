package com.example.adminsystem.service;

import com.example.adminsystem.model.User;
import java.util.List;

public interface UserService {
    User getById(Long id);
    User getByUsername(String username);
    User login(String username, String password);
    List<User> findByCondition(String username, String role);
    void create(User user);
    void update(User user);
    void delete(Long id);
}
