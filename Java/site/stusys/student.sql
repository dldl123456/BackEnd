/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50553
Source Host           : localhost:3306
Source Database       : student

Target Server Type    : MYSQL
Target Server Version : 50553
File Encoding         : 65001

Date: 2017-10-09 14:56:38
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for score
-- ----------------------------
DROP TABLE IF EXISTS `score`;
CREATE TABLE `score` (
  `id` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `math` varchar(255) DEFAULT NULL,
  `chinese` varchar(255) DEFAULT NULL,
  `english` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of score
-- ----------------------------
INSERT INTO `score` VALUES ('1', '三', '99', '66', '33');
INSERT INTO `score` VALUES ('2', '马', '99', '66', '33');
INSERT INTO `score` VALUES ('3', '王', '44', '77', '22');
INSERT INTO `score` VALUES ('4', 'sd', '99', '66', '33');
INSERT INTO `score` VALUES ('5', 'gtr', '44', '77', '55');
