
package DAL;

import java.sql.*;
import javax.swing.JOptionPane;

public class Conectabd {

   
    public static Connection conectabd() throws ClassNotFoundException{
        try{
            Class.forName("org.postgresql.Driver");
            String usuario = "postgres";
            String senha = "admin";
            String url = "jbdc:postgresql://localhost:5432/controletrans";
            Connection con = DriverManager.getConnection( url, usuario, senha);
            //JOptionPane.showMessageDialog(null, "uHUUUUUUUL com sucesso");
            return con;
        }
        catch(SQLException error){
            JOptionPane.showMessageDialog(null, error);
            
            return null;
        }
    }
}
