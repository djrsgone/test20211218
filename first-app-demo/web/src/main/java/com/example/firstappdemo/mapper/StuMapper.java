package com.example.firstappdemo.mapper;

import com.example.firstappdemo.my.mapper.MyMapper;
import com.example.firstappdemo.pojo.Stu;
import org.springframework.stereotype.Repository;

@Repository
public interface StuMapper extends MyMapper<Stu> {
}