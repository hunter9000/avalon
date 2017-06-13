USE avalon;

CREATE TABLE `character_recipe` (
	`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
	`char_id` BIGINT(20) NULL DEFAULT NULL,
	`recipe_id` BIGINT(20) NULL DEFAULT NULL,
	PRIMARY KEY (`id`),
	INDEX `FK_42nk68mq6w8f3ppxpf3jnmc8u` (`recipe_id`),
	INDEX `FK_8xu3xiyumhckt5rd36k026l8h` (`char_id`),
	CONSTRAINT `FK_42nk68mq6w8f3ppxpf3jnmc8u` FOREIGN KEY (`recipe_id`) REFERENCES `recipe` (`id`),
	CONSTRAINT `FK_8xu3xiyumhckt5rd36k026l8h` FOREIGN KEY (`char_id`) REFERENCES `characters` (`id`)
)
COLLATE='utf8_general_ci' ENGINE=InnoDB;

CREATE TABLE `equipment_item` (
	`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
	`char_id` BIGINT(20) NULL DEFAULT NULL,
	`item_id` BIGINT(20) NULL DEFAULT NULL,
	PRIMARY KEY (`id`),
	INDEX `FK_gnln6ym65mfbkt2kik93le9am` (`char_id`),
	INDEX `FK_p8j9tkx5eiptbrx84abhhn5v8` (`item_id`),
	CONSTRAINT `FK_gnln6ym65mfbkt2kik93le9am` FOREIGN KEY (`char_id`) REFERENCES `characters` (`id`),
	CONSTRAINT `FK_p8j9tkx5eiptbrx84abhhn5v8` FOREIGN KEY (`item_id`) REFERENCES `item` (`id`)
)
COLLATE='utf8_general_ci' ENGINE=InnoDB;

CREATE TABLE `inventory_material` (
	`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
	`quantity` INT(11) NULL DEFAULT NULL,
	`char_id` BIGINT(20) NULL DEFAULT NULL,
	`material_id` BIGINT(20) NULL DEFAULT NULL,
	PRIMARY KEY (`id`),
	INDEX `FK_ppmog95nvjd7j1hd126nhyhh9` (`char_id`),
	INDEX `FK_leim1ru6c3efkqsgsfi43d9bo` (`material_id`),
	CONSTRAINT `FK_leim1ru6c3efkqsgsfi43d9bo` FOREIGN KEY (`material_id`) REFERENCES `material` (`id`),
	CONSTRAINT `FK_ppmog95nvjd7j1hd126nhyhh9` FOREIGN KEY (`char_id`) REFERENCES `characters` (`id`)
)
COLLATE='utf8_general_ci' ENGINE=InnoDB;



CREATE TABLE `material_effect` (
	`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
	`type` VARCHAR(255) NULL DEFAULT NULL,
	`slot` VARCHAR(255) NULL DEFAULT NULL,
	`val` INT(11) NULL DEFAULT NULL,
	`material_id` BIGINT(20) NULL DEFAULT NULL,
	PRIMARY KEY (`id`),
	INDEX `FK_723aryaw1as6ihgj6ch2ogi14` (`material_id`),
	CONSTRAINT `FK_723aryaw1as6ihgj6ch2ogi14` FOREIGN KEY (`material_id`) REFERENCES `material` (`id`)
)
COLLATE='utf8_general_ci' ENGINE=InnoDB;

CREATE TABLE `recipe_requirement` (
	`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
	`quantity` INT(11) NULL DEFAULT NULL,
	`material_id` BIGINT(20) NULL DEFAULT NULL,
	`recipe_id` BIGINT(20) NULL DEFAULT NULL,
	PRIMARY KEY (`id`),
	INDEX `FK_cuvx0xtu5vu7s7gas0uhcv0nl` (`material_id`),
	INDEX `FK_t568mtnmmu1u5spbai32j0vhg` (`recipe_id`),
	CONSTRAINT `FK_cuvx0xtu5vu7s7gas0uhcv0nl` FOREIGN KEY (`material_id`) REFERENCES `material` (`id`),
	CONSTRAINT `FK_t568mtnmmu1u5spbai32j0vhg` FOREIGN KEY (`recipe_id`) REFERENCES `recipe` (`id`)
)
COLLATE='utf8_general_ci' ENGINE=InnoDB;


CREATE TABLE `item_effect` (
	`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
	`equipment_id` BIGINT(20) NULL DEFAULT NULL,
	`material_effect_id` BIGINT(20) NULL DEFAULT NULL,
	PRIMARY KEY (`id`),
	INDEX `FK_3h0p4sj6ttkc4wqx30396wucf` (`equipment_id`),
	INDEX `FK_4hydy8fpfc1ja4j83j5iero7x` (`material_effect_id`),
	CONSTRAINT `FK_3h0p4sj6ttkc4wqx30396wucf` FOREIGN KEY (`equipment_id`) REFERENCES `equipment_item` (`id`),
	CONSTRAINT `FK_4hydy8fpfc1ja4j83j5iero7x` FOREIGN KEY (`material_effect_id`) REFERENCES `material_effect` (`id`)
)
COLLATE='utf8_general_ci' ENGINE=InnoDB;

INSERT INTO `sql_files` (`sql_file_name`, `run_date`) VALUES ('4.sql', NOW());