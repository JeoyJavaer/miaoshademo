package com.miaoshaproject.validator;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * <br>〈功能简述〉<br>
 *
 * @author Administrator
 * @create 2019/3/7
 * @since 1.0.0
 */
public class ValidationResult {

    private boolean hasErrors = false;
    private Map<String, String> errorMsg = new HashMap<>();

    public boolean isHasErrors() {
        return hasErrors;
    }

    public void setHasErrors(boolean hasErrors) {
        this.hasErrors = hasErrors;
    }

    public Map<String, String> getErrorMsgMa() {
        return errorMsg;
    }

    public void setErrorMsg(Map<String, String> errorMsgMa) {
        this.errorMsg = errorMsgMa;
    }

    public String getErrMsg() {
        return StringUtils.join(errorMsg.values().toArray(), ",");
    }
}
