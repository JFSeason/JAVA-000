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


