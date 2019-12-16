/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50536
Source Host           : localhost:3306
Source Database       : book

Target Server Type    : MYSQL
Target Server Version : 50536
File Encoding         : 65001

Date: 2019-12-16 20:01:18
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for bookmanage
-- ----------------------------
DROP TABLE IF EXISTS `bookmanage`;
CREATE TABLE `bookmanage` (
  `b_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增',
  `b_name` varchar(40) DEFAULT NULL,
  `b_author` varchar(40) DEFAULT NULL,
  `b_time` date DEFAULT NULL,
  `b_type` varchar(40) DEFAULT NULL COMMENT '计算机/软件，小说/文摘， 杂项',
  PRIMARY KEY (`b_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bookmanage
-- ----------------------------
INSERT INTO `bookmanage` VALUES ('1', '金庸全集', '金庸', '2013-02-21', '小说/文摘');
INSERT INTO `bookmanage` VALUES ('2', 'java自学通', '成峰', '2014-02-20', '计算机软件');
INSERT INTO `bookmanage` VALUES ('3', '盗墓笔记', '南派三叔', '2019-12-15', '小说 /文摘');
INSERT INTO `bookmanage` VALUES ('4', 'java高级', '清华IT', '2019-12-03', '计算机');
