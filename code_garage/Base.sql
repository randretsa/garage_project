create database garage_project;

create table poste (
    idposte serial primary key,
    nom_poste varchar(50)
);

create table Employe (
    idemploye serial primary key,
    nom varchar(100),
    prenom varchar(100),
    date_naissance date,
    idposte int,
    idniveau int,
    foreign key (idposte) references poste(idposte),
    foreign key (idniveau) references niveau_etude(idniveau)
);

create table niveau_etude (
    idniveau serial primary key,
    niveau varchar(100)
);