-- 创建数据库
-- create database market;

-- 删除数据库
-- drop database market;

-- 新建表
USE market;
CREATE TABLE Commodity_Category(
    CategoryID INT(4) NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '商品类别编号、主键、自增1',
    CategoryName VARCHAR(32) COMMENT '商品类别名称'
)ENGINE=MYISAM DEFAULT CHARSET=utf8,ENGINE=INNODB;

-- 删除表
-- drop table Commodity_Category;