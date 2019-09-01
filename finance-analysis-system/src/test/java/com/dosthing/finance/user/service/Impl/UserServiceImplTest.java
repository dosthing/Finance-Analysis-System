package com.dosthing.finance.user.service.Impl;

import com.dosthing.finance.FinanceAnalysisSystemApplicationTests;
import com.dosthing.finance.user.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

import static org.junit.Assert.*;

public class UserServiceImplTest extends FinanceAnalysisSystemApplicationTests {

    @Autowired
    private UserService userService;
    @Test
    public void registUser() throws Exception {
        String userName = "lishuangliang";
        String passWord = "123456";
        Integer cardType = null;
        String cardNo = null;
        String phoneNum = "18578776389";
        String email = null;
        String sex = "m";
        Date birthDay = null;
        userService.registUser(userName,passWord,cardType,cardNo,phoneNum,email,sex,birthDay);
    }

}