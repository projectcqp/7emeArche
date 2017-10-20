-- IL FAUT DESACTIVER LA VERIFICATION DES CLES ETRANGERES QUAND ON PASSE LES SCRITP DANS PHPMYADMIN
SET FOREIGN_KEY_CHECKS = 0;

INSERT INTO ligne_commande (id_ligne_commande, reference_article_ligne_commande, nom_article_ligne_commande, prix_unitaire_ligne_commande,
quantite_ligne_commande, total_ligne_commande, taux_tva_ligne_commande, id_commande_ligne_commande)
VALUES
('1', '1_livre_mat', 'Le Paris de Michel Audiard', '14.9', '1', '14.9', '20', '1'),
('2', '6_livre_demat', 'Une brève histoire du cinéma: (1895-2015)', '7.99', '1', '7.99', '20', '1'),
('3', '11_articleDivers_mat', 'Clap cinéma Hollywood', '5.37', '3', '16.11', '20', '1');

INSERT INTO commande (id_commande, date_commande, total_ht_commande, total_tva_commande, numero_commande, numero_facture_commande,
adresse_facturation_commande, adresse_livraison_commande, id_compte_commande)
VALUES
('1', '2017-10-18', '39', '7.8', '2017-10-0001', 'f-20171018-0001',
'Monsieur Jean DUPONT 1 rue du midi 75001 PARIS FRANCE', 'Monsieur Jean DUPONT 1 rue du midi 75001 PARIS FRANCE', '1');

SET FOREIGN_KEY_CHECKS = 1;