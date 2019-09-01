package com.dosthing.finance.data.service.user.Impl;

import com.dosthing.finance.data.dao.user.CustomerBalanceLogDao;
import com.dosthing.finance.data.entity.user.CustomerBalanceLog;
import com.dosthing.finance.data.service.user.CustomerBalanceLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: finance-analysis-system
 * @description: 用户资金变动信息Service
 * @author: Mr.Shuang
 * @create: 2019-08-31 13:
 **/
@Service
public class CustomerBalanceLogServiceImpl implements CustomerBalanceLogService{

    @Autowired
    private CustomerBalanceLogDao customerBalanceLogDao;

    @Override
    public void save(CustomerBalanceLog customerBalanceLog) {
        customerBalanceLogDao.insertSelective(customerBalanceLog);
    }

    @Override
    public void deleteById(Integer id) {
        customerBalanceLogDao.deleteByPrimaryKey(id);
    }

    @Override
    public void update(CustomerBalanceLog customerBalanceLog) {
        customerBalanceLogDao.updateByPrimaryKeySelective(customerBalanceLog);
    }

    @Override
    public CustomerBalanceLog selecteById(Integer id) {
        return customerBalanceLogDao.selectByPrimaryKey(id);
    }
}
