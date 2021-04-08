/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import ConnectDataBase.ConnectDataBase;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Pascal_De_Marie
 */
public class ControleurUser {

    Statement st;
    ResultSet rs;
    DefaultTableModel dtm;
    String ref, noms, pass, type, rech;
    String entete[] = {"Référence", "Nom utilisateur", "Password"};

    public ControleurUser(String ref, String noms, String pass, String rech) {
        this.ref = ref;
        this.noms = noms;
        this.pass = pass;
        this.rech = rech;
    }

    public String getRef() {
        return ref;
    }

    public String getNoms() {
        return noms;
    }

    public String getPass() {
        return pass;
    }

    public String getType() {
        return type;
    }

    public String getRech() {
        return rech;
    }

    public DefaultTableModel getDtm() {
        return dtm;
    }

    public void remplirTableau() {
        try {
            st = new ConnectDataBase().getConnetion().createStatement();
            String reqver = "Select * from t_user";
            dtm = new DefaultTableModel(null, entete);
            rs = st.executeQuery(reqver);
            while (rs.next()) {
                Object row[] = new Object[3];
                row[0] = rs.getObject(1);
                row[1] = rs.getObject(2);
                row[2] = rs.getObject(3);
                dtm.addRow(row);
            }
        } catch (Exception ex) {
            System.out.print(ex);
        }
    }

    //Créér utilisateur
    public void CreateUser() {
        try {
            st = new ConnectDataBase().getConnetion().createStatement();
            String reqver = "Select * from t_user where Refuser='" + getRef() + "'";
            rs = st.executeQuery(reqver);
            if (rs.next()) {
                String refs = rs.getString("Refuser");
                JOptionPane.showMessageDialog(null, "Cet utilisateur existe déjà, c'est l'utilisateur : " + refs, "JStore : ERREUR", JOptionPane.ERROR_MESSAGE);
            } else {
                String reqis = "insert into t_user values('" + getRef() + "','" + getNoms() + "','" + getPass() + "')";
                st.executeUpdate(reqis);
                JOptionPane.showMessageDialog(null, "Utilisateur enregistré.", "JStore : INFORMATION", JOptionPane.INFORMATION_MESSAGE);
                ref = "";
                noms = "";
                pass = "";
                rech = "";
            }
        } catch (SQLException ex) {
            System.out.print(ex);
        }
    }

    // Modifier utilisateur
    public void ModifyUser() {
        try {
            st = new ConnectDataBase().getConnetion().createStatement();
            String reqver = "Select * from t_user where Refuser='" + getRef() + "'";
            rs = st.executeQuery(reqver);
            if (!rs.next()) {
                JOptionPane.showMessageDialog(null, "Cet utilisateur n'existe pas.", "JStore : ERREUR", JOptionPane.ERROR_MESSAGE);
            } else {
                String reqis = "update t_user set Nomuser='" + getNoms() + "',Pass='" + getPass() + "'where Refuser='" + getRef() + "'";
                st.executeUpdate(reqis);
                JOptionPane.showMessageDialog(null, "Utilisateur modifié.", "JStore : INFORMATION", JOptionPane.INFORMATION_MESSAGE);
                ref = "";
                noms = "";
                pass = "";
                rech = "";
            }
        } catch (SQLException ex) {
            System.out.print(ex);
        }
    }

    // Modifier utilisateur
    public void DeleteUser() {
        try {
            st = new ConnectDataBase().getConnetion().createStatement();
            String reqver = "Select * from t_user where Refuser='" + getRef() + "'";
            rs = st.executeQuery(reqver);
            if (!rs.next()) {
                JOptionPane.showMessageDialog(null, "Cet utilisateur n'existe pas.", "JStore : ERREUR", JOptionPane.ERROR_MESSAGE);
            } else {
                String reqis = "delete from t_user where Refuser='" + getRef() + "'";
                st.executeUpdate(reqis);
                JOptionPane.showMessageDialog(null, "Utilisateur supprimé.", "JStore : INFORMATION", JOptionPane.INFORMATION_MESSAGE);
                ref = "";
                noms = "";
                pass = "";
                rech = "";
            }
        } catch (SQLException ex) {
            System.out.print(ex);
        }
    }

    // Modifier utilisateur
    public void SearchUser() {
        try {
            st = new ConnectDataBase().getConnetion().createStatement();
            String reqver = "Select * from t_user where Refuser='" + getRech() + "'";
            rs = st.executeQuery(reqver);
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Les informations concernant cet utilisateur\non été trouvées avec succès.", "JStore : INFORMATION", JOptionPane.INFORMATION_MESSAGE);
                ref = rs.getString("Refuser");
                noms = rs.getString("Nomuser");
                pass = rs.getString("Pass");
            } else {
                JOptionPane.showMessageDialog(null, "Cet utilisateur n'existe pas.", "JStore : ERREUR", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            System.out.print(ex);
        }
    }
}
