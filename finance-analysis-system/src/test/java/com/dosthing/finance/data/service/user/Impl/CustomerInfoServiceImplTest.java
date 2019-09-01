package com.dosthing.finance.data.service.user.Impl;

import com.dosthing.finance.data.entity.user.CustomerInfo;
import com.dosthing.finance.data.service.user.CustomerInfoService;
import com.dosthing.finance.data.service.user.CustomerInfoService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class CustomerInfoServiceImplTest {

    @Autowired
    private CustomerInfoService customerInfoService;

    @Test
    public void selecteByid() throws Exception {
    }

    @Test
    public void save() throws Exception {
        CustomerInfo customerInfo = new CustomerInfo();
        customerInfo.setCustometName("lishuangliang");
        customerInfo.setCustomerCardNo("123456789");
        customerInfo.setCustomerCardType(1);
        customerInfo.setCustomerLoginId(1);
        customerInfoService.save(customerInfo);
    }

}