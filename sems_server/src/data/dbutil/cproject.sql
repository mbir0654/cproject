/*
Navicat MySQL Data Transfer

Source Server         : dani
Source Server Version : 50508
Source Host           : localhost:3306
Source Database       : pc221

Target Server Type    : MYSQL
Target Server Version : 50508
File Encoding         : 65001

Date: 2011-05-24 03:34:12
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `announcement`
-- ----------------------------
DROP TABLE IF EXISTS `announcement`;
CREATE TABLE `announcement` (
  `subject` varchar(30) NOT NULL,
  `body` tinytext,
  `date` date DEFAULT NULL,
  `announcementId` int(11) NOT NULL AUTO_INCREMENT,
  `teacherId` int(11) NOT NULL,
  `courseId` int(11) NOT NULL,
  PRIMARY KEY (`announcementId`),
  KEY `ann_fk1` (`teacherId`),
  KEY `ann_fk2` (`courseId`),
  CONSTRAINT `ann_fk1` FOREIGN KEY (`teacherId`) REFERENCES `teachers` (`teacherId`),
  CONSTRAINT `ann_fk2` FOREIGN KEY (`courseId`) REFERENCES `courses` (`courseId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of announcement
-- ----------------------------
INSERT INTO `announcement` VALUES ('primul anunt', 'aici este continutul primului anunt', '2011-05-24', '1', '1', '1');

-- ----------------------------
-- Table structure for `assignments`
-- ----------------------------
DROP TABLE IF EXISTS `assignments`;
CREATE TABLE `assignments` (
  `assignmentId` int(11) NOT NULL AUTO_INCREMENT,
  `csId` int(11) NOT NULL,
  `text` text NOT NULL,
  `deadline` date NOT NULL,
  PRIMARY KEY (`assignmentId`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of assignments
-- ----------------------------

-- ----------------------------
-- Table structure for `contracts`
-- ----------------------------
DROP TABLE IF EXISTS `contracts`;
CREATE TABLE `contracts` (
  `contractId` int(11) NOT NULL AUTO_INCREMENT,
  `ssId` int(11) NOT NULL,
  `spId` int(11) NOT NULL,
  `dateAdd` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `dateUpdate` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`contractId`),
  KEY `spId` (`spId`),
  KEY `ssId` (`ssId`),
  KEY `ssId_2` (`ssId`),
  CONSTRAINT `contracts_ibfk_1` FOREIGN KEY (`spId`) REFERENCES `specializations` (`spId`),
  CONSTRAINT `contracts_ibfk_2` FOREIGN KEY (`ssId`) REFERENCES `students_specializations` (`ssId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of contracts
-- ----------------------------

-- ----------------------------
-- Table structure for `contracts_data`
-- ----------------------------
DROP TABLE IF EXISTS `contracts_data`;
CREATE TABLE `contracts_data` (
  `contractId` int(11) NOT NULL,
  `csId` int(11) NOT NULL,
  KEY `contractId` (`contractId`),
  KEY `csId` (`csId`),
  CONSTRAINT `contracts_data_ibfk_1` FOREIGN KEY (`contractId`) REFERENCES `contracts` (`contractId`),
  CONSTRAINT `contracts_data_ibfk_2` FOREIGN KEY (`csId`) REFERENCES `specializations_courses` (`csId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of contracts_data
-- ----------------------------

-- ----------------------------
-- Table structure for `coursematerials`
-- ----------------------------
DROP TABLE IF EXISTS `coursematerials`;
CREATE TABLE `coursematerials` (
  `cmId` int(11) NOT NULL AUTO_INCREMENT,
  `csId` int(11) NOT NULL,
  `fileName` varchar(255) NOT NULL,
  PRIMARY KEY (`cmId`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of coursematerials
-- ----------------------------

-- ----------------------------
-- Table structure for `courses`
-- ----------------------------
DROP TABLE IF EXISTS `courses`;
CREATE TABLE `courses` (
  `courseId` int(11) NOT NULL AUTO_INCREMENT,
  `courseName` varchar(255) NOT NULL,
  PRIMARY KEY (`courseId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of courses
-- ----------------------------
INSERT INTO `courses` VALUES ('1', 'BMC');
INSERT INTO `courses` VALUES ('2', 'Analiza');
INSERT INTO `courses` VALUES ('3', 'FP');

-- ----------------------------
-- Table structure for `faculties`
-- ----------------------------
DROP TABLE IF EXISTS `faculties`;
CREATE TABLE `faculties` (
  `facultyId` int(11) NOT NULL AUTO_INCREMENT,
  `facultyName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`facultyId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of faculties
-- ----------------------------
INSERT INTO `faculties` VALUES ('1', 'Mate-Info');

-- ----------------------------
-- Table structure for `faculties_specializations`
-- ----------------------------
DROP TABLE IF EXISTS `faculties_specializations`;
CREATE TABLE `faculties_specializations` (
  `facultyId` int(11) NOT NULL,
  `spId` int(11) NOT NULL,
  KEY `facultyId` (`facultyId`),
  KEY `spId` (`spId`),
  CONSTRAINT `faculties_specializations_ibfk_1` FOREIGN KEY (`facultyId`) REFERENCES `faculties` (`facultyId`),
  CONSTRAINT `faculties_specializations_ibfk_2` FOREIGN KEY (`spId`) REFERENCES `specializations` (`spId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of faculties_specializations
-- ----------------------------

-- ----------------------------
-- Table structure for `grade`
-- ----------------------------
DROP TABLE IF EXISTS `grade`;
CREATE TABLE `grade` (
  `noteId` int(11) NOT NULL AUTO_INCREMENT,
  `csId` int(11) NOT NULL,
  `studentId` int(11) NOT NULL,
  `grade` int(11) NOT NULL,
  `type` varchar(50) NOT NULL,
  PRIMARY KEY (`noteId`),
  KEY `csId` (`csId`),
  KEY `studentId` (`studentId`),
  CONSTRAINT `grade_ibfk_1` FOREIGN KEY (`csId`) REFERENCES `specializations_courses` (`csId`),
  CONSTRAINT `grade_ibfk_2` FOREIGN KEY (`studentId`) REFERENCES `students` (`studentId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of grade
-- ----------------------------

-- ----------------------------
-- Table structure for `solutions`
-- ----------------------------
DROP TABLE IF EXISTS `solutions`;
CREATE TABLE `solutions` (
  `assignmentId` int(11) NOT NULL,
  `ssId` int(11) NOT NULL,
  `solution` int(11) NOT NULL,
  PRIMARY KEY (`assignmentId`,`ssId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of solutions
-- ----------------------------

-- ----------------------------
-- Table structure for `specializations`
-- ----------------------------
DROP TABLE IF EXISTS `specializations`;
CREATE TABLE `specializations` (
  `spId` int(11) NOT NULL AUTO_INCREMENT,
  `spName` varchar(255) NOT NULL,
  PRIMARY KEY (`spId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of specializations
-- ----------------------------

-- ----------------------------
-- Table structure for `specializations_courses`
-- ----------------------------
DROP TABLE IF EXISTS `specializations_courses`;
CREATE TABLE `specializations_courses` (
  `csId` int(11) NOT NULL AUTO_INCREMENT,
  `spId` int(11) NOT NULL,
  `courseId` int(11) NOT NULL,
  `courseCode` varchar(255) NOT NULL,
  `courseType` varchar(50) NOT NULL,
  `courseCredits` int(11) NOT NULL,
  `semester` int(11) NOT NULL,
  PRIMARY KEY (`csId`),
  KEY `spId` (`spId`),
  KEY `courseId` (`courseId`),
  CONSTRAINT `specializations_courses_ibfk_1` FOREIGN KEY (`spId`) REFERENCES `specializations` (`spId`),
  CONSTRAINT `specializations_courses_ibfk_2` FOREIGN KEY (`courseId`) REFERENCES `courses` (`courseId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of specializations_courses
-- ----------------------------

-- ----------------------------
-- Table structure for `students`
-- ----------------------------
DROP TABLE IF EXISTS `students`;
CREATE TABLE `students` (
  `studentId` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(255) NOT NULL,
  `personalCode` varchar(255) NOT NULL,
  PRIMARY KEY (`studentId`),
  KEY `userName` (`userName`) USING BTREE,
  CONSTRAINT `students_fk1` FOREIGN KEY (`userName`) REFERENCES `users` (`userName`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of students
-- ----------------------------

-- ----------------------------
-- Table structure for `students_specializations`
-- ----------------------------
DROP TABLE IF EXISTS `students_specializations`;
CREATE TABLE `students_specializations` (
  `ssId` int(11) NOT NULL AUTO_INCREMENT,
  `studentId` int(11) NOT NULL,
  `spId` int(11) NOT NULL,
  `serialNumber` int(11) NOT NULL,
  `group` int(11) NOT NULL,
  `year` int(11) NOT NULL,
  PRIMARY KEY (`ssId`),
  KEY `spId` (`spId`),
  KEY `studentId` (`studentId`),
  CONSTRAINT `students_specializations_ibfk_1` FOREIGN KEY (`studentId`) REFERENCES `students` (`studentId`),
  CONSTRAINT `students_specializations_ibfk_2` FOREIGN KEY (`spId`) REFERENCES `specializations` (`spId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of students_specializations
-- ----------------------------

-- ----------------------------
-- Table structure for `teachers`
-- ----------------------------
DROP TABLE IF EXISTS `teachers`;
CREATE TABLE `teachers` (
  `teacherId` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(255) NOT NULL,
  `teacherTitle` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`teacherId`),
  KEY `userName` (`userName`) USING BTREE,
  CONSTRAINT `fk1` FOREIGN KEY (`userName`) REFERENCES `users` (`userName`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teachers
-- ----------------------------
INSERT INTO `teachers` VALUES ('1', 'bobby', 'Prof.');
INSERT INTO `teachers` VALUES ('2', 'marcel', 'Asistent');
INSERT INTO `teachers` VALUES ('3', 'dia', 'Lector');

-- ----------------------------
-- Table structure for `teachers_spec`
-- ----------------------------
DROP TABLE IF EXISTS `teachers_spec`;
CREATE TABLE `teachers_spec` (
  `teacherId` int(11) NOT NULL,
  `csId` int(11) NOT NULL,
  KEY `csId` (`csId`),
  KEY `teacherId` (`teacherId`),
  CONSTRAINT `teachers_spec_ibfk_1` FOREIGN KEY (`teacherId`) REFERENCES `teachers` (`teacherId`),
  CONSTRAINT `teachers_spec_ibfk_2` FOREIGN KEY (`csId`) REFERENCES `specializations_courses` (`csId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teachers_spec
-- ----------------------------

-- ----------------------------
-- Table structure for `users`
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `firstName` varchar(255) DEFAULT NULL,
  `lastName` varchar(255) DEFAULT NULL,
  `userName` varchar(255) NOT NULL DEFAULT '',
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`userName`),
  UNIQUE KEY `UserName` (`userName`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 PACK_KEYS=1;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('Adrian', 'Bunta', 'adi', '1a1dc91c907325c69271ddf0c944bc72', 'admin');
INSERT INTO `users` VALUES ('Bot-Rus', 'Rares', 'bobby', '1a1dc91c907325c69271ddf0c944bc72', 'prof');
INSERT INTO `users` VALUES ('Daniel', 'Dudas', 'dani', '1a1dc91c907325c69271ddf0c944bc72', 'admin');
INSERT INTO `users` VALUES ('Bujorean', 'Diana', 'dia', '1a1dc91c907325c69271ddf0c944bc72', 'prof');
INSERT INTO `users` VALUES ('Codrea', 'Marcel', 'marcel', '1a1dc91c907325c69271ddf0c944bc72', 'prof');
INSERT INTO `users` VALUES ('Bogdan', 'Mihut', 'myh', '1a1dc91c907325c69271ddf0c944bc72', 'admin');
