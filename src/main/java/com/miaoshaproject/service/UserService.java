package com.miaoshaproject.service;

import com.miaoshaproject.error.BusinessException;
import com.miaoshaproject.service.model.UserModel;
import org.springframework.stereotype.Service;

/**
 * <br>〈用户管理服务〉<br>
 *
 * @author Administrator
 * @create 2019/3/7
 * @since 1.0.0
 */
@Service
public interface UserService {

    void  register(UserModel userModel) throws BusinessException;
}
