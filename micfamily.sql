/*
 Navicat Premium Data Transfer

 Source Server         : YanShiBoSQL
 Source Server Type    : MySQL
 Source Server Version : 80026
 Source Host           : localhost:3306
 Source Schema         : micfamily

 Target Server Type    : MySQL
 Target Server Version : 80026
 File Encoding         : 65001

 Date: 05/07/2022 17:50:39
*/

SET NAMES utf8mb4;
SET
FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for consumer
-- ----------------------------
DROP TABLE IF EXISTS `consumer`;
CREATE TABLE `consumer`
(
    `id`       varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = gbk COLLATE = gbk_chinese_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of consumer
-- ----------------------------
INSERT INTO `consumer`
VALUES ('1', 'YanShiBo', '111111');
INSERT INTO `consumer`
VALUES ('2', 'bbb', '123456789');

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods`
(
    `id`              int NOT NULL AUTO_INCREMENT,
    `goods_name`      char(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    `price`           decimal(10, 2) NULL DEFAULT NULL,
    `credit_exchange` decimal(10, 2) NULL DEFAULT NULL,
    `quantity`        int NULL DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods`
VALUES (1, '炸鸡', 10.00, 25.00, 10);
INSERT INTO `goods`
VALUES (2, '薯条', 13.00, 30.00, 20);

-- ----------------------------
-- Table structure for manager
-- ----------------------------
DROP TABLE IF EXISTS `manager`;
CREATE TABLE `manager`
(
    `id`         int                                                     NOT NULL AUTO_INCREMENT,
    `user_name`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    `password`   varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    `permission` int NULL DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE INDEX `user_name`(`user_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 58 CHARACTER SET = gbk COLLATE = gbk_chinese_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of manager
-- ----------------------------
INSERT INTO `manager`
VALUES (28, 'zengjia2', 'cxvcxv ', 1);
INSERT INTO `manager`
VALUES (29, 'chengjiatao', 'cxvcxv ', 1);
INSERT INTO `manager`
VALUES (35, 'xcvcxdfsfdee', 'cxvcxv ', 2);
INSERT INTO `manager`
VALUES (38, 'xcvcx1', 'cxvcxv ', 1);
INSERT INTO `manager`
VALUES (39, 'xcvcx2', 'cxvcxv ', 1);
INSERT INTO `manager`
VALUES (54, 'test1', '111', 3);
INSERT INTO `manager`
VALUES (55, 'test2', '111', 4);
INSERT INTO `manager`
VALUES (56, 'test3', '111', 2);
INSERT INTO `manager`
VALUES (57, 'YanShiBo', '111', 1);
INSERT INTO `manager`
VALUES (58, 'root', 'root', 1);
INSERT INTO `manager`
VALUES (59, 'user', '111', 5);
INSERT INTO `manager`
VALUES (60, 'admin', '123', 2);

-- ----------------------------
-- Table structure for notice
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice`
(
    `id`       int                                                     NOT NULL AUTO_INCREMENT,
    `power`    int                                                     NOT NULL,
    `category` int NULL DEFAULT NULL,
    `date`     date                                                    NOT NULL,
    `topic`    varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = gbk COLLATE = gbk_chinese_ci COMMENT = 'category  公告种类\r\npower 权限' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of notice
-- ----------------------------
INSERT INTO `notice`
VALUES (1, 1, 1, '2022-07-04', '麦家项目启动');
INSERT INTO `notice`
VALUES (2, 2, 1, '2022-07-01', '登录注册界面开始开发');

-- ----------------------------
-- Table structure for room
-- ----------------------------
DROP TABLE IF EXISTS `room`;
CREATE TABLE `room`
(
    `id`        int                                                     NOT NULL AUTO_INCREMENT,
    `status`    varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    `room_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    `room_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = gbk COLLATE = gbk_chinese_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of room
-- ----------------------------
INSERT INTO `room`
VALUES (1, '4', 'A101', '1');
INSERT INTO `room`
VALUES (4, '4', 'A102', '2');
INSERT INTO `room`
VALUES (5, '2', 'A103', '3');
INSERT INTO `room`
VALUES (6, '4', 'A104', '2');
INSERT INTO `room`
VALUES (7, '2', 'B101', '1');
INSERT INTO `room`
VALUES (8, '2', 'B102', '2');
INSERT INTO `room`
VALUES (9, '2', 'C101', '1');
INSERT INTO `room`
VALUES (10, '2', 'A105', '2');
INSERT INTO `room`
VALUES (11, '2', 'A106', '3');
INSERT INTO `room`
VALUES (12, '2', 'B103', '2');

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order`
(
    `id`           int                                                     NOT NULL AUTO_INCREMENT,
    `order_info`   varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    `order_time`   varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    `co_room`      varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    `consum_amout` int NULL DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = gbk COLLATE = gbk_chinese_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_order
-- ----------------------------
INSERT INTO `t_order`
VALUES (2, 'pear', '17.00', 'B316', 100);
INSERT INTO `t_order`
VALUES (3, 'chips', '18.00', 'A315', 30);
INSERT INTO `t_order`
VALUES (5, 'apple', '16.32', 'B315', 50);

-- ----------------------------
-- Table structure for vip
-- ----------------------------
DROP TABLE IF EXISTS `vip`;
CREATE TABLE `vip`
(
    `id`        int                                                     NOT NULL AUTO_INCREMENT,
    `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    `password`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    `scores`    int NULL DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = gbk COLLATE = gbk_chinese_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of vip
-- ----------------------------
INSERT INTO `vip`
VALUES (3, 'xcvcz', 'cxvcxv ', 520);
INSERT INTO `vip`
VALUES (4, 'lipeiyang', 'WSDSB', 520);
INSERT INTO `vip`
VALUES (5, 'shuhang', 'WSDSG', 520);
INSERT INTO `vip`
VALUES (6, 'xuxing', '6666', 6666);
INSERT INTO `vip`
VALUES (8, 'test12', '111', 2);

SET
FOREIGN_KEY_CHECKS = 1;
