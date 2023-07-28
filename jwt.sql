/*
 Navicat Premium Data Transfer

 Source Server         : mysql@5.7
 Source Server Type    : MySQL
 Source Server Version : 50743 (5.7.43)
 Source Host           : localhost:3307
 Source Schema         : jwt

 Target Server Type    : MySQL
 Target Server Version : 50743 (5.7.43)
 File Encoding         : 65001

 Date: 29/07/2023 01:04:07
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `role` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
BEGIN;
INSERT INTO `role` (`id`, `user_id`, `role`) VALUES (1, 1, 1);
COMMIT;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(64) NOT NULL,
  `password` varchar(64) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` (`id`, `username`, `password`) VALUES (1, 'zs', '123456');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
