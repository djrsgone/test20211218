package com.djr.demo.mybatis.learning;

import com.djr.demo.mybatis.learning.stream.Stu;

import java.util.Arrays;

public class ClassLoaderTest {

    public static void main(String[] args)
    {
        try
        {

            Stu stu = (Stu) Class.forName("com.djr.demo.mybatis.learning.stream.Stu").newInstance();
            stu.setAge(10);
            stu.setName("baby");
            stu.setSex(1);
            System.out.println("stu = " + stu);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}
