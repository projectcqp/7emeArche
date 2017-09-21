SET FOREIGN_KEY_CHECKS=0
INSERT INTO adresse (id_adresse, nom_adresse, voie_adresse, complement_adresse, code_postal_adresse, ville_adresse, pays_adresse, id_compte_adresse)
VALUES 
('1', 'domicile', 'mon numéro et ma rue', '', '94100', 'SAINT MAUR DES FOSSES', '', '1'),
('3', 'point relais', 'adresse du point relais', '', '94100', 'SAINT MAUR DES FOSSES', '', '1'),
('2', 'travail', 'numéro et rue de mon taff', '', '75013', 'PARIS', '', '1');
INSERT INTO compte(id_compte, email_compte, password_compte, nom_compte, prenom_compte, telephone_compte, date_naissance_compte, id_adresse_facturation_compte)
VALUES ('1', 'email@email.com', 'password', 'NOM', 'Prenom', '0011223344', '2017-09-20', '1');
SET FOREIGN_KEY_CHECKS=1