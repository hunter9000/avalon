
-- INSERT INTO effect (type)
-- values (FIRE), (ICE);

INSERT INTO material (name, icon)
VALUES ('Wood', 'wood'), ('Iron', 'iron');

INSERT INTO material_effect (material_id, type, val, slot)
VALUES (1, 'FIRE', 5, 'BODY'),
        (2, 'FIRE', 5, 'BODY'), (2, 'ICE', 10, 'HEAD');