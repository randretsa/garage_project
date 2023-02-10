package facturation;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;

import connexion.Connexion;

import java.lang.Exception;

public class Facture {
    int idFacture;
    int idClient;
    String ref;
    Date dateFacture;

    double montantpaye;
    List<FactureService> listfactureService;

    

    public Facture () {

    }

    public Facture(int idfacture,int idClient,String ref,Date datefacture) {
        this.setIdFacture(idfacture);
        this.setIdClient(idClient);
        this.setRef(ref);
        this.setDateFacture(datefacture);
    }


    public void saveFacture(Connection connection,String idclient,String reference,String date)throws Exception {
        if (connection == null) {
            Connexion connexion = new Connexion();
            connection = connexion.Connex("postgres");
        }

            String requete= "insert into facture values (default,"+idclient+",'"+reference+"','"+date+"')";
            Statement statement = connection.createStatement();
            statement.execute(requete);

        connection.close();
    }

    public boolean checkRemiseAnniversaire(Connection connection) throws Exception {
        Client client = new Client().getClientById(connection, String.valueOf(idClient));

        if ((client.getDate_Naissance().getMonth() == (this.getDateFacture().getMonth())) && (client.getDate_Naissance().getDate() == (this.getDateFacture().getDate()))) {
            return true;
        }

        return false;
    }


    public void payer(Connection connection,double montant) throws Exception{
        if (connection == null) {
            Connexion connexion = new Connexion();
            connection = connexion.Connex("postgres");
        }

        if (montant < 0 || montant > getRestePayer()) {
            throw new Exception("montant invalide!!");
        } else {
            String requete= "insert into payementfacture values ("+this.getIdFacture()+","+montant+")";
            Statement statement = connection.createStatement();
            statement.execute(requete);
        }

        

        connection.close();
    }


    public List<Facture> getAllFacture(Connection connection) throws Exception{
        List<Facture> listFacture = new ArrayList<Facture>();

        if (connection == null) {
            Connexion connexion = new Connexion();
            connection = connexion.Connex("postgres");
        }

        String requete= "select * from facture";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(requete);

        while (resultSet.next()) {
            Facture facture = new Facture();
            facture.setIdFacture(resultSet.getInt("idfacture"));
            facture.setIdClient(resultSet.getInt("idclient"));
            facture.setRef(resultSet.getString("ref"));
            facture.setDateFacture(resultSet.getDate("date_facture"));

            facture.getListFactureService(connection);
            facture.getMontantPayer(connection);
            listFacture.add(facture);
        }

        return listFacture;
    }


    public Facture getFactureById(Connection connection,String id) throws Exception{
        Facture facture = new Facture();

        if (connection == null) {
            Connexion connexion = new Connexion();
            connection = connexion.Connex("postgres");
        }

        String requete= "select * from facture where idfacture="+this.getIdFacture()+"";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(requete);

        while (resultSet.next()) {
            facture.setIdFacture(resultSet.getInt("idfacture"));
            facture.setIdClient(resultSet.getInt("idclient"));
            facture.setRef(resultSet.getString("ref"));
            facture.setDateFacture(resultSet.getDate("date_facture"));

            facture.getListFactureService(connection);
            facture.getMontantPayer(connection);
        }

        return facture;
    }


    public double getRestePayer() {
        double reste = 0;
        reste = this.getMontantTotal() - this.getMontantpaye();
        return reste;
    }


    public void getMontantPayer(Connection connection) throws Exception {
        if (connection == null) {
            Connexion connexion = new Connexion();
            connection = connexion.Connex("postgres");
        }

        String requete= "select sum(montant) as montant,idfacture from payementfacture where idfacture="+this.getIdFacture()+" group by idfacture";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(requete);

        while (resultSet.next()) {
            this.setMontantpaye(resultSet.getDouble("montant"));
        }
    }


    public double getMontantTotal() {
        double montantTotal=0;
            try {
                for (int i = 0; i < listfactureService.size(); i++) {
                    montantTotal = montantTotal + listfactureService.get(i).getMontantLine();
                }
                if (this.checkRemiseAnniversaire(null)) {
                    System.out.println(this.checkRemiseAnniversaire(null));
                    montantTotal = montantTotal - (montantTotal * 50)/100;
                }
            } catch (Exception e) {
                // TODO: handle exception
            }

        return montantTotal;
    }


    public void getListFactureService(Connection connection) throws Exception {
        List<FactureService> list = new ArrayList<FactureService>();
        if (connection == null) {
            Connexion connexion = new Connexion();
            connection = connexion.Connex("postgres");
        }

        String requete= "select factureservice.idfacture,factureservice.idservice,quantite,montant,services.nom_service,services.marge_beneficiaire,remise from factureservice join facture on facture.idfacture=factureservice.idfacture join services on services.idservice_garage=factureservice.idservice where factureservice.idfacture="+this.getIdFacture()+"";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(requete);

        while (resultSet.next()) {
            FactureService factureservice = new FactureService(resultSet.getInt("idfacture"),resultSet.getInt("quantite"),resultSet.getDouble("montant"),resultSet.getDouble("remise"));
            factureservice.setIdservice(resultSet.getInt("idservice"));
            factureservice.setNom_service(resultSet.getString("nom_service"));
            factureservice.setMarge_Beneficiaire(resultSet.getDouble("marge_beneficiaire"));
            list.add(factureservice);
            
        }
        listfactureService = list;

    }

    public int getIdFacture() {
        return idFacture;
    }
    public void setIdFacture(int idFacture) {
        this.idFacture = idFacture;
    }
    public int getIdClient() {
        return idClient;
    }
    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }
    public String getRef() {
        return ref;
    }
    public void setRef(String ref) {
        this.ref = ref;
    }
    public Date getDateFacture() {
        return dateFacture;
    }
    public void setDateFacture(Date dateFacture) {
        this.dateFacture = dateFacture;
    }
    public double getMontantpaye() {
        return montantpaye;
    }
    public void setMontantpaye(double montantpaye) {
        this.montantpaye = montantpaye;
    }

    @Override
    public String toString() {
        return "Facture [listfactureService=" + listfactureService + "]";
    }

    public List<FactureService> getListfactureService() {
        return listfactureService;
    }

    public void setListfactureService(List<FactureService> listfactureService) {
        this.listfactureService = listfactureService;
    }
}
