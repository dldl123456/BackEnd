/*
		创建学生表（student），要求包含字段（学号、姓名、年龄、性别、学院）
		1) 添加三名学员的信息
		分别是： 
				1，张三，18 , 男，信息学院
				2，李四，20，男，理学院
				3，小红，28，女，外语学院
		2) 删除关于“张三“的记录
		3) 将“李四“的性别改为”女”
		4) 查询所有的学生信息。
*/

-- 创建一个班级数据库(如果存在，先删除)
DROP DATABASE IF EXISTS Class;
CREATE DATABASE Class;

-- 在班级数据库中创建学生表(如果存在，先删除)
USE Class;
DROP TABLE IF EXISTS Students;
CREATE TABLE Students(
	stuId INT(4) NOT NULL PRIMARY KEY auto_increment, #学号,主键、非空、自增列
	stuName VARCHAR(32) NOT NULL, #学生姓名
	stuAge INT(8) NOT NULL, #学生年龄
	stuSex CHAR(2) NOT NULL, #学生性别
	stuCollege VARCHAR(32) #学生专业
)ENGINE=INNODB CHARSET=utf8;

-- 查看表结构
DESC Students;

-- 往表中添加数据
INSERT INTO Students VALUES
	(1, "张三", 18, '男', "信息学院"),
	(2, "李四", 20, '男', "理学院"),
	(3, "小红", 28, '女', "外语学院");

-- 查看表
SELECT * FROM Students;

-- 删除关于“张三“的记录
DELETE FROM Students WHERE stuName = "张三";

-- 将“李四“的性别改为”女”
UPDATE Students SET stuSex = '女' WHERE stuName = "李四";

-- 查询所有的学生信息。
SELECT * FROM Students;