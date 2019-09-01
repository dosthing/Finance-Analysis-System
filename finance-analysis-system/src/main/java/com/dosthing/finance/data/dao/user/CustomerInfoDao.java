package com.dosthing.finance.data.dao.user;


import com.dosthing.finance.data.entity.user.CustomerInfo;
import org.apache.ibatis.annotations.Param;

public interface CustomerInfoDao {
    int deleteByPrimaryKey(Integer customerInfoId);

    int insert(CustomerInfo record);

    int insertSelective(CustomerInfo record);

    CustomerInfo selectByPrimaryKey(Integer customerInfoId);

    CustomerInfo selectByPhoneNum(@Param("phoneNum") String phoneNum);

    CustomerInfo selectByEmail(@Param("email") String email);

    int updateByPrimaryKeySelective(CustomerInfo record);

    int updateByPrimaryKey(CustomerInfo record);
}