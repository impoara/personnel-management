/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50548
Source Host           : localhost:3306
Source Database       : code

Target Server Type    : MYSQL
Target Server Version : 50548
File Encoding         : 65001

Date: 2020-12-17 13:09:40
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `employee`
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `em_number` int(5) NOT NULL,
  `em_name` varchar(20) COLLATE utf8_bin NOT NULL,
  `em_birth` date NOT NULL,
  `sex` int(5) NOT NULL,
  `em_format` int(5) NOT NULL,
  `em_source` int(5) NOT NULL,
  `em_polity` int(5) NOT NULL,
  `em_folk` int(5) NOT NULL,
  `em_id` varchar(20) COLLATE utf8_bin NOT NULL,
  `em_indate` date NOT NULL,
  `em_worktime` date NOT NULL,
  `em_birthplace` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `em_phone` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `em_mail` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `em_blood` int(5) DEFAULT NULL,
  `em_wedlock` int(5) DEFAULT NULL,
  `em_stature` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `dep_number` int(20) DEFAULT NULL,
  `job_number` int(20) DEFAULT NULL,
  `em_seat` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `em_learn` int(5) DEFAULT NULL,
  `em_degree` int(5) DEFAULT NULL,
  `em_graduate` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `em_specialty` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `em_gradate` date DEFAULT NULL,
  `em_homeplace` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `situation` int(2) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `em_number` (`em_number`) USING BTREE,
  KEY `employee_ibfk_1` (`dep_number`),
  KEY `employee_ibfk_2` (`job_number`),
  CONSTRAINT `employee_ibfk_1` FOREIGN KEY (`dep_number`) REFERENCES `dept` (`dept_number`) ON UPDATE CASCADE,
  CONSTRAINT `employee_ibfk_2` FOREIGN KEY (`job_number`) REFERENCES `job` (`job_number`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=67 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES ('5', '1', '黄明昊', '2000-06-07', '1', '3', '8', '10', '6', '370105200010110033', '2020-02-04', '2018-11-03', '山东省', '15662705229', '152635@qq.com', '13', '17', '185', '2004', '20023', '山东省', '23', '27', '清华', '计算机', '2018-02-25', '山东省', '0');
INSERT INTO `employee` VALUES ('13', '2', '陈立农', '2001-03-05', '1', '3', '8', '11', '5', '370123200102173831', '2010-05-09', '2008-05-06', '山东省', '18353108342', '12733@qq.com', '13', '18', '180', '2011', '20006', '山东省', '3', '25', '北大青鸟', '北大', '2005-05-08', '北京省', '0');
INSERT INTO `employee` VALUES ('14', '3', '张玲', '2005-05-08', '2', '3', '8', '10', '5', '370105200010110033', '0012-08-06', '0012-05-03', '湖北省', '15867423259', '1237562@qq.com', '13', '17', '180', '2005', '40007', '山东省', '21', '25', '北京航空航天', '相声', '0010-08-09', '湖北省', '0');
INSERT INTO `employee` VALUES ('15', '4', '戢凡', '2005-05-08', '1', '3', '8', '10', '5', '370105200010110033', '0012-08-06', '0012-05-03', '山东省', '18695234756', '1237532@qq.com', '13', '17', '180', '2003', '30002', '山东省', '21', '26', '武汉', '音乐', '0010-08-09', '湖南省', '1');
INSERT INTO `employee` VALUES ('16', '5', '黄明昊', '2005-05-08', '2', '3', '8', '10', '5', '513221197102183838', '2020-08-07', '2020-05-08', '山东省', '12365478523', '12376692@qq.com', '13', '17', '123', '2000', '20019', '四川省', '3', '25', '哈弗', '舞蹈', '2006-08-09', '云南省', '0');
INSERT INTO `employee` VALUES ('17', '6', '范义恬', '2005-05-08', '1', '3', '8', '10', '5', '370105200010110033', '0012-08-06', '0012-05-03', '北京省', '18569472305', '12362@qq.com', '13', '17', '123', '2000', '40010', '湖北省', '3', '25', '重庆大学', '戏剧', '0010-08-09', '四川省', '0');
INSERT INTO `employee` VALUES ('18', '7', '杨珂', '2005-05-08', '2', '3', '8', '11', '5', '370105200010110033', '0012-08-06', '0012-05-03', '山东省', '17589621452', '17563223@qq.com', '13', '17', '123', '2001', '20023', '山东省', '21', '25', '闽南大学', '数学', '2005-05-08', '云南省', '0');
INSERT INTO `employee` VALUES ('19', '8', '黄明昊', '2005-05-08', '1', '3', '8', '10', '5', '370105200010110033', '0012-08-06', '0012-05-03', '浙江省', '18569742358', '1272653@qq.com', '13', '17', '123', '2006', '20023', '山东省', '3', '25', '东南大学', '舞蹈', '2005-05-08', '山东省', '0');
INSERT INTO `employee` VALUES ('20', '9', '张玲', '2005-05-08', '2', '3', '8', '10', '5', '370105200010110033', '0012-08-06', '0012-05-03', '湖北省', '18685824210', '128973@qq.com', '13', '17', '123', '2008', '40010', '湖南省', '3', '25', '北京电影学院', '音乐', '0010-08-09', '浙江省', '0');
INSERT INTO `employee` VALUES ('21', '10', '范丞丞', '2005-05-08', '1', '3', '8', '10', '5', '370105200010110022', '2015-08-06', '2011-05-03', '湖北省', '18353108345', '127895933@qq.com', '13', '17', '123', '2000', '40009', '云南省', '3', '25', '中央戏剧学院', '设计', '2006-08-09', '河南省', '0');
INSERT INTO `employee` VALUES ('22', '11', '张艺兴', '2005-05-08', '2', '3', '8', '10', '5', '370105200010110033', '2015-08-06', '2014-05-03', '黑龙江省', '15691257306', '18972@qq.com', '13', '17', '123', '2011', '40010', '黑龙江省', '3', '25', '北大', '表演', '2008-08-09', '贵州省', '1');
INSERT INTO `employee` VALUES ('23', '12', '蔡徐坤', '2005-05-08', '1', '3', '8', '10', '5', '370123200102173835', '2012-08-06', '2010-05-03', '云南省', '10324681285', '15682565@qq.com', '13', '17', '123', '2008', '20023', '湖北省', '3', '25', '蓝翔', '挖掘机', '2012-08-09', '四川省', '0');
INSERT INTO `employee` VALUES ('24', '13', '刘玉凤', '2005-05-08', '1', '3', '8', '10', '5', '130928198905281793', '2020-08-06', '2020-05-03', '台湾省', '18569421037', '123@qq.com', '13', '17', '123', '2000', '20023', '四川省', '3', '25', '上海大学', '戏剧', '2008-08-09', '北京省', '0');
INSERT INTO `employee` VALUES ('25', '14', '冯光宇', '2005-05-08', '1', '3', '8', '10', '5', '370105200010110033', '2016-08-06', '2015-05-03', '山东省', '18353108346', '123@qq.com', '13', '17', '123', '2009', '20019', '云南省', '3', '25', '湖北大学', '声乐', '2008-05-08', '越南省', '0');
INSERT INTO `employee` VALUES ('27', '15', '王源', '2005-05-08', '1', '3', '8', '10', '5', '370123200102173833', '2020-08-06', '2020-05-03', '山东省', '18353108344', '123@qq.com', '13', '19', '180', '2009', '40010', '山东省', '3', '25', '济南大学', '相声', '2012-05-08', '云南省', '1');
INSERT INTO `employee` VALUES ('28', '16', '王俊凯', '2000-05-08', '1', '3', '8', '10', '5', '370123200102173832', '2013-08-06', '2011-05-03', '山东省', '15856926358', '456789@qq.com', '13', '17', '175', '2008', '20023', '天津省', '3', '25', '四川大学', '民族舞', '2011-05-08', '四川省', '1');
INSERT INTO `employee` VALUES ('30', '17', '陈立农', '2005-05-08', '1', '3', '8', '10', '5', '370123200102173836', '2020-08-06', '2020-05-03', '吉林省', '17689206898', '456789@qq.com', '13', '17', '163', '2011', '20023', '山东省', '3', '25', '吉林大学', '街舞', '2012-05-08', '北京省', '0');
INSERT INTO `employee` VALUES ('36', '18', '王林凯', '2005-05-08', '1', '3', '8', '10', '5', '371482200012265623', '2020-08-06', '2020-05-03', '吉林省', '15856245864', '123@qq.com', '13', '17', '180', '2001', '20023', '山东省', '21', '27', '内蒙古大学', '拉丁舞', '2005-05-12', '湖北省', '0');
INSERT INTO `employee` VALUES ('37', '19', '舒克', '1986-10-01', '1', '3', '8', '10', '5', '370123200102173837', '2020-10-01', '2020-09-01', '山东', '15555555555', '123@123.com', '14', '17', '188', '2012', '20019', '山东', '21', '25', '加利顿大学', '计算机', '2000-10-01', '山东', '1');
INSERT INTO `employee` VALUES ('38', '20', '易烊千玺', '2000-12-26', '1', '3', '8', '10', '5', '371482200012265623', '2012-01-06', '2011-05-06', '四川省', '15685325652', '3501697526@qq.com', '13', '17', '180', '2000', '40007', '北京', '21', '25', '家里蹲大学', '北京电影学院', '2006-06-01', '四川省', '1');
INSERT INTO `employee` VALUES ('39', '21', '杨柯', '2020-12-16', '2', '3', '8', '11', '6', '371482200012265456', '2020-12-09', '2020-12-23', '山东省', '15555555555', '3501697526@qq.com', '15', '17', '163', '2007', '20023', '山东省', '23', '29', '齐鲁理工学院', '计算机', '2020-12-10', '德州市', '1');
INSERT INTO `employee` VALUES ('40', '22', '范义恬', '2020-12-16', '2', '4', '8', '11', '6', '371482200012265623', '2020-12-15', '2020-12-15', '山东省', '15685325652', '3501697526@qq.com', '14', '17', '180', '2006', '40010', '山东省', '23', '28', '齐鲁理工学院', '计算机', '2020-12-16', '德州市', '1');
INSERT INTO `employee` VALUES ('41', '23', '刘玉凤', '2020-12-22', '2', '4', '9', '11', '6', '371482200012265658', '2020-12-27', '2020-12-27', '山东省', '15685325652', '3501697526@qq.com', '13', '17', '165', '2000', '20023', '山东潍坊', '21', '28', '哈弗', '演员', '2020-12-25', null, '1');
INSERT INTO `employee` VALUES ('51', '24', '赵天雨', '2000-10-11', '1', '3', '8', '10', '6', '371482200012265623', '2020-12-26', '2020-12-22', null, null, '1594809541@qq.com', '16', '17', '180', '2004', '20019', null, '24', '30', null, null, null, null, '0');
INSERT INTO `employee` VALUES ('52', '25', '范升华', '2020-12-03', '1', '3', '8', '10', '5', '371482200012265623', '2020-12-18', '2020-12-14', null, null, null, '13', '17', null, '2018', '20019', null, '21', '25', null, null, null, null, '0');
INSERT INTO `employee` VALUES ('53', '26', '魏子超', '2020-12-01', '1', '3', '8', '10', '5', '371482200012265623', '2020-12-10', '2020-12-09', null, null, null, '13', '17', null, '2002', '40010', null, '21', '25', null, null, null, null, '0');
INSERT INTO `employee` VALUES ('54', '27', '王源', '2020-12-01', '1', '3', '8', '10', '5', '371482200012265623', '2020-12-10', '2020-12-10', null, null, null, '13', '17', null, '2011', '40007', null, '21', '25', null, null, null, null, '1');
INSERT INTO `employee` VALUES ('55', '28', '张玉凤', '2018-02-01', '1', '3', '8', '10', '5', '371482200012265623', '2020-12-02', '2019-01-09', null, null, null, '13', '17', null, '2000', '40007', null, '21', '25', null, null, null, null, '1');
INSERT INTO `employee` VALUES ('56', '29', '王琳凯', '2020-12-01', '1', '3', '8', '10', '5', '371482200012265623', '2020-12-10', '2020-12-10', null, null, null, '13', '17', null, null, '20023', null, '21', '25', null, null, null, null, '1');
