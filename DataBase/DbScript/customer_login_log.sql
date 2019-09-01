CREATE TABLE `customer_login_log`(
	`login_id` INT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '登录日志id',
	`customer_id` INT UNSIGNED NOT NULL COMMENT '登录用户id',
	`login_time` TIMESTAMP NOT NULL COMMENT '用户登录时间',
	`login_ip` INT UNSIGNED NOT NULL COMMENT '登录ip',
	`login_type` INT NOT NULL COMMENT '登录类型：0-未成功，1-成功',
	PRIMARY KEY pk_loginid(login_id)
) ENGINE = innodb COMMENT '用户登录日志表';