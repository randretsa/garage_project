package metier;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
<<<<<<< Updated upstream
=======
import java.lang.Exception;

>>>>>>> Stashed changes

import connexion.Connexion;

public class Poste {
    int Id;
    String Nom_poste;

    public Poste() {
        
    }

    public Poste(int id,String nom_poste) {
        this.setId(id);
        this.setNom_poste(nom_poste);
    }

    public ArrayList<Poste> liste_poste(Connection connection)throws Exception {
        ArrayList<Poste> list_poste = new ArrayList<Poste>();

        if (connection == null) {
            Connexion connexion = new Connexion();
            connection = connexion.Connex("postgres");
        }

        String requete = "select * from Poste";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(requete);
    
            while (resultSet.next()) {
                list_poste.add(new Poste(resultSet.getInt("idposte"), resultSet.getString("nom_poste")));
            }


        return list_poste;
    }

    public int getId() {
        return Id;
    }
    public void setId(int id) {
        Id = id;
    }
    public String getNom_poste() {
        return Nom_poste;
    }
    public void setNom_poste(String nom_poste) {
        Nom_poste = nom_poste;
    }

}
