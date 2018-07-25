-- 主键(PRIMARY KEY)
-- 标识该属性为该表的主键，可以唯一的标识对应的记录。
-- 
-- 外键(FOREIGN KEY)
-- 标识该属性为该表的外键，与某个表的主键关联。
-- 
-- 唯一性(UNIQUE)
-- 标识该属性的值是唯一的。
-- 
-- 非空(NOT NULL)
-- 标识该属性不能为空。
-- 
-- 默认值(DEFAULT)
-- 为该属性设置默认值。
--
-- 如果需要命名 PRIMARY KEY 约束，以及为多个列定义 PRIMARY KEY 约束
-- CONSTRAINT pk_PersonID PRIMARY KEY (Id_P,LastName)

use market;
/*创建班级表 't_class'*/
create table t_class(
	#班级id为主键，唯一标识表中对应的记录，id设置为自动增长
	id int primary key auto_increment,
	#班级名称，不能为空且唯一
	className varchar(20) unique not null
)Engine=InnoDB auto_increment=5 DEFAULT CHARSET=utf8;

/*创建学生表 't_student'*/
CREATE TABLE t_student(
	#学生id为主键，唯一标识表中对应的记录，id设置为自动增长
  id int(4) not null primary key auto_increment,
	#学生姓名，不能空且唯一
  stuName varchar(20) unique not null,
	#学生性别，不能为空
	sex char(2) not null,  #或varchar(1)
	#学生出生日期，不能为空，默认值为1970-01-01 00:00:00
	birthday datetime not null default '1970-01-01 00:00:00',
	#学生所属班级为外键，关联班级表----'t_class'的主键id
	classId int,
	constraint fk_class foreign key(classId) references t_class(id)
)Engine=InnoDB auto_increment=5 DEFAULT CHARSET=utf8;