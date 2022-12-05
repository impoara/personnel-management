/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50548
Source Host           : localhost:3306
Source Database       : code

Target Server Type    : MYSQL
Target Server Version : 50548
File Encoding         : 65001

Date: 2020-12-17 13:09:22
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `dep_change`
-- ----------------------------
DROP TABLE IF EXISTS `dep_change`;
CREATE TABLE `dep_change` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `em_id` int(5) NOT NULL,
  `dept_before` int(5) DEFAULT NULL,
  `dept_after` int(5) DEFAULT NULL,
  `dept_chtype` int(5) NOT NULL,
  `dept_chreason` varchar(20) NOT NULL,
  `dept_chdate` date NOT NULL,
  `dept_extra` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `dept_before` (`dept_before`),
  KEY `dept_after` (`dept_after`),
  KEY `dep_change_ibfk_1` (`em_id`),
  CONSTRAINT `dep_change_ibfk_1` FOREIGN KEY (`em_id`) REFERENCES `employee` (`em_number`)
) ENGINE=InnoDB AUTO_INCREMENT=72 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dep_change
-- ----------------------------
INSERT INTO `dep_change` VALUES ('65', '1', '2009', '2000', '45', '54', '2020-12-17', '');
INSERT INTO `dep_change` VALUES ('66', '1', '2000', '2002', '45', '54', '2020-12-17', '');
INSERT INTO `dep_change` VALUES ('67', '10', '2011', '2002', '45', '54', '2020-12-01', '');
INSERT INTO `dep_change` VALUES ('68', '10', '2002', '2000', '45', '54', '2020-12-02', '回家');
INSERT INTO `dep_change` VALUES ('69', '1', '2002', '2004', '46', '54', '2020-12-17', '');
INSERT INTO `dep_change` VALUES ('70', '2', '2000', '2011', '45', '54', '2020-12-22', '');
INSERT INTO `dep_change` VALUES ('71', '25', '2000', '2018', '45', '54', '2020-12-17', '');
