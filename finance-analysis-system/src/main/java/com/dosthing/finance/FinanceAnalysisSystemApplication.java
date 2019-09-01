package com.dosthing.finance;

import com.dosthing.finance.properties.SystemProperties;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(SystemProperties.class)
@MapperScan(basePackages = "com.dosthing.finance.data.dao")
public class FinanceAnalysisSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinanceAnalysisSystemApplication.class, args);
	}

}
