CREATE DATABASE  IF NOT EXISTS `final` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `final`;
-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: info5100jiaf.mysql.database.azure.com    Database: final
-- ------------------------------------------------------
-- Server version	5.6.47.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `flight`
--

DROP TABLE IF EXISTS `flight`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `flight` (
  `idFlight` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '/^[A-Z\\d]{2}\\d{3,4}$/',
  `idCompany` int(11) NOT NULL,
  `timeArrival` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `timeDuration` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `Status` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT 'normal',
  `seatList` mediumtext COLLATE utf8mb4_unicode_ci,
  `idParkingLot` int(4) DEFAULT '0',
  `DepartureOrArrival` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `onGround` tinyint(4) DEFAULT NULL,
  `timeDeparture` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `airport` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`idFlight`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flight`
--

LOCK TABLES `flight` WRITE;
/*!40000 ALTER TABLE `flight` DISABLE KEYS */;
INSERT INTO `flight` VALUES ('AA1243',15,'2022-12-13 11:30',NULL,'normal','10,1000,90,800,AA12430B,AA12431B,AA12432B,AA12433B,AA12434B,AA12435B,AA12436B,AA12437B,AA12438B,AA12439B,AA124310B,AA12431E,AA12432E,AA12433E,AA12434E,AA12435E,AA12436E,AA12437E,AA12438E,AA12439E,AA124310E,AA124311E,AA124312E,AA124313E,AA124314E,AA124315E,AA124316E,AA124317E,AA124318E,AA124319E,AA124320E,AA124321E,AA124322E,AA124323E,AA124324E,AA124325E,AA124326E,AA124327E,AA124328E,AA124329E,AA124330E,AA124331E,AA124332E,AA124333E,AA124334E,AA124335E,AA124336E,AA124337E,AA124338E,AA124339E,AA124340E,AA124341E,AA124342E,AA124343E,AA124344E,AA124345E,AA124346E,AA124347E,AA124348E,AA124349E,AA124350E,AA124351E,AA124352E,AA124353E,AA124354E,AA124355E,AA124356E,AA124357E,AA124358E,AA124359E,AA124360E,AA124361E,AA124362E,AA124363E,AA124364E,AA124365E,AA124366E,AA124367E,AA124368E,AA124369E,AA124370E,AA124371E,AA124372E,AA124373E,AA124374E,AA124375E,AA124376E,AA124377E,AA124378E,AA124379E,AA124380E,AA124381E,AA124382E,AA124383E,AA124384E,AA124385E,AA124386E,AA124387E,AA124388E,AA124389E,AA124390E,',14,'1',NULL,'2022-12-13 04:00','New York'),('CA0214',12,'2022-12-14 22:30',NULL,'delay','8,2000,30,1500,CA02140B,CA02141B,CA02142B,CA02143B,CA02144B,CA02145B,CA02146B,CA02147B,CA02148B,CA02141E,CA02142E,CA02143E,CA02144E,CA02145E,CA02146E,CA02147E,CA02148E,CA02149E,CA021410E,CA021411E,CA021412E,CA021413E,CA021414E,CA021415E,CA021416E,CA021417E,CA021418E,CA021419E,CA021420E,CA021421E,CA021422E,CA021423E,CA021424E,CA021425E,CA021426E,CA021427E,CA021428E,CA021429E,CA021430E,',21,'1',NULL,'2022-12-13 00:00','Beijing'),('DA0728',16,'2022-12-13 05:30',NULL,'normal','10,1200,90,800,DA07280B,DA07281B,DA07282B,DA07283B,DA07284B,DA07285B,DA07286B,DA07287B,DA07288B,DA07289B,DA072810B,DA07281E,DA07282E,DA07283E,DA07284E,DA07285E,DA07286E,DA07287E,DA07288E,DA07289E,DA072810E,DA072811E,DA072812E,DA072813E,DA072814E,DA072815E,DA072816E,DA072817E,DA072818E,DA072819E,DA072820E,DA072821E,DA072822E,DA072823E,DA072824E,DA072825E,DA072826E,DA072827E,DA072828E,DA072829E,DA072830E,DA072831E,DA072832E,DA072833E,DA072834E,DA072835E,DA072836E,DA072837E,DA072838E,DA072839E,DA072840E,DA072841E,DA072842E,DA072843E,DA072844E,DA072845E,DA072846E,DA072847E,DA072848E,DA072849E,DA072850E,DA072851E,DA072852E,DA072853E,DA072854E,DA072855E,DA072856E,DA072857E,DA072858E,DA072859E,DA072860E,DA072861E,DA072862E,DA072863E,DA072864E,DA072865E,DA072866E,DA072867E,DA072868E,DA072869E,DA072870E,DA072871E,DA072872E,DA072873E,DA072874E,DA072875E,DA072876E,DA072877E,DA072878E,DA072879E,DA072880E,DA072881E,DA072882E,DA072883E,DA072884E,DA072885E,DA072886E,DA072887E,DA072888E,DA072889E,DA072890E,',NULL,'0',NULL,'2022-12-13 02:00','Demark'),('DA1101',18,'2022-12-13 22:30',NULL,'normal','10,2000,90,1000,DA11010B,DA11011B,DA11012B,DA11013B,DA11014B,DA11015B,DA11016B,DA11017B,DA11018B,DA11019B,DA110110B,DA11011E,DA11012E,DA11013E,DA11014E,DA11015E,DA11016E,DA11017E,DA11018E,DA11019E,DA110110E,DA110111E,DA110112E,DA110113E,DA110114E,DA110115E,DA110116E,DA110117E,DA110118E,DA110119E,DA110120E,DA110121E,DA110122E,DA110123E,DA110124E,DA110125E,DA110126E,DA110127E,DA110128E,DA110129E,DA110130E,DA110131E,DA110132E,DA110133E,DA110134E,DA110135E,DA110136E,DA110137E,DA110138E,DA110139E,DA110140E,DA110141E,DA110142E,DA110143E,DA110144E,DA110145E,DA110146E,DA110147E,DA110148E,DA110149E,DA110150E,DA110151E,DA110152E,DA110153E,DA110154E,DA110155E,DA110156E,DA110157E,DA110158E,DA110159E,DA110160E,DA110161E,DA110162E,DA110163E,DA110164E,DA110165E,DA110166E,DA110167E,DA110168E,DA110169E,DA110170E,DA110171E,DA110172E,DA110173E,DA110174E,DA110175E,DA110176E,DA110177E,DA110178E,DA110179E,DA110180E,DA110181E,DA110182E,DA110183E,DA110184E,DA110185E,DA110186E,DA110187E,DA110188E,DA110189E,DA110190E,',13,'0',NULL,'2022-12-13 17:00','Chicago'),('EJ7970',12,'2022-12-15 01:30',NULL,'normal','4,100,9,20,EJ79700B,EJ79701B,EJ79702B,EJ79703B,EJ79704B,EJ79701E,EJ79702E,EJ79703E,EJ79704E,EJ79705E,EJ79706E,EJ79707E,EJ79708E,EJ79709E,',23,'1',NULL,'2022-12-08 02:00','chengdu'),('GA1010',17,'2022-12-13 21:30',NULL,'normal','4,800,-20,700,GA10100B,GA10101B,GA10102B,GA10103B,GA10104B,',33,'1',NULL,'2022-12-13 04:30','Hanbao'),('NU1213',20,'2022-12-13 09:30',NULL,'delay','1,1000,10,300,NU12130B,NU12131B,NU12131E,NU12132E,NU12133E,NU12134E,NU12135E,NU12136E,NU12137E,NU12138E,NU12139E,NU121310E,',33,'1',NULL,'2022-12-13 03:00','Los Angeles');
/*!40000 ALTER TABLE `flight` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `flight company`
--

DROP TABLE IF EXISTS `flight company`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `flight company` (
  `idflight company` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  `admin` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `counter` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`idflight company`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flight company`
--

LOCK TABLES `flight company` WRITE;
/*!40000 ALTER TABLE `flight company` DISABLE KEYS */;
INSERT INTO `flight company` VALUES (12,'China Airlines','ca@gmail.com','D13'),(14,'JetBlue Airlines','jetblue@gmail.com','E14'),(15,'American Airlines','aa@gmail.com','B11'),(16,'WestEast Airlines','da@gmail.com','H17'),(17,'German Airlines','ga@gmail.com','A10'),(18,'Delta Airlines','daa@gmail.com','F15'),(19,'Korean Airlines','ka@gmail.com','G16'),(20,'NEU Airlines','neu@gmail.com','C12');
/*!40000 ALTER TABLE `flight company` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `immgraterecord`
--

DROP TABLE IF EXISTS `immgraterecord`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `immgraterecord` (
  `recordDate` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  `idpassport` varchar(15) COLLATE utf8mb4_unicode_ci NOT NULL,
  `from` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `to` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `withDanger` tinyint(1) DEFAULT NULL,
  `comments` text COLLATE utf8mb4_unicode_ci,
  `idImmRecord` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`idImmRecord`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `immgraterecord`
--

LOCK TABLES `immgraterecord` WRITE;
/*!40000 ALTER TABLE `immgraterecord` DISABLE KEYS */;
INSERT INTO `immgraterecord` VALUES ('12/11/2022','E79004516','Boston','Beijing',1,'Double Check. No problem.','I_20221211195343_1'),('12/11/2022','E79009065','LA','Boston',0,'','I_20221211195408_2'),('12/11/2022','E79009068','Boston','New York',0,'xixi','I_20221211195434_3'),('12/11/2022','E79009069','Boston','Beijing',1,'carry knife','I_20221211195450_4'),('12/11/2022','E79009069','LA','Boston',0,'F1 visa','I_20221211202736_1'),('12/11/2022','E79008012','Boston','Hanbao',0,'','I_20221211215837_1'),('12/12/2022','E79009034','Chicago','Boston',1,'good passenger','I_20221212214243_1'),('12/13/2022','E0213465','Boston','Seoul',1,'Carry seed','I_20221213085331_1'),('12/13/2022','E79004576','Boston','Beijing',1,'NO Danger','I_20221213091312_1');
/*!40000 ALTER TABLE `immgraterecord` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `laggage`
--

DROP TABLE IF EXISTS `laggage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `laggage` (
  `idlaggage` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `weight` double NOT NULL,
  `isFragile` tinyint(4) NOT NULL,
  PRIMARY KEY (`idlaggage`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `laggage`
--

LOCK TABLES `laggage` WRITE;
/*!40000 ALTER TABLE `laggage` DISABLE KEYS */;
INSERT INTO `laggage` VALUES ('L_20221211193518_1',10,1),('L_20221211194721_2',1,1),('L_20221211195124_3',22,0),('L_20221211195124_4',22.5,0),('L_20221211202632_1',12,0),('L_20221211202632_2',0.1,0),('L_20221211215750_1',10,0),('L_20221212211744_1',12,1),('L_20221212211746_2',12,1),('L_20221212211857_3',12,1),('L_20221212211858_4',12,1),('L_20221212212101_5',10.99,0),('L_20221212212103_6',10.99,0),('L_20221212212114_7',10.99,0),('L_20221212212115_8',10.99,0),('L_20221212212434_9',10.99,0),('L_20221212212926_1',1.4,0),('L_20221212212948_2',1.4,0),('L_20221212213134_1',1,0),('L_20221212213241_1',1,0),('L_20221212213404_1',12.5,0),('L_20221212213723_2',12.5,0),('L_20221212213833_3',11.5,0),('L_20221213085123_1',0.5,0),('L_20221213091133_1',22.9,1);
/*!40000 ALTER TABLE `laggage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `passport`
--

DROP TABLE IF EXISTS `passport`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `passport` (
  `idpassport` varchar(15) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '/^([a-zA-Z]|[0-9]){5,17}$/',
  `legalName` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '/^[a-z ,.''-]+$/i',
  `expiryDate` datetime(5) NOT NULL,
  `dob` datetime(5) NOT NULL,
  `visa` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `immRecords` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`idpassport`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `passport`
--

LOCK TABLES `passport` WRITE;
/*!40000 ALTER TABLE `passport` DISABLE KEYS */;
INSERT INTO `passport` VALUES ('E0213465','Miaochuan Hu','2027-05-05 00:00:00.00000','1997-11-23 00:00:00.00000','China',NULL),('E79004516','Pao Qian','2029-10-31 00:00:00.00000','1993-07-01 00:00:00.00000','United Stats',NULL),('E79004576','Xiaobao Song','2029-09-30 00:00:00.00000','1991-10-04 00:00:00.00000','China',NULL),('E79008012','Mild Li','2029-09-10 00:00:00.00000','1993-04-30 00:00:00.00000','China',NULL),('E79009034','New Pass','2028-10-08 00:00:00.00000','2995-09-20 00:00:00.00000','China',NULL),('E79009065','Wenhua Zhang','2029-02-20 00:00:00.00000','1994-10-10 00:00:00.00000','Tailand',NULL),('E79009068','Yi Xu','2025-10-20 00:00:00.00000','1995-09-08 00:00:00.00000','United Stats',NULL),('E79009069','Mingxia Li','2027-10-10 00:00:00.00000','1995-06-06 00:00:00.00000','China',NULL),('EJ4377511','Mingyu Li','2029-10-21 00:00:00.00000','1989-01-02 00:00:00.00000','United Stats',NULL);
/*!40000 ALTER TABLE `passport` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person`
--

DROP TABLE IF EXISTS `person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `person` (
  `idPersons` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  `pw` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  `age` int(11) NOT NULL,
  `role` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `name` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  `gender` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `idTicket` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Passengar attribute',
  `idPassport` varchar(15) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Passengar attribute',
  `idImm` int(11) DEFAULT NULL COMMENT 'Passengar attribute',
  `idSellHis` int(11) DEFAULT NULL COMMENT 'Ticketing staff attribute',
  `idFlightCompany` int(11) DEFAULT NULL COMMENT 'Counter staff attribute',
  `idFlight` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Ground Staff & Crew Staff attribute',
  PRIMARY KEY (`idPersons`),
  UNIQUE KEY `account_UNIQUE` (`account`),
  UNIQUE KEY `idTicket_UNIQUE` (`idTicket`),
  UNIQUE KEY `idImm_UNIQUE` (`idImm`),
  UNIQUE KEY `idSellHis_UNIQUE` (`idSellHis`),
  UNIQUE KEY `idPassport_UNIQUE` (`idPassport`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person`
--

LOCK TABLES `person` WRITE;
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
INSERT INTO `person` VALUES (5,'sa@gmail.com','Bamajie521',10,'System Admin','System Admin','male',NULL,NULL,NULL,NULL,NULL,NULL),(17,'salesman@gmail.com','Bamajie521',28,'Salesman','Salesman','Prefer not to say',NULL,NULL,NULL,NULL,NULL,NULL),(18,'tc@gmail.com','Bamajie521',50,'Traffic Control','Traffic Control','Female',NULL,NULL,NULL,NULL,NULL,NULL),(20,'pu@gmail.com','Bamajie521',21,'Pickup','Lisa Zheng','Female',NULL,NULL,NULL,NULL,NULL,NULL),(22,'airporta@gmail.com','Bamajie521',29,'Airport Admin','Airport Admin','Female',NULL,NULL,NULL,NULL,NULL,NULL),(25,'greeter@gmail.com','Bamajie521',23,'Greeter','Greeter','Female',NULL,NULL,NULL,NULL,NULL,NULL),(26,'ssa@gmail.com','Bamajie521',50,'Service Admin','Service Admin','Male',NULL,NULL,NULL,NULL,NULL,NULL),(28,'cond@gmail.com','Bamajie521',21,'Conductor','conductor1','Male',NULL,NULL,NULL,NULL,NULL,NULL),(30,'crew@gmail.com','Bamajie521',23,'Flight Crew','crew1 Li','Female',NULL,NULL,NULL,NULL,NULL,NULL),(31,'customs@gmail.com','Bamajie521',33,'Customs','customs1','Male',NULL,NULL,NULL,NULL,NULL,NULL),(50,'pw@gmail.com','Bamajie521',35,'Security Policeman','policewoman','Female',NULL,NULL,NULL,NULL,NULL,NULL),(58,'fc100@gmail.com','Bamajie521',9,'Flight Crew','fc Li','Female',NULL,NULL,NULL,NULL,NULL,NULL),(66,'fcdeng@gmail.com','Bamajie521',99,'Flight Crew','fc Deng','Prefer not to say',NULL,NULL,NULL,NULL,NULL,NULL),(67,'ce@gmail.com','Bamajie521',88,'Customs','customs En','Female',NULL,NULL,NULL,NULL,NULL,NULL),(68,'alicelmx@gmail.com','lmx1994PG',28,'Passenger','Mingxia Li','Female','T_202212112023_2','E79009069',NULL,NULL,NULL,NULL),(69,'xuyi@gmail.com','Bamajie521',28,'Passenger','Yi Xu','Male','T_202212130925_5','E79009068',NULL,NULL,NULL,NULL),(70,'wenhua@gmail.com','Bamajie521',29,'Passenger','Wenhua Zhang','Male','T_202212111937_2','E79009065',NULL,NULL,NULL,NULL),(71,'lili@gmail.com','Bamajie521',19,'Passenger','Lily Jin','Prefer not to say',NULL,NULL,NULL,NULL,NULL,NULL),(72,'jetblue@gmail.com','Bamajie521',30,'Airbus Admin','Airbus Admin','male',NULL,NULL,NULL,NULL,14,NULL),(73,'aa@gmail.com','Bamajie521',30,'Airbus Admin','Airbus Admin','male',NULL,NULL,NULL,NULL,15,NULL),(74,'da@gmail.com','Bamajie521',30,'Airbus Admin','Airbus Admin','male',NULL,NULL,NULL,NULL,16,NULL),(75,'pickup@gmail.com','Bamajie521',39,'Pickup','pickup Xi','Male',NULL,NULL,NULL,NULL,NULL,NULL),(76,'cca@gmail.com','Bamajie521',20,'Counter','counter CA','Male',NULL,NULL,NULL,NULL,12,NULL),(77,'cjb@gmail.com','Bamajie521',29,'Counter','counter Jetblue','Prefer not to say',NULL,NULL,NULL,NULL,14,NULL),(78,'caa@gmail.com','Bamajie521',29,'Counter','counter aa','Male',NULL,NULL,NULL,NULL,15,NULL),(79,'cac@gmail.com','Bamajie521',30,'Counter','ca counter','Prefer not to say',NULL,NULL,NULL,NULL,12,NULL),(80,'pz@gmail.com','Bamajie521',30,'Passenger','Mark Zhao','Male',NULL,NULL,NULL,NULL,NULL,NULL),(81,'pq@gmail.com','Bamajie521',39,'Passenger','Jeffra Qian','Male','T_202212111944_4','E79004516',NULL,NULL,NULL,NULL),(82,'xs@gmail.com','Bamajie521',20,'Passenger','Xiaobao Song','Prefer not to say','T_202212111944_5','E79004576',NULL,NULL,NULL,NULL),(83,'tccz@gmail.com','Bamajie521',24,'Traffic Control','tcc Zhang','Female',NULL,NULL,NULL,NULL,NULL,NULL),(84,'fccli@gmail.com','Bamajie521',67,'Flight Crew','fcc Li','Male',NULL,NULL,NULL,NULL,NULL,NULL),(85,'jay@gmail.com','Bamajie521',23,'Greeter','Jay Chou','Male',NULL,NULL,NULL,NULL,NULL,NULL),(86,'jolin@gmail.com','Bamajie521',24,'Salesman','Jolin Cai','Female',NULL,NULL,NULL,NULL,NULL,NULL),(87,'governa@gmail.com','Bamajie521',30,'Govern Admin','goven','Female',NULL,NULL,NULL,NULL,NULL,NULL),(88,'mild@gmail.com','Bamajie521',32,'Passenger','Mild Li','Female','T_202212112155_1','E79008012',NULL,NULL,NULL,NULL),(89,'ga@gmail.com','Bamajie521',30,'Airbus Admin','Airbus Admin','male',NULL,NULL,NULL,NULL,17,NULL),(90,'cga@gmail.com','Bamajie521',7,'Counter','Counter GA','Male',NULL,NULL,NULL,NULL,17,NULL),(91,'daa@gmail.com','Bamajie521',30,'Airbus Admin','Airbus Admin','male',NULL,NULL,NULL,NULL,18,NULL),(92,'newpass@gmail.com','Bamajie521',21,'Passenger','Dong Deng','Female','T_202212122115_1','E79009034',NULL,NULL,NULL,NULL),(93,'newcounter@gmail.com','Bamajie521',32,'Counter','new counter','Male',NULL,NULL,NULL,NULL,18,NULL),(94,'ka@gmail.com','Bamajie521',30,'Airbus Admin','Airbus Admin','male',NULL,NULL,NULL,NULL,19,NULL),(95,'cka@gmail.com','Bamajie521',33,'Counter','Counter KA','Male',NULL,NULL,NULL,NULL,19,NULL),(96,'miao@gmail.com','Bamajie521',24,'Passenger','Miaochuan Hu','Male','T_202212130849_1','E0213465',NULL,NULL,NULL,NULL),(97,'neu@gmail.com','Bamajie521',30,'Airbus Admin','Airbus Admin','male',NULL,NULL,NULL,NULL,20,NULL),(98,'neuc@gmail.com','Bamajie521',33,'Counter','Neu Counter','Female',NULL,NULL,NULL,NULL,20,NULL),(99,'my@gmail.com','lmx1994MY',31,'Passenger','Mingyu Li','Female','T_202212130909_3','EJ4377511',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seat`
--

DROP TABLE IF EXISTS `seat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `seat` (
  `idseat` varchar(20) NOT NULL,
  `flightNo` varchar(20) NOT NULL,
  `class` varchar(20) NOT NULL,
  `sold` tinyint(4) NOT NULL,
  PRIMARY KEY (`idseat`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seat`
--

LOCK TABLES `seat` WRITE;
/*!40000 ALTER TABLE `seat` DISABLE KEYS */;
INSERT INTO `seat` VALUES ('AA124310B','AA1243','Business',0),('AA124310E','AA1243','Economy',1),('AA124311E','AA1243','Economy',0),('AA124312E','AA1243','Economy',0),('AA124313E','AA1243','Economy',0),('AA124314E','AA1243','Economy',0),('AA124315E','AA1243','Economy',0),('AA124316E','AA1243','Economy',0),('AA124317E','AA1243','Economy',0),('AA124318E','AA1243','Economy',0),('AA124319E','AA1243','Economy',0),('AA12431B','AA1243','Business',0),('AA12431E','AA1243','Economy',0),('AA124320E','AA1243','Economy',0),('AA124321E','AA1243','Economy',0),('AA124322E','AA1243','Economy',0),('AA124323E','AA1243','Economy',0),('AA124324E','AA1243','Economy',0),('AA124325E','AA1243','Economy',0),('AA124326E','AA1243','Economy',0),('AA124327E','AA1243','Economy',0),('AA124328E','AA1243','Economy',0),('AA124329E','AA1243','Economy',0),('AA12432B','AA1243','Business',0),('AA12432E','AA1243','Economy',0),('AA124330E','AA1243','Economy',0),('AA124331E','AA1243','Economy',0),('AA124332E','AA1243','Economy',0),('AA124333E','AA1243','Economy',0),('AA124334E','AA1243','Economy',0),('AA124335E','AA1243','Economy',0),('AA124336E','AA1243','Economy',0),('AA124337E','AA1243','Economy',0),('AA124338E','AA1243','Economy',0),('AA124339E','AA1243','Economy',0),('AA12433B','AA1243','Business',0),('AA12433E','AA1243','Economy',0),('AA124340E','AA1243','Economy',0),('AA124341E','AA1243','Economy',0),('AA124342E','AA1243','Economy',0),('AA124343E','AA1243','Economy',0),('AA124344E','AA1243','Economy',0),('AA124345E','AA1243','Economy',0),('AA124346E','AA1243','Economy',0),('AA124347E','AA1243','Economy',0),('AA124348E','AA1243','Economy',0),('AA124349E','AA1243','Economy',0),('AA12434B','AA1243','Business',0),('AA12434E','AA1243','Economy',0),('AA124350E','AA1243','Economy',0),('AA124351E','AA1243','Economy',0),('AA124352E','AA1243','Economy',0),('AA124353E','AA1243','Economy',0),('AA124354E','AA1243','Economy',0),('AA124355E','AA1243','Economy',0),('AA124356E','AA1243','Economy',0),('AA124357E','AA1243','Economy',0),('AA124358E','AA1243','Economy',0),('AA124359E','AA1243','Economy',0),('AA12435B','AA1243','Business',0),('AA12435E','AA1243','Economy',0),('AA124360E','AA1243','Economy',0),('AA124361E','AA1243','Economy',0),('AA124362E','AA1243','Economy',0),('AA124363E','AA1243','Economy',0),('AA124364E','AA1243','Economy',0),('AA124365E','AA1243','Economy',0),('AA124366E','AA1243','Economy',0),('AA124367E','AA1243','Economy',0),('AA124368E','AA1243','Economy',0),('AA124369E','AA1243','Economy',0),('AA12436B','AA1243','Business',0),('AA12436E','AA1243','Economy',0),('AA124370E','AA1243','Economy',0),('AA124371E','AA1243','Economy',0),('AA124372E','AA1243','Economy',0),('AA124373E','AA1243','Economy',0),('AA124374E','AA1243','Economy',0),('AA124375E','AA1243','Economy',0),('AA124376E','AA1243','Economy',0),('AA124377E','AA1243','Economy',0),('AA124378E','AA1243','Economy',0),('AA124379E','AA1243','Economy',0),('AA12437B','AA1243','Business',0),('AA12437E','AA1243','Economy',0),('AA124380E','AA1243','Economy',0),('AA124381E','AA1243','Economy',0),('AA124382E','AA1243','Economy',0),('AA124383E','AA1243','Economy',0),('AA124384E','AA1243','Economy',0),('AA124385E','AA1243','Economy',0),('AA124386E','AA1243','Economy',0),('AA124387E','AA1243','Economy',0),('AA124388E','AA1243','Economy',0),('AA124389E','AA1243','Economy',0),('AA12438B','AA1243','Business',0),('AA12438E','AA1243','Economy',0),('AA124390E','AA1243','Economy',0),('AA12439B','AA1243','Business',0),('AA12439E','AA1243','Economy',0),('CA021410E','CA0214','Economy',0),('CA021411E','CA0214','Economy',0),('CA021412E','CA0214','Economy',0),('CA021413E','CA0214','Economy',0),('CA021414E','CA0214','Economy',0),('CA021415E','CA0214','Economy',0),('CA021416E','CA0214','Economy',0),('CA021417E','CA0214','Economy',0),('CA021418E','CA0214','Economy',0),('CA021419E','CA0214','Economy',0),('CA02141B','CA0214','Business',1),('CA02141E','CA0214','Economy',0),('CA021420E','CA0214','Economy',0),('CA021421E','CA0214','Economy',0),('CA021422E','CA0214','Economy',0),('CA021423E','CA0214','Economy',0),('CA021424E','CA0214','Economy',0),('CA021425E','CA0214','Economy',0),('CA021426E','CA0214','Economy',0),('CA021427E','CA0214','Economy',0),('CA021428E','CA0214','Economy',0),('CA021429E','CA0214','Economy',0),('CA02142B','CA0214','Business',1),('CA02142E','CA0214','Economy',0),('CA021430E','CA0214','Economy',0),('CA02143B','CA0214','Business',1),('CA02143E','CA0214','Economy',0),('CA02144B','CA0214','Business',0),('CA02144E','CA0214','Economy',0),('CA02145B','CA0214','Business',0),('CA02145E','CA0214','Economy',0),('CA02146B','CA0214','Business',0),('CA02146E','CA0214','Economy',0),('CA02147B','CA0214','Business',0),('CA02147E','CA0214','Economy',0),('CA02148B','CA0214','Business',0),('CA02148E','CA0214','Economy',0),('CA02149E','CA0214','Economy',0),('DA072810B','DA0728','Business',0),('DA072810E','DA0728','Economy',0),('DA072811E','DA0728','Economy',0),('DA072812E','DA0728','Economy',0),('DA072813E','DA0728','Economy',0),('DA072814E','DA0728','Economy',0),('DA072815E','DA0728','Economy',0),('DA072816E','DA0728','Economy',0),('DA072817E','DA0728','Economy',0),('DA072818E','DA0728','Economy',0),('DA072819E','DA0728','Economy',0),('DA07281B','DA0728','Business',0),('DA07281E','DA0728','Economy',0),('DA072820E','DA0728','Economy',0),('DA072821E','DA0728','Economy',0),('DA072822E','DA0728','Economy',0),('DA072823E','DA0728','Economy',0),('DA072824E','DA0728','Economy',0),('DA072825E','DA0728','Economy',0),('DA072826E','DA0728','Economy',0),('DA072827E','DA0728','Economy',0),('DA072828E','DA0728','Economy',0),('DA072829E','DA0728','Economy',0),('DA07282B','DA0728','Business',0),('DA07282E','DA0728','Economy',0),('DA072830E','DA0728','Economy',0),('DA072831E','DA0728','Economy',0),('DA072832E','DA0728','Economy',0),('DA072833E','DA0728','Economy',0),('DA072834E','DA0728','Economy',0),('DA072835E','DA0728','Economy',0),('DA072836E','DA0728','Economy',0),('DA072837E','DA0728','Economy',0),('DA072838E','DA0728','Economy',0),('DA072839E','DA0728','Economy',0),('DA07283B','DA0728','Business',0),('DA07283E','DA0728','Economy',0),('DA072840E','DA0728','Economy',0),('DA072841E','DA0728','Economy',0),('DA072842E','DA0728','Economy',0),('DA072843E','DA0728','Economy',0),('DA072844E','DA0728','Economy',0),('DA072845E','DA0728','Economy',0),('DA072846E','DA0728','Economy',0),('DA072847E','DA0728','Economy',0),('DA072848E','DA0728','Economy',0),('DA072849E','DA0728','Economy',0),('DA07284B','DA0728','Business',0),('DA07284E','DA0728','Economy',0),('DA072850E','DA0728','Economy',0),('DA072851E','DA0728','Economy',0),('DA072852E','DA0728','Economy',0),('DA072853E','DA0728','Economy',0),('DA072854E','DA0728','Economy',0),('DA072855E','DA0728','Economy',0),('DA072856E','DA0728','Economy',0),('DA072857E','DA0728','Economy',0),('DA072858E','DA0728','Economy',0),('DA072859E','DA0728','Economy',0),('DA07285B','DA0728','Business',0),('DA07285E','DA0728','Economy',0),('DA072860E','DA0728','Economy',0),('DA072861E','DA0728','Economy',0),('DA072862E','DA0728','Economy',0),('DA072863E','DA0728','Economy',0),('DA072864E','DA0728','Economy',0),('DA072865E','DA0728','Economy',0),('DA072866E','DA0728','Economy',0),('DA072867E','DA0728','Economy',0),('DA072868E','DA0728','Economy',0),('DA072869E','DA0728','Economy',0),('DA07286B','DA0728','Business',0),('DA07286E','DA0728','Economy',0),('DA072870E','DA0728','Economy',0),('DA072871E','DA0728','Economy',0),('DA072872E','DA0728','Economy',0),('DA072873E','DA0728','Economy',0),('DA072874E','DA0728','Economy',0),('DA072875E','DA0728','Economy',0),('DA072876E','DA0728','Economy',0),('DA072877E','DA0728','Economy',0),('DA072878E','DA0728','Economy',0),('DA072879E','DA0728','Economy',0),('DA07287B','DA0728','Business',0),('DA07287E','DA0728','Economy',0),('DA072880E','DA0728','Economy',0),('DA072881E','DA0728','Economy',0),('DA072882E','DA0728','Economy',0),('DA072883E','DA0728','Economy',0),('DA072884E','DA0728','Economy',0),('DA072885E','DA0728','Economy',0),('DA072886E','DA0728','Economy',0),('DA072887E','DA0728','Economy',0),('DA072888E','DA0728','Economy',0),('DA072889E','DA0728','Economy',0),('DA07288B','DA0728','Business',0),('DA07288E','DA0728','Economy',0),('DA072890E','DA0728','Economy',0),('DA07289B','DA0728','Business',0),('DA07289E','DA0728','Economy',0),('DA110110B','DA1101','Business',1),('DA110110E','DA1101','Economy',0),('DA110111E','DA1101','Economy',0),('DA110112E','DA1101','Economy',0),('DA110113E','DA1101','Economy',0),('DA110114E','DA1101','Economy',0),('DA110115E','DA1101','Economy',0),('DA110116E','DA1101','Economy',0),('DA110117E','DA1101','Economy',0),('DA110118E','DA1101','Economy',0),('DA110119E','DA1101','Economy',0),('DA11011B','DA1101','Business',0),('DA11011E','DA1101','Economy',0),('DA110120E','DA1101','Economy',0),('DA110121E','DA1101','Economy',0),('DA110122E','DA1101','Economy',0),('DA110123E','DA1101','Economy',0),('DA110124E','DA1101','Economy',0),('DA110125E','DA1101','Economy',0),('DA110126E','DA1101','Economy',0),('DA110127E','DA1101','Economy',0),('DA110128E','DA1101','Economy',0),('DA110129E','DA1101','Economy',0),('DA11012B','DA1101','Business',0),('DA11012E','DA1101','Economy',0),('DA110130E','DA1101','Economy',0),('DA110131E','DA1101','Economy',0),('DA110132E','DA1101','Economy',0),('DA110133E','DA1101','Economy',0),('DA110134E','DA1101','Economy',0),('DA110135E','DA1101','Economy',0),('DA110136E','DA1101','Economy',0),('DA110137E','DA1101','Economy',0),('DA110138E','DA1101','Economy',0),('DA110139E','DA1101','Economy',0),('DA11013B','DA1101','Business',0),('DA11013E','DA1101','Economy',0),('DA110140E','DA1101','Economy',0),('DA110141E','DA1101','Economy',0),('DA110142E','DA1101','Economy',0),('DA110143E','DA1101','Economy',0),('DA110144E','DA1101','Economy',0),('DA110145E','DA1101','Economy',0),('DA110146E','DA1101','Economy',0),('DA110147E','DA1101','Economy',0),('DA110148E','DA1101','Economy',0),('DA110149E','DA1101','Economy',0),('DA11014B','DA1101','Business',0),('DA11014E','DA1101','Economy',0),('DA110150E','DA1101','Economy',0),('DA110151E','DA1101','Economy',0),('DA110152E','DA1101','Economy',0),('DA110153E','DA1101','Economy',0),('DA110154E','DA1101','Economy',0),('DA110155E','DA1101','Economy',0),('DA110156E','DA1101','Economy',0),('DA110157E','DA1101','Economy',0),('DA110158E','DA1101','Economy',0),('DA110159E','DA1101','Economy',0),('DA11015B','DA1101','Business',0),('DA11015E','DA1101','Economy',0),('DA110160E','DA1101','Economy',0),('DA110161E','DA1101','Economy',0),('DA110162E','DA1101','Economy',0),('DA110163E','DA1101','Economy',0),('DA110164E','DA1101','Economy',0),('DA110165E','DA1101','Economy',0),('DA110166E','DA1101','Economy',0),('DA110167E','DA1101','Economy',0),('DA110168E','DA1101','Economy',0),('DA110169E','DA1101','Economy',0),('DA11016B','DA1101','Business',0),('DA11016E','DA1101','Economy',0),('DA110170E','DA1101','Economy',0),('DA110171E','DA1101','Economy',0),('DA110172E','DA1101','Economy',0),('DA110173E','DA1101','Economy',0),('DA110174E','DA1101','Economy',0),('DA110175E','DA1101','Economy',0),('DA110176E','DA1101','Economy',0),('DA110177E','DA1101','Economy',0),('DA110178E','DA1101','Economy',0),('DA110179E','DA1101','Economy',0),('DA11017B','DA1101','Business',0),('DA11017E','DA1101','Economy',0),('DA110180E','DA1101','Economy',0),('DA110181E','DA1101','Economy',0),('DA110182E','DA1101','Economy',0),('DA110183E','DA1101','Economy',0),('DA110184E','DA1101','Economy',0),('DA110185E','DA1101','Economy',0),('DA110186E','DA1101','Economy',0),('DA110187E','DA1101','Economy',0),('DA110188E','DA1101','Economy',0),('DA110189E','DA1101','Economy',0),('DA11018B','DA1101','Business',0),('DA11018E','DA1101','Economy',0),('DA110190E','DA1101','Economy',0),('DA11019B','DA1101','Business',0),('DA11019E','DA1101','Economy',0),('EJ79701B','EJ7970','Business',0),('EJ79701E','EJ7970','Economy',0),('EJ79702B','EJ7970','Business',0),('EJ79702E','EJ7970','Economy',0),('EJ79703B','EJ7970','Business',0),('EJ79703E','EJ7970','Economy',0),('EJ79704B','EJ7970','Business',0),('EJ79704E','EJ7970','Economy',0),('EJ79705E','EJ7970','Economy',0),('EJ79706E','EJ7970','Economy',0),('EJ79707E','EJ7970','Economy',0),('EJ79708E','EJ7970','Economy',0),('EJ79709E','EJ7970','Economy',0),('GA10101B','GA1010','Business',1),('GA10102B','GA1010','Business',0),('GA10103B','GA1010','Business',0),('GA10104B','GA1010','Business',0),('JB123410E','JB1234','Economy',1),('JB12341B','JB1234','Business',1),('JB12341E','JB1234','Economy',0),('JB12342E','JB1234','Economy',0),('JB12343E','JB1234','Economy',0),('JB12344E','JB1234','Economy',0),('JB12345E','JB1234','Economy',0),('JB12346E','JB1234','Economy',0),('JB12347E','JB1234','Economy',0),('JB12348E','JB1234','Economy',0),('JB12349E','JB1234','Economy',0),('KA000110E','KA0001','Economy',0),('KA000111E','KA0001','Economy',0),('KA000112E','KA0001','Economy',0),('KA000113E','KA0001','Economy',0),('KA000114E','KA0001','Economy',0),('KA000115E','KA0001','Economy',0),('KA000116E','KA0001','Economy',0),('KA000117E','KA0001','Economy',0),('KA000118E','KA0001','Economy',0),('KA000119E','KA0001','Economy',0),('KA00011B','KA0001','Business',1),('KA00011E','KA0001','Economy',0),('KA000120E','KA0001','Economy',0),('KA00012B','KA0001','Business',0),('KA00012E','KA0001','Economy',0),('KA00013E','KA0001','Economy',0),('KA00014E','KA0001','Economy',0),('KA00015E','KA0001','Economy',0),('KA00016E','KA0001','Economy',0),('KA00017E','KA0001','Economy',0),('KA00018E','KA0001','Economy',0),('KA00019E','KA0001','Economy',0),('NU121310E','NU1213','Economy',1),('NU12131B','NU1213','Business',1),('NU12131E','NU1213','Economy',1),('NU12132E','NU1213','Economy',0),('NU12133E','NU1213','Economy',0),('NU12134E','NU1213','Economy',0),('NU12135E','NU1213','Economy',0),('NU12136E','NU1213','Economy',0),('NU12137E','NU1213','Economy',0),('NU12138E','NU1213','Economy',0),('NU12139E','NU1213','Economy',0);
/*!40000 ALTER TABLE `seat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ticket`
--

DROP TABLE IF EXISTS `ticket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ticket` (
  `idTicket` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `idFlight` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `isBoardingPass` tinyint(4) NOT NULL,
  `realPrice` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT '',
  `boardingTime` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT '',
  `idSeat` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT '',
  `idPort` int(11) DEFAULT '0',
  `idLaggage` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT '',
  `carryDanger` tinyint(4) DEFAULT '0' COMMENT 'user for secruity check: 1 true',
  `from` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT 'departure',
  `to` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT 'arrive',
  `issuedGift` tinyint(1) DEFAULT '0',
  `isBorderCheck` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`idTicket`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticket`
--

LOCK TABLES `ticket` WRITE;
/*!40000 ALTER TABLE `ticket` DISABLE KEYS */;
INSERT INTO `ticket` VALUES ('T_202212111937_1','AA1243',1,'','2022-12-13 03:30','AA124310E',14,'L_20221211195124_3|L_20221211195124_4|',0,'Boston','New York',0,1),('T_202212111937_2','JB1234',1,'','2022-12-13 01:30','JB123410E',21,'',0,'LA','Boston',0,1),('T_202212111944_4','CA0214',1,'','2022-12-12 23:30','CA02142B',21,'L_20221211194721_2|',1,'Boston','Beijing',0,1),('T_202212111944_5','CA0214',1,'','2022-12-12 23:30','CA02143B',21,'L_20221213091133_1|',1,'Boston','Beijing',1,1),('T_202212112023_2','JB1234',1,'','2022-12-13 01:30','JB12341B',21,'L_20221211202632_1|L_20221211202632_2|',0,'LA','Boston',0,1),('T_202212112155_1','GA1010',1,'','2022-12-13 04:00','GA10101B',22,'L_20221211215750_1|',0,'Boston','Hanbao',0,1),('T_202212122115_1','DA1101',1,'','2022-12-13 16:30','DA110110B',13,'L_20221212213833_3|',1,'Chicago','Boston',1,1),('T_202212130849_1','KA0001',1,'','2022-12-13 11:30','KA00011B',33,'L_20221213085123_1|',1,'Boston','Seoul',1,1);
/*!40000 ALTER TABLE `ticket` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-12-27 16:24:51
