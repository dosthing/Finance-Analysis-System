package com.dosthing.finance.data.service.user;

import com.dosthing.finance.data.entity.user.CustomerAddr;
import com.dosthing.finance.data.entity.user.CustomerInfo;

public interface CustomerAddrService {
    void save(CustomerAddr customerAddr);

    void deleteById(Integer id);

    void updateById(CustomerAddr customerAddr);

    CustomerAddr selecteByid(Integer id);

    CustomerAddr selecteByCustomerInfoId(Integer customerInfoId);
}
