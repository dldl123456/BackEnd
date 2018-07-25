
部门表
create table dept(
	dept_id int COMMENT '部门id' AUTO_INCREMENT,
	name varchar(20) COMMENT '部门名字',
	location varchar(10) COMMENT '部门地址',
	primary key (dept_id)
);

员工表
create table employee(
	emp_id int COMMENT '员工id' AUTO_INCREMENT,
	name varchar(20) COMMENT '名字',
	gender tinyint COMMENT '1男2女',
	age tinyint COMMENT '年龄',
	salary float COMMENT '工资',
	position tinyint COMMENT '职位123',
	dept_id int COMMENT '部门id',
	primary key (emp_id),
	FOREIGN KEY (`dept_id`) REFERENCES `dept` (`dept_id`)
);

1. 部门表插入3条数据；
insert into dept(name,location) values
('销售','上海'),
('开发','北京'),
('经理','广州'),
('设计','深圳');

2. 员工表插入10条数据，分属不同的部门
insert into employee(name,gender,age,salary,position,dept_id) values
('张三',1,32,6200,2,3),
('李四',1,26,4200,3,3),
('王五',2,24,3800,3,3),
('赵柳',1,25,3200,3,3),
('张小红',2,26,6300,2,2),
('玫瑰',2,23,1600,1,2),
('月季',2,24,2200,1,2),
('牡丹',2,25,4900,1,2),
('玛丽',2,23,3600,3,1),
('张小明',1,26,2800,3,1);

3. 选择部门3 中的所有员工。
select * from employee where dept_id = 3;

4. 列出所有员工的姓名，编号和部门编号。
select name as 姓名,dept_id as 部门id ,emp_id as 员工id  from employee;

5. 找出工资低于2000的员工信息
select * from employee where salary < 2000;

6. 找出工资高于3000的女员工信息（包括部门名称）
select * from employee where salary > 3000 and gender = 2;

7. 找出部门1和部门2中所有经理的详细信息。
select * from employee where (dept_id = 1 or dept_id=2) and position=2;

8. 找出部门3中所有男员工的信息。
select * from employee where dept_id=3 and gender = 1;

9. 找出部门1 中所有经理和部门2 中所有业务员
 	和既不是经理又不是业务员但是工资大于或等于2000的所有员工信息。
select * from employee where (dept_id=1 and position=2)  or (dept_id=2 and position=1) or (position not in(2,1) and salary >=2000);

10. 显示员工姓名中不含“张”的员工信息
select * from employee where name not like '%张%';

11. 显示员工的详细信息，并按照姓名排序
select * from employee order by convert (name using gbk) desc;

12. 显示所有员工的姓名、部门名称，工资，按照工资降序排列
select e.name,d.name,e.salary from employee as e 
	left join dept d on e.dept_id = d.dept_id order by e.salary desc;

select e.name,d.name,e.salary from employee as e ,dept as d 
	where e.dept_id = d.dept_id order by e.salary desc;

13. 显示所有部门名称和这些部门的员工信息 
select * from employee as e 
	left join dept d on e.dept_id = d.dept_id ;

14. 显示所有部门2的部门名称，部门的员工人数 
select d.name,count(e.name) from employee as e 
	left join dept d on e.dept_id = d.dept_id where e.dept_id=2 ;

15. 显示工资高于经理平均工资的所有员工姓名，部门和工资。
select e.name,d.name,e.salary from employee as e 
	left join dept d on e.dept_id = d.dept_id where salary > (select avg(salary) from employee where position=2)

16. 列出各个部门的平均工资，最高工资和最低工资
select dept_id , avg(salary), max(salary) ,min(salary) ,count(1)  from employee group by dept_id;

