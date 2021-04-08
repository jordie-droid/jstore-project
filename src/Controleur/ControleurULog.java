/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import ConnectDataBase.ConnectDataBase;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Pascal_De_Marie
 */
public class ControleurULog {
    
    Statement st = null;
    ResultSet rs = null;
    DefaultTableModel dtm;
    int yes;
    String termea;
    String ter;

    public ControleurULog(String terme, String tera) {
        termea = terme;
        ter = tera;
    }

    public DefaultTableModel getDtm() {
        return dtm;
    }

    public void remplirTableau() {
        String entete[] = {"Numéro log", "Utilisateur", "Type utilisateur", "Date log", "Etat de log"};
        dtm = new DefaultTableModel(null, entete);
        Object row[] = new Object[5];
        String req = "select t_log.RowNum,t_user.Nomuser,t_log.Typuser,t_log.DaLog,t_log.StatLog from t_log,t_user,t_admi where t_user.Refuser=t_log.Refuser";
        try {
            st = new ConnectDataBase().getConnetion().createStatement();
            rs = st.executeQuery(req);
            while (rs.next()) {
                row[0] = rs.getObject(1);
                row[1] = rs.getObject(2);
                row[2] = rs.getObject(3);
                row[3] = rs.getObject(4);
                row[4] = rs.getObject(5);
                dtm.addRow(row);
            }
        } catch (SQLException ex) {
            System.out.print(ex);
        }
    }

    public void Rechercher() {
        String entete[] = {"Numéro log", "Utilisateur", "Type utilisateur", "Date log", "Etat de log"};
        dtm = new DefaultTableModel(null, entete);
        Object row[] = new Object[5];
        String req = "select t_log.RowNum,t_user.Nomuser,t_log.Typuser,t_log.DaLog,t_log.StatLog from t_log,t_user,t_admi where t_user.Refuser=t_log.Refuser and t_log.DaLog between '" + termea + "'and '" + ter + "'";
        try {
            st = new ConnectDataBase().getConnetion().createStatement();
            rs = st.executeQuery(req);
            while (rs.next()) {
                row[0] = rs.getObject(1);
                row[1] = rs.getObject(2);
                row[2] = rs.getObject(3);
                row[3] = rs.getObject(4);
                row[4] = rs.getObject(5);
                dtm.addRow(row);
            }
        } catch (SQLException ex) {
            System.out.print(ex);
        }
    }
    
}
