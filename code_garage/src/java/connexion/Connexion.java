package connexion;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connexion {
    public Connexion(){
    
    }
    public Connection Connex(String base) throws Exception
    {   
        Connection connection = null;
        Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/garage_project", base, "Mahefa01");
        return connection;
        
    }
}
