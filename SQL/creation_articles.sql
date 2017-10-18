-- Décocher "Activer la vérification des clés étrangères"
-- Mettre les materialise ou dematerialise à NULL dans article
INSERT INTO materialise (id_materialise, etat_materialise)
VALUES
('1', 'NEUF'),
('2', 'NEUF'),
('3', 'OCCASION_BON'),
('4', 'OCCASION_USAGE'),
('5', 'OCCASION_MOYEN'),
('7', 'OCCASION_TRES_BON'),
('9', 'NEUF'),
('10', 'NEUF'),
('11', 'NEUF');

INSERT INTO dematerialise (id_dematerialise, format_dematerialise, url_download_dematerialise)
VALUES
('6', 'KINDLE', 'url_download_demat_6'),
('8', 'KINDLE', 'url_download_demat_8');

INSERT INTO livre (id_article_livre, auteur_livre, isbn_livre, editeur_livre, genre_livre, date_livre)
VALUES
('1', 'Philippe Lombard', '978-2840969914', 'Parigramme', 'photo', '2017-02-02'),
('2', 'Philip Kemp', '978-2081266162', 'Flammarion', 'cinéma', '2011-02-11'),
('3', 'Laurent Delmas', '978-2035941725', 'Larousse', 'cinéma', '2017-09-27'),
('4', 'Jennifer Van Sijll', '978-2212117615', 'Eyrolles', 'cinéma', '2006-02-16'),
('5', 'Laurent Jullier', '978-2818504819', 'Fayard/Pluriel', 'cinéma', '2017-05-31'),
('6', 'Laurent Jullier', 'B071DTK1TG', 'Fayard/Pluriel', 'cinéma', '2017-05-31'),
('7', 'Vincent Amiel', '978-2200619831', 'Armand Colin', 'cinéma', '2017-08-16'),
('8', 'Vincent Amiel', 'B074P18YLF', 'Armand Colin', 'cinéma', '2017-08-16');

INSERT INTO article_divers (id_article_article_divers, type_article_divers)
VALUES
('9', 'AFFICHE'),
('10', 'AFFICHE'),
('11', 'ACCESSOIRE');

INSERT INTO article (id_article, reference_article, prix_ht_article, nom_article, description_article,
url_image_article, id_materialise_article, id_dematerialise_article, stock_article, type_article, id_tva_article)
VALUES
('1', '1_livre_mat', '14.90', 'Le Paris de Michel Audiard', 'Paris a connu bien des périodes de vie. Le temps de Michel Audiard n''est pas la moins riche et la moins suprenante de ces époques extraordinaires. Né dans le 14e arrondissement, Michel Audiard fréquente l''école de la rue du Moulin-Vert puis le Vél'' d''Hiv'' de la rue Nélaton. Pendant l''Occupation, il s''inscrit en école de soudure pour échapper au STO. Mais c''est comme porteur de journaux à bicyclette qu''il entame sa vie professionnelle. La proximité avec les journalistes, qu''il croise dans les cafés des grands boulevards, lui vaut cependant de passer de l''autre côté du miroir, sa faconde naturelle nourrissant de longs articles " de notre envoyé spécial en Indochine " d''autant mieux informés que l''intéressé prend soin de les rédiger sans quitter sa mansarde ! Suivent les critiques de films, qu''Audiard compose sans s''infliger d''assister aux projections... Ces premiers pas le mènent à Cinémonde... Un producteur ne tarde pas à lui demander un premier scénario, Mission à Tanger en 1949... qui sera suivi de nombreux autres. Entre 125, rue Montmartre, Les Barbouzes, Les Tontons flingueurs... comme scénariste et/ou dialoguiste, Audiard truffera ses œuvres de décors familiers et de références au Paris de sa jeunesse. Celui des concierges assises sur le pas de leur porte, des pistards tournant sans relâche au Vél d''Hiv'', des Halles en effervescence... et de la réplique gouailleuse qu un titi ne manquera de faire glisser sur le zinc... " Toute une époque !" disait Blier dans Les Tontons.',
'images/1_livre_mat.jpg', '1', NULL, '10', 'Livre', '3'),
('2', '2_livre_mat', '29.90', 'Tout sur le cinéma : Panorama des chefs-d''oeuvre et des techniques', 'Quel est le premier film parlant ? Comment se caractérise le néo-réalisme italien ? Comment les premiers effets spéciaux furent-ils réalisés ? Quelles oeuvres du XXIe siècle peuvent-elles être déjà considérées comme majeures ? Vingt-cinq historiens du cinéma, critiques, auteurs et enseignants ont participé à l''élaboration de cet ouvrage unique pour nous aider à mieux comprendre l''évolution du cinéma mondial, depuis ses balbutiements jusqu''aux dernières réalisations en 3D. Près de 700 films commentés ; 80 entrées thématiques, représentatives de l''histoire du cinéma, présentées en détail ; 160 chefs-d''oeuvre incontournables décryptés. Tous les outils indispensables (repères chronologiques, biographies de réalisateur et d''acteur, analyses de scènes emblématiques, index).',
'2_livre_mat.jpg', '2', NULL, '20', 'Livre', '3'),
('3', '3_livre_mat', '22.50', 'Cinéma - La grande histoire du 7ème art', 'De l''invention des frères Lumières jusqu''à nos jours, cet ouvrage propose, à travers 135 rétrospectives consacrées aux différentes facettes de l''histoire du cinéma, un panorama complet du 7e art : films, réalisateurs, acteurs, mouvements et écoles, genres, studios et producteurs. L''iconographie d''une richesse (plus de 400 documents d''archives, affiches, portraits ou photos de films), un glossaire technique, les palmarès complets des grands festivals internationaux, les filmographies des grands réalisateurs et des grands acteurs, permettent de construire une véritable mémoire du cinéma du monde entier.',
'images/3_livre_mat.jpg', '3', NULL, '0', 'Livre', '3'),
('4', '4_livre_mat', '25.30', 'Les techniques narratives du cinéma', '"Je m''efforce de toujours chercher d''abord la façon cinématographique de raconter une histoire par la succession des plans et des morceaux de film entre eux. Lorsqu''on écrit un film, il est indispensable [...] chaque fois qu''il est possible, d''accorder la préférence au visuel sur le dialogue (...) En résumé, on peut dire que le rectangle de l''écran doit être chargé d''émotion." En écho à ces propos d''Alfred Hitchcock, ce livre présente 100 exemples des techniques proprement cinématographiques qui construisent l''histoire d''un film. De Metropolis à Kill Bill, des extraits de scénarii célèbres montrent comment créer des caractères, dynamiser une action, donner toute sa force à une intrigue par le travail du cadrage, des mouvements de caméra, de la lumière...',
'images/4_livre_mat.jpg', '4', NULL, '5', 'Livre', '3'),
('5', '5_livre_mat', '11.00', 'Une brève histoire du cinéma: (1895-2015)', 'Cet ouvrage s''adresse au grand public aussi bien qu''aux étudiants et aux cinéphiles. Il explique, illustrations à l''appui, plus de cent vingt ans d’histoire d''une industrie considérée à la fois comme un art et comme un média. Donnant les repères essentiels – des origines du cinéma à nos jours – dans le monde, il aborde les dernières découvertes et les cinématographies méconnues. Il livre aussi des outils d''analyse et de compréhension : à quoi reconnaît-on un film expressionniste ? Comment envisageait-on le montage dans les années 1900 ? Quelle révolution des images animées entraîne vraiment le numérique ? Une brève histoire du cinéma permet de saisir l’évolution des techniques et les enjeux qui régissent le monde du cinéma : une synthèse indispensable pour savoir ce qui se trame derrière le grand écran !',
'images/5_livre_mat.jpg', '5', NULL, '3', 'Livre', '3'),
('6', '6_livre_demat', '7.99', 'Une brève histoire du cinéma: (1895-2015)', 'Cet ouvrage s''adresse au grand public aussi bien qu''aux étudiants et aux cinéphiles. Il explique, illustrations à l''appui, plus de cent vingt ans d’histoire d''une industrie considérée à la fois comme un art et comme un média. Donnant les repères essentiels – des origines du cinéma à nos jours – dans le monde, il aborde les dernières découvertes et les cinématographies méconnues. Il livre aussi des outils d''analyse et de compréhension : à quoi reconnaît-on un film expressionniste ? Comment envisageait-on le montage dans les années 1900 ? Quelle révolution des images animées entraîne vraiment le numérique ? Une brève histoire du cinéma permet de saisir l’évolution des techniques et les enjeux qui régissent le monde du cinéma : une synthèse indispensable pour savoir ce qui se trame derrière le grand écran !',
'images/6_livre_demat.jpg', NULL, '6', '1', 'Livre', '3'),
('7', '7_livre_mat', '22.00', 'Esthétique du montage - 4e éd.', 'Le montage au cinéma ne se résume pas à une opération technique qui consiste à couper et coller des morceaux de pellicule pour en faire un film. C''est avant tout une opération complexe qui exige de la créativité et nécessite une approche esthétique de l''œuvre. Associer des images en un certain ordre, les agencer selon un certain rythme, créer des ruptures ou des continuités, tel est l''art du montage. Ce livre a pour objectif de tracer un panorama des différentes conceptions du montage tout au long de l''histoire du cinéma et de proposer une analyse de cette technique au cœur de nombreux domaines de représentations. L''auteur illustre son exposé par nombre d''exemples de montage de films, notamment à travers ceux d’Orson Welles, d''Alain Resnais ou encore de Maurice Pialat. Enfin, il montre en quoi l''évolution des techniques te des pratiques de montage influe naturellement sur l''esthétique des films. Nouvelle édition actualisée.',
'images/7_livre_mat.jpg', '7', NULL, '10', 'Livre', '3'),
('8', '8_livre_demat', '14.99', 'Esthétique du montage - 4e éd.', 'Le montage au cinéma ne se résume pas à une opération technique qui consiste à couper et coller des morceaux de pellicule pour en faire un film. C''est avant tout une opération complexe qui exige de la créativité et nécessite une approche esthétique de l''œuvre. Associer des images en un certain ordre, les agencer selon un certain rythme, créer des ruptures ou des continuités, tel est l''art du montage. Ce livre a pour objectif de tracer un panorama des différentes conceptions du montage tout au long de l''histoire du cinéma et de proposer une analyse de cette technique au cœur de nombreux domaines de représentations. L''auteur illustre son exposé par nombre d''exemples de montage de films, notamment à travers ceux d’Orson Welles, d''Alain Resnais ou encore de Maurice Pialat. Enfin, il montre en quoi l''évolution des techniques te des pratiques de montage influe naturellement sur l''esthétique des films. Nouvelle édition actualisée.',
'images/8_livre_demat.jpg', NULL, '8', '1', 'Livre', '3'),
('9', '9_articleDivers_mat', '8.69', 'Poster Pulp Fiction', 'Affiche en papier glacé du film Pulp Fiction au format 61cm x 91cm',
'images/9_articleDivers_mat.jpg', '9', NULL, '10', 'ArticleDivers', '3'),
('10', '10_articleDivers_mat', '9.99', 'Poster Retour vers le futur', 'Affiche en papier glacé du film Retour vers le futur au format 61cm x 91cm',
'images/10_articleDivers_mat.jpg', '10', NULL, '10', 'ArticleDivers', '3'),
('11', '11_articleDivers_mat', '5.37', 'Clap cinéma Hollywood', 'Véritable clap de cinéma en bois pour monter vos films comme à Hollywood !',
'images/11_articleDivers_mat.jpg', '11', NULL, '15', 'ArticleDivers', '3');