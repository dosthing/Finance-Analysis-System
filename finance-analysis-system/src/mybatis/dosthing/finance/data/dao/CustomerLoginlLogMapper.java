package mybatis..dosthing.finance.data.dao;

import mybatis..dosthing.finance.data.entity.CustomerLoginlLog;

public interface CustomerLoginlLogMapper {
    int deleteByPrimaryKey(Integer loginId);

    int insert(CustomerLoginlLog record);

    int insertSelective(CustomerLoginlLog record);

    CustomerLoginlLog selectByPrimaryKey(Integer loginId);

    int updateByPrimaryKeySelective(CustomerLoginlLog record);

    int updateByPrimaryKey(CustomerLoginlLog record);
}