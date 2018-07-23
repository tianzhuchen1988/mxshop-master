create database test;
use test;

CREATE TABLE `account` (
  `account_id` int(11) NOT NULL AUTO_INCREMENT,
  `account_name` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `account_password` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`account_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE `product` (
  `product_id` int(11) NOT NULL AUTO_INCREMENT,
  `product_name` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1002 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1003 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO `test`.`account` (`account_name`, `account_password`) VALUES ('chentz', 'chentz');
INSERT INTO `test`.`user` (`user_name`, `age`) VALUES ('chentz', 30);

ALTER TABLE `test`.`user`
ADD COLUMN `gender` VARCHAR(3) NULL AFTER `age`;

ALTER TABLE `test`.`account`
CHANGE COLUMN `account_name` `account_name` VARCHAR(100) CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_unicode_ci' NULL DEFAULT NULL ,
CHANGE COLUMN `account_password` `account_password` VARCHAR(100) CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_unicode_ci' NULL DEFAULT NULL ;

ALTER TABLE `test`.`user`
CHANGE COLUMN `gender` `gender` CHAR(1) CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_unicode_ci' NULL DEFAULT NULL ;

