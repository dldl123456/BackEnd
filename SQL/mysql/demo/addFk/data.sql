/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50540
Source Host           : localhost:3303
Source Database       : market

Target Server Type    : MYSQL
Target Server Version : 50540
File Encoding         : 65001

Date: 2017-12-24 21:40:17
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for commodityinfo
-- ----------------------------
DROP TABLE IF EXISTS `commodityinfo`;
CREATE TABLE `commodityinfo` (
  `CID` int(4) NOT NULL AUTO_INCREMENT COMMENT '商品类别编号、主键、自增1',
  `CategoryID` int(4) NOT NULL COMMENT '商品类别编号、外键、引用commodity_category表的主键',
  `CName` varchar(32) NOT NULL COMMENT '商品名称',
  `Picture` varchar(16) DEFAULT NULL COMMENT '商品图片',
  `InputPrice` float NOT NULL COMMENT '商品购入价格',
  `OutPrice` float NOT NULL COMMENT '商品单价',
  `Amount` int(4) DEFAULT NULL COMMENT '商品库存量',
  PRIMARY KEY (`CID`),
  KEY `market_FK` (`CategoryID`),
  CONSTRAINT `market_FK` FOREIGN KEY (`CategoryID`) REFERENCES `commodity_category` (`CategoryID`),
  CONSTRAINT `commodityinfo_ibfk_1` FOREIGN KEY (`CategoryID`) REFERENCES `commodity_category` (`CategoryID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of commodityinfo
-- ----------------------------

-- ----------------------------
-- Table structure for commodity_category
-- ----------------------------
DROP TABLE IF EXISTS `commodity_category`;
CREATE TABLE `commodity_category` (
  `CategoryID` int(4) NOT NULL AUTO_INCREMENT COMMENT '商品类别编号、主键、自增1',
  `CategoryName` varchar(32) DEFAULT NULL COMMENT '商品类别名称',
  PRIMARY KEY (`CategoryID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of commodity_category
-- ----------------------------
