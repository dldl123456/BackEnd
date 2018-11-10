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
#DESC `tb_user`;

INSERT INTO `tb_user` 
	(`username`, `password`, `age`) 
VALUES
	('zs', '123123', 45),
	('laiy', '4567', 22);
#SELECT * FROM `tb_user`;


-- 用户表(user)
DROP TABLE IF EXISTS `tbs_user`;
CREATE TABLE `tbs_user`(
	`id` VARCHAR(128) NOT NULL PRIMARY KEY,  #用户id
	`username` varchar(32) DEFAULT NULL,  #用户名
	`password` varchar(16) DEFAULT NULL  #用户密码
)ENGINE=INNODB CHARSET=utf8;
#DESC `tbs_user`;

INSERT INTO `tbs_user` 
	(`id`, `username`, `password`) 
VALUES
	('333434223', 'zs', '123123'),
	('78964123156', 'laiy', '4567');
#SELECT * FROM `tbs_user`;



-- 商品表(tb_goods)
DROP TABLE IF EXISTS `tb_goods`;
CREATE TABLE `tb_goods`(
	`id` int(16) NOT NULL PRIMARY KEY auto_increment,
	`goodsname` varchar(32) DEFAULT NULL,
	`price` FLOAT DEFAULT NULL,
	`num` int DEFAULT NULL
)ENGINE=INNODB CHARSET=utf8;
#DESC `tbs_user`;

INSERT INTO `tb_goods` 
	(`goodsname`, `price`, `num`)
VALUES
	('apple', 800, 20),
	('banana', 300, 100),
	('TV', 230000, 3);
#SELECT * FROM `tb_goods`;

-- 动物表(tb_animals)
DROP TABLE IF EXISTS `tb_animals`;
CREATE TABLE `tb_animals`(
	`id` int(16) NOT NULL PRIMARY KEY auto_increment,
	`animal_name` varchar(32) DEFAULT NULL,
	`a_age` int DEFAULT NULL
)ENGINE=INNODB CHARSET=utf8;
#DESC `tb_animals`;

INSERT INTO `tb_animals` 
	(`animal_name`, `a_age`)
VALUES
	('dog', 20),
	('cat', 3);
#SELECT * FROM `tb_animals`;



-- 用户表(user_tb)
DROP TABLE IF EXISTS `user_tb`;
CREATE TABLE `user_tb`(
	`uid` int(4) NOT NULL PRIMARY KEY auto_increment,  #用户id
	`uname` varchar(32) DEFAULT NULL,  #用户名
	`groupId` int(4) NOT NULL
)ENGINE=INNODB CHARSET=utf8;
#DESC `user_tb`;

INSERT INTO `user_tb` 
	(`uname`, `groupId`) 
VALUES
	('zs', 1),
	('gj', 2),
	('er', 2),
	('xb', 1);
#SELECT * FROM `user_tb`;

-- 组表(group_tb)
DROP TABLE IF EXISTS `group_tb`;
CREATE TABLE `group_tb`(
	`gid` int(4) NOT NULL PRIMARY KEY auto_increment,  
	`gname` varchar(32) DEFAULT NULL  
)ENGINE=INNODB CHARSET=utf8;
#DESC `group_tb`;

INSERT INTO `group_tb` 
	(`gname`) 
VALUES
	('code'),
	('sell');
#SELECT * FROM `group_tb`;



-- (tb_person)
DROP TABLE IF EXISTS `tb_person`;
CREATE TABLE `tb_person`(
	`pid` int(4) NOT NULL PRIMARY KEY auto_increment,  
	`pname` varchar(32) DEFAULT NULL  
)ENGINE=INNODB CHARSET=utf8;
#DESC `tb_person`;

INSERT INTO `tb_person` 
	(`pname`) 
VALUES
	('xiaohua'),
	('zhangsan');
#SELECT * FROM `tb_person`;


-- (tb_card)
DROP TABLE IF EXISTS `tb_card`;
CREATE TABLE `tb_card`(
	`cid` int(4) NOT NULL PRIMARY KEY auto_increment,  
	`cardNo` varchar(32) DEFAULT NULL,
	`personId` int(4) NOT NULL
)ENGINE=INNODB CHARSET=utf8;
#DESC `tb_card`;

INSERT INTO `tb_card` 
	(`cardNo`, `personId`) 
VALUES
	('15248564165', 1),
	('48654531561', 2);
#SELECT * FROM `tb_card`;




-- (tb_student)
DROP TABLE IF EXISTS `tb_student`;
CREATE TABLE `tb_student`(
	`sid` int(4) NOT NULL PRIMARY KEY auto_increment,  
	`sname` varchar(32) DEFAULT NULL
)ENGINE=INNODB CHARSET=utf8;
#DESC `tb_student`;

INSERT INTO `tb_student` 
	(`sname`) 
VALUES
	('xiaohua'),
	('cfsd'),
	('gffsd');
#SELECT * FROM `tb_student`;


-- (tb_course)
DROP TABLE IF EXISTS `tb_course`;
CREATE TABLE `tb_course`(
	`cid` int(4) NOT NULL PRIMARY KEY auto_increment,  
	`cname` varchar(32) DEFAULT NULL
)ENGINE=INNODB CHARSET=utf8;
#DESC `tb_course`;

INSERT INTO `tb_course` 
	(`cname`) 
VALUES
	('java'),
	('html'),
	('c++');
#SELECT * FROM `tb_course`;

-- (tb_middle)
DROP TABLE IF EXISTS `tb_middle`;
CREATE TABLE `tb_middle`( 
	`mid` int(4) NOT NULL PRIMARY KEY auto_increment,  
	`studentId` int(4) DEFAULT NULL,  
	`courseId` int(4) DEFAULT NULL
)ENGINE=INNODB CHARSET=utf8;
#DESC `tb_middle`;

INSERT INTO `tb_middle` 
	(`studentId`, `courseId`) 
VALUES
	(1, 1),
	(2, 1),
	(3, 2),
	(2, 3);
#SELECT * FROM `tb_middle`;
