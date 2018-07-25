CREATE DATABASE student;
#DROP DATABASE student;

use student;

-- 班级表
/**
班级表
表名：Class
字段：
ClassId 主键
ClassName 班级名称
*/
CREATE TABLE Class(
	ClassId INT(4) PRIMARY KEY,
	ClassName VARCHAR(32)
)Engine=InnoDB DEFAULT CHARSET=utf8;
DESC Class;

INSERT INTO Class VALUES (1, '1班');
INSERT INTO Class VALUES (2, '2班');
INSERT INTO Class VALUES (3, '3班');
INSERT INTO Class VALUES (4, '4班');
INSERT INTO Class VALUES (5, '5班');
INSERT INTO Class VALUES (6, '6班');
SELECT * FROM Class;

#清空班级表
#TRUNCATE Class;  

-- 学生表
/**
表名：Student
字段：
StudentId 主键
StudentName 学生姓名
Age 年龄
Sex 性别
Birthday 生日
ClassId 班级表主键（所属班级id）
*/
CREATE TABLE Student(
	StudentId INT(4) PRIMARY KEY,
	StudentName VARCHAR(32),
	Age INT(4),
	Sex CHAR(2),
	Birthday DATE DEFAULT '1990-1-1',
	ClassId INT(4)
)Engine=InnoDB DEFAULT CHARSET=utf8;
DESC Student;

-- SELECT DAYOFMONTH()

INSERT INTO Student VALUES (1, '大大', 12, '男', '1993-6-5', 1);
INSERT INTO Student VALUES (2, '中中', 13, '女', '1993-2-8', 5);
INSERT INTO Student VALUES (3, '小小', 3, '男', '1993-1-3', 3);
INSERT INTO Student VALUES (4, '花花', 11, '女', '1993-11-5', 2);
SELECT * FROM Student;

-- 查询笔记
/*SELECT Birthday AS '大大的生日' FROM Student WHERE StudentName='大大';
SELECT MONTH('1993-6-5') AS '大大的生日月份';
SELECT MONTH(birthday) AS '大大的生日' from student WHERE StudentName='大大';*/


#清空学生表
#TRUNCATE Student; 
#删除学生表
#DROP TABLE Student;


-- 课程表
/**
表名：Subject
字段：
SubjectId 主键
SubjectName 课程名称
Remark 备注
*/
CREATE TABLE Subject(
	SubjectId INT(4) PRIMARY KEY,
	SubjectName VARCHAR(32),
	Remark VARCHAR(50) COMMENT '备注'
)Engine=InnoDB DEFAULT CHARSET=utf8;
DESC Subject;

INSERT INTO Subject VALUES (1, '数学', '数学课');
INSERT INTO Subject VALUES (2, '语文', '语文课');
INSERT INTO Subject VALUES (3, '英语', '英语课');
SELECT * FROM Subject;

#清空课程表
#TRUNCATE Subject; 


-- 学生和课程中间表
/**
表名：Student_Subject
字段：
Student_Subject_Id 主键
SubjectId 课程表主键
StudentId 学生表主键
*/
CREATE TABLE Student_Subject(
	Student_Subject_Id INT(4) PRIMARY KEY,
	SubjectId INT(4),
	StudentId INT(4)
)Engine=InnoDB DEFAULT CHARSET=utf8;
DESC Student_Subject;

INSERT INTO Student_Subject VALUES (1, 1, 1);
INSERT INTO Student_Subject VALUES (2, 2, 2);
INSERT INTO Student_Subject VALUES (3, 3, 3);
SELECT * FROM Student_Subject;

#清空学生和课程中间表
#TRUNCATE Student_Subject; 


-- 学生备注表
/**
表名：StudentRemark
字段：
StudentId 学生表主键
StudentRemark 备注
*/
CREATE TABLE StudentRemark(
	StudentId INT(4) PRIMARY KEY,
	StudentRemark VARCHAR(50) COMMENT '备注'
)Engine=InnoDB DEFAULT CHARSET=utf8;
DESC StudentRemark;

INSERT INTO StudentRemark VALUES (1, '记大过');
INSERT INTO StudentRemark VALUES (2, '退学');
INSERT INTO StudentRemark VALUES (3, '被哈佛录取');
SELECT * FROM StudentRemark;

#清空学生备注表
#TRUNCATE StudentRemark; 


-- 星座表
CREATE TABLE Star(
	StarId INT(4) PRIMARY KEY NOT null auto_increment,
	BeginTime VARCHAR(32),
	EndTime VARCHAR(32),
	StarName VARCHAR(32)
)Engine=InnoDB DEFAULT CHARSET=utf8;
DESC Star;

INSERT INTO Star values('1', '1-20', '2-18', '水瓶座');
INSERT INTO Star values('2', '2-19', '3-20', '双鱼座');
INSERT INTO Star values('3', '3-21', '4-19', '白羊座');
INSERT INTO Star values('4', '4-20', '5-20', '金牛座');
INSERT INTO Star values('5', '5-21', '6-21', '双子座');
INSERT INTO Star values('6', '6-22', '7-22', '巨蟹座');
INSERT INTO Star values('7', '7-23', '8-22', '狮子座');
INSERT INTO Star values('8', '8-23', '9-22', '处女座');
INSERT INTO Star values('9', '9-23', '10-23', '天枰座');
INSERT INTO Star values('10', '10-24', '11-22', '天蝎座');
INSERT INTO Star values('11', '11-23', '12-21', '射手座');
INSERT INTO Star values('12', '12-22', '1-19', '摩羯座');
SELECT * FROM Star;

#清空星座表
#TRUNCATE Star;
#删除星座表
#DROP TABLE Star;




-- 查询
#查询大大的星座(学生表、星座表)
SELECT MONTH(birthday) AS '大大的生日' from student WHERE StudentName='大大';

select StarName from Star where BeginTime;
select * ,(select StarName from Star where BeginTime>Student.Birthday and Student.Birthday>EndTime) as '星座' from Student where StudentName='大大';
-- (select StarName from Star where BeginTime>Student.Birthday and Student.Birthday>EndTime)where BeginTime>Student.Birthday and Student.Birthday>EndTime