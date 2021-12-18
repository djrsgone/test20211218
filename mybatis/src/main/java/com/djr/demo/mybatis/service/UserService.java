package com.djr.demo.mybatis.service;

import com.djr.demo.mybatis.pojo.User;

import java.util.List;

public interface UserService {

    List<User> findAll();
    User queryById(int id);
    User queryByIdCustom(Integer id);
    User queryByCondition(String name, String password);
    List<User> queryUserList(String password);

    boolean update(User user);
    boolean delete(int user);

    int create(User user);

    void testTrans();
}
