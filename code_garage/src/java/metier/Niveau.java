package metier;

import connexion.Connexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Niveau {
    int Id;
    String Niveau;

        public ArrayList<Niveau> liste_niveau(Connection connection)throws Exception {
        ArrayList<Niveau> list_niveau = new ArrayList<Niveau>();

        if (connection == null) {
            Connexion connexion = new Connexion();
            connection = connexion.Connex("postgres");
        }

        String requete = " select*from niveau_etude";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(requete);
    
            while (resultSet.next()) {
                list_niveau.add(new Niveau(resultSet.getInt("idniveau"), resultSet.getString("niveau")));
            }


        return list_niveau;
    }
    public Niveau() {
        
    }

    public Niveau(int Id, String Niveau) {
        this.Id = Id;
        this.Niveau = Niveau;
    }
    
    

    public int getId() {
        return Id;
    }
    public void setId(int id) {
        Id = id;
    }
    public String getNiveau() {
        return Niveau;
    }
    public void setNiveau(String niveau) {
        Niveau = niveau;
    }


}
