package com.dosthing.finance.data.dao.user;

import com.dosthing.finance.data.entity.user.CustomerLoginlLog;



public interface CustomerLoginlLogDao {
    int deleteByPrimaryKey(Integer loginId);

    int insert(CustomerLoginlLog record);

    int insertSelective(CustomerLoginlLog record);

    CustomerLoginlLog selectByPrimaryKey(Integer loginId);

    int updateByPrimaryKeySelective(CustomerLoginlLog record);

    int updateByPrimaryKey(CustomerLoginlLog record);
}