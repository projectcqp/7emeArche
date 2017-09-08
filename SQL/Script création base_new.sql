-- Création de la base
drop database if exists 7emearche;
create database 7emearche charset=utf8;
use 7emearche;

-- Création des tables
create table tva (
id_tva integer(2) primary key,
libelle_tva varchar(25) not null unique,
taux_tva double  not null default 0
) engine innodb;

--  Crééation de l'arboressence article
create table materialise(
id_materialise integer(5) primary key,
etat_materialise enum('NEUF', 'OCCASION_TRES_BON', 'OCCASION_BON', 'OCCCASION_MOYEN', 'OCCASION_USAGE')
) engine innodb;

create table dematerialise(
id_dematerialise integer(5) primary key,
format_dematerialise varchar(25) not null,
url_download_dematerialise varchar(2655)
) engine innodb;

create table article(
id_article integer(5) primary key,
reference_article varchar(20) not null,
prix_ht_article double not null default 0,
nom_article varchar(100) not null,
description_article varchar(5000) not null,
url_image_article varchar(100) default 'images/no_photo.jpg',

id_materialise_article integer(2),
foreign key (id_materialise_article) references materialise(id_materialise),
 
id_dematerialise_article integer(2),
foreign key (id_dematerialise_article) references dematerialise(id_dematerialise),

stock_article integer(4) default 0 not null,

type_article varchar(75),

id_tva_article integer(2) not null,
foreign key (id_tva_article) references tva(id_tva) 
) engine innodb;

create table livre(
id_article_livre integer(5) primary key,
foreign key (id_article_livre) references article(id_article),

auteur_livre varchar(100) not null,
isbn_livre varchar(14) not null,

editeur_livre varchar(100) not null,
genre_livre varchar(25) not null,
date_livre date not null
) engine innodb;

create table article_divers(
id_article_divers integer(5) primary key,
foreign key (id_article_divers) references article(id_article),

type_article_divers varchar(50) not null
) engine innodb;

-- Les tables 'adresse' et 'compte' ont des références mutuelles
-- il faut créer les clefs étrangères à part
-- ne pas modifier l'ordre
create table adresse(
id_adresse integer(5) primary key,
nom_adresse varchar(10) not null,
voie_adresse varchar(75) not null,
complement_adresse varchar(25),
code_postal_adresse varchar(10) not null, 
ville_adresse varchar(50) not null,
pays_adresse varchar(50) not null default 'France',

id_compte_adresse integer(5) not null
) engine innodb;

create table compte(
id_compte integer(5) primary key,
email_compte varchar(50) not null unique,
password_compte varchar(30) not null,
nom_compte varchar(50) not null,
prenom_compte varchar(50) not null,
telephone_compte varchar(15) not null,
date_naissance_compte date not null,

id_adresse_facturation_compte integer(5) not null,
foreign key (id_adresse_facturation_compte) references adresse(id_adresse)
) engine innodb;

alter table adresse add foreign key (id_compte_adresse) references compte(id_compte);

-- Fin

create table commande(
id_commande integer(5) primary key,
date_commande date not null,

id_compte_commande integer(5) not null, 
foreign key (id_compte_commande ) references compte(id_compte)
) engine innodb;

create table ligne_commande(
id_commande__ligne_commande  integer(5) not null,
 foreign key (id_commande__ligne_commande ) references commande(id_commande),

id_article_ligne_commande integer(5) not null,
foreign key (id_article_ligne_commande) references article(id_article),

primary key(id_commande__ligne_commande,id_article_ligne_commande),

quantite_ligne_commande integer(5) not null
 ) engine innodb;



-- Création des utilisateurs
CREATE USER if not exists '7emeArcheUser'@'localhost' IDENTIFIED  BY 'password';
GRANT select, delete, insert update ON 7emearche.* To '7emeArcheUser'@'localhost';

CREATE USER if not exists '7emeArcheDba'@'localhost' IDENTIFIED  BY 'password';
GRANT all privileges ON 7emearche.* To '7emeArcheUser'@'localhost';

