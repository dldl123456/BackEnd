/*
Navicat MySQL Data Transfer

Source Server         : 本机
Source Server Version : 50553
Source Host           : localhost:3306
Source Database       : test2

Target Server Type    : MYSQL
Target Server Version : 50553
File Encoding         : 65001

Date: 2018-05-09 09:19:25
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `teaId` int(4) NOT NULL,
  `teaName` varchar(15) DEFAULT NULL,
  `teaSalary` int(16) DEFAULT NULL,
  `teaGender` char(3) DEFAULT NULL,
  `teaAge` int(4) DEFAULT NULL,
  PRIMARY KEY (`teaId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('101', 'Tom', '5000', '男', '28');
INSERT INTO `teacher` VALUES ('102', 'Larry', '5000', '男', '26');
INSERT INTO `teacher` VALUES ('104', 'Arabt', '5000', '男', '27');
INSERT INTO `teacher` VALUES ('108', 'Tom', '5000', '男', '28');
INSERT INTO `teacher` VALUES ('109', 'Tom', '5000', '男', '29');
INSERT INTO `teacher` VALUES ('111', '小明', '1000000', '女', '99');
