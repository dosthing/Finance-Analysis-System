package com.dosthing.finance.data.service.user;

import com.dosthing.finance.data.entity.user.CustomerBalanceLog;

public interface CustomerBalanceLogService {
    void save(CustomerBalanceLog customerBalanceLog);

    void deleteById(Integer id);

    void update(CustomerBalanceLog customerBalanceLog);

    CustomerBalanceLog selecteById(Integer id);
}
