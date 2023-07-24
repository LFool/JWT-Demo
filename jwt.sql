/*
 Navicat Premium Data Transfer

 Source Server         : mysql@5.7
 Source Server Type    : MySQL
 Source Server Version : 50742 (5.7.42)
 Source Host           : localhost:3307
 Source Schema         : jwt

 Target Server Type    : MySQL
 Target Server Version : 50742 (5.7.42)
 File Encoding         : 65001

 Date: 24/07/2023 19:47:01
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

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
