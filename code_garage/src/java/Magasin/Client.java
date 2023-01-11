package Magasin;

public class Client {
    int Id;
    String Nom;
    String Prenom;
    String Pwd;

    public Client() {
        
    }

    public int getId() {
        return Id;
    }
    public void setId(int Id) {
        this.Id = Id;
    }
    public String getNom() {
        return Nom;
    }
    public void setNom(String Nom) {
        this.Nom = Nom;
    }
    public String getPrenom() {
        return Prenom;
    }
    public void setPrenom(String Prenom) {
        this.Prenom = Prenom;
    }
    public String getPwd() {
        return Pwd;
    }
    public void setPwd(String Pwd) {
        this.Pwd = Pwd;
    }

}
