package metier;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.lang.Exception;

import connexion.Connexion;

public class Service {
    int Idservice;
    String Nom_service;
    ServicePoste listposte;

    public Service() {

    }

    public Service(int idservice,String nom_service,ServicePoste listPoste) {
        this.setIdservice(idservice);
        this.setNom_service(nom_service);
        this.setListposte(listPoste);
    }

    
    // public double getMontantService(){
    //     return somme (montant*dure);
    // }

    // public ArrayList<ServicePoste> getDetailService(Connection connection)throws Exception {
    //     ArrayList<ServicePoste> detailservice = new ArrayList<ServicePoste>();

    //     if (connection == null) {
    //         Connexion connexion = new Connexion();
    //         connection = connexion.Connex("postgres");
    //     }

    //     String requete = "select idservice,nom_service,poste.idposte,nom_poste,salaire, extract(hour from duree) duree from service_poste join salaire_poste on salaire_poste.idposte = service_poste.idposte join poste on salaire_poste.idposte = poste.idposte join services on services.idservice_garage = service_poste.idservice;";
    //     Statement statement = connection.createStatement();
    //     ResultSet resultSet = statement.executeQuery(requete);
    
    //         while (resultSet.next()) {
    //             detailservice.add(new ServicePoste(resultSet.getInt("idservice"), resultSet.getString("nom_service"),new ServicePoste(new SalairePoste(resultSet.getDouble("salaire"), resultSet.getDouble("duree"))));
    //         }

    // }

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
    public ServicePoste getListposte() {
        return listposte;
    }
    public void setListposte(ServicePoste listposte) {
        this.listposte = listposte;
    }


}
