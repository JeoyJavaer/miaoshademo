package com.miaoshaproject.controller;

import com.miaoshaproject.Utils.Utils;
import com.miaoshaproject.error.BusinessException;
import com.miaoshaproject.error.EmBusinessError;
import com.miaoshaproject.response.CommonReturnType;
import com.miaoshaproject.service.UserService;
import com.miaoshaproject.service.model.UserModel;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 * <br>〈用户相关的请求〉<br>
 *
 * @author Administrator
 * @create 2019/3/7
 * @since 1.0.0
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private HttpServletRequest httpServletRequest;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public CommonReturnType register(@RequestParam("telephone") String telephone,
                                     @RequestParam("otpCode") String optCode,
                                     @RequestParam("name") String name,
                                     @RequestParam("password") String password,
                                     @RequestParam("gender") Byte gender,
                                     @RequestParam("age") Integer age) throws UnsupportedEncodingException, NoSuchAlgorithmException, BusinessException {
        String inSessionOptCode = (String) httpServletRequest.getSession().getAttribute(telephone);
        if (!StringUtils.equals(optCode, inSessionOptCode)) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR, "短信验证码不正确");
        }

        UserModel userModel = new UserModel();
        userModel.setName(name);
        userModel.setGender(gender);
        userModel.setAge(age);
        userModel.setTelephone(telephone);
        userModel.setRegisterMode("byPhone");
        userModel.setEncrptPassword(Utils.EncodeByMD5(password));
        userService.register(userModel);
        return CommonReturnType.create(null);
    }


    //获取OPT短信
    @RequestMapping(value = "/getOpt", method = RequestMethod.POST)
    public CommonReturnType getOpt(@RequestParam("telephone") String telephone) {
        String optCodeString = Utils.generateOpt();
        httpServletRequest.getSession().setAttribute(telephone, optCodeString);
        System.out.println("telephone:" + telephone + "&optCode:" + optCodeString);
        return CommonReturnType.create(telephone);
    }


}
