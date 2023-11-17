CREATE DATABASE  IF NOT EXISTS `circulobd` /*!40100 DEFAULT CHARACTER SET utf8mb3 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `circulobd`;
-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: localhost    Database: circulobd
-- ------------------------------------------------------
-- Server version	8.0.29

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
-- Table structure for table `ecuacioncirculo`
--

DROP TABLE IF EXISTS `ecuacioncirculo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ecuacioncirculo` (
  `idEcuacionCirculo` int NOT NULL AUTO_INCREMENT,
  `centroX` float DEFAULT NULL,
  `centroY` float DEFAULT NULL,
  `radio` float DEFAULT NULL,
  `puntoX` float DEFAULT NULL,
  `puntoY` float DEFAULT NULL,
  `mostrarEC` varchar(10) DEFAULT NULL,
  `tipoEC` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`idEcuacionCirculo`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ecuacioncirculo`
--

LOCK TABLES `ecuacioncirculo` WRITE;
/*!40000 ALTER TABLE `ecuacioncirculo` DISABLE KEYS */;
INSERT INTO `ecuacioncirculo` VALUES (2,-3,4,4.47214,1,2,'general','porPuntos'),(5,0.5,-1.5,5,1,2,'general','adioDe'),(6,-3,4,4.47214,1,2,'estandar','porPuntos'),(7,-3,4,4.47214,1,2,'general','porPuntos'),(8,0.5,-1.5,5,1,2,'estandar','radioDe'),(9,0.5,-1.5,5,1,2,'general','radioDe'),(10,0.5,-1.5,5,1,2,'general','adioDe'),(11,-3,4,4.47214,1,2,'estandar','porPuntos'),(12,-3,4,4.47214,1,2,'general','porPuntos'),(13,0.5,-1.5,5,1,2,'estandar','radioDe'),(14,0.5,-1.5,5,1,2,'general','radioDe'),(15,0.5,-1.5,5,1,2,'general','adioDe'),(16,-3,4,4.47214,1,2,'estandar','porPuntos'),(17,-3,4,4.47214,1,2,'general','porPuntos'),(18,0.5,-1.5,5,1,2,'estandar','radioDe'),(19,0.5,-1.5,5,1,2,'general','radioDe'),(20,0.5,-1.5,5,1,2,'general','adioDe'),(21,-3,4,4.47214,1,2,'estandar','porPuntos'),(22,-3,4,4.47214,1,2,'general','porPuntos'),(23,0.5,-1.5,5,1,2,'estandar','radioDe'),(24,0.5,-1.5,5,1,2,'general','radioDe'),(25,0.5,-1.5,5,1,2,'general','adioDe'),(26,-3,4,4.47214,1,2,'estandar','porPuntos'),(27,-3,4,4.47214,1,2,'general','porPuntos'),(28,0.5,-1.5,5,1,2,'estandar','radioDe'),(29,0.5,-1.5,5,1,2,'general','radioDe'),(30,0.5,-1.5,5,1,2,'general','adioDe'),(31,-3,4,4.47214,1,2,'estandar','porPuntos'),(32,-3,4,4.47214,1,2,'general','porPuntos'),(33,0.5,-1.5,5,1,2,'estandar','radioDe'),(34,0.5,-1.5,5,1,2,'general','radioDe'),(35,0.5,-1.5,5,1,2,'general','adioDe'),(36,-3,4,4.47214,1,2,'estandar','porPuntos'),(37,-3,4,4.47214,1,2,'general','porPuntos'),(38,0.5,-1.5,5,1,2,'estandar','radioDe'),(39,0.5,-1.5,5,1,2,'general','radioDe'),(40,0.5,-1.5,5,1,2,'general','adioDe'),(41,-3,4,4.47214,1,2,'estandar','porPuntos'),(42,-3,4,4.47214,1,2,'general','porPuntos'),(43,0.5,-1.5,5,1,2,'estandar','radioDe'),(44,0.5,-1.5,5,1,2,'general','radioDe'),(45,0.5,-1.5,5,1,2,'general','adioDe'),(46,-3,4,4.47214,1,2,'estandar','porPuntos'),(47,-3,4,4.47214,1,2,'general','porPuntos'),(48,0.5,-1.5,5,1,2,'estandar','radioDe'),(49,0.5,-1.5,5,1,2,'general','radioDe'),(50,0.5,-1.5,5,1,2,'general','adioDe');
/*!40000 ALTER TABLE `ecuacioncirculo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `radioycirculo`
--

DROP TABLE IF EXISTS `radioycirculo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `radioycirculo` (
  `idRadioYCirculo` int NOT NULL AUTO_INCREMENT,
  `centroX` float DEFAULT NULL,
  `centroY` float DEFAULT NULL,
  `radio` float DEFAULT NULL,
  `bandera` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`idRadioYCirculo`)
) ENGINE=InnoDB AUTO_INCREMENT=82 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `radioycirculo`
--

LOCK TABLES `radioycirculo` WRITE;
/*!40000 ALTER TABLE `radioycirculo` DISABLE KEYS */;
INSERT INTO `radioycirculo` VALUES (2,-2,2,16,'tipo1'),(5,-2,2,16,'tipo1'),(6,-2,2,16,'tipo1'),(7,-2,2,16,'tipo1'),(8,-2,2,16,'tipo1'),(9,-2,2,16,'tipo1'),(10,-2,2,16,'tipo1'),(11,-2,2,16,'tipo1'),(12,-2,2,16,'tipo1'),(13,-2,2,16,'tipo1'),(14,-2,2,16,'tipo1'),(15,-2,2,16,'tipo1'),(16,-2,2,-0.75,'tipo1'),(17,-2,2,-0.75,'tipo1'),(18,-2,2,16,'tipo1'),(19,1,-1.5,2,'tipo2'),(20,2,-3,-0.75,'tipoX'),(21,-2,2,16,'tipo1'),(22,1,-1.5,2,'tipo2'),(23,2,-3,-0.75,'tipoX'),(24,-2,2,16,'tipo1'),(25,1,-1.5,2,'tipo2'),(26,2,-3,-0.75,'tipoX'),(27,-2,2,16,'tipo1'),(28,-2,2,16,'tipo1'),(29,-2,2,16,'tipo1'),(30,-2,2,16,'tipo1'),(31,-2,2,16,'tipo1'),(32,-2,2,16,'tipo1'),(33,1,-1.5,2,'tipo2'),(34,2,-3,-0.75,'tipoX'),(35,-2,2,16,'tipo1'),(36,1,-1.5,2,'tipo2'),(37,2,-3,-0.75,'tipoX'),(38,-2,2,16,'tipo1'),(39,1,-1.5,2,'tipo2'),(40,2,-3,-0.75,'tipoX'),(41,-2,2,16,'tipo1'),(42,1,-1.5,2,'tipo2'),(43,2,-3,-0.75,'tipoX'),(44,-2,2,16,'tipo1'),(45,1,-1.5,2,'tipo2'),(46,2,-3,-0.75,'tipoX'),(47,-2,2,16,'tipo1'),(48,-2,2,16,'tipo1'),(49,-2,2,16,'tipo1'),(50,1,-1.5,2,'tipo2'),(51,2,-3,-0.75,'tipoX'),(52,-2,2,16,'tipo1'),(53,1,-1.5,2,'tipo2'),(54,2,-3,-0.75,'tipoX'),(55,-2,2,16,'tipo1'),(56,1,-1.5,2,'tipo2'),(57,2,-3,-0.75,'tipoX'),(58,-2,2,16,'tipo1'),(59,1,-1.5,2,'tipo2'),(60,2,-3,-0.75,'tipoX'),(61,-2,2,16,'tipo1'),(62,1,-1.5,2,'tipo2'),(63,2,-3,-0.75,'tipoX'),(64,-2,2,16,'tipo1'),(65,-2,2,16,'tipo1'),(66,1,-1.5,2,'tipo2'),(67,2,-3,-0.75,'tipoX'),(68,-2,2,16,'tipo1'),(69,1,-1.5,2,'tipo2'),(70,2,-3,-0.75,'tipoX'),(71,-2,2,16,'tipo1'),(72,1,-1.5,2,'tipo2'),(73,2,-3,-0.75,'tipoX'),(74,-2,2,16,'tipo1'),(75,-2,2,16,'tipo1'),(76,-2,2,16,'tipo1'),(77,-2,2,16,'tipo1'),(78,-2,2,16,'tipo1'),(79,-2,2,16,'tipo1'),(80,-2,2,16,'tipo1'),(81,-2,2,16,'tipo1');
/*!40000 ALTER TABLE `radioycirculo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-06-07 21:52:04
