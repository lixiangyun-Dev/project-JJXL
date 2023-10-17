package com.lxy.projectjjxl.common;


import lombok.Data;

@Data
public class ApiResult<T> {

    /** 响应码: 状态码为200才算请求成功 */
    private int code;

    /** 响应消息 */
    private String msg;

    /** 响应数据 */
    private T data;

    public ApiResult() {
    }

    public ApiResult(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <T> ApiResult<T> success(){
        return new ApiResult<>(200,"操作成功",null);
    }

    public static <T> ApiResult<T> success(T data){
        return new ApiResult<>(200,"操作成功",data);
    }
    
    public static <T> ApiResult<T> success(String msg, T data){
        return new ApiResult<>(200,msg,null);
    }

    public static <T> ApiResult<T> fail(Integer code, String msg){
        return new ApiResult<>(code,msg,null);
    }
}
