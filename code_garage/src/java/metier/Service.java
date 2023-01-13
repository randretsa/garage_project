package metier;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
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

    // public List<ServicePoste> getDetailService(Connection connection,int idservice)throws Exception {
    //     List<ServicePoste> detailservice = new List<ServicePoste>();

    //     if (connection == null) {
    //         Connexion connexion = new Connexion();
    //         connection = connexion.Connex("postgres");
    //     }

    //     String requete = "select from service_poste join salaire_poste join poste join service where idservice = idservice";
    //     Statement statement = connection.createStatement();
    //     ResultSet resultSet = statement.executeQuery(requete);
    
    //         while (resultSet.next()) {
    //             detailservice.add(new ServicePoste(resultSet.getInt("idposte"), resultSet.getString("nom_poste")));
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
