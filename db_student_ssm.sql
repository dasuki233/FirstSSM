/*
 Navicat Premium Data Transfer

 Source Server         : student
 Source Server Type    : MySQL
 Source Server Version : 80021
 Source Host           : localhost:3306
 Source Schema         : db_student_ssm

 Target Server Type    : MySQL
 Target Server Version : 80021
 File Encoding         : 65001

 Date: 19/08/2020 15:38:44
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for applymsg
-- ----------------------------
DROP TABLE IF EXISTS `applymsg`;
CREATE TABLE `applymsg`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `job` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `site` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `salary` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pattern` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of applymsg
-- ----------------------------
INSERT INTO `applymsg` VALUES (1, '腾讯公司', 'Java开发工程师', '深圳', '8k', '校企互动式模式');
INSERT INTO `applymsg` VALUES (2, '网易公司', 'Java开发工程师', '深圳', '9k', '校企互动式模式');
INSERT INTO `applymsg` VALUES (3, '育碧公司', 'Java开发工程师', '深圳', '6k', '校企互动式模式');
INSERT INTO `applymsg` VALUES (4, '百度公司', 'Java开发工程师', '深圳', '11k', '学校引进企业模式');
INSERT INTO `applymsg` VALUES (7, '网易互联网校园招聘', 'Java开发工程师', '杭州,北京', '7k', '学校引进企业模式');
INSERT INTO `applymsg` VALUES (8, '网易互联网校园招聘', '前端开发工程师', '广州,杭州,北京', '6k', '\"订单\"式合作');
INSERT INTO `applymsg` VALUES (9, '网易互联网校园招聘', '电商运营', '广州,杭州,北京', '5k', '\"订单\"式合作');
INSERT INTO `applymsg` VALUES (10, '网易互联网校园招聘', 'Android开发工程师', '广州,杭州,北京', '8k', '\"订单\"式合作');
INSERT INTO `applymsg` VALUES (11, '网易互联网校园招聘', '深度学习算法工程师', '广州,杭州,北京', '9k', '学校引进企业模式');
INSERT INTO `applymsg` VALUES (12, '腾讯公司', '技术运营', '深圳,北京,广州,成都', '7k', '校企互动式模式');
INSERT INTO `applymsg` VALUES (13, '腾讯公司', '软件测试', '深圳,北京,广州,成都', '6k', '校企互动式模式');

-- ----------------------------
-- Table structure for baogao
-- ----------------------------
DROP TABLE IF EXISTS `baogao`;
CREATE TABLE `baogao`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `sdId` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `former` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `now` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `reason` varchar(600) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `get_name_for_student`(`sdId`) USING BTREE,
  CONSTRAINT `get_name_for_student` FOREIGN KEY (`sdId`) REFERENCES `student` (`username`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of baogao
-- ----------------------------
INSERT INTO `baogao` VALUES (1, '张', '腾讯', '百度', '这里简直就是压榨，他们才给我2000一个月，这个月我都加班了60多个小时了，一分加班费都没有，还扣了我半个月工资，我受不了了啊！！！！');

-- ----------------------------
-- Table structure for c3p0testtable
-- ----------------------------
DROP TABLE IF EXISTS `c3p0testtable`;
CREATE TABLE `c3p0testtable`  (
  `a` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of c3p0testtable
-- ----------------------------

-- ----------------------------
-- Table structure for clazz
-- ----------------------------
DROP TABLE IF EXISTS `clazz`;
CREATE TABLE `clazz`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `gradeId` int NOT NULL,
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `remark` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`, `gradeId`) USING BTREE,
  INDEX `gradeId`(`gradeId`) USING BTREE,
  INDEX `id`(`id`) USING BTREE,
  CONSTRAINT `clazz_ibfk_1` FOREIGN KEY (`gradeId`) REFERENCES `grade` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 292 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of clazz
-- ----------------------------
INSERT INTO `clazz` VALUES (12, 16, '软件工程', '软件工程');
INSERT INTO `clazz` VALUES (14, 16, '学前教育', '学前教育');
INSERT INTO `clazz` VALUES (233, 18, '应用泰语', '应用泰语');
INSERT INTO `clazz` VALUES (234, 17, '网络工程', '网络工程');
INSERT INTO `clazz` VALUES (235, 19, '应用化学', '网络工程');
INSERT INTO `clazz` VALUES (236, 16, '机械设计制造及其自动化', '机械设计制造及其自动化');
INSERT INTO `clazz` VALUES (237, 20, '电气工程及其自动化', '电气工程及其自动化');
INSERT INTO `clazz` VALUES (238, 16, '计算机科学与技术', '计算机科学与技术');
INSERT INTO `clazz` VALUES (240, 18, '土木工程', '土木工程');
INSERT INTO `clazz` VALUES (251, 16, '计算机应用技术', '计算机应用技术');
INSERT INTO `clazz` VALUES (286, 16, '安全工程', '安全工程');
INSERT INTO `clazz` VALUES (287, 16, '环境设计 ', '环境设计 ');
INSERT INTO `clazz` VALUES (288, 16, '会计学', '会计学');
INSERT INTO `clazz` VALUES (289, 18, '材料科学与工程', '材料科学与工程');
INSERT INTO `clazz` VALUES (290, 17, ' 食品质量与安全', ' 食品质量与安全');
INSERT INTO `clazz` VALUES (291, 17, ' 动物医学 ', ' 动物医学 ');

-- ----------------------------
-- Table structure for company
-- ----------------------------
DROP TABLE IF EXISTS `company`;
CREATE TABLE `company`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `scale` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `qualification` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `nature` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `pattern` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `job` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sdId` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tcId` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `remark` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `get_sd_username`(`sdId`) USING BTREE,
  INDEX `get_tc_username`(`tcId`) USING BTREE,
  CONSTRAINT `get_sd_username` FOREIGN KEY (`sdId`) REFERENCES `student` (`username`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `get_tc_username` FOREIGN KEY (`tcId`) REFERENCES `teacher` (`username`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 26 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of company
-- ----------------------------
INSERT INTO `company` VALUES (1, '中国石油化工集团公司', '国企', '化工石油工程资质', '国有企业', '\"订单\"式合作', 'Java开发工程师', '张', '马思维1', NULL);
INSERT INTO `company` VALUES (3, '中国石油天然气集团公司', '国企', '化工石油工程资质', '国有企业', '\"订单\"式合作', 'Java开发工程师', '李四', '李白', NULL);
INSERT INTO `company` VALUES (10, '国家电网公司', '国企', '电力工程资质', '国有企业', '\"订单\"式合作', 'Java开发工程师', '孙', '杜甫', NULL);
INSERT INTO `company` VALUES (11, '中国工商银行股份有限公司', '国企', '通信工程资质', '国有企业', '\"订单\"式合作', '前端开发工程师', '李四', '马思维1', NULL);
INSERT INTO `company` VALUES (12, '中国移动通信集团公司', '国企', '通信工程资质', '国有企业', '\"订单\"式合作', 'Android开发工程师', '王五', '杜甫', NULL);
INSERT INTO `company` VALUES (21, '网易（杭州）网络有限公司', '大型企业', '通信工程资质', '民营IT企业', '\"订单\"式合作', '技术运营', '王一', '陈冠希', NULL);
INSERT INTO `company` VALUES (24, '深圳市腾讯计算机系统有限公司', '大型企业', '通信工程资质', '民营IT企业', '学校引进企业模式', '前端开发工程师', '张', '张老师', NULL);

-- ----------------------------
-- Table structure for grade
-- ----------------------------
DROP TABLE IF EXISTS `grade`;
CREATE TABLE `grade`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `remark` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 230 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of grade
-- ----------------------------
INSERT INTO `grade` VALUES (16, '2016届', '1');
INSERT INTO `grade` VALUES (17, '2017届', NULL);
INSERT INTO `grade` VALUES (18, '2018届', NULL);
INSERT INTO `grade` VALUES (19, '2019届', NULL);
INSERT INTO `grade` VALUES (20, '2020届', NULL);
INSERT INTO `grade` VALUES (229, '1212', '');

-- ----------------------------
-- Table structure for independent
-- ----------------------------
DROP TABLE IF EXISTS `independent`;
CREATE TABLE `independent`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `sdId` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `job` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `site` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `remark` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `duikou` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `get_sd_username1`(`sdId`) USING BTREE,
  INDEX `site`(`site`) USING BTREE,
  CONSTRAINT `get_sd_username1` FOREIGN KEY (`sdId`) REFERENCES `student` (`username`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 65 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of independent
-- ----------------------------
INSERT INTO `independent` VALUES (3, '王一', '网易（杭州）网络有限公司', 'Java开发工程师', '广西', '自主实习', '是');
INSERT INTO `independent` VALUES (4, '李', '网易（杭州）网络有限公司', 'Java开发工程师', '南京', '自主实习', '否');
INSERT INTO `independent` VALUES (29, '赵', '深圳市腾讯计算机系统有限公司', '前端开发工程师', '北京', '志愿申请', '否');
INSERT INTO `independent` VALUES (30, '孙', '深圳市腾讯计算机系统有限公司', 'Android开发工程师', '东京', '志愿申请', '是');
INSERT INTO `independent` VALUES (31, '李四', '深圳市腾讯计算机系统有限公司', '技术运营', '上海', '志愿申请', '是');
INSERT INTO `independent` VALUES (32, '王五', '网易（杭州）网络有限公司', 'Java开发工程师', '澳大利亚', '志愿申请', '是');
INSERT INTO `independent` VALUES (48, '张', '网易（杭州）网络有限公司', 'Java开发工程师', '瑞典', '志愿申请', '否');
INSERT INTO `independent` VALUES (60, '张', '深圳市腾讯计算机系统有限公司', 'Java开发工程师', '瑞典', '自主实习', '是');
INSERT INTO `independent` VALUES (63, NULL, NULL, NULL, NULL, NULL, '是');
INSERT INTO `independent` VALUES (64, NULL, NULL, NULL, NULL, NULL, '是');

-- ----------------------------
-- Table structure for inform
-- ----------------------------
DROP TABLE IF EXISTS `inform`;
CREATE TABLE `inform`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `studentId` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `arrange` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `testt` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `training` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sqsj` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `get_name`(`studentId`) USING BTREE,
  CONSTRAINT `get_name` FOREIGN KEY (`studentId`) REFERENCES `student` (`username`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 49 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of inform
-- ----------------------------
INSERT INTO `inform` VALUES (27, '张', '实习时间2020-11-10', '岗前测试时间2020-11-17', '培训时间安排2020-11-21', '腾讯公司2020-11-28');
INSERT INTO `inform` VALUES (29, '王五', '实习时间2020-11-11', '岗前测试时间2020-11-15', '培训时间安排2020-11-19', '腾讯公司2020-11-23');
INSERT INTO `inform` VALUES (31, '赵', '实习时间2020-11-9', '岗前测试时间2020-11-15', '培训时间安排2020-11-21', '腾讯公司2020-11-27');

-- ----------------------------
-- Table structure for pjgl
-- ----------------------------
DROP TABLE IF EXISTS `pjgl`;
CREATE TABLE `pjgl`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `sdId` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `summary` varchar(600) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `scsxbg` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `score` int NULL DEFAULT NULL,
  `pj` varchar(600) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `get_username_forStudent`(`sdId`) USING BTREE,
  CONSTRAINT `get_username_forStudent` FOREIGN KEY (`sdId`) REFERENCES `student` (`username`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pjgl
-- ----------------------------
INSERT INTO `pjgl` VALUES (1, '张', '1', '上传实习报告', 80, '');
INSERT INTO `pjgl` VALUES (2, '李', '', '', 80, '');
INSERT INTO `pjgl` VALUES (3, '王一', '1', '1', 1, '1');
INSERT INTO `pjgl` VALUES (4, '孙', '123', '1231', 1, '23123');
INSERT INTO `pjgl` VALUES (10, '张', '我看看看看我看看看看我看看看看我看看看看我看看看看我看看看看我看看看看我看看看看我看看看看我看看看看我看看看看我看看看看我看看看看我看看看看我看看看看我看看看看我看看看看我看看看看我看看看看我看看看看我看看看看我看看看看我看看看看我看看看看我看看看看我看看看看我看看看看我看看看看我看看看看我看看看看我看看看看我看看看看我看看看看我看看看看我看看看看我看看看看', NULL, 80, '');

-- ----------------------------
-- Table structure for processs
-- ----------------------------
DROP TABLE IF EXISTS `processs`;
CREATE TABLE `processs`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `sdId` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `czjl` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `fbqk` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bgjh` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `remark` varchar(600) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `get_sdusn`(`sdId`) USING BTREE,
  CONSTRAINT `get_sdusn` FOREIGN KEY (`sdId`) REFERENCES `student` (`username`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 30 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of processs
-- ----------------------------
INSERT INTO `processs` VALUES (14, '李四', '大一', '澳大利亚', '已就业', '感觉良好');
INSERT INTO `processs` VALUES (19, '王五', '大一', '澳大利亚', '已就业', '哦嘞瓦姨妈,赛高尼HIGH铁鸭子哒！哦嘞瓦姨妈,赛高尼HIGH铁鸭子哒！哦嘞瓦姨妈,赛高尼HIGH铁鸭子哒！哦嘞瓦姨妈,赛高尼HIGH铁鸭子哒！哦嘞瓦姨妈,赛高尼HIGH铁鸭子哒！哦嘞瓦姨妈,赛高尼HIGH铁鸭子哒！哦嘞瓦姨妈,赛高尼HIGH铁鸭子哒！哦嘞瓦姨妈,赛高尼HIGH铁鸭子哒！哦嘞瓦姨妈,赛高尼HIGH铁鸭子哒！哦嘞瓦姨妈,赛高尼HIGH铁鸭子哒！哦嘞瓦姨妈,赛高尼HIGH铁鸭子哒！哦嘞瓦姨妈,赛高尼HIGH铁鸭子哒！哦嘞瓦姨妈,赛高尼HIGH铁鸭子哒！哦嘞瓦姨妈,赛高尼HIGH铁鸭子哒！哦嘞瓦姨妈,赛高尼HIGH铁鸭子哒！哦嘞瓦姨妈,赛高尼HIGH铁鸭子哒！哦嘞瓦姨妈,赛高尼HIGH铁鸭子哒！哦嘞瓦姨妈,赛高尼HIGH铁鸭子哒！哦嘞瓦姨妈,赛高尼HIGH铁鸭子哒！哦嘞瓦姨妈,赛高尼HIGH铁鸭子哒！哦嘞瓦姨妈,赛高尼HIGH铁鸭子哒！哦嘞瓦姨妈,赛高尼HIGH铁鸭子哒！哦嘞瓦姨妈,赛高尼HIGH铁鸭子哒！哦嘞瓦姨妈,赛高尼HIGH铁鸭子哒！哦嘞瓦姨妈,赛高尼HIGH铁鸭子哒！哦嘞瓦姨妈,赛高尼HIGH铁鸭子哒！哦嘞瓦姨妈,赛高尼HIGH铁鸭子哒！哦嘞瓦姨妈,赛高尼HIGH铁鸭子哒！哦嘞瓦姨妈,赛高尼HIGH铁鸭子哒！哦嘞瓦姨妈,赛高尼HIGH铁鸭子哒！哦嘞瓦姨妈,赛高尼HIGH铁鸭子哒！哦嘞瓦姨妈,赛高尼HIGH铁鸭子哒！');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `clazzId` int NULL DEFAULT NULL,
  `xh` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sn` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `username` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `tel` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sex` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `photo` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `remark` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`, `username`) USING BTREE,
  INDEX `gradeId`(`clazzId`) USING BTREE,
  INDEX `username`(`username`) USING BTREE,
  INDEX `id`(`id`) USING BTREE,
  INDEX `sn`(`sn`) USING BTREE,
  CONSTRAINT `student_ibfk_1` FOREIGN KEY (`clazzId`) REFERENCES `clazz` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 48 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (27, 14, '181040610101', 'S1597518743910', '张', '123', '18777777777', '男', '/StudentManagerSSM/photo/touxiang.jpg', '2018级');
INSERT INTO `student` VALUES (31, 234, '181040610102', 'S1597518748805', '王一', '1', NULL, '男', '/StudentManagerSSM/photo/touxiang.jpg', '2018级');
INSERT INTO `student` VALUES (32, 237, '181040610103', 'S1597357968048', '李', '1', NULL, '男', '/StudentManagerSSM/photo/touxiang.jpg', '2018级');
INSERT INTO `student` VALUES (33, 237, '181040610104', 'S1597357949907', '赵', '1', NULL, '男', '/StudentManagerSSM/photo/touxiang.jpg', '2018级');
INSERT INTO `student` VALUES (34, 12, '181040610105', 'S1597531543661', '孙', '1', NULL, '男', '/StudentManagerSSM/upload/1597531532162.jpg', '2018级');
INSERT INTO `student` VALUES (41, 12, '181040610106', 'S1597531028537', '李四', '321', NULL, '男', '/StudentManagerSSM/upload/1597531026533.jpg', '2019级');
INSERT INTO `student` VALUES (42, 12, '181040610107', 'S1597530820921', '王五', '123', NULL, '男', '/StudentManagerSSM/upload/1597530819001.jpg', '2019级');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `performance` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `honor` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `worktime` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tel` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `username`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES (1, '张老师', '123', '优秀', '特级教师', '13年', '10086');
INSERT INTO `teacher` VALUES (3, '张三', '123', '优秀', '特级教师', '12年', '123131');
INSERT INTO `teacher` VALUES (7, '吴彦祖', '5', '优秀', '特级教师', '9年', '10010');
INSERT INTO `teacher` VALUES (8, '陈冠希', '6', '优秀', '特级教师', '3年', '1001011');
INSERT INTO `teacher` VALUES (9, '林志玲', '7', '优秀', '特级教师', '5年', '1008611');
INSERT INTO `teacher` VALUES (10, '李白', '8', '优秀', '特级教师', '8年', '18790140454654');
INSERT INTO `teacher` VALUES (11, '杜甫', '1', '优秀', '特级教师', '13年', '12345678');
INSERT INTO `teacher` VALUES (12, '马思维1', '11', '优秀', '特级教师', '13年', '123123123');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', 'user');
INSERT INTO `user` VALUES (17, '1', '1');

SET FOREIGN_KEY_CHECKS = 1;
