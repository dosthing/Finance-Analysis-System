package com.dosthing.finance.data.service.user.Impl;

import com.dosthing.finance.data.dao.user.CustomerPointlLogDao;
import com.dosthing.finance.data.entity.user.CustomerPointlLog;
import com.dosthing.finance.data.service.user.CustomerPointlLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: finance-analysis-system
 * @description: 用户积分记录信息Service
 * @author: Mr.Shuang
 * @create: 2019-08-31 13:
 **/
@Service
public class CustomerPointlLogServiceImpl implements CustomerPointlLogService {

    @Autowired
    private CustomerPointlLogDao customerPointlLogDao;

    @Override
    public void save(CustomerPointlLog customerPointlLog) {
        customerPointlLogDao.updateByPrimaryKeySelective(customerPointlLog);
    }

    @Override
    public void deleteById(Integer id) {
        customerPointlLogDao.deleteByPrimaryKey(id);
    }

    @Override
    public void update(CustomerPointlLog customerPointlLog) {
        customerPointlLogDao.updateByPrimaryKeySelective(customerPointlLog);
    }

    @Override
    public CustomerPointlLog selecteById(Integer id) {
        return customerPointlLogDao.selectByPrimaryKey(id);
    }
}
