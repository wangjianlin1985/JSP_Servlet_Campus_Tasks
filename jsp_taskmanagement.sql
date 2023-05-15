﻿/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50505
Source Host           : 127.0.0.1:3306
Source Database       : jsp_taskmanagement

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2020-01-08 22:29:57
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `admin`
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `aid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(32) DEFAULT NULL,
  `password` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`aid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', 'admin', 'admin');

-- ----------------------------
-- Table structure for `record`
-- ----------------------------
DROP TABLE IF EXISTS `record`;
CREATE TABLE `record` (
  `rid` varchar(32) NOT NULL,
  `state` int(10) DEFAULT NULL,
  `create_at` bigint(20) DEFAULT NULL,
  `update_at` bigint(20) DEFAULT NULL,
  `uid` varchar(32) DEFAULT NULL,
  `tid` varchar(32) DEFAULT NULL,
  `is_read` int(10) DEFAULT NULL,
  PRIMARY KEY (`rid`),
  KEY `uid_fk` (`uid`),
  KEY `tid_fk` (`tid`),
  CONSTRAINT `tid_fk` FOREIGN KEY (`tid`) REFERENCES `task` (`tid`) ON DELETE SET NULL,
  CONSTRAINT `uid_fk` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of record
-- ----------------------------
INSERT INTO `record` VALUES ('0CBB7563C28F4BED921FE9B61E30DDBF', '1', '1507015943000', '1507015943000', 'B14FC0B8A77211E7AA6654EE75AEF2EA', 'E2FA6FE3A77011E7AA6654EE75AEF2EA', null);
INSERT INTO `record` VALUES ('15B85AD5B81E42AB8DE0AD0769D44E7C', '4', '1506929720000', '1507556610000', 'C22A9BB7B4634F0EB80A7EEF4FD8ED08', '2A229544A72A11E7AA6654EE75AEF2EA', '1');
INSERT INTO `record` VALUES ('15B9BF5020F94E5089B48337E424FB8C', '3', '1507551529000', '1507556610000', 'C22A9BB7B4634F0EB80A7EEF4FD8ED08', 'A399446A6C6644A788F967D29EAD73A5', '1');
INSERT INTO `record` VALUES ('168182D15C8F454CAF73B872E4758461', '2', '1507016637000', '1507016681000', '9C8E48C9A77211E7AA6654EE75AEF2EA', 'E31595D6A77011E7AA6654EE75AEF2EA', null);
INSERT INTO `record` VALUES ('169315F2797E45139050B11C652C9A4E', '1', '1507016663000', '1507016663000', '9C8E48C9A77211E7AA6654EE75AEF2EA', '2A1BBACAA72A11E7AA6654EE75AEF2EA', null);
INSERT INTO `record` VALUES ('174B18A5298A41F18F091C81E1F68646', '3', '1507012383000', '1507555935000', 'C22A9BB7B4634F0EB80A7EEF4FD8ED08', 'E30EBDD3A77011E7AA6654EE75AEF2EA', '1');
INSERT INTO `record` VALUES ('17BB0CD0C83948618D8CC3E58FFB5D31', '1', '1507509009000', '1507509009000', 'A0A26EC0841E4A8E9545DD877DFCCE96', '0EF03468923F4E38A4A6779DCFB021DD', null);
INSERT INTO `record` VALUES ('1B56F538E47749CA844FF3BFA6D2F5A1', '1', '1507508724000', '1507508724000', 'A0A26EC0841E4A8E9545DD877DFCCE96', '2A302CE3A72A11E7AA6654EE75AEF2EA', null);
INSERT INTO `record` VALUES ('1E4CCC3FE93B4F85A0BE1749D87A5ACC', '3', '1506935594000', '1507557064000', 'A0A26EC0841E4A8E9545DD877DFCCE96', '2AC3CEBDA72511E7AA6654EE75AEF2EA', '1');
INSERT INTO `record` VALUES ('1F1E530A0ADE492DA2C04A018308604D', '1', '1506935604000', '1507011752000', 'A0A26EC0841E4A8E9545DD877DFCCE96', '0546AD49639D4E26B2E8577770AAC1EE', null);
INSERT INTO `record` VALUES ('2278F1D946654891B42D61BC15B32514', '1', '1570519653000', '1570519653000', '3E5A90DEA77311E7AA6654EE75AEF2EA', 'E301135AA77011E7AA6654EE75AEF2EA', null);
INSERT INTO `record` VALUES ('27B4C070ADD5451BA35229B4C9076A9B', '1', '1506929783000', '1507011761000', 'C22A9BB7B4634F0EB80A7EEF4FD8ED08', '362C2ACBA72311E7AA6654EE75AEF2EA', null);
INSERT INTO `record` VALUES ('3A8B429B288144C5942FF79F0EB92CDA', '1', '1507508619000', '1507508619000', 'A0A26EC0841E4A8E9545DD877DFCCE96', 'A399446A6C6644A788F967D29EAD73A5', null);
INSERT INTO `record` VALUES ('3BCF4CCE3CC44DEE9069061CA6D4405E', '1', '1506959661000', '1507011737000', 'F24D92F3A77311E7AA6654EE75AEF2EA', 'E30EBDD3A77011E7AA6654EE75AEF2EA', null);
INSERT INTO `record` VALUES ('3CF79630F2CE4A73B9C7E46FFDE75497', '3', '1507551549000', '1507556610000', 'C22A9BB7B4634F0EB80A7EEF4FD8ED08', 'E2ECD36DA77011E7AA6654EE75AEF2EA', '1');
INSERT INTO `record` VALUES ('3E54087EE45E47BBB9727FB3B590E986', '1', '1507017565000', '1507017565000', 'E3599DF052144D11A9207ECC1E69E3F9', 'A0A26EC0841E4A8E9545DD877DFCCE95', null);
INSERT INTO `record` VALUES ('44A8307BA41548A4AAA2D151050C194E', '3', '1507551519000', '1507555935000', 'C22A9BB7B4634F0EB80A7EEF4FD8ED08', 'E31C642AA77011E7AA6654EE75AEF2EA', '1');
INSERT INTO `record` VALUES ('51B6AB49823D409F9C8098AD96FD52A3', '4', '1507551522000', '1507555935000', 'C22A9BB7B4634F0EB80A7EEF4FD8ED08', '0EF03468923F4E38A4A6779DCFB021DD', '1');
INSERT INTO `record` VALUES ('5A63EF693B11422AB13B97C45825C993', '3', '1506959655000', '1507016258000', 'F24D92F3A77311E7AA6654EE75AEF2EA', 'E301135AA77011E7AA6654EE75AEF2EA', null);
INSERT INTO `record` VALUES ('5F49CF9F335440248D4B609DAD58E95F', '1', '1507508683000', '1507508683000', 'A0A26EC0841E4A8E9545DD877DFCCE96', 'E301135AA77011E7AA6654EE75AEF2EA', null);
INSERT INTO `record` VALUES ('68916E2FD1D349A087883CC62288823B', '1', '1506998259000', '1507007001000', 'C22A9BB7B4634F0EB80A7EEF4FD8ED08', '2A07D063A72A11E7AA6654EE75AEF2EA', null);
INSERT INTO `record` VALUES ('717F56FC18714803A64392161B6DAF70', '1', '1506959359000', '1507011741000', null, '2A29A815A72A11E7AA6654EE75AEF2EA', null);
INSERT INTO `record` VALUES ('7516018CC7DE4231B659DB2E451DD6B2', '1', '1507017537000', '1507017537000', 'E3599DF052144D11A9207ECC1E69E3F9', 'E31595D6A77011E7AA6654EE75AEF2EA', null);
INSERT INTO `record` VALUES ('77E701A8C3CF44318D5DBD1944A6FD66', '1', '1506998191000', '1507007004000', 'C22A9BB7B4634F0EB80A7EEF4FD8ED08', null, null);
INSERT INTO `record` VALUES ('79C6C90A2FCE43B1A2DB086F743AF3B7', '3', '1507551538000', '1507556610000', 'C22A9BB7B4634F0EB80A7EEF4FD8ED08', 'E31595D6A77011E7AA6654EE75AEF2EA', '1');
INSERT INTO `record` VALUES ('7D23A2F2D96C4E0F98042A4FE5330B03', '2', '1570519184000', '1570519186000', '3E5A90DEA77311E7AA6654EE75AEF2EA', '0EF03468923F4E38A4A6779DCFB021DD', '0');
INSERT INTO `record` VALUES ('905AC2B21A1F4B9A9102DFEB8FC3E397', '3', '1570519143000', '1570519176000', '3E5A90DEA77311E7AA6654EE75AEF2EA', 'A399446A6C6644A788F967D29EAD73A5', '0');
INSERT INTO `record` VALUES ('9A7A7A879534403E85550F13D18D5342', '3', '1507551533000', '1507556610000', 'C22A9BB7B4634F0EB80A7EEF4FD8ED08', 'E30839C4A77011E7AA6654EE75AEF2EA', '1');
INSERT INTO `record` VALUES ('9DCBD1252AB143C0AAB89B609ACA3708', '3', '1507551535000', '1507556610000', 'C22A9BB7B4634F0EB80A7EEF4FD8ED08', 'E301135AA77011E7AA6654EE75AEF2EA', '1');
INSERT INTO `record` VALUES ('A0A26EC0841E4A8E9545DD877DFCCE11', '3', '1506902546000', '1507509530000', 'E3599DF052144D11A9207ECC1E69E3F9', 'A0A26EC0841E4A8E9545DD877DFCCE85', null);
INSERT INTO `record` VALUES ('A0A26EC0841E4A8E9545DD877DFDCE11', '3', '1506903298000', '1507556610000', 'C22A9BB7B4634F0EB80A7EEF4FD8ED08', 'A0A26EC0841E4A8E9545DD877DFCCE95', '1');
INSERT INTO `record` VALUES ('A26380DE007A4A10A4EDDCB5A9BF66FC', '1', '1507013479000', '1507013479000', 'F24D92F3A77311E7AA6654EE75AEF2EA', '0BD51009A72411E7AA6654EE75AEF2EA', null);
INSERT INTO `record` VALUES ('AE7C709DCD494E6682243B5B84E4415C', '4', '1507016637000', '1507509642000', '9C8E48C9A77211E7AA6654EE75AEF2EA', 'E2FA6FE3A77011E7AA6654EE75AEF2EA', null);
INSERT INTO `record` VALUES ('B34652BFE95246B2A464485CB2671FB6', '1', '1506959345000', '1507011749000', null, 'E301135AA77011E7AA6654EE75AEF2EA', null);
INSERT INTO `record` VALUES ('B4C0A411DDF64ADAB40C6E2AA9F87763', '4', '1506929746000', '1507556610000', 'C22A9BB7B4634F0EB80A7EEF4FD8ED08', 'A9E02DC7A72311E7AA6654EE75AEF2EA', '1');
INSERT INTO `record` VALUES ('B6D6FEE5D55C4801B4D1118FB5E915DB', '1', '1507016710000', '1507016710000', '672DDD3DA77211E7AA6654EE75AEF2EA', 'A0A26EC0841E4A8E9545DD877DFCCE85', null);
INSERT INTO `record` VALUES ('B804CFED2D0F4DF7A6B03CFCFD1123F4', '1', '1507015953000', '1507015953000', 'B14FC0B8A77211E7AA6654EE75AEF2EA', '2A0E500CA72A11E7AA6654EE75AEF2EA', null);
INSERT INTO `record` VALUES ('BC5E96A2237741DCA61A66C2B4078727', '1', '1506959347000', '1506959355000', null, 'E31C642AA77011E7AA6654EE75AEF2EA', null);
INSERT INTO `record` VALUES ('BCA0147109374378B93298EB5909A418', '1', '1506959346000', '1507011747000', null, 'E2FA6FE3A77011E7AA6654EE75AEF2EA', null);
INSERT INTO `record` VALUES ('C5C9EA68C6BC42C99A87C44349C85B67', '3', '1506935579000', '1507016550000', 'A0A26EC0841E4A8E9545DD877DFCCE96', '2A15679FA72A11E7AA6654EE75AEF2EA', null);
INSERT INTO `record` VALUES ('C7F833647F51404EA2525A5942C7D072', '4', '1507551551000', '1507556610000', 'C22A9BB7B4634F0EB80A7EEF4FD8ED08', '2A302CE3A72A11E7AA6654EE75AEF2EA', '1');
INSERT INTO `record` VALUES ('CAF34D4EA03D450AB71288FC0332056D', '1', '1507017544000', '1507017544000', 'E3599DF052144D11A9207ECC1E69E3F9', 'A9E02DC7A72311E7AA6654EE75AEF2EA', null);
INSERT INTO `record` VALUES ('CD102847BB114ACAB12E40A370AD49CF', '1', '1507508653000', '1507508653000', 'A0A26EC0841E4A8E9545DD877DFCCE96', 'E30EBDD3A77011E7AA6654EE75AEF2EA', null);
INSERT INTO `record` VALUES ('D0B0FCE2C6724E4EA4C5C1CA788B4972', '1', '1507017540000', '1507017540000', 'E3599DF052144D11A9207ECC1E69E3F9', '2A1BBACAA72A11E7AA6654EE75AEF2EA', null);
INSERT INTO `record` VALUES ('D47326DAB8574CBFB946A79C069CA9A5', '1', '1507015949000', '1507015949000', 'B14FC0B8A77211E7AA6654EE75AEF2EA', 'E31C642AA77011E7AA6654EE75AEF2EA', null);
INSERT INTO `record` VALUES ('DB4363AD292A4CC6A3B39BFF467DB5F1', '4', '1506959664000', '1506959665000', 'F24D92F3A77311E7AA6654EE75AEF2EA', '2A229544A72A11E7AA6654EE75AEF2EA', null);
INSERT INTO `record` VALUES ('DFA43F261EC5432ABB234420DFF2CDAF', '3', '1506998269000', '1507556610000', 'C22A9BB7B4634F0EB80A7EEF4FD8ED08', 'E2FA6FE3A77011E7AA6654EE75AEF2EA', '1');
INSERT INTO `record` VALUES ('E45CB9EA50DF4F45BBE380AD62D1A4AD', '4', '1507016702000', '1507016714000', '672DDD3DA77211E7AA6654EE75AEF2EA', 'E2ECD36DA77011E7AA6654EE75AEF2EA', null);
INSERT INTO `record` VALUES ('E632F83B1B6E4D01A3338F18F80BF151', '3', '1507016700000', '1507016742000', '672DDD3DA77211E7AA6654EE75AEF2EA', 'E30839C4A77011E7AA6654EE75AEF2EA', null);
INSERT INTO `record` VALUES ('E7749A5573D447488487B844F3880958', '2', '1506959354000', '1506959358000', null, 'E2ECD36DA77011E7AA6654EE75AEF2EA', null);
INSERT INTO `record` VALUES ('E8D3F86ECD5B420D94883E251AC9DB8C', '1', '1507016667000', '1507016667000', '9C8E48C9A77211E7AA6654EE75AEF2EA', '0BD51009A72411E7AA6654EE75AEF2EA', null);
INSERT INTO `record` VALUES ('EAF03EED18564511A5E09402356EF206', '1', '1570519188000', '1570519188000', '3E5A90DEA77311E7AA6654EE75AEF2EA', 'E2FA6FE3A77011E7AA6654EE75AEF2EA', null);
INSERT INTO `record` VALUES ('EE98AE68BFDC472492F600F3FC560330', '1', '1507016655000', '1507016655000', '9C8E48C9A77211E7AA6654EE75AEF2EA', 'A0A26EC0841E4A8E9545DD877DFCCE95', null);
INSERT INTO `record` VALUES ('EFDDCFCB63CE4B87B1B64F8985FC1D55', '1', '1506935586000', '1507011758000', 'A0A26EC0841E4A8E9545DD877DFCCE96', '2A1BBACAA72A11E7AA6654EE75AEF2EA', null);
INSERT INTO `record` VALUES ('F0D8D0C7FB4B46E68DA508C2323D6A4B', '1', '1507016705000', '1507016705000', '672DDD3DA77211E7AA6654EE75AEF2EA', 'A9E02DC7A72311E7AA6654EE75AEF2EA', null);
INSERT INTO `record` VALUES ('F965B27203404679A4F06C9613C0A7F9', '1', '1507509089000', '1507509089000', 'A0A26EC0841E4A8E9545DD877DFCCE96', 'E31595D6A77011E7AA6654EE75AEF2EA', null);

-- ----------------------------
-- Table structure for `task`
-- ----------------------------
DROP TABLE IF EXISTS `task`;
CREATE TABLE `task` (
  `tid` varchar(32) NOT NULL,
  `desc` varchar(255) DEFAULT NULL,
  `category` varchar(20) DEFAULT NULL,
  `create_at` varchar(20) DEFAULT NULL,
  `update_at` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`tid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of task
-- ----------------------------
INSERT INTO `task` VALUES ('0546AD49639D4E26B2E8577770AAC1EE', '设计一个爬虫程序', 'Python', '1506915180000', '1506915205000');
INSERT INTO `task` VALUES ('0BD51009A72411E7AA6654EE75AEF2EA', '使用Angular开发网页', '前端', '1506915887000', null);
INSERT INTO `task` VALUES ('0EF03468923F4E38A4A6779DCFB021DD', '熟练运用各种开发工具', '运维', '1506998376000', null);
INSERT INTO `task` VALUES ('2A07D063A72A11E7AA6654EE75AEF2EA', '使用Angular开发网页', '前端', '1506918514000', null);
INSERT INTO `task` VALUES ('2A0E500CA72A11E7AA6654EE75AEF2EA', '开发一款App并发布', 'IOS', '1506918515000', null);
INSERT INTO `task` VALUES ('2A15679FA72A11E7AA6654EE75AEF2EA', '完成一个商城管理系统的后台', 'PHP', '1506918515000', null);
INSERT INTO `task` VALUES ('2A1BBACAA72A11E7AA6654EE75AEF2EA', '完成一个商城管理系统的后台', 'PHP', '1506918515000', null);
INSERT INTO `task` VALUES ('2A229544A72A11E7AA6654EE75AEF2EA', '华农oj题量达500', 'C/C++', '1506918515000', null);
INSERT INTO `task` VALUES ('2A29A815A72A11E7AA6654EE75AEF2EA', '实现一个简单的Linux内核', 'C/C++', '1506918515000', null);
INSERT INTO `task` VALUES ('2A302CE3A72A11E7AA6654EE75AEF2EA', '开发微信小程序-签到', 'Android', '1506918515000', null);
INSERT INTO `task` VALUES ('2AC3CEBDA72511E7AA6654EE75AEF2EA', '开发一款App并发布', 'IOS', '1506916368000', null);
INSERT INTO `task` VALUES ('362C2ACBA72311E7AA6654EE75AEF2EA', '华农oj题量达400', 'C/C++', '1506915528000', '1506915587000');
INSERT INTO `task` VALUES ('783C5CA6A72311E7AA6654EE75AEF2EA', '开发一款查询天气的App', 'Android', '1506915639000', '1506915690000');
INSERT INTO `task` VALUES ('9AD22B3524CE421D96A7506C6D504934', '冒泡算法java转C++', '编程相关', '1570520187000', null);
INSERT INTO `task` VALUES ('A0A26EC0841E4A8E9545DD877DFCCE85', '完成一个任务管理系统的后台', 'PHP', '1506902415000', '1506902431000');
INSERT INTO `task` VALUES ('A0A26EC0841E4A8E9545DD877DFCCE95', '完成一个商城管理系统的后台', 'Java', '1506869939000', null);
INSERT INTO `task` VALUES ('A399446A6C6644A788F967D29EAD73A5', '使用Unity3d开发一款游戏并发布到steam上.', 'C/C++', '1507017305000', '1570519411000');
INSERT INTO `task` VALUES ('A4F19C5BA72211E7AA6654EE75AEF2EA', '设计一个响应式网页', '前端', '1506915285000', '1506905431000');
INSERT INTO `task` VALUES ('A9E02DC7A72311E7AA6654EE75AEF2EA', '熟练使用Linux', '运维', '1506915723000', '1506915804000');
INSERT INTO `task` VALUES ('E2ECD36DA77011E7AA6654EE75AEF2EA', '使用Angular开发网页', '前端', '1506948889000', null);
INSERT INTO `task` VALUES ('E2FA6FE3A77011E7AA6654EE75AEF2EA', '开发一款App并发布到iphone store上', 'IOS', '1506948890000', '1506998335000');
INSERT INTO `task` VALUES ('E301135AA77011E7AA6654EE75AEF2EA', '完成一个商城管理系统的购物模块', 'PHP', '1506948890000', '1506996627000');
INSERT INTO `task` VALUES ('E30839C4A77011E7AA6654EE75AEF2EA', '完成一个商城管理系统的后台', 'PHP', '1506948890000', null);
INSERT INTO `task` VALUES ('E30EBDD3A77011E7AA6654EE75AEF2EA', '华农oj题量达500', 'C/C++', '1506948890000', null);
INSERT INTO `task` VALUES ('E31595D6A77011E7AA6654EE75AEF2EA', '实现一个简单的Linux内核', 'C/C++', '1506948890000', null);
INSERT INTO `task` VALUES ('E31C642AA77011E7AA6654EE75AEF2EA', '开发微信小程序-签到', 'Android', '1506948890000', null);

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uid` varchar(32) NOT NULL,
  `stuid` varchar(20) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `institute` varchar(20) DEFAULT NULL,
  `major` varchar(20) DEFAULT NULL,
  `grade` int(2) DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL,
  `category` varchar(20) DEFAULT NULL,
  `create_at` bigint(20) DEFAULT NULL,
  `update_at` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`uid`),
  UNIQUE KEY `idx_user_stuid` (`stuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('3E5A90DEA77311E7AA6654EE75AEF2EA', '201111111117', 'jack', 'e10adc3949ba59abbe56e057f20f883e', '工程学院', '车辆工程', '3', 'tom@scau.com', 'PHP', '1506949902000', '1570519102000');
INSERT INTO `user` VALUES ('4D859C4AA77211E7AA6654EE75AEF2EA', '201111111110', '华为', 'e10adc3949ba59abbe56e057f20f883e', '数学与信息学院·软件学院', '计机', '2', 'tom@scau.com', 'Java', '1506949498000', '1570519103000');
INSERT INTO `user` VALUES ('672DDD3DA77211E7AA6654EE75AEF2EA', '201111111111', '小米', 'e10adc3949ba59abbe56e057f20f883e', '经管学院', '经济学', '2', 'tom@scau.com', 'UI', '1506949541000', '1570519104000');
INSERT INTO `user` VALUES ('79B42DE5A77211E7AA6654EE75AEF2EA', '201111111112', 'tom', 'e10adc3949ba59abbe56e057f20f883e', '公管学院', '房地产', '2', 'tom@scau.com', '前端', '1506949572000', '1570519104000');
INSERT INTO `user` VALUES ('893CDED6A77311E7AA6654EE75AEF2EA', '201111111118', 'jac', 'e10adc3949ba59abbe56e057f20f883e', '数信院', '信管', '3', 'tom@scau.com', 'C/C++', '1506950027000', '1570519105000');
INSERT INTO `user` VALUES ('8949FD80A77311E7AA6654EE75AEF2EA', '201111111119', 'jac', 'e10adc3949ba59abbe56e057f20f883e', '数信院', '网工', '3', 'tom@scau.com', 'PHP', '1506950028000', '1570519105000');
INSERT INTO `user` VALUES ('8FB6FA5EA77211E7AA6654EE75AEF2EA', '201111111113', 'jack', 'e10adc3949ba59abbe56e057f20f883e', '农学院', '风景园林', '2', 'tom@scau.com', 'IOS', '1506949609000', '1570519105000');
INSERT INTO `user` VALUES ('9C8E48C9A77211E7AA6654EE75AEF2EA', '201111111114', 'jack', 'e10adc3949ba59abbe56e057f20f883e', '农学院', '风景园林', '2', 'tom@scau.com', '前端', '1506949630000', '1570519106000');
INSERT INTO `user` VALUES ('A0A26EC0841E4A8E9545DD877DFCCE96', '201726040206', '汤姆猫', 'e10adc3949ba59abbe56e057f20f883e', '数信学院', '软R', '2', 'tom@163.com', 'PHP后台', '1506847926000', '1570519107000');
INSERT INTO `user` VALUES ('B0DE2B43A77311E7AA6654EE75AEF2EA', '201111111120', 'jac', 'e10adc3949ba59abbe56e057f20f883e', '经管学院', '经济学', '3', 'tom@scau.com', 'UI', '1506950094000', '1570519109000');
INSERT INTO `user` VALUES ('B14FC0B8A77211E7AA6654EE75AEF2EA', '201111111115', 'jack', 'e10adc3949ba59abbe56e057f20f883e', '外国语学院', '商务英语', '1', 'tom@scau.com', 'PHP', '1506949665000', '1570519110000');
INSERT INTO `user` VALUES ('C22A9BB7B4634F0EB80A7EEF4FD8ED08', '201532112211', '杰克', 'e10adc3949ba59abbe56e057f20f883e', '工程学院', '电子信息工程', '3', 'jack@qq.com', 'IOS', '1506850950000', '1570519111000');
INSERT INTO `user` VALUES ('E3599DF052144D11A9207ECC1E69E3F9', '201625040206', 'hdh', 'e10adc3949ba59abbe56e057f20f883e', '数信学院', '信管', '2', '799108252@qq.com', 'Java后台', '1506846102000', '1570519111000');
INSERT INTO `user` VALUES ('F247417BA77311E7AA6654EE75AEF2EA', '201111111122', 'jac', 'e10adc3949ba59abbe56e057f20f883e', '数信院', '网工', '2', 'tom@scau.com', 'PHP', '1506950204000', '1570519111000');
INSERT INTO `user` VALUES ('F24D92F3A77311E7AA6654EE75AEF2EA', '201111111123', 'jac', 'e10adc3949ba59abbe56e057f20f883e', '经管学院', '经济学', '3', 'tom@scau.com', 'UI', '1506950204000', '1570519112000');
INSERT INTO `user` VALUES ('F254F329A77311E7AA6654EE75AEF2EA', '201111111124', 'jac', 'e10adc3949ba59abbe56e057f20f883e', '法学院', '汉语言', '1', 'tom@scau.com', 'UI', '1506950204000', '1570519114000');
DROP TRIGGER IF EXISTS `tri_record_create`;
DELIMITER ;;
CREATE TRIGGER `tri_record_create` BEFORE INSERT ON `record` FOR EACH ROW BEGIN
 SET new.create_at = UNIX_TIMESTAMP(now())*1000;
 SET new.update_at = UNIX_TIMESTAMP(now())*1000;
END
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `tri_record_update`;
DELIMITER ;;
CREATE TRIGGER `tri_record_update` BEFORE UPDATE ON `record` FOR EACH ROW BEGIN
 SET new.update_at = UNIX_TIMESTAMP(now())*1000;
END
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `tri_task_create`;
DELIMITER ;;
CREATE TRIGGER `tri_task_create` BEFORE INSERT ON `task` FOR EACH ROW BEGIN
 SET new.create_at = UNIX_TIMESTAMP(now())*1000;
END
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `tri_task_update`;
DELIMITER ;;
CREATE TRIGGER `tri_task_update` BEFORE UPDATE ON `task` FOR EACH ROW BEGIN
 SET new.update_at = UNIX_TIMESTAMP(now())*1000;
END
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `tri_user_create`;
DELIMITER ;;
CREATE TRIGGER `tri_user_create` BEFORE INSERT ON `user` FOR EACH ROW BEGIN
 SET new.create_at = UNIX_TIMESTAMP(now())*1000;
END
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `tri_user_update`;
DELIMITER ;;
CREATE TRIGGER `tri_user_update` BEFORE UPDATE ON `user` FOR EACH ROW BEGIN
 SET new.update_at = UNIX_TIMESTAMP(now())*1000;
END
;;
DELIMITER ;