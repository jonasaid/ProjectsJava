-- MySQL dump 10.13  Distrib 5.7.21, for Win64 (x86_64)
--
-- Host: localhost    Database: juego
-- ------------------------------------------------------
-- Server version	5.7.21-log

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
-- Table structure for table `juego`
--

DROP TABLE IF EXISTS `juego`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `juego` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `juego` varchar(20) NOT NULL,
  `descripcion` varchar(10000) NOT NULL,
  `imagen` varchar(1000) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `juego`
--

LOCK TABLES `juego` WRITE;
/*!40000 ALTER TABLE `juego` DISABLE KEYS */;
INSERT INTO `juego` VALUES (1,'Gears of war','Gears of War, el gran triple A de Microsoft para el 2006, no es secreto para muchos que fue el juego que vino a decir como deben de hacerse los shooters en tercera persona. Encarnamos a Marcus Fenix, un \"ex-soldado\" carcelario por desobedecer unas ordenes para rescatar a su padre. Estamos en el planeta Sera, planeta colonizado por los humanos, en la introducción del juego nos hablan del día \"E\", como el día que una misteriosa raza que tenía más tiempo del que creíamos y que se suponía que era un simple cuento para asustar a los niños se torno en realidad, los Locust emergieron aniquilando todo a su paso y la humanidad lleva una guerra contra ellos por el dominio del planeta desde hace más de 14 años, teniendo que activar un arma conocida como \"El Martillo Alba\" a gran escala para así evitar más masacre, pero llevándose inocentes de paso. Ahora con la humanidad al borde de la extinción, esta reclutando hasta las últimas fuerzas para hacer una y última ofensiva que pueda acabar, o al menos, cambiar el rumbo de la guerra.','https://www.tuexpertojuegos.com/wp-content/uploads/2011/09/gow_3_01.png'),(2,'Gears of war 2','Gears of War 2 es el claro ejemplo de como se puede llegar al máximo potencial de un juego y como se debe hacer un secuela. Empezamos con el apartado gráfico que es maravilloso,superando con creces la de la primera parte,una jugabilidad mucho más pulida y mejorada que antes,añade muchas nuevas cosas como los modos horda o bestia que están bastante guapos,nuevas armas como la gorgon,la boltok,,el escudo acorazado,el arco explosivo o el mortero.','https://upload.wikimedia.org/wikipedia/en/e/e0/Gears_of_War_2_Game_Cover.jpg'),(3,'Gears of war 3','Gears of War 3 supone,como ya lo hizo Halo 3,el final de la trilogía original de Gears of War que se ha convertido en uno de los juegazos de 2011,y sigue siendo a día de hoy el mejor juego de la saga,ganando premios al shooter del año,tiene varias razones:\nLa jugabilidad: En general es el mismo sistema de coberturas en 3ra persona que también le ha ido en las anteriores,hasta el punto que este lo tiene refinado hasta la saciedad,haciendo que los combates sean rápidos y frenéticos,ya que no hay lag y eso lo arregla,además vuelven los típicos modos multijugador,con mapas como Mercy,el del Banco de Arena...ambos con muy buenos modos de juegos adictivos y divertidos,sumando los modos horda y bestia,que en esta entrega se han mejorado en todo,incluyendo servers se`parados y dedicados.\nLos gráficos: Los gráficos como siempre muy buenos,se nota lo que puede alcanzar el Unreal Engine añadiendo unos escenarios muy bien detallados y detalles con estampas magníficas.','https://cdn.hobbyconsolas.com/sites/navi.axelspringer.es/public/styles/cover_290x414/public/media/image/2016/08/caratula-gears-war-3.jpg?itok=_x9B5UON'),(4,'Halo','Gran FPS con una profunda e inmersiva historia de ciencia ficción. Un gran título para los amantes de los juegos clásicos, muy innovador para su fecha de lanzamiento y con bastos niveles explorables (aunque lineales al fin y al cabo). Una gran variedad de Armas y la posibilidad de utilizar Vehículos. Un multijugador bastante adictivo con una comunidad que sigue activa en los momentos actuales. Juego ideal para los amantes de la ciencia ficción, y para quienes quieran adentrarse en este basto universo de HALO.','https://cdn.hobbyconsolas.com/sites/navi.axelspringer.es/public/styles/main_element/public/media/image/2014/11/405602-analisis-halo-coleccion-jefe-maestro.jpg?itok=e9DpEqkZ');
/*!40000 ALTER TABLE `juego` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `juego_user`
--

DROP TABLE IF EXISTS `juego_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `juego_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fk_id_user` int(11) NOT NULL,
  `fk_id_juego` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `fk_id_user` (`fk_id_user`,`fk_id_juego`),
  KEY `tiene` (`fk_id_juego`),
  CONSTRAINT `tiene` FOREIGN KEY (`fk_id_juego`) REFERENCES `juego` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `usa` FOREIGN KEY (`fk_id_user`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `juego_user`
--

LOCK TABLES `juego_user` WRITE;
/*!40000 ALTER TABLE `juego_user` DISABLE KEYS */;
INSERT INTO `juego_user` VALUES (1,1,1),(3,1,2),(2,4,3),(4,4,4);
/*!40000 ALTER TABLE `juego_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'SebastianAlva','halocollection'),(2,'Edwin','treps22**'),(3,'rojo',''),(4,'jona','hola');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-03-11  1:01:57
