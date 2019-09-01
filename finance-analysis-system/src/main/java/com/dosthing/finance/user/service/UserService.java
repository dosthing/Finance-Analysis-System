package com.dosthing.finance.user.service;

import com.alibaba.fastjson.JSONObject;
import com.dosthing.finance.data.entity.user.CustomerAddr;
import com.dosthing.finance.data.entity.user.CustomerInfo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

public interface UserService {

    void registUser(String userName,String passWord, Integer cardType, String cardNo, String phoneNum,String email,String sex,Date birthDay);

    /**
     * 简单邮箱注册接口
     * @param email
     * @param passWord
     * @param validCode
     * @param sessionValidCode
     */
    void simpleRegistUser(String email,String passWord,String validCode,String sessionValidCode);

    String getEmailValidCode(String email);

    void login(String email, String phoneNum, String passWord,String ip);

    void logout(String email, String phoneNum,String ip);

    Map<String,Object> getuserInfo(String email, String phoneNum);

    void updateUserInfo(CustomerInfo customerInfo, CustomerAddr customerAddr);

    /**
     * 用户积分更新接口
     * @param customerInfoId 用户信息id
     * @param source 积分变更来源
     * @param sourceSn 来源编号
     * @param point 变更积分数
     * @param type 0-增加积分 1-减少积分
     */
    void updateUserPoint(Integer customerInfoId, Integer source, String sourceSn,Integer point,Integer type);

    /**
     * 用户余额更新接口
     * @param customerInfoId 用户信息id
     * @param source  金额变更来源
     * @param sourceSn 来源编号
     * @param amount 变更金额数
     * @param type 0-增加积分 1-减少积分
     */
    void uodateUserBalance(Integer customerInfoId, Integer source, String sourceSn, BigDecimal amount, Integer type);
}

