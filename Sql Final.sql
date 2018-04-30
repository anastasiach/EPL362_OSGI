-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: epl362
-- ------------------------------------------------------
-- Server version	5.7.19-log

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
-- Table structure for table `branch`
--

DROP TABLE IF EXISTS `branch`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `branch` (
  `BranchID` varchar(45) NOT NULL,
  `Name` varchar(45) NOT NULL,
  `Address` varchar(45) NOT NULL,
  `City` varchar(45) NOT NULL,
  `DropIn` tinyint(4) DEFAULT NULL,
  `PreArranged` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`BranchID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `branch`
--

LOCK TABLES `branch` WRITE;
/*!40000 ALTER TABLE `branch` DISABLE KEYS */;
INSERT INTO `branch` VALUES ('1','BranchName','dfgdfg','dfg',0,1);
/*!40000 ALTER TABLE `branch` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `case`
--

DROP TABLE IF EXISTS `case`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `case` (
  `CaseID` int(11) NOT NULL,
  `Name` varchar(45) NOT NULL,
  PRIMARY KEY (`CaseID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `case`
--

LOCK TABLES `case` WRITE;
/*!40000 ALTER TABLE `case` DISABLE KEYS */;
INSERT INTO `case` VALUES (1,'CaseName'),(2,'Case2');
/*!40000 ALTER TABLE `case` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `client`
--

DROP TABLE IF EXISTS `client`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `client` (
  `ClientID` int(11) NOT NULL,
  `FirstName` varchar(45) NOT NULL,
  `LastName` varchar(45) NOT NULL,
  `CaseID` int(11) NOT NULL,
  `Transaction` varchar(45) NOT NULL,
  `RiskStatus` tinyint(4) DEFAULT NULL,
  `UpdatedRecord` date NOT NULL,
  `StaffID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ClientID`),
  KEY `fcase_idx` (`CaseID`),
  KEY `fstaffc_idx` (`StaffID`),
  CONSTRAINT `fcase` FOREIGN KEY (`CaseID`) REFERENCES `case` (`CaseID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fstaffc` FOREIGN KEY (`StaffID`) REFERENCES `staff` (`StaffID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client`
--

LOCK TABLES `client` WRITE;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
INSERT INTO `client` VALUES (1,'Anastasia','Xeimona',1,'dfdfgsdfg',1,'0000-00-00',1),(2,'Marina','Pashiali',1,'sdfdjsfoj',0,'2018-04-10',NULL);
/*!40000 ALTER TABLE `client` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clientrecord`
--

DROP TABLE IF EXISTS `clientrecord`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `clientrecord` (
  `RecordID` int(11) NOT NULL AUTO_INCREMENT,
  `ClientID` int(11) NOT NULL,
  `CaseID` int(11) NOT NULL,
  `Date` date NOT NULL,
  `Recommentation` varchar(1000) DEFAULT NULL,
  `LegalOpinion` varchar(1000) DEFAULT NULL,
  `LegalStrategyID` int(11) DEFAULT NULL,
  `Comments` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`RecordID`),
  KEY `fclientr_idx` (`ClientID`),
  KEY `fcaser_idx` (`CaseID`),
  KEY `fclientr_idx1` (`LegalStrategyID`),
  CONSTRAINT `fcaser` FOREIGN KEY (`CaseID`) REFERENCES `case` (`CaseID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fclientr` FOREIGN KEY (`ClientID`) REFERENCES `client` (`ClientID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientrecord`
--

LOCK TABLES `clientrecord` WRITE;
/*!40000 ALTER TABLE `clientrecord` DISABLE KEYS */;
INSERT INTO `clientrecord` VALUES (1,1,1,'2018-04-10','r1','l1',0,'Comment'),(2,1,1,'2018-04-19','r2','null',0,'null'),(3,1,2,'2018-04-15','r3','l3',0,'null'),(4,1,1,'2018-04-20','r4','l4',1,'Commeeeeeeeeents'),(5,1,1,'2018-04-28','r4','l4',1,'Commeeeeeeeeents'),(6,1,1,'2018-04-28','r5','l4',1,'Commeeeeeeeeents'),(7,1,1,'2018-04-28','r5','l5',1,'Commeeeeeeeeents'),(8,1,1,'2018-04-28','r6','l6',1,'Hellooooo'),(9,1,1,'2018-04-28','r6','l6',1,'Hellooooo'),(10,1,1,'2018-04-28','r6','l6',1,'Hellooooo'),(11,1,1,'2018-04-28','r6','l6',1,'Hellooooo!!!!'),(12,1,1,'2018-04-30','r6','l6',1,'Hellooooo'),(13,2,1,'2018-04-30','r6','l6',1,'Comments!!! ');
/*!40000 ALTER TABLE `clientrecord` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `legalstrategy`
--

DROP TABLE IF EXISTS `legalstrategy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `legalstrategy` (
  `LegalStrategyID` int(11) NOT NULL,
  `Name` varchar(45) NOT NULL,
  `Side-effects` varchar(1000) NOT NULL,
  PRIMARY KEY (`LegalStrategyID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `legalstrategy`
--

LOCK TABLES `legalstrategy` WRITE;
/*!40000 ALTER TABLE `legalstrategy` DISABLE KEYS */;
INSERT INTO `legalstrategy` VALUES (1,'StrategyName','Effects');
/*!40000 ALTER TABLE `legalstrategy` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `randevou`
--

DROP TABLE IF EXISTS `randevou`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `randevou` (
  `AppointmentID` int(11) NOT NULL AUTO_INCREMENT,
  `Date` date NOT NULL,
  `Time` time NOT NULL,
  `ClientID` int(11) NOT NULL,
  `StaffID` int(11) NOT NULL,
  `BranchID` varchar(45) NOT NULL,
  `DropIn` tinyint(4) DEFAULT NULL,
  `Canceled` tinyint(4) DEFAULT NULL,
  `Updated` tinyint(4) DEFAULT NULL,
  `Append` tinyint(4) DEFAULT NULL,
  `CaseID` int(11) DEFAULT NULL,
  PRIMARY KEY (`AppointmentID`),
  KEY `fclienta_idx` (`ClientID`),
  KEY `fstaffa_idx` (`StaffID`),
  KEY `fbranch_idx` (`BranchID`),
  KEY `fcasea_idx` (`CaseID`),
  CONSTRAINT `FOREIGNKEY` FOREIGN KEY (`BranchID`) REFERENCES `branch` (`BranchID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fcasea` FOREIGN KEY (`CaseID`) REFERENCES `case` (`CaseID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fclienta` FOREIGN KEY (`ClientID`) REFERENCES `client` (`ClientID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fstaffa` FOREIGN KEY (`StaffID`) REFERENCES `staff` (`StaffID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `randevou`
--

LOCK TABLES `randevou` WRITE;
/*!40000 ALTER TABLE `randevou` DISABLE KEYS */;
INSERT INTO `randevou` VALUES (1,'2018-04-18','13:40:00',1,1,'1',0,0,0,1,1),(8,'2018-03-23','00:00:08',1,1,'1',0,0,0,0,1),(10,'2018-05-30','20:00:08',1,1,'1',0,0,0,0,1),(11,'2018-05-14','00:00:08',1,1,'1',0,0,0,0,2),(13,'2018-03-14','00:00:08',1,1,'1',0,0,0,0,2),(14,'2018-04-29','00:00:09',1,1,'1',1,0,0,0,1),(15,'2018-04-30','18:00:00',1,1,'1',0,0,0,0,1),(16,'2018-05-02','00:00:13',2,1,'1',0,0,0,0,1),(17,'2018-04-30','18:30:00',2,1,'1',0,0,0,0,2);
/*!40000 ALTER TABLE `randevou` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `staff`
--

DROP TABLE IF EXISTS `staff`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `staff` (
  `StaffID` int(11) NOT NULL,
  `FirstName` varchar(45) NOT NULL,
  `LastName` varchar(45) NOT NULL,
  `Username` varchar(45) NOT NULL,
  `Password` varchar(45) NOT NULL,
  `Email` varchar(45) DEFAULT NULL,
  `BranchID` varchar(45) NOT NULL,
  `Lawyer` tinyint(4) NOT NULL,
  `Secretary` tinyint(4) NOT NULL,
  `Receptionist` tinyint(4) NOT NULL,
  `Manager` tinyint(4) NOT NULL,
  PRIMARY KEY (`StaffID`),
  KEY `fbranchs_idx` (`BranchID`),
  CONSTRAINT `fbranchs` FOREIGN KEY (`BranchID`) REFERENCES `branch` (`BranchID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `staff`
--

LOCK TABLES `staff` WRITE;
/*!40000 ALTER TABLE `staff` DISABLE KEYS */;
INSERT INTO `staff` VALUES (1,'nasia','yiannaki','ayiann02','123','nasia@gmail.com','1',1,0,0,0),(2,'antonia','savvia','asavvi02','123','anto@gmail.com','1',0,1,0,0),(3,'marina','pashiali','mpashi01','123','mar@gmail.com','1',0,0,1,0),(4,'anastasia','chimona','acheim01','123','anas@gmail.com','1',0,0,0,1);
/*!40000 ALTER TABLE `staff` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-04-30 18:27:17
