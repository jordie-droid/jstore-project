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

/**
 *
 * @author Pascal_De_Marie
 */
public class ControleurClient {

    Statement st = null;
    ResultSet rs = null;
    String refa;
    String nomsa;
    String adressea;
    String maila;
    String tela;
    String recha;
    private int yes;

    public ControleurClient(String ref, String noms, String adresse, String mail, String tel, String rech) {
        refa = ref;
        nomsa = noms;
        adressea = adresse;
        maila = mail;
        tela = tel;
        recha = rech;
    }

    public String getReferenceClient() {
        return refa;
    }

    public String getNomsClient() {
        return nomsa;
    }

    public String getAdresseClient() {
        return adressea;
    }

    public String getTelephoneClient() {
        return tela;
    }

    public String getMailClient() {
        return maila;
    }

    public String getRechercheClient() {
        return recha;
    }

    //enregistrement
    public void enregistrer() {
        if (getReferenceClient().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Veuillez remplir la référence.", "JStore : ERREUR", JOptionPane.ERROR_MESSAGE);
        } else {
            if (JOptionPane.showConfirmDialog(null, "Voullez-vous enregistrer ce client ?", "JStore : CONFIRMATION", JOptionPane.YES_NO_OPTION) == yes) {
                try {
                    st = new ConnectDataBase().getConnetion().createStatement();
                    String req = "Insert into t_client values('" + getReferenceClient() + "','" + getNomsClient() + "','" + getAdresseClient() + "','" + getMailClient() + "','" + getTelephoneClient() + "')";
                    String reqver = "Select * from t_client where refcli='" + getReferenceClient() + "'";
                    rs = st.executeQuery(reqver);
                    if (rs.next()) {
                        String art = rs.getString("nomscli");
                        JOptionPane.showMessageDialog(null, "Ce client existe déjà. C'est le client : " + art, "JStore : INFORMATION", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        st.executeUpdate(req);
                        JOptionPane.showMessageDialog(null, "Client enregisté.", "JStore : INFORMATION", JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (SQLException ex) {
                    System.out.print(ex);
                }
            }
        }
    }

    //modification
    public void modification() {
        if (getReferenceClient().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Veuillez remplir la référence.", "JStore : ERREUR", JOptionPane.ERROR_MESSAGE);
        } else {
            if (JOptionPane.showConfirmDialog(null, "Voullez-vous modifier ce client ?", "JStore : CONFIRMATION", JOptionPane.YES_NO_OPTION) == yes) {
                try {
                    st = new ConnectDataBase().getConnetion().createStatement();
                    String req = "Update t_client set nomscli='" + getNomsClient() + "',adrcli='" + getAdresseClient() + "',mailcli='" + getMailClient() + "',telcli='" + getTelephoneClient() + "' where refcli='" + getReferenceClient() + "'";
                    String reqver = "Select * from t_client where refcli='" + getReferenceClient() + "'";
                    rs = st.executeQuery(reqver);
                    if (!rs.next()) {
                        JOptionPane.showMessageDialog(null, "Ce client n'existe pas.", "JStore : INFORMATION", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        st.executeUpdate(req);
                        JOptionPane.showMessageDialog(null, "Client modifié.", "JStore : INFORMATION", JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (SQLException ex) {
                    System.out.print(ex);
                }
            }
        }
    }

    //suppression
    public void supprimer() {
        if (getReferenceClient().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Veuillez remplir la référence.", "JStore : ERREUR", JOptionPane.ERROR_MESSAGE);
        } else {
            if (JOptionPane.showConfirmDialog(null, "Voullez-vous supprimer ce client ?", "JStore : CONFIRMATION", JOptionPane.YES_NO_OPTION) == yes) {
                try {
                    st = new ConnectDataBase().getConnetion().createStatement();
                    String req = "delete from t_client where refcli='" + getReferenceClient() + "'";
                    String reqver = "Select * from t_client where refcli='" + getReferenceClient() + "'";
                    rs = st.executeQuery(reqver);
                    if (!rs.next()) {
                        JOptionPane.showMessageDialog(null, "Ce client n'existe pas.", "JStore : INFORMATION", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        st.executeUpdate(req);
                        JOptionPane.showMessageDialog(null, "Client supprimé.", "JStore : INFORMATION", JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (SQLException ex) {
                    System.out.print(ex);
                }
            }
        }
    }

    //Rechercher
    public void rechercher() {
        if (getRechercheClient().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Veuillez saisir le terme à rechercher.", "JStore : ERREUR", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                st = new ConnectDataBase().getConnetion().createStatement();
                String reqver = "Select * from t_client where refcli='" + getRechercheClient() + "'";
                rs = st.executeQuery(reqver);
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "Les informations pour ce client \nont été trouvé avec succès.", "JStore : INFORMATION", JOptionPane.INFORMATION_MESSAGE);
                    refa = rs.getString("refcli");
                    nomsa = rs.getString("nomscli");
                    adressea = rs.getString("adrcli");
                    maila = rs.getString("mailcli");
                    tela = rs.getString("telcli");
                } else {
                    JOptionPane.showMessageDialog(null, "Ce client n'existe pas.", "JStore : ERREUR", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException ex) {
                System.out.print(ex);
            }
        }
    }

    //annuler
    public void annuler() {
        refa = "";
        nomsa = "";
        adressea = "";
        maila = "";
        tela = "";
    }
}
