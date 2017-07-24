USE avalon;

CREATE TABLE `equipped_item` (
	`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
	`character_id` BIGINT(20) NOT NULL,
	`equipment` BIGINT(20) NOT NULL,
	`equipment_slot` VARCHAR(255) NOT NULL,
	PRIMARY KEY (`id`),
	INDEX `equipped_item__character_id` (`character_id`),
	INDEX `equipped_item__equipment` (`equipment`),
	CONSTRAINT `equipped_item__character_id` FOREIGN KEY (`character_id`) REFERENCES `characters` (`id`),
	CONSTRAINT `equipped_item__equipment` FOREIGN KEY (`equipment`) REFERENCES `equipment_item` (`id`)
)
COLLATE='utf8_general_ci' ENGINE=InnoDB;

INSERT INTO `sql_files` (`sql_file_name`, `run_date`) VALUES ('6.sql', NOW());