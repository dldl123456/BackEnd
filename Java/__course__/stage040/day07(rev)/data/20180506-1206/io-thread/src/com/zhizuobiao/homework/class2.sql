创建学生表（student），要求包含字段（学号、姓名、年龄、性别、学院）
1) 添加三名学员的信息
分别是： 
    1，张三，18 , 男，信息学院
    2，李四，20，男，理学院
    3，小红，28，女，外语学院
2) 删除关于“张三“的记录
3) 将“李四“的性别改为”女”
4) 查询所有的学生信息。


create table student(
	id int AUTO_INCREMENT,
	name varchar(50),
	age int ,
	sex char(1),
	school varchar(50),
	PRIMARY KEY (`id`)
) DEFAULT CHARSET=utf8;

insert into student(name,age,sex,school) values("张三",18,"男","信息学院");
insert into student(name,age,sex,school) values("李四",20,"男","理学院");
insert into student(name,age,sex,school) values("小红",18,"女","外语学院");

insert into student(name,age,sex,school) values
("张三",18,"男","信息学院"),
("李四",20,"男","理学院"),
("小红",18,"女","外语学院");

update student set sex = "女" where name = "李四";

select * from student;

