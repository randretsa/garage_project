package metier;

import java.util.Date;

public class Employee {
    int Id;
    String Nom;
    String Prenom;
    Date Date_naissance;
    Poste Poste;
    Niveau niveau;

    public Employee() {
        
    }

    public int getId() {
        return Id;
    }
    public void setId(int id) {
        Id = id;
    }
    public String getNom() {
        return Nom;
    }
    public void setNom(String nom) {
        Nom = nom;
    }
    public String getPrenom() {
        return Prenom;
    }
    public void setPrenom(String prenom) {
        Prenom = prenom;
    }
    public Date getDate_naissance() {
        return Date_naissance;
    }
    public void setDate_naissance(Date date_naissance) {
        Date_naissance = date_naissance;
    }
    public Poste getPoste() {
        return Poste;
    }
    public void setPoste(Poste poste) {
        Poste = poste;
    }
    public Niveau getNiveau() {
        return niveau;
    }
    public void setNiveau(Niveau niveau) {
        this.niveau = niveau;
    }
}
