package com.dosthing.finance.data.dao.user;

import com.dosthing.finance.data.entity.user.CustomerLevelInfo;

import java.util.List;


public interface CustomerLevelInfoDao {
    int deleteByPrimaryKey(Byte customerLevel);

    int insert(CustomerLevelInfo record);

    int insertSelective(CustomerLevelInfo record);

    CustomerLevelInfo selectByPrimaryKey(Byte customerLevel);

    List<CustomerLevelInfo> findAll();

    int updateByPrimaryKeySelective(CustomerLevelInfo record);

    int updateByPrimaryKey(CustomerLevelInfo record);

}