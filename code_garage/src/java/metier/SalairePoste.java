package metier;

public class SalairePoste extends Poste{
    int Montant;

    public SalairePoste() {

    }

    public SalairePoste(int montant) {
        this.setMontant(montant);
    }

    public int getMontant() {
        return Montant;
    }

    public void setMontant(int montant) {
        Montant = montant;
    }

}
