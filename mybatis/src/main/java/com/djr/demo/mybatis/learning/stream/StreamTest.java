package com.djr.demo.mybatis.learning.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StreamTest {

    public static List<Stu> list = new ArrayList<Stu>();

    public static void main(String[] args){
        StreamTest test = new StreamTest();
        test.initList();
        //test.filter();
        //test.findFirst();
        //test.findAny();
        //test.anyMatch();
        //test.noneMatch();
        test.allMatch();
    }

    public void initList(){
        list.add(new Stu("公众号Java技术栈-Petty", 22, 1));
        list.add(new Stu("公众号Java技术栈-Tom", 38, 1));
        list.add(new Stu("公众号Java技术栈-Jessica", 43, 0));
        list.add(new Stu("公众号Java技术栈-John", 15, 1));
        list.add(new Stu("公众号Java技术栈-Lily", 25, 0));
        list.add(new Stu("公众号Java技术栈-Lambs", 28, 0));
        list.add(new Stu("公众号Java技术栈-Jack", 45, 1));
        list.add(new Stu("公众号Java技术栈-Addy", 9, 0));
        list.add(new Stu("公众号Java技术栈-Bob", 61, 1));
        list.add(new Stu("公众号Java技术栈-Candy", 26, 0));
    }

    public void filter(){
        System.out.println("搜索所有姓名包含 c 的人");
        list.stream().filter(u -> u.getName().contains("c")).forEach(System.out::println);
    }

    public void findFirst(){
        System.out.println("搜索第一个年纪 > 30的人");
        Optional<Stu> optional = list.stream().filter(u -> u.getAge() > 70).findFirst();
        if(optional.isPresent()){
            System.out.println(optional);
        }else{
            System.err.println("Not Found");
        }
    }

    public void findAny(){
        System.out.println("搜索任意一个年纪 > 30的人");
        Optional<Stu> optional = list.stream().filter(u -> u.getAge() > 30).findAny();
        System.out.println(optional);
    }

    public void anyMatch(){
        System.out.println("是否存在Jack: " + list.stream().anyMatch(u -> u.getName().contains("Jack")) );
        System.out.println("是否存在Jet: " + list.stream().anyMatch(u -> u.getName().contains("Jet")) );
    }

    public void noneMatch(){
        System.out.println("是否不存在Jack: " + list.stream().noneMatch(u -> u.getName().contains("Jack")) );
        System.out.println("是否不存在Jet: " + list.stream().noneMatch(u -> u.getName().contains("Jet")) );
    }

    public void allMatch(){
        System.out.println("所有人的年纪都大于3：" + list.stream().allMatch(stu -> stu.getAge() > 3));
        System.out.println("所有人的年纪都大于30：" + list.stream().allMatch(stu -> stu.getAge() > 30));
    }
}
