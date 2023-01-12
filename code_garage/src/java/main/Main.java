package main;

import java.util.ArrayList;

import connexion.Connexion;
import metier.Poste;

public class Main {
    public static void main(String[] args) throws Exception {
        // Connexion connexion = new Connexion();
        // System.out.println(connexion);
        Poste poste = new Poste();
        ArrayList<Poste> list= poste.liste_poste(null);
        for (int index = 0; index < list.size(); index++) {
            System.out.println(list.get(index).getNom_poste());
        }
    }
}
