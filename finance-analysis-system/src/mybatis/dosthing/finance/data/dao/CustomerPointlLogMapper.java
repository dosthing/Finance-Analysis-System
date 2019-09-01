package mybatis..dosthing.finance.data.dao;

import mybatis..dosthing.finance.data.entity.CustomerPointlLog;

public interface CustomerPointlLogMapper {
    int deleteByPrimaryKey(Integer pointId);

    int insert(CustomerPointlLog record);

    int insertSelective(CustomerPointlLog record);

    CustomerPointlLog selectByPrimaryKey(Integer pointId);

    int updateByPrimaryKeySelective(CustomerPointlLog record);

    int updateByPrimaryKey(CustomerPointlLog record);
}