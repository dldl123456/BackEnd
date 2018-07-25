/*
	1. 部门表插入3条数据；
	2. 员工表插入10条数据，分属不同的部门
	3. 选择部门3 中的所有员工。
	4. 列出所有员工的姓名，编号和部门编号。
	5. 找出工资低于2000的员工信息
	6. 找出工资高于3000的女员工信息（包括部门名称）
	7. 找出部门1和部门2中所有经理的详细信息。
	8. 找出部门3中所有男员工的信息。
	9. 找出部门1 中所有经理和部门2 中所有业务员和既不是经理又不是业务员但是工资大于或等于2000的所有员工信息。
	10. 显示员工姓名中不含“张”的员工信息
	11. 显示员工的详细信息，并按照姓名排序
	12. 显示所有员工的姓名、部门名称，工资，按照工资降序排列
	13. 显示所有部门名称和这些部门的员工信息 
	14. 显示所有部门2的部门名称，部门的员工人数 
	15. 显示工资高于经理平均工资的所有员工姓名，部门和工资。
	16. 列出各个部门的平均工资，最高工资和最低工资
	要求：

	建表语句和所有sql语句直接填入到答案框里面
*/

-- 创建一个公司数据库(如果存在，先删除)
DROP DATABASE IF EXISTS CompanyDb;
CREATE DATABASE CompanyDb;

-- 设置当前使用的数据库为company
USE CompanyDb;

-- 在数据库company下创建一个部门表，表名为dept
DROP TABLE IF EXISTS dept;
CREATE TABLE dept(
	dept_id INT(4) NOT NULL PRIMARY KEY auto_increment, #部门id,主键、非空、自增列
	dept_name VARCHAR(20),  #部门名称
	location VARCHAR(100) #部门地址
)ENGINE=INNODB CHARSET=utf8;

-- 查看表结构
#DESC dept;

-- 在数据库company下创建一个员工表，表名为employee
DROP TABLE IF EXISTS employee;
CREATE TABLE employee(
	emp_id INT(4) NOT NULL PRIMARY KEY auto_increment, #员工id,主键、非空、自增列
	emp_name VARCHAR(20),  #姓名
	gender char(2), #性别
	age TINYINT, #年龄
	salary FLOAT, #工资
	position VARCHAR(20), #职位，1、业务员，2、经理，3、职员
	dept_id INT #部门id
)ENGINE=INNODB CHARSET=utf8;

-- 查看表结构
#DESC dept;


-- 1.部门表插入3条数据；
INSERT INTO dept VALUES
	('1', '运营部', '地址1'),
	('2', '技术部', '地址2'),
	('3', '销售部', '地址3');

-- 查看表
SELECT * FROM dept;

-- 2.员工表插入10条数据，分属不同的部门
INSERT INTO employee
	(emp_name, gender, age, salary, position, dept_id) 
VALUES
	('张三', '男', 28, 1200.0, '职员', 1),
	('李四', '男', 26, 2000.0, '职员', 2),
	('王五', '女', 27, 16000.0, '业务员', 1),
	('小明', '男', 30, 12000.0, '经理', 2),
	('赵六', '女', 28, 10000.0, '经理', 1),
	('小绿', '男', 20, 10000.0, '职员', 3),
	('小紫', '女', 20, 15000.0, '职员', 2),
	('小红', '女', 22, 8000.0, '经理', 3),
	('小花', '女', 26, 8000.0, '业务员', 2),
	('纸巾', '男', 23, 6000.0, '职员', 2);

-- 查看表
SELECT 
	emp_id '员工编号', dept_name '部门名称', emp_name '员工姓名', 
	gender '性别', age '年龄', salary '工资', 
	position '职位', location '公司地址'
FROM 
	dept, employee  
WHERE dept.dept_id=employee.dept_id;

-- 3.选择部门3中的所有员工
SELECT * FROM employee WHERE dept_id=3;

-- 4.列出所有员工的姓名，编号和部门编号
SELECT emp_id, emp_name, dept_id FROM employee;

-- 5.找出工资低于2000的员工信息
SELECT * FROM employee WHERE salary<2000;

-- 6.找出工资高于3000的女员工信息（包括部门名称）
SELECT 
	emp_id '员工编号', dept_name '部门名称', emp_name '员工姓名', 
	gender '性别', age '年龄', salary '工资', 
	position '职位', location '公司地址'
FROM 
	dept, employee  
WHERE 
	dept.dept_id=employee.dept_id
AND gender='女' AND salary>3000;

-- 7.找出部门1和部门2中所有经理的详细信息
SELECT * FROM employee WHERE dept_id IN(1, 2) AND position='经理';

-- 8.找出部门3中所有男员工的信息
SELECT * FROM employee WHERE dept_id=3 AND gender='男';

-- 9.找出部门1中所有经理和部门2中所有业务员和既不是经理又不是业务员但是工资大于或等于2000的所有员工信息。
SELECT * FROM 
	employee 
WHERE 
	(dept_id=1 AND position='经理')
OR
	(dept_id=2 AND position='业务员')
OR
	(position NOT IN('经理', '业务员') AND salary>=2000);

-- 10.显示员工姓名中不含“张”的员工信息
SELECT * FROM employee WHERE emp_name NOT LIKE '%张%';

-- 11.显示员工的详细信息，并按照姓名排序
SELECT * FROM employee ORDER BY emp_name ASC;

-- 12.显示所有员工的姓名、部门名称，工资，按照工资降序排列
SELECT 
	emp_name '员工姓名', dept_name '部门名称', salary '工资'
FROM 
	dept, employee  
WHERE 
	dept.dept_id=employee.dept_id
ORDER BY
	salary DESC;

-- 13.显示所有部门名称和这些部门的员工信息
SELECT 
	emp_id '员工编号', dept_name '部门名称', emp_name '员工姓名', 
	gender '性别', age '年龄', salary '工资', 
	position '职位', location '公司地址'
FROM 
	dept, employee  
WHERE dept.dept_id=employee.dept_id;

-- 14.显示所有部门2的部门名称，部门的员工人数
SELECT 
	dept_name '部门名称', COUNT(*) 'count'
FROM 
	dept, employee
WHERE dept.dept_id=2 AND dept.dept_id=employee.dept_id
GROUP BY dept_name

-- 15.显示工资高于经理平均工资的所有员工姓名，部门和工资
SELECT * FROM employee 
WHERE 
	position != '经理' 
AND 
	salary > (SELECT AVG(salary) '平均分数' FROM employee WHERE position='经理');

-- 16.列出各个部门的平均工资，最高工资和最低工资
SELECT 
	dept_name '部门名称', ROUND(AVG(salary), 2) '平均工资', MAX(salary) '最高工资', MIN(salary) '最低工资'
FROM 
	dept, employee
WHERE 
	dept.dept_id=employee.dept_id
GROUP BY dept_name

-- end