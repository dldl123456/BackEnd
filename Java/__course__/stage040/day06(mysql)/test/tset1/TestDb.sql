/*
MySql综合练习

1.创建一个数据库TestDb

2.设置当前使用的数据库为TestDb
3.在数据库TestDb下创建一个表，表名为student
该表的列名分别为
id,stuNo,name,sex,phone
注意 id 设置为主键(整形)
stuNo 唯一
name,sex 不能为空（字符串类型）
phone 可以为空(字符型)
4.向用户里插入4组数据
(1,'001','cj1','男','110')
(2,'002','cj2','男','120')
(3,'003','cj3','男','119')
(4,'004','cj4','男')
5.查询
（1）查询表的所有信息
(2)查询id=1或3表的记录
(3)查询2<=id<=4之间的记录
（4）查询id=2,3,4的记录
6.修改
将id为2,3的性别改为'女',姓名改为'cui'
然后查询结果
7.删除 
删除id=4的行
然后查询结果
*/

-- 1.创建一个班级数据库(如果存在，先删除)
DROP DATABASE IF EXISTS TestDb;
CREATE DATABASE TestDb;

-- 2.设置当前使用的数据库为TestDb
USE TestDb;

-- 3.在数据库TestDb下创建一个表，表名为student
/*该表的列名分别为
id,stuNo,name,sex,phone
注意 id 设置为主键(整形)
stuNo 唯一
name,sex 不能为空（字符串类型）
phone 可以为空(字符型)*/
DROP TABLE IF EXISTS student;
CREATE TABLE student(
	stuId INT(4) NOT NULL PRIMARY KEY, #学生id
	stuNo INT(8) UNIQUE,  #学生学号
	stuName VARCHAR(32) NOT NULL,  #学生姓名
	stuSex CHAR(2) NOT NULL, #学生性别
	stuPhone VARCHAR(32)  #学生号码
)ENGINE=INNODB CHARSET=utf8;

-- 查看表结构
DESC student;

-- 4.向用户里插入4组数据
/*(1,'001','cj1','男','110')
(2,'002','cj2','男','120')
(3,'003','cj3','男','119')
(4,'004','cj4','男')*/
INSERT INTO student VALUES
	(1,'001','cj1','男','110'),
	(2,'002','cj2','男','120'),
	(3,'003','cj3','男','119'),
	(4,'004','cj4','男', '');

-- 5.查询
 -- (1)查询表的所有信息
 SELECT * FROM student;

 -- (2)查询id=1或3表的记录
 SELECT * FROM student WHERE stuId=1 OR stuId=3;

 -- (3)查询2<=id<=4之间的记录
 SELECT * FROM student WHERE stuId>=2 AND stuId<=4;

 -- (4)查询id=2,3,4的记录
 SELECT * FROM student WHERE stuId=2 OR stuId=3 OR stuId=4;

-- 6.修改
/*将id为2,3的性别改为'女',姓名改为'cui'
然后查询结果*/
UPDATE student SET stuSex='女', stuName='cui' WHERE stuId=2 OR stuId=3;  #中间用逗号
SELECT * FROM student WHERE stuId=2 OR stuId=3;

-- 7.删除 
/*删除id=4的行
然后查询结果*/
DELETE FROM student WHERE stuId=4;
SELECT * FROM student;

-- end