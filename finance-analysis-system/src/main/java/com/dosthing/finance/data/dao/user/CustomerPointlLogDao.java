package com.dosthing.finance.data.dao.user;

import com.dosthing.finance.data.entity.user.CustomerPointlLog;



public interface CustomerPointlLogDao {
    int deleteByPrimaryKey(Integer pointId);

    int insert(CustomerPointlLog record);

    int insertSelective(CustomerPointlLog record);

    CustomerPointlLog selectByPrimaryKey(Integer pointId);

    int updateByPrimaryKeySelective(CustomerPointlLog record);

    int updateByPrimaryKey(CustomerPointlLog record);
}