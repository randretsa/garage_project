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

create table services (
    idservice_garage serial primary key,
    nom_service varchar(50)
);

create table service_poste (
    idservice_poste serial primary key,
    idservice int,
    idposte int,
    duree time,
    foreign key (idposte) references poste(idposte)
);

create table pieces (
    idpiece serial primary key,
    nom_piece varchar(50),
    prix double precision
);

create table service_piece (
    idservice int,
    idpiece int,
    quantite int,
    foreign key (idservice) references services(idservice_garage),
    foreign key (idpiece) references pieces(idpiece)
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

insert into services values (default,'vidange');
insert into services values (default,'lavage');

insert into service_poste values (default,1,3,'02:00:00');
insert into service_poste values (default,1,4,'01:00:00');
insert into service_poste values (default,2,1,'01:00:00');

insert into pieces values (default,'huile',100000);
insert into pieces values (default,'filtre_huile',20000);
insert into pieces values (default,'entonnoir',10000);
insert into pieces values (default,'savon',500);
insert into pieces values (default,'eponge',500);

insert into service_piece values (1,1,1);
insert into service_piece values (1,2,1);
insert into service_piece values (1,3,1);
insert into service_piece values (2,4,2);
insert into service_piece values (2,5,2);