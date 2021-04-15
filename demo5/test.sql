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

 Date: 15/04/2021 18:22:10
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
INSERT INTO `employees` VALUES (9, 'test', '女', '江苏', '苏州', '中国');
INSERT INTO `employees` VALUES (1030, 'gd', '男', '河南', '汝州', '中国');
INSERT INTO `employees` VALUES (2018, 'shiinaliu', '女', '广东', '惠州', '中国');
INSERT INTO `employees` VALUES (2345, '张三', '男', '广东', '惠州', '中国');
INSERT INTO `employees` VALUES (201307, '张扬', '男', '江苏', '苏州', '中国');

-- ----------------------------
-- Table structure for film
-- ----------------------------
DROP TABLE IF EXISTS `film`;
CREATE TABLE `film`  (
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `leng` int(0) NOT NULL,
  PRIMARY KEY (`title`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of film
-- ----------------------------
INSERT INTO `film` VALUES ('test', 18);
INSERT INTO `film` VALUES ('test20201117', 300);
INSERT INTO `film` VALUES ('喜羊羊大战灰太狼', 200);

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
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods`  (
  `id` int(0) NOT NULL,
  `goodsName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `goodsPrice` decimal(10, 2) NOT NULL,
  `goodsImage` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES (1, '绿格子上衣', 104.30, '<img src=\"./static/img/1.jpg\" alt=\"绿格子上衣\" width=\"100px\" />');
INSERT INTO `goods` VALUES (2, '短牛仔裤', 134.00, '<img src=\"./static/img/2.jpg\" alt=\"短牛仔裤\" width=\"100px\" />');
INSERT INTO `goods` VALUES (3, '绿格子连衣裙', 260.00, '<img src=\"./static/img/3.jpg\" alt=\"绿格子连衣裙\" width=\"100px\" />');
INSERT INTO `goods` VALUES (4, '小鸟耳环', 10.00, '<img src=\"./static/img/4.jpg\" alt=\"小鸟耳环\" width=\"100px\" />');
INSERT INTO `goods` VALUES (5, '哆啦A梦项链', 80.00, '<img src=\"./static/img/5.jpg\" alt=\"哆啦A梦项链\" width=\"100px\" />');
INSERT INTO `goods` VALUES (6, '完美日记口红', 59.90, '<img src=\"./static/img/6.jpg\" alt=\"完美日记口红\" width=\"100px\" />');
INSERT INTO `goods` VALUES (7, '匡威背包', 209.00, '<img src=\"./static/img/7.jpg\" alt=\"匡威背包\" width=\"100px\" />');
INSERT INTO `goods` VALUES (8, '良品铺子零食大礼包', 138.00, '<img src=\"./static/img/8.jpg\" alt=\"良品铺子零食大礼包\" width=\"100px\" />');

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message`  (
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `message` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`username`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO `message` VALUES ('a123', '我是a123');
INSERT INTO `message` VALUES ('aabbc', '你是*，骂你了*');
INSERT INTO `message` VALUES ('gd', '我的gd');
INSERT INTO `message` VALUES ('lisi11', '*，你好。*。嘿嘿');
INSERT INTO `message` VALUES ('mashiro', '我是mashiro');
INSERT INTO `message` VALUES ('shiinaliu', '敏感词汇测试：*👈用*代替了');
INSERT INTO `message` VALUES ('shiinaliu77', '我是shiinaliu77');
INSERT INTO `message` VALUES ('test', 'test0828');
INSERT INTO `message` VALUES ('testagain', 'test again 屏蔽->*');
INSERT INTO `message` VALUES ('user2021', 'c，*，o，*');
INSERT INTO `message` VALUES ('zhangsan', '*，👈敏感词汇将会被屏蔽');

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders`  (
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `time` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `id` int(0) NOT NULL,
  `goodsName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `goodsPrice` decimal(10, 2) NOT NULL,
  `goodsImage` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`username`, `time`, `id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('shiina', '2020-05-25 23:21:04', 6, '完美日记口红', 59.90, '<img src=\"./static/img/6.jpg\" alt=\"完美日记口红\" width=\"100px\" />');
INSERT INTO `orders` VALUES ('shiina', '2020-06-02 23:21:30', 1, '绿格子上衣', 104.30, '<img src=\"./static/img/1.jpg\" alt=\"绿格子上衣\" width=\"100px\" />');
INSERT INTO `orders` VALUES ('shiina', '2020-06-02 23:21:30', 2, '短牛仔裤', 134.00, '<img src=\"./static/img/2.jpg\" alt=\"短牛仔裤\" width=\"100px\" />');
INSERT INTO `orders` VALUES ('shiina', '2020-06-02 23:35:43', 7, '匡威背包', 209.00, '<img src=\"./static/img/7.jpg\" alt=\"匡威背包\" width=\"100px\" />');
INSERT INTO `orders` VALUES ('shiina', '2020-06-02 23:35:43', 8, '良品铺子零食大礼包', 138.00, '<img src=\"./static/img/8.jpg\" alt=\"良品铺子零食大礼包\" width=\"100px\" />');
INSERT INTO `orders` VALUES ('shiina', '2020-06-03 14:04:42', 1, '绿格子上衣', 104.30, '<img src=\"./static/img/1.jpg\" alt=\"绿格子上衣\" width=\"100px\" />');
INSERT INTO `orders` VALUES ('shiina', '2020-06-03 14:04:42', 2, '短牛仔裤', 134.00, '<img src=\"./static/img/2.jpg\" alt=\"短牛仔裤\" width=\"100px\" />');
INSERT INTO `orders` VALUES ('shiinaliu', '2020-06-03 14:09:04', 4, '小鸟耳环', 10.00, '<img src=\"./static/img/4.jpg\" alt=\"小鸟耳环\" width=\"100px\" />');
INSERT INTO `orders` VALUES ('shiinaliu', '2020-06-03 14:09:04', 5, '哆啦A梦项链', 80.00, '<img src=\"./static/img/5.jpg\" alt=\"哆啦A梦项链\" width=\"100px\" />');
INSERT INTO `orders` VALUES ('shiinaliu', '2020-06-03 14:09:04', 6, '完美日记口红', 59.90, '<img src=\"./static/img/6.jpg\" alt=\"完美日记口红\" width=\"100px\" />');
INSERT INTO `orders` VALUES ('test', '2020-06-03 09:12:13', 1, '绿格子上衣', 104.30, '<img src=\"./static/img/1.jpg\" alt=\"绿格子上衣\" width=\"100px\" />');
INSERT INTO `orders` VALUES ('test', '2020-06-03 09:12:13', 2, '短牛仔裤', 134.00, '<img src=\"./static/img/2.jpg\" alt=\"短牛仔裤\" width=\"100px\" />');
INSERT INTO `orders` VALUES ('test', '2020-06-03 09:12:41', 2, '短牛仔裤', 134.00, '<img src=\"./static/img/2.jpg\" alt=\"短牛仔裤\" width=\"100px\" />');
INSERT INTO `orders` VALUES ('test', '2020-06-03 09:12:41', 3, '绿格子连衣裙', 260.00, '<img src=\"./static/img/3.jpg\" alt=\"绿格子连衣裙\" width=\"100px\" />');
INSERT INTO `orders` VALUES ('testagain', '2020-06-03 14:03:33', 4, '小鸟耳环', 10.00, '<img src=\"./static/img/4.jpg\" alt=\"小鸟耳环\" width=\"100px\" />');
INSERT INTO `orders` VALUES ('testagain', '2020-06-03 14:03:33', 5, '哆啦A梦项链', 80.00, '<img src=\"./static/img/5.jpg\" alt=\"哆啦A梦项链\" width=\"100px\" />');
INSERT INTO `orders` VALUES ('user2021', '2021-04-15 18:15:01', 3, '绿格子连衣裙', 260.00, '<img src=\"./static/img/3.jpg\" alt=\"绿格子连衣裙\" width=\"100px\" />');

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
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(0) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `sex` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `age` int(0) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'qq', '女', 23);
INSERT INTO `user` VALUES (2, 'aa', '男', 25);
INSERT INTO `user` VALUES (3, 'Shiina', '女', 20);
INSERT INTO `user` VALUES (2018, 'mashiro', '女', 18);
INSERT INTO `user` VALUES (4103, 'shiina', '女', 20);

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
INSERT INTO `users` VALUES ('a123', 'a123', 'aaaa123', '女', 18);
INSERT INTO `users` VALUES ('aabbc', 'aabbc', 'aabbc--', '男', 23);
INSERT INTO `users` VALUES ('gd', 'gd', '果冻', '男', 25);
INSERT INTO `users` VALUES ('imtest', 'imtest11', 'shiina', '女', 18);
INSERT INTO `users` VALUES ('jizhu', 'jizhuzz', 'shiina', '女', 18);
INSERT INTO `users` VALUES ('lisi', 'lisi', 'lisisi', '男', 22);
INSERT INTO `users` VALUES ('lisi11', 'lisi22', 'lisi', '女', 20);
INSERT INTO `users` VALUES ('mashiro', 'mashiro', 'shiro', '女', 23);
INSERT INTO `users` VALUES ('shiina', 'shiina', 'shiina', '女', 18);
INSERT INTO `users` VALUES ('shiinaliu', 'shiinaliu', 'shiina', '女', 18);
INSERT INTO `users` VALUES ('shiinaliu77', 'shiinaliu77', 'shiina', '女', 18);
INSERT INTO `users` VALUES ('t1', 't1', 'testt1', '男', 16);
INSERT INTO `users` VALUES ('test', 'test', '椎名', '女', 18);
INSERT INTO `users` VALUES ('test0603', 'test0603', 'null', '男', 0);
INSERT INTO `users` VALUES ('testagain', 'testagain', 'testagain', '男', 18);
INSERT INTO `users` VALUES ('tt', 'tt', 'tttest', '男', 18);
INSERT INTO `users` VALUES ('ttt', 'ttt', 'lisi', '男', 21);
INSERT INTO `users` VALUES ('user2021', 'user2021', 'mashiro2021', '女', 20);
INSERT INTO `users` VALUES ('zhangsan', 'zhangsan11', 'zhangsan', '女', 20);

SET FOREIGN_KEY_CHECKS = 1;
