CREATE DATABASE  IF NOT EXISTS `TravelDreamDB` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `TravelDreamDB`;
-- MySQL dump 10.13  Distrib 5.6.13, for osx10.6 (i386)
--
-- Host: 127.0.0.1    Database: TravelDreamDB
-- ------------------------------------------------------
-- Server version	5.6.14

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
-- Table structure for table `COMPONENT`
--

DROP TABLE IF EXISTS `COMPONENT`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `COMPONENT` (
  `idComponent` int(11) NOT NULL AUTO_INCREMENT,
  `idType` varchar(20) NOT NULL,
  `name` varchar(45) NOT NULL,
  `description` varchar(500) DEFAULT NULL,
  `price` int(11) NOT NULL,
  PRIMARY KEY (`idComponent`),
  UNIQUE KEY `comp and type` (`idComponent`,`idType`),
  KEY `idType_idx` (`idType`),
  CONSTRAINT `idType` FOREIGN KEY (`idType`) REFERENCES `COMPONENT_TYPE` (`idType`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `COMPONENT`
--

LOCK TABLES `COMPONENT` WRITE;
/*!40000 ALTER TABLE `COMPONENT` DISABLE KEYS */;
INSERT INTO `COMPONENT` VALUES (3,'FLG','Ryanair flight','Offerta Speciale A/R',98),(4,'HTL','Hostal Josefina','Hostal Josefina si trova nel cuore di Madrid, nelle vicinanze dei seguenti luoghi di interesse, facilmente raggiungibili a piedi: Plaza de Callao e Puerta del Sol. Nelle vicinanze potrai visitare anche: Plaza Mayor e Plaza de España.',250),(5,'XCR','Visita alla cattedrale dell\'Almudena ','La Cattedrale dell\' Almuneda è la chiesa madre dell’arcidiocesi di Madrid e si trova vicino al Palazzo Reale. L’interno del tempio è in stile gotico, mentre l’esterno classicista.',15),(6,'FLG','Easy Jet Flight','Offerta Speciale A/R',110),(7,'HTL','La Maison Champs Elysees','Situata tra l’Avenue Montaigne e il Grand Palais, la Maison Champs Elysées apre le porte a un nuovo mondo fatto di lusso e poesia, un’atmosfera rilassata, dove il minimalismo è arricchito da un’incredibile cura per i dettagli. Questo è un luogo che racconta una storia, gli interni di questo pregevole hotel sono attentamente orchestrati come una giocosa e provocatoria produzione teatrale.',288),(8,'FLG','Direct Flight to New York','Volo in business class',503),(9,'FLG','Alitalia Flight to Amsterdam','Volo Prima Classe A/R',278),(11,'HTL','Golden Tulip Amsterdam West','Situato a solo 1 km dalla stazione ferroviaria di Amsterdam Sloterdijk, a 15 minuti di auto dall\'Aeroporto di Schiphol, il Golden Tulip Amsterdam West offre la connessione Wi-Fi gratuita e camere climatizzate con un design raffinato.',180),(12,'FLG','VOLO A/R con 8 giorni e 7 notti RODI','Offerta Limitata ',389),(13,'HTL','Thalasso Spa Resort ','La splendida architettura greca, gli alloggi lussuosi e la rigenerante Thalasso Spa cattureranno la vostra mente per sempre.',200),(14,'XCR','Ananeosis Thalasso Spa','L\'unico centro termale di talassoterapia sull\'isola di Rodi che collabora in esclusiva con Thalgo & Terrake, una delle aziende leader nel mondo della Thalasso Spa.',80),(15,'FLG','Praha Flight','VOLO A/R con 3 giorni / 2 notti',129),(16,'HTL','Hotel Barceló Praha','Alloggia in questo hotel 4 stelle nel centro di Praga. Barcelo Praha Five si trova a meno di 15 minuti da note attrazioni locali, come Birrificio Staropramen e Parco di Mrazovka.',175),(17,'FLG','Ryanair Special Deal Praha','8 days A/R',85),(18,'XCR','Visita guidata al Castello di Praga','Costruito nel IX secolo. Con 570 metri di lunghezza e 130 di larghezza, è considerato la più grande fortezza medievale del mondo. Contiene la Cattedrale di San Vito, Vicolo d\'Oro e alchimia, dove hanno lavorato alcuni alchimisti per trovare la formula per creare l\'oro.',11),(19,'HTL','The Lex Boutique Hotel NYC','Sistemazione in Camera Cozy Queen\r\nCaffè gratuito\r\nTrattamento di Prima Colazione\r\nTasse locali incluse (14.75% VAT e USD 3.50 tassa di soggiorno)',450);
/*!40000 ALTER TABLE `COMPONENT` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `COMPONENT_TYPE`
--

DROP TABLE IF EXISTS `COMPONENT_TYPE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `COMPONENT_TYPE` (
  `idType` varchar(20) NOT NULL,
  `type` varchar(45) NOT NULL,
  PRIMARY KEY (`idType`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `COMPONENT_TYPE`
--

LOCK TABLES `COMPONENT_TYPE` WRITE;
/*!40000 ALTER TABLE `COMPONENT_TYPE` DISABLE KEYS */;
INSERT INTO `COMPONENT_TYPE` VALUES ('FLG','flight'),('HTL','hotel'),('XCR','excursion');
/*!40000 ALTER TABLE `COMPONENT_TYPE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `EXCURSION`
--

DROP TABLE IF EXISTS `EXCURSION`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `EXCURSION` (
  `idComponent` int(11) NOT NULL,
  `place` varchar(45) NOT NULL,
  `start` datetime NOT NULL,
  `finish` datetime NOT NULL,
  PRIMARY KEY (`idComponent`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `EXCURSION`
--

LOCK TABLES `EXCURSION` WRITE;
/*!40000 ALTER TABLE `EXCURSION` DISABLE KEYS */;
INSERT INTO `EXCURSION` VALUES (5,'Madrid','2014-02-19 00:00:00','2014-02-19 00:00:00'),(14,'Rodi','2014-02-12 00:00:00','2014-02-12 00:00:00'),(18,'Praha','2014-02-14 00:00:00','2014-02-14 00:00:00');
/*!40000 ALTER TABLE `EXCURSION` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `FLIGHT`
--

DROP TABLE IF EXISTS `FLIGHT`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `FLIGHT` (
  `idComponent` int(11) NOT NULL,
  `departureDate` datetime NOT NULL,
  `returnDate` datetime NOT NULL,
  `departurePlace` varchar(45) NOT NULL,
  `arrivalPlace` varchar(45) NOT NULL,
  PRIMARY KEY (`idComponent`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `FLIGHT`
--

LOCK TABLES `FLIGHT` WRITE;
/*!40000 ALTER TABLE `FLIGHT` DISABLE KEYS */;
INSERT INTO `FLIGHT` VALUES (3,'2014-02-17 00:00:00','2014-02-24 00:00:00','Milan','Madrid'),(6,'2014-03-13 00:00:00','2014-02-16 00:00:00','Milan','Paris'),(8,'2014-02-19 00:00:00','2014-02-26 00:00:00','Rome','New York'),(9,'2014-02-28 00:00:00','2014-03-11 00:00:00','Bologna','Amsterdam'),(12,'2014-02-04 00:00:00','2014-02-11 00:00:00','Milan','Rodi'),(15,'2014-02-18 00:00:00','2014-02-25 00:00:00','Rome','Praha'),(17,'2014-02-18 00:00:00','2014-02-26 00:00:00','Milan','Praha');
/*!40000 ALTER TABLE `FLIGHT` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `HOTEL`
--

DROP TABLE IF EXISTS `HOTEL`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `HOTEL` (
  `idComponent` int(11) NOT NULL,
  `place` varchar(45) NOT NULL,
  `checkIn` datetime NOT NULL,
  `checkOut` datetime NOT NULL,
  PRIMARY KEY (`idComponent`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `HOTEL`
--

LOCK TABLES `HOTEL` WRITE;
/*!40000 ALTER TABLE `HOTEL` DISABLE KEYS */;
INSERT INTO `HOTEL` VALUES (4,'Madrid','2014-02-17 00:00:00','2014-02-24 00:00:00'),(7,'Paris','2014-03-13 00:00:00','2014-03-16 00:00:00'),(11,'Amsterdam','2014-02-04 00:00:00','2014-02-11 00:00:00'),(13,'Rodi','2014-02-04 00:00:00','2014-02-11 00:00:00'),(16,'Praha','2014-02-18 00:00:00','2014-02-25 00:00:00'),(19,'New York','2014-02-19 00:00:00','2014-02-26 00:00:00');
/*!40000 ALTER TABLE `HOTEL` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PACKAGE`
--

DROP TABLE IF EXISTS `PACKAGE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PACKAGE` (
  `idPackage` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(45) NOT NULL,
  `description` varchar(500) DEFAULT NULL,
  `type` varchar(45) NOT NULL,
  PRIMARY KEY (`idPackage`)
) ENGINE=InnoDB AUTO_INCREMENT=66699 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PACKAGE`
--

LOCK TABLES `PACKAGE` WRITE;
/*!40000 ALTER TABLE `PACKAGE` DISABLE KEYS */;
INSERT INTO `PACKAGE` VALUES (66673,'RODI: Prestigioso 5 stelle fronte mare','Tra le acque del Mar Egeo affiora un gioiello dalla bellezza gloriosa e imponente: Rodi. ','standard'),(66685,'Magica Praga','Praga è una bellissima città. Anzi, una delle più belle in tutta l\'Europa. Apprezzerete la sua magia che incontrerete ad ogni angolo, la posizione privilegiata dell’hotel e la sistemazione in camera executive.','standard'),(66691,'Magica Praga CUSTOM','Praga è una bellissima città. Anzi, una delle più belle in tutta l\'Europa. Apprezzerete la sua magia che incontrerete ad ogni angolo, la posizione privilegiata dell’hotel e la sistemazione in camera executive.','custom'),(66692,'New York: Shopping nel cuore di Manhattan','Tutti conosciamo New York... E\' la città che simboleggia tutto il mondo, grazie alla sua commistione di culture, al suo melting pot unico, grazie a una cinematografia che ce l\'ha fatta vivere in tutte le sue fasi. Luoghi familiari come Wall Street, Central Park e la mitica Statua della Libertà ora non dovrete più vederli solo sul piccolo o grande schermo: volate con Voyage Privé in questa magica destinazione per un\'esperienza incredibile!','standard'),(66695,'Settimana ad Amsterdam','La capitale olandese è conosciuta in tutto il mondo per la sua rete di canali, risalente al XVII secolo, gli antichi palazzi, gli eccellenti musei e i coffee shop, tutte mete imperdibili di qualunque viaggio a Amsterdam.','standard'),(66696,'Settimana ad Amsterdam CUSTOM','La capitale olandese è conosciuta in tutto il mondo per la sua rete di canali, risalente al XVII secolo, gli antichi palazzi, gli eccellenti musei e i coffee shop, tutte mete imperdibili di qualunque viaggio a Amsterdam.','custom'),(66698,'RODI: Prestigioso 5 stelle fronte mare CUSTOM','Tra le acque del Mar Egeo affiora un gioiello dalla bellezza gloriosa e imponente: Rodi. ','custom');
/*!40000 ALTER TABLE `PACKAGE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PACK_CONTENT`
--

DROP TABLE IF EXISTS `PACK_CONTENT`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PACK_CONTENT` (
  `idPackage` int(11) NOT NULL,
  `idComponent` int(11) NOT NULL,
  PRIMARY KEY (`idPackage`,`idComponent`),
  KEY `idComponent_idx` (`idComponent`),
  CONSTRAINT `idComponentForContent` FOREIGN KEY (`idComponent`) REFERENCES `COMPONENT` (`idComponent`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PACK_CONTENT`
--

LOCK TABLES `PACK_CONTENT` WRITE;
/*!40000 ALTER TABLE `PACK_CONTENT` DISABLE KEYS */;
INSERT INTO `PACK_CONTENT` VALUES (66692,8),(66695,9),(66695,11),(66696,11),(66673,12),(66681,12),(66682,12),(66673,13),(66681,13),(66682,13),(66673,14),(66681,14),(66682,14),(66698,14),(66666,15),(66680,15),(66683,15),(66685,15),(66666,16),(66680,16),(66683,16),(66685,16),(66691,16),(66685,18),(66692,19);
/*!40000 ALTER TABLE `PACK_CONTENT` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PURCHASED_PACK`
--

DROP TABLE IF EXISTS `PURCHASED_PACK`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PURCHASED_PACK` (
  `idBooking` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `idPackage` int(11) NOT NULL,
  `guests` int(11) DEFAULT NULL,
  `totalPrice` int(11) DEFAULT NULL,
  PRIMARY KEY (`idBooking`),
  KEY `usernameForPurchased_idx` (`username`),
  CONSTRAINT `usernameForPurchased` FOREIGN KEY (`username`) REFERENCES `USERS` (`username`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PURCHASED_PACK`
--

LOCK TABLES `PURCHASED_PACK` WRITE;
/*!40000 ALTER TABLE `PURCHASED_PACK` DISABLE KEYS */;
INSERT INTO `PURCHASED_PACK` VALUES (1,'user',66693,1,260),(2,'user',66696,2,360);
/*!40000 ALTER TABLE `PURCHASED_PACK` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `SAVED_PACK`
--

DROP TABLE IF EXISTS `SAVED_PACK`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `SAVED_PACK` (
  `username` varchar(45) NOT NULL,
  `idPackage` int(11) NOT NULL,
  PRIMARY KEY (`username`,`idPackage`),
  KEY `idPackage_idx` (`idPackage`),
  CONSTRAINT `idPackageForSaved` FOREIGN KEY (`idPackage`) REFERENCES `PACKAGE` (`idPackage`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `username` FOREIGN KEY (`username`) REFERENCES `USERS` (`username`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `SAVED_PACK`
--

LOCK TABLES `SAVED_PACK` WRITE;
/*!40000 ALTER TABLE `SAVED_PACK` DISABLE KEYS */;
INSERT INTO `SAVED_PACK` VALUES ('admin',66692),('admin',66695),('user',66696),('user',66698);
/*!40000 ALTER TABLE `SAVED_PACK` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `USERS`
--

DROP TABLE IF EXISTS `USERS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `USERS` (
  `username` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `password` varchar(300) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `USERS`
--

LOCK TABLES `USERS` WRITE;
/*!40000 ALTER TABLE `USERS` DISABLE KEYS */;
INSERT INTO `USERS` VALUES ('admin','admin@gmail.com','8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918'),('user','user@gmail.com','04f8996da763b7a969b1028ee3007569eaf3a635486ddab211d512c85b9df8fb');
/*!40000 ALTER TABLE `USERS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `USER_GROUP`
--

DROP TABLE IF EXISTS `USER_GROUP`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `USER_GROUP` (
  `username` varchar(45) NOT NULL,
  `idGroup` varchar(45) NOT NULL,
  PRIMARY KEY (`username`),
  CONSTRAINT `usernameInGroup` FOREIGN KEY (`username`) REFERENCES `USERS` (`username`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `USER_GROUP`
--

LOCK TABLES `USER_GROUP` WRITE;
/*!40000 ALTER TABLE `USER_GROUP` DISABLE KEYS */;
INSERT INTO `USER_GROUP` VALUES ('admin','ADMIN'),('user','USER');
/*!40000 ALTER TABLE `USER_GROUP` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-01-31 11:09:04
