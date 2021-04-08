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
public class ControleurFournisseur {

    Statement st = null;
    ResultSet rs = null;
    String refa;
    String nomsa;
    String adressea;
    String maila;
    String tela;
    String recha;
    private int yes;

    public ControleurFournisseur(String ref, String noms, String adresse, String mail, String tel, String rech) {
        refa = ref;
        nomsa = noms;
        adressea = adresse;
        maila = mail;
        tela = tel;
        recha = rech;
    }

    public String getReferenceFournisseur() {
        return refa;
    }

    public String getNomsFournisseur() {
        return nomsa;
    }

    public String getAdresseFournisseur() {
        return adressea;
    }

    public String getTelephoneFournisseur() {
        return tela;
    }

    public String getMailFournisseur() {
        return maila;
    }

    public String getRechercheFournisseur() {
        return recha;
    }

    //enregistrement
    public void enregistrer() {
        if (getReferenceFournisseur().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Veuillez remplir la référence.", "JStore : ERREUR", JOptionPane.ERROR_MESSAGE);
        } else {
            if (JOptionPane.showConfirmDialog(null, "Voullez-vous enregistrer ce fournisseur ?", "JStore : CONFIRMATION", JOptionPane.YES_NO_OPTION) == yes) {
                try {
                    st = new ConnectDataBase().getConnetion().createStatement();
                    String req = "Insert into t_fourn values('" + getReferenceFournisseur() + "','" + getNomsFournisseur() + "','" + getAdresseFournisseur() + "','" + getMailFournisseur() + "','" + getTelephoneFournisseur() + "')";
                    String reqver = "Select * from t_fourn where reffour='" + getReferenceFournisseur() + "'";
                    rs = st.executeQuery(reqver);
                    if (rs.next()) {
                        String art = rs.getString("nomsfour");
                        JOptionPane.showMessageDialog(null, "Ce fournisseur existe déjà. C'est le client : " + art, "JStore : INFORMATION", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        st.executeUpdate(req);
                        JOptionPane.showMessageDialog(null, "Fournisseur enregisté.", "JStore : INFORMATION", JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (SQLException ex) {
                    System.out.print(ex);
                }
            }
        }
    }

    //modification
    public void modification() {
        if (getReferenceFournisseur().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Veuillez remplir la référence.", "JStore : ERREUR", JOptionPane.ERROR_MESSAGE);
        } else {
            if (JOptionPane.showConfirmDialog(null, "Voullez-vous modifier ce fournisseur ?", "JStore : CONFIRMATION", JOptionPane.YES_NO_OPTION) == yes) {
                try {
                    st = new ConnectDataBase().getConnetion().createStatement();
                    String req = "Update t_fourn set nomsfour='" + getNomsFournisseur() + "',adressfour='" + getAdresseFournisseur() + "',mailfour='" + getMailFournisseur() + "',telfour='" + getTelephoneFournisseur() + "' where reffour='" + getReferenceFournisseur() + "'";
                    String reqver = "Select * from t_fourn where reffour='" + getReferenceFournisseur() + "'";
                    rs = st.executeQuery(reqver);
                    if (!rs.next()) {
                        JOptionPane.showMessageDialog(null, "Ce fournisseur n'existe pas.", "JStore : INFORMATION", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        st.executeUpdate(req);
                        JOptionPane.showMessageDialog(null, "Fournisseur enregistré.", "JStore : INFORMATION", JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (SQLException ex) {
                    System.out.print(ex);
                }
            }
        }
    }

    //suppression
    public void supprimer() {
        if (getReferenceFournisseur().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Veuillez remplir la référence.", "JStore : ERREUR", JOptionPane.ERROR_MESSAGE);
        } else {
            if (JOptionPane.showConfirmDialog(null, "Voullez-vous supprimer ce fournisseur ?", "JStore : CONFIRMATION", JOptionPane.YES_NO_OPTION) == yes) {
                try {
                    st = new ConnectDataBase().getConnetion().createStatement();
                    String req = "delete from t_fourn where reffour='" + getReferenceFournisseur() + "'";
                    String reqver = "Select * from t_fourn where reffour='" + getReferenceFournisseur() + "'";
                    rs = st.executeQuery(reqver);
                    if (!rs.next()) {
                        JOptionPane.showMessageDialog(null, "Ce fournisseur n'existe pas.", "JStore : INFORMATION", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        st.executeUpdate(req);
                        JOptionPane.showMessageDialog(null, "Fournisseur supprimé.", "JStore : INFORMATION", JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (SQLException ex) {
                    System.out.print(ex);
                }
            }
        }
    }

    //Rechercher
    public void rechercher() {
        if (getRechercheFournisseur().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Veuillez saisir le terme à rechercher.", "JStore : ERREUR", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                st = new ConnectDataBase().getConnetion().createStatement();
                String reqver = "Select * from t_fourn where reffour='" + getRechercheFournisseur() + "'";
                rs = st.executeQuery(reqver);
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "Les informations pour ce fournisseur \nont été trouvé avec succès.", "JStore : INFORMATION", JOptionPane.INFORMATION_MESSAGE);
                    refa = rs.getString("reffour");
                    nomsa = rs.getString("nomsfour");
                    adressea = rs.getString("adressfour");
                    maila = rs.getString("mailfour");
                    tela = rs.getString("telfour");
                } else {
                    JOptionPane.showMessageDialog(null, "Ce fournisseur n'existe pas.", "JStore : ERREUR", JOptionPane.ERROR_MESSAGE);
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
