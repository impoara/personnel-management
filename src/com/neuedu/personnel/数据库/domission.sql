/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50548
Source Host           : localhost:3306
Source Database       : code

Target Server Type    : MYSQL
Target Server Version : 50548
File Encoding         : 65001

Date: 2020-12-17 13:09:34
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `domission`
-- ----------------------------
DROP TABLE IF EXISTS `domission`;
CREATE TABLE `domission` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `em_id` int(5) NOT NULL,
  `lz_type` int(20) DEFAULT NULL,
  `lz_date` date NOT NULL,
  `lz_go` varchar(20) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`),
  KEY `em_id` (`em_id`),
  CONSTRAINT `domission_ibfk_1` FOREIGN KEY (`em_id`) REFERENCES `employee` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of domission
-- ----------------------------
INSERT INTO `domission` VALUES ('38', '54', '34', '2020-12-17', '无');
INSERT INTO `domission` VALUES ('39', '38', '38', '2020-12-08', '无');
INSERT INTO `domission` VALUES ('40', '55', '34', '2020-12-17', '上大学');
INSERT INTO `domission` VALUES ('41', '37', '34', '2020-12-01', '开飞机');
INSERT INTO `domission` VALUES ('42', '28', '34', '2020-12-08', '当爱豆');
INSERT INTO `domission` VALUES ('43', '15', '34', '2020-12-23', '植发');
INSERT INTO `domission` VALUES ('44', '27', '36', '2020-12-02', '无');
INSERT INTO `domission` VALUES ('45', '22', '35', '2020-12-11', '无');
