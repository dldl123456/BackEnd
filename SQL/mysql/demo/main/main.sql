-- 新建
/*CREATE DATABASE student;

use student;
CREATE TABLE stu(
	id INT PRIMARY KEY auto_increment,
	name VARCHAR(50),
	sex CHAR(2) DEFAULT '男',
	age INT
);

insert into stu values (1, 'zmx', '男', 3);
insert into stu values (2, 'zmx', 'm', 3);
insert into stu values (3, 'zmx', '女', 3);

SELECT * from stu;*/

-- 查看表结构
-- DESC stu;

-- 修改
/*UPDATE stu set name='张三', sex='女', age=22 WHERE id=1;
SELECT * from stu;*/

-- 删除
/*DELETE from stu WHERE id=3;
SELECT * from stu;*/

-- 清空表
/*TRUNCATE stu;
SELECT * from stu;*/

/*insert into stu (name, sex, age) VALUES ('zmx', '男', '99');
SELECT * from stu;*/

/*use student;
SELECT * from stu;*/

