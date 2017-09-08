drop database if exists 7emearche;
create database 7emearche charset=utf8;
USE 7emearche;

CREATE TABLE `article` (
  `reference_article` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `prix` double NOT NULL,
  `nom` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL,
  `description` varchar(1000) COLLATE utf8mb4_unicode_ci NOT NULL,
  `url_image` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT 'images/no_photo.jpg',
  `type_article` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `stock` int(11) NOT NULL,
  `etat` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `format` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `url_download` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;



INSERT INTO `article` (`reference_article`, `prix`, `nom`, `description`, `url_image`, `type_article`, `stock`, `etat`, `format`, `url_download`) VALUES
('divers_mat_00001', 21.99, 'Mr. Robot - Saison 1', 'Elliot Alderson est un jeune informaticien vivant à New York, qui travaille en tant qu\'ingénieur en sécurité informatique pour Allsafe Security. Celui-ci luttant constamment contre un trouble d\'anxiété sociale et de dépression, son processus de pensée semble fortement influencé par la paranoïa et l\'illusion. Il pirate les comptes des gens, ce qui le conduit souvent à agir comme un cyber-justicier. Elliot rencontre "Mr. Robot", un mystérieux anarchiste qui souhaite le recruter dans son groupe de hackers connu sous le nom de "Fsociety". Leur objectif consiste à rétablir l\'équilibre de la société par la destruction des infrastructures des plus grosses banques et entreprises du monde, notamment le conglomérat E Corp. (surnommé "Evil Corp." par Elliot) qui, par ailleurs, représente 80% du chiffre d\'affaires d\'Allsafe Security...', 'images/img_divers_mat_00001.jpg', 'ARTICLE_DIVERS', 10, 'NEUF', '', ''),
('divers_mat_00002', 13.5, 'Mug Cinéma Culte - Parodie Star Wars - BB, je suis ton père !!', 'Joli mug humoristique sur le thème Star Wars.', 'images/img_divers_mat_00002.jpg', 'ARTICLE_DIVERS', 10, 'NEUF', '', ''),
('livre_demat_00004', 13.99, 'Ecrire un scénario pour le cinéma', 'Un bon scénario, comment ça marche ? Par où commencer lorsqu\'on a une idée d\'histoire ? Comment construire son film pour qu\'il remporte l\'adhésion du spectateur mais aussi du lecteur professionnel auquel il sera soumis ? Puisant abondamment dans le répertoire cinématographique mondial, Franck Haro vous propose un voyage à travers les différents genres du cinéma. Cette odyssée est l\'occasion de décortiquer l\'art de construire une histoire, de créer des personnages intrigants et de structurer un film. L\'écriture scénaristique obéit à des règles strictes qui, si elles doivent être parfaitement connues et maîtrisées, sont faites pour être détournées. Avec pédagogie et humour, l\'auteur met au jour conseils et méthodes pour vous aider dans l\'écriture et vous explique comment donner toutes les chances à votre scénario d\'être un jour porté à l\'écran.', 'images/img_livre_demat_00004.jpg', 'LIVRE', 1, '', 'KINDLE', 'url_download_livre_demat_00004'),
('livre_demat_00005', 1.99, 'Le Petit livre de - 200 répliques cultes du cinéma', 'Si j\'aurai su, j\'aurai pas venu.\r\n(La guerre des boutons, 1962)\r\n\r\nDe la tête au pied, je suis faite pour l\'amour.\r\n(L\'Ange bleu, 1930)\r\n\r\n- Tu comprends, j\'ai besoin de prendre l\'air. Je veux changer d\'atmosphère !\r\n- C\'est la première fois qu\'on me traite d\'atmosphère ! Atmosphère, atmosphère... est-ce que j\'ai une gueule d\'atmosphère ?!!\r\n(Hôtel du Nord, 1938)\r\n\r\nDrôles, sensuelles, ironiques, tendres ou terribles... Les 200 citations et répliques sélectionnées dans cet ouvrage ont fait, font et feront encore longtemps la saveur ou la profondeur des grands films dont elles sont extraites. Préparez-vous à un flot d\'émotions et de souvenirs !', 'images/img_livre_demat_00005.jpg', 'LIVRE', 1, '', 'KINDLE', 'url_download_livre_demat_00005'),
('livre_demat_00006', 20.49, 'Le cinéma par ceux qui le font', 'Qui n\'a jamais rêvé de visiter un plateau de tournage, d\'assister aux répétitions, aux prises de vues, d\'observer comment le réalisateur, le producteur, les techniciens et les acteurs donnent vie à un film, bref d\'entrer dans les coulisses du cinéma ?\r\nCet ouvrage, illustré de plus de 230 photos, accompagne les plus grands professionnels et visite l\'envers du décor. Il permet de redécouvrir les spécificités et les mécanismes de chaque métier du cinéma. Du producteur à l\'exploitant, du réalisateur au projectionniste, 30 professions, connues ou méconnues, sont ainsi mises en lumière, avec entre autres le storyboardeur, le costumier, la scripte, le directeur de casting, le machiniste, etc.\r\nC\'est à travers autant d\'entretiens avec des figures de la profession (Alain Corneau, Sandrine Bonnaire, Christophe Rossignon, Pierre-William Glenn, Francis Lai, etc.) que ce livre vous invite au coeur du cinéma grâce à ceux qui jouent un rôle essentiel dans la construction et la réussite d\'un film.', 'images/img_livre_demat_00006.jpg', 'Livre', 10, '', 'Kindle', 'url_download'),
('livre_mat_00004', 29.9, 'Tout sur le cinéma : Panorama des chefs-d\'oeuvre et des techniques', 'Quel est le premier film parlant ? Comment se caractérise le néo-réalisme italien ? Comment les premiers effets spéciaux furent-ils réalisés ? Quelles oeuvres du XXIe siècle peuvent-elles être déjà considérées comme majeures ? Vingt-cinq historiens du cinéma, critiques, auteurs et enseignants ont participé à l\'élaboration de cet ouvrage unique pour nous aider à mieux comprendre l\'évolution du cinéma mondial, depuis ses balbutiements jusqu\'aux dernières réalisations en 3D. Près de 700 films commentés ; 80 entrées thématiques, représentatives de l\'histoire du cinéma, présentées en détail ; 160 chefs-d\'oeuvre incontournables décryptés. Tous les outils indispensables (repères chronologiques, biographies de réalisateur et d\'acteur, analyses de scènes emblématiques, index).', 'images/img_livre_mat_00004.jpg', 'LIVRE', 10, 'NEUF', '', ''),
('livre_mat_00005', 25.3, 'Les techniques narratives du cinéma : Les 100 plus grands procédés', '" Je m\'efforce de toujours chercher d\'abord la façon cinématographique de raconter une histoire par la succession des plans et des morceaux de film entre eux. Lorsqu\'on écrit un film, il est indispensable [...] chaque fois qu\'il est possible, d\'accorder la préférence au visuel sur le dialogue (...) En résumé, on peut dire que le rectangle de l\'écran doit être chargé d\'émotion. " En écho à ces propos d\'Alfred Hitchcock, ce lire présente 100 exemples des techniques proprement cinématographiques qui construisent l\'histoire d\'un film. De Metropolis à Kill Bill, des extraits de scénarii célèbres montrent comment créer des caractères, dynamiser une action, donner toute sa force à une intrigue par le travail du cadrage, des mouvements de caméra, de la lumière...', 'images/img_livre_mat_00005.jpg', 'LIVRE', 10, 'NEUF', '', ''),
('livre_mat_00007', 20, 'Ecrire un scénario pour le cinéma', 'Un bon scénario, comment ça marche ? Par où commencer lorsqu\'on a une idée d\'histoire ? Comment construire son film pour qu\'il remporte l\'adhésion du spectateur mais aussi du lecteur professionnel auquel il sera soumis ? Puisant abondamment dans le répertoire cinématographique mondial, Franck Haro vous propose un voyage à travers les différents genres du cinéma. Cette odyssée est l\'occasion de décortiquer l\'art de construire une histoire, de créer des personnages intrigants et de structurer un film. L\'écriture scénaristique obéit à des règles strictes qui, si elles doivent être parfaitement connues et maîtrisées, sont faites pour être détournées. Avec pédagogie et humour, l\'auteur met au jour conseils et méthodes pour vous aider dans l\'écriture et vous explique comment donner toutes les chances à votre scénario d\'être un jour porté à l\'écran.', 'images/img_livre_mat_00007.jpg', 'LIVRE', 10, 'NEUF', '', ''),
('livre_mat_00008', 2.99, 'Le Petit livre de - 200 répliques cultes du cinéma', 'Si j\'aurai su, j\'aurai pas venu.\r\n(La guerre des boutons, 1962)\r\n\r\nDe la tête au pied, je suis faite pour l\'amour.\r\n(L\'Ange bleu, 1930)\r\n\r\n- Tu comprends, j\'ai besoin de prendre l\'air. Je veux changer d\'atmosphère !\r\n- C\'est la première fois qu\'on me traite d\'atmosphère ! Atmosphère, atmosphère... est-ce que j\'ai une gueule d\'atmosphère ?!!\r\n(Hôtel du Nord, 1938)\r\n\r\nDrôles, sensuelles, ironiques, tendres ou terribles... Les 200 citations et répliques sélectionnées dans cet ouvrage ont fait, font et feront encore longtemps la saveur ou la profondeur des grands films dont elles sont extraites. Préparez-vous à un flot d\'émotions et de souvenirs !', 'images/img_livre_mat_00008.jpg', 'LIVRE', 1, 'OCCASION_MOYEN', '', ''),
('livre_mat_00009', 25.4, 'Anatomie du scénario : Cinéma, littérature, séries télé', 'Parmi les nombreux essais et manuels d\'écriture, L\'Anatomie du scénario est une référence incontournable pour les scénaristes débutants et confirmés. John Truby entend mettre fin au dogme de la structure en trois actes qu\'il juge artificielle. Il préconise les intrigues à multiples facettes, les réseaux de personnages et le mélange des genres. Il invite à tordre les règles qui régissent l\'écriture de scénarios afin d\'écrire des histoires originales qui doivent être abordées comme des organismes vivants, aussi changeants et complexes que ceux qui les imaginent. Les préceptes développés dans ce livre complètent plus qu\'ils ne concurrencent les ouvrages d\'autres théoriciens de la dramaturgie. Ils exposent les bases d\'une formation continue aussi populaire en France qu\'aux Etats-Unis où elle a été mise en place il y a trente ans.', 'images/img_livre_mat_00009.jpg', 'LIVRE', 10, 'OCCASION_BON', '', ''),
('livre_mat_00010', 16, 'Le Cinéma de ma jeunesse', 'Le cinéma exerce depuis sa création une fascination sur les publics de tous âges et remplit les salles. Illustré de plus de 300 photos rares, ce livre raconte 40 ans de cinéma d\'émotion, 40 ans d\'histoire populaire, décennie par décennie.Chaque film emblématique d\'une génération est remis dans son contexte à la lumière d\'un texte vivant et nostalgique et de photos d\'époque.A la fin des années 40, la télévision n\'a pas encore envahi les foyers français, le cinéma de quartier ne désemplit pas. Ce ne sont pas seulement des films que l\'on va voir mais les actualités, quelques dessins animés et les publicités de Jean Mineur et son fameux "Balzac 001".', 'images/img_livre_mat_00010.jpg', 'LIVRE', 10, 'NEUF', '', ''),
('livre_mat_00011', 29.5, 'Le cinéma par ceux qui le font', 'Qui n\'a jamais rêvé de visiter un plateau de tournage, d\'assister aux répétitions, aux prises de vues, d\'observer comment le réalisateur, le producteur, les techniciens et les acteurs donnent vie à un film, bref d\'entrer dans les coulisses du cinéma ?\r\nCet ouvrage, illustré de plus de 230 photos, accompagne les plus grands professionnels et visite l\'envers du décor. Il permet de redécouvrir les spécificités et les mécanismes de chaque métier du cinéma. Du producteur à l\'exploitant, du réalisateur au projectionniste, 30 professions, connues ou méconnues, sont ainsi mises en lumière, avec entre autres le storyboardeur, le costumier, la scripte, le directeur de casting, le machiniste, etc.\r\nC\'est à travers autant d\'entretiens avec des figures de la profession (Alain Corneau, Sandrine Bonnaire, Christophe Rossignon, Pierre-William Glenn, Francis Lai, etc.) que ce livre vous invite au coeur du cinéma grâce à ceux qui jouent un rôle essentiel dans la construction et la réussite d\'un film.', 'images/img_livre_mat_00010.jpg', 'Livre', 10, 'OCCASION_TRES_BON', '', '');



CREATE TABLE `article_divers` (
  `reference_article_divers` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `type_article_divers` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `caracteristiques` varchar(1000) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;



INSERT INTO `article_divers` (`reference_article_divers`, `type_article_divers`, `caracteristiques`) VALUES
('divers_mat_00001', 'DVD', 'Rami Malek (Acteur), Christian Slater Acteur)\r\nNombre de disques : 3\r\nStudio : Universal Pictures France\r\nDate de sortie du DVD : 18 octobre 2016\r\nDurée : 450 minutes\r\nASIN: B01HZ558A4'),
('divers_mat_00002', 'MUG', 'Intérieur et anse de couleur noire\r\nPasse au micro-ondes\r\nPasse au lave-vaisselle\r\nContenance 375 ml\r\nBoîte protectrice individuel antichoc en carton pour une livraison en toute sécurité');



CREATE TABLE `compte` (
  `nom` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `prenom` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `adresse_compte` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL,
  `adresse_livraison` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL,
  `email` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `telephone` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;



INSERT INTO `compte` (`nom`, `prenom`, `adresse_compte`, `adresse_livraison`, `email`, `telephone`, `password`) VALUES
('BIGOT', 'Alexandre', '51 avenue Gabriel Péri\r\n94100 SAINT MAUR DES FOSSES', '51 avenue Gabriel Péri\r\n94100 SAINT MAUR DES FOSSES', 'alex_bigot@hotmail.com', '0685901508', 'password');




CREATE TABLE `livre` (
  `reference_livre` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `auteur` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `isbn` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `editeur` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `genre` varchar(150) COLLATE utf8mb4_unicode_ci NOT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;



INSERT INTO `livre` (`reference_livre`, `auteur`, `isbn`, `editeur`, `genre`, `date`) VALUES
('livre_demat_00004', 'Franck HARO', 'B01IE0XOKA', 'EYROLLES', 'Cinéma Scénario', '2016-07-13'),
('livre_demat_00005', 'Vincent MIRABEL', 'B00ARHBD0M', 'FIRST', 'Art Cinéma', '2012-12-20'),
('livre_demat_00006', 'Gérard CAMY', 'B005Q6Y9DM', 'NOUVEAU MONDE', 'Beaux livres', '2010-12-16'),
('livre_mat_00004', 'Philip KEMP', '978-208126616', 'FLAMMARION', 'Arts et Spectacles', '2011-11-01'),
('livre_mat_00005', 'Jennifer VAN SIJLL', '978-2212117615', 'EYROLLES', 'Cinéma Essais', '2006-02-16'),
('livre_mat_00007', 'Franck HARO', '978-2212565706', 'EYROLLES', 'Cinéma Scenario', '2016-08-07'),
('livre_mat_00008', 'Vincent MIRABEL', '978-2754011990', 'FIRST', 'Art Cinéma', '2009-04-09'),
('livre_mat_00009', 'John TRUBY', '978-2847364903', 'NOUVEAU MONDE', 'Beaux livres', '2010-01-01'),
('livre_mat_00010', 'Laurent CHOLLET', '978-2258089891', 'HORS COLLECTION', 'Beaux livres', '2012-10-31'),
('livre_mat_00011', 'Gérard CAMY', '978-2847364187', 'NOUVEAU MONDE', 'Beaux livres', '2010-10-28');


ALTER TABLE `article`
  ADD PRIMARY KEY (`reference_article`);


ALTER TABLE `article_divers`
  ADD PRIMARY KEY (`reference_article_divers`);


ALTER TABLE `compte`
  ADD PRIMARY KEY (`email`);


ALTER TABLE `livre`
  ADD PRIMARY KEY (`reference_livre`);


ALTER TABLE `article_divers`
  ADD CONSTRAINT `fk_articleDivers_article` FOREIGN KEY (`reference_article_divers`) REFERENCES `article` (`reference_article`);

ALTER TABLE `livre`
  ADD CONSTRAINT `fk_livre_article` FOREIGN KEY (`reference_livre`) REFERENCES `article` (`reference_article`);

CREATE USER '7emeArcheUser'@'%'IDENTIFIED BY 'password';
GRANT select, delete, insert, update ON 7emearche.* To '7emeArcheUser'@'%';

CREATE USER '7emeArcheDba'@'%'IDENTIFIED BY 'password';
GRANT all priviliges update ON 7emearche.* To '7emeArcheUser'@'%';

CREATE USER 'mouhamed'@'%'IDENTIFIED BY 'password';
GRANT all priviliges ON 7emearche.* To 'mouhamed'@'%';

CREATE USER 'alexandre'@'%'IDENTIFIED BY 'password';
GRANT all priviliges ON 7emearche.* To 'alexandre'@'%';

CREATE USER 'fabrice'@'%'IDENTIFIED BY 'password';
GRANT all priviliges ON 7emearche.* To 'fabrice'@'%';
