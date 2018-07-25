MySql综合练习

1.创建一个数据库TestDb
create database testdb;

2.设置当前使用的数据库为TestDb
use testdb;

3.在数据库TestDb下创建一个表，表名为student
该表的列名分别为
id,stuNo,name,sex,phone
注意 id 设置为主键(整形)
stuNo 唯一
name,sex 不能为空（字符串类型）
phone 可以为空(字符型)

create table student(
id int ,
stu_no varchar(10) unique,
name varchar(30) not null,
sex varchar(2) not null,
phone varchar(20),
primary key (id)
);

4.向用户里插入4组数据
(1,'001','cj1','男','110')
(2,'002','cj2','男','120')
(3,'003','cj3','男','119')
(4,'004','cj4','男')

insert into student(id,stu_no,name,sex,phone) values
(1,'001','cj1','男','110'),
(2,'002','cj2','男','120'),
(3,'003','cj3','男','119'),
(4,'004','cj4','男','');

5.查询
（1）查询表的所有信息
select * from student;
 (2)查询id=1或3表的记录
select * from student where id = 3 or id = 1;
 (3)查询2<=id<=4之间的记录
 select * from student where id >= 2 and id <= 4;
（4）查询id=2,3,4的记录
 select * from student where id in (2,3,4);

6.修改
将id为2,3的性别改为'女',姓名改为'cui'
然后查询结果
update student set sex = '女',name= 'cui' where id= 2 or id =3;
select * from student;

7.删除 
删除id=4的行
然后查询结果

delete from student where id = 4;
select * from student;