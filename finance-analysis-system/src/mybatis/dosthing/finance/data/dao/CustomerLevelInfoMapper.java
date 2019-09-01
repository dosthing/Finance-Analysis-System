package mybatis..dosthing.finance.data.dao;

import mybatis..dosthing.finance.data.entity.CustomerLevelInfo;

public interface CustomerLevelInfoMapper {
    int deleteByPrimaryKey(Byte customerLevel);

    int insert(CustomerLevelInfo record);

    int insertSelective(CustomerLevelInfo record);

    CustomerLevelInfo selectByPrimaryKey(Byte customerLevel);

    int updateByPrimaryKeySelective(CustomerLevelInfo record);

    int updateByPrimaryKey(CustomerLevelInfo record);
}