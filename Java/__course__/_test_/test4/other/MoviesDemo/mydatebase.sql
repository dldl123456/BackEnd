/*
Navicat MySQL Data Transfer

Source Server         : dada
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : mydatebase

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2018-01-23 17:55:45
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `admins`
-- ----------------------------
DROP TABLE IF EXISTS `admins`;
CREATE TABLE `admins` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `psw` varchar(15) NOT NULL,
  `sex` enum('男','女') DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `adress` varchar(50) DEFAULT NULL,
  `tel` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admins
-- ----------------------------
INSERT INTO `admins` VALUES ('1', 'admin', '123', '男', '22', '湖南', '123');
INSERT INTO `admins` VALUES ('2', 'dada', '123', '男', '24', '湖南邵阳', '15211993940');

-- ----------------------------
-- Table structure for `city`
-- ----------------------------
DROP TABLE IF EXISTS `city`;
CREATE TABLE `city` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `province_id` int(11) DEFAULT NULL,
  `province_name` varchar(50) DEFAULT NULL,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=84 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of city
-- ----------------------------
INSERT INTO `city` VALUES ('1', '3', '河北省', '石家庄市');
INSERT INTO `city` VALUES ('2', '3', '河北省', '唐山市');
INSERT INTO `city` VALUES ('3', '3', '河北省', '秦皇岛市');
INSERT INTO `city` VALUES ('4', '3', '河北省', '邯郸市');
INSERT INTO `city` VALUES ('5', '3', '河北省', '邢台市');
INSERT INTO `city` VALUES ('6', '3', '河北省', '保定市');
INSERT INTO `city` VALUES ('7', '3', '河北省', '张家口市');
INSERT INTO `city` VALUES ('8', '3', '河北省', '承德市');
INSERT INTO `city` VALUES ('9', '3', '河北省', '沧州市');
INSERT INTO `city` VALUES ('10', '3', '河北省', '廊坊市');
INSERT INTO `city` VALUES ('11', '3', '河北省', '衡水市');
INSERT INTO `city` VALUES ('12', '3', '河北省', '辛集市');
INSERT INTO `city` VALUES ('13', '3', '河北省', '藁城市');
INSERT INTO `city` VALUES ('14', '3', '河北省', '晋州市');
INSERT INTO `city` VALUES ('15', '3', '河北省', '新乐市');
INSERT INTO `city` VALUES ('16', '3', '河北省', '鹿泉市');
INSERT INTO `city` VALUES ('17', '3', '河北省', '遵化市');
INSERT INTO `city` VALUES ('18', '3', '河北省', '丰南市');
INSERT INTO `city` VALUES ('19', '3', '河北省', '迁安市');
INSERT INTO `city` VALUES ('20', '3', '河北省', '武安市');
INSERT INTO `city` VALUES ('21', '3', '河北省', '南宫市');
INSERT INTO `city` VALUES ('22', '3', '河北省', '沙河市');
INSERT INTO `city` VALUES ('23', '3', '河北省', '涿州市');
INSERT INTO `city` VALUES ('24', '3', '河北省', '定州市');
INSERT INTO `city` VALUES ('25', '3', '河北省', '安国市');
INSERT INTO `city` VALUES ('26', '3', '河北省', '高碑店市');
INSERT INTO `city` VALUES ('27', '3', '河北省', '泊头市');
INSERT INTO `city` VALUES ('28', '3', '河北省', '任丘市');
INSERT INTO `city` VALUES ('29', '3', '河北省', '黄骅市');
INSERT INTO `city` VALUES ('30', '3', '河北省', '河间市');
INSERT INTO `city` VALUES ('31', '3', '河北省', '霸州市');
INSERT INTO `city` VALUES ('32', '3', '河北省', '三河市');
INSERT INTO `city` VALUES ('33', '3', '河北省', '冀州市');
INSERT INTO `city` VALUES ('34', '3', '河北省', '深州市');
INSERT INTO `city` VALUES ('35', '4', '山西省', '太原市');
INSERT INTO `city` VALUES ('36', '4', '山西省', '大同市');
INSERT INTO `city` VALUES ('37', '4', '山西省', '阳泉市');
INSERT INTO `city` VALUES ('38', '4', '山西省', '长治市');
INSERT INTO `city` VALUES ('39', '4', '山西省', '晋城市');
INSERT INTO `city` VALUES ('40', '4', '山西省', '朔州市');
INSERT INTO `city` VALUES ('41', '4', '山西省', '古交市');
INSERT INTO `city` VALUES ('42', '4', '山西省', '潞城市');
INSERT INTO `city` VALUES ('43', '4', '山西省', '高平市');
INSERT INTO `city` VALUES ('44', '4', '山西省', '忻州市');
INSERT INTO `city` VALUES ('45', '4', '山西省', '原平市');
INSERT INTO `city` VALUES ('46', '4', '山西省', '孝义市');
INSERT INTO `city` VALUES ('47', '4', '山西省', '离石市');
INSERT INTO `city` VALUES ('48', '4', '山西省', '汾阳市');
INSERT INTO `city` VALUES ('49', '4', '山西省', '榆次市');
INSERT INTO `city` VALUES ('50', '4', '山西省', '介休市');
INSERT INTO `city` VALUES ('51', '4', '山西省', '临汾市');
INSERT INTO `city` VALUES ('52', '4', '山西省', '侯马市');
INSERT INTO `city` VALUES ('53', '4', '山西省', '河津市');
INSERT INTO `city` VALUES ('54', '4', '山西省', '霍州市');
INSERT INTO `city` VALUES ('55', '4', '山西省', '运城市');
INSERT INTO `city` VALUES ('56', '4', '山西省', '永济市');
INSERT INTO `city` VALUES ('57', '5', '内蒙', '呼和浩特');
INSERT INTO `city` VALUES ('58', '5', '内蒙', '包头市');
INSERT INTO `city` VALUES ('59', '5', '内蒙', '乌海市');
INSERT INTO `city` VALUES ('60', '5', '内蒙', '赤峰市');
INSERT INTO `city` VALUES ('61', '5', '内蒙', '通辽市');
INSERT INTO `city` VALUES ('62', '5', '内蒙', '霍林郭勒市');
INSERT INTO `city` VALUES ('63', '5', '内蒙', '海拉尔市');
INSERT INTO `city` VALUES ('64', '5', '内蒙', '满洲里市');
INSERT INTO `city` VALUES ('65', '5', '内蒙', '扎兰屯市');
INSERT INTO `city` VALUES ('66', '5', '内蒙', '牙克石市');
INSERT INTO `city` VALUES ('67', '5', '内蒙', '根河市');
INSERT INTO `city` VALUES ('68', '5', '内蒙', '额尔古纳市');
INSERT INTO `city` VALUES ('69', '5', '内蒙', '乌兰浩特市');
INSERT INTO `city` VALUES ('70', '5', '内蒙', '二连浩特市');
INSERT INTO `city` VALUES ('71', '5', '内蒙', '锡林浩特市');
INSERT INTO `city` VALUES ('72', '5', '内蒙', '集宁市');
INSERT INTO `city` VALUES ('73', '5', '内蒙', '丰镇市');
INSERT INTO `city` VALUES ('74', '5', '内蒙', '东胜市');
INSERT INTO `city` VALUES ('75', '5', '内蒙', '临河市');
INSERT INTO `city` VALUES ('76', '6', '辽宁省', '沈阳市');
INSERT INTO `city` VALUES ('77', '6', '辽宁省', '大连市');
INSERT INTO `city` VALUES ('78', '6', '辽宁省', '鞍山市');
INSERT INTO `city` VALUES ('79', '6', '辽宁省', '抚顺市');
INSERT INTO `city` VALUES ('80', '6', '辽宁省', '本溪市');
INSERT INTO `city` VALUES ('81', '6', '辽宁省', '丹东市');
INSERT INTO `city` VALUES ('82', '6', '辽宁省', '锦州市');
INSERT INTO `city` VALUES ('83', '6', '辽宁省', '营口市');

-- ----------------------------
-- Table structure for `movies`
-- ----------------------------
DROP TABLE IF EXISTS `movies`;
CREATE TABLE `movies` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL,
  `director` varchar(50) DEFAULT NULL,
  `stars` varchar(50) DEFAULT NULL,
  `type` varchar(50) DEFAULT NULL,
  `mins` int(11) DEFAULT NULL,
  `intro` text,
  `mark` double DEFAULT NULL,
  `status` enum('1','-1','0') DEFAULT '0',
  `opentime` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uniquename` (`name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of movies
-- ----------------------------
INSERT INTO `movies` VALUES ('1', '泰坦尼克号', '未知', '未知', '爱情片', '120', 'you jump,i jump!', '8.9', '1', '2018-01-12');
INSERT INTO `movies` VALUES ('2', '金刚', '未知', '未知', '动作片', '100', '猩猩', '7.6000000000000005', '1', '2018-01-13');
INSERT INTO `movies` VALUES ('3', '奇门遁甲', '袁和平', '大鹏', '动作片', '113', '在一个妖孽横行，天象大乱的时代，外星妖物侵袭而来。此时江湖上精通“奇门遁甲”之术的神秘组织“雾隐门”挺身而出，其首领老大（伍佰 饰）、弟子诸葛青云（大鹏 饰）、铁蜻蜓（倪妮 饰）和雾隐七子等众人各怀所长。另一方面，诸葛青云途中寻找新一代掌门小圆圈（周冬雨 饰）之时，新晋捕快刀宜长（李治廷 饰）为救铁蜻蜓亦被牵连在内。一时间，风云涌起，“天外来客”与“雾隐门”之间的正邪之战即将引发，一场新的奇幻危机正在来临……', '10', '0', '2018-01-10');
INSERT INTO `movies` VALUES ('4', '寻梦环游记', '昂克里奇', '安东尼', '喜剧', '105', '一个像成为音乐家的小男孩米格的奇妙之', '7.8', '1', '2018-01-14');
INSERT INTO `movies` VALUES ('5', '坚强', '大卫', '杰克', '传记', '116', '杰夫·伯曼同名记事回忆录改编', '9', '1', '2018-01-14');
INSERT INTO `movies` VALUES ('6', '肖声克的救赎', '弗兰克·德拉邦特 ', '蒂姆·罗宾斯 / 摩根·弗里曼 / 鲍勃·冈顿 ', '剧情 / 犯罪', '142', '20世纪40年代末，小有成就的青年银行家安迪（蒂姆·罗宾斯 Tim Robbins 饰）因涉嫌杀害妻子及她的情人而锒铛入狱。在这座名为肖申克的监狱内，希望似乎虚无缥缈，终身监禁的惩罚无疑注定了安迪接下来灰暗绝望的人生。未过多久，安迪尝试接近囚犯中颇有声望的瑞德（摩根·弗里曼 Morgan Freeman 饰），请求对方帮自己搞来小锤子。以此为契机，二人逐渐熟稔，安迪也仿佛在鱼龙混杂、罪恶横生、黑白混淆的牢狱中找到属于自己的求生之道。他利用自身的专业知识，帮助监狱管理层逃税、洗黑钱，同时凭借与瑞德的交往在犯人中间也渐渐受到礼遇。表面看来，他已如瑞德那样对那堵高墙从憎恨转变为处之泰然，但是对自由的渴望仍促使他朝着心中的希望和目标前进。而关于其罪行的真相，似乎更使这一切朝前推进了一步……', '10', '1', '1994-09-10');
INSERT INTO `movies` VALUES ('8', 'dad', 'dad', 'sadas', 'dsaads', '121', 'dsdasdsa', '10', '0', '2012-10-10');

-- ----------------------------
-- Table structure for `plans`
-- ----------------------------
DROP TABLE IF EXISTS `plans`;
CREATE TABLE `plans` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `movieId` int(11) DEFAULT NULL COMMENT '电影id',
  `hallId` int(11) DEFAULT NULL,
  `showtime` datetime DEFAULT NULL,
  `prices` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_plans_halls` (`hallId`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of plans
-- ----------------------------
INSERT INTO `plans` VALUES ('1', '2', '3', '2018-01-24 14:30:00', '40');
INSERT INTO `plans` VALUES ('3', '3', '1', '2018-01-25 14:30:00', '35');
INSERT INTO `plans` VALUES ('4', '5', '5', '2018-01-26 14:46:00', '40');
INSERT INTO `plans` VALUES ('5', '2', '2', '2018-01-31 15:44:30', '22');
INSERT INTO `plans` VALUES ('6', '6', '2', '2018-01-23 17:30:00', '40');
INSERT INTO `plans` VALUES ('7', '2', '5', '2012-10-10 09:20:00', '23');
INSERT INTO `plans` VALUES ('8', '2', '2', '2018-01-24 16:30:00', '43');
INSERT INTO `plans` VALUES ('9', '2', '5', '2018-01-24 15:00:00', '23');
INSERT INTO `plans` VALUES ('10', '2', '3', '2018-01-24 16:20:00', '22');

-- ----------------------------
-- Table structure for `province`
-- ----------------------------
DROP TABLE IF EXISTS `province`;
CREATE TABLE `province` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(60) NOT NULL,
  `country` varchar(50) NOT NULL DEFAULT '中国',
  PRIMARY KEY (`id`),
  UNIQUE KEY `cityname` (`name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of province
-- ----------------------------
INSERT INTO `province` VALUES ('1', '北京市', '中国');
INSERT INTO `province` VALUES ('2', '天津市', '中国');
INSERT INTO `province` VALUES ('3', '河北省', '中国');
INSERT INTO `province` VALUES ('4', '山西省', '中国');
INSERT INTO `province` VALUES ('5', '内蒙', '中国');
INSERT INTO `province` VALUES ('6', '辽宁省', '中国');
INSERT INTO `province` VALUES ('7', '吉林省', '中国');
INSERT INTO `province` VALUES ('8', '黑龙江省', '中国');
INSERT INTO `province` VALUES ('9', '上海市', '中国');
INSERT INTO `province` VALUES ('10', '江苏省', '中国');
INSERT INTO `province` VALUES ('11', '浙江省', '中国');
INSERT INTO `province` VALUES ('12', '安徽省', '中国');
INSERT INTO `province` VALUES ('13', '福建省', '中国');
INSERT INTO `province` VALUES ('14', '江西省', '中国');
INSERT INTO `province` VALUES ('15', '山东省', '中国');
INSERT INTO `province` VALUES ('16', '河南省', '中国');
INSERT INTO `province` VALUES ('17', '湖北省', '中国');
INSERT INTO `province` VALUES ('18', '湖南省', '中国');
INSERT INTO `province` VALUES ('19', '广东省', '中国');
INSERT INTO `province` VALUES ('20', '广西省', '中国');
INSERT INTO `province` VALUES ('21', '海南省', '中国');
INSERT INTO `province` VALUES ('22', '重庆市', '中国');
INSERT INTO `province` VALUES ('23', '四川省', '中国');
INSERT INTO `province` VALUES ('24', '贵州省', '中国');
INSERT INTO `province` VALUES ('25', '云南省', '中国');
INSERT INTO `province` VALUES ('26', '陕西省', '中国');
INSERT INTO `province` VALUES ('27', '甘肃省', '中国');
INSERT INTO `province` VALUES ('28', '青海省', '中国');
INSERT INTO `province` VALUES ('29', '宁夏', '中国');
INSERT INTO `province` VALUES ('30', '新疆', '中国');

-- ----------------------------
-- Table structure for `reviews`
-- ----------------------------
DROP TABLE IF EXISTS `reviews`;
CREATE TABLE `reviews` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `movieId` int(11) DEFAULT NULL COMMENT '电影id',
  `ticketId` int(11) DEFAULT NULL COMMENT '电影票ID',
  `mark` double DEFAULT NULL COMMENT '评分',
  `review` text COMMENT '评论',
  PRIMARY KEY (`id`),
  KEY `FK_reviews_tickets` (`ticketId`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of reviews
-- ----------------------------
INSERT INTO `reviews` VALUES ('2', '2', '2', '9', null);
INSERT INTO `reviews` VALUES ('3', '2', '3', '4', null);
INSERT INTO `reviews` VALUES ('7', '3', '5', '8.9', '我ihdhaihds');
INSERT INTO `reviews` VALUES ('8', '3', '18', '9', 'dasjdshjkdhka');

-- ----------------------------
-- Table structure for `seats`
-- ----------------------------
DROP TABLE IF EXISTS `seats`;
CREATE TABLE `seats` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `co` int(11) DEFAULT NULL,
  `ro` int(11) DEFAULT NULL,
  `hallId` int(11) DEFAULT NULL,
  `ticketId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of seats
-- ----------------------------
INSERT INTO `seats` VALUES ('1', '4', '4', '3', '1');
INSERT INTO `seats` VALUES ('2', '5', '4', '3', '2');
INSERT INTO `seats` VALUES ('3', '6', '4', '3', '3');
INSERT INTO `seats` VALUES ('4', '4', '5', '3', '4');
INSERT INTO `seats` VALUES ('5', '4', '6', '1', '5');
INSERT INTO `seats` VALUES ('6', '4', '7', '2', '6');
INSERT INTO `seats` VALUES ('7', '5', '8', '2', '7');
INSERT INTO `seats` VALUES ('8', '8', '8', '2', '8');
INSERT INTO `seats` VALUES ('9', '2', '2', '1', '9');
INSERT INTO `seats` VALUES ('10', '6', '6', '2', '10');
INSERT INTO `seats` VALUES ('11', '3', '3', '2', '11');
INSERT INTO `seats` VALUES ('12', '3', '2', '1', '12');

-- ----------------------------
-- Table structure for `showhalls`
-- ----------------------------
DROP TABLE IF EXISTS `showhalls`;
CREATE TABLE `showhalls` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `theaterId` int(11) DEFAULT NULL,
  `title` varchar(30) DEFAULT NULL,
  `cos` int(11) DEFAULT NULL,
  `ros` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_hall_theater` (`theaterId`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of showhalls
-- ----------------------------
INSERT INTO `showhalls` VALUES ('1', '1', '一号厅', '15', '12');
INSERT INTO `showhalls` VALUES ('2', '2', '一号影厅', '15', '20');
INSERT INTO `showhalls` VALUES ('3', '1', '二号厅', '20', '10');
INSERT INTO `showhalls` VALUES ('4', '1', '三号厅', '12', '12');
INSERT INTO `showhalls` VALUES ('5', '2', '二号影厅', '20', '20');
INSERT INTO `showhalls` VALUES ('6', '3', '1号影厅', '21', '15');
INSERT INTO `showhalls` VALUES ('7', '4', 'dsd', '8', '12');

-- ----------------------------
-- Table structure for `theaters`
-- ----------------------------
DROP TABLE IF EXISTS `theaters`;
CREATE TABLE `theaters` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL,
  `adress` varchar(50) DEFAULT NULL,
  `status` enum('2','1','0') NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of theaters
-- ----------------------------
INSERT INTO `theaters` VALUES ('1', '中河影院', '光谷', '1');
INSERT INTO `theaters` VALUES ('2', '九州影院', '双清区', '1');
INSERT INTO `theaters` VALUES ('3', '大地影院', '北塔区江北广电', '1');

-- ----------------------------
-- Table structure for `tickets`
-- ----------------------------
DROP TABLE IF EXISTS `tickets`;
CREATE TABLE `tickets` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT NULL COMMENT '用户id',
  `planId` int(11) DEFAULT NULL,
  `prices` double DEFAULT NULL,
  `buytime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_tickets_plans` (`planId`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tickets
-- ----------------------------
INSERT INTO `tickets` VALUES ('1', '1', '1', '40', '2017-12-17 20:00:00');
INSERT INTO `tickets` VALUES ('2', '2', '1', '40', '2017-12-16 20:07:05');
INSERT INTO `tickets` VALUES ('3', '3', '1', '40', '2017-12-16 19:07:37');
INSERT INTO `tickets` VALUES ('4', '4', '1', '40', '2017-12-13 20:07:59');
INSERT INTO `tickets` VALUES ('5', '1', '3', '35', '2017-12-17 20:10:23');
INSERT INTO `tickets` VALUES ('6', '2', '2', '45', '2017-12-16 20:11:19');
INSERT INTO `tickets` VALUES ('7', '4', '2', '45', '2017-12-16 20:21:44');
INSERT INTO `tickets` VALUES ('8', '5', '1', '40', '2017-12-18 20:13:19');
INSERT INTO `tickets` VALUES ('9', '5', '2', '45', '2017-12-15 20:22:59');
INSERT INTO `tickets` VALUES ('10', '3', '2', '45', '2017-12-15 20:12:06');
INSERT INTO `tickets` VALUES ('11', '9', '6', '36', '2018-01-23 10:55:50');
INSERT INTO `tickets` VALUES ('18', '1', '3', '17.5', '2018-01-23 12:06:04');

-- ----------------------------
-- Table structure for `users`
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `psw` varchar(15) NOT NULL,
  `adress` varchar(50) DEFAULT NULL,
  `sex` enum('男','女') DEFAULT '男',
  `age` int(11) DEFAULT NULL,
  `tel` varchar(11) DEFAULT NULL,
  `rank` enum('1','2','3','4','5','6') DEFAULT '1',
  `balance` double(14,2) DEFAULT '0.00',
  `cost` double(14,2) DEFAULT '0.00',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1', 'dada', 'qwe', '湖南', '男', '23', '1234567890', '6', '10242.50', '127.50');
INSERT INTO `users` VALUES ('2', 'sun', '111', '湖北', '男', '24', '212121231', '5', '8000.00', '200.00');
INSERT INTO `users` VALUES ('3', 'xt', '222', '上海', '女', '22', '111111111', '3', '232.00', '54.00');
INSERT INTO `users` VALUES ('4', 'xt99sun', 'sun', '啊啊', '女', '22', '11212121', '1', '220.00', '50.00');
INSERT INTO `users` VALUES ('5', 'ad', '222', '湖南', '男', '24', '1829023120', '1', '0.00', '0.00');
INSERT INTO `users` VALUES ('8', 'da1', '123', 'da', '男', '21', 'dadadada', '2', '100.00', '0.00');
INSERT INTO `users` VALUES ('9', '达达', '123123', '邵阳', '男', '24', '15071211479', '2', '264.00', '36.00');
INSERT INTO `users` VALUES ('10', 'dadd', '1234', 'dasd', '男', '22', '72187328973', '1', '0.00', '0.00');
