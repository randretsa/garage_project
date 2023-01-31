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

alter table services add column marge_beneficiaire double precision;  

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

create table Categorie_prix (
    idCategorie_prix serial,
    minimum double precision,
    maximum double precision,
    pourcentage double precision
);

create table client (
    idclient serial primary key,
    nom varchar(50),
    mot_de_passe varchar(50)
);

create table facture (
    idfacture serial primary key,
    idclient int,
    ref varchar(50),
    Date_facture date,
    foreign key (idclient) references client(idclient)
);

create table factureService (
    idfacture int,
    idservice int,
    quantite int,
    montant double precision,
    foreign key (idfacture) references facture(idfacture),
    foreign key (idservice) references services(idservice_garage)
);

create table facturePiece (
    idfacture int,
    idpiece int,
    quantite int,
    montant double precision,
    foreign key (idfacture) references facture(idfacture),
    foreign key (idpiece) references pieces(idpiece)
);

create table payementFacture (
    idfacture int,
    montant double precision,
    foreign key (idfacture) references facture(idfacture)
);


insert into client values (default,'mahefa','mah123');
insert into client values (default,'nomena','nomena123');

insert into facture values (default,1,'ref40','2023-01-31');
insert into facture values (default,1,'ref50','2023-01-31');

insert into factureService values (1,1,2,3000);
insert into factureService values (1,2,3,5000);

insert into payementFacture values (1,10000);

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

insert into Categorie_prix values (default,0,5000,10);
insert into Categorie_prix values (default,5000,20000,25);
insert into Categorie_prix values (default,20000,30000,30);
insert into Categorie_prix values (default,100000,150000,10);


-------------------------------------------------------------
update services set marge_beneficiaire=10 where idservice_garage=1;
update services set marge_beneficiaire=15 where idservice_garage=2;

