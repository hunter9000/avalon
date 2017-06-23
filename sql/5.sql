USE avalon;

-- run
ALTER TABLE `material` DROP COLUMN `icon`;
ALTER TABLE `material` ADD COLUMN `material_type` VARCHAR(255) NOT NULL;


-- MATERIALS
INSERT INTO `material` (name, material_type) VALUES ('Pine', 'WOOD');
INSERT INTO `material` (name, material_type) VALUES ('Fir', 'WOOD');
INSERT INTO `material` (name, material_type) VALUES ('Yew', 'WOOD');
INSERT INTO `material` (name, material_type) VALUES ('Spruce', 'WOOD');
INSERT INTO `material` (name, material_type) VALUES ('Ash', 'WOOD');
INSERT INTO `material` (name, material_type) VALUES ('Walnut', 'WOOD');
INSERT INTO `material` (name, material_type) VALUES ('Cherry', 'WOOD');
INSERT INTO `material` (name, material_type) VALUES ('Blackwood', 'WOOD');
INSERT INTO `material` (name, material_type) VALUES ('Sandalwood', 'WOOD');
INSERT INTO `material` (name, material_type) VALUES ('Ironwood', 'WOOD');
INSERT INTO `material` (name, material_type) VALUES ('Kingwood', 'WOOD');

INSERT INTO `material` (name, material_type) VALUES ('Iron', 'METAL');
INSERT INTO `material` (name, material_type) VALUES ('Tin', 'METAL');
INSERT INTO `material` (name, material_type) VALUES ('Bronze', 'METAL');
INSERT INTO `material` (name, material_type) VALUES ('Copper', 'METAL');
INSERT INTO `material` (name, material_type) VALUES ('Lead', 'METAL');
INSERT INTO `material` (name, material_type) VALUES ('Gold', 'METAL');
INSERT INTO `material` (name, material_type) VALUES ('Silver', 'METAL');
INSERT INTO `material` (name, material_type) VALUES ('Zinc', 'METAL');
INSERT INTO `material` (name, material_type) VALUES ('Quiksilver', 'METAL');
INSERT INTO `material` (name, material_type) VALUES ('Brass', 'METAL');

INSERT INTO `material` (name, material_type) VALUES ('Fleece', 'HIDE');
INSERT INTO `material` (name, material_type) VALUES ('Wool', 'HIDE');
INSERT INTO `material` (name, material_type) VALUES ('Fur', 'HIDE');
INSERT INTO `material` (name, material_type) VALUES ('Rawhide', 'HIDE');
INSERT INTO `material` (name, material_type) VALUES ('Leather', 'HIDE');

INSERT INTO `material` (name, material_type) VALUES ('Burlap', 'CLOTH');
INSERT INTO `material` (name, material_type) VALUES ('Flax', 'CLOTH');
INSERT INTO `material` (name, material_type) VALUES ('Jute', 'CLOTH');
INSERT INTO `material` (name, material_type) VALUES ('Cotton', 'CLOTH');
INSERT INTO `material` (name, material_type) VALUES ('Silk', 'CLOTH');

INSERT INTO `material` (name, material_type) VALUES ('Diamond', 'GEM');
INSERT INTO `material` (name, material_type) VALUES ('Amythest', 'GEM');
INSERT INTO `material` (name, material_type) VALUES ('Aquamarine', 'GEM');
INSERT INTO `material` (name, material_type) VALUES ('Beryl', 'GEM');
INSERT INTO `material` (name, material_type) VALUES ('Emerald', 'GEM');
INSERT INTO `material` (name, material_type) VALUES ('Citrine', 'GEM');
INSERT INTO `material` (name, material_type) VALUES ('Ruby', 'GEM');
INSERT INTO `material` (name, material_type) VALUES ('Sapphire', 'GEM');
INSERT INTO `material` (name, material_type) VALUES ('Feldspar', 'GEM');
INSERT INTO `material` (name, material_type) VALUES ('Moonstone', 'GEM');
INSERT INTO `material` (name, material_type) VALUES ('Sunstone', 'GEM');
INSERT INTO `material` (name, material_type) VALUES ('Garnet', 'GEM');
INSERT INTO `material` (name, material_type) VALUES ('Topaz', 'GEM');
INSERT INTO `material` (name, material_type) VALUES ('Hematite', 'GEM');
INSERT INTO `material` (name, material_type) VALUES ('Jasper', 'GEM');
INSERT INTO `material` (name, material_type) VALUES ('Lapis Lazuli', 'GEM');
INSERT INTO `material` (name, material_type) VALUES ('Opal', 'GEM');
INSERT INTO `material` (name, material_type) VALUES ('Quartz', 'GEM');
INSERT INTO `material` (name, material_type) VALUES ('Flint', 'GEM');
INSERT INTO `material` (name, material_type) VALUES ('Tourmaline', 'GEM');
INSERT INTO `material` (name, material_type) VALUES ('Turquoise', 'GEM');
INSERT INTO `material` (name, material_type) VALUES ('Jet', 'GEM');
INSERT INTO `material` (name, material_type) VALUES ('Coral', 'GEM');
INSERT INTO `material` (name, material_type) VALUES ('Pearl', 'GEM');
INSERT INTO `material` (name, material_type) VALUES ('Obsidian', 'GEM');

INSERT INTO `material` (name, material_type) VALUES ('Amber', 'MISC');
INSERT INTO `material` (name, material_type) VALUES ('Bone', 'MISC');
INSERT INTO `material` (name, material_type) VALUES ('Tar', 'MISC');
INSERT INTO `material` (name, material_type) VALUES ('Saltpeter', 'MISC');
INSERT INTO `material` (name, material_type) VALUES ('Sulfur', 'MISC');
INSERT INTO `material` (name, material_type) VALUES ('Clay', 'MISC');
INSERT INTO `material` (name, material_type) VALUES ('Charcoal', 'MISC');
INSERT INTO `material` (name, material_type) VALUES ('Phosphorus', 'MISC');
INSERT INTO `material` (name, material_type) VALUES ('Paper', 'MISC');



-- MAT EFFECTS
INSERT INTO `material_effect` (material_id, type, val, slot) VALUES ( (SELECT `id` FROM `material` WHERE `name`='Pine'), 'ADDED_PIERCING_RESIST', '2', 'BODY' );
INSERT INTO `material_effect` (material_id, type, val, slot) VALUES ( (SELECT `id` FROM `material` WHERE `name`='Pine'), 'LESS_FIRE_RESIST', '2', 'BODY' );
INSERT INTO `material_effect` (material_id, type, val, slot) VALUES ( (SELECT `id` FROM `material` WHERE `name`='Fir'), 'ADDED_PIERCING_RESIST', '5', 'BODY' );
INSERT INTO `material_effect` (material_id, type, val, slot) VALUES ( (SELECT `id` FROM `material` WHERE `name`='Fir'), 'LESS_FIRE_RESIST', '5', 'BODY' );
INSERT INTO `material_effect` (material_id, type, val, slot) VALUES ( (SELECT `id` FROM `material` WHERE `name`='Yew'), 'ADDED_PIERCING_RESIST', '10', 'BODY' );
INSERT INTO `material_effect` (material_id, type, val, slot) VALUES ( (SELECT `id` FROM `material` WHERE `name`='Yew'), 'LESS_FIRE_RESIST', '10', 'BODY' );

-- ITEMS
INSERT INTO `item` (name, body_slot) VALUES ('Copper Sword', 'LEFT_HAND');
INSERT INTO `item` (name, body_slot) VALUES ('Bronze Sword', 'LEFT_HAND');
INSERT INTO `item` (name, body_slot) VALUES ('Iron Sword', 'LEFT_HAND');

INSERT INTO `item` (name, body_slot) VALUES ('Quarterstaff', 'LEFT_HAND');

INSERT INTO `item` (name, body_slot) VALUES ('Brass Ring', 'RING');

INSERT INTO `item` (name, body_slot) VALUES ('Silver Amulet', 'NECK');
INSERT INTO `item` (name, body_slot) VALUES ('Gold Amulet', 'NECK');

INSERT INTO `item` (name, body_slot) VALUES ('Hide Armor', 'BODY');

INSERT INTO `item` (name, body_slot) VALUES ('Grimoire', 'LEFT_HAND');


-- RECIPES
INSERT INTO `recipe` (item_id, extra_capacity) VALUES ( (SELECT id FROM item WHERE name = 'Copper Sword'), '10');
INSERT INTO `recipe` (item_id, extra_capacity) VALUES ( (SELECT id FROM item WHERE name = 'Bronze Sword'), '15');
INSERT INTO `recipe` (item_id, extra_capacity) VALUES ( (SELECT id FROM item WHERE name = 'Iron Sword'), '20');

INSERT INTO `recipe` (item_id, extra_capacity) VALUES ( (SELECT id FROM item WHERE name = 'Quarterstaff'), '10');

INSERT INTO `recipe` (item_id, extra_capacity) VALUES ( (SELECT id FROM item WHERE name = 'Brass Ring'), '7');

INSERT INTO `recipe` (item_id, extra_capacity) VALUES ( (SELECT id FROM item WHERE name = 'Silver Amulet'), '5');
INSERT INTO `recipe` (item_id, extra_capacity) VALUES ( (SELECT id FROM item WHERE name = 'Gold Amulet'), '10');

INSERT INTO `recipe` (item_id, extra_capacity) VALUES ( (SELECT id FROM item WHERE name = 'Hide Armor'), '15');

INSERT INTO `recipe` (item_id, extra_capacity) VALUES ( (SELECT id FROM item WHERE name = 'Grimoire'), '7');


-- RECIPE REQUIREMENTS
INSERT INTO `recipe_requirement` (`material_id`, `recipe_id`, `quantity`) VALUES ( (SELECT id FROM `material` WHERE name = 'Copper'), (SELECT r.id FROM `recipe` r JOIN `item` i ON r.item_id = i.id WHERE i.name = 'Copper Sword'), '3');
INSERT INTO `recipe_requirement` (`material_id`, `recipe_id`, `quantity`) VALUES ( (SELECT id FROM `material` WHERE name = 'Copper'), (SELECT r.id FROM `recipe` r JOIN `item` i ON r.item_id = i.id WHERE i.name = 'Bronze Sword'), '2');
INSERT INTO `recipe_requirement` (`material_id`, `recipe_id`, `quantity`) VALUES ( (SELECT id FROM `material` WHERE name = 'Tin'), (SELECT r.id FROM `recipe` r JOIN `item` i ON r.item_id = i.id WHERE i.name = 'Bronze Sword'), '2');
INSERT INTO `recipe_requirement` (`material_id`, `recipe_id`, `quantity`) VALUES ( (SELECT id FROM `material` WHERE name = 'Iron'), (SELECT r.id FROM `recipe` r JOIN `item` i ON r.item_id = i.id WHERE i.name = 'Iron Sword'), '5');

INSERT INTO `recipe_requirement` (`material_id`, `recipe_id`, `quantity`) VALUES ( (SELECT id FROM `material` WHERE name = 'Pine'), (SELECT r.id FROM `recipe` r JOIN `item` i ON r.item_id = i.id WHERE i.name = 'Quarterstaff'), '4');

INSERT INTO `recipe_requirement` (`material_id`, `recipe_id`, `quantity`) VALUES ( (SELECT id FROM `material` WHERE name = 'Brass'), (SELECT r.id FROM `recipe` r JOIN `item` i ON r.item_id = i.id WHERE i.name = 'Brass Ring'), '2');

INSERT INTO `recipe_requirement` (`material_id`, `recipe_id`, `quantity`) VALUES ( (SELECT id FROM `material` WHERE name = 'Silver'), (SELECT r.id FROM `recipe` r JOIN `item` i ON r.item_id = i.id WHERE i.name = 'Silver Amulet'), '2');
INSERT INTO `recipe_requirement` (`material_id`, `recipe_id`, `quantity`) VALUES ( (SELECT id FROM `material` WHERE name = 'Gold'), (SELECT r.id FROM `recipe` r JOIN `item` i ON r.item_id = i.id WHERE i.name = 'Gold Amulet'), '3');

INSERT INTO `recipe_requirement` (`material_id`, `recipe_id`, `quantity`) VALUES ( (SELECT id FROM `material` WHERE name = 'Rawhide'), (SELECT r.id FROM `recipe` r JOIN `item` i ON r.item_id = i.id WHERE i.name = 'Hide Armor'), '5');

INSERT INTO `recipe_requirement` (`material_id`, `recipe_id`, `quantity`) VALUES ( (SELECT id FROM `material` WHERE name = 'Paper'), (SELECT r.id FROM `recipe` r JOIN `item` i ON r.item_id = i.id WHERE i.name = 'Grimoire'), '10');


INSERT INTO `sql_files` (`sql_file_name`, `run_date`) VALUES ('5.sql', NOW());