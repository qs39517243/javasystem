package com.ztz.system.service.imp;

import com.ztz.system.pojo.User;

import java.util.List;

public interface UserServiceImp {

    // id查询单个用户
    public User getUserById(Integer id);

    // username查询单个用户
    public User getUserByUsername(String username);

    // 查询所有用户
    public List<User> getAllUsers();

    // 条件查询用户
    public List<User> getSelectiveUsers(String text);

    // 添加新用户
    public Integer insertUser(User user);

    // 删除用户
    public Integer deleteUser(Integer id);

    // 更新用户信息
    public Integer updateUser(User user);
}
