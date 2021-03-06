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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
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
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
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
  UNIQUE KEY `contracts_uk` (`spId`,`ssId`),
  KEY `spId` (`spId`),
  KEY `ssId` (`ssId`),
  KEY `ssId_2` (`ssId`),
  CONSTRAINT `contracts_ibfk_1` FOREIGN KEY (`spId`) REFERENCES `specializations` (`spId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `contracts_ibfk_2` FOREIGN KEY (`ssId`) REFERENCES `students_specializations` (`ssId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contracts`
--

LOCK TABLES `contracts` WRITE;
/*!40000 ALTER TABLE `contracts` DISABLE KEYS */;
INSERT INTO `contracts` VALUES (1,2,2),(2,3,2),(3,4,2),(4,5,2);
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
  UNIQUE KEY `course_contract_uk` (`csId`,`contractId`),
  KEY `contractId` (`contractId`),
  KEY `csId` (`csId`),
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
  UNIQUE KEY `coursematerials_uk1` (`csId`,`fileName`),
  KEY `fk_coursematerials_1` (`csId`),
  CONSTRAINT `fk_coursematerials_1` FOREIGN KEY (`csId`) REFERENCES `specializations_courses` (`csId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
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
  PRIMARY KEY (`courseId`),
  UNIQUE KEY `courses_uk` (`courseName`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `courses`
--

LOCK TABLES `courses` WRITE;
/*!40000 ALTER TABLE `courses` DISABLE KEYS */;
INSERT INTO `courses` VALUES (2,'Analiza'),(1,'BMC'),(3,'FP'),(6,'Ingineria SistemelorSoft');
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
  PRIMARY KEY (`examId`),
  UNIQUE KEY `exams_uk` (`csId`,`type`,`date`),
  KEY `new_fk_constraint` (`csId`),
  CONSTRAINT `new_fk_constraint` FOREIGN KEY (`csId`) REFERENCES `specializations_courses` (`csId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1 ROW_FORMAT=FIXED;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exams`
--

LOCK TABLES `exams` WRITE;
/*!40000 ALTER TABLE `exams` DISABLE KEYS */;
INSERT INTO `exams` VALUES (5,'2011-05-27',2,'final'),(4,'2011-05-24',5,'final'),(3,'2011-05-21',10,'final');
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
  PRIMARY KEY (`facultyId`),
  UNIQUE KEY `faculties_uk` (`facultyName`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `faculties`
--

LOCK TABLES `faculties` WRITE;
/*!40000 ALTER TABLE `faculties` DISABLE KEYS */;
INSERT INTO `faculties` VALUES (1,'Mate-Info','Str. Mihail Kogalniceanu Nr. 1'),(2,'Fizica','Str. Mihail Kogalniceanu Nr. 1'),(3,'Chimie Si Inginerie Chimica','Str. Mihail Kogalniceanu Nr. 1'),(4,'Biologie Si Geologie','Str. Mihail Kogalniceanu Nr. 1'),(5,'Geografie','Str. Mihail Kogalniceanu Nr. 1'),(6,'Istorie Si Filosofie','Str. Mihail Kogalniceanu Nr. 1'),(7,'Litere','Str. Mihail Kogalniceanu Nr. 1');
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
INSERT INTO `faculties_specializations` VALUES (1,2),(1,3),(1,4),(6,7),(6,8),(6,9),(6,10),(2,11),(2,12),(2,13),(3,14),(3,15),(3,16),(4,17),(4,18),(4,19),(5,20),(5,21),(5,22),(7,23),(7,24),(7,25),(7,26);
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
  CONSTRAINT `grades_ibfk_1` FOREIGN KEY (`csId`) REFERENCES `specializations_courses` (`csId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `grades_ibfk_2` FOREIGN KEY (`ssId`) REFERENCES `students_specializations` (`ssId`) ON DELETE CASCADE ON UPDATE CASCADE
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
  UNIQUE KEY `groups_uk` (`name`),
  KEY `fk_gr_sp` (`spId`),
  CONSTRAINT `fk_gr_sp` FOREIGN KEY (`spId`) REFERENCES `specializations` (`spId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `groups`
--

LOCK TABLES `groups` WRITE;
/*!40000 ALTER TABLE `groups` DISABLE KEYS */;
INSERT INTO `groups` VALUES (1,'221',2),(2,'222',2),(3,'223',2),(4,'231',4),(5,'232',4),(6,'233',4),(7,'211',3),(9,'213',3),(10,'212',3),(11,'111',7),(12,'112',7),(13,'113',7),(14,'121',8),(15,'122',8),(16,'123',8),(17,'131',9),(18,'133',9),(19,'141',10),(20,'142',10),(21,'143',10),(22,'311',11),(23,'312',11),(24,'321',12),(25,'322',12),(26,'323',12),(27,'331',13),(28,'332',13),(29,'333',13),(30,'411',14),(31,'412',14),(32,'413',14),(33,'421',15),(34,'422',15),(35,'423',15),(36,'431',16),(37,'432',16),(38,'433',16),(39,'511',17),(40,'512',17),(41,'521',18),(42,'522',18),(43,'523',18),(44,'611',20),(45,'612',20),(46,'613',20),(47,'621',21),(48,'622',21),(49,'623',21),(50,'631',22),(51,'711',23),(52,'712',23),(53,'713',23),(54,'721',24),(55,'722',24),(56,'723',24),(57,'731',25);
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
  UNIQUE KEY `solutions_uk` (`assignmentId`,`ssId`),
  KEY `fk_solutions_1` (`ssId`),
  CONSTRAINT `fk_solutions_1` FOREIGN KEY (`ssId`) REFERENCES `students_specializations` (`ssId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_solutions_2` FOREIGN KEY (`assignmentId`) REFERENCES `assignments` (`assignmentId`) ON DELETE CASCADE ON UPDATE CASCADE
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
  PRIMARY KEY (`spId`),
  UNIQUE KEY `specs_uk` (`spName`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `specializations`
--

LOCK TABLES `specializations` WRITE;
/*!40000 ALTER TABLE `specializations` DISABLE KEYS */;
INSERT INTO `specializations` VALUES (2,'Informatica',3),(3,'Matematica',3),(4,'Ingineria informatiei',4),(7,'Istorie',3),(8,'Istoria Artei',3),(9,'Arheologie',3),(10,'Filosofie',3),(11,'Fizica',3),(12,'Stiinte Ingineresti',3),(13,'Stiinta mediului',3),(14,'Chimie',3),(15,'Chimia mediului',3),(16,'Inginerie Chimica',3),(17,'Biologie',3),(18,'Geologie',3),(19,'Inginerie Geologica',3),(20,'Geografie',3),(21,'Geografia Turismului',3),(22,'Hidrologie Si Meteorologie',3),(23,'Limba si literatura romana',3),(24,'Literatura universala si comparata',3),(25,'Limbi clasice',3),(26,'Limbi moderne aplicate ',3);
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
  UNIQUE KEY `specs_courses_uk1` (`courseCode`),
  UNIQUE KEY `specs_courses_uk2` (`csId`,`spId`),
  KEY `spId` (`spId`),
  KEY `courseId` (`courseId`),
  CONSTRAINT `specializations_courses_ibfk_1` FOREIGN KEY (`spId`) REFERENCES `specializations` (`spId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `specializations_courses_ibfk_2` FOREIGN KEY (`courseId`) REFERENCES `courses` (`courseId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
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
  PRIMARY KEY (`studentId`,`serialNumber`,`personalCode`),
  UNIQUE KEY `students_uk1` (`userName`),
  UNIQUE KEY `students_uk2` (`personalCode`),
  UNIQUE KEY `students_uk3` (`serialNumber`),
  KEY `userName` (`userName`) USING BTREE,
  CONSTRAINT `students_fk1` FOREIGN KEY (`userName`) REFERENCES `users` (`userName`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `students`
--

LOCK TABLES `students` WRITE;
/*!40000 ALTER TABLE `students` DISABLE KEYS */;
INSERT INTO `students` VALUES (2,'alex','1880607123454',1,10680),(3,'andu','1880607123455',1,10681),(4,'mishu','1880607123456',1,10682),(5,'ovi','1880607123457',1,10683);
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
  PRIMARY KEY (`ssId`),
  UNIQUE KEY `s_s_uk1` (`spId`,`groupId`,`studentId`),
  UNIQUE KEY `s_s_uk2` (`studentId`),
  KEY `spId` (`spId`),
  KEY `studentId` (`studentId`),
  KEY `students_specializations_ibfk_3` (`groupId`),
  CONSTRAINT `students_specializations_ibfk_1` FOREIGN KEY (`studentId`) REFERENCES `students` (`studentId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `students_specializations_ibfk_2` FOREIGN KEY (`spId`) REFERENCES `specializations` (`spId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `students_specializations_ibfk_3` FOREIGN KEY (`groupId`) REFERENCES `groups` (`groupId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `students_specializations`
--

LOCK TABLES `students_specializations` WRITE;
/*!40000 ALTER TABLE `students_specializations` DISABLE KEYS */;
INSERT INTO `students_specializations` VALUES (2,2,2,1),(3,3,2,1),(4,4,2,1),(5,5,2,1);
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
  UNIQUE KEY `teachers_uk` (`userName`),
  KEY `userName` (`userName`) USING BTREE,
  CONSTRAINT `fk1` FOREIGN KEY (`userName`) REFERENCES `users` (`userName`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teachers`
--

LOCK TABLES `teachers` WRITE;
/*!40000 ALTER TABLE `teachers` DISABLE KEYS */;
INSERT INTO `teachers` VALUES (1,'bobby','Prof.'),(3,'dia','Lector'),(5,'oti','Prof. Doctor ');
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
  UNIQUE KEY `teachers_groups_uk` (`tsId`,`groupId`),
  KEY `fk_teachers_groups_1` (`tsId`),
  KEY `fk_teachers_groups_2` (`groupId`),
  CONSTRAINT `fk_teachers_groups_1` FOREIGN KEY (`tsId`) REFERENCES `teachers_spec` (`tsId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_teachers_groups_2` FOREIGN KEY (`groupId`) REFERENCES `groups` (`groupId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teachers_groups`
--

LOCK TABLES `teachers_groups` WRITE;
/*!40000 ALTER TABLE `teachers_groups` DISABLE KEYS */;
INSERT INTO `teachers_groups` VALUES (1,1),(6,1);
/*!40000 ALTER TABLE `teachers_groups` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teachers_spec`
--

DROP TABLE IF EXISTS `teachers_spec`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teachers_spec` (
  `tsId` int(11) NOT NULL AUTO_INCREMENT,
  `teacherId` int(11) NOT NULL,
  `csId` int(11) NOT NULL,
  PRIMARY KEY (`tsId`),
  UNIQUE KEY `teachers_specrs_uk` (`csId`,`teacherId`),
  KEY `csId` (`csId`),
  KEY `teacherId` (`teacherId`),
  CONSTRAINT `teachers_spec_ibfk_1` FOREIGN KEY (`teacherId`) REFERENCES `teachers` (`teacherId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `teachers_spec_ibfk_2` FOREIGN KEY (`csId`) REFERENCES `specializations_courses` (`csId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teachers_spec`
--

LOCK TABLES `teachers_spec` WRITE;
/*!40000 ALTER TABLE `teachers_spec` DISABLE KEYS */;
INSERT INTO `teachers_spec` VALUES (1,1,2),(2,3,2),(6,5,2);
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
INSERT INTO `users` VALUES ('Adrian','Bunta','adi','1a1dc91c907325c69271ddf0c944bc72','admin'),('Alexandru','Suciu','alex','1a1dc91c907325c69271ddf0c944bc72','stud'),('Andrei','Suciu','andu','1a1dc91c907325c69271ddf0c944bc72','stud'),('Bot-Rus','Rares','bobby','1a1dc91c907325c69271ddf0c944bc72','prof'),('Daniel','Dudas','dani','1a1dc91c907325c69271ddf0c944bc72','admin'),('Bujorean','Diana','dia','1a1dc91c907325c69271ddf0c944bc72','prof'),('Mihai','Suciu','mishu','1a1dc91c907325c69271ddf0c944bc72','stud'),('Bogdan','Mihut','myh','1a1dc91c907325c69271ddf0c944bc72','admin'),('Otniel','Nicola','oti','1a1dc91c907325c69271ddf0c944bc72','prof'),('Ovidiu','Suciu','ovi','1a1dc91c907325c69271ddf0c944bc72','stud');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'pc221'
--
/*!50003 DROP PROCEDURE IF EXISTS `announce_for_course` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = latin1 */ ;
/*!50003 SET character_set_results = latin1 */ ;
/*!50003 SET collation_connection  = latin1_swedish_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`localhost`*/ /*!50003 PROCEDURE `announce_for_course`(IN param6 INT)
BEGIN
	SELECT * FROM announcement a 
	inner join teachers t on a.teacherId = t.teacherId
	where csid = param6;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `courses_for_contract` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = latin1 */ ;
/*!50003 SET character_set_results = latin1 */ ;
/*!50003 SET collation_connection  = latin1_swedish_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`localhost`*/ /*!50003 PROCEDURE `courses_for_contract`(IN param9 INT)
BEGIN
	select courseCode from 
	contracts_data cd inner join specializations_courses sc 
	on cd.csId=sc.csId 
	where contractId = param9;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `courses_for_specialty` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = latin1 */ ;
/*!50003 SET character_set_results = latin1 */ ;
/*!50003 SET collation_connection  = latin1_swedish_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`localhost`*/ /*!50003 PROCEDURE `courses_for_specialty`(IN param4 INT)
BEGIN
	select s.csId, c.courseName, s.courseCode, s.courseType, s.courseCredits, s.semester 
	from courses c inner join specializations_courses s on c.courseId = s.courseId 
	where s.spId = param4;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `courses_for_teacher` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`localhost`*/ /*!50003 PROCEDURE `courses_for_teacher`(IN param10 VARCHAR(255))
BEGIN
	select sc.courseCode 
	from specializations_courses sc inner join teachers_spec ts  on sc.csId = ts.csId
	inner join teachers t on ts.teacherId = t.teacherId
	inner join users u on u.userName = t.userName
	where u.username = param10;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `grades_for_exam` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = latin1 */ ;
/*!50003 SET character_set_results = latin1 */ ;
/*!50003 SET collation_connection  = latin1_swedish_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`localhost`*/ /*!50003 PROCEDURE `grades_for_exam`(IN param3 INT)
BEGIN
	select  userName, grade 
	from students_specializations ss
	inner join grades g on g.ssId=ss.ssId 
	inner join exams e on g.csId=e.csId and g.type = e.type
	inner join students s on s.studentId=ss.studentId
	where examId = param3; 
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `groups_for_teacher` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = latin1 */ ;
/*!50003 SET character_set_results = latin1 */ ;
/*!50003 SET collation_connection  = latin1_swedish_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`localhost`*/ /*!50003 PROCEDURE `groups_for_teacher`(IN param7 VARCHAR(255))
BEGIN
	select g.name 
	from groups g 
	inner join teachers_groups tg on g.groupId = tg.groupId
	inner join teachers_spec ts  on tg.tsId = ts.tsid 
	inner join teachers t on ts.teacherId = t.teacherId
	where t.userName = param7;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `solutions_for_assign` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = latin1 */ ;
/*!50003 SET character_set_results = latin1 */ ;
/*!50003 SET collation_connection  = latin1_swedish_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`localhost`*/ /*!50003 PROCEDURE `solutions_for_assign`(IN param2 INT)
BEGIN
	select solution, completed, userName 
	from solutions sl inner join students_specializations ss on sl.ssId = ss.ssId 
	inner join students st on ss.studentId = st.studentId 
	where sl.assignmentId = param2;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `specialties_for_faculty` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`localhost`*/ /*!50003 PROCEDURE `specialties_for_faculty`(IN param5 INT)
BEGIN
	select * from specializations 
	where spId in (
	select spId from faculties_specializations 
	where facultyId = param5); 
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `students_for_group` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = latin1 */ ;
/*!50003 SET character_set_results = latin1 */ ;
/*!50003 SET collation_connection  = latin1_swedish_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`localhost`*/ /*!50003 PROCEDURE `students_for_group`(IN param8 INT)
BEGIN
	select c.contractId,ss.ssId,ss.studentId,s.serialNumber,
				 s.personalCode,u.userName,s.year from
	groups g inner join students_specializations ss on g.spId=ss.spId
	inner join students s on ss.studentId=s.studentId 
	inner join users u on s.userName=u.userName 
	inner join contracts c on c.ssId=ss.ssId
	where g.groupId=param8;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `teachers_for_course` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = latin1 */ ;
/*!50003 SET character_set_results = latin1 */ ;
/*!50003 SET collation_connection  = latin1_swedish_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`localhost`*/ /*!50003 PROCEDURE `teachers_for_course`(IN param1 INT)
BEGIN
	select userName 
	from teachers t inner join teachers_spec ts on t.teacherId = ts.teacherId
	inner join specializations_courses s on ts.csId = s.csId 
	where s.csId = param1;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2011-06-01  3:44:44
