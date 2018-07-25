-- 如果存在，删除
DROP DATABASE IF EXISTS `ttt`;

-- 创建数据库
CREATE DATABASE `ttt`;

-- 使用数据库
USE `ttt`;

-- 员工表
drop table if exists employees;
create table if not exists employees (
  id int not null primary key,
  age int not null,
  name varchar(64),
  dept_id int(10)
);
INSERT INTO employees VALUES (100, 28, 'MaxSu', 1);
INSERT INTO employees VALUES (101, 25, 'WeiWang', 2);
INSERT INTO employees VALUES (102, 30, 'KidaSu', 2);
INSERT INTO employees VALUES (103, 28, 'KobeBryant', 1);
--
-- 部门表
drop table if exists dept;
create table if not exists dept (
  id int not null primary key,
  name varchar (64)
);
INSERT INTO dept VALUES (1, '技术部');
INSERT INTO dept VALUES (2, '市场部');