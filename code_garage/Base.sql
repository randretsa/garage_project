create database garage_project;

create table poste (
    idposte serial primary key,
    nom_poste varchar(50)
);

create table niveau_etude (
    idniveau serial primary key,
    niveau varchar(100)
);

create table salaire_poste(
    idsalaire_poste serial primary key,
    idposte int,
    salaire double precision,
    foreign key (idposte) references poste(idposte) 
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



insert into poste values (default,'Controleur de Vehicule');
insert into poste values (default,'Peintre en carrosserie'); 
insert into poste values (default,'Reparateur en carosserie'); 
insert into poste values (default,'Mecanicien Dieseliste');

insert into niveau_etude values (default,'CAP');
insert into niveau_etude values (default,'BACC+2');
insert into niveau_etude values (default,'Ingeniurie');
insert into niveau_etude values (default,'BACC+5');

insert into salaire_poste values (default,1,40000);
insert into salaire_poste values (default,2,20000);
insert into salaire_poste values (default,3,30000);
insert into salaire_poste values (default,4,25000);

