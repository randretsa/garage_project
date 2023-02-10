package finance;

import java.util.ArrayList;
import java.util.Date;

import facturation.Facture;
import java.lang.Exception;
import finance.DetailDepense;

public class EtatFinance {
    ArrayList<DetailDepense> detailDepenses = new ArrayList<DetailDepense>();
    ArrayList<Facture> listFacture = new ArrayList<Facture>();
    double recette;
    double depense;
    double detail;

    public void Recette()throws Exception {
        double montantPaye = 0;
        double montantRepport = 0;
        Facture facture = new Facture();
        Repport repport = new Repport().getRepport(null);
        Date dateRepport = new Date(repport.getDate_repport().getTime());
        montantRepport = repport.getMontant();

        for(Facture f : facture.getAllFacture(null)) {
            Date dt = new Date(f.getDateFacture().getTime());
            if (dt.after(dateRepport)) {
                montantPaye = montantPaye + f.getMontantpaye();
            }
        }

        this.setRecette(montantPaye + montantRepport);

    }

    public void depense()throws Exception {
        double montantDepense = 0;
        DetailDepense detailDepense = new DetailDepense();
        Repport repport = new Repport().getRepport(null);
        Date dateRepport = new Date(repport.getDate_repport().getTime());

        for(DetailDepense dp : detailDepense.getAllDetailDepense(null)) {
            Date dt = new Date(dp.getDate_Depense().getTime());
            if (dt.after(dateRepport)) {
                montantDepense = montantDepense + dp.getMontant();
            }
        }

        this.setDepense(montantDepense);
    }


    public void detailCaisse() {
        double detailCaisse = 0;
        detailCaisse = this.getRecette() - this.getDepense();

        this.setDetail(detailCaisse);
    }


    public ArrayList<DetailDepense> getDetailDepenses() {
        return detailDepenses;
    }
    public void setDetailDepenses(ArrayList<DetailDepense> detailDepenses) {
        this.detailDepenses = detailDepenses;
    }
    public ArrayList<Facture> getListFacture() {
        return listFacture;
    }
    public void setListFacture(ArrayList<Facture> listFacture) {
        this.listFacture = listFacture;
    }

    public double getRecette() {
        return recette;
    }

    public void setRecette(double recette) {
        this.recette = recette;
    }

    public double getDepense() {
        return depense;
    }

    public void setDepense(double depense) {
        this.depense = depense;
    }

    public double getDetail() {
        return detail;
    }

    public void setDetail(double detail) {
        this.detail = detail;
    }

}
