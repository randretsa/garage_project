package main;

import connexion.Connexion;
import magasin.CategoriePrix;
import magasin.Piece;

import java.util.ArrayList;
import java.util.Date;
import metier.Employee;
import metier.Niveau;
import metier.Service;
import metier.ServicePoste;


public class Main {
    public static void main(String[] args) throws Exception {
         Connexion connexion = new Connexion();
        // System.out.println(connexion);
        Niveau poste = new Niveau();
        Service service = new Service();
        Piece piece = new Piece();
        CategoriePrix categoriePrix = new CategoriePrix();


        service.setIdservice(1);


        ArrayList<Niveau> list= poste.liste_niveau(null);
        ArrayList<Service> list_service = service.getService(null);
        ArrayList<CategoriePrix> list_CategoriePrixs = categoriePrix.getCategoriePrix(null);

        service.getDetailService(null);
        service.getPiecesService(null);
        for (int index = 0; index < list_CategoriePrixs.size(); index++) {
            //System.out.println(list.get(index).getNiveau()); 
            //System.out.println(service.getListposte().get(index).getDure());
            //System.out.println(service.getListPieces().get(index).getPrixUnitaire());
            System.out.println(list_CategoriePrixs.get(index).toString());
            


            //System.out.println(list_service.get(index).getNom_service() + " " + list_service.get(index).getMontantService());
        }
        //System.out.println(service.getMontantService());
        //System.out.println(service.getValeurService());
        //System.out.println(service.getService_By_Id(null, "1").getNom_service());
        
        // Employee emp = new Employee();
        // emp.saveEmploye(connexion.Connex("postgres"), "njaka", "andria", new Date(), 1, 1);
    
    }
}
