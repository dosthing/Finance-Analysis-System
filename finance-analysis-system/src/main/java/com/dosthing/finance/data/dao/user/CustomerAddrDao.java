package com.dosthing.finance.data.dao.user;

import com.dosthing.finance.data.entity.user.CustomerAddr;
import org.apache.ibatis.annotations.Param;


public interface CustomerAddrDao {
    int deleteByPrimaryKey(Integer customerAddrId);

    int insert(CustomerAddr record);

    int insertSelective(CustomerAddr record);

    CustomerAddr selectByPrimaryKey(Integer customerAddrId);

    CustomerAddr selecteByCustomerInfoId(@Param("customerInfoId") Integer customerInfoId);

    int updateByPrimaryKeySelective(CustomerAddr record);

    int updateByPrimaryKey(CustomerAddr record);

}