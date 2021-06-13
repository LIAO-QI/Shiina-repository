/*
 Navicat Premium Data Transfer

 Source Server         : Shiina
 Source Server Type    : MySQL
 Source Server Version : 80019
 Source Host           : localhost:3306
 Source Schema         : pharmacy_info

 Target Server Type    : MySQL
 Target Server Version : 80019
 File Encoding         : 65001

 Date: 13/04/2021 11:32:17
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for account_other
-- ----------------------------
DROP TABLE IF EXISTS `account_other`;
CREATE TABLE `account_other`  (
  `ao_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '其他支出编号',
  `ao_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '其他支出名称',
  `ao_money` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '其他支出金额',
  `ao_remarks` varchar(80) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '其他支出备注',
  `ao_date` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '其他支出日期',
  PRIMARY KEY (`ao_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of account_other
-- ----------------------------
INSERT INTO `account_other` VALUES (1, '电费', '125', '用电周期2021.3 - 2021.4', '20210401');
INSERT INTO `account_other` VALUES (2, '水费', '100', '用水周期2021.3 - 2021.4', '20210401');
INSERT INTO `account_other` VALUES (3, '雇佣临时售货员', '500', '5人，4小时', '20210412');

-- ----------------------------
-- Table structure for drug_category
-- ----------------------------
DROP TABLE IF EXISTS `drug_category`;
CREATE TABLE `drug_category`  (
  `c_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '药品类别编号',
  `c_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '药品类别名称',
  `c_remarks` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '药品类别备注',
  PRIMARY KEY (`c_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of drug_category
-- ----------------------------
INSERT INTO `drug_category` VALUES (1, '保健药', '强身健体，舒筋通络');
INSERT INTO `drug_category` VALUES (2, '消炎药', '抑制炎症反应，起到抗菌作用');
INSERT INTO `drug_category` VALUES (3, '清热解毒药剂', '清热解毒，利湿，并有升高白血球和降血脂作用');

-- ----------------------------
-- Table structure for drug_list
-- ----------------------------
DROP TABLE IF EXISTS `drug_list`;
CREATE TABLE `drug_list`  (
  `d_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '药品编号',
  `d_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '药品名称',
  `c_id` int(0) NOT NULL COMMENT '药品类别编号',
  `produce_date` datetime(0) NOT NULL COMMENT '生产日期',
  `expiration_date` datetime(0) NOT NULL COMMENT '有效日期',
  `sfda` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '国药准字',
  `produce_batch` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '生产批号',
  `d_remarks` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '药品备注',
  `inventory` int(0) NOT NULL COMMENT '库存数量',
  `rack_save` int(0) NOT NULL COMMENT '架存数量',
  `sv_id` int(0) NOT NULL COMMENT '药品等级号',
  `purchase_price` double(30, 0) NULL DEFAULT NULL COMMENT '进货价',
  `sale_price` double(30, 0) NULL DEFAULT NULL COMMENT '出售价',
  PRIMARY KEY (`d_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of drug_list
-- ----------------------------
INSERT INTO `drug_list` VALUES (1, '陈李济保济丸', 1, '2021-04-10 00:00:00', '2023-04-10 00:00:00', 'gb20210410', 's20210410', '东北的人参鹿茸、化州的正宗橘红、德庆的何首乌、肇庆的茨实、阳春的砂仁，特别是作为镇店之宝的新会正宗陈皮。', 515, 11, 1, 80, 150);
INSERT INTO `drug_list` VALUES (2, '阿莫西林', 2, '2021-04-01 00:00:00', '2021-04-01 00:00:00', 'gb20210401', 's20210401', '适用于呼吸道、皮肤软组织、泌尿生殖道感染等。过敏性皮炎。血清病、皮疹、接触性皮炎、严重肾功能损害者慎用。', 310, 19, 3, 30, 60);
INSERT INTO `drug_list` VALUES (3, '藿香正气水', 3, '2021-04-03 00:00:00', '2023-04-03 00:00:00', 'gb20230403', 's20230403', '具有解表化湿、理气和中的作用。一般用于治疗外感风寒引起的感冒、头痛、头昏、腹部冷痛、呕吐、腹泻，还有中暑也可以喝。', 500, 14, 1, 5, 12);
INSERT INTO `drug_list` VALUES (4, '夏桑菊颗粒', 3, '2021-04-02 00:00:00', '2023-04-02 00:00:00', 'gb20230402', 's20230402', '可用于清肝明目，疏风散热，能解疮毒，能够有效的改善咽喉肿痛，牙痛，咳嗽等呼吸道疾病。', 510, 14, 1, 10, 25);

-- ----------------------------
-- Table structure for drug_svo
-- ----------------------------
DROP TABLE IF EXISTS `drug_svo`;
CREATE TABLE `drug_svo`  (
  `sv_id` int(0) NOT NULL COMMENT '药品等级号',
  `y_number` int(0) NOT NULL COMMENT '黄色预警数',
  `r_number` int(0) NOT NULL COMMENT '红色预警数',
  PRIMARY KEY (`sv_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of drug_svo
-- ----------------------------
INSERT INTO `drug_svo` VALUES (1, 500, 400);
INSERT INTO `drug_svo` VALUES (2, 400, 300);
INSERT INTO `drug_svo` VALUES (3, 300, 200);
INSERT INTO `drug_svo` VALUES (4, 200, 100);
INSERT INTO `drug_svo` VALUES (5, 0, 0);

-- ----------------------------
-- Table structure for purchase_order
-- ----------------------------
DROP TABLE IF EXISTS `purchase_order`;
CREATE TABLE `purchase_order`  (
  `po_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '进货单编号（account_out）',
  `stock_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '进货流水号',
  `ra_id` int(0) NOT NULL COMMENT '补货申请单编号',
  `po_date` datetime(0) NOT NULL COMMENT '进货日期',
  `po_remarks` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '进货备注',
  PRIMARY KEY (`po_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of purchase_order
-- ----------------------------
INSERT INTO `purchase_order` VALUES (1, 'stock20210413', 3, '2021-04-13 00:00:00', '无');
INSERT INTO `purchase_order` VALUES (2, 'stock20210414', 4, '2021-04-14 00:00:00', '无');
INSERT INTO `purchase_order` VALUES (3, 'stock20210413', 5, '2021-04-13 00:00:00', '加急');
INSERT INTO `purchase_order` VALUES (5, 'stock20210415', 6, '2021-04-15 00:00:00', '及时进货');

-- ----------------------------
-- Table structure for replenish_apply
-- ----------------------------
DROP TABLE IF EXISTS `replenish_apply`;
CREATE TABLE `replenish_apply`  (
  `ra_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '补货申请单编号',
  `apply_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '补货申请流水号',
  `produce_area` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '生产产地',
  `produce_firm` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '生产公司',
  `approve` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '1' COMMENT '补货申请是否通过，1未通过，2通过。若通过了则在进货订单列表里能查询到，且在补货申请列表里能隐藏不显示，补货申请列表只显示未通过的补货订单',
  `ra_remarks` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '补货申请备注',
  `ra_date` datetime(0) NOT NULL COMMENT '补货申请日期',
  PRIMARY KEY (`ra_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of replenish_apply
-- ----------------------------
INSERT INTO `replenish_apply` VALUES (1, 'sq20210411', '广东', '广东药业', '1', '补充存货', '2021-04-11 00:00:00');
INSERT INTO `replenish_apply` VALUES (2, 'sq20210411', '天津', '天津药业', '1', '无', '2021-04-11 00:00:00');
INSERT INTO `replenish_apply` VALUES (3, 'sq20210412', '广东', '广东药企', '2', '无', '2021-04-12 00:00:00');
INSERT INTO `replenish_apply` VALUES (4, 'sq20210410', '广东', '广东药品生产公司', '2', '无', '2021-04-10 00:00:00');
INSERT INTO `replenish_apply` VALUES (5, 'sq20210413', '天津', '天津药品生产公司', '2', '加急', '2021-04-13 00:00:00');
INSERT INTO `replenish_apply` VALUES (6, 'sq20210415', '广东', '广东果然药业', '2', '无', '2021-04-15 00:00:00');

-- ----------------------------
-- Table structure for replenish_drug
-- ----------------------------
DROP TABLE IF EXISTS `replenish_drug`;
CREATE TABLE `replenish_drug`  (
  `ra_id` int(0) NOT NULL COMMENT '补货申请单编号',
  `d_id` int(0) NOT NULL COMMENT '药品编号',
  `num` int(0) NOT NULL COMMENT '需要补货的药品数量',
  PRIMARY KEY (`ra_id`, `d_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of replenish_drug
-- ----------------------------
INSERT INTO `replenish_drug` VALUES (1, 2, 20);
INSERT INTO `replenish_drug` VALUES (1, 4, 20);
INSERT INTO `replenish_drug` VALUES (2, 3, 10);
INSERT INTO `replenish_drug` VALUES (3, 2, 5);
INSERT INTO `replenish_drug` VALUES (4, 1, 10);
INSERT INTO `replenish_drug` VALUES (5, 2, 5);
INSERT INTO `replenish_drug` VALUES (6, 1, 5);
INSERT INTO `replenish_drug` VALUES (6, 4, 10);

-- ----------------------------
-- Table structure for sale_drug
-- ----------------------------
DROP TABLE IF EXISTS `sale_drug`;
CREATE TABLE `sale_drug`  (
  `so_id` int(0) NOT NULL COMMENT '销售订单编号',
  `d_id` int(0) NOT NULL COMMENT '药品编号',
  `num` int(0) NOT NULL COMMENT '销售的药品数量',
  PRIMARY KEY (`so_id`, `d_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sale_drug
-- ----------------------------
INSERT INTO `sale_drug` VALUES (1, 1, 2);
INSERT INTO `sale_drug` VALUES (1, 2, 1);
INSERT INTO `sale_drug` VALUES (2, 3, 2);
INSERT INTO `sale_drug` VALUES (3, 3, 2);
INSERT INTO `sale_drug` VALUES (3, 4, 1);
INSERT INTO `sale_drug` VALUES (4, 1, 2);
INSERT INTO `sale_drug` VALUES (4, 4, 2);
INSERT INTO `sale_drug` VALUES (5, 1, 5);
INSERT INTO `sale_drug` VALUES (5, 3, 2);
INSERT INTO `sale_drug` VALUES (5, 4, 3);

-- ----------------------------
-- Table structure for sale_order
-- ----------------------------
DROP TABLE IF EXISTS `sale_order`;
CREATE TABLE `sale_order`  (
  `so_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '销售订单编号（account_in）',
  `order_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '销售流水号',
  `s_id` int(0) NOT NULL COMMENT '员工编号',
  `so_date` datetime(0) NOT NULL COMMENT '销售日期',
  PRIMARY KEY (`so_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sale_order
-- ----------------------------
INSERT INTO `sale_order` VALUES (1, 'order2021310', 1, '2021-04-10 00:00:00');
INSERT INTO `sale_order` VALUES (2, 'order2021311', 1, '2021-04-11 00:00:00');
INSERT INTO `sale_order` VALUES (3, 'order2021311', 6, '2021-04-11 00:00:00');
INSERT INTO `sale_order` VALUES (4, 'order2021311', 6, '2021-04-11 00:00:00');
INSERT INTO `sale_order` VALUES (5, 'order2021313', 1, '2021-04-13 00:00:00');

-- ----------------------------
-- Table structure for staff_department
-- ----------------------------
DROP TABLE IF EXISTS `staff_department`;
CREATE TABLE `staff_department`  (
  `de_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '部门编号',
  `de_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '部门名字',
  `de_manager` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '部门经理',
  `de_remarks` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '部门备注',
  `de_phone` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '部门电话',
  PRIMARY KEY (`de_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of staff_department
-- ----------------------------
INSERT INTO `staff_department` VALUES (1, '销售部', '孙经理', '推销、出售药品', '7550351');
INSERT INTO `staff_department` VALUES (2, '采购部', '刘经理', '购进药品', '7550352');
INSERT INTO `staff_department` VALUES (3, '库存部', '胖经理', '清点需补货药品，管理库存', '7550353');

-- ----------------------------
-- Table structure for staff_list
-- ----------------------------
DROP TABLE IF EXISTS `staff_list`;
CREATE TABLE `staff_list`  (
  `s_id` int(0) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '员工编号',
  `s_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '员工姓名',
  `s_sex` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '员工性别',
  `s_birth` date NOT NULL COMMENT '员工生日',
  `s_address` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '员工地址',
  `s_phone` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '员工电话',
  `s_duty` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '员工职务',
  `de_id` int(0) NOT NULL COMMENT '部门编号',
  PRIMARY KEY (`s_id`) USING BTREE,
  INDEX `sl_sde`(`de_id`) USING BTREE,
  CONSTRAINT `sl_sde` FOREIGN KEY (`de_id`) REFERENCES `staff_department` (`de_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of staff_list
-- ----------------------------
INSERT INTO `staff_list` VALUES (1, '孙呦嘎', '女', '1999-09-08', '天津市河东区', '17694920101', '销售员', 1);
INSERT INTO `staff_list` VALUES (2, '廖桑', '女', '2000-08-28', '广东省惠州市', '17694920202', '库存员', 3);
INSERT INTO `staff_list` VALUES (3, '刘桑', '男', '1999-11-08', '天津市宝坻区', '17694920303', '库存员', 3);
INSERT INTO `staff_list` VALUES (4, '邱桑', '男', '1999-10-09', '天津市河西区', '17694920404', '采购员', 2);
INSERT INTO `staff_list` VALUES (5, '王桑', '女', '2000-08-09', '天津市武清区', '17694920505', '采购员', 2);
INSERT INTO `staff_list` VALUES (6, '嘎嘎子', '男', '2000-04-01', '天津市河东区', '17694920606', '销售员', 1);

SET FOREIGN_KEY_CHECKS = 1;
