-- Décocher "Activer la vérification des clés étrangères" pour la première création
-- Pour les créations suivantes commencer par créer un compte avec id_adresse "0"
-- il faut aggrandir le champs nom_adresse 10 trop petit
INSERT INTO adresse (id_adresse, nom_adresse, voie_adresse, complement_adresse, code_postal_adresse, ville_adresse, pays_adresse, id_compte_adresse)
VALUES
('0', 'test', 'test', 'test', '00000', 'test', '', '1'),
('1', 'facturation', '1 rue du midi', '', '75001', 'PARIS', 'FRANCE', '1'),
('3', 'pRelais', '2 rue du midi', '', '75001', 'PARIS', 'FRANCE', '1'),
('2', 'travail', '3 rue du midi', '', '75001', 'PARIS', 'FRANCE', '1'),
('4', 'facturation', '4 rue du midi', '', '75001', 'PARIS', 'FRANCE', '2'),
('5', 'domicile', '5 rue du midi', '', '75001', 'PARIS', 'FRANCE', '2'),
('6', 'travail', '6 rue du midi', '', '75001', 'PARIS', 'FRANCE', '2'),
('7', 'travail2', '7 rue du midi', '', '75001', 'PARIS', 'FRANCE', '2');

INSERT INTO compte(id_compte, email_compte, password_compte, titre_compte, nom_compte, prenom_compte, telephone_compte, date_naissance_compte, id_adresse_facturation_compte)
VALUES
('1', 'jeandupont@gmail.com', 'password', 'Monsieur', 'DUPONT', 'Jean', '0011223344', '2017-09-20', '1'),
('2', 'clairedupond@email.com', 'password', 'Madame', 'DUPOND', 'Claire', '0022446688', '2000-10-22', '4');