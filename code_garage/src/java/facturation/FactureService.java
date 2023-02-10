package facturation;

import java.sql.Connection;
import java.sql.Statement;

import connexion.Connexion;
import metier.Service;

public class FactureService extends Service{
    int idFacture;
    int quantite;
    double prix_unitaire;
    double remise;

    

    public FactureService() {

    }

    public FactureService(int idfacture,int quantite,double prixunitaire,double remise) {
        this.setIdFacture(idfacture);
        this.setQuantite(quantite);
        this.setPrix_unitaire(prixunitaire);
        this.setRemise(remise);
    }


    public void saveDetailFacture(Connection connection,String idfacture,String idservice,String quantite,String montant,String remise)throws Exception {
        if (connection == null) {
            Connexion connexion = new Connexion();
            connection = connexion.Connex("postgres");
        }

            String requete= "insert into factureservice values ("+idfacture+","+idservice+","+quantite+","+montant+","+remise+")";
            Statement statement = connection.createStatement();
            statement.execute(requete);

        connection.close();
    }


    public double getMontantLine () {
        double montant = 0;
        montant = (this.getPrix_unitaire() - this.getMontantRemise() ) * this.getQuantite() ;
        return montant;
    }

    public double getMontantRemise() {
        double montant = 0;
        montant = (this.getPrix_unitaire() * this.getRemise()) / 100;
        return montant;
    }

    public int getIdFacture() {
        return idFacture;
    }
    public void setIdFacture(int idFacture) {
        this.idFacture = idFacture;
    }
    public int getQuantite() {
        return quantite;
    }
    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
    public double getPrix_unitaire() {
        return prix_unitaire;
    }
    public void setPrix_unitaire(double prix_unitaire) {
        this.prix_unitaire = prix_unitaire;
    }

    public double getRemise() {
        return remise;
    }

    public void setRemise(double remise) {
        this.remise = remise;
    }

    @Override
    public String toString() {
        return "FactureService [idFacture=" + idFacture + ", quantite=" + quantite + ", prix_unitaire=" + prix_unitaire
                + "]";
    }

    

}
