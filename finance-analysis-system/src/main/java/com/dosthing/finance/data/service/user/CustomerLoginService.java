package com.dosthing.finance.data.service.user;

import com.dosthing.finance.data.entity.user.CustomerLogin;

public interface CustomerLoginService {

    void save(CustomerLogin customerLogin);

    void deleteById(Integer id);

    void update(CustomerLogin customerLogin);

    CustomerLogin selecteById(Integer id);
}
