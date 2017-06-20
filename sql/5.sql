USE avalon;

INSERT INTO `material`
(name, icon)
VALUES
('Wood', 'wood'),
('Iron', 'iron');


INSERT INTO `material_effect`
(material_id, type, val, slot)
VALUES
(1, 'FIRE', 5, 'BODY'),
(2, 'FIRE', 5, 'BODY'),
(2, 'ICE', 10, 'HEAD');

INSERT INTO `sql_files` (`sql_file_name`, `run_date`) VALUES ('5.sql', NOW());