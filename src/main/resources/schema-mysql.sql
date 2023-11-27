CREATE DATABASE IF NOT EXISTS `office` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;


CREATE TABLE IF NOT EXISTS `account` (
  `user_id` int NOT NULL DEFAULT '0',
  `pwd` varchar(60) DEFAULT NULL,
  `account_state` tinyint DEFAULT '0',
  `account_permissions` int DEFAULT '0',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE IF NOT EXISTS `day_off` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int DEFAULT '0',
  `user_name` varchar(20) DEFAULT NULL,
  `team` varchar(20) DEFAULT NULL,
  `lleave` varchar(20) DEFAULT NULL,
  `leave_reason` varchar(100) DEFAULT NULL,
  `start_day` datetime DEFAULT NULL,
  `end_day` datetime DEFAULT NULL,
  `time` int DEFAULT '0',
  `pic_id` int DEFAULT '0',
  `ps` varchar(100) DEFAULT NULL,
  `auditor` varchar(20) DEFAULT NULL,
  `state` varchar(20) DEFAULT NULL,
  `fail_reason` varchar(100) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE IF NOT EXISTS `pic` (
  `pic_id` int NOT NULL AUTO_INCREMENT,
  `pic_address` varchar(2000) DEFAULT NULL,
  PRIMARY KEY (`pic_id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `user_info` (
  `user_id` int NOT NULL DEFAULT '0',
  `user_name` varchar(20) DEFAULT NULL,
  `team` varchar(20) DEFAULT NULL,
  `email` varchar(60) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `annual_leave` int DEFAULT '0',
  `sick_leave` int DEFAULT '0',
  `in_day` date DEFAULT NULL,
  `out_day` date DEFAULT NULL,
  `resign_reason` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
