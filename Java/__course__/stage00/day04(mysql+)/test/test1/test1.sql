-- 1、创建一个数据库TestDb
-- create database TestDb;

-- 2、设置当前使用的数据库为TestDb
-- use TestDb;

-- 3.在数据库TestDb下创建一个表，表名为student
/*该表的列名分别为
id,stuNo,name,sex,phone
注意 id 设置为主键(整形)
stuNo 唯一
name,sex 不能为空（字符串类型）
phone 可以为空(字符型)*/
/*create table student(
   id int(4) primary key,
   stuNo int(4) unique,
   name varchar(25) not null,
   sex char(2) not null,
   phone char(11)
)ENGINE=MYISAM DEFAULT CHARSET=utf8,ENGINE=INNODB;*/

-- 4.向用户里插入4组数据
/*(1,'001','cj1','男','110')
(2,'002','cj2','男','120')
(3,'003','cj3','男','119')
(4,'004','cj4','男')*/
-- INSERT INTO student VALUES('1', '001', 'cyj1', '男', '110');
-- INSERT INTO student VALUES('2', '002', 'cyj2', '男', '120');
-- INSERT INTO student VALUES('3', '003', 'cyj3', '男', '119');
-- insert into student(`id`, `stuNo`, `name`, `sex`) values('4', '004', 'cyj4', '男');


-- 5.查询
-- （1）查询表的所有信息
-- SELECT * FROM student;

-- (2)查询id=1或3表的记录(or)
-- SELECT * FROM student where id=3 or id=4;

-- (3)查询2<=id<=4之间的记录(and)
-- SELECT * FROM student where id>=2 and id<=4;

-- （4）查询id=2,3,4的记录(in)
-- SELECT * FROM student WHERE id in(2, 3, 4);

-- 6.修改
/*将id为2,3的性别改为'女',姓名改为'cui'
然后查询结果*/
-- update student set sex='女', name='cui' where id in(2, 3);
-- select * from student where id in(2, 3);

-- 7.删除 
/*删除id=4的行
然后查询结果*/
-- delete from student where id=4;
-- select * from student;

