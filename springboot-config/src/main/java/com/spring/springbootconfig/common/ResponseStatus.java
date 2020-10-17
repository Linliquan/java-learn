package com.spring.springbootconfig.common;

import lombok.Getter;

/**
 * @description:
 * @author: linliquan
 * @create: 2020-10-17 15:30
 **/
public enum ResponseStatus {

    /**
     *  200 : 成功
     */
    SUCCESS(200, "success", "成功"),
    PARAM_ERROR(300, "paramerror", "参数错误"),
    UK_ERROR(301, "UK_error", "数据重复"),
    LOGIN_INVALID(302, "login_invalid", "登录失效，请重新登录"),
    FAIL(500, "fail", "失败"),
    GATEWAY_ERROR(502, "gateWayError", "网关错误");

    @Getter
    int code;
    @Getter
    String msg;
    @Getter
    String fullMsg;

    ResponseStatus(int code, String msg, String fullMsg) {
        this.code = code;
        this.msg = msg;
        this.fullMsg = fullMsg;
    }
}
