package magasin;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import connexion.Connexion;

public class CategoriePrix {
    int idCategore_prix;
    double minimum;
    double maximum;
    double pourcentage;

    

    public CategoriePrix(int idcategorie_prix,double minimum,double maximum,double pourcentage) {
        this.setIdCategore_prix(idcategorie_prix);
        this.setMinimum(minimum);
        this.setMaximum(maximum);
        this.setPourcentage(pourcentage);
    }



    public ArrayList<CategoriePrix> getCategoriePrix (Connection connection) throws Exception{
        ArrayList<CategoriePrix> list_categoriePrix = new ArrayList<CategoriePrix>();

        if (connection == null) {
            Connexion connexion = new Connexion();
            connection = connexion.Connex("postgres");
        }

        String requete= "select * from categorie_prix";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(requete);

        while (resultSet.next()) {
            CategoriePrix categoriePrix = new CategoriePrix(resultSet.getInt("idCategorie_prix"), resultSet.getDouble("minimum"), resultSet.getDouble("maximum"), resultSet.getDouble("pourcentage"));
            list_categoriePrix.add(categoriePrix);
        }

        return list_categoriePrix;
    }

    public int getIdCategore_prix() {
        return idCategore_prix;
    }
    public void setIdCategore_prix(int idCategore_prix) {
        this.idCategore_prix = idCategore_prix;
    }
    public double getMinimum() {
        return minimum;
    }
    public void setMinimum(double minimum) {
        this.minimum = minimum;
    }
    public double getMaximum() {
        return maximum;
    }
    public void setMaximum(double maximum) {
        this.maximum = maximum;
    }
    public double getPourcentage() {
        return pourcentage;
    }
    public void setPourcentage(double pourcentage) {
        this.pourcentage = pourcentage;
    }

    @Override
    public String toString() {
        return "CategoriePrix [idCategore_prix=" + idCategore_prix + ", minimum=" + minimum + ", maximum=" + maximum
                + ", pourcentage=" + pourcentage + "]";
    }

    public CategoriePrix() {

    }
}
