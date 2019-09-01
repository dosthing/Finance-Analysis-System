package com.dosthing.finance.data.service.user.Impl;

import com.dosthing.finance.data.dao.user.CustomerLoginlLogDao;
import com.dosthing.finance.data.entity.user.CustomerLoginlLog;
import com.dosthing.finance.data.service.user.CustomerLoginlLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: finance-analysis-system
 * @description: 用户登录记录信息表
 * @author: Mr.Shuang
 * @create: 2019-08-31 13:
 **/
@Service
public class CustomerLoginlLogServiceImpl implements CustomerLoginlLogService {

    @Autowired
    private CustomerLoginlLogDao customerLoginlLogDao;

    @Override
    public void save(CustomerLoginlLog customerLoginlLog) {
        customerLoginlLogDao.insertSelective(customerLoginlLog);
    }

    @Override
    public void deleteById(Integer id) {
        customerLoginlLogDao.deleteByPrimaryKey(id);
    }

    @Override
    public void update(CustomerLoginlLog customerLoginlLog) {
        customerLoginlLogDao.updateByPrimaryKeySelective(customerLoginlLog);
    }

    @Override
    public CustomerLoginlLog selecteById(Integer id) {
        return customerLoginlLogDao.selectByPrimaryKey(id);
    }
}
