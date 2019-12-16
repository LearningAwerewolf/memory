/*
Navicat MySQL Data Transfer

Source Server         : s
Source Server Version : 50553
Source Host           : localhost:3306
Source Database       : rainmanage

Target Server Type    : MYSQL
Target Server Version : 50553
File Encoding         : 65001

Date: 2019-12-16 17:26:28
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `rainquality`
-- ----------------------------
DROP TABLE IF EXISTS `rainquality`;
CREATE TABLE `rainquality` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `districtName` varchar(22) NOT NULL COMMENT ' 区域名称',
  `monitorTime` date NOT NULL COMMENT ' 监测时间',
  `rain` int(10) NOT NULL COMMENT '主键',
  `monitoringStation` varchar(200) NOT NULL COMMENT '监测站',
  `monitoringAddress` varchar(200) NOT NULL COMMENT '站点地址',
  PRIMARY KEY (`id`),
  UNIQUE KEY `PK__EASYBUY___C63B5EE724927208` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of rainquality
-- ----------------------------
INSERT INTO `rainquality` VALUES ('1', '西城区', '2014-07-09', '2', '什么街站', '展览路的暴漏');
INSERT INTO `rainquality` VALUES ('12', 'QQQQ', '2013-12-13', '123', '123', '123');
INSERT INTO `rainquality` VALUES ('16', '李永辉', '2019-12-16', '12', '河南林业', '图书馆');
INSERT INTO `rainquality` VALUES ('17', '啊啊', '2019-12-16', '5', '啊啊', 'vv');
INSERT INTO `rainquality` VALUES ('18', '111', '2019-06-02', '11', '22', '33');
INSERT INTO `rainquality` VALUES ('19', 'qq', '2019-03-02', '2', '1', '1');
