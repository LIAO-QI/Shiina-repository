/*
 Navicat Premium Data Transfer

 Source Server         : Shiina
 Source Server Type    : MySQL
 Source Server Version : 80019
 Source Host           : localhost:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 80019
 File Encoding         : 65001

 Date: 28/04/2020 14:15:24
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for books
-- ----------------------------
DROP TABLE IF EXISTS `books`;
CREATE TABLE `books`  (
  `bookid` int(0) NOT NULL AUTO_INCREMENT,
  `bookName` char(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `bookNumber` int(0) NOT NULL,
  `pubdate` datetime(0) NOT NULL,
  PRIMARY KEY (`bookid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of books
-- ----------------------------
INSERT INTO `books` VALUES (1, '大学语文', 190, '2020-03-11 00:00:00');
INSERT INTO `books` VALUES (2, '数学', 120, '2020-03-14 00:00:00');
INSERT INTO `books` VALUES (3, '高数', 150, '2020-03-14 00:00:00');
INSERT INTO `books` VALUES (4, '英语', 250, '2020-03-14 00:00:00');
INSERT INTO `books` VALUES (5, '大英', 200, '2020-03-13 00:00:00');
INSERT INTO `books` VALUES (6, 'Java', 111, '2020-03-14 00:00:00');
INSERT INTO `books` VALUES (7, 'Javaweb', 222, '2020-03-14 00:00:00');
INSERT INTO `books` VALUES (8, '离散数学', 100, '2020-03-14 00:00:00');
INSERT INTO `books` VALUES (9, '马克思', 230, '2020-03-14 00:00:00');
INSERT INTO `books` VALUES (10, '毛概', 260, '2020-03-15 00:00:00');
INSERT INTO `books` VALUES (11, 'JavaScript', 130, '2020-03-15 00:00:00');
INSERT INTO `books` VALUES (12, 'Jsp', 150, '2020-03-15 00:00:00');
INSERT INTO `books` VALUES (13, '心理健康', 123, '2020-03-13 00:00:00');
INSERT INTO `books` VALUES (14, '我是小于10', 9, '2020-03-13 00:00:00');
INSERT INTO `books` VALUES (15, '格式化', 300, '2020-03-14 00:00:00');
INSERT INTO `books` VALUES (16, '格式化p\'lu\'s', 400, '2020-03-14 00:00:00');
INSERT INTO `books` VALUES (17, '我是新书', 5, '2020-04-14 00:00:00');

-- ----------------------------
-- Table structure for employees
-- ----------------------------
DROP TABLE IF EXISTS `employees`;
CREATE TABLE `employees`  (
  `em_id` int(0) NOT NULL,
  `em_name` char(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `em_sex` char(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `em_province` char(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `em_city` char(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `em_native` char(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`em_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of employees
-- ----------------------------
INSERT INTO `employees` VALUES (1, '李鑫', '男', '云南', '呈贡', '中国');
INSERT INTO `employees` VALUES (2, '夏天', '男', '广西', '南宁', '中国');
INSERT INTO `employees` VALUES (4, '张三', '男', '北京', '海淀', '中国');
INSERT INTO `employees` VALUES (5, 'shiina', '女', '广东', '惠州', '中国');
INSERT INTO `employees` VALUES (6, 'mashiro', '女', '广东', '惠州', '中国');
INSERT INTO `employees` VALUES (9, 'test', '男', '江苏', '苏州', '中国');
INSERT INTO `employees` VALUES (1030, 'gd', '男', '河南', '汝州', '中国');
INSERT INTO `employees` VALUES (2018, 'shiinaliu', '女', '广东', '惠州', '中国');
INSERT INTO `employees` VALUES (2345, '张三', '男', '广东', '惠州', '中国');
INSERT INTO `employees` VALUES (201307, '张扬', '男', '山东', '苏州', '中国');

-- ----------------------------
-- Table structure for foods
-- ----------------------------
DROP TABLE IF EXISTS `foods`;
CREATE TABLE `foods`  (
  `id` int(0) NOT NULL,
  `FoodName` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `FoodPrice` decimal(10, 2) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of foods
-- ----------------------------
INSERT INTO `foods` VALUES (1, '面包', 4.00);
INSERT INTO `foods` VALUES (2, '葡萄', 12.00);
INSERT INTO `foods` VALUES (3, '苹果', 3.00);
INSERT INTO `foods` VALUES (4, '香蕉', 1.00);
INSERT INTO `foods` VALUES (5, '白菜', 1.00);

-- ----------------------------
-- Table structure for register
-- ----------------------------
DROP TABLE IF EXISTS `register`;
CREATE TABLE `register`  (
  `username` char(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` char(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`username`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of register
-- ----------------------------
INSERT INTO `register` VALUES ('mashiro', '456');
INSERT INTO `register` VALUES ('shiina', '123');
INSERT INTO `register` VALUES ('test', 'test');
INSERT INTO `register` VALUES ('us', 'pw');
INSERT INTO `register` VALUES ('usaa', 'pw');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `sex` char(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `age` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`username`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('20184103', '20184103', 'Shiina', '女', 18);
INSERT INTO `users` VALUES ('a123', '123a', 'null', '男', 0);
INSERT INTO `users` VALUES ('aabbc', 'aabbc', 'null', '男', 0);
INSERT INTO `users` VALUES ('gd', 'gd', 'null', '男', 0);
INSERT INTO `users` VALUES ('mashiro', 'mashiro', 'shiro', '女', 23);
INSERT INTO `users` VALUES ('shiinaliu', '123456', 'shiina', '女', 20);
INSERT INTO `users` VALUES ('t1', 't1', 'testt1', '男', 16);
INSERT INTO `users` VALUES ('test', 'test', 'testtest', '女', 18);
INSERT INTO `users` VALUES ('tt', 'tt', 'null', '男', 0);
INSERT INTO `users` VALUES ('ttt', 'ttt', 'lisi', '男', 21);
INSERT INTO `users` VALUES ('zhangsan', 'zhangsan', 'null', '男', 0);

SET FOREIGN_KEY_CHECKS = 1;
