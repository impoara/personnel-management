/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50548
Source Host           : localhost:3306
Source Database       : code

Target Server Type    : MYSQL
Target Server Version : 50548
File Encoding         : 65001

Date: 2020-12-17 13:09:46
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `job`
-- ----------------------------
DROP TABLE IF EXISTS `job`;
CREATE TABLE `job` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `job_number` int(5) NOT NULL,
  `job_name` varchar(20) COLLATE utf8_bin NOT NULL,
  `job_type` int(5) NOT NULL,
  `job_man` int(5) DEFAULT NULL,
  `job_max` int(5) DEFAULT NULL,
  `situation` int(2) DEFAULT '1',
  PRIMARY KEY (`id`),
  UNIQUE KEY `job_number` (`job_number`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of job
-- ----------------------------
INSERT INTO `job` VALUES ('1', '40007', '软件设计师', '50', '1', '60', '1');
INSERT INTO `job` VALUES ('2', '30005', '软件工程师', '0', '0', '30', '1');
INSERT INTO `job` VALUES ('3', '40010', '销售员', '50', '3', '54', '1');
INSERT INTO `job` VALUES ('4', '20021', '市场分析师', '48', '0', '40', '1');
INSERT INTO `job` VALUES ('7', '20019', '行政经理', '48', '4', '20', '1');
INSERT INTO `job` VALUES ('8', '20020', '翻译员', '48', '0', '42', '1');
INSERT INTO `job` VALUES ('9', '20006', '专家顾问', '48', '1', '56', '1');
INSERT INTO `job` VALUES ('10', '40009', '程序员', '50', '1', '64', '1');
INSERT INTO `job` VALUES ('11', '40011', '导游', '50', '0', '12', '1');
INSERT INTO `job` VALUES ('12', '30001', '前台', '49', '0', '35', '1');
INSERT INTO `job` VALUES ('13', '20010', '经纪人', '48', '0', '44', '1');
INSERT INTO `job` VALUES ('14', '20022', '打字员', '48', '0', '45', '1');
INSERT INTO `job` VALUES ('15', '20023', '程序员', '48', '7', '50', '1');
INSERT INTO `job` VALUES ('16', '20012', '前台美化', '48', '0', '44', '1');
INSERT INTO `job` VALUES ('17', '30002', '社会实际部', '49', '0', '20', '1');
INSERT INTO `job` VALUES ('18', '20017', '技术管理部', '48', '0', '51', '1');
