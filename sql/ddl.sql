create DATABASE springstudy;

use springstudy;

DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
    `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增id',
    `username` varchar(64) NOT NULL DEFAULT '' COMMENT '用户名',
    `user_mobile_no` varchar(64) NOT NULL DEFAULT '' COMMENT '手机号',
    `user_email` varchar(64) NOT NULL DEFAULT '' COMMENT 'email',
    `remark` varchar(64) NOT NULL DEFAULT '' COMMENT '备注',
    `remark2` varchar(64) NOT NULL DEFAULT '' COMMENT '备注2',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP  COMMENT '创建时间',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB CHARSET = utf8 COMMENT 't_user';


DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
    `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增id',
    `user_id` varchar(64) NOT NULL DEFAULT '' COMMENT '用户 id',
    `dr_amount` bigint(20) UNSIGNED NOT NULL DEFAULT 0 COMMENT '借方金额',
    `cr_amount` bigint(20) UNSIGNED NOT NULL DEFAULT 0 COMMENT '贷方金额',
    `balance` bigint(20) UNSIGNED NOT NULL DEFAULT 0 COMMENT '余额,如钱包余额',
    `account_name` varchar(64) NOT NULL DEFAULT '' COMMENT '账户名,如现金钱包',
    `account_type` varchar(10) NOT NULL DEFAULT '0' COMMENT '0-资金账户,1-应收账户,2-应付账户',
    `card_type` varchar(10) NOT NULL DEFAULT '0' COMMENT '银行卡类型, 0-其他,1-借记卡,2-信用卡',
    `remark` varchar(64) NOT NULL DEFAULT '' COMMENT '备注',
    `create_time` TIMESTAMP NOT NULL DEFAULT '2010-09-10 10:30:50'  COMMENT '创建时间',
    `update_time` TIMESTAMP NOT NULL DEFAULT '2010-09-10 10:30:50' ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB CHARSET = utf8 COMMENT '资产账户表';


DROP TABLE IF EXISTS `month_bill`;
CREATE TABLE `month_bill` (
    `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增id',
    `user_id` varchar(64) NOT NULL DEFAULT '' COMMENT '用户 id',
    `dr_amount` bigint(20) UNSIGNED NOT NULL DEFAULT 0 COMMENT '借方金额',
    `cr_amount` bigint(20) UNSIGNED NOT NULL DEFAULT 0 COMMENT '贷方金额',
    `balance` bigint(20) UNSIGNED NOT NULL DEFAULT 0 COMMENT '余额,如钱包余额',
    `account_id` bigint(20) UNSIGNED NOT NULL DEFAULT 0 COMMENT '账户id',
    `tx_month` varchar(6) NOT NULL DEFAULT '' COMMENT '交易月,如201901',
    `start_date` varchar(4) NOT NULL DEFAULT '' COMMENT '账单周期开始日期',
    `end_date` varchar(4) NOT NULL DEFAULT '' COMMENT '账单周期结束日期',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB CHARSET = utf8 COMMENT '每月余额表';


DROP TABLE IF EXISTS `daily_bill`;
CREATE TABLE `daily_bill` (
    `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增id',
    `user_id` varchar(64) NOT NULL DEFAULT '' COMMENT '用户id',
    `tx_date` varchar(8) NOT NULL DEFAULT '' COMMENT '交易日期,如20190125',
    `tx_amount` bigint(20) UNSIGNED NOT NULL DEFAULT 0 COMMENT '交易金额',
    `dr_amount` bigint(20) UNSIGNED NOT NULL DEFAULT 0 COMMENT '借方金额',
    `cr_amount` bigint(20) UNSIGNED NOT NULL DEFAULT 0 COMMENT '贷方金额',
    `account_id` bigint(20) UNSIGNED NOT NULL DEFAULT 0 COMMENT '账户id',
    `tx_type` varchar(10) NOT NULL DEFAULT '0' COMMENT '交易类型,支出-0,收入-1,转账-2',
    `remark` varchar(64) NOT NULL DEFAULT '' COMMENT '备注',
    `create_time` TIMESTAMP NOT NULL DEFAULT '2010-09-10 10:30:50'  COMMENT '创建时间',
    `update_time` TIMESTAMP NOT NULL DEFAULT '2010-09-10 10:30:50' ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB CHARSET = utf8 COMMENT '交易明细表, 记录每一笔支出/收入交易';
