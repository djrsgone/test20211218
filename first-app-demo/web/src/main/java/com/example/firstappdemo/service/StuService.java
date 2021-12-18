package com.example.firstappdemo.service;

import com.example.firstappdemo.pojo.Stu;

public interface StuService {

    /**
     * 新增数据至数据库
     * @param stu
     */
    public void saveStu(Stu stu);
}
