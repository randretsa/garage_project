package finance;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import connexion.Connexion;

import java.lang.Exception;

public class Depense {
    int iddepense;
    String Libelle;

    public Depense() {

    }

    public Depense(int iddepense,String libelle) {
        this.setIddepense(iddepense);
        this.setLibelle(libelle);
    }

    public ArrayList<Depense> getAllDepense(Connection connection) throws Exception {
        ArrayList<Depense> listDepense = new ArrayList<Depense>();

        if (connection == null) {
            Connexion connexion = new Connexion();
            connection = connexion.Connex("postgres");
        }
        

        String requete= "select * from depense";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(requete);

        while (resultSet.next()) {
            Depense depense = new Depense(resultSet.getInt("iddepense"),resultSet.getString("libelle"));
            listDepense.add(depense);
        }

        return listDepense;
    }

    public int getIddepense() {
        return iddepense;
    }
    public void setIddepense(int iddepense) {
        this.iddepense = iddepense;
    }
    public String getLibelle() {
        return Libelle;
    }
    public void setLibelle(String libelle) {
        Libelle = libelle;
    }
}
