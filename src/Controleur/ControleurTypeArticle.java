/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import ConnectDataBase.ConnectDataBase;
import Forms.F_typart;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Pascal_De_Marie
 */
public class ControleurTypeArticle {

    Statement st = null;
    ResultSet rs = null;
    String refa;
    String liba;
    String car1a;
    String car2a;
    String tra;
    String RechPara;
    int yes;
    F_typart typ = new F_typart(new javax.swing.JFrame(), true);
    //constructeur

    public ControleurTypeArticle(String ref, String lib, String car1, String car2, String RechPar, String tr) {
        refa = ref;
        liba = lib;
        car1a = car1;
        car2a = car2;
        tra = tr;
        RechPara = RechPar;
    }

    public String getReference() {
        return refa;
    }

    public String getLibelle() {
        return liba;
    }

    public String getCaracteristique1() {
        return car1a;
    }

    public String getCaracteristique2() {
        return car2a;
    }

    public String getTermeDeRecherche() {
        return tra;
    }

    //enregistrer
    public void enregistrer() {
        if (getReference().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Veuillez remplir la référence.",  "JStore : ERREUR", JOptionPane.ERROR_MESSAGE);
        } else {
            if (JOptionPane.showConfirmDialog(null, "Voullez-vous enregistrer ce type d'article ?", "JStore : CONFIRMATION", JOptionPane.YES_NO_OPTION) == yes) {
                try {
                    st = new ConnectDataBase().getConnetion().createStatement();
                    String req = "Insert into t_typart values('" + getReference() + "','" + getLibelle() + "','" + getCaracteristique1() + "','" + getCaracteristique2() + "')";
                    String reqver = "Select * from t_typart where codtype='" + getReference() + "'";
                    rs = st.executeQuery(reqver);
                    if (rs.next()) {
                        String art = rs.getString("libtype") + " " + rs.getString("caract1") + " " + rs.getString("caract2");
                        JOptionPane.showMessageDialog(null, "Ce type d'article existe déjà. C'est le type : " + art, "JStore : ERREUR", JOptionPane.ERROR_MESSAGE);
                    } else {
                        st.executeUpdate(req);
                        JOptionPane.showMessageDialog(null, "Type d'article enregisté.", "JStore : INFORMATION", JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (SQLException ex) {
                    System.out.print(ex);
                }
            }
        }
    }

    //modifier
    public void modifier() {
        if (getReference().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Veuillez remplir la référence.", "JStore : ERREUR", JOptionPane.ERROR_MESSAGE);
        } else {
            if (JOptionPane.showConfirmDialog(null, "Voullez-vous modifier ce type d'article ?", "JStore : CONFIRMATION", JOptionPane.YES_NO_OPTION) == yes) {
                try {
                    st = new ConnectDataBase().getConnetion().createStatement();
                    String req = "Update t_typart set libtype='" + getLibelle() + "',caract1='" + getCaracteristique1() + "',caract2='" + getCaracteristique2() + "' where codtype='" + getReference() + "'";
                    String reqver = "Select * from t_typart where codtype='" + getReference() + "'";
                    rs = st.executeQuery(reqver);
                    if (!rs.next()) {
                        JOptionPane.showMessageDialog(null, "Ce type d'article n'existe pas.", "JStore : ERREUR", JOptionPane.ERROR_MESSAGE);
                    } else {
                        st.executeUpdate(req);
                        JOptionPane.showMessageDialog(null, "Type d'article modifiée.", "JStore : INFORMATION", JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (SQLException ex) {
                    System.out.print(ex);
                }
            }
        }
    }

    public void supprimer() {
        if (getReference().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Veuillez remplir la référence.", "JStore : ERREUR", JOptionPane.ERROR_MESSAGE);
        } else {
            if (JOptionPane.showConfirmDialog(null, "Voullez-vous supprimer ce type d'article ?", "JStore : CONFIRMATION", JOptionPane.YES_NO_OPTION) == yes) {
                try {
                    st = new ConnectDataBase().getConnetion().createStatement();
                    String req = "Delete from t_typart where codtype='" + getReference() + "'";
                    String reqver = "Select * from t_typart where codtype='" + getReference() + "'";
                    rs = st.executeQuery(reqver);
                    if (!rs.next()) {
                        JOptionPane.showMessageDialog(null, "Ce type d'article n'existe pas.", "JStore : ERREUR", JOptionPane.ERROR_MESSAGE);
                    } else {
                        st.executeUpdate(req);
                        JOptionPane.showMessageDialog(null, "Type d'article supprimée.", "JStore : INFORMATION", JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (SQLException ex) {
                    System.out.print(ex);
                }
            }
        }
    }

    //Rechercher
    public void rechercher() {
        if (getTermeDeRecherche().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Veuillez saisir le terme à rechercher.", "JStore : ERREUR", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                st = new ConnectDataBase().getConnetion().createStatement();
                String reqver = "Select * from t_typart where codtype='" + getTermeDeRecherche() + "'";
                rs = st.executeQuery(reqver);
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "Les informations pour ce type d'article \nont été trouvé avec succès.", "JStore : INFORMATION", JOptionPane.INFORMATION_MESSAGE);
                    refa = rs.getString("codtype");
                    liba = rs.getString("libtype");
                    car1a = rs.getString("caract1");
                    car2a = rs.getString("caract2");
                } else {
                    JOptionPane.showMessageDialog(null, "Ce type d'article n'existe pas.", "JStore : ERREUR", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException ex) {
                System.out.print(ex);
            }
        }
    }

    //annuler();
    public void annuler() {
        refa = "";
        liba = "";
        car1a = "";
        car2a = "";
    }
}
