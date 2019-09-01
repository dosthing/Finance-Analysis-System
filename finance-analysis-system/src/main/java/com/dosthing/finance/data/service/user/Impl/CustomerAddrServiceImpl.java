package com.dosthing.finance.data.service.user.Impl;

import com.dosthing.finance.data.dao.user.CustomerAddrDao;
import com.dosthing.finance.data.entity.user.CustomerAddr;
import com.dosthing.finance.data.entity.user.CustomerInfo;
import com.dosthing.finance.data.service.user.CustomerAddrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: finance-analysis-system
 * @description: 用户地址信息Service
 * @author: Mr.Shuang
 * @create: 2019-08-31 13:
 **/

@Service
public class CustomerAddrServiceImpl implements CustomerAddrService{

    @Autowired
    private CustomerAddrDao customerAddrDao;

    @Override
    public void save(CustomerAddr customerAddr) {
        customerAddrDao.insertSelective(customerAddr);
    }

    @Override
    public void deleteById(Integer id) {
        customerAddrDao.deleteByPrimaryKey(id);
    }

    @Override
    public void updateById(CustomerAddr customerAddr) {
        customerAddrDao.updateByPrimaryKeySelective(customerAddr);
    }

    @Override
    public CustomerAddr selecteByid(Integer id) {
        return customerAddrDao.selectByPrimaryKey(id);
    }

    @Override
    public CustomerAddr selecteByCustomerInfoId(Integer customerInfoId) {
        return customerAddrDao.selecteByCustomerInfoId(customerInfoId);
    }
}
