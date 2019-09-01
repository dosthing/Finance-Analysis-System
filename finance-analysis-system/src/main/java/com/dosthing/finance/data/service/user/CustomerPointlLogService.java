package com.dosthing.finance.data.service.user;

import com.dosthing.finance.data.entity.user.CustomerPointlLog;

public interface CustomerPointlLogService {

    void save(CustomerPointlLog customerPointlLog);

    void deleteById(Integer id);

    void update(CustomerPointlLog customerPointlLog);

    CustomerPointlLog selecteById(Integer id);
}
