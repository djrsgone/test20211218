package com.example.firstappdemo.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.web.cors.reactive.PreFlightRequestWebFilter;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class JSONResult {

    //响应业务状态
    private int status = 200;

    //响应消息
    private String msg;

    //响应中的数据
    private Object data;

    private String ok;

    public static JSONResult ok (){
        return new JSONResult();
    }

    public static JSONResult ok (Object data){
        JSONResult result = new JSONResult();
        result.setData(data);
        return result;
    }

    public static JSONResult errorMsg(String msg){
        JSONResult result = new JSONResult();
        result.setStatus(500);
        result.setMsg(msg);
        return result;
    }

    public static JSONResult errorUserTicket(String msg){
        JSONResult result = new JSONResult();
        result.setStatus(557);
        result.setMsg(msg);
        return result;
    }

    public static JSONResult errorMap(Object data){
        JSONResult result = new JSONResult();
        result.setStatus(501);
        result.setMsg("error");
        result.setData(data);
        return result;
    }

    public static JSONResult errorTokenMsg(String msg){
        JSONResult result = new JSONResult();
        result.setStatus(502);
        result.setMsg(msg);
        return result;
    }

    public static JSONResult errorException(String msg){
        JSONResult result = new JSONResult();
        result.setStatus(555);
        result.setMsg(msg);
        return result;
    }

    public static JSONResult errorUserQQ(String msg){
        JSONResult result = new JSONResult();
        result.setStatus(556);
        result.setMsg(msg);
        return result;
    }


}
