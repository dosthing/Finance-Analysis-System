package com.dosthing.finance.data.service.user.Impl;

import com.dosthing.finance.data.dao.user.CustomerInfoDao;
import com.dosthing.finance.data.entity.user.CustomerInfo;
import com.dosthing.finance.data.service.user.CustomerInfoService;
import com.dosthing.finance.data.service.user.CustomerInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: finance-analysis-system
 * @description: 用户信息service
 * @author: Mr.Shuang
 * @create: 2019-08-29 23:
 **/

@Service
public class CustomerInfoServiceImpl implements CustomerInfoService {

    @Autowired
    private CustomerInfoDao customerInfoDao;

    @Override
    public CustomerInfo selecteByid(Integer id) {
        return customerInfoDao.selectByPrimaryKey(id);
    }

    @Override
    public void save(CustomerInfo customerInfo) {
        customerInfoDao.insertSelective(customerInfo);
    }

    @Override
    public void deleteById(Integer id) {
        customerInfoDao.deleteByPrimaryKey(id);
    }

    @Override
    public void updateById(CustomerInfo customerInfo) {
        customerInfoDao.updateByPrimaryKeySelective(customerInfo);
    }

    @Override
    public CustomerInfo selecteByPhone(String phoneNum) {
        return customerInfoDao.selectByPhoneNum(phoneNum);
    }

    @Override
    public CustomerInfo selecteByEmail(String email) {
        return customerInfoDao.selectByEmail(email);
    }
}
