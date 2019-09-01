package com.dosthing.finance.data.service.user;

import com.dosthing.finance.data.entity.user.CustomerInfo;

public interface CustomerInfoService {

    void save(CustomerInfo customerInfo);

    void deleteById(Integer id);

    void updateById(CustomerInfo customerInfo);

    CustomerInfo selecteByid(Integer id);

    CustomerInfo selecteByPhone(String phoneNum);

    CustomerInfo selecteByEmail(String email);
}
