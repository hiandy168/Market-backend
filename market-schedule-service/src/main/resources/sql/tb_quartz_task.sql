/*
Navicat MySQL Data Transfer

Source Server         : 60.31.177.186
Source Server Version : 50541
Source Host           : 60.31.177.186:3309
Source Database       : market

Target Server Type    : MYSQL
Target Server Version : 50541
File Encoding         : 65001

Date: 2016-07-20 20:33:29
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_quartz_task
-- ----------------------------
DROP TABLE IF EXISTS `tb_quartz_task`;
CREATE TABLE `tb_quartz_task` (
  `task_id` int(11) NOT NULL AUTO_INCREMENT,
  `task_name` varchar(255) DEFAULT NULL,
  `task_group` varchar(255) DEFAULT NULL,
  `task_des` varchar(255) DEFAULT NULL,
  `task_url` varchar(255) DEFAULT NULL,
  `task_express` varchar(255) DEFAULT NULL,
  `task_key` varchar(255) DEFAULT NULL,
  `task_status` tinyint(2) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `last_update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`task_id`)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;

-- ----------------------------
-- Records of tb_quartz_task
-- ----------------------------
