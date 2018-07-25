/*
 * 编写SQL语句实现以下的要求：
 * 1. 查询出血型为“O型”的用户姓名、性别；（两表连接）
 * 2. 使用连接查询(内联)，查询出血型为“A型”并且星座为“白羊座”的用户姓名、性别；
 * 3. 用户“.NET”更新自己的名字为“天外飞仙”，请编写SQL语句进行更新；
 * 查询输出用户的详细信息，输出结果
*/

-- 删除数据库
DROP DATABASE IF EXISTS test1;

-- 创建数据库
CREATE DATABASE test1;

-- 删除数据库
#DROP DATABASE tse1;

-- 使用数据库
use test1;


-- 用户信息表
DROP TABLE IF EXISTS Users;
-- 创建用户信息表
CREATE TABLE Users(
	Id INT(4) PRIMARY KEY NOT NULL auto_increment,
	NickName VARCHAR(16),
	Sex CHAR(2),
	StarId INT(4) NOT NULL,
	BloodTypeId INT(4) NOT NULL
)ENGINE=INNODB auto_increment=1 DEFAULT CHARSET=utf8;

-- 查看用户信息表结构
#DESC Users;

-- 往用户信息表中插入记录
INSERT INTO Users values(1, '豆豆', '男', 7, 1);
INSERT INTO Users values(2, '小强', '男', 6, 4);
INSERT INTO Users values(3, '静静', '男', 5, 2);
INSERT INTO Users values(4, '.Net', '男', 8, 3);
INSERT INTO Users values(5, 'bobo', '男', 4, 1);
INSERT INTO Users values(6, '我爱C#', '男', 6, 2);
INSERT INTO Users values(7, '风筝', '女', 3, 1);
INSERT INTO Users values(8, 'benben', '男', 3, 1);
INSERT INTO Users values(9, '吕洞宾', '男', 1, 1);
INSERT INTO Users values(10, '清凉一夏', '女', 8, 2);

-- 查看用户信息表
#SELECT * FROM Users;

-- 清空用户信息表
#TRUNCATE Users; 
-- 删除用户表
#DROP TABLE Users;


-- 星座信息表
DROP TABLE IF EXISTS Star;
-- 创建星座信息表
CREATE TABLE Star(
	Id INT(4) PRIMARY KEY NOT NULL auto_increment,
	StarName VARCHAR(32)
)ENGINE=INNODB auto_increment=1 DEFAULT CHARSET=utf8;

-- 查看星座信息表结构
#DESC Attribute;

-- 往星座信息表中插入记录
INSERT INTO Star values(1, '水瓶座');
INSERT INTO Star values(2, '双鱼座');
INSERT INTO Star values(3, '白羊座');
INSERT INTO Star values(4, '金牛座');
INSERT INTO Star values(5, '双子座');
INSERT INTO Star values(6, '巨蟹座');
INSERT INTO Star values(7, '狮子座');
INSERT INTO Star values(8, '处女座');
INSERT INTO Star values(9, '天枰座');
INSERT INTO Star values(10, '天蝎座');
INSERT INTO Star values(11, '射手座');
INSERT INTO Star values(12, '摩羯座');

-- 查看星座信息表
#SELECT * FROM Star;

-- 清空星座信息表
#TRUNCATE Star; 
-- 删除用户属性表
#DROP TABLE Star;


-- 血型信息表
DROP TABLE IF EXISTS Blood;
-- 创建血型信息表
CREATE TABLE Blood(
	Id INT(4) PRIMARY KEY NOT NULL auto_increment,
	BloodType VARCHAR(32)
)ENGINE=INNODB auto_increment=1 DEFAULT CHARSET=utf8;

-- 查看血型信息表结构
#DESC Blood;

-- 往血型信息表中插入记录
INSERT INTO Blood values(1, 'A型');
INSERT INTO Blood values(2, 'B型');
INSERT INTO Blood values(3, 'O型');
INSERT INTO Blood values(4, 'AB型');

-- 查看血型信息表
#SELECT * FROM Blood;

-- 清空血型信息表
#TRUNCATE Blood; 
-- 删除血型信息表
#DROP TABLE Blood;



/*
	---  查询  ---
 * 内联通式：select 查询字段 from tb1 inner join tb2 on 条件 (where 条件)
*/
-- 1. 查询出血型为“O型”的用户姓名、性别；（两表连接）
-- (Users, Blood)
-- **
SELECT 
	Users.NickName AS '昵称',
	Users.Sex AS '性别'
	#,Blood.BloodType AS '血型'
FROM Users,Blood 
WHERE Users.BloodTypeId=Blood.id AND BloodType LIKE 'O%';

-- 内联
/*SELECT 
	Users.NickName AS '昵称',
	Users.Sex AS '性别'
	#,Blood.BloodType AS '血型'   
FROM Users INNER JOIN Blood ON Users.BloodTypeId=Blood.Id 
WHERE BloodType LIKE 'O%';*/


-- 2. 使用连接查询(内联)，查询出血型为“A型”并且星座为“白羊座”的用户姓名、性别
-- (Users, Star, Blood)
-- 内联
SELECT
	Users.NickName AS '昵称',
	Users.Sex AS '性别'
	#,Star.StarName AS '星座'
	#,Blood.BloodType AS '血型'
FROM Users INNER JOIN Blood INNER JOIN Star 
ON Users.BloodTypeId=Blood.id AND Users.StarId=Star.id
WHERE BloodType LIKE 'A%' AND StarName='白羊座';

-- **
/*SELECT 
	Users.NickName AS '昵称',
	Users.Sex AS '性别'
	#,Star.StarName AS '星座'
	#,Blood.BloodType AS '血型'
FROM Users, Star, Blood
WHERE Users.BloodTypeId=Blood.id AND Users.StarId=Star.id AND BloodType LIKE 'A%' AND StarName='白羊座';*/


-- FROM Users, Star, Blood
-- WHERE 

-- 3. 用户“.NET”更新自己的名字为“天外飞仙”，请编写SQL语句进行更新
-- (Users)[Star, Blood]
UPDATE Users SET NickName='天外飞仙' WHERE NickName='.NET';
-- 内联
SELECT 
	NickName AS '昵称',
	Sex AS '性别',
	StarName AS '星座',
	BloodType AS '血型'
FROM Users INNER JOIN Star INNER JOIN Blood
ON Users.BloodTypeId=Blood.id AND Users.StarId=Star.id
WHERE NickName='天外飞仙';

-- **
/*SELECT 
	NickName AS '昵称',
	Sex AS '性别',
	StarName AS '星座',
	BloodType AS '血型'
FROM Users, Star, Blood
WHERE Users.BloodTypeId=Blood.id AND Users.StarId=Star.id AND NickName='天外飞仙';*/


