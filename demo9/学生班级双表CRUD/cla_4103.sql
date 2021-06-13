/*
 Navicat Premium Data Transfer

 Source Server         : Shiina
 Source Server Type    : MySQL
 Source Server Version : 80019
 Source Host           : localhost:3306
 Source Schema         : db_20184103

 Target Server Type    : MySQL
 Target Server Version : 80019
 File Encoding         : 65001

 Date: 05/06/2021 15:55:48
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for cla_4103
-- ----------------------------
DROP TABLE IF EXISTS `cla_4103`;
CREATE TABLE `cla_4103`  (
  `cid` int(0) NOT NULL,
  `cname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`cid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cla_4103
-- ----------------------------
INSERT INTO `cla_4103` VALUES (1, '一班');
INSERT INTO `cla_4103` VALUES (2, '二班');
INSERT INTO `cla_4103` VALUES (3, '三班');
INSERT INTO `cla_4103` VALUES (4, '四班');
INSERT INTO `cla_4103` VALUES (5, '五班');

SET FOREIGN_KEY_CHECKS = 1;
