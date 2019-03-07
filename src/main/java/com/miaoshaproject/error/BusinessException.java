package com.miaoshaproject.error;

/**
 * <br>〈错误处理〉<br>
 *
 * @author Administrator
 * @create 2019/3/7
 * @since 1.0.0
 */
public class BusinessException extends Exception implements CommonError {
    private CommonError commonError;


    public BusinessException(CommonError commonError) {
        super();
        this.commonError = commonError;
    }

    public BusinessException(CommonError commonError,String errorMsg){
        super();
        this.commonError=commonError;
        this.commonError.setErrorMsg(errorMsg);
    }

    @Override
    public int getErrorCode() {
        return this.commonError.getErrorCode();
    }

    @Override
    public String getErrorMsg() {
        return this.commonError.getErrorMsg();
    }

    @Override
    public CommonError setErrorMsg(String msg) {
        commonError.setErrorMsg(msg);
        return this;
    }
}
