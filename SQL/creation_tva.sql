SET foreign_key_checks = 0;
INSERT INTO tva(id_tva, libelle_tva, taux_tva)
VALUES
('1', 'réduit', '5.5'),
('2', 'intermédiaire', '10'),
('3', 'normal', '20'),
('0', 'Exonéré', '0');
SET foreign_key_checks = 1;