-- 如果存在，删除
DROP DATABASE IF EXISTS `test06_1`;

-- 创建数据库
CREATE DATABASE `test06_1`;

-- 使用数据库
USE `test06_1`;

-- 用户表(user)
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`(
	`id` int(4) NOT NULL PRIMARY KEY auto_increment,  #用户id
	`username` varchar(32) DEFAULT NULL,  #用户名
	`password` varchar(16) DEFAULT NULL,  #用户密码
	`level` varchar(16) DEFAULT NULL  #级别
)ENGINE=INNODB CHARSET=utf8;
#DESC `user`;

INSERT INTO `user` 
	(`username`, `password`, `level`) 
VALUES
	('张三', '123123', '低级'),
	('李四', '456456', '中级'),
	('王五', '789789', '高级');
SELECT * FROM `user`;