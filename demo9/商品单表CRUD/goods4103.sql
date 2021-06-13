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

 Date: 03/06/2021 21:12:58
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for goods4103
-- ----------------------------
DROP TABLE IF EXISTS `goods4103`;
CREATE TABLE `goods4103`  (
  `goodsId` int(0) NOT NULL COMMENT '商品编号',
  `goodsName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '商品名',
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '分类/类别',
  `price` decimal(10, 2) NOT NULL COMMENT '单价',
  `num` int(0) NOT NULL COMMENT '数量',
  `produceFirm` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '生产厂商',
  PRIMARY KEY (`goodsId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goods4103
-- ----------------------------
INSERT INTO `goods4103` VALUES (1, '薯片', '零食', 6.00, 100, '乐事有限公司');
INSERT INTO `goods4103` VALUES (2, '可乐', '饮料', 3.00, 200, '可口可乐有限公司');
INSERT INTO `goods4103` VALUES (3, '圆珠笔', '文具', 2.00, 250, '广东圆珠笔有限公司');
INSERT INTO `goods4103` VALUES (4, '毛巾', '日用品', 10.00, 50, '广东毛巾有限公司');
INSERT INTO `goods4103` VALUES (5, 'testSSM', '日用品', 99.00, 1, 'idea');
INSERT INTO `goods4103` VALUES (6, 'Shiina', '药品', 828.00, 1, '椎名真白药业');
INSERT INTO `goods4103` VALUES (20184103, '廖凤琦', '零食', 99.00, 1, '广东');

SET FOREIGN_KEY_CHECKS = 1;
