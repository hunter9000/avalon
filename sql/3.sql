USE avalon;

CREATE TABLE `item` (
	`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
	`body_slot` VARCHAR(255) NULL DEFAULT NULL,
	`name` VARCHAR(255) NULL DEFAULT NULL,
	PRIMARY KEY (`id`)
)
COLLATE='utf8_general_ci' ENGINE=InnoDB;


CREATE TABLE `recipe` (
	`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
	`extra_capacity` INT(11) NULL DEFAULT NULL,
	`item_id` BIGINT(20) NULL DEFAULT NULL,
	PRIMARY KEY (`id`),
	INDEX `FK_7d6t52l3orld2foqgoi45qisv` (`item_id`),
	CONSTRAINT `FK_7d6t52l3orld2foqgoi45qisv` FOREIGN KEY (`item_id`) REFERENCES `item` (`id`)
)
COLLATE='utf8_general_ci' ENGINE=InnoDB;


CREATE TABLE `material` (
	`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
	`icon` VARCHAR(255) NULL DEFAULT NULL,
	`name` VARCHAR(255) NULL DEFAULT NULL,
	PRIMARY KEY (`id`)
)
COLLATE='utf8_general_ci' ENGINE=InnoDB;





CREATE TABLE `map` (
	`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
	`boss_level` BIT(1) NULL DEFAULT NULL,
	`char_id` BIGINT(20) NULL DEFAULT NULL,
	PRIMARY KEY (`id`),
	INDEX `FK_hv7rnaxnoy9w6kx77u0onx7bi` (`char_id`)
)
COLLATE='utf8_general_ci' ENGINE=InnoDB;

CREATE TABLE `cell` (
	`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
	`ground_type` VARCHAR(255) NULL DEFAULT NULL,
	`cell_x` INT(11) NULL DEFAULT NULL,
	`cell_y` INT(11) NULL DEFAULT NULL,
	`map_id` BIGINT(20) NULL DEFAULT NULL,
	PRIMARY KEY (`id`),
	INDEX `FK_29u9ni1kogh5hg64wknfshnvr` (`map_id`),
	CONSTRAINT `FK_29u9ni1kogh5hg64wknfshnvr` FOREIGN KEY (`map_id`) REFERENCES `map` (`id`)
)
COLLATE='utf8_general_ci' ENGINE=InnoDB;


CREATE TABLE `characters` (
	`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
	`map_x` INT(11) NULL DEFAULT NULL,
	`map_y` INT(11) NULL DEFAULT NULL,
	`name` VARCHAR(255) NULL DEFAULT NULL,
	`curr_map_id` BIGINT(20) NULL DEFAULT NULL,
	`user_id` BIGINT(20) NULL DEFAULT NULL,
	PRIMARY KEY (`id`),
	INDEX `FK_tml8qvj6k5l5x7fvyym6cmwaw` (`curr_map_id`),
	INDEX `FK_3r882i418xbsbcayej5g1gowx` (`user_id`),
	CONSTRAINT `FK_3r882i418xbsbcayej5g1gowx` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
	CONSTRAINT `FK_tml8qvj6k5l5x7fvyym6cmwaw` FOREIGN KEY (`curr_map_id`) REFERENCES `map` (`id`)
)
COLLATE='utf8_general_ci' ENGINE=InnoDB;


ALTER TABLE `map` ADD CONSTRAINT `FK_hv7rnaxnoy9w6kx77u0onx7bi` FOREIGN KEY (`char_id`) REFERENCES `characters` (`id`);

INSERT INTO `sql_files` (`sql_file_name`, `run_date`) VALUES ('3.sql', NOW());