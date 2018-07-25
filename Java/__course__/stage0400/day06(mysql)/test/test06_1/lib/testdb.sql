-- 创建一个公司数据库(如果存在，先删除)
DROP DATABASE IF EXISTS testDb;
CREATE DATABASE testDb;

-- 设置当前使用的数据库为company
USE testDb;

DROP TABLE IF EXISTS student;
CREATE TABLE student (
  stu_id int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  stu_name varchar(20) DEFAULT NULL,
  stu_age int(11) DEFAULT NULL,
  stu_score double DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

INSERT INTO student(stu_id, stu_name, stu_age, stu_score) values (1, '李四', 13, 99),(2, 'jack', 18, 90),(3, 'nihao', 20, 88);

#UPDATE student SET stu_name='张三', stu_age=22, stu_score=99 WHERE stu_id=1;

SELECT * from student;


