/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50548
Source Host           : localhost:3306
Source Database       : code

Target Server Type    : MYSQL
Target Server Version : 50548
File Encoding         : 65001

Date: 2020-12-17 13:09:28
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `dept`
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `dept_number` int(5) NOT NULL,
  `dept_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `dept_type` int(5) NOT NULL,
  `dept_tel` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `dept_fax` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `dept_super` int(5) DEFAULT NULL,
  `dept_desc` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `dept_setdate` date NOT NULL,
  `situation` int(2) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `dept_number` (`dept_number`) USING BTREE,
  KEY `dept_super` (`dept_super`) USING BTREE,
  CONSTRAINT `dept_ibfk_1` FOREIGN KEY (`dept_super`) REFERENCES `dept` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of dept
-- ----------------------------
INSERT INTO `dept` VALUES ('1', '2000', '经济开发部', '40', '13586579412', '024-8695274', '1', '', '2016-05-13', '0');
INSERT INTO `dept` VALUES ('2', '2001', '人力资源部', '39', '14785236985', '024-2589632', '5', '提供人力支持', '2015-05-08', '0');
INSERT INTO `dept` VALUES ('5', '2002', '经纪人', '39', '14589652145', '024-7854126', '2', '提供思想支持', '2005-05-08', '0');
INSERT INTO `dept` VALUES ('6', '2003', '科技部', '39', '15852347500', '154-1523645', '23', '提供科技支持', '2002-05-08', '1');
INSERT INTO `dept` VALUES ('12', '2004', '经理部', '39', '14541254125', '024-2589632', null, '提供经济支持', '2020-10-22', '0');
INSERT INTO `dept` VALUES ('13', '2005', '秘书部', '39', '15896521478', '024-2589632', null, '提供文案支持', '2020-10-10', '1');
INSERT INTO `dept` VALUES ('14', '2006', '律师部', '40', '15662705229', '024-2589632', '12', '提供言语支持', '2020-10-10', '1');
INSERT INTO `dept` VALUES ('16', '2007', '软件测试', '40', '15662705229', '045-8562354', '23', '提供bug支持', '2020-10-22', '1');
INSERT INTO `dept` VALUES ('17', '2008', '股东会', '39', '15868745369', '024-2589632', '12', '提供资金支持', '2020-10-23', '1');
INSERT INTO `dept` VALUES ('18', '2009', '人力资源部', '39', '15662705229', '021-1547854', null, '提供劳力支持', '2016-07-01', '1');
INSERT INTO `dept` VALUES ('21', '2010', '销售部', '39', '15662705229', '158-1547845', null, '提供销售支持', '2020-12-09', '1');
INSERT INTO `dept` VALUES ('23', '2011', '软件开发', '40', '15662705229', '051-1548784', '2', '提供开发支持', '2020-10-02', '0');
INSERT INTO `dept` VALUES ('32', '2012', '魔教', '39', '15662705229', '022-7458541', null, '提供魔术支持', '2020-12-10', '1');
INSERT INTO `dept` VALUES ('33', '2013', '邪教', '40', '15685234756', '022-8695221', null, '提供邪术支持', '2020-12-17', '1');
INSERT INTO `dept` VALUES ('34', '2018', '后勤部', '39', '13375418417', '031-1234567', null, '打扫卫生，保持环境', '2020-12-02', '0');
