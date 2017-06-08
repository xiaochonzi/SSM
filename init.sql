create database bangF  default charset utf8 COLLATE utf8_general_ci;
use bangF;

CREATE TABLE bangF.role
(
    `id` INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(8) NOT NULL ,
    `permission` INT,
    UNIQUE INDEX role_name_unidex (`name`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

create TABLE bangF.user(
    `id` int PRIMARY KEY not NULL AUTO_INCREMENT,
    `email` VARCHAR(64)  NOT NULL ,
    `username` VARCHAR(64) NOT NULL ,
    `password_hash` VARCHAR(128),
    `role_id` int,
    `confirmed` BOOL,
    `member_since` DATETIME,
    `last_seen` DATETIME,
    `avatar_hash` VARCHAR(128),
    UNIQUE INDEX `user_username_unidex` (`username`),
    UNIQUE INDEX `user_email_unidex` (`email`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE bangF.user_detail(
    `id` int PRIMARY KEY not null,
    `name` VARCHAR(64),
    `sex` VARCHAR(2),
    `birthday` VARCHAR(8),
    `location_country` VARCHAR(64),
    `location_city` VARCHAR(64),
    `about_me` TEXT,
    INDEX `user_detail_id_index` (`id`)
)ENGINE =InnoDB CHARSET =utf8;

create TABLE bangF.user_x_follow(
    `id` INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `follower_id` INT ,
    `followed_id` INT,
    INDEX `follow_follwer_unidex` (`follower_id`),
    INDEX `follow_follwed_unidex` (`followed_id`)
)ENGINE =InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE bangF.post(
    `id` int PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `title` TEXT,
    `body` TEXT,
    `create_time` DATETIME,
    `author_id` int,
    `body_html` TEXT,
    `like_num` int,
    INDEX `post_id_index` (`id`)
)ENGINE =InnoDB DEFAULT CHARSET = utf8;

CREATE table bangF.comment(
    `id` INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `body` TEXT,
    `body_html` TEXT,
    `create_time` DATETIME,
    `disabled` BOOL,
    `author_id` int,
    `post_id` int,
    `like_num` int,
    INDEX `comment_id_index` (`id`)
)ENGINE =InnoDB DEFAULT CHARSET =utf8;

create table bangF.post_x_like(
    `id` int PRIMARY KEY not null AUTO_INCREMENT,
    `post_id` int,
    `author_id` int
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table bangF.comment_x_like(
    `id` int PRIMARY KEY not null AUTO_INCREMENT,
    `comment_id` int,
    `author_id` int
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

