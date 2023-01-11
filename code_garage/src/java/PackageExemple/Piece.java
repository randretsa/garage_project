package PackageExemple;

public class Piece {
    int Id;
    String ZonePiece;
    String nomPiece;
    int Quantite;
    int PrixUnitaire;

    public Piece() {
        
    }

    public int getId() {
        return Id;
    }
    public void setId(int id) {
        Id = id;
    }
    public String getZonePiece() {
        return ZonePiece;
    }
    public void setZonePiece(String zonePiece) {
        ZonePiece = zonePiece;
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
    public int getPrixUnitaire() {
        return PrixUnitaire;
    }
    public void setPrixUnitaire(int prixUnitaire) {
        PrixUnitaire = prixUnitaire;
    }
}
