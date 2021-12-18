package com.example.firstappdemo.controller;

import com.example.firstappdemo.pojo.Stu;
import com.example.firstappdemo.service.StuService;
import com.example.firstappdemo.utils.JSONResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("dbstu")
@Slf4j
public class NewStuController {

    @Autowired
    private StuService stuService;

    @PostMapping("insert")
    @ResponseBody
    public Object insert(){
        String id = UUID.randomUUID().toString();

        Stu stu = new Stu();
        stu.setId(id);
        stu.setNane("慕课网学习");
        stu.setSex(1);
        stuService.saveStu(stu);
        return JSONResult.ok();
    }
}
