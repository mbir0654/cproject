-- MySQL dump 10.13  Distrib 5.1.41, for debian-linux-gnu (i486)
--
-- Host: localhost    Database: pc221
-- ------------------------------------------------------
-- Server version	5.1.41-3ubuntu12.10

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `announcement`
--

DROP TABLE IF EXISTS `announcement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `announcement`
--

LOCK TABLES `announcement` WRITE;
/*!40000 ALTER TABLE `announcement` DISABLE KEYS */;
INSERT INTO `announcement` VALUES ('titlu','continut','2011-05-24',1,1,2);
/*!40000 ALTER TABLE `announcement` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `assignments`
--

DROP TABLE IF EXISTS `assignments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assignments`
--

LOCK TABLES `assignments` WRITE;
/*!40000 ALTER TABLE `assignments` DISABLE KEYS */;
INSERT INTO `assignments` VALUES (1,2,'textul temei','2011-05-26','Titlul temei'),(2,2,'ceva text','2011-05-29','Titlul celei de-a 2-a teme');
/*!40000 ALTER TABLE `assignments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contracts`
--

DROP TABLE IF EXISTS `contracts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contracts` (
  `contractId` int(11) NOT NULL AUTO_INCREMENT,
  `ssId` int(11) NOT NULL,
  `spId` int(11) NOT NULL,
  PRIMARY KEY (`contractId`),
  KEY `spId` (`spId`),
  KEY `ssId` (`ssId`),
  KEY `ssId_2` (`ssId`),
  CONSTRAINT `contracts_uk` UNIQUE (`spId`,`ssId`),
  CONSTRAINT `contracts_ibfk_1` FOREIGN KEY (`spId`) REFERENCES `specializations` (`spId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `contracts_ibfk_2` FOREIGN KEY (`ssId`) REFERENCES `students_specializations` (`ssId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contracts`
--

LOCK TABLES `contracts` WRITE;
/*!40000 ALTER TABLE `contracts` DISABLE KEYS */;
INSERT INTO `contracts` VALUES (1,2,2),(2,3,2),(3,4,2),(4,5,2),(16,18,2);
/*!40000 ALTER TABLE `contracts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contracts_data`
--

DROP TABLE IF EXISTS `contracts_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contracts_data` (
  `contractId` int(11) NOT NULL,
  `csId` int(11) NOT NULL,
  KEY `contractId` (`contractId`),
  KEY `csId` (`csId`),
  CONSTRAINT `course_contract_uk` UNIQUE (`csId`,`contractId`),
  CONSTRAINT `contracts_data_ibfk_1` FOREIGN KEY (`contractId`) REFERENCES `contracts` (`contractId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `contracts_data_ibfk_2` FOREIGN KEY (`csId`) REFERENCES `specializations_courses` (`csId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contracts_data`
--

LOCK TABLES `contracts_data` WRITE;
/*!40000 ALTER TABLE `contracts_data` DISABLE KEYS */;
INSERT INTO `contracts_data` VALUES (1,2),(1,5),(1,10),(2,2),(2,5),(2,10),(3,2),(3,5),(3,10),(4,2),(4,5),(4,10);
/*!40000 ALTER TABLE `contracts_data` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `coursematerials`
--

DROP TABLE IF EXISTS `coursematerials`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `coursematerials` (
  `cmId` int(11) NOT NULL AUTO_INCREMENT,
  `csId` int(11) NOT NULL,
  `fileName` varchar(255) NOT NULL,
  PRIMARY KEY (`cmId`),
  KEY `fk_coursematerials_1` (`csId`),
  CONSTRAINT `coursematerials_uk1` UNIQUE (`csId`,`fileName`),
  CONSTRAINT `fk_coursematerials_1` FOREIGN KEY (`csId`) REFERENCES `specializations_courses` (`csId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `coursematerials`
--

LOCK TABLES `coursematerials` WRITE;
/*!40000 ALTER TABLE `coursematerials` DISABLE KEYS */;
INSERT INTO `coursematerials` VALUES (1,2,'course material filename');
/*!40000 ALTER TABLE `coursematerials` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `courses`
--

DROP TABLE IF EXISTS `courses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `courses` (
  `courseId` int(11) NOT NULL AUTO_INCREMENT,
  `courseName` varchar(255) NOT NULL,
  CONSTRAINT `courses_uk` UNIQUE (`courseName`),
  PRIMARY KEY (`courseId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `courses`
--

LOCK TABLES `courses` WRITE;
/*!40000 ALTER TABLE `courses` DISABLE KEYS */;
INSERT INTO `courses` VALUES (1,'BMC'),(2,'Analiza'),(3,'FP');
/*!40000 ALTER TABLE `courses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exams`
--

DROP TABLE IF EXISTS `exams`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `exams` (
  `examId` int(11) NOT NULL AUTO_INCREMENT,
  `date` date NOT NULL,
  `csId` int(11) NOT NULL,
  `type` varchar(255) NOT NULL,
  CONSTRAINT `exams_uk` UNIQUE (`csId`,`type`,`date`),
  PRIMARY KEY (`examId`),
  KEY `new_fk_constraint` (`csId`),
  CONSTRAINT `new_fk_constraint` FOREIGN KEY (`csId`) REFERENCES `specializations_courses` (`csId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1 ROW_FORMAT=FIXED;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exams`
--

LOCK TABLES `exams` WRITE;
/*!40000 ALTER TABLE `exams` DISABLE KEYS */;
INSERT INTO `exams` VALUES (3,'2011-05-21',10,'final'),(4,'2011-05-24',5,'final'),(5,'2011-05-27',2,'final');
/*!40000 ALTER TABLE `exams` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `faculties`
--

DROP TABLE IF EXISTS `faculties`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `faculties` (
  `facultyId` int(11) NOT NULL AUTO_INCREMENT,
  `facultyName` varchar(255) DEFAULT NULL,
  `address` varchar(255) NOT NULL,
  CONSTRAINT `faculties_uk` UNIQUE (`facultyName`),
  PRIMARY KEY (`facultyId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `faculties`
--

LOCK TABLES `faculties` WRITE;
/*!40000 ALTER TABLE `faculties` DISABLE KEYS */;
INSERT INTO `faculties` VALUES (1,'Mate-Info','M. Kogalniceanu nr.1');
/*!40000 ALTER TABLE `faculties` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `faculties_specializations`
--

DROP TABLE IF EXISTS `faculties_specializations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `faculties_specializations` (
  `facultyId` int(11) NOT NULL,
  `spId` int(11) NOT NULL,
  KEY `facultyId` (`facultyId`),
  KEY `spId` (`spId`),
  CONSTRAINT `faculties_specializations_ibfk_1` FOREIGN KEY (`facultyId`) REFERENCES `faculties` (`facultyId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `faculties_specializations_ibfk_2` FOREIGN KEY (`spId`) REFERENCES `specializations` (`spId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `faculties_specializations`
--

LOCK TABLES `faculties_specializations` WRITE;
/*!40000 ALTER TABLE `faculties_specializations` DISABLE KEYS */;
INSERT INTO `faculties_specializations` VALUES (1,2),(1,3),(1,4);
/*!40000 ALTER TABLE `faculties_specializations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `grades`
--

DROP TABLE IF EXISTS `grades`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grades`
--

LOCK TABLES `grades` WRITE;
/*!40000 ALTER TABLE `grades` DISABLE KEYS */;
INSERT INTO `grades` VALUES (1,2,2,10,'final'),(2,2,3,10,'final'),(3,2,4,10,'final'),(4,2,5,10,'final'),(5,5,2,10,'final'),(6,5,3,10,'final'),(7,5,4,10,'final'),(8,5,5,10,'final'),(9,10,2,10,'final'),(10,10,3,10,'final'),(11,10,4,10,'final'),(12,10,5,10,'final');
/*!40000 ALTER TABLE `grades` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `groups`
--

DROP TABLE IF EXISTS `groups`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `groups` (
  `groupId` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `spId` int(11) NOT NULL,
  PRIMARY KEY (`groupId`),
  KEY `fk_gr_sp` (`spId`),
  CONSTRAINT `groups_uk` UNIQUE (`name`),
  CONSTRAINT `fk_gr_sp` FOREIGN KEY (`spId`) REFERENCES `specializations` (`spId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `groups`
--

LOCK TABLES `groups` WRITE;
/*!40000 ALTER TABLE `groups` DISABLE KEYS */;
INSERT INTO `groups` VALUES (1,'221',2);
/*!40000 ALTER TABLE `groups` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `solutions`
--

DROP TABLE IF EXISTS `solutions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `solutions` (
  `assignmentId` int(11) NOT NULL,
  `ssId` int(11) NOT NULL,
  `solution` varchar(255) NOT NULL,
  `completed` date NOT NULL,
  PRIMARY KEY (`assignmentId`,`ssId`),
  KEY `fk_solutions_1` (`ssId`),
  CONSTRAINT `solutions_uk` UNIQUE (`assignmentId`,`ssId`),
  CONSTRAINT `fk_solutions_2` FOREIGN KEY (`assignmentId`) REFERENCES `assignments` (`assignmentId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_solutions_1` FOREIGN KEY (`ssId`) REFERENCES `students_specializations` (`ssId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `solutions`
--

LOCK TABLES `solutions` WRITE;
/*!40000 ALTER TABLE `solutions` DISABLE KEYS */;
INSERT INTO `solutions` VALUES (1,2,'solution filename','2011-05-27'),(2,2,'alt filename','2011-05-28');
/*!40000 ALTER TABLE `solutions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `specializations`
--

DROP TABLE IF EXISTS `specializations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `specializations` (
  `spId` int(11) NOT NULL AUTO_INCREMENT,
  `spName` varchar(255) NOT NULL,
  `numberOfYears` int(11) NOT NULL,
  CONSTRAINT `specs_uk` UNIQUE (`spName`),
  PRIMARY KEY (`spId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `specializations`
--

LOCK TABLES `specializations` WRITE;
/*!40000 ALTER TABLE `specializations` DISABLE KEYS */;
INSERT INTO `specializations` VALUES (2,'informatica',3),(3,'matematica',3),(4,'ingineria informatiei',4);
/*!40000 ALTER TABLE `specializations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `specializations_courses`
--

DROP TABLE IF EXISTS `specializations_courses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `specializations_courses` (
  `csId` int(11) NOT NULL AUTO_INCREMENT,
  `spId` int(11) NOT NULL,
  `courseId` int(11) NOT NULL,
  `courseCode` varchar(255) NOT NULL,
  `courseType` varchar(50) NOT NULL,
  `courseCredits` int(11) NOT NULL,
  `semester` int(11) NOT NULL,
  CONSTRAINT `specs_courses_uk` UNIQUE (`courseCode`),
  CONSTRAINT `specs_courses_uk` UNIQUE (`courseId`),
  PRIMARY KEY (`csId`),
  KEY `spId` (`spId`),
  KEY `courseId` (`courseId`),
  CONSTRAINT `specializations_courses_ibfk_1` FOREIGN KEY (`spId`) REFERENCES `specializations` (`spId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `specializations_courses_ibfk_2` FOREIGN KEY (`courseId`) REFERENCES `courses` (`courseId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `specializations_courses`
--

LOCK TABLES `specializations_courses` WRITE;
/*!40000 ALTER TABLE `specializations_courses` DISABLE KEYS */;
INSERT INTO `specializations_courses` VALUES (2,2,1,'BMC-INFO','OBLIGATORIU',6,1),(3,3,1,'BMC-MATE','OBLIGATORIU',6,1),(4,4,1,'BMC-INGI','OBLIGATORIU',6,1),(5,2,2,'ANA-INFO','OBLIGATORIU',6,1),(7,3,2,'ANA-MATE','OBLIGATORIU',6,1),(8,4,2,'ANA-INGI','OBLIGATORIU',6,1),(9,4,3,'FPR-INGI','OBLIGATORIU',6,1),(10,2,3,'FPR-INFO','OBLIGATORIU',6,1),(11,3,3,'FPR-MATE','OBLIGATORIU',6,1);
/*!40000 ALTER TABLE `specializations_courses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `students`
--

DROP TABLE IF EXISTS `students`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `students` (
  `studentId` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(255) NOT NULL,
  `personalCode` varchar(255) NOT NULL,
  `year` int(11) NOT NULL,
  `serialNumber` int(11) NOT NULL,
  CONSTRAINT `students_uk1` UNIQUE (`userName`),
  CONSTRAINT `students_uk2` UNIQUE (`personalCode`),
  CONSTRAINT `students_uk3` UNIQUE (`serialNumber`),
  PRIMARY KEY (`studentId`,`serialNumber`,`personalCode`),
  KEY `userName` (`userName`) USING BTREE,
  CONSTRAINT `students_fk1` FOREIGN KEY (`userName`) REFERENCES `users` (`userName`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `students`
--

LOCK TABLES `students` WRITE;
/*!40000 ALTER TABLE `students` DISABLE KEYS */;
INSERT INTO `students` VALUES (2,'alex','1880607123454',1,10680),(3,'andu','1880607123454',1,10681),(4,'mishu','1880607123454',1,10682),(5,'ovi','1880607123454',1,10683),(19,'oti','1234567890',1,10688);
/*!40000 ALTER TABLE `students` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `students_specializations`
--

DROP TABLE IF EXISTS `students_specializations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `students_specializations` (
  `ssId` int(11) NOT NULL AUTO_INCREMENT,
  `studentId` int(11) NOT NULL,
  `spId` int(11) NOT NULL,
  `groupId` int(11) NOT NULL,
  CONSTRAINT `s_s_uk1` UNIQUE (`spId`,`groupId`),
  CONSTRAINT `s_s_uk2` UNIQUE (`studentId`),
  PRIMARY KEY (`ssId`),
  KEY `spId` (`spId`),
  KEY `studentId` (`studentId`),
  KEY `students_specializations_ibfk_3` (`groupId`),
  CONSTRAINT `students_specializations_ibfk_1` FOREIGN KEY (`studentId`) REFERENCES `students` (`studentId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `students_specializations_ibfk_2` FOREIGN KEY (`spId`) REFERENCES `specializations` (`spId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `students_specializations_ibfk_3` FOREIGN KEY (`groupId`) REFERENCES `groups` (`groupId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `students_specializations`
--

LOCK TABLES `students_specializations` WRITE;
/*!40000 ALTER TABLE `students_specializations` DISABLE KEYS */;
INSERT INTO `students_specializations` VALUES (2,2,2,1),(3,3,2,1),(4,4,2,1),(5,5,2,1),(18,19,2,1);
/*!40000 ALTER TABLE `students_specializations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teachers`
--

DROP TABLE IF EXISTS `teachers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teachers` (
  `teacherId` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(255) NOT NULL,
  `teacherTitle` varchar(255) NOT NULL DEFAULT '',
  CONSTRAINT `teachers_uk` UNIQUE (`userName`),
  PRIMARY KEY (`teacherId`),
  KEY `userName` (`userName`) USING BTREE,
  CONSTRAINT `fk1` FOREIGN KEY (`userName`) REFERENCES `users` (`userName`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teachers`
--

LOCK TABLES `teachers` WRITE;
/*!40000 ALTER TABLE `teachers` DISABLE KEYS */;
INSERT INTO `teachers` VALUES (1,'bobby','Prof.'),(3,'dia','Lector');
/*!40000 ALTER TABLE `teachers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teachers_groups`
--

DROP TABLE IF EXISTS `teachers_groups`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teachers_groups` (
  `tsId` int(11) NOT NULL,
  `groupId` int(11) NOT NULL,
  KEY `fk_teachers_groups_1` (`tsId`),
  KEY `fk_teachers_groups_2` (`groupId`),
  CONSTRAINT `teachers_groups_uk` UNIQUE (`tsId`,`groupId`),
  CONSTRAINT `fk_teachers_groups_1` FOREIGN KEY (`tsId`) REFERENCES `teachers_spec` (`tsId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_teachers_groups_2` FOREIGN KEY (`groupId`) REFERENCES `groups` (`groupId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teachers_groups`
--

LOCK TABLES `teachers_groups` WRITE;
/*!40000 ALTER TABLE `teachers_groups` DISABLE KEYS */;
INSERT INTO `teachers_groups` VALUES (1,1);
/*!40000 ALTER TABLE `teachers_groups` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teachers_spec`
--

DROP TABLE IF EXISTS `teachers_spec`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teachers_spec` (
  `tsId` int(11) NOT NULL,
  `teacherId` int(11) NOT NULL,
  `csId` int(11) NOT NULL,
  PRIMARY KEY (`tsId`),
  KEY `csId` (`csId`),
  KEY `teacherId` (`teacherId`),
  CONSTRAINT `teachers_specrs_uk` UNIQUE (`csId`,`teacherId`),
  CONSTRAINT `teachers_spec_ibfk_1` FOREIGN KEY (`teacherId`) REFERENCES `teachers` (`teacherId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `teachers_spec_ibfk_2` FOREIGN KEY (`csId`) REFERENCES `specializations_courses` (`csId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teachers_spec`
--

LOCK TABLES `teachers_spec` WRITE;
/*!40000 ALTER TABLE `teachers_spec` DISABLE KEYS */;
INSERT INTO `teachers_spec` VALUES (1,1,2),(2,3,2);
/*!40000 ALTER TABLE `teachers_spec` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `firstName` varchar(255) DEFAULT NULL,
  `lastName` varchar(255) DEFAULT NULL,
  `userName` varchar(255) NOT NULL DEFAULT '',
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`userName`),
  UNIQUE KEY `UserName` (`userName`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 PACK_KEYS=1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES ('Adrian','Bunta','adi','1a1dc91c907325c69271ddf0c944bc72','admin'),('Alexandru','Suciu','alex','1a1dc91c907325c69271ddf0c944bc72','stud'),('Andrei','Suciu','andu','1a1dc91c907325c69271ddf0c944bc72','stud'),('Bot-Rus','Rares','bobby','1a1dc91c907325c69271ddf0c944bc72','prof'),('Daniel','Dudas','dani','1a1dc91c907325c69271ddf0c944bc72','admin'),('Bujorean','Diana','dia','1a1dc91c907325c69271ddf0c944bc72','prof'),('Mihai','Suciu','mishu','1a1dc91c907325c69271ddf0c944bc72','stud'),('Bogdan','Mihut','myh','1a1dc91c907325c69271ddf0c944bc72','admin'),('Otniel','Nicola','oti','1a1dc91c907325c69271ddf0c944bc72','stud'),('Ovidiu','Suciu','ovi','1a1dc91c907325c69271ddf0c944bc72','stud');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2011-05-31  2:30:56
