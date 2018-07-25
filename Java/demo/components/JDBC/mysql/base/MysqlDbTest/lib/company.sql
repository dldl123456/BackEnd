-- 如果存在，删除数据库
DROP DATABASE IF EXISTS company;

-- 创建数据库
CREATE DATABASE company;

-- 使用数据库
use company;

-- 如果存在，删除表
DROP TABLE IF EXISTS employee;

-- 创建表
CREATE TABLE Employee(
	Id INT(4) PRIMARY KEY NOT NULL auto_increment,
	EmpName VARCHAR(20),
	Pwd VARCHAR(20),
	Age INT(4)
)ENGINE=INNODB auto_increment=1 DEFAULT CHARSET=utf8;

-- 查询表结构
DESC Employee;

-- 插入记录
INSERT INTO employee VALUES(1, '小明', '123123', '22');
INSERT INTO employee VALUES(2, '小z', '123123', '22');
INSERT INTO employee VALUES(3, 'zmx', '44332', '15');

-- 查询表信息
select * from employee;

