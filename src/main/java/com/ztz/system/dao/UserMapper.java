package com.ztz.system.dao;

import com.ztz.system.pojo.User;

import java.util.List;

public interface UserMapper {

    // 通过id查找用户
    User getUserById(Integer id);

    // 通过用户名查找用户
    User getUserByUsername(String username);

    // 获取所有用户
    List<User> getAllUsers();

    // 获取部分用户
    List<User> getSelectiveUsers(String username);

    // 增
    int insertUser(User user);

    // 删
    int deleteUser(Integer id);

    // 改
    int updateUser(User user);
}