package com.djr.demo.mybatis.controller;

import com.djr.demo.mybatis.utils.JSONResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.servlet.http.HttpServletRequest;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.*;


@Controller
@Slf4j
@RequestMapping("/test")
public class HelloController {

    @Autowired
    private TemplateEngine templateEngine;

    @GetMapping("/test")
    @ResponseBody
    public Object test(){
        return JSONResult.ok();
    }

    @GetMapping("/hello")
    @ResponseBody
    public String hello(Model model, HttpServletRequest request) throws IOException {
        log.info("enter hello");
        model.addAttribute("there", "Happy Each Day");
        model.addAttribute("datevalue", new Date());

        int sex = 2;
        model.addAttribute("sex", sex);

        List<String> myList = new LinkedList<>();
        myList.add("Java");
        myList.add("HTML");
        myList.add("SpringBoot");
        myList.add("大数据");
        model.addAttribute("myList", myList);

        Map<String, Object> myMap = new LinkedHashMap<>();
        myMap.put("id", "1001");
        myMap.put("name", "Jack");
        myMap.put("sex", "男");
        myMap.put("loves", myList);
        model.addAttribute("myMap", myMap);

        Context context = new Context();
        context.setVariable("there", "Happy Each Day");
        context.setVariable("datevalue", new Date());
        context.setVariable("sex", 2);
        context.setVariable("myList", myList);
        context.setVariable("myMap", myMap);

        Writer writer = new FileWriter("d:/springtest.html");

        templateEngine.process("teacher", context, writer);
        writer.close();

//        request.setAttribute("englishName", "xyzbc");
//        request.getSession().setAttribute("usertoken", "abcd-xyzf-1234-5678");

        log.info("end hello");
//        return "teacher";
        return "ok";
    }

}
