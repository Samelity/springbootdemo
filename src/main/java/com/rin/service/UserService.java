package com.rin.service;

import com.rin.entity.User;

import java.util.List;

public interface UserService {
    //新增用户
    int createUser(User user);

    //根据name查询信息
    List<User> getUser(int id);

    //根据name删除用户
    int deleteUser(int id);

    //获取用户总量
    int getAllUser();

    //获取所有用户列表
    List<User> getList();

    //更新指定id的user数据
    int updateUser(int id, User user);
}
