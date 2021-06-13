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

 Date: 04/06/2021 00:57:27
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for file4103
-- ----------------------------
DROP TABLE IF EXISTS `file4103`;
CREATE TABLE `file4103`  (
  `file_id` int(0) NOT NULL AUTO_INCREMENT,
  `file_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `file_uuidname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `file_uploader` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `file_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `file_size` double NOT NULL,
  `file_downloadtimes` int(0) NOT NULL,
  PRIMARY KEY (`file_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of file4103
-- ----------------------------
INSERT INTO `file4103` VALUES (1, 'Elsa Kopf - If.mp3', '93ab774a-7470-4330-82d6-de9386135cc7', 'Shiina', '音乐', 4469479, 1);
INSERT INTO `file4103` VALUES (2, '花たん - 心做し.mp3', 'dce75dda-94a4-43f8-ac16-04ccac0336af', '20184103廖凤琦', '音乐', 4298753, 9);
INSERT INTO `file4103` VALUES (3, '空实验报告电子版.doc', '88fc12dc-d3dd-489b-bde8-4b76267aeadb', 'Shiina', '文档', 54784, 2);
INSERT INTO `file4103` VALUES (4, '盲盒.mp4', '79903572-3aac-498b-bafb-ef504e4b459c', '20184103廖凤琦', '视频', 5405967, 2);
INSERT INTO `file4103` VALUES (5, 'b2.jpg', '37f0068a-470c-4905-b135-6a48992849d1', 'Mashiro', '图片', 173276, 1);
INSERT INTO `file4103` VALUES (6, 'tx.jpg', '4f13a3b7-d29a-4411-9faf-7c561645f770', '20184103廖凤琦', '图片', 120763, 1);
INSERT INTO `file4103` VALUES (7, 'Lainey Lou - Oceanside.mp3', '56f0e5f0-66a1-46a4-a193-f26d38009c9c', 'Mashiro', '音乐', 4032998, 1);
INSERT INTO `file4103` VALUES (10, '实验六 指导.docx', 'b13ff8b2-c451-4b2c-8483-3efcaecb2994', 'Shiina', '文档', 24108, 10);

SET FOREIGN_KEY_CHECKS = 1;
