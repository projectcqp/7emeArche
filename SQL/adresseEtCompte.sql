-- Décocher "Activer la vérification des clés étrangères" pour la première création
-- Pour les créations suivantes commencer par créer un compte avec id_adresse "0"
-- il faut aggrandir le champs nom_adresse 10 trop petit
INSERT INTO adresse (id_adresse, nom_adresse, voie_adresse, complement_adresse, code_postal_adresse, ville_adresse, pays_adresse, id_compte_adresse)
VALUES
('0', 'test', 'test', 'test', '00000', 'test', '', '1'),
('1', 'facturatio', 'mon numéro et ma rue', '', '94100', 'SAINT MAUR DES FOSSES', '', '1'),
('3', 'pRelais', 'adresse du point relais', '', '94100', 'SAINT MAUR DES FOSSES', '', '1'),
('2', 'travail', 'numéro et rue de mon taff', '', '75013', 'PARIS', '', '1'),
('4', 'facturatio', 'numéro et rue de facturation', '', '75013', 'PARIS', '', '2'),
('5', 'domicile', 'numéro et rue domicile', '', '75013', 'PARIS', '', '2'),
('6', 'travail', 'numéro et rue de mon taff1', '', '75013', 'PARIS', '', '2'),
('7', 'travail2', 'numéro et rue de mon taff2', '', '75013', 'PARIS', '', '2');

INSERT INTO compte(id_compte, email_compte, password_compte, nom_compte, prenom_compte, telephone_compte, date_naissance_compte, id_adresse_facturation_compte)
VALUES
('1', 'email@email.com', 'password', 'NOM', 'Prenom', '0011223344', '2017-09-20', '1'),
('2', 'email2@email.com', 'password', 'NOM2', 'Prenom2', '0022446688', '2000-10-22', '4');