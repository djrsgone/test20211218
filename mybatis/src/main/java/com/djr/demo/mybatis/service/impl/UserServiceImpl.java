package com.djr.demo.mybatis.service.impl;

import com.djr.demo.mybatis.mappers.UserMapper;
import com.djr.demo.mybatis.my.mapper.UserMapperCustom;
import com.djr.demo.mybatis.pojo.User;
import com.djr.demo.mybatis.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.UUID;

@Service("userService")
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserMapperCustom userMapperCustom;

    @Override
    public User queryById(int id) {
        return userMapper.selectByPrimaryKey(Integer.valueOf(id));
    }

    @Override
    public User queryByCondition(String name, String password) {
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("username", name);
        criteria.andEqualTo("password", password);
        return userMapper.selectOneByExample(example);
    }

    @Override
    public List<User> queryUserList(String password) {
//        Example example = new Example(User.class);
//        Example.Criteria criteria = example.createCriteria();
//        criteria.andEqualTo("password", password);
//        return userMapper.selectByExample(example);

        User user = new User();
        user.setPassword(password);
        return userMapper.select(user);
    }

    @Override
    public List<User> findAll() {
        //return userMapper.findAll();
        return userMapper.selectAll();
    }

    @Override
    public int create(User user) {
        int result = this.userMapper.insert(user);
        return result;
    }

    @Override
    public boolean update(User user) {
        //return this.userMapper.updateByPrimaryKey(user) > 0;
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id", user.getId());
        return this.userMapper.updateByExample(user, example)  > 0;
    }

    @Override
    public boolean delete(int id) {
//        int ret = this.userMapper.deleteByPrimaryKey(id);
//        log.info("UserServiceImpl deleteResult = " + ret);
//        return ret > 0;


//        Example example = new Example(User.class);
//        Example.Criteria criteria = example.createCriteria();
//        criteria.andEqualTo("id", id);
//
//        int ret = this.userMapper.deleteByExample(example);
//        log.info("UserServiceImpl deleteResult = " + ret);
//        return ret > 0;

        User user = new User();
        user.setId(id);
        int ret = this.userMapper.delete(user);
        log.info("UserServiceImpl deleteResult = " + ret);
        return ret > 0;
    }

    @Transactional
    @Override
    public void testTrans() {
        User user1 = new User();
        user1.setId(5);
        user1.setUsername(UUID.randomUUID().toString());
        user1.setPassword("pass5");
        userMapper.insert(user1);

        int val = 100 /0;

        User user2 = new User();
        user2.setId(4);
        user2.setUsername("abc2");
        user2.setPassword("pass2");
        userMapper.updateByPrimaryKey(user2);
    }

    @Override
    public User queryByIdCustom(Integer id) {
        List<User> userList = this.userMapperCustom.queryByIdCustom(id);
        User user = userList != null && !userList.isEmpty() ? userList.get(0) : null;
        return user;
    }
}
