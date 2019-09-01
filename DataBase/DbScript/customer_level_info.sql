CREATE TABLE `customer_level_info`(
	`customer_level` INT NOT NULL AUTO_INCREMENT COMMENT '会员级别Id',
	`level_name` VARCHAR(10) NOT NULL COMMENT '会员级别名称',
	`min_point` INT UNSIGNED NOT NULL DEFAULT 0 COMMENT '该级别最低积分',
	`max_point` INT UNSIGNED NOT NULL DEFAULT 0 COMMENT '该级别最高分',
	`modified_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP  ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
	PRIMARY KEY pk_levelid(customer_level)
) ENGINE = innodb COMMENT '用户级别信息表';