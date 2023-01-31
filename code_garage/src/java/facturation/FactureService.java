package facturation;

import metier.Service;

public class FactureService extends Service{
    int idFacture;
    int quantite;
    double prix_unitaire;

    public FactureService() {

    }

    public FactureService(int idfacture,int quantite,double prixunitaire) {
        this.setIdFacture(idfacture);
        this.setQuantite(quantite);
        this.setPrix_unitaire(prixunitaire);
    }


    public double getMontantLine () {
        double montant = 0;
        montant = this.getPrix_unitaire() * this.getQuantite();
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

    @Override
    public String toString() {
        return "FactureService [idFacture=" + idFacture + ", quantite=" + quantite + ", prix_unitaire=" + prix_unitaire
                + "]";
    }

    

}
