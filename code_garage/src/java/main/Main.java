package main;

import connexion.Connexion;
import facturation.Client;
import facturation.Facture;
import facturation.FactureService;
import magasin.CategoriePrix;
import magasin.Piece;

import java.util.ArrayList;
import java.util.Date;
import metier.Employee;
import metier.Niveau;
import metier.Service;
import metier.ServicePoste;
import facturation.Client;


public class Main {
    public static void main(String[] args) throws Exception {
        //Facture facture = new Facture();
        //  facture.setIdFacture(1);
        //  facture.getListFactureService(null);

        Client client = new Client().getClientById(null,"1");
         
        //  for (int i = 0; i < facture.getListfactureService().size(); i++) {
        //     System.out.println(facture.getListfactureService().get(i).getNom_service());
        //  }
         //System.out.println(facture.getFactureById(null, "1").getListfactureService().size());

        System.out.println(client.getDate_Naissance());
    
    }
}
