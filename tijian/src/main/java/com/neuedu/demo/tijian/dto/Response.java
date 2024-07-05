package com.neuedu.demo.tijian.dto;

import java.io.Serializable;

public class Response<T> implements Serializable {
    private Integer code; //1成功，0失败
    private String message;
    private T result;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public Response(){}

    public Response(Integer code, String message, T result) {
        this.code = code;
        this.message = message;
        this.result = result;
    }

    public static Response success(Object data){
        return new Response(200,"success",data);
    }

    public static Response success(){
        return new Response(200,"success",null);
    }

    public static Response error(String message){
        return new Response(500,message,null);
    }

    public static Response error(int code, String message){
        return new Response(code,message,null);
    }

}
