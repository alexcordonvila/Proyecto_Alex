-- MySQL dump 10.13  Distrib 8.0.38, for Win64 (x86_64)
--
-- Host: localhost    Database: db_reparaciones
-- ------------------------------------------------------
-- Server version	9.0.0

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
-- Table structure for table `marcas`
--

DROP TABLE IF EXISTS `marcas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `marcas` (
  `id` int NOT NULL AUTO_INCREMENT,
  `marca` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `marcas`
--

LOCK TABLES `marcas` WRITE;
/*!40000 ALTER TABLE `marcas` DISABLE KEYS */;
INSERT INTO `marcas` VALUES (1,'Dell'),(2,'HP'),(3,'Apple'),(4,'Lenovo'),(5,'Acer'),(6,'Asus'),(7,'MSI'),(8,'Toshiba'),(9,'Samsung'),(10,'Sony'),(11,'Nothink');
/*!40000 ALTER TABLE `marcas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `modelos`
--

DROP TABLE IF EXISTS `modelos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `modelos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `modelo` varchar(45) NOT NULL,
  `FK_marca` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `constr_modelos_FK_marca_idx` (`FK_marca`),
  CONSTRAINT `constr_modelos_FK_marca` FOREIGN KEY (`FK_marca`) REFERENCES `marcas` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `modelos`
--

LOCK TABLES `modelos` WRITE;
/*!40000 ALTER TABLE `modelos` DISABLE KEYS */;
INSERT INTO `modelos` VALUES (1,'XPS 13',1),(2,'Inspiron 15',1),(3,'Alienware m15',1),(4,'Latitude 7400',1),(5,'Precision 5550',1),(6,'Pavilion 15',2),(7,'Spectre x360',2),(8,'Omen 17',2),(9,'EliteBook 850',2),(10,'ProBook 450',2),(11,'MacBook Air',3),(12,'MacBook Pro 16',3),(13,'iMac 24\"',3),(14,'Mac Mini',3),(15,'Mac Pro',3),(16,'ThinkPad X1',4),(17,'IdeaPad 3',4),(18,'Yoga Slim 7',4),(19,'Legion 5',4),(20,'ThinkBook 14s',4),(21,'Swift 3',5),(22,'Aspire 5',5),(23,'Predator Helios 300',5),(24,'Nitro 5',5),(25,'Spin 5',5),(26,'ZenBook 13',6),(27,'ROG Strix G15',6),(28,'VivoBook S14',6),(29,'TUF Dash F15',6),(30,'ProArt StudioBook',6),(31,'GF63 Thin',7),(32,'Prestige 14',7),(33,'Creator Z16',7),(34,'Katana GF66',7),(35,'Modern 15',7),(36,'Satellite Pro',8),(37,'Tecra A50',8),(38,'Portégé X30',8),(39,'Dynabook E10',8),(40,'L50',8),(41,'Galaxy Book Pro',9),(42,'Galaxy Book Flex',9),(43,'Notebook 9',9),(44,'Chromebook 4',9),(45,'Galaxy Book Odyssey',9),(46,'VAIO Z',10),(47,'VAIO S',10),(48,'VAIO Fit 15E',10),(49,'VAIO Pro 13',10),(50,'VAIO Duo 11',10),(51,'Nalx_3000',11);
/*!40000 ALTER TABLE `modelos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ordenadores`
--

DROP TABLE IF EXISTS `ordenadores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ordenadores` (
  `id` int NOT NULL AUTO_INCREMENT,
  `numeroSerie` varchar(45) DEFAULT NULL,
  `capacidad` int NOT NULL,
  `ram` int NOT NULL,
  `anotaciones` varchar(200) NOT NULL,
  `FK_modelo` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `constr_ordenadores_FK_modelos_idx` (`FK_modelo`),
  FULLTEXT KEY `fulltextIDX` (`numeroSerie`),
  CONSTRAINT `constr_ordenadores_FK_modelos` FOREIGN KEY (`FK_modelo`) REFERENCES `modelos` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ordenadores`
--

LOCK TABLES `ordenadores` WRITE;
/*!40000 ALTER TABLE `ordenadores` DISABLE KEYS */;
INSERT INTO `ordenadores` VALUES (1,'SN123456D1',512,16,'Laptop ligero',1),(2,'SN123457D2',256,8,'Con pantalla táctil',1),(3,'SN123458D3',1024,32,'Para gaming',2),(4,'SN123459D4',512,16,'Laptop empresarial',4),(5,'SN123460D5',2048,64,'Estación de trabajo',5),(6,'SN223456H1',512,16,'Laptop para oficina',6),(7,'SN223457H2',256,8,'Convertible con pantalla táctil',7),(8,'SN223458H3',1024,32,'Para gaming',8),(9,'SN223459H4',512,16,'Laptop de alta gama',9),(10,'SN223460H5',256,8,'Modelo económico',10),(11,'SN323456A1',256,8,'Laptop ligero y delgado',11),(12,'SN323457A2',512,16,'Laptop para creadores',12),(13,'SN323458A3',1024,32,'Para diseño gráfico',13),(14,'SN323459A4',256,8,'PC compacto',14),(15,'SN323460A5',2048,64,'Potente para edición de vídeo',15),(16,'SN423456L1',512,16,'Laptop empresarial',16),(17,'SN423457L2',256,8,'Modelo de gama media',17),(18,'SN423458L3',1024,32,'Ultrabook delgado',18),(19,'SN423459L4',512,16,'Para gaming',19),(20,'SN423460L5',256,8,'Laptop empresarial',20),(21,'SN523456AC1',512,16,'Laptop ultradelgado',21),(22,'SN523457AC2',256,8,'Para estudiantes',22),(23,'SN523458AC3',1024,32,'Para gaming',23),(24,'SN523459AC4',512,16,'Laptop económico',24),(25,'SN523460AC5',256,8,'Convertible 2 en 1',25),(26,'SN623456AS1',512,16,'Laptop profesional',26),(27,'SN623457AS2',1024,32,'Para gaming',27),(28,'SN623458AS3',256,8,'Modelo económico',28),(29,'SN623459AS4',512,16,'Laptop para creadores',29),(30,'SN623460AS5',2048,64,'Estación de trabajo potente',30);
/*!40000 ALTER TABLE `ordenadores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `v_modelos`
--

DROP TABLE IF EXISTS `v_modelos`;
/*!50001 DROP VIEW IF EXISTS `v_modelos`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `v_modelos` AS SELECT 
 1 AS `id`,
 1 AS `modelo`,
 1 AS `FK_marca`,
 1 AS `marca`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `v_ordenadores`
--

DROP TABLE IF EXISTS `v_ordenadores`;
/*!50001 DROP VIEW IF EXISTS `v_ordenadores`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `v_ordenadores` AS SELECT 
 1 AS `id`,
 1 AS `numeroSerie`,
 1 AS `capacidad`,
 1 AS `ram`,
 1 AS `anotaciones`,
 1 AS `FK_modelo`,
 1 AS `modelo`,
 1 AS `marca`*/;
SET character_set_client = @saved_cs_client;

--
-- Dumping events for database 'db_reparaciones'
--

--
-- Dumping routines for database 'db_reparaciones'
--
/*!50003 DROP PROCEDURE IF EXISTS `sp_eliminar_ordenador` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_eliminar_ordenador`(
in id int
)
BEGIN
DELETE FROM ordenadores o
where  id = o.id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_insertar_marca` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_insertar_marca`(
in pmarca varchar(45)
)
BEGIN
insert INTO marcas(marca)
values
(pmarca);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_insertar_modelo` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_insertar_modelo`(
in pmodelo varchar(45),
in pFK_marca int
)
BEGIN
insert INTO modelos(modelo, FK_marca)
values
(pmodelo, pFK_marca);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_insertar_ordenador` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_insertar_ordenador`(
in pnumeroSerie varchar(45),
in pcapacidad int,
in pram int,
in panotaciones varchar(200),
in pFK_modelo int
)
BEGIN
insert INTO ordenadores(numeroSerie,capacidad,ram,anotaciones,FK_modelo)
values
(pnumeroSerie,pcapacidad,pram,panotaciones,pFK_modelo);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_modificar_ordenador` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_modificar_ordenador`(
in pid int,
in pnumeroSerie varchar(45),
in pcapacidad int,
in pram int,
in panotaciones varchar(200),
in pFK_modelo int
)
BEGIN
UPDATE ordenadores o
SET  
o.numeroSerie = pnumeroSerie, 
o.capacidad = pcapacidad, 
o.ram = pram,
o.anotaciones = panotaciones,
o.FK_modelo = pFK_modelo
WHERE pid = o.id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_obtener_modelos_por_marca` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_obtener_modelos_por_marca`(IN marcaID int)
BEGIN
SELECT
*
FROM v_modelos v_m
WHERE v_m.FK_marca = marcaID;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_obtener_ordenador_por_id` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_obtener_ordenador_por_id`(IN ordenadorID INT)
BEGIN
    SELECT 
        *
    FROM 
        v_ordenadores v_o
    WHERE 
        v_o.id = ordenadorID;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_obtener_todas_marcas` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_obtener_todas_marcas`()
BEGIN
SELECT
*
FROM marcas;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_obtener_todos_modelos` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_obtener_todos_modelos`()
BEGIN
SELECT
*
FROM v_modelos v_m;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_obtener_todos_ordenadores` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_obtener_todos_ordenadores`()
BEGIN
	SELECT * FROM v_ordenadores;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Final view structure for view `v_modelos`
--

/*!50001 DROP VIEW IF EXISTS `v_modelos`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `v_modelos` AS select `mod`.`id` AS `id`,`mod`.`modelo` AS `modelo`,`mod`.`FK_marca` AS `FK_marca`,`marc`.`marca` AS `marca` from (`modelos` `mod` join `marcas` `marc`) where (`mod`.`FK_marca` = `marc`.`id`) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `v_ordenadores`
--

/*!50001 DROP VIEW IF EXISTS `v_ordenadores`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `v_ordenadores` AS select `o`.`id` AS `id`,`o`.`numeroSerie` AS `numeroSerie`,`o`.`capacidad` AS `capacidad`,`o`.`ram` AS `ram`,`o`.`anotaciones` AS `anotaciones`,`o`.`FK_modelo` AS `FK_modelo`,`mod`.`modelo` AS `modelo`,`marc`.`marca` AS `marca` from ((`ordenadores` `o` join `modelos` `mod`) join `marcas` `marc`) where ((`o`.`FK_modelo` = `mod`.`id`) and (`mod`.`FK_marca` = `marc`.`id`)) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-09-26 12:49:38
