/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50548
Source Host           : localhost:3306
Source Database       : code

Target Server Type    : MYSQL
Target Server Version : 50548
File Encoding         : 65001

Date: 2020-12-17 13:09:51
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `job_change`
-- ----------------------------
DROP TABLE IF EXISTS `job_change`;
CREATE TABLE `job_change` (
  `emp_number` int(5) NOT NULL,
  `emp_name` varchar(20) COLLATE utf8_bin NOT NULL,
  `job_chname` varchar(20) COLLATE utf8_bin NOT NULL,
  `job_chtype` int(5) DEFAULT NULL,
  `job_chreason` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `job_chdate` date NOT NULL,
  `job_chextra` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `job_oldname` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `id` int(5) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of job_change
-- ----------------------------
INSERT INTO `job_change` VALUES ('1', '黄明昊', '市场分析师', '45', '54', '2020-12-17', '', '软件设计师', '23');
INSERT INTO `job_change` VALUES ('2', '陈立农', '专家顾问', '46', '54', '2020-12-17', '', '软件设计师', '24');
INSERT INTO `job_change` VALUES ('5', '黄明昊', '行政经理', '47', '56', '2020-12-17', '', '卖保险', '25');
INSERT INTO `job_change` VALUES ('4', '戢凡', '相声部', '47', '56', '2020-12-17', '111', '翻译员', '26');
INSERT INTO `job_change` VALUES ('1', '黄明昊', '凤凤加油鸭', '45', '54', '2020-12-17', '', '市场分析师', '27');
INSERT INTO `job_change` VALUES ('25', '范升华', '市场分析师', '45', '54', '2020-01-29', '', '软件设计师', '28');
INSERT INTO `job_change` VALUES ('25', '范升华', '行政经理', '45', '54', '2020-12-02', '', '市场分析师', '29');
