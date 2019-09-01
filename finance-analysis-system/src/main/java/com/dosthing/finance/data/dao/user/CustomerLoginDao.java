package com.dosthing.finance.data.dao.user;


import com.dosthing.finance.data.entity.user.CustomerLogin;

public interface CustomerLoginDao {
    int deleteByPrimaryKey(Integer customerId);

    int insert(CustomerLogin record);

    int insertSelective(CustomerLogin record);

    CustomerLogin selectByPrimaryKey(Integer customerId);

    int updateByPrimaryKeySelective(CustomerLogin record);

    int updateByPrimaryKey(CustomerLogin record);
}