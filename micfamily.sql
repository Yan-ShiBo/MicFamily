/*
 Navicat Premium Data Transfer

 Source Server         : zrgj2
 Source Server Type    : MySQL
 Source Server Version : 50650
 Source Host           : 124.222.244.117:3306
 Source Schema         : zrgj2

 Target Server Type    : MySQL
 Target Server Version : 50650
 File Encoding         : 65001

 Date: 12/07/2022 09:38:21
*/

SET NAMES utf8mb4;
SET
FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods`
(
    `id`              int(11) NOT NULL AUTO_INCREMENT,
    `goods_name`      char(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    `price`           decimal(10, 2) NULL DEFAULT NULL,
    `credit_exchange` decimal(10, 2) NULL DEFAULT NULL,
    `quantity`        int(11) NULL DEFAULT NULL,
    `order_id`        int(11) NULL DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods`
VALUES (1, '炸鸡', 10.00, 25.00, 10, 5);
INSERT INTO `goods`
VALUES (2, '薯条', 13.00, 30.00, 20, 5);
INSERT INTO `goods`
VALUES (3, '电池', 5.00, 10.00, 27, NULL);
INSERT INTO `goods`
VALUES (4, '啤酒', 7.00, 10.00, 6, NULL);
INSERT INTO `goods`
VALUES (5, '乡村基', 20.00, 50.00, 5, NULL);
INSERT INTO `goods`
VALUES (6, 'Durex', 10.00, 1.00, 99, NULL);
INSERT INTO `goods`
VALUES (7, '果盘', 40.00, 50.00, 33, NULL);
INSERT INTO `goods`
VALUES (8, '小食', 55.00, 70.00, 44, NULL);

-- ----------------------------
-- Table structure for info
-- ----------------------------
DROP TABLE IF EXISTS `info`;
CREATE TABLE `info`
(
    `id`   int(11) NOT NULL AUTO_INCREMENT,
    `info` longtext CHARACTER SET utf8 COLLATE utf8_general_mysql500_ci NULL,
    `n_id` int(11) NULL DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE,
    INDEX  `n_id`(`n_id`) USING BTREE,
    CONSTRAINT `n_id` FOREIGN KEY (`n_id`) REFERENCES `notice` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_mysql500_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of info
-- ----------------------------
INSERT INTO `info`
VALUES (1,
        '主讲人简介：    任文，教授、博士生导师，北京外国语大学高级翻译学院院长，翻译硕士专业学位教育专家委员会主任委员、国家翻译能力研究中心主任，国际大学翻译学院联合会(CIUTI)副主席，第四届全国翻译专业学位研究生教育指导委员会副主任委员，中国英汉语比较研究会语言服务研究专业委员会副会长等，长期从事翻译学、口译研究和外语教育研究。讲座简介：编者按：未来属于青年，希望寄予青年。暑期来临，西南大学“三下乡”社会实践活动拉开序幕。此次活动以“喜迎二十大，青春向未来”为主题，学校组织了重庆市级重点团队20支，校级实践团2支，院级实践团38支，校级小分队188支，院级小分队95支，共计一万两千余名大学生参与其中。接下来，同学们即将把青春活力播种在乡村振兴中，将智慧才干灌注于社会服务中，将满腔热情投注于地方发展中，发扬脚踏实地奋斗、艰苦奋斗的精神，坚定理想信念，厚植爱国情怀，绽放青春风采，以青春力量赓续红色血脉，以优异成绩迎接党的二十大胜利召开。 “同学们，你们看，那个有些小，这个摘起来刚刚好！”“摘青椒不需要拽，直接给它提起就摘下来了。”',
        1);
INSERT INTO `info`
VALUES (2,
        '赵国华一行深入园艺园林学院、食品科学学院、动物医学院等地检查学院实验室安全运行情况以及放假期间安全管理安排情况，针对检查中存在的隐患问题，检查组要求相关单位加强日常安全管理，立即落实整改工作。赵国华强调，各单位要紧抓实验室安全管理不放松，严格落实实验室安全制度，规范危险化学品储存和使用管理，对假期无人实验室要采取断水断电措施，确保暑期实验室安全稳定运行。韩旭东一行围绕校园疫情防控、学生安全管理、消防安全、食品安全以及在建工程建设情况等方面深入美术学院、材料与能源学院、39教学楼、在建生物学大楼以及二号门等区域开展检查工作，听取相关职能部门、学院的工作汇报。韩旭东指出，学工部门和各学院要加强学生假期离校前安全教育，全面掌握留校学生情况，项目施工单位要落实安全文明施工，确保开学前投入使用。党政办公室、党委研究生工作部、党委学生工作部、保卫处、实验室建设与设备管理处、后勤保障部以及后勤集团相关负责人参加检查。近日，国家重点研发计划项目“西南粮食主产区重金属和农业面源污染综合防治与修复技术示范”（项目编号：2018YFD0800600）顺利通过农业农村部科技发展中心组织的综合绩效评价。近日，国家重点研发计划项目“西南粮食主产区重金属和农业面源污染综合防治与修复技术示范”（项目编号：2018YFD0800600）顺利通过农业农村部科技发展中心组织的综合绩效评价。有力助推了“土壤污染防治行动计划”国家任务在西南地区的落地，为西南粮食主产区作物安全生产、农业生态环境保护作出了重要贡献。',
        2);
INSERT INTO `info`
VALUES (3,
        '\r\n 	\r\n 	\r\n学校召开2022年春季学期期末干部大会\r\n \r\n 	\r\n来源：党政办公室   |   文字：曾卓益熳   |   摄影：刘亚东\r\n编辑：刘亚东   |   审核：于涛\r\n7月8日下午，学校召开2022年春季学期期末干部大会。校领导、各二级党组织书记，各学院（部）院（部）长，机关部门、直附属单位、企业单位主要负责人在东方红会议厅参加会议。\r\n\r\n\r\n\r\n会上，学校党委副书记安春元受校长张卫国委托，总结回顾了党建与事业发展的重点工作，着重对暑期工作进行了安排部署：一是加快推进重点工作；二是统筹推进重大科研平台建设；三是认真组织重大科研项目和标志性教学、科研成果筹划申报；四是认真做好招生就业工作；五是扎实做好安全教育管理工作；六是加快各项基建和修缮项目建设；七是加快财政专项资金预算执行进度；八是严格做好值班值守工作；九是严格落实中央八项规定。\r\n\r\n\r\n\r\n学校党委书记李旭锋就做好假期和下半年工作提出了三点要求：一是要在对标对表强谋划上进一步发力，要有逆水行舟的紧迫感、危机感；要善于识别机遇、抢抓机遇，从大局出发谋划思考工作；要利用假期难得的时间系统梳理、认真谋划下学期工作。二是要在提速提质抓落实上进一步发力，要围绕学校中心工作和重点任务，瞄准堵点痛点，靶向发力，精准破局，确保各项任务高质量高效率地落实落细落到位。三是要在严防严守保安全上进一步发力，高度防范涉意识形态风险，严格落实疫情防控规定，坚决杜绝安全隐患。\r\n\r\n李旭锋要求，全校上下要继续保持攻坚的勇气、增强攻坚的锐气、坚定攻坚的底气，脚踏实地、担当作为，为实际行动书写学校2022年的不凡成绩，以优异成绩迎接党的二十大胜利召开。\r\n\r\n \r\n附件: 	\r\n\r\n 	\r\n 	\r\n学校召开2022年春季学期期末干部大会\r\n \r\n 	\r\n来源：党政办公室   |   文字：曾卓益熳   |   摄影：刘亚东\r\n编辑：刘亚东   |   审核：于涛\r\n7月8日下午，学校召开2022年春季学期期末干部大会。校领导、各二级党组织书记，各学院（部）院（部）长，机关部门、直附属单位、企业单位主要负责人在东方红会议厅参加会议。\r\n\r\n\r\n\r\n会上，学校党委副书记安春元受校长张卫国委托，总结回顾了党建与事业发展的重点工作，着重对暑期工作进行了安排部署：一是加快推进重点工作；二是统筹推进重大科研平台建设；三是认真组织重大科研项目和标志性教学、科研成果筹划申报；四是认真做好招生就业工作；五是扎实做好安全教育管理工作；六是加快各项基建和修缮项目建设；七是加快财政专项资金预算执行进度；八是严格做好值班值守工作；九是严格落实中央八项规定。\r\n\r\n\r\n\r\n学校党委书记李旭锋就做好假期和下半年工作提出了三点要求：一是要在对标对表强谋划上进一步发力，要有逆水行舟的紧迫感、危机感；要善于识别机遇、抢抓机遇，从大局出发谋划思考工作；要利用假期难得的时间系统梳理、认真谋划下学期工作。二是要在提速提质抓落实上进一步发力，要围绕学校中心工作和重点任务，瞄准堵点痛点，靶向发力，精准破局，确保各项任务高质量高效率地落实落细落到位。三是要在严防严守保安全上进一步发力，高度防范涉意识形态风险，严格落实疫情防控规定，坚决杜绝安全隐患。\r\n\r\n李旭锋要求，全校上下要继续保持攻坚的勇气、增强攻坚的锐气、坚定攻坚的底气，脚踏实地、担当作为，为实际行动书写学校2022年的不凡成绩，以优异成绩迎接党的二十大胜利召开。\r\n\r\n \r\n附件: 	\r\n\r\n 	\r\n 	\r\n学校召开2022年春季学期期末干部大会\r\n \r\n 	\r\n来源：党政办公室   |   文字：曾卓益熳   |   摄影：刘亚东\r\n编辑：刘亚东   |   审核：于涛\r\n7月8日下午，学校召开2022年春季学期期末干部大会。校领导、各二级党组织书记，各学院（部）院（部）长，机关部门、直附属单位、企业单位主要负责人在东方红会议厅参加会议。\r\n\r\n\r\n\r\n会上，学校党委副书记安春元受校长张卫国委托，总结回顾了党建与事业发展的重点工作，着重对暑期工作进行了安排部署：一是加快推进重点工作；二是统筹推进重大科研平台建设；三是认真组织重大科研项目和标志性教学、科研成果筹划申报；四是认真做好招生就业工作；五是扎实做好安全教育管理工作；六是加快各项基建和修缮项目建设；七是加快财政专项资金预算执行进度；八是严格做好值班值守工作；九是严格落实中央八项规定。\r\n\r\n\r\n\r\n学校党委书记李旭锋就做好假期和下半年工作提出了三点要求：一是要在对标对表强谋划上进一步发力，要有逆水行舟的紧迫感、危机感；要善于识别机遇、抢抓机遇，从大局出发谋划思考工作；要利用假期难得的时间系统梳理、认真谋划下学期工作。二是要在提速提质抓落实上进一步发力，要围绕学校中心工作和重点任务，瞄准堵点痛点，靶向发力，精准破局，确保各项任务高质量高效率地落实落细落到位。三是要在严防严守保安全上进一步发力，高度防范涉意识形态风险，严格落实疫情防控规定，坚决杜绝安全隐患。\r\n\r\n李旭锋要求，全校上下要继续保持攻坚的勇气、增强攻坚的锐气、坚定攻坚的底气，脚踏实地、担当作为，为实际行动书写学校2022年的不凡成绩，以优异成绩迎接党的二十大胜利召开。\r\n\r\n \r\n附件: 	\r\n',
        4);
INSERT INTO `info`
VALUES (4,
        '7月6日下午，学校6-7月校园安全工作例会在行署楼第五会议室召开。党委书记李旭锋，副校长赵国华、韩旭东出席会议，相关职能部门负责人参加会议。李旭锋主持会议。\r\n\r\n7月6日下午，学校6-7月校园安全工作例会在行署楼第五会议室召开。党委书记李旭锋，副校长赵国华、韩旭东出席会议，相关职能部门负责人参加会议。李旭锋主持会议。\r\n\r\n',
        5);

-- ----------------------------
-- Table structure for manager
-- ----------------------------
DROP TABLE IF EXISTS `manager`;
CREATE TABLE `manager`
(
    `id`         int(11) NOT NULL AUTO_INCREMENT,
    `user_name`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    `password`   varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    `permission` int(11) NULL DEFAULT NULL,
    `status`     int(11) NULL DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE INDEX `user_name`(`user_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 67 CHARACTER SET = gbk COLLATE = gbk_chinese_ci COMMENT = '1.2.3.4.管理员\r\n5.用户' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of manager
-- ----------------------------
INSERT INTO `manager`
VALUES (28, 'zengjia1', 'cxvcxv ', 1, 1);
INSERT INTO `manager`
VALUES (29, 'chengjiatao', 'cxvcxv ', 1, 1);
INSERT INTO `manager`
VALUES (35, 'xcvcxdfsfdee', 'cxvcxv ', 2, 1);
INSERT INTO `manager`
VALUES (38, 'xcvcx1', 'cxvcxv ', 1, 1);
INSERT INTO `manager`
VALUES (39, 'xcvcx2', 'cxvcxv ', 1, 1);
INSERT INTO `manager`
VALUES (54, 'test1', '111', 3, 1);
INSERT INTO `manager`
VALUES (55, 'test2', '111', 4, 1);
INSERT INTO `manager`
VALUES (56, 'test3', '111', 2, NULL);
INSERT INTO `manager`
VALUES (57, 'YanShiBo', '111', 1, NULL);
INSERT INTO `manager`
VALUES (58, 'root', 'root', 1, NULL);
INSERT INTO `manager`
VALUES (59, 'user', '111', 5, 1);
INSERT INTO `manager`
VALUES (60, 'admin', '123', 2, NULL);
INSERT INTO `manager`
VALUES (61, 'user2', '111', 6, NULL);
INSERT INTO `manager`
VALUES (62, 'Jeremy', '666', 5, NULL);
INSERT INTO `manager`
VALUES (63, 'user1', '111', 5, 1);
INSERT INTO `manager`
VALUES (64, 'user3', '111', 5, NULL);
INSERT INTO `manager`
VALUES (65, '', '', NULL, NULL);
INSERT INTO `manager`
VALUES (66, 'shuxiaochen', '111', 5, NULL);

-- ----------------------------
-- Table structure for msgs
-- ----------------------------
DROP TABLE IF EXISTS `msgs`;
CREATE TABLE `msgs`
(
    `msgs_id`   int(11) NOT NULL AUTO_INCREMENT,
    `msgs_cont` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    `type`      int(11) NULL DEFAULT NULL,
    PRIMARY KEY (`msgs_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 95 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of msgs
-- ----------------------------
INSERT INTO `msgs`
VALUES (1, '消息一', 0);
INSERT INTO `msgs`
VALUES (2, '消息2', 2);
INSERT INTO `msgs`
VALUES (3, '有新的用户了', 0);
INSERT INTO `msgs`
VALUES (4, '有新的用户了', 0);
INSERT INTO `msgs`
VALUES (5, '有新的用户了', 0);
INSERT INTO `msgs`
VALUES (6, '有新的用户了', 0);
INSERT INTO `msgs`
VALUES (7, '有新的用户了', 0);
INSERT INTO `msgs`
VALUES (8, '有新的用户了', 0);
INSERT INTO `msgs`
VALUES (9, '有新的用户了', 0);
INSERT INTO `msgs`
VALUES (69, '有新的用户了', 0);
INSERT INTO `msgs`
VALUES (70, '有新的用户了', 0);
INSERT INTO `msgs`
VALUES (71, '有新的用户了', 0);
INSERT INTO `msgs`
VALUES (72, '有新的用户了', 0);
INSERT INTO `msgs`
VALUES (73, '有新的用户了', 0);
INSERT INTO `msgs`
VALUES (74, '有新的用户了', 0);
INSERT INTO `msgs`
VALUES (75, '有新的用户了', 0);
INSERT INTO `msgs`
VALUES (76, '有新的用户了', 0);
INSERT INTO `msgs`
VALUES (77, '有新的用户了', 0);
INSERT INTO `msgs`
VALUES (78, '有新的用户了', 0);
INSERT INTO `msgs`
VALUES (92, '有新的包间预定', 0);
INSERT INTO `msgs`
VALUES (93, '有新的包间预定', 0);
INSERT INTO `msgs`
VALUES (94, '有新的用户了', 1);

-- ----------------------------
-- Table structure for notice
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice`
(
    `id`       int(11) NOT NULL AUTO_INCREMENT,
    `power`    int(11) NOT NULL,
    `category` int(11) NULL DEFAULT NULL,
    `date`     date                                                    NOT NULL,
    `topic`    varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = gbk COLLATE = gbk_chinese_ci COMMENT = 'category  公告种类\r\npower 权限' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of notice
-- ----------------------------
INSERT INTO `notice`
VALUES (1, 1, 1, '2022-07-04', '麦家项目启动');
INSERT INTO `notice`
VALUES (2, 2, 1, '2022-07-01', '登录注册界面开始开发');
INSERT INTO `notice`
VALUES (4, 1, 1, '2022-07-11', '舒航真帅');
INSERT INTO `notice`
VALUES (5, 1, 1, '2022-07-12', '开发组是我爹地');

-- ----------------------------
-- Table structure for room
-- ----------------------------
DROP TABLE IF EXISTS `room`;
CREATE TABLE `room`
(
    `id`         int(11) NOT NULL AUTO_INCREMENT,
    `status`     varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    `room_name`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    `room_type`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    `manager_id` int(11) NULL DEFAULT NULL,
    `price`      int(11) NOT NULL,
    PRIMARY KEY (`id`) USING BTREE,
    INDEX        `manager_id`(`manager_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = gbk COLLATE = gbk_chinese_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of room
-- ----------------------------
INSERT INTO `room`
VALUES (1, '4', 'A101', '1', 63, 108);
INSERT INTO `room`
VALUES (4, '4', 'A102', '2', 64, 168);
INSERT INTO `room`
VALUES (5, '2', 'A103', '3', NULL, 288);
INSERT INTO `room`
VALUES (6, '2', 'A104', '1', NULL, 118);
INSERT INTO `room`
VALUES (7, '2', 'B101', '2', NULL, 178);
INSERT INTO `room`
VALUES (8, '2', 'B102', '3', NULL, 300);
INSERT INTO `room`
VALUES (9, '4', 'C101', '1', NULL, 166);
INSERT INTO `room`
VALUES (10, '2', 'A105', '2', NULL, 200);
INSERT INTO `room`
VALUES (11, '2', 'A106', '3', NULL, 355);
INSERT INTO `room`
VALUES (12, '2', 'B103', '2', NULL, 198);
INSERT INTO `room`
VALUES (13, '2', 'B315', '2', 59, 187);
INSERT INTO `room`
VALUES (14, '2', 'S100', '1', NULL, 88);
INSERT INTO `room`
VALUES (15, '2', 'S101', '2', NULL, 178);
INSERT INTO `room`
VALUES (16, '2', 'S102', '3', NULL, 198);
INSERT INTO `room`
VALUES (17, '2', 'A105', '2', NULL, 52);

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order`
(
    `id`           int(11) NOT NULL AUTO_INCREMENT,
    `order_info`   varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    `order_time`   varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    `co_room`      varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    `consum_amout` int(11) NULL DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = gbk COLLATE = gbk_chinese_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_order
-- ----------------------------
INSERT INTO `t_order`
VALUES (2, 'pear', '17:00', 'B316', 100);
INSERT INTO `t_order`
VALUES (3, 'chips', '18:00', 'A315', 30);
INSERT INTO `t_order`
VALUES (5, '李沛阳的订单', '16:32', 'B315', 50);

-- ----------------------------
-- Table structure for vip
-- ----------------------------
DROP TABLE IF EXISTS `vip`;
CREATE TABLE `vip`
(
    `id`        int(11) NOT NULL AUTO_INCREMENT,
    `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    `password`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    `scores`    int(11) NULL DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = gbk COLLATE = gbk_chinese_ci ROW_FORMAT = DYNAMIC;

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
VALUES (6, 'xuxing', '6666', 666);
INSERT INTO `vip`
VALUES (8, 'test12', '111', 2);
INSERT INTO `vip`
VALUES (9, 'test1', '123', 22);
INSERT INTO `vip`
VALUES (10, '赵俊翔', '123456', 5000);
INSERT INTO `vip`
VALUES (11, 'sh', '111111', 1000000);

SET
FOREIGN_KEY_CHECKS = 1;
