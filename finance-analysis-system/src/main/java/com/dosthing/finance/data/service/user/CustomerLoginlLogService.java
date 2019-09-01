package com.dosthing.finance.data.service.user;

import com.dosthing.finance.data.entity.user.CustomerLoginlLog;

public interface CustomerLoginlLogService {

    void save(CustomerLoginlLog customerLoginlLog);

    void deleteById(Integer id);

    void update(CustomerLoginlLog customerLoginlLog);

    CustomerLoginlLog selecteById(Integer id);

}
