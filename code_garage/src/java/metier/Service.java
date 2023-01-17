package metier;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.lang.Exception;

import connexion.Connexion;
import magasin.Piece;

public class Service {
    int Idservice;
    String Nom_service;
    ArrayList<ServicePoste> listposte;
    ArrayList<Piece> listPieces;

    public Service() {

    }

    public Service(int idservice,String nom_service) {
        this.setIdservice(idservice);
        this.setNom_service(nom_service);
    }

    
    public double getMontantService(){
        double somme = 0;
        for (int i = 0; i < listposte.size(); i++) {
            somme = somme + listposte.get(i).getDure() * listposte.get(i).getPoste().getMontant();
        }
        return somme;
    }

    public double getRevenuMateriel(){
        double somme = 0;
        for (int i = 0; i < listPieces.size(); i++) {
            somme = somme + listPieces.get(i).getPrixUnitaire() * listPieces.get(i).getQuantite();
        }
        return somme;
    }

    public void getDetailService(Connection connection)throws Exception {
        ArrayList<ServicePoste> detailservice = new ArrayList<ServicePoste>();

        if (connection == null) {
            Connexion connexion = new Connexion();
            connection = connexion.Connex("postgres");
        }

        String requete = "select idservice,nom_service,poste.idposte,nom_poste,salaire, extract(hour from duree) duree from service_poste join salaire_poste on salaire_poste.idposte = service_poste.idposte join poste on salaire_poste.idposte = poste.idposte join services on services.idservice_garage = service_poste.idservice where idservice="+this.getIdservice()+";";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(requete);
    
            while (resultSet.next()) {
                SalairePoste salairePoste = new SalairePoste(resultSet.getInt("idposte"), resultSet.getString("nom_poste"), resultSet.getDouble("salaire"));
                ServicePoste servicePoste = new ServicePoste(salairePoste, resultSet.getDouble("duree"));
                detailservice.add(servicePoste);
            }
            this.listposte = detailservice;

    }


    public ArrayList<Service> getService(Connection connection)throws Exception {
        ArrayList<Service> list_service = new ArrayList<Service>();

        if (connection == null) {
            Connexion connexion = new Connexion();
            connection = connexion.Connex("postgres");
        }

        String requete= "select * from services";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(requete);

        while (resultSet.next()) {
            Service service = new Service(resultSet.getInt("idservice_garage"),resultSet.getString("nom_service"));
            service.getDetailService(connection);
            service.getPiecesService(connection);
            list_service.add(service);
        }

        return list_service;
    }

    public void getPiecesService(Connection connection) throws Exception {
        ArrayList<Piece> detailPieceservice = new ArrayList<Piece>();

        if (connection == null) {
            Connexion connexion = new Connexion();
            connection = connexion.Connex("postgres");
        }

        //String requete = "select idservice,nom_service,poste.idposte,nom_poste,salaire, extract(hour from duree) duree from service_poste join salaire_poste on salaire_poste.idposte = service_poste.idposte join poste on salaire_poste.idposte = poste.idposte join services on services.idservice_garage = service_poste.idservice where idservice="+this.getIdservice()+";";
        String requete = "select pieces.idpiece,nom_piece,quantite,prix from service_piece join pieces on pieces.idpiece=service_piece.idpiece where idservice="+this.getIdservice()+"";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(requete);
    
            while (resultSet.next()) {
                //SalairePoste salairePoste = new SalairePoste(resultSet.getInt("idposte"), resultSet.getString("nom_poste"), resultSet.getDouble("salaire"));
                //ServicePoste servicePoste = new ServicePoste(salairePoste, resultSet.getDouble("duree"));
                //Piece piece = new Piece(resultSet.getInt("idpiece"),resultSet.getString("nom_piece"),resultSet.getInt("quantite"),resultSet.getDouble("prix"));
                Piece piece = new Piece();
                piece.setId(resultSet.getInt("idpiece"));
                piece.setNomPiece(resultSet.getString("nom_piece"));
                piece.setQuantite(resultSet.getInt("quantite"));
                piece.setPrixUnitaire(resultSet.getDouble("prix"));
                detailPieceservice.add(piece);
            }
            this.listPieces = detailPieceservice;
    }


    public double getMargeBeneficiaire() {
        double calcul =  (getMontantService() + getRevenuMateriel()) * 20/100;
        return calcul;
    }

    public double getValeurService() {
        double calcul = getMontantService() + getRevenuMateriel() + getMargeBeneficiaire();
        return calcul;
    }
    

    public int getIdservice() {
        return Idservice;
    }
    public void setIdservice(int idservice) {
        Idservice = idservice;
    }
    public String getNom_service() {
        return Nom_service;
    }
    public void setNom_service(String nom_service) {
        Nom_service = nom_service;
    }
    public ArrayList<ServicePoste> getListposte() {
        return listposte;
    }
    public void setListposte(ArrayList<ServicePoste> listposte) {
        this.listposte = listposte;
    }
    public ArrayList<Piece> getListPieces() {
        return listPieces;
    }

    public void setListPieces(ArrayList<Piece> listPieces) {
        this.listPieces = listPieces;
    }


}
