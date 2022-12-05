/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50548
Source Host           : localhost:3306
Source Database       : code

Target Server Type    : MYSQL
Target Server Version : 50548
File Encoding         : 65001

Date: 2020-12-17 13:09:08
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `code`
-- ----------------------------
DROP TABLE IF EXISTS `code`;
CREATE TABLE `code` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `code_value` varchar(20) COLLATE utf8_bin NOT NULL,
  `type_id` int(5) NOT NULL,
  `code_name` varchar(20) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of code
-- ----------------------------
INSERT INTO `code` VALUES ('1', '男', '1', '性别');
INSERT INTO `code` VALUES ('2', '女', '1', '性别');
INSERT INTO `code` VALUES ('3', '正式员工', '2', '用工形式');
INSERT INTO `code` VALUES ('4', '临时员工', '2', '用工形式');
INSERT INTO `code` VALUES ('5', '满族', '3', '民族');
INSERT INTO `code` VALUES ('6', '汉族', '3', '民族');
INSERT INTO `code` VALUES ('7', '壮族', '3', '民族');
INSERT INTO `code` VALUES ('8', '校园招聘', '4', '人员来源');
INSERT INTO `code` VALUES ('9', '社会招聘', '4', '人员来源');
INSERT INTO `code` VALUES ('10', '党员', '5', '政治面貌');
INSERT INTO `code` VALUES ('11', '预备党员', '5', '政治面貌');
INSERT INTO `code` VALUES ('12', '团员', '5', '政治面貌');
INSERT INTO `code` VALUES ('13', 'A型', '6', '血型');
INSERT INTO `code` VALUES ('14', 'B型', '6', '血型');
INSERT INTO `code` VALUES ('15', 'AB型', '6', '血型');
INSERT INTO `code` VALUES ('16', 'O型', '6', '血型');
INSERT INTO `code` VALUES ('17', '未婚', '7', '婚姻状况');
INSERT INTO `code` VALUES ('18', '已婚', '7', '婚姻状况');
INSERT INTO `code` VALUES ('19', '丧偶', '7', '婚姻状况');
INSERT INTO `code` VALUES ('20', '离婚', '7', '婚姻状况');
INSERT INTO `code` VALUES ('21', '高中及以下', '8', '最高学历');
INSERT INTO `code` VALUES ('22', '大专', '8', '最高学历');
INSERT INTO `code` VALUES ('23', '本科', '8', '最高学历');
INSERT INTO `code` VALUES ('24', '研究生', '8', '最高学历');
INSERT INTO `code` VALUES ('25', '无学位', '9', '最高学位');
INSERT INTO `code` VALUES ('26', '学士', '9', '最高学位');
INSERT INTO `code` VALUES ('27', '双学士', '9', '最高学位');
INSERT INTO `code` VALUES ('28', '硕士', '9', '最高学位');
INSERT INTO `code` VALUES ('29', '博士', '9', '最高学位');
INSERT INTO `code` VALUES ('30', '博士后', '9', '最高学位');
INSERT INTO `code` VALUES ('31', '转正', '10', '考核结果');
INSERT INTO `code` VALUES ('32', '延期', '10', '考核结果');
INSERT INTO `code` VALUES ('33', '试用期未通过', '10', '考核结果');
INSERT INTO `code` VALUES ('34', '主动离职', '11', '离职类型');
INSERT INTO `code` VALUES ('35', '辞退', '11', '离职类型');
INSERT INTO `code` VALUES ('36', '退休', '11', '离职类型');
INSERT INTO `code` VALUES ('37', '开除', '11', '离职类型');
INSERT INTO `code` VALUES ('38', '试用期未通过', '11', '离职类型');
INSERT INTO `code` VALUES ('39', '公司', '12', '部门类型');
INSERT INTO `code` VALUES ('40', '部门', '12', '部门类型');
INSERT INTO `code` VALUES ('45', '主动调动', '14', '调转类型');
INSERT INTO `code` VALUES ('46', '被动调动', '14', '调转类型');
INSERT INTO `code` VALUES ('47', '数据错误', '14', '调转类型');
INSERT INTO `code` VALUES ('48', '技术', '15', '岗位类型');
INSERT INTO `code` VALUES ('49', '管理', '15', '岗位类型');
INSERT INTO `code` VALUES ('50', '销售', '15', '岗位类型');
INSERT INTO `code` VALUES ('54', '升职', '17', '调转类型');
INSERT INTO `code` VALUES ('55', '降职', '17', '调转类型');
INSERT INTO `code` VALUES ('56', '数据错误', '17', '调转类型');

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
