package com.dosthing.finance.user.service.Impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dosthing.finance.data.entity.user.*;
import com.dosthing.finance.data.service.email.MailService;
import com.dosthing.finance.data.service.user.*;
import com.dosthing.finance.enums.ErrorEnum;
import com.dosthing.finance.exception.FasException;
import com.dosthing.finance.user.service.UserService;
import com.dosthing.finance.utils.MD5Util;
import com.dosthing.finance.utils.RandomUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: finance-analysis-system
 * @description: 用户service
 * @author: Mr.Shuang
 * @create: 2019-08-31
 **/
@Service
public class UserServiceImpl implements UserService{

    @Resource
    MailService mailService;

    @Resource
    TemplateEngine templateEngine;

    @Autowired
    CustomerInfoService customerInfoService;

    @Autowired
    CustomerLoginService customerLoginService;

    @Autowired
    CustomerLoginlLogService customerLoginlLogService;

    @Autowired
    CustomerAddrService customerAddrService;

    @Autowired
    CustomerPointlLogService customerPointlLogService;

    @Autowired
    CustomerLevelInfoService customerLevelInfoService;

    @Autowired
    CustomerBalanceLogService customerBalanceLogService;

    @Override
    public  Map<String,Object> getuserInfo(String email, String phoneNum) {
        CustomerInfo customerInfo = getCustomerInfo(email,phoneNum);
        CustomerAddr customerAddr = customerAddrService.selecteByCustomerInfoId(customerInfo.getCustomerInfoId());
        Map<String,Object> result = new HashMap<>();
        result.put("customerInfo",customerInfo);
        result.put("customerAddr",customerAddr);
        return result;
    }

    @Override
    public void updateUserInfo(CustomerInfo customerInfo, CustomerAddr customerAddr) {
        CustomerInfo customerInfoNew = customerInfoService.selecteByid(customerInfo.getCustomerInfoId());
        //用户信息表只能更新部分数据
        customerInfoNew.setCustometName(customerInfo.getCustometName());
        customerInfoNew.setCustomerCardType(customerInfo.getCustomerCardType());
        customerInfoNew.setCustomerCardNo(customerInfo.getCustomerCardNo());
        customerInfoNew.setGender(customerInfo.getGender());
        customerInfoNew.setBirthday(customerInfo.getBirthday());

        //更新地址信息
        customerAddrService.updateById(customerAddr);
    }

    @Override
    public void registUser(String userName, String passWord,Integer cardType, String cardNo, String phoneNum, String email, String sex, Date birthDay) {

        //检查用户手机号是否已被注册

        //1.保存用户信息
        CustomerInfo customerInfo = new CustomerInfo();
        customerInfo.setCustometName(userName);
        customerInfo.setCustomerCardType(cardType);
        customerInfo.setCustomerCardNo(cardNo);
        customerInfo.setMobilePhone(phoneNum);
        customerInfo.setCustomerEmail(email);
        customerInfo.setGender(sex);
        customerInfo.setBirthday(birthDay);
        customerInfoService.save(customerInfo);

        //2.创建登录信息表
        Integer customerInfoId = customerInfoService.selecteByPhone(phoneNum).getCustomerInfoId();
        CustomerLogin customerLogin = new CustomerLogin();
        customerLogin.setCustomerId(customerInfoId);
        customerLogin.setLoginName(userName);
        customerLogin.setPassword(MD5Util.encrypt(passWord));
        customerLogin.setUserStats(0);
        customerLoginService.save(customerLogin);
        //3.创建用户地址信息表
        CustomerAddr customerAddr = new CustomerAddr();
        customerAddr.setCustomerId(customerInfoId);
        customerAddrService.save(customerAddr);
    }

    @Override
    public void simpleRegistUser(String email, String passWord, String validCode,String sessionValidCode) {

        //检验validCode
       if(!sessionValidCode.equals(MD5Util.encrypt(validCode))){
           throw new FasException(101,"验证码错误");
       }
        //注册用户
        CustomerInfo customerInfo = new CustomerInfo();
        customerInfo.setCustomerEmail(email);
        customerInfoService.save(customerInfo);

        Integer customerInfoId = customerInfoService.selecteByEmail(email).getCustomerInfoId();
        CustomerLogin customerLogin = new CustomerLogin();
        customerLogin.setCustomerId(customerInfoId);
        customerLogin.setPassword(MD5Util.encrypt(passWord));
        customerLogin.setUserStats(0);
        customerLoginService.save(customerLogin);

        CustomerAddr customerAddr = new CustomerAddr();
        customerAddr.setCustomerId(customerInfoId);
        customerAddrService.save(customerAddr);
    }

    @Override
    public String getEmailValidCode(String email) {

        //检查邮箱是否被注册
        CustomerInfo customerInfo = customerInfoService.selecteByEmail(email);
        if(customerInfo != null){
            throw new FasException(ErrorEnum.USER_REGISTED);
        }
        String validCode = RandomUtil.random(4);
        Context context = new Context();
        context.setVariable("validCode",validCode);
        String emailContent=templateEngine.process("emailValidCode",context);
        mailService.sendHtmlMail(email,"Fas验证邮件",emailContent);
        return validCode;
    }

    @Override
    public void login(String email, String phoneNum, String passWord,String ip) {
        CustomerInfo customerInfo = getCustomerInfo(email,phoneNum);
        //置登录表状态
        CustomerLogin customerLogin = customerLoginService.selecteById(customerInfo.getCustomerInfoId());
        if(!MD5Util.encrypt(passWord).equals(customerLogin.getPassword())){
            throw new FasException(ErrorEnum.USER_PASSWORD_ERROE);
        }
        customerLogin.setUserStats(1);
        customerLoginService.update(customerLogin);
        //记录登录信息
        CustomerLoginlLog customerLoginlLog = new CustomerLoginlLog();
        customerLoginlLog.setCustomerId(customerInfo.getCustomerInfoId());
        customerLoginlLog.setLoginTime(new Date());
        customerLoginlLog.setLoginIp(ip);
        customerLoginlLog.setLoginType(1);
        customerLoginlLogService.save(customerLoginlLog);
    }

    @Override
    public void logout(String email, String phoneNum,String ip) {
        CustomerInfo customerInfo = getCustomerInfo(email,phoneNum);
        CustomerLogin customerLogin = customerLoginService.selecteById(customerInfo.getCustomerInfoId());
        customerLogin.setUserStats(0);
        customerLoginService.update(customerLogin);
        //记录登录信息
        CustomerLoginlLog customerLoginlLog = new CustomerLoginlLog();
        customerLoginlLog.setCustomerId(customerInfo.getCustomerInfoId());
        customerLoginlLog.setLoginTime(new Date());
        customerLoginlLog.setLoginIp(ip);
        customerLoginlLog.setLoginType(0);
        customerLoginlLogService.save(customerLoginlLog);
    }

    @Override
    @Transactional
    public void updateUserPoint(Integer customerInfoId, Integer source, String sourceSn, Integer point, Integer type) {
        //记录变更信息
        CustomerPointlLog customerPointlLog = new CustomerPointlLog();
        customerPointlLog.setCustomerId(customerInfoId);
        customerPointlLog.setChangePoint(point);
        customerPointlLog.setSource(source);
        customerPointlLog.setReferNumber(sourceSn);
        customerPointlLog.setCreateTime(new Date());
        customerPointlLogService.save(customerPointlLog);
        //更新用户主表信息
        CustomerInfo customerInfo = customerInfoService.selecteByid(customerInfoId);
        //增加积分
        if(type == 0){
            customerInfo.setUserPoint(customerInfo.getUserPoint() + point);
        }else{ //减少积分
            customerInfo.setUserPoint((customerInfo.getUserPoint() - point) < 0 ? 0:(customerInfo.getUserPoint() - point));
        }
        //计算用户等级
        customerInfo = getCustomerLevel(customerInfo);
        //更新用户信息
        customerInfoService.updateById(customerInfo);
    }

    @Override
    @Transactional
    public void uodateUserBalance(Integer customerInfoId, Integer source, String sourceSn, BigDecimal amount, Integer type) {
        //添加变更记录
        CustomerBalanceLog customerBalanceLog = new CustomerBalanceLog();
        customerBalanceLog.setCustomerId(customerInfoId);
        customerBalanceLog.setSource(source);
        customerBalanceLog.setSourceSn(sourceSn);
        customerBalanceLog.setAmount(amount);
        customerBalanceLog.setCreateTime(new Date());
        customerBalanceLogService.save(customerBalanceLog);
        //更新用户主表信息
        CustomerInfo customerInfo = customerInfoService.selecteByid(customerInfoId);
        //增加用户余额
        if(type == 0){
            customerInfo.setUserMoney(customerInfo.getUserMoney().add(amount));
        }else{ //减少用户余额
            if(customerInfo.getUserMoney().compareTo(amount) == -1){
                throw new FasException(ErrorEnum.USER_MONNEY_SHORTAGE);
            }
            customerInfo.setUserMoney((customerInfo.getUserMoney().subtract(amount)));
        }
        //更新用户信息
        customerInfoService.updateById(customerInfo);
    }

    private CustomerInfo getCustomerInfo(String email, String phoneNum){
        CustomerInfo customerInfo = null;
        if (email != null){
            customerInfo = customerInfoService.selecteByEmail(email);
        }else if(phoneNum != null){
            customerInfo = customerInfoService.selecteByPhone(phoneNum);
        }else{
            throw new FasException(101,"email phoneNum不能都为空");
        }
        return customerInfo;
    }

    private CustomerInfo getCustomerLevel(CustomerInfo customerInfo){
        List<CustomerLevelInfo> customerLevelInfoList = customerLevelInfoService.findAll();
        customerLevelInfoList.stream().forEach(a->{
            if(customerInfo.getUserPoint() >= a.getMinPoint() && customerInfo.getUserPoint()< a.getMaxPoint()){
                customerInfo.setCustomerLevel(a.getCustomerLevel());
            }
        });
        return customerInfo;
    }
}
