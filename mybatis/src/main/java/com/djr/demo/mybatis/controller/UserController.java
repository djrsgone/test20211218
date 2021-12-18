package com.djr.demo.mybatis.controller;

import com.djr.demo.mybatis.pojo.User;
import com.djr.demo.mybatis.pojo.bo.UserBO;
import com.djr.demo.mybatis.service.UserService;
import com.djr.demo.mybatis.utils.JSONResult;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/user")
public class UserController {

    private static AtomicInteger idGenerator = new AtomicInteger(4);

    @Autowired
    private UserService userService;

    @GetMapping("/query")
//    public JSONResult query(@RequestParam int id){
      public JSONResult query(
              //@RequestParam String username,
              @RequestParam String password) {
//        User user = userService.queryById(id);
//        User user = userService.queryByCondition(username, password);
        List<User> userList = userService.queryUserList(password);
        JSONResult jsonResult =  userList == null ?
                JSONResult.errorException("指定用户不存在(password=" + password + ")") : JSONResult.ok(userList);
        return jsonResult;
    }

    @GetMapping("/query2/{sId}")
    @ResponseBody
    public JSONResult query2(@PathVariable int sId)
    {
        if(sId <= 0){
            JSONResult jsonResult = JSONResult.errorMsg("sId should be > 0");
            return jsonResult;
        }

        User user = this.userService.queryByIdCustom(sId);
        JSONResult jsonResult = user == null ? JSONResult.errorMsg("fail to query user") : JSONResult.ok(user);
        return jsonResult;
    }

    @RequestMapping("/findAll")
    public List<User> findAll(){
        return userService.findAll();
    }

    @PostMapping("/create")
    public JSONResult create(@Valid @RequestBody UserBO userBO,
                             BindingResult bindingResult){
        //判断BindingResult是否有错误，错误信息会包含在里面，如果有则直接return
        if(bindingResult.hasErrors()){
            Map<String, String> map = getErrors(bindingResult);
            JSONResult jsonResult = JSONResult.errorMap(map);
            return jsonResult;
        }

        User user = new User();
        BeanUtils.copyProperties(userBO, user);
        user.setId(idGenerator.incrementAndGet());

        int result = this.userService.create(user);
        JSONResult jsonResult = JSONResult.ok(result);
        return jsonResult;
    }

    @PostMapping("update")
    @ResponseBody
    public JSONResult update(@Valid @RequestBody UserBO userBO,
                             BindingResult bindingResult)
    {
        if(bindingResult.hasErrors()){
            Map<String, String> map = getErrors(bindingResult);
            JSONResult jsonResult = JSONResult.errorMap(map);
            return jsonResult;
        }

        User user = new User();
        BeanUtils.copyProperties(userBO, user);

        boolean success = this.userService.update(user);
        JSONResult jsonResult = success ? JSONResult.ok() :
                JSONResult.errorMsg("Fail to update user");
        return jsonResult;
    }

    @DeleteMapping("/delete/{userId}")
    @ResponseBody
    public JSONResult delete(@PathVariable int userId){
        if(userId <= 0){
            return JSONResult.errorMsg("userId must be <= 0");
        }

        boolean success = this.userService.delete(userId);
        JSONResult jsonResult = success ?JSONResult.ok() : JSONResult.errorMsg("Fail to delete user");
        return jsonResult;
    }

    @GetMapping("/testTrans")
    @ResponseBody
    public JSONResult testTrans(){
        this.userService.testTrans();
        return JSONResult.ok();
    }

    public Map<String, String> getErrors(BindingResult result){
        Map<String, String> map = new LinkedHashMap<>();

        List<FieldError> errorList = result.getFieldErrors();
        for(FieldError error : errorList){
            String field = error.getField();
            String msg = error.getDefaultMessage();
            map.put(field, msg);
        }

        return map;
    }

}
