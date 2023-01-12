package connexion;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connexion {
    public Connexion(){
    
    }
    public Connection Connex(String base) throws Exception
    {   
        Connection connection = null;
        if (base == "Oracle") {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/Mahefa","scott","tiger");
        }
        else if (base == "postgres") {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/garage_project", "postgres", "root");
        }

        return connection;
        
    }
}
