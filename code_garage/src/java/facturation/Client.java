package facturation;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;

import connexion.Connexion;

public class Client {
    int idClient;
    String Nom;
    String Mot_de_passe;
    Date Date_Naissance;

    public Client() {

    }

    public Client(int idclient,String nom, String motdepasse,Date dateNaissance) {
        this.setIdClient(idclient);
        this.setNom(nom);
        this.setMot_de_passe(motdepasse);
        this.setDate_Naissance(dateNaissance);
    }


    public List<Client> getAllClient(Connection connection) throws Exception {
        List<Client> Listclient = new ArrayList<Client>();

        if (connection == null) {
            Connexion connexion = new Connexion();
            connection = connexion.Connex("postgres");
        }

        String requete= "select * from client";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(requete);

        while (resultSet.next()) {
            Client client = new Client();
            client.setIdClient(resultSet.getInt("idclient"));
            client.setNom(resultSet.getString("nom"));
            client.setMot_de_passe(resultSet.getString("mot_de_passe"));
            client.setDate_Naissance(resultSet.getDate("date_naissance"));
            Listclient.add(client);
        }

        return Listclient;
    }


    public Client getClientById(Connection connection,String idclient)throws Exception {
        Client client = new Client();

        if (connection == null) {
            Connexion connexion = new Connexion();
            connection = connexion.Connex("postgres");
        }

        String requete= "select * from client where idclient="+idclient+"";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(requete);

        while (resultSet.next()) {
            client.setIdClient(resultSet.getInt("idclient"));
            client.setNom(resultSet.getString("nom"));
            client.setMot_de_passe(resultSet.getString("mot_de_passe"));
            client.setDate_Naissance(resultSet.getDate("date_naissance"));
        }

        return client;

    }

    public int getIdClient() {
        return idClient;
    }
    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }
    public String getNom() {
        return Nom;
    }
    public void setNom(String nom) {
        Nom = nom;
    }
    public String getMot_de_passe() {
        return Mot_de_passe;
    }
    public void setMot_de_passe(String mot_de_passe) {
        Mot_de_passe = mot_de_passe;
    }
    public Date getDate_Naissance() {
        return Date_Naissance;
    }
    public void setDate_Naissance(Date date_Naissance) {
        Date_Naissance = date_Naissance;
    }


}