CREATE TABLE `SALESORDER` (
	`ID` INT(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
	`ORDERNO` VARCHAR(200) DEFAULT NULL COMMENT '订单编号',
	`CREATETIME` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
	`PAYTIME` DATETIME DEFAULT NULL COMMENT '付款时间',
	`SENDTIME` DATETIME DEFAULT NULL COMMENT '发货时间',
	`DISTRIBUTION` INT(11) DEFAULT NULL COMMENT '配送ID',
	`REALPAY` DECIMAL(18,2) DEFAULT NULL COMMENT '实付金额',
	`DISCOUNTAMOUNT` DECIMAL(18,2) DEFAULT NULL COMMENT '优惠金额',
	`TOTALPRICE` DECIMAL(18,2) DEFAULT NULL COMMENT '商品总价',
	`ADDRESSID` INT(11) DEFAULT NULL COMMENT '收货地址ID',
	PRIMARY KEY (`ID`)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=UTF8 COMMENT='订单表';

-- 系统用户
CREATE TABLE `sys_user`
(
  `user_id`        bigint      NOT NULL AUTO_INCREMENT,
  `username`       varchar(50) NOT NULL COMMENT '用户名',
  `password`       varchar(100) COMMENT '密码',
  `salt`           varchar(20) COMMENT '盐',
  `email`          varchar(100) COMMENT '邮箱',
  `mobile`         varchar(100) COMMENT '手机号',
  `status`         tinyint COMMENT '状态  0：禁用   1：正常',
  `create_user_id` bigint(20) COMMENT '创建者ID',
  `create_time`    datetime COMMENT '创建时间',
  PRIMARY KEY (`user_id`),
  UNIQUE INDEX (`username`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='系统用户';

-- 初始数据
INSERT INTO `sys_user` (`user_id`, `username`, `password`, `salt`, `email`, `mobile`, `status`, `create_user_id`,
                        `create_time`)
VALUES ('1', 'admin', '9ec9750e709431dad22365cabc5c625482e574c74adaebba7dd02f1129e4ce1d', 'YzcmCZNvbXocrsz9dm8e',
        'root@renren.io', '13612345678', '1', '1', '2016-11-11 11:11:11');

