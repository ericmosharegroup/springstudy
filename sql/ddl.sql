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