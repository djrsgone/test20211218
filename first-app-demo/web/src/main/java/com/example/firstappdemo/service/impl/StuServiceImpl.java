package com.example.firstappdemo.service.impl;

import com.example.firstappdemo.mapper.StuMapper;
import com.example.firstappdemo.pojo.Stu;
import com.example.firstappdemo.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class StuServiceImpl implements StuService {

//    @Autowired
//    private StuMapper stuMapper;

    @Override
    public void saveStu(Stu stu) {
//        String id = stu.getId();
//        if(stuMapper.existsWithPrimaryKey(id)){
//            stuMapper.updateByPrimaryKey(stu);
//        }else{
//            stuMapper.insert(stu);
//        }
//        stuMapper.insert(stu);
    }
}
