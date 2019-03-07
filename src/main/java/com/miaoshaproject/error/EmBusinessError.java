package com.miaoshaproject.error;

import java.awt.print.PrinterGraphics;

/**
 * <br>〈功能简述〉<br>
 *
 * @author Administrator
 * @create 2019/3/7
 * @since 1.0.0
 */
public enum EmBusinessError implements CommonError {

    //通用错误类型 00001
    PARAMETER_VALIDATION_ERROR(10001, "参数不合法"),

    //自定义未知错误
    UN_KNOWN_ERROR(10002, "未知错误"),

    //20000开头 用户信息相关的错误
    USER_NOT_EXISTS(20001, "用户不存在"),
    USER_NOT_LOGIN(20002, "用户未登录"),
    USER_LOGIN_FAIL(20003, "手机号或密码错误!"),


    //30000 交易相关的错误
    STOCK_NOT_ENOUGH(30001, "库存不足");


    private int errorCode;
    private String errMsg;

    EmBusinessError(int errorCode, String errMsg) {
        this.errorCode = errorCode;
        this.errMsg = errMsg;
    }

    @Override
    public int getErrorCode() {
        return this.errorCode;
    }

    @Override
    public String getErrorMsg() {
        return this.errMsg;
    }

    @Override
    public CommonError setErrorMsg(String msg) {
        this.errMsg = errMsg;
        return this;
    }
}
