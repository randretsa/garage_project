package metier;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.lang.Exception;
import java.sql.SQLException;


public class Employee {
    int Id;
    String Nom;
    String Prenom;
    Date Date_naissance;
    Poste Poste;
    Niveau niveau;

    public Employee() {
        
    }

    public Employee(int id,String nom,String prenom,Date date_naissance,Poste poste,Niveau niveau) {
        this.setId(id);
        this.setNom(nom);
        this.setPrenom(prenom);
        this.setDate_naissance(date_naissance);
        this.setPoste(poste);
        this.setNiveau(niveau);
    }


    public void saveEmploye(Connection connection, String nom,String prenom,Date date_naissance,int poste,int niveau)throws SQLException,Exception {
        String insert = "INSERT INTO Employe VALUES (default,"+nom+","+prenom+","+date_naissance+","+poste+","+niveau+")";
        Statement statement = connection.createStatement();
        int insertion = statement.executeUpdate(insert);
        
        connection.close();
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
