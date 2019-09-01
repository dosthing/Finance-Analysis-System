package com.dosthing.finance.user.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dosthing.finance.data.entity.user.CustomerAddr;
import com.dosthing.finance.data.entity.user.CustomerInfo;
import com.dosthing.finance.enums.ErrorEnum;
import com.dosthing.finance.exception.FasException;
import com.dosthing.finance.user.service.UserService;
import com.dosthing.finance.utils.IPUtil;
import com.dosthing.finance.utils.MD5Util;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * @program: finance-analysis-system
 * @description: 用户信息controller
 * @author: Mr.Shuang
 * @create: 2019-08-31
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;



    @RequestMapping("/info")
    public String getUserInfo(@RequestParam(value = "email",required = false) String email,
                              @RequestParam(value = "phoneNum", required = false) String phoneNum){
        userService.getuserInfo(email,phoneNum);
        return  "success";
    }

    @RequestMapping("/updateinfo")
    public String updateUserInfo(@RequestParam(value = "userInfo",required = false) JSONObject userInfo){
        CustomerInfo customerInfo = JSON.parseObject(userInfo.getString("customerInfo"),CustomerInfo.class);
        CustomerAddr customerAddr = JSON.parseObject(userInfo.getString("customerAddr"),CustomerAddr.class);
        userService.updateUserInfo(customerInfo,customerAddr);
        return  "success";
    }

    @RequestMapping("/register")
    public void registUser(@RequestParam(value = "userName", required = true) String userName,
                           @RequestParam(value = "passWord", required = true) String passWord,
                           @RequestParam(value = "cardType", required = false) Integer cardType,
                           @RequestParam(value = "cardNo", required = false) String cardNo,
                           @RequestParam(value = "phoneNum", required = true) String phoneNum,
                           @RequestParam(value = "email",required = false) String email,
                           @RequestParam(value = "sex", required = true) String sex,
                           @RequestParam(value = "birthDay",required = false) Date birthDay){
        userService.registUser(userName, passWord,cardType, cardNo, phoneNum, email, sex, birthDay);
    }

    @RequestMapping("/simpleRegister")
    public void simpleRegister( @RequestParam(value = "email",required = true) String email,
                                @RequestParam(value = "passWord", required = true) String passWord,
                                @RequestParam(value = "validCode", required = true) String validCode,
                                HttpServletRequest request,
                                HttpServletResponse response){
        HttpSession session = request.getSession();
        String sessionValidCode = (String)session.getAttribute("email_valid_code");
        if( sessionValidCode== null){
            throw new FasException(ErrorEnum.VALID_TIMEOUT);
        }
        userService.simpleRegistUser(email,passWord,validCode,sessionValidCode);
    }

    @RequestMapping("/getEmailValidCode")
    public String getEmailValidCode(@RequestParam(value = "email",required = true) String email,
                                    HttpServletRequest request,
                                    HttpServletResponse response){
        String result = userService.getEmailValidCode(email);

        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(30*60);
        session.setAttribute("email_valid_code", MD5Util.encrypt(result));
        return  "success";
    }

    @RequestMapping("/login")
    public String login( @RequestParam(value = "email",required = false) String email,
                         @RequestParam(value = "phoneNum", required = false) String phoneNum,
                         @RequestParam(value = "passWord", required = true) String passWord,
                         HttpServletRequest request){
        //设置cookie
        //todo
        //执行登录流程
        String ip = IPUtil.getIpAddr(request);
        userService.login(email,phoneNum,passWord,ip);
        return  "success";
    }

    @RequestMapping("logout")
    public String logout(@RequestParam(value = "email",required = false) String email,
                         @RequestParam(value = "phoneNum", required = false) String phoneNum,
                         HttpServletRequest request){
        //清除cookie
        //todo
        //执行退出登录流程
        String ip = IPUtil.getIpAddr(request);
        userService.logout(email,phoneNum,ip);
        return  "success";
    }
}
