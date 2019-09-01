package com.dosthing.finance.data.service.user;

import com.dosthing.finance.data.entity.user.CustomerLevelInfo;

import java.util.List;

public interface CustomerLevelInfoService {

    void save(CustomerLevelInfo customerLevelInfo);

    void deleteById(Integer id);

    void update(CustomerLevelInfo customerLevelInfo);

    CustomerLevelInfo selecteById(Integer id);

    List<CustomerLevelInfo> findAll();
}
