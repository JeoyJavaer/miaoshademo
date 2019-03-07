package com.miaoshaproject.error;

/**
 * <br>〈公共错误模板〉<br>
 *
 * @author Administrator
 * @create 2019/3/7
 * @since 1.0.0
 */
public interface CommonError {

    int getErrorCode();

    String getErrorMsg();

    CommonError setErrorMsg(String msg);

}
