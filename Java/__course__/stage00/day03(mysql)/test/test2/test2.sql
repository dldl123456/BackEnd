-- 创建数据库
-- create database market;

-- 删除数据库
-- drop database market;

-- 新建表
USE market;
CREATE TABLE CommodityInfo(
    CID INT(4) NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '商品类别编号、主键、自增1',
    CategoryID INT(4) NOT NULL COMMENT '商品类别编号、外键、引用commodity_category表的主键',
    FOREIGN KEY (CategoryID) REFERENCES commodity_category (CategoryID),
    CName VARCHAR(32) NOT NULL COMMENT '商品名称',
    Picture VARCHAR(16) COMMENT '商品图片',
    InputPrice FLOAT(8) NOT NULL COMMENT '商品购入价格',
    OutPrice FLOAT(8) NOT NULL COMMENT '商品单价',
    Amount INT(4) COMMENT '商品库存量'
)ENGINE=MYISAM DEFAULT CHARSET=utf8,ENGINE=INNODB;

-- 删除表
-- drop table Commodity_Category;