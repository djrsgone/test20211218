package com.djr.demo.util;

public class JSONResult {

    //响应消息
    private String error;

    //响应中的数据
    private Object data;

    private boolean ok = true;

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
        result.setOk(false);
        result.setError(msg);
        return result;
    }

    @Override
    public String toString() {
        return "JSONResult{" +
                "msg='" + error + '\'' +
                ", data=" + data +
                ", ok=" + ok +
                '}';
    }

    //getter and setter

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public boolean getOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }



}
