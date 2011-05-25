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
  `courseId` int(11) NOT NULL,
  PRIMARY KEY (`announcementId`),
  KEY `ann_fk1` (`teacherId`),
  KEY `ann_fk2` (`courseId`),
  CONSTRAINT `ann_fk1` FOREIGN KEY (`teacherId`) REFERENCES `teachers` (`teacherId`),
  CONSTRAINT `ann_fk2` FOREIGN KEY (`courseId`) REFERENCES `courses` (`courseId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `announcement`
--

LOCK TABLES `announcement` WRITE;
/*!40000 ALTER TABLE `announcement` DISABLE KEYS */;
INSERT INTO `announcement` VALUES ('primul anunt','aici este continutul primului anunt','2011-05-24',1,1,1);
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
  PRIMARY KEY (`assignmentId`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assignments`
--

LOCK TABLES `assignments` WRITE;
/*!40000 ALTER TABLE `assignments` DISABLE KEYS */;
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
  CONSTRAINT `contracts_ibfk_1` FOREIGN KEY (`spId`) REFERENCES `specializations` (`spId`),
  CONSTRAINT `contracts_ibfk_2` FOREIGN KEY (`ssId`) REFERENCES `students_specializations` (`ssId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contracts`
--

LOCK TABLES `contracts` WRITE;
/*!40000 ALTER TABLE `contracts` DISABLE KEYS */;
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
  CONSTRAINT `contracts_data_ibfk_1` FOREIGN KEY (`contractId`) REFERENCES `contracts` (`contractId`),
  CONSTRAINT `contracts_data_ibfk_2` FOREIGN KEY (`csId`) REFERENCES `specializations_courses` (`csId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contracts_data`
--

LOCK TABLES `contracts_data` WRITE;
/*!40000 ALTER TABLE `contracts_data` DISABLE KEYS */;
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
  PRIMARY KEY (`cmId`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `coursematerials`
--

LOCK TABLES `coursematerials` WRITE;
/*!40000 ALTER TABLE `coursematerials` DISABLE KEYS */;
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
-- Table structure for table `faculties`
--

DROP TABLE IF EXISTS `faculties`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `faculties` (
  `facultyId` int(11) NOT NULL AUTO_INCREMENT,
  `facultyName` varchar(255) DEFAULT NULL,
  `address` varchar(255) NOT NULL,
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
  CONSTRAINT `faculties_specializations_ibfk_1` FOREIGN KEY (`facultyId`) REFERENCES `faculties` (`facultyId`),
  CONSTRAINT `faculties_specializations_ibfk_2` FOREIGN KEY (`spId`) REFERENCES `specializations` (`spId`)
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
-- Table structure for table `grade`
--

DROP TABLE IF EXISTS `grade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grade`
--

LOCK TABLES `grade` WRITE;
/*!40000 ALTER TABLE `grade` DISABLE KEYS */;
/*!40000 ALTER TABLE `grade` ENABLE KEYS */;
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
  `solution` int(11) NOT NULL,
  PRIMARY KEY (`assignmentId`,`ssId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `solutions`
--

LOCK TABLES `solutions` WRITE;
/*!40000 ALTER TABLE `solutions` DISABLE KEYS */;
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
  PRIMARY KEY (`csId`),
  KEY `spId` (`spId`),
  KEY `courseId` (`courseId`),
  CONSTRAINT `specializations_courses_ibfk_1` FOREIGN KEY (`spId`) REFERENCES `specializations` (`spId`),
  CONSTRAINT `specializations_courses_ibfk_2` FOREIGN KEY (`courseId`) REFERENCES `courses` (`courseId`)
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
  PRIMARY KEY (`studentId`),
  KEY `userName` (`userName`) USING BTREE,
  CONSTRAINT `students_fk1` FOREIGN KEY (`userName`) REFERENCES `users` (`userName`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `students`
--

LOCK TABLES `students` WRITE;
/*!40000 ALTER TABLE `students` DISABLE KEYS */;
INSERT INTO `students` VALUES (2,'alex','1880607123454'),(3,'andu','1880607123454'),(4,'mishu','1880607123454'),(5,'ovi','1880607123454');
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
  `serialNumber` int(11) NOT NULL,
  `group` int(11) NOT NULL DEFAULT '221',
  `year` int(11) NOT NULL DEFAULT '2',
  PRIMARY KEY (`ssId`),
  KEY `spId` (`spId`),
  KEY `studentId` (`studentId`),
  CONSTRAINT `students_specializations_ibfk_1` FOREIGN KEY (`studentId`) REFERENCES `students` (`studentId`),
  CONSTRAINT `students_specializations_ibfk_2` FOREIGN KEY (`spId`) REFERENCES `specializations` (`spId`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `students_specializations`
--

LOCK TABLES `students_specializations` WRITE;
/*!40000 ALTER TABLE `students_specializations` DISABLE KEYS */;
INSERT INTO `students_specializations` VALUES (2,2,2,10680,221,2),(3,3,2,10681,221,2),(4,4,2,10682,221,2),(5,5,2,10684,221,2),(6,5,2,10686,221,2);
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
  PRIMARY KEY (`teacherId`),
  KEY `userName` (`userName`) USING BTREE,
  CONSTRAINT `fk1` FOREIGN KEY (`userName`) REFERENCES `users` (`userName`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teachers`
--

LOCK TABLES `teachers` WRITE;
/*!40000 ALTER TABLE `teachers` DISABLE KEYS */;
INSERT INTO `teachers` VALUES (1,'bobby','Prof.'),(2,'marcel','Asistent'),(3,'dia','Lector');
/*!40000 ALTER TABLE `teachers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teachers_spec`
--

DROP TABLE IF EXISTS `teachers_spec`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teachers_spec` (
  `teacherId` int(11) NOT NULL,
  `csId` int(11) NOT NULL,
  KEY `csId` (`csId`),
  KEY `teacherId` (`teacherId`),
  CONSTRAINT `teachers_spec_ibfk_1` FOREIGN KEY (`teacherId`) REFERENCES `teachers` (`teacherId`),
  CONSTRAINT `teachers_spec_ibfk_2` FOREIGN KEY (`csId`) REFERENCES `specializations_courses` (`csId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teachers_spec`
--

LOCK TABLES `teachers_spec` WRITE;
/*!40000 ALTER TABLE `teachers_spec` DISABLE KEYS */;
INSERT INTO `teachers_spec` VALUES (1,2),(2,2),(3,2);
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
INSERT INTO `users` VALUES ('Adrian','Bunta','adi','1a1dc91c907325c69271ddf0c944bc72','admin'),('Alexandru','Suciu','alex','1a1dc91c907325c69271ddf0c944bc72','stud'),('Andrei','Suciu','andu','1a1dc91c907325c69271ddf0c944bc72','stud'),('Bot-Rus','Rares','bobby','1a1dc91c907325c69271ddf0c944bc72','prof'),('Daniel','Dudas','dani','1a1dc91c907325c69271ddf0c944bc72','admin'),('Bujorean','Diana','dia','1a1dc91c907325c69271ddf0c944bc72','prof'),('Codrea','Marcel','marcel','1a1dc91c907325c69271ddf0c944bc72','prof'),('Mihai','Suciu','mishu','1a1dc91c907325c69271ddf0c944bc72','stud'),('Bogdan','Mihut','myh','1a1dc91c907325c69271ddf0c944bc72','admin'),('Ovidiu','Suciu','ovi','1a1dc91c907325c69271ddf0c944bc72','stud');
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

-- Dump completed on 2011-05-25 10:16:29
