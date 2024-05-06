-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: localhost    Database: ecommerce
-- ------------------------------------------------------
-- Server version	8.0.30

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
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `id` bigint NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `image_name` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` double NOT NULL,
  `weight` double NOT NULL,
  `category_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK7l29ekt1x29jup80y2iigimyy` (`category_id`),
  CONSTRAINT `FK7l29ekt1x29jup80y2iigimyy` FOREIGN KEY (`category_id`) REFERENCES `category` (`category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (8,'     Manufacturer ‏ : ‎ Kusum fashion\r\n    ASIN ‏ : ‎ B0BH9D26RF\r\n    Item model number ‏ : ‎ Kusum36@\r\n    Manufacturer ‏ : ‎ Kusum fashion\r\n\r\n    Best Sellers Rank: #63,555 in Clothing & Accessories (See Top 100 in Clothing & Accessories) ','kurtha.jpg','Green printed kurthi',399,12,5),(9,' Package Dimensions ‏ : ‎ 29.2 x 24.5 x 3.9 cm; 350 Grams\r\n    Date First Available ‏ : ‎ 20 January 2022\r\n    Manufacturer ‏ : ‎ Amazon Brand - Symbol\r\n    ASIN ‏ : ‎ B085J9BLWC\r\n    Item model number ‏ : ‎ SS20/SY/DNM-ART028\r\n    Manufacturer ‏ : ‎ Amaz','jean.jpg','jean',699,18,1),(11,'Package Dimensions ‏ : ‎ 36.3 x 27.8 x 3.7 cm; 260 Grams\r\n    Date First Available ‏ : ‎ 29 June 2020\r\n    Manufacturer ‏ : ‎ Amazon Brand - Symbol\r\n    ASIN ‏ : ‎ B083JN53YW\r\n    Item model number ‏ : ‎ 2VN02\r\n    Manufacturer ‏ : ‎ Amazon Brand - Symbol','T-shirt.jpg','T-shirt',270,10,3),(35,'ggfgh','Jaipur Kurtha.jpg','kurtha',799,29,5),(36,'Package Dimensions ‏ : ‎ 29.2 x 24.5 x 3.9 cm; 350 Grams Date First Available ‏ : ‎ 20 January 2022 Manufacturer ‏ : ‎ Amazon Brand - Symbol ASIN ‏ : ‎ B085J9BLWC Item model number ‏ : ‎ SS20/SY/DNM-ART028 Manufacturer ‏ : ‎ Amaz','Neostreak Men\'s Slim Fit Stretchable Jeans.jpg','mens-cotton-formal-pant',800,344,1),(46,' Product Dimensions ‏ : ‎ 28 x 22 x 2 cm; 350 Grams\r\nDate First Available ‏ : ‎ 12 April 2022\r\nManufacturer ‏ : ‎ ANNI DESIGNER\r\nASIN ‏ : ‎ B09XT8B9YK\r\nItem model number ‏ : ‎ Fulkali\r\nDepartment ‏ : ‎ Women\r\nManufacturer ‏ : ‎ ANNI DESIGNER ','MultiColor Rayon.jpg','kurthi',1178,23,5),(47,' Product Dimensions ‏ : ‎ 30 x 24 x 1 cm; 220 Grams\r\nDate First Available ‏ : ‎ 27 July 2022\r\nManufacturer ‏ : ‎ Mensa Brands Technologies Pvt Ltd\r\nASIN ‏ : ‎ B0B7RKFPH1\r\nItem model number ‏ : ‎ C301\r\nDepartment ‏ : ‎ Men ','Mens Shirt.jpg','shirt',800,19,3);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-02-01 13:29:29
