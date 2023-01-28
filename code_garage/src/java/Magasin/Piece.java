package magasin;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import connexion.Connexion;

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

    public Piece(int id,String nom_piece,double Prix) {
        this.setId(id);
        this.setNomPiece(nom_piece);
        this.setPrixUnitaire(Prix);
    }

    public ArrayList<Piece> getListePiece (Connection connection) throws Exception {
        ArrayList<Piece> list_piece = new ArrayList<Piece>();

        if (connection == null) {
            Connexion connexion = new Connexion();
            connection = connexion.Connex("postgres");
        }

        String requete= "select * from pieces";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(requete);

        while (resultSet.next()) {
            Piece piece = new Piece(resultSet.getInt("idpiece"), resultSet.getString("nom_piece"), resultSet.getDouble("prix"));
            list_piece.add(piece);
        }

        return list_piece;
    }



    public double getInteret () throws Exception {
        double calcul = 0;
        CategoriePrix categoriePrix = new CategoriePrix();
        ArrayList<CategoriePrix> list_categoriePrix = categoriePrix.getCategoriePrix(null);

        for (int i = 0; i < list_categoriePrix.size(); i++) {
            if (PrixUnitaire > list_categoriePrix.get(i).getMinimum() && PrixUnitaire <= list_categoriePrix.get(i).getMaximum()) {
                calcul = (PrixUnitaire * list_categoriePrix.get(i).getPourcentage()) /100; 
                break;
            }
            else {
                calcul = (PrixUnitaire * 20) /100;
            }
        }
        return calcul;
    }


    public double getPourcentage () throws Exception {
        double calcul = 0;
        CategoriePrix categoriePrix = new CategoriePrix();
        ArrayList<CategoriePrix> list_categoriePrix = categoriePrix.getCategoriePrix(null);

        for (int i = 0; i < list_categoriePrix.size(); i++) {
            if (PrixUnitaire > list_categoriePrix.get(i).getMinimum() && PrixUnitaire <= list_categoriePrix.get(i).getMaximum()) {
                calcul = list_categoriePrix.get(i).getPourcentage(); 
                break;
            }
            else {
                calcul = 20;
            }
        }
        return calcul;
    }


    public double getPrixConseiller()throws Exception {
        double prixConseiller = 0;
        prixConseiller = PrixUnitaire + getInteret();
        return prixConseiller;
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
