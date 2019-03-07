package com.miaoshaproject.service.impl;

import com.miaoshaproject.dao.UserDoMapper;
import com.miaoshaproject.dao.UserPasswordDoMapper;
import com.miaoshaproject.dataobject.UserDo;
import com.miaoshaproject.dataobject.UserPasswordDo;
import com.miaoshaproject.error.BusinessException;
import com.miaoshaproject.error.EmBusinessError;
import com.miaoshaproject.service.UserService;
import com.miaoshaproject.service.model.UserModel;
import com.miaoshaproject.validator.ValidationResult;
import com.miaoshaproject.validator.ValidatorImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

/**
 * <br>〈功能简述〉<br>
 *
 * @author Administrator
 * @create 2019/3/7
 * @since 1.0.0
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDoMapper userDoMapper;

    @Autowired
    private UserPasswordDoMapper userPasswordDoMapper;


    @Autowired
    private ValidatorImpl validator;

    @Override
    public void register(UserModel userModel) throws BusinessException {
        if (userModel == null) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
        }

        ValidationResult validate = validator.validate(userModel);
        if (validate.isHasErrors()) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR, validate.getErrMsg());
        }

        UserDo userDo = convertUserModel2UserDo(userModel);

        try {

            userDoMapper.insertSelective(userDo);
        }catch (DuplicateKeyException ex){
            throw  new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR,"该手机号已存在！");
        }


        //设置id
        userModel.setId(userDo.getId());

        //保存密码
        UserPasswordDo userPasswordDo =convertUserModel2UserPasswordDo(userModel);
        userPasswordDoMapper.insertSelective(userPasswordDo);
    }


    private UserPasswordDo convertUserModel2UserPasswordDo(UserModel model) {
        if (model == null) return null;

        UserPasswordDo userPasswordDo = new UserPasswordDo();
        userPasswordDo.setEncrptpassword(model.getEncrptPassword());
        userPasswordDo.setUserId(model.getId());
        return userPasswordDo;

    }

    private UserDo convertUserModel2UserDo(UserModel userModel) {
        if (userModel == null) return null;
        UserDo userDo = new UserDo();
        BeanUtils.copyProperties(userModel,userDo);
        return userDo;

    }
}
