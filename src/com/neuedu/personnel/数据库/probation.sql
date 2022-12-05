/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50548
Source Host           : localhost:3306
Source Database       : code

Target Server Type    : MYSQL
Target Server Version : 50548
File Encoding         : 65001

Date: 2020-12-17 13:09:56
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `probation`
-- ----------------------------
DROP TABLE IF EXISTS `probation`;
CREATE TABLE `probation` (
  `id` int(5) NOT NULL DEFAULT '0',
  `em_id` int(5) DEFAULT NULL,
  `prob_start` date NOT NULL,
  `prob_end` date NOT NULL,
  `prob_reviews` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `prob_results` int(5) DEFAULT NULL,
  `prob_data` date DEFAULT NULL,
  `prob_ notes` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `em_id` (`em_id`),
  CONSTRAINT `probation_ibfk_1` FOREIGN KEY (`em_id`) REFERENCES `employee` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of probation
-- ----------------------------
