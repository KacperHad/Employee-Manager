
package ProjektPK;
import java.sql.*;

/**
 *
 * @author kacpe
 */
public class Connect {
    public Connection c;
    public Statement s;
    
    public Connect(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql:///pracownicy","root","");
            s = c.createStatement();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
