/*
Navicat MySQL Data Transfer

Source Server         : dani
Source Server Version : 50508
Source Host           : localhost:3306
Source Database       : pc221

Target Server Type    : MYSQL
Target Server Version : 50508
File Encoding         : 65001

Date: 2011-05-29 03:34:50
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
  `csId` int(11) NOT NULL,
  PRIMARY KEY (`announcementId`),
  KEY `ann_fk1` (`teacherId`),
  KEY `ann_fk2` (`csId`),
  CONSTRAINT `ann_fk1` FOREIGN KEY (`teacherId`) REFERENCES `teachers` (`teacherId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `ann_fk2` FOREIGN KEY (`csId`) REFERENCES `specializations_courses` (`csId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of announcement
-- ----------------------------
INSERT INTO `announcement` VALUES ('titlu', 'continut', '2011-05-24', '1', '1', '2');

-- ----------------------------
-- Table structure for `assignments`
-- ----------------------------
DROP TABLE IF EXISTS `assignments`;
CREATE TABLE `assignments` (
  `assignmentId` int(11) NOT NULL AUTO_INCREMENT,
  `csId` int(11) NOT NULL,
  `text` text NOT NULL,
  `deadline` date NOT NULL,
  `subject` varchar(255) NOT NULL,
  PRIMARY KEY (`assignmentId`),
  KEY `fk_assignments_2` (`csId`),
  CONSTRAINT `fk_assignments_2` FOREIGN KEY (`csId`) REFERENCES `specializations_courses` (`csId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of assignments
-- ----------------------------
INSERT INTO `assignments` VALUES ('1', '2', 'textul temei', '2011-05-26', 'Titlul temei');
INSERT INTO `assignments` VALUES ('2', '2', 'ceva text', '2011-05-29', 'Titlul celei de-a 2-a teme');

-- ----------------------------
-- Table structure for `contracts`
-- ----------------------------
DROP TABLE IF EXISTS `contracts`;
CREATE TABLE `contracts` (
  `contractId` int(11) NOT NULL AUTO_INCREMENT,
  `ssId` int(11) NOT NULL,
  `spId` int(11) NOT NULL,
  PRIMARY KEY (`contractId`),
  KEY `spId` (`spId`),
  KEY `ssId` (`ssId`),
  KEY `ssId_2` (`ssId`),
  CONSTRAINT `contracts_ibfk_1` FOREIGN KEY (`spId`) REFERENCES `specializations` (`spId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `contracts_ibfk_2` FOREIGN KEY (`ssId`) REFERENCES `students_specializations` (`ssId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of contracts
-- ----------------------------
INSERT INTO `contracts` VALUES ('1', '2', '2');
INSERT INTO `contracts` VALUES ('2', '3', '2');
INSERT INTO `contracts` VALUES ('3', '4', '2');
INSERT INTO `contracts` VALUES ('4', '5', '2');

-- ----------------------------
-- Table structure for `contracts_data`
-- ----------------------------
DROP TABLE IF EXISTS `contracts_data`;
CREATE TABLE `contracts_data` (
  `contractId` int(11) NOT NULL,
  `csId` int(11) NOT NULL,
  KEY `contractId` (`contractId`),
  KEY `csId` (`csId`),
  CONSTRAINT `contracts_data_ibfk_1` FOREIGN KEY (`contractId`) REFERENCES `contracts` (`contractId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `contracts_data_ibfk_2` FOREIGN KEY (`csId`) REFERENCES `specializations_courses` (`csId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of contracts_data
-- ----------------------------
INSERT INTO `contracts_data` VALUES ('1', '2');
INSERT INTO `contracts_data` VALUES ('1', '5');
INSERT INTO `contracts_data` VALUES ('1', '10');
INSERT INTO `contracts_data` VALUES ('2', '2');
INSERT INTO `contracts_data` VALUES ('2', '5');
INSERT INTO `contracts_data` VALUES ('2', '10');
INSERT INTO `contracts_data` VALUES ('3', '2');
INSERT INTO `contracts_data` VALUES ('3', '5');
INSERT INTO `contracts_data` VALUES ('3', '10');
INSERT INTO `contracts_data` VALUES ('4', '2');
INSERT INTO `contracts_data` VALUES ('4', '5');
INSERT INTO `contracts_data` VALUES ('4', '10');

-- ----------------------------
-- Table structure for `coursematerials`
-- ----------------------------
DROP TABLE IF EXISTS `coursematerials`;
CREATE TABLE `coursematerials` (
  `cmId` int(11) NOT NULL AUTO_INCREMENT,
  `csId` int(11) NOT NULL,
  `fileName` varchar(255) NOT NULL,
  PRIMARY KEY (`cmId`),
  KEY `fk_coursematerials_1` (`csId`),
  CONSTRAINT `fk_coursematerials_1` FOREIGN KEY (`csId`) REFERENCES `specializations_courses` (`csId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of coursematerials
-- ----------------------------
INSERT INTO `coursematerials` VALUES ('1', '2', 'course material filename');

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
-- Table structure for `exams`
-- ----------------------------
DROP TABLE IF EXISTS `exams`;
CREATE TABLE `exams` (
  `examId` int(11) NOT NULL AUTO_INCREMENT,
  `date` date NOT NULL,
  `csId` int(11) NOT NULL,
  `type` varchar(255) NOT NULL,
  PRIMARY KEY (`examId`),
  KEY `new_fk_constraint` (`csId`),
  CONSTRAINT `new_fk_constraint` FOREIGN KEY (`csId`) REFERENCES `specializations_courses` (`csId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1 ROW_FORMAT=FIXED;

-- ----------------------------
-- Records of exams
-- ----------------------------
INSERT INTO `exams` VALUES ('3', '2011-05-21', '10', 'final');
INSERT INTO `exams` VALUES ('4', '2011-05-24', '5', 'final');
INSERT INTO `exams` VALUES ('5', '2011-05-27', '2', 'final');

-- ----------------------------
-- Table structure for `faculties`
-- ----------------------------
DROP TABLE IF EXISTS `faculties`;
CREATE TABLE `faculties` (
  `facultyId` int(11) NOT NULL AUTO_INCREMENT,
  `facultyName` varchar(255) DEFAULT NULL,
  `address` varchar(255) NOT NULL,
  PRIMARY KEY (`facultyId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of faculties
-- ----------------------------
INSERT INTO `faculties` VALUES ('1', 'Mate-Info', 'M. Kogalniceanu nr.1');

-- ----------------------------
-- Table structure for `faculties_specializations`
-- ----------------------------
DROP TABLE IF EXISTS `faculties_specializations`;
CREATE TABLE `faculties_specializations` (
  `facultyId` int(11) NOT NULL,
  `spId` int(11) NOT NULL,
  KEY `facultyId` (`facultyId`),
  KEY `spId` (`spId`),
  CONSTRAINT `faculties_specializations_ibfk_1` FOREIGN KEY (`facultyId`) REFERENCES `faculties` (`facultyId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `faculties_specializations_ibfk_2` FOREIGN KEY (`spId`) REFERENCES `specializations` (`spId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of faculties_specializations
-- ----------------------------
INSERT INTO `faculties_specializations` VALUES ('1', '2');
INSERT INTO `faculties_specializations` VALUES ('1', '3');
INSERT INTO `faculties_specializations` VALUES ('1', '4');

-- ----------------------------
-- Table structure for `grades`
-- ----------------------------
DROP TABLE IF EXISTS `grades`;
CREATE TABLE `grades` (
  `gradeId` int(11) NOT NULL AUTO_INCREMENT,
  `csId` int(11) NOT NULL,
  `ssId` int(11) NOT NULL,
  `grade` int(11) NOT NULL,
  `type` varchar(50) NOT NULL,
  PRIMARY KEY (`gradeId`) USING BTREE,
  KEY `csId` (`csId`),
  KEY `studentId` (`ssId`),
  CONSTRAINT `grades_ibfk_2` FOREIGN KEY (`ssId`) REFERENCES `students_specializations` (`ssId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `grades_ibfk_1` FOREIGN KEY (`csId`) REFERENCES `specializations_courses` (`csId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of grades
-- ----------------------------
INSERT INTO `grades` VALUES ('1', '2', '2', '10', 'final');
INSERT INTO `grades` VALUES ('2', '2', '3', '10', 'final');
INSERT INTO `grades` VALUES ('3', '2', '4', '10', 'final');
INSERT INTO `grades` VALUES ('4', '2', '5', '10', 'final');
INSERT INTO `grades` VALUES ('5', '5', '2', '10', 'final');
INSERT INTO `grades` VALUES ('6', '5', '3', '10', 'final');
INSERT INTO `grades` VALUES ('7', '5', '4', '10', 'final');
INSERT INTO `grades` VALUES ('8', '5', '5', '10', 'final');
INSERT INTO `grades` VALUES ('9', '10', '2', '10', 'final');
INSERT INTO `grades` VALUES ('10', '10', '3', '10', 'final');
INSERT INTO `grades` VALUES ('11', '10', '4', '10', 'final');
INSERT INTO `grades` VALUES ('12', '10', '5', '10', 'final');

-- ----------------------------
-- Table structure for `groups`
-- ----------------------------
DROP TABLE IF EXISTS `groups`;
CREATE TABLE `groups` (
  `groupId` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `spId` int(11) NOT NULL,
  PRIMARY KEY (`groupId`),
  KEY `fk_gr_sp` (`spId`),
  CONSTRAINT `fk_gr_sp` FOREIGN KEY (`spId`) REFERENCES `specializations` (`spId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of groups
-- ----------------------------
INSERT INTO `groups` VALUES ('1', '221', '2');

-- ----------------------------
-- Table structure for `solutions`
-- ----------------------------
DROP TABLE IF EXISTS `solutions`;
CREATE TABLE `solutions` (
  `assignmentId` int(11) NOT NULL,
  `ssId` int(11) NOT NULL,
  `solution` varchar(255) NOT NULL,
  `completed` date NOT NULL,
  PRIMARY KEY (`assignmentId`,`ssId`),
  KEY `fk_solutions_1` (`ssId`),
  CONSTRAINT `fk_solutions_2` FOREIGN KEY (`assignmentId`) REFERENCES `assignments` (`assignmentId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_solutions_1` FOREIGN KEY (`ssId`) REFERENCES `students_specializations` (`ssId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of solutions
-- ----------------------------
INSERT INTO `solutions` VALUES ('1', '2', 'solution filename', '2011-05-27');
INSERT INTO `solutions` VALUES ('2', '2', 'alt filename', '2011-05-28');

-- ----------------------------
-- Table structure for `specializations`
-- ----------------------------
DROP TABLE IF EXISTS `specializations`;
CREATE TABLE `specializations` (
  `spId` int(11) NOT NULL AUTO_INCREMENT,
  `spName` varchar(255) NOT NULL,
  `numberOfYears` int(11) NOT NULL,
  PRIMARY KEY (`spId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of specializations
-- ----------------------------
INSERT INTO `specializations` VALUES ('2', 'informatica', '3');
INSERT INTO `specializations` VALUES ('3', 'matematica', '3');
INSERT INTO `specializations` VALUES ('4', 'ingineria informatiei', '4');

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
  CONSTRAINT `specializations_courses_ibfk_1` FOREIGN KEY (`spId`) REFERENCES `specializations` (`spId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `specializations_courses_ibfk_2` FOREIGN KEY (`courseId`) REFERENCES `courses` (`courseId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of specializations_courses
-- ----------------------------
INSERT INTO `specializations_courses` VALUES ('2', '2', '1', 'BMC-INFO', 'OBLIGATORIU', '6', '1');
INSERT INTO `specializations_courses` VALUES ('3', '3', '1', 'BMC-MATE', 'OBLIGATORIU', '6', '1');
INSERT INTO `specializations_courses` VALUES ('4', '4', '1', 'BMC-INGI', 'OBLIGATORIU', '6', '1');
INSERT INTO `specializations_courses` VALUES ('5', '2', '2', 'ANA-INFO', 'OBLIGATORIU', '6', '1');
INSERT INTO `specializations_courses` VALUES ('7', '3', '2', 'ANA-MATE', 'OBLIGATORIU', '6', '1');
INSERT INTO `specializations_courses` VALUES ('8', '4', '2', 'ANA-INGI', 'OBLIGATORIU', '6', '1');
INSERT INTO `specializations_courses` VALUES ('9', '4', '3', 'FPR-INGI', 'OBLIGATORIU', '6', '1');
INSERT INTO `specializations_courses` VALUES ('10', '2', '3', 'FPR-INFO', 'OBLIGATORIU', '6', '1');
INSERT INTO `specializations_courses` VALUES ('11', '3', '3', 'FPR-MATE', 'OBLIGATORIU', '6', '1');

-- ----------------------------
-- Table structure for `students`
-- ----------------------------
DROP TABLE IF EXISTS `students`;
CREATE TABLE `students` (
  `studentId` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(255) NOT NULL,
  `personalCode` varchar(255) NOT NULL,
  `year` int(11) NOT NULL,
  `serialNumber` int(11) NOT NULL,
  PRIMARY KEY (`studentId`,`serialNumber`,`personalCode`),
  KEY `userName` (`userName`) USING BTREE,
  CONSTRAINT `students_fk1` FOREIGN KEY (`userName`) REFERENCES `users` (`userName`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of students
-- ----------------------------
INSERT INTO `students` VALUES ('2', 'alex', '1880607123454', '1', '10680');
INSERT INTO `students` VALUES ('3', 'andu', '1880607123454', '1', '10681');
INSERT INTO `students` VALUES ('4', 'mishu', '1880607123454', '1', '10682');
INSERT INTO `students` VALUES ('5', 'ovi', '1880607123454', '1', '10683');

-- ----------------------------
-- Table structure for `students_specializations`
-- ----------------------------
DROP TABLE IF EXISTS `students_specializations`;
CREATE TABLE `students_specializations` (
  `ssId` int(11) NOT NULL AUTO_INCREMENT,
  `studentId` int(11) NOT NULL,
  `spId` int(11) NOT NULL,
  `groupId` int(11) NOT NULL,
  PRIMARY KEY (`ssId`),
  KEY `spId` (`spId`),
  KEY `studentId` (`studentId`),
  KEY `students_specializations_ibfk_3` (`groupId`),
  CONSTRAINT `students_specializations_ibfk_1` FOREIGN KEY (`studentId`) REFERENCES `students` (`studentId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `students_specializations_ibfk_2` FOREIGN KEY (`spId`) REFERENCES `specializations` (`spId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `students_specializations_ibfk_3` FOREIGN KEY (`groupId`) REFERENCES `groups` (`groupId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of students_specializations
-- ----------------------------
INSERT INTO `students_specializations` VALUES ('2', '2', '2', '1');
INSERT INTO `students_specializations` VALUES ('3', '3', '2', '1');
INSERT INTO `students_specializations` VALUES ('4', '4', '2', '1');
INSERT INTO `students_specializations` VALUES ('5', '5', '2', '1');

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
  CONSTRAINT `fk1` FOREIGN KEY (`userName`) REFERENCES `users` (`userName`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teachers
-- ----------------------------
INSERT INTO `teachers` VALUES ('1', 'bobby', 'Prof.');
INSERT INTO `teachers` VALUES ('3', 'dia', 'Lector');

-- ----------------------------
-- Table structure for `teachers_groups`
-- ----------------------------
DROP TABLE IF EXISTS `teachers_groups`;
CREATE TABLE `teachers_groups` (
  `tsId` int(11) NOT NULL,
  `groupId` int(11) NOT NULL,
  KEY `fk_teachers_groups_1` (`tsId`),
  KEY `fk_teachers_groups_2` (`groupId`),
  CONSTRAINT `fk_teachers_groups_1` FOREIGN KEY (`tsId`) REFERENCES `teachers_spec` (`tsId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_teachers_groups_2` FOREIGN KEY (`groupId`) REFERENCES `groups` (`groupId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of teachers_groups
-- ----------------------------
INSERT INTO `teachers_groups` VALUES ('1', '1');

-- ----------------------------
-- Table structure for `teachers_spec`
-- ----------------------------
DROP TABLE IF EXISTS `teachers_spec`;
CREATE TABLE `teachers_spec` (
  `tsId` int(11) NOT NULL,
  `teacherId` int(11) NOT NULL,
  `csId` int(11) NOT NULL,
  PRIMARY KEY (`tsId`),
  KEY `csId` (`csId`),
  KEY `teacherId` (`teacherId`),
  CONSTRAINT `teachers_spec_ibfk_1` FOREIGN KEY (`teacherId`) REFERENCES `teachers` (`teacherId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `teachers_spec_ibfk_2` FOREIGN KEY (`csId`) REFERENCES `specializations_courses` (`csId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teachers_spec
-- ----------------------------
INSERT INTO `teachers_spec` VALUES ('1', '1', '2');
INSERT INTO `teachers_spec` VALUES ('2', '3', '2');

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
INSERT INTO `users` VALUES ('Alexandru', 'Suciu', 'alex', '1a1dc91c907325c69271ddf0c944bc72', 'stud');
INSERT INTO `users` VALUES ('Andrei', 'Suciu', 'andu', '1a1dc91c907325c69271ddf0c944bc72', 'stud');
INSERT INTO `users` VALUES ('Bot-Rus', 'Rares', 'bobby', '1a1dc91c907325c69271ddf0c944bc72', 'prof');
INSERT INTO `users` VALUES ('Daniel', 'Dudas', 'dani', '1a1dc91c907325c69271ddf0c944bc72', 'admin');
INSERT INTO `users` VALUES ('Bujorean', 'Diana', 'dia', '1a1dc91c907325c69271ddf0c944bc72', 'prof');
INSERT INTO `users` VALUES ('Mihai', 'Suciu', 'mishu', '1a1dc91c907325c69271ddf0c944bc72', 'stud');
INSERT INTO `users` VALUES ('Bogdan', 'Mihut', 'myh', '1a1dc91c907325c69271ddf0c944bc72', 'admin');
INSERT INTO `users` VALUES ('Ovidiu', 'Suciu', 'ovi', '1a1dc91c907325c69271ddf0c944bc72', 'stud');

-- ----------------------------
-- Procedure structure for `announce_for_course`
-- ----------------------------
DROP PROCEDURE IF EXISTS `announce_for_course`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `announce_for_course`(IN param6 INT)
BEGIN
	SELECT * FROM announcement a 
	inner join teachers t on a.teacherId = t.teacherId
	where csid = param6;
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for `courses_for_contract`
-- ----------------------------
DROP PROCEDURE IF EXISTS `courses_for_contract`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `courses_for_contract`(IN param9 INT)
BEGIN
	select courseCode from 
	contracts_data cd inner join specializations_courses sc 
	on cd.csId=sc.csId 
	where contractId = param9;
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for `courses_for_specialty`
-- ----------------------------
DROP PROCEDURE IF EXISTS `courses_for_specialty`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `courses_for_specialty`(IN param4 INT)
BEGIN
	select s.csId, c.courseName, s.courseCode, s.courseType, s.courseCredits, s.semester 
	from courses c inner join specializations_courses s on c.courseId = s.courseId 
	where s.spId = param4;
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for `courses_for_teacher`
-- ----------------------------
DROP PROCEDURE IF EXISTS `courses_for_teacher`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `courses_for_teacher`(IN param10 VARCHAR(255))
BEGIN
	select sc.courseCode 
	from specializations_courses sc inner join teachers_spec ts  on sc.csId = ts.csId
	inner join teachers t on ts.teacherId = t.teacherId
	inner join users u on u.userName = t.userName
	where u.username = param10;
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for `grades_for_exam`
-- ----------------------------
DROP PROCEDURE IF EXISTS `grades_for_exam`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `grades_for_exam`(IN param3 INT)
BEGIN
	select  userName, grade 
	from students_specializations ss
	inner join grades g on g.ssId=ss.ssId 
	inner join exams e on g.csId=e.csId and g.type = e.type
	inner join students s on s.studentId=ss.studentId
	where examId = param3; 
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for `groups_for_teacher`
-- ----------------------------
DROP PROCEDURE IF EXISTS `groups_for_teacher`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `groups_for_teacher`(IN param7 VARCHAR(255))
BEGIN
	select g.name 
	from groups g 
	inner join teachers_groups tg on g.groupId = tg.groupId
	inner join teachers_spec ts  on tg.tsId = ts.tsid 
	inner join teachers t on ts.teacherId = t.teacherId
	where t.userName = param7;
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for `solutions_for_assign`
-- ----------------------------
DROP PROCEDURE IF EXISTS `solutions_for_assign`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `solutions_for_assign`(IN param2 INT)
BEGIN
	select solution, completed, userName 
	from solutions sl inner join students_specializations ss on sl.ssId = ss.ssId 
	inner join students st on ss.studentId = st.studentId 
	where sl.assignmentId = param2;
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for `specialties_for_faculty`
-- ----------------------------
DROP PROCEDURE IF EXISTS `specialties_for_faculty`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `specialties_for_faculty`(IN param5 INT)
BEGIN
	select * from specializations 
	where spId in (
	select spId from faculties specializations 
	where facultyId = param5); 
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for `students_for_group`
-- ----------------------------
DROP PROCEDURE IF EXISTS `students_for_group`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `students_for_group`(IN param8 INT)
BEGIN
	select c.contractId,ss.ssId,ss.studentId,s.serialNumber,
				 s.personalCode,u.userName,s.year from
	groups g inner join students_specializations ss on g.spId=ss.spId
	inner join students s on ss.studentId=s.studentId 
	inner join users u on s.userName=u.userName 
	inner join contracts c on c.ssId=ss.ssId
	where g.groupId=param8;
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for `teachers_for_course`
-- ----------------------------
DROP PROCEDURE IF EXISTS `teachers_for_course`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `teachers_for_course`(IN param1 INT)
BEGIN
	select userName 
	from teachers t inner join teachers_spec ts on t.teacherId = ts.teacherId
	inner join specializations_courses s on ts.csId = s.csId 
	where s.csId = param1;
END
;;
DELIMITER ;
