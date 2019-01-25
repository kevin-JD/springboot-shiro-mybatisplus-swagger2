/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2019-01-25 17:20:52
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `USERNAME` varchar(50) DEFAULT NULL,
  `PASSWORD` varchar(50) DEFAULT NULL,
  `EMAIL` varchar(20) DEFAULT NULL,
  `CREATETIME` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'james', '1234567', '1234567@qq.com', '2019-01-25 16:00:00');
INSERT INTO `t_user` VALUES ('2', 'kobe', '1234567', '1234567@qq.com', '2019-01-25 16:00:01');
INSERT INTO `t_user` VALUES ('3', 'cp3', '1234567', '1234567@qq.com', '2019-01-25 16:00:02');
INSERT INTO `t_user` VALUES ('4', 'harden', '1234567', '1234567@qq.com', '2019-01-25 16:09:17');
