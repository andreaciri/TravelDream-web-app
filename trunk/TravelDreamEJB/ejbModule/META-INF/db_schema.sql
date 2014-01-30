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
  `description` varchar(100) DEFAULT NULL,
  `price` int(11) NOT NULL,
  PRIMARY KEY (`idComponent`),
  UNIQUE KEY `comp and type` (`idComponent`,`idType`),
  KEY `idType_idx` (`idType`),
  CONSTRAINT `idType` FOREIGN KEY (`idType`) REFERENCES `COMPONENT_TYPE` (`idType`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

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
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

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
  KEY `idPackageForPurchased_idx` (`idPackage`),
  CONSTRAINT `idPackageForPurchased` FOREIGN KEY (`idPackage`) REFERENCES `PACKAGE` (`idPackage`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `usernameForPurchased` FOREIGN KEY (`username`) REFERENCES `USERS` (`username`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

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
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-01-30  9:43:00
