package com.spring.springbootconfig.common;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @description:
 * @author: linliquan
 * @create: 2020-10-17 15:30
 **/
public class Response<T> implements Serializable {
    @Getter
    @Setter
    private Boolean success;
    @Getter
    @Setter
    private T data;

    @Getter
    @Setter
    private Integer code = 200;
    @Getter
    @Setter
    private String msg = "操作成功";


    public static Response fail(String msg) {
        Response response = new Response();
        response.setSuccess(Boolean.FALSE);
        response.setCode(ResponseStatus.FAIL.getCode());
        response.setMsg(msg);
        return response;
    }

    public static Response fail(Integer code, String msg) {
        Response response = new Response();
        response.setSuccess(Boolean.FALSE);
        response.setCode(code);
        response.setMsg(msg);
        return response;
    }

    public static Response fail(Response response, Integer code, String msg) {
        response.setSuccess(Boolean.FALSE);
        response.setCode(code);
        response.setMsg(msg);
        return response;
    }

    public static <T> Response<T> succ(T data, String msg) {
        Response response = new Response();
        response.setSuccess(Boolean.TRUE);
        response.setCode(ResponseStatus.SUCCESS.code);
        response.setData(data);
        response.setMsg(msg);
        return response;
    }

    public static <T> Response<T> succ(T data) {
        Response response = new Response();
        response.setSuccess(Boolean.TRUE);
        response.setCode(ResponseStatus.SUCCESS.code);
        response.setData(data);
        return response;
    }


    @Override
    public String toString() {
        //失败时不打出data
        if (null == success || !success) {
            return "{" +
                    "success=" + success
                    + ", code=" + code +
                    ", msg='" + msg + '\'' +
                    '}';
        }
        if (null == data) {
            return null;
        }

        return data.toString();


    }
}

