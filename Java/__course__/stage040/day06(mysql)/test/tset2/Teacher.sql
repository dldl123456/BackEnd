/*
已有教师表 teacher [id(number primary key),name varchar2(15),salary(number),gender varchar2(3),age(number) ]; 
按要求完成作业。 
1.向表中插入语句 （101,'Tom',5000,'男',28）; （102,'Larry',5000,'男',26）; （103,'Katty',6500,'女',30）; （104,'Arabt',5000,'男',27）; 
2.将编号为103的老师的工资改为6800 
3.将名字为Katty的老师的年龄改为29 
4.将编号为103这一行的数据删除 
5.事物的ACID的原则是怎样的？
*/

-- 1.创建一个数据库(如果存在，先删除)
DROP DATABASE IF EXISTS test2;
CREATE DATABASE test2;

-- 2.设置当前使用的数据库为test2
USE test2;

-- 创建教师表
/*
teacher [id(number primary key),name varchar2(15),salary(number),gender varchar2(3),age(number) ]; 
*/
DROP TABLE IF EXISTS teacher;
CREATE TABLE teacher(
	teaId INT(4) NOT NULL PRIMARY KEY, #教师id
	teaName VARCHAR(15),  #教师姓名
	teaSalary INT(16),  #教师工资
	teaGender VARCHAR(3), #教师性别
	teaAge INT(4)  #教师年龄
)ENGINE=INNODB CHARSET=utf8;

-- 查看表结构
DESC teacher;

-- 1.向表中插入语句 （101,'Tom',5000,'男',28）; （102,'Larry',5000,'男',26）; （103,'Katty',6500,'女',30）; （104,'Arabt',5000,'男',27）; 
INSERT INTO teacher VALUES
	(101,'Tom',5000,'男',28),
	(102,'Larry',5000,'男',26),
	(103,'Katty',6500,'女',30),
	(104,'Arabt',5000,'男',27);

SELECT * FROM teacher;

-- 2.将编号为103的老师的工资改为6800 
UPDATE teacher SET teaSalary=6800 WHERE teaId=103;
SELECT * FROM teacher WHERE teaId=103;

-- 3.将名字为Katty的老师的年龄改为29 
UPDATE teacher SET teaAge=29 WHERE teaName="Katty";
SELECT * FROM teacher WHERE teaName="Katty";

-- 4.将编号为103这一行的数据删除
DELETE FROM teacher WHERE teaId=103;
SELECT * FROM teacher;

-- 5.事物的ACID的原则是怎样的？
/*
	ACID就是：原子性(Atomicity )、一致性( Consistency )、隔离性或独立性( Isolation)和持久性(Durabilily)。
	1. 原子性 
		 原子性属性用于标识事务是否完全地完成，一个事务的任何更新要在系统上完全完成，如果由于某种原因出错，
		 事务不能完成它的全部任务，系统将返回到事务开始前的状态。 
	2. 一致性 
		 事务在系统完整性中实施一致性，这通过保证系统的任何事务最后都处于有效状态来实现。如果事务成功地完成，
		 那么系统中所有变化将正确地应用，系统处于有效状态。如果在事务中出现错误，那么系统中的所有变化将自动地回滚，系统返回到原始状态。
		 因为事务开始时系统处于一致状态，所以现在系统仍然处于一致状态。
	3. 隔离性 
		 在隔离状态执行事务，使它们好像是系统在给定时间内执行的唯一操作。如果有两个事务，运行在相同的
		 时间内，执行相同的功能，事务的隔离性将确保每一事务在系统中认为只有该事务在使用系统。 
	4. 持久性 
		 持久性意味着一旦事务执行成功，在系统中产生的所有变化将是永久的。应该存在一些检查点防止在系统失败时丢失
		 信息。甚至硬件本身失败，系统的状态仍能通过在日志中记录事务完成的任务进行重建。持久性的概念允许开发者认为不管系统以后发生了什么变化，完 
		 成的事务是系统永久的部分。 
*/
