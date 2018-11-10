-- 如果存在，删除
DROP DATABASE IF EXISTS `mybatis_1`;

-- 创建数据库
CREATE DATABASE `mybatis_1`;

-- 使用数据库
USE `mybatis_1`;

-- 用户表(user)
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user`(
	`id` int(4) NOT NULL PRIMARY KEY auto_increment,  #用户id
	`username` varchar(32) DEFAULT NULL,  #用户名
	`password` varchar(16) DEFAULT NULL,  #用户密码
	`age` int(11) DEFAULT NULL
)ENGINE=INNODB CHARSET=utf8;
DESC `tb_user`;

INSERT INTO `tb_user` 
	(`username`, `password`, `age`) 
VALUES
	('zs', '123123', 45),
	('laiy', '4567', 22);

SELECT * FROM `tb_user`;