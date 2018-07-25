/*
创建学生表（student），要求包含字段（学号、姓名、年龄、性别、学院）
1) 添加三名学员的信息
分别是： 
    1，张三，18 , 男，信息学院
    2，李四，20，男，理学院
    3，小红，28，女，外语学院
2) 删除关于“张三“的记录
3) 将“李四“的性别改为”女”
4) 查询所有的学生信息。
*/

-- 调用demo数据库
-- use demo;

-- 创建school表
/*CREATE TABLE school(
    studentId int(4) not null primary key,
    studentName varchar(8),`school`
    age int(4),`studentId`
    sex varchar(4),
    college varchar(32)
);*/

-- 添加记录
-- INSERT INTO `school` (`studentId`, `studentName`, `age`, `sex`, `college`) VALUES ('1', '张三', '18', '男', '信息学院');
-- INSERT INTO `school` (`studentId`, `studentName`, `age`, `sex`, `college`) VALUES ('2', '李四', '20', '男', '理学院')
-- INSERT INTO `school` (`studentId`, `studentName`, `age`, `sex`, `college`) VALUES ('3', '小红', '28', '女', '外语学院')

-- 删除记录
-- DELETE FROM `school` WHERE (`studentName`='张三');

-- 查询信息
SELECT * FROM `school`;