USE avalon;

-- run
ALTER TABLE `material` DROP COLUMN `icon`;
ALTER TABLE `material` ADD COLUMN `material_type` VARCHAR(255) NOT NULL;

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






INSERT INTO `material_effect` (material_id, type, val, slot) VALUES
(1, 'FIRE', 5, 'BODY'),
(2, 'FIRE', 5, 'BODY'),
(2, 'ICE', 10, 'HEAD');

INSERT INTO `sql_files` (`sql_file_name`, `run_date`) VALUES ('5.sql', NOW());