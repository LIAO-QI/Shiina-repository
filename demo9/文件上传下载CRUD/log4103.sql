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

 Date: 04/06/2021 00:57:35
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for log4103
-- ----------------------------
DROP TABLE IF EXISTS `log4103`;
CREATE TABLE `log4103`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `user` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `method` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `ip_address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `operation_time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 29 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of log4103
-- ----------------------------
INSERT INTO `log4103` VALUES (1, 'Shiina', 'com.shiina.controller.FileController.upload()', '0:0:0:0:0:0:0:1', '2021-05-28 13:35:20', '上传文件');
INSERT INTO `log4103` VALUES (2, 'Shiina', 'com.shiina.controller.FileController.upload()', '0:0:0:0:0:0:0:1', '2021-05-28 13:46:23', '上传文件');
INSERT INTO `log4103` VALUES (3, 'Shiina', 'com.shiina.controller.FileController.upload()', '0:0:0:0:0:0:0:1', '2021-05-28 13:46:50', '上传文件');
INSERT INTO `log4103` VALUES (4, 'Shiina', 'com.shiina.controller.FileController.upload()', '0:0:0:0:0:0:0:1', '2021-05-28 13:48:03', '上传文件');
INSERT INTO `log4103` VALUES (5, 'Shiina', 'com.shiina.controller.FileController.upload()', '0:0:0:0:0:0:0:1', '2021-05-28 13:49:13', '上传文件');
INSERT INTO `log4103` VALUES (6, 'Shiina', 'com.shiina.controller.FileController.upload()', '0:0:0:0:0:0:0:1', '2021-05-28 13:49:46', '上传文件');
INSERT INTO `log4103` VALUES (7, 'Shiina', 'com.shiina.controller.FileController.download()', '0:0:0:0:0:0:0:1', '2021-05-28 13:49:53', '下载文件');
INSERT INTO `log4103` VALUES (8, 'Shiina', 'com.shiina.controller.FileController.download()', '0:0:0:0:0:0:0:1', '2021-05-28 13:53:56', '下载文件');
INSERT INTO `log4103` VALUES (9, 'Shiina', 'com.shiina.controller.FileController.upload()', '0:0:0:0:0:0:0:1', '2021-05-28 13:59:46', '上传文件');
INSERT INTO `log4103` VALUES (10, 'Shiina', 'com.shiina.controller.FileController.download()', '0:0:0:0:0:0:0:1', '2021-05-28 14:00:10', '下载文件');
INSERT INTO `log4103` VALUES (11, 'Shiina', 'com.shiina.controller.FileController.download()', '0:0:0:0:0:0:0:1', '2021-05-28 14:02:10', '下载文件');
INSERT INTO `log4103` VALUES (12, 'Shiina', 'com.shiina.controller.FileController.download()', '0:0:0:0:0:0:0:1', '2021-05-28 14:06:21', '下载文件');
INSERT INTO `log4103` VALUES (13, 'Shiina', 'com.shiina.controller.FileController.download()', '0:0:0:0:0:0:0:1', '2021-05-28 14:11:45', '下载文件');
INSERT INTO `log4103` VALUES (14, 'Shiina', 'com.shiina.controller.FileController.download()', '0:0:0:0:0:0:0:1', '2021-05-28 14:19:17', '下载文件');
INSERT INTO `log4103` VALUES (15, 'Shiina', 'com.shiina.controller.FileController.download()', '0:0:0:0:0:0:0:1', '2021-05-28 14:22:45', '下载文件');
INSERT INTO `log4103` VALUES (16, 'Shiina', 'com.shiina.controller.FileController.update()', '0:0:0:0:0:0:0:1', '2021-05-28 14:27:24', '更新文件');
INSERT INTO `log4103` VALUES (17, 'Shiina', 'com.shiina.controller.FileController.upload()', '0:0:0:0:0:0:0:1', '2021-05-28 14:28:31', '上传文件');
INSERT INTO `log4103` VALUES (18, 'Shiina', 'com.shiina.controller.FileController.delete()', '0:0:0:0:0:0:0:1', '2021-05-28 14:28:43', '删除文件');
INSERT INTO `log4103` VALUES (19, 'Shiina', 'com.shiina.controller.FileController.upload()', '0:0:0:0:0:0:0:1', '2021-05-28 16:08:52', '上传文件');
INSERT INTO `log4103` VALUES (20, 'Shiina', 'com.shiina.controller.FileController.update()', '0:0:0:0:0:0:0:1', '2021-05-28 16:09:03', '更新文件');
INSERT INTO `log4103` VALUES (21, 'Shiina', 'com.shiina.controller.FileController.delete()', '0:0:0:0:0:0:0:1', '2021-05-28 16:09:19', '删除文件');
INSERT INTO `log4103` VALUES (22, 'Shiina', 'com.shiina.controller.FileController.download()', '0:0:0:0:0:0:0:1', '2021-05-28 16:10:26', '下载文件');
INSERT INTO `log4103` VALUES (23, 'Shiina', 'com.shiina.controller.FileController.download()', '0:0:0:0:0:0:0:1', '2021-05-28 16:12:40', '下载文件');
INSERT INTO `log4103` VALUES (24, 'Shiina', 'com.shiina.controller.FileController.download()', '0:0:0:0:0:0:0:1', '2021-05-28 16:17:34', '下载文件');
INSERT INTO `log4103` VALUES (25, 'Shiina', 'com.shiina.controller.FileController.download()', '0:0:0:0:0:0:0:1', '2021-05-28 16:22:44', '下载文件');
INSERT INTO `log4103` VALUES (26, 'Shiina', 'com.shiina.controller.FileController.download()', '0:0:0:0:0:0:0:1', '2021-05-28 16:26:18', '下载文件');
INSERT INTO `log4103` VALUES (27, 'Shiina', 'com.shiina.controller.FileController.download()', '0:0:0:0:0:0:0:1', '2021-05-28 16:30:14', '下载文件');
INSERT INTO `log4103` VALUES (28, 'Shiina', 'com.shiina.controller.FileController.download()', '0:0:0:0:0:0:0:1', '2021-05-28 16:34:11', '下载文件');
INSERT INTO `log4103` VALUES (29, 'Shiina', 'com.shiina.controller.FileController.download()', '0:0:0:0:0:0:0:1', '2021-05-28 16:36:31', '下载文件');
INSERT INTO `log4103` VALUES (30, 'Mashiro', 'com.shiina.springboot_goods_management.controller.GoodsController.insert()', '0:0:0:0:0:0:0:1', '2021-06-03 21:08:15', '添加商品');
INSERT INTO `log4103` VALUES (31, 'Mashiro', 'com.shiina.springboot_goods_management.controller.GoodsController.update()', '0:0:0:0:0:0:0:1', '2021-06-03 21:09:44', '更新商品');
INSERT INTO `log4103` VALUES (32, 'Mashiro', 'com.shiina.springboot_goods_management.controller.GoodsController.delete()', '0:0:0:0:0:0:0:1', '2021-06-03 21:10:01', '删除商品');
INSERT INTO `log4103` VALUES (33, 'Mashiro', 'com.shiina.springboot_goods_management.controller.GoodsController.update()', '0:0:0:0:0:0:0:1', '2021-06-04 00:36:25', '更新商品');
INSERT INTO `log4103` VALUES (34, 'ShiinaLiu', 'com.shiina.springboot_file_management.controller.FileController.upload()', '0:0:0:0:0:0:0:1', '2021-06-04 00:50:25', '上传文件');
INSERT INTO `log4103` VALUES (35, 'ShiinaLiu', 'com.shiina.springboot_file_management.controller.FileController.update()', '0:0:0:0:0:0:0:1', '2021-06-04 00:53:56', '更新文件');
INSERT INTO `log4103` VALUES (36, 'ShiinaLiu', 'com.shiina.springboot_file_management.controller.FileController.download()', '0:0:0:0:0:0:0:1', '2021-06-04 00:54:19', '下载文件');
INSERT INTO `log4103` VALUES (37, 'ShiinaLiu', 'com.shiina.springboot_file_management.controller.FileController.upload()', '0:0:0:0:0:0:0:1', '2021-06-04 00:55:27', '上传文件');
INSERT INTO `log4103` VALUES (38, 'ShiinaLiu', 'com.shiina.springboot_file_management.controller.FileController.update()', '0:0:0:0:0:0:0:1', '2021-06-04 00:55:36', '更新文件');
INSERT INTO `log4103` VALUES (39, 'ShiinaLiu', 'com.shiina.springboot_file_management.controller.FileController.delete()', '0:0:0:0:0:0:0:1', '2021-06-04 00:55:54', '删除文件');

SET FOREIGN_KEY_CHECKS = 1;
