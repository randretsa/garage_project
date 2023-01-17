package magasin;

public class Piece {
    int Id;
    String nomPiece;
    int Quantite;
    double PrixUnitaire;

    public Piece() {
        
    }

    public Piece(int id,String nom_piece,int quantite,double Prix) {
        this.setId(id);
        this.setNomPiece(nom_piece);
        this.setQuantite(quantite);
        this.setPrixUnitaire(Prix);
    }

    public int getId() {
        return Id;
    }
    public void setId(int id) {
        Id = id;
    }
    public String getNomPiece() {
        return nomPiece;
    }
    public void setNomPiece(String nomPiece) {
        this.nomPiece = nomPiece;
    }
    public int getQuantite() {
        return Quantite;
    }
    public void setQuantite(int quantite) {
        Quantite = quantite;
    }
    public double getPrixUnitaire() {
        return PrixUnitaire;
    }
    public void setPrixUnitaire(double prixUnitaire) {
        PrixUnitaire = prixUnitaire;
    }
}
