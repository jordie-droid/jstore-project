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
public class ControleurData {

    Statement st = null;
    ResultSet rs = null;
    DefaultTableModel dtm;
    int yes;
    String termea;
    String ter;

    public ControleurData(String terme, String tera) {
        termea = terme;
        ter=tera;
    }

    public DefaultTableModel getDtm() {
        return dtm;
    }

    public void remplirTableau() {
        switch (termea) {
            case "Type d'article": {
                String entete[] = {"Référence", "Libellé", "Carartéristique 1", "Carartéristique 2"};
                dtm = new DefaultTableModel(null, entete);
                Object row[] = new Object[4];
                String req = "Select * from t_typart";
                try {
                    st = new ConnectDataBase().getConnetion().createStatement();
                    rs = st.executeQuery(req);
                    while (rs.next()) {
                        row[0] = rs.getObject(1);
                        row[1] = rs.getObject(2);
                        row[2] = rs.getObject(3);
                        row[3] = rs.getObject(4);
                        dtm.addRow(row);
                    }
                } catch (SQLException ex) {
                    System.out.print(ex);
                }
                break;
            }
            case "Article": {
                String entete[] = {"Référence", "Désignation", "Type d'article"};
                dtm = new DefaultTableModel(null, entete);
                Object row[] = new Object[3];
                String req = "Select t_article.refart,t_article.design,t_typart.libtype from t_article, t_typart where t_article.codtype=t_typart.codtype";
                try {
                    st = new ConnectDataBase().getConnetion().createStatement();
                    rs = st.executeQuery(req);
                    while (rs.next()) {
                        row[0] = rs.getObject(1);
                        row[1] = rs.getObject(2);
                        row[2] = rs.getObject(3);
                        dtm.addRow(row);
                    }
                } catch (SQLException ex) {
                    System.out.print(ex);
                }
                break;
            }
            case "Fournisseur": {
                String entete[] = {"Référence", "Noms fournisseur", "Adresse fournisseur", "Mail fournisseur", "Téléphone fournisseur"};
                dtm = new DefaultTableModel(null, entete);
                Object row[] = new Object[5];
                String req = "Select * from t_fourn";
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
                break;
            }
            case "Client": {
                String entete[] = {"Référence", "Noms Client", "Adresse Client", "Mail Client", "Téléphone Client"};
                dtm = new DefaultTableModel(null, entete);
                Object row[] = new Object[5];
                String req = "Select * from t_client";
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
                break;
            }
        }
    }
    
    public void Rechercher() {
        switch (termea) {
            case "Type d'article": {
                String entete[] = {"Référence", "Libellé", "Carartéristique 1", "Carartéristique 2"};
                dtm = new DefaultTableModel(null, entete);
                Object row[] = new Object[4];
                String req = "Select * from t_typart where codtype='"+ter+"' or libtype='"+ter+"'";
                try {
                    st = new ConnectDataBase().getConnetion().createStatement();
                    rs = st.executeQuery(req);
                    while (rs.next()) {
                        row[0] = rs.getObject(1);
                        row[1] = rs.getObject(2);
                        row[2] = rs.getObject(3);
                        row[3] = rs.getObject(4);
                        dtm.addRow(row);
                    }
                } catch (SQLException ex) {
                    System.out.print(ex);
                }
                break;
            }
            case "Article": {
                String entete[] = {"Référence", "Désignation", "Type d'article"};
                dtm = new DefaultTableModel(null, entete);
                Object row[] = new Object[3];
                String req = "Select t_article.refart,t_article.design,t_typart.libtype from t_article, t_typart where t_article.codtype=t_typart.codtype and refart='"+ter+"' or design='"+ter+"'";
                try {
                    st = new ConnectDataBase().getConnetion().createStatement();
                    rs = st.executeQuery(req);
                    while (rs.next()) {
                        row[0] = rs.getObject(1);
                        row[1] = rs.getObject(2);
                        row[2] = rs.getObject(3);
                        dtm.addRow(row);
                    }
                } catch (SQLException ex) {
                    System.out.print(ex);
                }
                break;
            }
            case "Fournisseur": {
                String entete[] = {"Référence", "Noms fournisseur", "Adresse fournisseur", "Mail fournisseur", "Téléphone fournisseur"};
                dtm = new DefaultTableModel(null, entete);
                Object row[] = new Object[5];
                String req = "Select * from t_fourn where reffour='"+ter+"' or nomsfour='"+ter+"' or adressfour='"+ter+"' or mailfour='"+ter+"' or telfour='"+ter+"'";
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
                break;
            }
            case "Client": {
                String entete[] = {"Référence", "Noms Client", "Adresse Client", "Mail Client", "Téléphone Client"};
                dtm = new DefaultTableModel(null, entete);
                Object row[] = new Object[5];
                String req = "Select * from t_client where refcli='"+ter+"' or nomscli='"+ter+"' or adrcli='"+ter+"'  or mailcli='"+ter+"' or telcli='"+ter+"'";
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
                break;
            }
        }
    }
    }