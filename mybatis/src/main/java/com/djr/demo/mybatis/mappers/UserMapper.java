package com.djr.demo.mybatis.mappers;

import com.djr.demo.mybatis.my.mapper.MyMapper;
import com.djr.demo.mybatis.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper//指定这是一个操作数据库的mapper
public interface UserMapper extends MyMapper<User> {
//    List<User> findAll();


}
