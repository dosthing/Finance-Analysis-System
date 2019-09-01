CREATE TABLE `customer_info`(
	`customer_info_id` INT UNSIGNED AUTO_INCREMENT NOT NULL COMMENT '自增主键Id',
	`customer_login_id` INT UNSIGNED NOT NULL COMMENT 'customer_login表的自增Id',
	`customet_name` VARCHAR(20) NOT NULL COMMENT '用户真实姓名',
	`customer_card_type` INT NOT NULL DEFAULT 1 COMMENT '证件类型： 1身份证，2 护照 3 军官证 ',
	`customer_card_no` VARCHAR(20) COMMENT '证件号码',
	`mobile_phone` VARCHAR(32) COMMENT '手机号',
	`customer_email` VARCHAR(50) COMMENT '邮箱',
	`gender` VARCHAR(1) COMMENT '性别',
	`user_point` INT NOT NULL DEFAULT 0 COMMENT '用户积分',
	`register_time` TIMESTAMP NOT NULL COMMENT '注册时间',
	`birthday` DATETIME COMMENT '会员生日',
	`customer_level` INT NOT NULL DEFAULT 1 COMMENT '会员级别： 1 普通会员 2 黄金会员 3 钻石会员',
	`user_money` DECIMAL(8,2) NOT NULL DEFAULT 0.00 COMMENT '用户余额',
	`modified_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP   ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
	PRIMARY KEY pk_customerinfoid(customer_info_id)
) ENGINE = innodb COMMENT '用户信息表  参考简书 https://www.jianshu.com/p/b89127a415df';