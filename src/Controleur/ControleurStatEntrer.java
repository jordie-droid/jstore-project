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
public class ControleurStatEntrer {
    
    Statement st = null;
    ResultSet rs = null;
    DefaultTableModel dtm;
    int yes;
    String termea;
    String ter;

    public ControleurStatEntrer(String terme, String tera) {
        termea = terme;
        ter = tera;
    }

    public DefaultTableModel getDtm() {
        return dtm;
    }

    public void remplirTableau() {
        String entete[] = {"Numéro d'entrée", "Date d'entrée", "Quantité", "Prix unitaire", "Fournisseur", "Article"};
        dtm = new DefaultTableModel(null, entete);
        Object row[] = new Object[6];
        String req = "Select t_entrer.numstock,t_entrer.DateEntrer,t_entrer.QteEntrer,t_entrer.PrixUnitaire,t_fourn.nomsfour,t_article.design from t_entrer,t_article,t_fourn where t_article.refart=t_entrer.refart and t_fourn.reffour=t_entrer.reffour";
        try {
            st = new ConnectDataBase().getConnetion().createStatement();
            rs = st.executeQuery(req);
            while (rs.next()) {
                row[0] = rs.getObject(1);
                row[1] = rs.getObject(2);
                row[2] = rs.getObject(3);
                row[3] = rs.getObject(4);
                row[4] = rs.getObject(5);
                row[5] = rs.getObject(6);
                dtm.addRow(row);
            }
        } catch (SQLException ex) {
            System.out.print(ex);
        }
    }

    public void Rechercher() {
        String entete[] = {"Numéro d'entrée", "Date d'entrée", "Quantité", "Prix unitaire", "Fournisseur", "Article"};
        dtm = new DefaultTableModel(null, entete);
        Object row[] = new Object[6];
        String req = "Select t_entrer.numstock,t_entrer.DateEntrer,t_entrer.QteEntrer,t_entrer.PrixUnitaire,t_fourn.nomsfour,t_article.design from t_entrer,t_article,t_fourn where t_article.refart=t_entrer.refart and t_fourn.reffour=t_entrer.reffour and t_entrer.DateEntrer between '" + termea + "'and '" + ter + "'";
        try {
            st = new ConnectDataBase().getConnetion().createStatement();
            rs = st.executeQuery(req);
            while (rs.next()) {
                row[0] = rs.getObject(1);
                row[1] = rs.getObject(2);
                row[2] = rs.getObject(3);
                row[3] = rs.getObject(4);
                row[4] = rs.getObject(5);
                row[5] = rs.getObject(6);
                dtm.addRow(row);
            }
        } catch (SQLException ex) {
            System.out.print(ex);
        }
    }
    //select t_entrer.QteEntrer,t_article.design from t_article,t_entrer where t_entrer.refart=t_article.refart and DateEntrer between '2016-11-06' and '2016-11-06'

}
