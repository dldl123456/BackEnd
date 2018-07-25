-- 如果存在，删除
DROP DATABASE IF EXISTS `film_system0206`;

-- 创建数据库
create database film_system0206;

-- 使用数据库
use film_system0206;

-- 用户表
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `username` varchar(20) NOT NULL COMMENT '账号',
  `password` varchar(20) DEFAULT NULL COMMENT '密码',
  `sex` char(2) DEFAULT NULL COMMENT '性别:男，女',
  `age` tinyint(3) unsigned DEFAULT NULL COMMENT '年龄',
  `mobile` varchar(20) DEFAULT NULL COMMENT '手机号',
  `auth` tinyint(4) DEFAULT NULL COMMENT '用户：1，管理员：2',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
