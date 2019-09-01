package com.dosthing.finance.data.service.user.Impl;

import com.dosthing.finance.data.dao.user.CustomerLevelInfoDao;
import com.dosthing.finance.data.entity.user.CustomerLevelInfo;
import com.dosthing.finance.data.service.user.CustomerLevelInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: finance-analysis-system
 * @description: 用户等级信息表
 * @author: Mr.Shuang
 * @create: 2019-08-31 13:
 **/
@Service
public class CustomerLevelInfoServiceImpl implements CustomerLevelInfoService {

    @Autowired
    private CustomerLevelInfoDao customerLevelInfoDao;

    @Override
    public void save(CustomerLevelInfo customerLevelInfo) {
        customerLevelInfoDao.insertSelective(customerLevelInfo);
    }

    @Override
    public void deleteById(Integer id) {
        customerLevelInfoDao.deleteByPrimaryKey(id.byteValue());
    }

    @Override
    public void update(CustomerLevelInfo customerLevelInfo) {
        customerLevelInfoDao.updateByPrimaryKeySelective(customerLevelInfo);
    }

    @Override
    public CustomerLevelInfo selecteById(Integer id) {
        return customerLevelInfoDao.selectByPrimaryKey(id.byteValue());
    }

    @Override
    public List<CustomerLevelInfo> findAll() {
        return customerLevelInfoDao.findAll();
    }
}
