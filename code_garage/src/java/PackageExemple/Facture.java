package PackageExemple;

import java.sql.Date;
import java.util.ArrayList;

public class Facture {
    Date Date;
    String Ref;
    String Client;
    ArrayList<?> ListPiece;

    public Facture() {
        
    }

    public Date getDate() {
        return Date;
    }
    public void setDate(Date date) {
        Date = date;
    }
    public String getRef() {
        return Ref;
    }
    public void setRef(String ref) {
        Ref = ref;
    }
    public String getClient() {
        return Client;
    }
    public void setClient(String client) {
        Client = client;
    }
    public ArrayList<?> getListPiece() {
        return ListPiece;
    }
    public void setListPiece(ArrayList<?> listPiece) {
        ListPiece = listPiece;
    }
}
