package com.dosthing.finance.data.service.user.Impl;

import com.dosthing.finance.data.dao.user.CustomerLoginDao;
import com.dosthing.finance.data.entity.user.CustomerLogin;
import com.dosthing.finance.data.service.user.CustomerLoginService;
import com.dosthing.finance.data.service.user.CustomerLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: finance-analysis-system
 * @description: 用户登录信息Service
 * @author: Mr.Shuang
 * @create: 2019-08-31 13:
 **/

@Service
public class CustomerLoginServiceImpl implements CustomerLoginService {

    @Autowired
    private CustomerLoginDao customerLoginDao;

    @Override
    public void save(CustomerLogin customerLogin) {
        customerLoginDao.insert(customerLogin);
    }

    @Override
    public void deleteById(Integer id) {
        customerLoginDao.deleteByPrimaryKey(id);
    }

    @Override
    public void update(CustomerLogin customerLogin) {
        customerLoginDao.updateByPrimaryKeySelective(customerLogin);
    }

    @Override
    public CustomerLogin selecteById(Integer id) {
        return customerLoginDao.selectByPrimaryKey(id);
    }
}
