package finance;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import connexion.Connexion;

import java.lang.Exception;

public class DetailDepense {
    int iddepense;
    double montant;
    Date Date_Depense;

    public DetailDepense() {

    }

    public DetailDepense(int iddepense,double montant,Date date) {
        this.setIddepense(iddepense);
        this.setMontant(montant);
        this.setDate_Depense(date);
    }

    public ArrayList<DetailDepense> getAllDetailDepense(Connection connection) throws Exception {
        ArrayList<DetailDepense> listDetailDepenses = new ArrayList<DetailDepense>();

        if (connection == null) {
            Connexion connexion = new Connexion();
            connection = connexion.Connex("postgres");
        }
        

        String requete= "select * from detaildepense";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(requete);

        while (resultSet.next()) {
            DetailDepense detailDepense = new DetailDepense(resultSet.getInt("iddepense"),resultSet.getDouble("montant"),resultSet.getDate("date_depense"));
            listDetailDepenses.add(detailDepense);
        }

        return listDetailDepenses;
    }

    public void save(Connection connection,String iddepense,String montant,String date)throws Exception {
        EtatFinance etatFinance = new EtatFinance();
        etatFinance.Recette();

        if (Double.parseDouble(montant) > etatFinance.getRecette() ) {
            throw new Exception("Solde Insuffisant!!");
        } else if (Double.parseDouble(montant) < 0) {
            throw new Exception("Montant Invalide!!");
        }
        
        if (connection == null) {
            Connexion connexion = new Connexion();
            connection = connexion.Connex("postgres");
        }

        String requete= "insert into detaildepense values ("+iddepense+","+montant+",'"+date+"')";
        Statement statement = connection.createStatement();
        statement.execute(requete);

        connection.close();
    }

    public int getIddepense() {
        return iddepense;
    }
    public void setIddepense(int iddepense) {
        this.iddepense = iddepense;
    }
    public double getMontant() {
        return montant;
    }
    public void setMontant(double montant) {
        this.montant = montant;
    }
    public Date getDate_Depense() {
        return Date_Depense;
    }
    public void setDate_Depense(Date date_Depense) {
        Date_Depense = date_Depense;
    }


}
