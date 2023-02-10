package finance;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.lang.Exception;

import connexion.Connexion;

public class Repport {
    int idrepport;
    double montant;
    Date Date_repport;

    public Repport() {

    }

    public Repport(int idrepport,double montant,Date dateRepport) {
        this.setIdrepport(idrepport);
        this.setMontant(montant);
        this.setDate_repport(dateRepport);
    }


    public void saveRepport(Connection connection,String montant,String date)throws Exception {  
        if (connection == null) {
            Connexion connexion = new Connexion();
            connection = connexion.Connex("postgres");
        }

        String requete= "insert into repport values (default,"+montant+",'"+date+"')";
        Statement statement = connection.createStatement();
        statement.execute(requete);

        connection.close();
    }
    

    public Repport getRepport(Connection connection)throws Exception {
        Repport repport = new Repport();

        if (connection == null) {
            Connexion connexion = new Connexion();
            connection = connexion.Connex("postgres");
        }

        String requete= "select * from repport order by date_repport desc limit 1";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(requete);

        while (resultSet.next()) {
            repport.setIdrepport(resultSet.getInt("idrepport"));
            repport.setMontant(resultSet.getDouble("montant"));
            repport.setDate_repport(resultSet.getDate("date_repport"));
        }

        return repport;
    }

    public int getIdrepport() {
        return idrepport;
    }
    public void setIdrepport(int idrepport) {
        this.idrepport = idrepport;
    }
    public double getMontant() {
        return montant;
    }
    public void setMontant(double montant) {
        this.montant = montant;
    }
    public Date getDate_repport() {
        return Date_repport;
    }
    public void setDate_repport(Date date_repport) {
        Date_repport = date_repport;
    }
}
