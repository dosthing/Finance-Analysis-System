CREATE TABLE `customer_addr`(
	`customer_addr_id` INT UNSIGNED AUTO_INCREMENT NOT NULL COMMENT '自增主键',
	`customer_id` INT UNSIGNED NOT NULL COMMENT 'customer_login表的自增id',
	`zip` INT NOT NULL COMMENT '邮编',
	`province` INT NOT NULL COMMENT '地区表中的省份Id',
	`city` INT NOT NULL COMMENT '地区表中城市的Id',
	`district` INT NOT NULL COMMENT '地区表中的区Id',
	`address` VARCHAR(200) NOT NULL COMMENT '具体地址门牌号',
	`is_defualt` INT NOT NULL COMMENT '是否默认',
	`modified_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP  ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
	PRIMARY KEY pk_customeraddrid(customer_addr_id)
) ENGINE = innodb COMMENT '用户地址表';