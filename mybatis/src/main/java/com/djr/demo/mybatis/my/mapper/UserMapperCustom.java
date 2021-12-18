package com.djr.demo.mybatis.my.mapper;

import com.djr.demo.mybatis.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface UserMapperCustom {

    public List<User> queryByIdCustom(Integer sId);

}
