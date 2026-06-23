package com.example.adminsystem.mapper;

import com.example.adminsystem.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    User selectById(Long id);
    User selectByUsername(@Param("username") String username);

    User selectByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

    List<User> selectByCondition(@Param("username") String username, @Param("role") String role);

    int insert(User user);
    int update(User user);
    int deleteById(Long id);
}
