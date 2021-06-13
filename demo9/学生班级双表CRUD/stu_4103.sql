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

 Date: 05/06/2021 15:55:39
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for stu_4103
-- ----------------------------
DROP TABLE IF EXISTS `stu_4103`;
CREATE TABLE `stu_4103`  (
  `sid` int(0) NOT NULL,
  `sname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `cscore` float(10, 1) NOT NULL,
  `sqlscore` float(10, 1) NOT NULL,
  `javascore` float(10, 1) NOT NULL,
  `cid` int(0) NOT NULL,
  PRIMARY KEY (`sid`) USING BTREE,
  INDEX `stu_cla`(`cid`) USING BTREE,
  CONSTRAINT `stu_cla` FOREIGN KEY (`cid`) REFERENCES `cla_4103` (`cid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of stu_4103
-- ----------------------------
INSERT INTO `stu_4103` VALUES (10000001, '张一', 90.0, 80.0, 70.0, 1);
INSERT INTO `stu_4103` VALUES (10000002, '张二', 52.0, 62.0, 72.0, 1);
INSERT INTO `stu_4103` VALUES (10000003, '张三', 95.0, 85.0, 75.0, 1);
INSERT INTO `stu_4103` VALUES (10000004, '张四', 72.0, 82.0, 92.0, 1);
INSERT INTO `stu_4103` VALUES (10000005, 'test', 80.0, 60.0, 60.0, 1);
INSERT INTO `stu_4103` VALUES (20000001, '果一', 55.0, 65.0, 75.0, 2);
INSERT INTO `stu_4103` VALUES (20000002, '果二', 75.0, 85.0, 95.0, 2);
INSERT INTO `stu_4103` VALUES (20000003, '果三', 88.0, 98.0, 99.0, 2);
INSERT INTO `stu_4103` VALUES (20000004, '果四', 91.0, 92.0, 93.0, 2);
INSERT INTO `stu_4103` VALUES (20184103, 'Shiina', 95.0, 96.0, 100.0, 5);
INSERT INTO `stu_4103` VALUES (30000001, 'Mashiro', 90.0, 95.0, 95.0, 3);
INSERT INTO `stu_4103` VALUES (30000002, 'test', 90.0, 90.0, 95.0, 3);
INSERT INTO `stu_4103` VALUES (50000001, '廖一', 92.0, 93.0, 94.0, 5);
INSERT INTO `stu_4103` VALUES (50000002, '廖二', 93.0, 94.0, 95.0, 5);
INSERT INTO `stu_4103` VALUES (50000003, '廖三', 94.0, 95.0, 96.0, 5);

SET FOREIGN_KEY_CHECKS = 1;
