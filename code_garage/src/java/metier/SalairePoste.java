package metier;

public class SalairePoste extends Poste{
    double Montant;

    public SalairePoste() {

    }

    public SalairePoste(int id,String nom_poste,double montant) {
        super(id,nom_poste);
        this.setMontant(montant);
    }

    public double getMontant() {
        return Montant;
    }

    public void setMontant(double montant) {
        Montant = montant;
    }

}
