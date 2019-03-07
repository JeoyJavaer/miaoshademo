package com.miaoshaproject.response;

import javax.lang.model.type.ReferenceType;
import java.io.PushbackInputStream;

/**
 * <br>〈公共返回数据〉<br>
 *
 * @author Administrator
 * @create 2019/3/7
 * @since 1.0.0
 */
public class CommonReturnType {

    private CommonReturnType() {
    }

    private String status;


    private Object data;


    public static CommonReturnType create(Object data, String status) {
        CommonReturnType type = new CommonReturnType();
        type.setData(data);
        type.setStatus(status);
        return type;
    }

    public static CommonReturnType create(Object data) {
        return CommonReturnType.create(data, "success");
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
