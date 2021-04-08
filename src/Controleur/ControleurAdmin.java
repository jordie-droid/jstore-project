/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import ConnectDataBase.ConnectDataBase;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Pascal_De_Marie
 */
public class ControleurAdmin {

    Statement st;
    ResultSet rs;
    DefaultTableModel dtm;
    String ref, noms, pass, type, rech;
    String entete[] = {"Référence", "Nom utilisateur", "Password"};
    int yes;
    ImageIcon EnRe = new ImageIcon(getClass().getResource("/Icons/alert.image_icon_info.png"));
    ImageIcon ErRo = new ImageIcon(getClass().getResource("/Icons/error.png"));

    public ControleurAdmin(String ref, String noms, String pass, String rech) {
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
            String reqver = "Select * from t_admi";
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
            if (JOptionPane.showConfirmDialog(null, "Voulez-vous enregistrer cet administrateur ?", "JStore : Confirmation", JOptionPane.OK_CANCEL_OPTION) == yes) {
                st = new ConnectDataBase().getConnetion().createStatement();
                String reqver = "Select * from t_admi where Refuser='" + getRef() + "'";
                rs = st.executeQuery(reqver);
                if (rs.next()) {
                    String refs = rs.getString("Refuser");
                    JOptionPane.showMessageDialog(null, "L'administrateur que vous voulez enregistrer existe déjà.\n c'est : " + refs, "JStore : ERREUR", JOptionPane.ERROR_MESSAGE, ErRo);
                } else {
                    String reqis = "insert into t_admi values('" + getRef() + "','" + getNoms() + "','" + getPass() + "')";
                    st.executeUpdate(reqis);
                    JOptionPane.showMessageDialog(null, "Administrateur enregistré.", "JStore : INFORMATION", JOptionPane.INFORMATION_MESSAGE, EnRe);
                    ref = "";
                    noms = "";
                    pass = "";
                    rech = "";
                }
            } else {
                JOptionPane.showMessageDialog(null, "L'enregistrement de cet administrateur est annulé.", "JStore : INFORMATION", JOptionPane.INFORMATION_MESSAGE, ErRo);
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
            if (JOptionPane.showConfirmDialog(null, "Voulez-vous modifier cet administrateur ?", "JStore : Confirmation", JOptionPane.OK_CANCEL_OPTION) == yes) {
                st = new ConnectDataBase().getConnetion().createStatement();
                String reqver = "Select * from t_admi where Refuser='" + getRef() + "'";
                rs = st.executeQuery(reqver);
                if (!rs.next()) {
                    JOptionPane.showMessageDialog(null, "L'administrateur que vous voulez modifier n'existe pas.", "JStore : ERREUR", JOptionPane.ERROR_MESSAGE, ErRo);
                } else {
                    String reqis = "update t_admi set Nomuser='" + getNoms() + "',Pass='" + getPass() + "'where Refuser='" + getRef() + "'";
                    st.executeUpdate(reqis);
                    JOptionPane.showMessageDialog(null, "Administrateur modifié.", "JStore : INFORMATION", JOptionPane.INFORMATION_MESSAGE, EnRe);
                    ref = "";
                    noms = "";
                    pass = "";
                    rech = "";
                }
            } else {
                JOptionPane.showMessageDialog(null, "La modification de cet administrateur est annulé.", "JStore : INFORMATION", JOptionPane.INFORMATION_MESSAGE, ErRo);
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
            if (JOptionPane.showConfirmDialog(null, "Voulez-vous supprimer cet administrateur ?", "JStore : Confirmation", JOptionPane.OK_CANCEL_OPTION) == yes) {
                st = new ConnectDataBase().getConnetion().createStatement();
                String reqver = "Select * from t_admi where Refuser='" + getRef() + "'";
                rs = st.executeQuery(reqver);
                if (!rs.next()) {
                    JOptionPane.showMessageDialog(null, "L'administrateur que vous voulez supprimer n'existe pas.", "JStore : ERREUR", JOptionPane.ERROR_MESSAGE, ErRo);
                } else {
                    String reqis = "delete from t_admi where Refuser='" + getRef() + "'";
                    st.executeUpdate(reqis);
                    JOptionPane.showMessageDialog(null, "Administrateur supprimé.", "JStore : INFORMATION", JOptionPane.INFORMATION_MESSAGE, EnRe);
                    ref = "";
                    noms = "";
                    pass = "";
                    rech = "";
                }
            } else {
                JOptionPane.showMessageDialog(null, "La suppression de cet administrateur est annulé.", "JStore : INFORMATION", JOptionPane.INFORMATION_MESSAGE, ErRo);
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
            if (JOptionPane.showConfirmDialog(null, "Voulez-vous rechercher cet administrateur ?", "JStore : Confirmation", JOptionPane.OK_CANCEL_OPTION) == yes) {
                st = new ConnectDataBase().getConnetion().createStatement();
                String reqver = "Select * from t_admi where Refuser='" + getRech() + "'";
                rs = st.executeQuery(reqver);
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "Les informations sur l'administrateur concerné\non été trouvées avec succès.", "JStore : INFORMATION", JOptionPane.INFORMATION_MESSAGE, EnRe);
                    ref = rs.getString("Refuser");
                    noms = rs.getString("Nomuser");
                    pass = rs.getString("Pass");
                } else {
                    JOptionPane.showMessageDialog(null, "L'administrateur que vous rechercher n'existe pas.", "JStore : ERREUR", JOptionPane.ERROR_MESSAGE, ErRo);
                }
            } else {
                JOptionPane.showMessageDialog(null, "La recherche de cet administrateur est annulé.", "JStore : INFORMATION", JOptionPane.INFORMATION_MESSAGE, ErRo);
                ref = "";
                noms = "";
                pass = "";
                rech = "";
            }
        } catch (SQLException ex) {
            System.out.print(ex);
        }
    }
}
