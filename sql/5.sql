USE avalon;

-- run
ALTER TABLE `material` DROP COLUMN `icon`;
ALTER TABLE `material` ADD COLUMN `material_type` VARCHAR(255) NOT NULL;
ALTER TABLE `material` ADD COLUMN `capacity_requirement` INTEGER(11) NOT NULL;

-- MATERIALS
INSERT INTO `material` (name, material_type, capacity_requirement) VALUES ('Pine', 'WOOD', 1);
INSERT INTO `material` (name, material_type, capacity_requirement) VALUES ('Fir', 'WOOD', 2);
INSERT INTO `material` (name, material_type, capacity_requirement) VALUES ('Yew', 'WOOD', 3);
INSERT INTO `material` (name, material_type, capacity_requirement) VALUES ('Spruce', 'WOOD', 4);
INSERT INTO `material` (name, material_type, capacity_requirement) VALUES ('Ash', 'WOOD', 5);
INSERT INTO `material` (name, material_type, capacity_requirement) VALUES ('Walnut', 'WOOD', 6);
INSERT INTO `material` (name, material_type, capacity_requirement) VALUES ('Cherry', 'WOOD', 7);
INSERT INTO `material` (name, material_type, capacity_requirement) VALUES ('Blackwood', 'WOOD', 8);
INSERT INTO `material` (name, material_type, capacity_requirement) VALUES ('Sandalwood', 'WOOD', 9);
INSERT INTO `material` (name, material_type, capacity_requirement) VALUES ('Ironwood', 'WOOD', 10);
INSERT INTO `material` (name, material_type, capacity_requirement) VALUES ('Kingwood', 'WOOD', 11);

INSERT INTO `material` (name, material_type, capacity_requirement) VALUES ('Iron', 'METAL', 1);
INSERT INTO `material` (name, material_type, capacity_requirement) VALUES ('Tin', 'METAL', 2);
INSERT INTO `material` (name, material_type, capacity_requirement) VALUES ('Bronze', 'METAL', 3);
INSERT INTO `material` (name, material_type, capacity_requirement) VALUES ('Copper', 'METAL', 4);
INSERT INTO `material` (name, material_type, capacity_requirement) VALUES ('Lead', 'METAL', 5);
INSERT INTO `material` (name, material_type, capacity_requirement) VALUES ('Gold', 'METAL', 6);
INSERT INTO `material` (name, material_type, capacity_requirement) VALUES ('Silver', 'METAL', 7);
INSERT INTO `material` (name, material_type, capacity_requirement) VALUES ('Zinc', 'METAL', 8);
INSERT INTO `material` (name, material_type, capacity_requirement) VALUES ('Quiksilver', 'METAL', 9);
INSERT INTO `material` (name, material_type, capacity_requirement) VALUES ('Brass', 'METAL', 10);

INSERT INTO `material` (name, material_type, capacity_requirement) VALUES ('Fleece', 'HIDE', 1);
INSERT INTO `material` (name, material_type, capacity_requirement) VALUES ('Wool', 'HIDE', 2);
INSERT INTO `material` (name, material_type, capacity_requirement) VALUES ('Fur', 'HIDE', 3);
INSERT INTO `material` (name, material_type, capacity_requirement) VALUES ('Rawhide', 'HIDE', 4);
INSERT INTO `material` (name, material_type, capacity_requirement) VALUES ('Leather', 'HIDE', 5);

INSERT INTO `material` (name, material_type, capacity_requirement) VALUES ('Burlap', 'CLOTH', 1);
INSERT INTO `material` (name, material_type, capacity_requirement) VALUES ('Flax', 'CLOTH', 2);
INSERT INTO `material` (name, material_type, capacity_requirement) VALUES ('Jute', 'CLOTH', 3);
INSERT INTO `material` (name, material_type, capacity_requirement) VALUES ('Cotton', 'CLOTH', 4);
INSERT INTO `material` (name, material_type, capacity_requirement) VALUES ('Silk', 'CLOTH', 5);

INSERT INTO `material` (name, material_type, capacity_requirement) VALUES ('Diamond', 'GEM', 1);
INSERT INTO `material` (name, material_type, capacity_requirement) VALUES ('Amythest', 'GEM', 1);
INSERT INTO `material` (name, material_type, capacity_requirement) VALUES ('Aquamarine', 'GEM', 1);
INSERT INTO `material` (name, material_type, capacity_requirement) VALUES ('Beryl', 'GEM', 2);
INSERT INTO `material` (name, material_type, capacity_requirement) VALUES ('Emerald', 'GEM', 2);
INSERT INTO `material` (name, material_type, capacity_requirement) VALUES ('Citrine', 'GEM', 2);
INSERT INTO `material` (name, material_type, capacity_requirement) VALUES ('Ruby', 'GEM', 3);
INSERT INTO `material` (name, material_type, capacity_requirement) VALUES ('Sapphire', 'GEM', 3);
INSERT INTO `material` (name, material_type, capacity_requirement) VALUES ('Feldspar', 'GEM', 3);
INSERT INTO `material` (name, material_type, capacity_requirement) VALUES ('Moonstone', 'GEM', 4);
INSERT INTO `material` (name, material_type, capacity_requirement) VALUES ('Sunstone', 'GEM', 4);
INSERT INTO `material` (name, material_type, capacity_requirement) VALUES ('Garnet', 'GEM', 4);
INSERT INTO `material` (name, material_type, capacity_requirement) VALUES ('Topaz', 'GEM', 5);
INSERT INTO `material` (name, material_type, capacity_requirement) VALUES ('Hematite', 'GEM', 5);
INSERT INTO `material` (name, material_type, capacity_requirement) VALUES ('Jasper', 'GEM', 5);
INSERT INTO `material` (name, material_type, capacity_requirement) VALUES ('Lapis Lazuli', 'GEM', 6);
INSERT INTO `material` (name, material_type, capacity_requirement) VALUES ('Opal', 'GEM', 6);
INSERT INTO `material` (name, material_type, capacity_requirement) VALUES ('Quartz', 'GEM', 6);
INSERT INTO `material` (name, material_type, capacity_requirement) VALUES ('Flint', 'GEM', 7);
INSERT INTO `material` (name, material_type, capacity_requirement) VALUES ('Tourmaline', 'GEM', 7);
INSERT INTO `material` (name, material_type, capacity_requirement) VALUES ('Turquoise', 'GEM', 7);
INSERT INTO `material` (name, material_type, capacity_requirement) VALUES ('Jet', 'GEM', 8);
INSERT INTO `material` (name, material_type, capacity_requirement) VALUES ('Coral', 'GEM', 8);
INSERT INTO `material` (name, material_type, capacity_requirement) VALUES ('Pearl', 'GEM', 8);
INSERT INTO `material` (name, material_type, capacity_requirement) VALUES ('Obsidian', 'GEM', 9);

INSERT INTO `material` (name, material_type, capacity_requirement) VALUES ('Amber', 'MISC', 1);
INSERT INTO `material` (name, material_type, capacity_requirement) VALUES ('Bone', 'MISC', 2);
INSERT INTO `material` (name, material_type, capacity_requirement) VALUES ('Tar', 'MISC', 3);
INSERT INTO `material` (name, material_type, capacity_requirement) VALUES ('Saltpeter', 'MISC', 4);
INSERT INTO `material` (name, material_type, capacity_requirement) VALUES ('Sulfur', 'MISC', 5);
INSERT INTO `material` (name, material_type, capacity_requirement) VALUES ('Clay', 'MISC', 6);
INSERT INTO `material` (name, material_type, capacity_requirement) VALUES ('Charcoal', 'MISC', 7);
INSERT INTO `material` (name, material_type, capacity_requirement) VALUES ('Phosphorus', 'MISC', 8);
INSERT INTO `material` (name, material_type, capacity_requirement) VALUES ('Paper', 'MISC', 9);




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