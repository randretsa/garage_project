package main;

import connexion.Connexion;
import java.util.ArrayList;
import java.util.Date;
import metier.Employee;
import metier.Niveau;

public class Main {
    public static void main(String[] args) throws Exception {
         Connexion connexion = new Connexion();
        // System.out.println(connexion);
        Niveau poste = new Niveau();
        ArrayList<Niveau> list= poste.liste_niveau(null);
        for (int index = 0; index < list.size(); index++) {
            System.out.println(list.get(index).getNiveau());
        }
        
        
        
        Employee emp = new Employee();
            emp.saveEmploye(connexion.Connex("postgres"), "njaka", "andria", new Date(), 1, 1);
    
    }
}
