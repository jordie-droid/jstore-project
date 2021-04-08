/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ConnectDataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Pascal_De_Marie
 */
public class ConnectDataBase {

    public Connection getConnetion() {
        Connection c = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/b_geststockstandar";
            c = DriverManager.getConnection(url, "root", "");
            //Class.forName("org.sqlite.JDBC");
            //c = DriverManager.getConnection("jdbc:sqlite:aze.db");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Base de donnée non trouvée" + ex, "JStore : ERREUR", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        return c;
    }
}
