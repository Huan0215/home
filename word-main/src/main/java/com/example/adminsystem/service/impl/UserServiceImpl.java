package com.example.adminsystem.service.impl;

import com.example.adminsystem.mapper.UserMapper;
import com.example.adminsystem.model.User;
import com.example.adminsystem.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User getById(Long id){ return userMapper.selectById(id); }

    @Override
    public User getByUsername(String username){ return userMapper.selectByUsername(username); }

    @Override
    public User login(String username, String password){
        return userMapper.selectByUsernameAndPassword(username, password);
    }

    @Override
    public List<User> findByCondition(String username, String role){
        return userMapper.selectByCondition(username, role);
    }

    @Override
    public void create(User user){ userMapper.insert(user); }

    @Override
    public void update(User user){ userMapper.update(user); }

    @Override
    public void delete(Long id){ userMapper.deleteById(id); }
}
