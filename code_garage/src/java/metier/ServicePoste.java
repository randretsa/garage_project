package metier;

public class ServicePoste {
    SalairePoste poste;
    double dure;

    public ServicePoste() {

    }

    public ServicePoste(SalairePoste poste,double dure) {
        this.setPoste(poste);
        this.setDure(dure);
    }

    public SalairePoste getPoste() {
        return poste;
    }
    public void setPoste(SalairePoste poste) {
        this.poste = poste;
    }
    public double getDure() {
        return dure;
    }
    public void setDure(double dure) {
        this.dure = dure;
    }
}
