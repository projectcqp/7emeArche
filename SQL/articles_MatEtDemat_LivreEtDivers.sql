-- Décocher "Activer la vérification des clés étrangères"
-- Mettre les materialise ou dematerialise à NULL dans article
INSERT INTO materialise (id_materialise, etat_materialise)
VALUES
('1', 'NEUF'),
('2', 'OCCASION_BON'),
('3', 'OCCASION_USAGE');

INSERT INTO dematerialise (id_dematerialise, format_dematerialise, url_download_dematerialise)
VALUES
('4', 'PDF', 'url download demat id4'),
('5', 'KINDLE', 'url download demat id5'),
('6', 'MP4', 'url download demat id6');

INSERT INTO livre (id_article_livre, auteur_livre, isbn_livre, editeur_livre, genre_livre, date_livre)
VALUES
('3', 'auteur_livre 3', 'isbn_livre 3', 'editeur_livre 3', 'genre_livre 3', '2000-01-01'),
('4', 'auteur_livre 4', 'isbn_livre 4', 'editeur_livre 4', 'genre_livre 4', '2000-01-01'),
('5', 'auteur_livre 5', 'isbn_livre 5', 'editeur_livre 5', 'genre_livre 5', '2000-01-01');

INSERT INTO article_divers (id_article_article_divers, type_article_divers)
VALUES
('1', 'AFFICHE'),
('2', 'DVD'),
('6', 'FILM');

INSERT INTO article (id_article, reference_article, prix_ht_article, nom_article, description_article, url_image_article, id_materialise_article, id_dematerialise_article, stock_article, type_article, id_tva_article)
VALUES
('1', 'ref article 1', '10.00', 'Nom affiche id 1', 'description_article 1', 'url_image_article 1', '1', NULL, '10', 'ArticleDivers', '3'),
('2', 'ref article 2', '11.10', 'Nom dvd id 2', 'description_article 2', 'url_image_article 2', '2', NULL, '10', 'ArticleDivers', '3'),
('3', 'ref article 3', '12.50', 'Nom livre id 3', 'description_article 3', 'url_image_article 3', '3', NULL, '10', 'Livre', '3'),
('4', 'ref article 4', '15.00', 'Nom livre id 4', 'description_article 4', 'url_image_article 4', NULL, '4', '1', 'Livre', '3'),
('5', 'ref article 5', '18.35', 'Nom livre id 5', 'description_article 5', 'url_image_article 5', NULL, '5', '1', 'Livre', '3'),
('6', 'ref article 6', '25.99', 'Nom film id 6', 'description_article 6', 'url_image_article 6', NULL, '6', '1', 'ArticleDivers', '3');