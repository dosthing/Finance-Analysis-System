package com.dosthing.finance.data.dao.user;

import com.dosthing.finance.data.entity.user.CustomerBalanceLog;



public interface CustomerBalanceLogDao {
    int deleteByPrimaryKey(Integer balanceId);

    int insert(CustomerBalanceLog record);

    int insertSelective(CustomerBalanceLog record);

    CustomerBalanceLog selectByPrimaryKey(Integer balanceId);

    int updateByPrimaryKeySelective(CustomerBalanceLog record);

    int updateByPrimaryKey(CustomerBalanceLog record);
}