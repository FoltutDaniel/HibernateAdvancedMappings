CREATE SCHEMA `hb-03-one-to-many`;

USE `hb-03-one-to-many`;

CREATE TABLE `instructor_detail` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
    `youtube_channel` varchar(128) DEFAULT NULL,
     `hobby` varchar(45) DEFAULT NULL,
     PRIMARY KEY(`id`)
     ) auto_increment=1;
     
CREATE TABLE `instructor` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
    `first_name` varchar(45) DEFAULT NULL,
    `last_name` varchar(45) DEFAULT NULL,
    `email` varchar(45) DEFAULT NULL,
    `instructor_details_id` int(11) DEFAULT NULL,
    PRIMARY KEY(`id`),
    KEY `FK_DETAIL_idx` (`instructor_details_id`),
    CONSTRAINT `FK_DETAIL` foreign key (`instructor_details_id`)
    REFERENCES `instructor_detail` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) AUTO_INCREMENT=1;

CREATE TABLE `course` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
    `title` varchar(128) DEFAULT NULL,
    `instructor_id` int(11) DEFAULT NULL,
    PRIMARY KEY(`id`),
    UNIQUE KEY `TITLE_UNIQUE` (`title`),
    KEY `FK_INSTRUCTOR_idx` (`instructor_id`),
    CONSTRAINT `FK_INSTRUCTOR` FOREIGN KEY(`instructor_id`) REFERENCES `instructor` (`id`)
    ON DELETE NO ACTION ON UPDATE NO ACTION
    )AUTO_INCREMENT=1;