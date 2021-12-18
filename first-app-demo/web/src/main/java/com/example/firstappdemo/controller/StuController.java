package com.example.firstappdemo.controller;

import com.example.firstappdemo.domain.Student;
import com.example.firstappdemo.utils.JSONResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletRequest;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("stu")
@Slf4j
public class StuController {

    @GetMapping("{stuId}/get")
    @ResponseBody
    public Object getStudent(@PathVariable("stuId") String stuId,
                             ServletRequest request){
                             //@RequestParam Integer id,
                             //@RequestParam String name){
        String idStr = request.getParameter("id");

        int id = Integer.parseInt(idStr);
        String name = request.getParameter("name");

        Student student = new Student();
        student.setName(name);
        student.setAge(id);
        log.info("stuId=" + stuId + ", student=" + student);

        return JSONResult.ok(student);
    }

    @PostMapping("create")
    @ResponseBody
    public String postStudent(@RequestBody Map<String, Object> map,
                              @RequestHeader("token") String token,
                              @CookieValue("clientId") String clientId,
                              HttpServletRequest request){
        log.info("token=" + token);
        log.info("clientId=" + clientId);
        log.info("map=" + map.toString());

        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies){
            log.info("[RequestCookie]" + cookie.getValue());
        }

        String headerToken = request.getHeader("token");
        log.info("headerToken=" + headerToken);

        return "创建stu";
    }

    @PutMapping("put")
    @ResponseBody
    public String putStudent()
    {
        return "更改stu";
    }

    @DeleteMapping("delete")
    @ResponseBody
    public String deleteStudent(){
        return "删除stu";
    }

    @PostMapping("upload")
    public String upload(MultipartFile file) throws IOException {
        file.transferTo(new File("d:/test.png"));
        return "上传成功";
    }

}
