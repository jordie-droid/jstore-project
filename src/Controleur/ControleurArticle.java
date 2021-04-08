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
public class ControleurArticle {

    Statement st = null;
    ResultSet rs = null;
    String refa;
    String desa;
    String typea;
    String recha;
    String car1a;
    String car2a;
    String refart;
    int yes;

    //constructeur
    public ControleurArticle(String ref, String des, String type, String car1, String car2, String refar, String rech) {
        refa = ref;
        desa = des;
        typea = type;
        recha = rech;
        car1a = car1;
        car2a = car2;
        refart = refar;
    }

    public String getReferenceArticle() {
        return refa;
    }

    public String getDesignation() {
        return desa;
    }

    public String getTypeArticle() {
        return typea;
    }

    public String getCaracteristique1() {
        return car1a;
    }

    public String getCaracteristique2() {
        return car2a;
    }

    public String getReferenceTypeArticle() {
        return refart;
    }

    public String getTermeAchercher() {
        return recha;
    }

    //les caractéristique
    public void caracteristiques() {
        try {
            String reqrech = "SELECT * FROM t_typart where libtype='" + typea + "'";
            st = new ConnectDataBase().getConnetion().createStatement();
            rs = st.executeQuery(reqrech);
            while (rs.next()) {
                car1a = rs.getString("caract1");
                car2a = rs.getString("caract2");
                refart = rs.getString("codtype");
            }
        } catch (Exception ex) {
            System.out.print(ex);
        }
    }

    //enregistrement
    public void enregistrer() {
        if (getReferenceArticle().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Veuillez remplir la référence.", "JStore : ERREUR", JOptionPane.ERROR_MESSAGE);
        } else {
            if (JOptionPane.showConfirmDialog(null, "Voullez-vous enregistrer cet article ?", "JStore : CONFIRMATION", JOptionPane.YES_NO_OPTION) == yes) {
                try {
                    st = new ConnectDataBase().getConnetion().createStatement();
                    String req = "Insert into t_article values('" + getReferenceArticle() + "','" + getDesignation() + "','" + getReferenceTypeArticle() + "')";
                    String reqver = "Select * from t_article where refart='" + getReferenceArticle() + "'";
                    rs = st.executeQuery(reqver);
                    if (rs.next()) {
                        String art = rs.getString("design");
                        JOptionPane.showMessageDialog(null, "Cet article existe déjà. C'est l'article : " + art, "JStore : INFORMATION", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        st.executeUpdate(req);
                        JOptionPane.showMessageDialog(null, "Article enregisté.", "JStore : INFORMATION", JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (SQLException ex) {
                    System.out.print(ex);
                }
            }
        }
    }

    //modification
    public void modifier() {
        if (getReferenceArticle().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Veuillez remplir la référence.", "JStore : ERREUR", JOptionPane.ERROR_MESSAGE);
        } else {
            if (JOptionPane.showConfirmDialog(null, "Voullez-vous modifier cet article ?", "JStore : CONFIRMATION", JOptionPane.YES_NO_OPTION) == yes) {
                try {
                    st = new ConnectDataBase().getConnetion().createStatement();
                    String req = "update t_article set design='" + getDesignation() + "', codtype='" + getReferenceTypeArticle() + "' where refart='" + getReferenceArticle() + "'";
                    String reqver = "Select * from t_article where refart='" + getReferenceArticle() + "'";
                    rs = st.executeQuery(reqver);
                    if (!rs.next()) {
                        JOptionPane.showMessageDialog(null, "Cet article n'existe pas.", "JStore : ERREUR", JOptionPane.ERROR_MESSAGE);
                    } else {
                        st.executeUpdate(req);
                        JOptionPane.showMessageDialog(null, "Article modifié.", "JStore : INFORMATION", JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (SQLException ex) {
                    System.out.print(ex);
                }
            }
        }
    }

    //modification
    public void supprimer() {
        if (getReferenceArticle().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Veuillez remplir la référence.", "JStore : ERREUR", JOptionPane.ERROR_MESSAGE);
        } else {
            if (JOptionPane.showConfirmDialog(null, "Voullez-vous supprimer cet article ?", "JStore : CONFIRMATION", JOptionPane.YES_NO_OPTION) == yes) {
                try {
                    st = new ConnectDataBase().getConnetion().createStatement();
                    String req = "delete from t_article where refart='" + getReferenceArticle() + "'";
                    String reqver = "Select * from t_article where refart='" + getReferenceArticle() + "'";
                    rs = st.executeQuery(reqver);
                    if (!rs.next()) {
                        JOptionPane.showMessageDialog(null, "Cet article n'existe pas.", "JStore : ERREUR", JOptionPane.ERROR_MESSAGE);
                    } else {
                        st.executeUpdate(req);
                        JOptionPane.showMessageDialog(null, "Article supprimé.", "JStore : INFORMATION", JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (SQLException ex) {
                    System.out.print(ex);
                }
            }
        }
    }

    //Rechercher
    public void rechercher() {
        if (getTermeAchercher().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Veuillez saisir le terme à rechercher.", "JStore : ERREUR", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                st = new ConnectDataBase().getConnetion().createStatement();
                String reqver = "Select * from t_article where refart='" + getTermeAchercher() + "'";
                rs = st.executeQuery(reqver);
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "Les informations pour cet article \nont été trouvé avec succès.", "JStore : INFORMATION", JOptionPane.INFORMATION_MESSAGE);
                    refa = rs.getString("refart");
                    desa = rs.getString("design");
                    refart = rs.getString("codtype");
                    String rechtyp = "Select * from t_typart where codtype='" + getReferenceTypeArticle() + "'";
                    rs = st.executeQuery(rechtyp);
                    if (rs.next()) {
                        typea = rs.getString("libtype");
                        car1a = rs.getString("caract1");
                        car2a = rs.getString("caract2");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Cet article n'existe pas.", "JStore : ERREUR", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException ex) {
                System.out.print(ex);
            }
        }
    }

    //annuler();
    public void annuler() {
        refa = "";
        desa = "";
        car1a = "";
        car2a = "";
        typea = "";
    }
}
