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
public class ControleurVueEntree {

    Statement st = null;
    ResultSet rs = null;
    DefaultTableModel dtm;
    int yes;
    String termea;
    String ter, NFour, Nprod;
    boolean Une, Deux, Inf, sup, Four, Pro;

    public ControleurVueEntree(String terme, String tera, boolean Une, boolean Deux, boolean Inf, boolean sup, boolean Four, boolean Pro, String NFour, String NPro) {
        termea = terme;
        ter = tera;
        this.Une = Une;
        this.Deux = Deux;
        this.Inf = Inf;
        this.sup = sup;
        this.Four = Four;
        this.Pro = Pro;
        this.NFour = NFour;
        this.Nprod = NPro;
    }

    public DefaultTableModel getDtm() {
        return dtm;
    }

    public void remplirTableau() {
        String entete[] = {"Numéro d'entrée", "Date d'entrée", "Quantité", "Prix unitaire", "Fournisseur", "Article"};
        dtm = new DefaultTableModel(null, entete);
        Object row[] = new Object[6];
        String req = "Select t_entrer.numstock,t_entrer.DateEntrer,t_entrer.QteEntrer,t_entrer.PrixUnitaire,t_fourn.nomsfour,t_article.design from t_entrer,t_article,t_fourn where t_article.refart=t_entrer.refart and t_fourn.reffour=t_entrer.reffour order by t_entrer.numstock";
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
        try {
            if (Une == true && Four==false && Pro==false) {
                String req1 = "Select t_entrer.numstock,t_entrer.DateEntrer,t_entrer.QteEntrer,t_entrer.PrixUnitaire,t_fourn.nomsfour,t_article.design from t_entrer,t_article,t_fourn where t_article.refart=t_entrer.refart and t_fourn.reffour=t_entrer.reffour and t_entrer.DateEntrer='" + termea + "' order by t_entrer.numstock";
                st = new ConnectDataBase().getConnetion().createStatement();
                rs = st.executeQuery(req1);
                while (rs.next()) {
                    row[0] = rs.getObject(1);
                    row[1] = rs.getObject(2);
                    row[2] = rs.getObject(3);
                    row[3] = rs.getObject(4);
                    row[4] = rs.getObject(5);
                    row[5] = rs.getObject(6);
                    dtm.addRow(row);
                }
            } else if (Deux == true && Four==false && Pro==false) {
                String req2 = "Select t_entrer.numstock,t_entrer.DateEntrer,t_entrer.QteEntrer,t_entrer.PrixUnitaire,t_fourn.nomsfour,t_article.design from t_entrer,t_article,t_fourn where t_article.refart=t_entrer.refart and t_fourn.reffour=t_entrer.reffour and t_entrer.DateEntrer between '" + termea + "'and '" + ter + "'order by t_entrer.numstock";
                st = new ConnectDataBase().getConnetion().createStatement();
                rs = st.executeQuery(req2);
                while (rs.next()) {
                    row[0] = rs.getObject(1);
                    row[1] = rs.getObject(2);
                    row[2] = rs.getObject(3);
                    row[3] = rs.getObject(4);
                    row[4] = rs.getObject(5);
                    row[5] = rs.getObject(6);
                    dtm.addRow(row);
                }
            } else if (Inf == true && Four==false && Pro==false) {
                String req3 = "Select t_entrer.numstock,t_entrer.DateEntrer,t_entrer.QteEntrer,t_entrer.PrixUnitaire,t_fourn.nomsfour,t_article.design from t_entrer,t_article,t_fourn where t_article.refart=t_entrer.refart and t_fourn.reffour=t_entrer.reffour and t_entrer.DateEntrer < '" + termea + "' order by t_entrer.numstock";
                st = new ConnectDataBase().getConnetion().createStatement();
                rs = st.executeQuery(req3);
                while (rs.next()) {
                    row[0] = rs.getObject(1);
                    row[1] = rs.getObject(2);
                    row[2] = rs.getObject(3);
                    row[3] = rs.getObject(4);
                    row[4] = rs.getObject(5);
                    row[5] = rs.getObject(6);
                    dtm.addRow(row);
                }
            } else if (sup == true && Four==false && Pro==false) {
                String req5 = "Select t_entrer.numstock,t_entrer.DateEntrer,t_entrer.QteEntrer,t_entrer.PrixUnitaire,t_fourn.nomsfour,t_article.design from t_entrer,t_article,t_fourn where t_article.refart=t_entrer.refart and t_fourn.reffour=t_entrer.reffour and t_entrer.DateEntrer > '" + termea + "' order by t_entrer.numstock";
                st = new ConnectDataBase().getConnetion().createStatement();
                rs = st.executeQuery(req5);
                while (rs.next()) {
                    row[0] = rs.getObject(1);
                    row[1] = rs.getObject(2);
                    row[2] = rs.getObject(3);
                    row[3] = rs.getObject(4);
                    row[4] = rs.getObject(5);
                    row[5] = rs.getObject(6);
                    dtm.addRow(row);
                }
            }else if (Une == true && Four == true && Pro==false) {
                String req6 = "Select t_entrer.numstock,t_entrer.DateEntrer,t_entrer.QteEntrer,t_entrer.PrixUnitaire,t_fourn.nomsfour,t_article.design from t_entrer,t_article,t_fourn where t_article.refart=t_entrer.refart and t_fourn.reffour=t_entrer.reffour and nomsfour='" + NFour + "' and t_entrer.DateEntrer = '" + termea + "' order by t_entrer.numstock";
                st = new ConnectDataBase().getConnetion().createStatement();
                rs = st.executeQuery(req6);
                while (rs.next()) {
                    row[0] = rs.getObject(1);
                    row[1] = rs.getObject(2);
                    row[2] = rs.getObject(3);
                    row[3] = rs.getObject(4);
                    row[4] = rs.getObject(5);
                    row[5] = rs.getObject(6);
                    dtm.addRow(row);
                }
            } else if (Deux == true && Four == true && Pro==false) {
                String req7 = "Select t_entrer.numstock,t_entrer.DateEntrer,t_entrer.QteEntrer,t_entrer.PrixUnitaire,t_fourn.nomsfour,t_article.design from t_entrer,t_article,t_fourn where t_article.refart=t_entrer.refart and t_fourn.reffour=t_entrer.reffour and nomsfour='" + NFour + "' and t_entrer.DateEntrer between '" + termea + "'and '" + ter + "'order by t_entrer.numstock";
                st = new ConnectDataBase().getConnetion().createStatement();
                rs = st.executeQuery(req7);
                while (rs.next()) {
                    row[0] = rs.getObject(1);
                    row[1] = rs.getObject(2);
                    row[2] = rs.getObject(3);
                    row[3] = rs.getObject(4);
                    row[4] = rs.getObject(5);
                    row[5] = rs.getObject(6);
                    dtm.addRow(row);
                }
            } else if (Inf == true && Four == true && Pro==false) {
                String req7 = "Select t_entrer.numstock,t_entrer.DateEntrer,t_entrer.QteEntrer,t_entrer.PrixUnitaire,t_fourn.nomsfour,t_article.design from t_entrer,t_article,t_fourn where t_article.refart=t_entrer.refart and t_fourn.reffour=t_entrer.reffour and nomsfour='" + NFour + "' and t_entrer.DateEntrer < '" + termea + "' order by t_entrer.numstock";
                st = new ConnectDataBase().getConnetion().createStatement();
                rs = st.executeQuery(req7);
                while (rs.next()) {
                    row[0] = rs.getObject(1);
                    row[1] = rs.getObject(2);
                    row[2] = rs.getObject(3);
                    row[3] = rs.getObject(4);
                    row[4] = rs.getObject(5);
                    row[5] = rs.getObject(6);
                    dtm.addRow(row);
                }
            } else if (sup == true && Four == true && Pro==false) {
                String req8 = "Select t_entrer.numstock,t_entrer.DateEntrer,t_entrer.QteEntrer,t_entrer.PrixUnitaire,t_fourn.nomsfour,t_article.design from t_entrer,t_article,t_fourn where t_article.refart=t_entrer.refart and t_fourn.reffour=t_entrer.reffour and nomsfour='" + NFour + "' and t_entrer.DateEntrer > '" + termea + "' order by t_entrer.numstock";
                st = new ConnectDataBase().getConnetion().createStatement();
                rs = st.executeQuery(req8);
                while (rs.next()) {
                    row[0] = rs.getObject(1);
                    row[1] = rs.getObject(2);
                    row[2] = rs.getObject(3);
                    row[3] = rs.getObject(4);
                    row[4] = rs.getObject(5);
                    row[5] = rs.getObject(6);
                    dtm.addRow(row);
                }
            } else if (Une == true && Pro == true && Four==false) {
                String req9 = "Select t_entrer.numstock,t_entrer.DateEntrer,t_entrer.QteEntrer,t_entrer.PrixUnitaire,t_fourn.nomsfour,t_article.design from t_entrer,t_article,t_fourn where t_article.refart=t_entrer.refart and t_fourn.reffour=t_entrer.reffour and t_article.design='" + Nprod + "' and t_entrer.DateEntrer = '" + termea + "' order by t_entrer.numstock";
                st = new ConnectDataBase().getConnetion().createStatement();
                rs = st.executeQuery(req9);
                while (rs.next()) {
                    row[0] = rs.getObject(1);
                    row[1] = rs.getObject(2);
                    row[2] = rs.getObject(3);
                    row[3] = rs.getObject(4);
                    row[4] = rs.getObject(5);
                    row[5] = rs.getObject(6);
                    dtm.addRow(row);
                }
                if(dtm.getRowCount()==0){
                    dtm.setRowCount(0);
                }
            } else if (Deux == true && Pro == true && Four==false) {
                String req10 = "Select t_entrer.numstock,t_entrer.DateEntrer,t_entrer.QteEntrer,t_entrer.PrixUnitaire,t_fourn.nomsfour,t_article.design from t_entrer,t_article,t_fourn where t_article.refart=t_entrer.refart and t_fourn.reffour=t_entrer.reffour and t_article.design='" + Nprod + "' and t_entrer.DateEntrer between '" + termea + "'and '" + ter + "'order by t_entrer.numstock";
                st = new ConnectDataBase().getConnetion().createStatement();
                rs = st.executeQuery(req10);
                while (rs.next()) {
                    row[0] = rs.getObject(1);
                    row[1] = rs.getObject(2);
                    row[2] = rs.getObject(3);
                    row[3] = rs.getObject(4);
                    row[4] = rs.getObject(5);
                    row[5] = rs.getObject(6);
                    dtm.addRow(row);
                }
            } else if (Inf == true && Pro == true && Four==false) {
                String req10 = "Select t_entrer.numstock,t_entrer.DateEntrer,t_entrer.QteEntrer,t_entrer.PrixUnitaire,t_fourn.nomsfour,t_article.design from t_entrer,t_article,t_fourn where t_article.refart=t_entrer.refart and t_fourn.reffour=t_entrer.reffour and t_article.design='" + Nprod + "' and t_entrer.DateEntrer < '" + termea + "' order by t_entrer.numstock";
                st = new ConnectDataBase().getConnetion().createStatement();
                rs = st.executeQuery(req10);
                while (rs.next()) {
                    row[0] = rs.getObject(1);
                    row[1] = rs.getObject(2);
                    row[2] = rs.getObject(3);
                    row[3] = rs.getObject(4);
                    row[4] = rs.getObject(5);
                    row[5] = rs.getObject(6);
                    dtm.addRow(row);
                }
            } else if (sup == true && Pro == true && Four==false) {
                String req11 = "Select t_entrer.numstock,t_entrer.DateEntrer,t_entrer.QteEntrer,t_entrer.PrixUnitaire,t_fourn.nomsfour,t_article.design from t_entrer,t_article,t_fourn where t_article.refart=t_entrer.refart and t_fourn.reffour=t_entrer.reffour and t_article.design='" + Nprod + "' and t_entrer.DateEntrer > '" + termea + "' order by t_entrer.numstock";
                st = new ConnectDataBase().getConnetion().createStatement();
                rs = st.executeQuery(req11);
                while (rs.next()) {
                    row[0] = rs.getObject(1);
                    row[1] = rs.getObject(2);
                    row[2] = rs.getObject(3);
                    row[3] = rs.getObject(4);
                    row[4] = rs.getObject(5);
                    row[5] = rs.getObject(6);
                    dtm.addRow(row);
                }
            }else if (Une == true && Pro == true && Four==true) {
                String req9 = "Select t_entrer.numstock,t_entrer.DateEntrer,t_entrer.QteEntrer,t_entrer.PrixUnitaire,t_fourn.nomsfour,t_article.design from t_entrer,t_article,t_fourn where t_article.refart=t_entrer.refart and t_fourn.reffour=t_entrer.reffour and t_article.design='" + Nprod + "' and t_fourn.nomsfour='" + NFour + "' and t_entrer.DateEntrer = '" + termea + "' order by t_entrer.numstock";
                st = new ConnectDataBase().getConnetion().createStatement();
                rs = st.executeQuery(req9);
                while (rs.next()) {
                    row[0] = rs.getObject(1);
                    row[1] = rs.getObject(2);
                    row[2] = rs.getObject(3);
                    row[3] = rs.getObject(4);
                    row[4] = rs.getObject(5);
                    row[5] = rs.getObject(6);
                    dtm.addRow(row);
                }
                if(dtm.getRowCount()==0){
                    dtm.setRowCount(0);
                }
            } else if (Deux == true && Pro == true && Four==true) {
                String req10 = "Select t_entrer.numstock,t_entrer.DateEntrer,t_entrer.QteEntrer,t_entrer.PrixUnitaire,t_fourn.nomsfour,t_article.design from t_entrer,t_article,t_fourn where t_article.refart=t_entrer.refart and t_fourn.reffour=t_entrer.reffour and t_article.design='" + Nprod + "' and t_fourn.nomsfour='" + NFour + "' and t_entrer.DateEntrer between '" + termea + "'and '" + ter + "'order by t_entrer.numstock";
                st = new ConnectDataBase().getConnetion().createStatement();
                rs = st.executeQuery(req10);
                while (rs.next()) {
                    row[0] = rs.getObject(1);
                    row[1] = rs.getObject(2);
                    row[2] = rs.getObject(3);
                    row[3] = rs.getObject(4);
                    row[4] = rs.getObject(5);
                    row[5] = rs.getObject(6);
                    dtm.addRow(row);
                }
            } else if (Inf == true && Pro == true && Four==true) {
                String req10 = "Select t_entrer.numstock,t_entrer.DateEntrer,t_entrer.QteEntrer,t_entrer.PrixUnitaire,t_fourn.nomsfour,t_article.design from t_entrer,t_article,t_fourn where t_article.refart=t_entrer.refart and t_fourn.reffour=t_entrer.reffour and t_article.design='" + Nprod + "' and t_fourn.nomsfour='" + NFour + "' and t_entrer.DateEntrer < '" + termea + "' order by t_entrer.numstock";
                st = new ConnectDataBase().getConnetion().createStatement();
                rs = st.executeQuery(req10);
                while (rs.next()) {
                    row[0] = rs.getObject(1);
                    row[1] = rs.getObject(2);
                    row[2] = rs.getObject(3);
                    row[3] = rs.getObject(4);
                    row[4] = rs.getObject(5);
                    row[5] = rs.getObject(6);
                    dtm.addRow(row);
                }
            } else if (sup == true && Pro == true && Four==true) {
                String req11 = "Select t_entrer.numstock,t_entrer.DateEntrer,t_entrer.QteEntrer,t_entrer.PrixUnitaire,t_fourn.nomsfour,t_article.design from t_entrer,t_article,t_fourn where t_article.refart=t_entrer.refart and t_fourn.reffour=t_entrer.reffour and t_article.design='" + Nprod + "' and t_fourn.nomsfour='" + NFour + "' and t_entrer.DateEntrer > '" + termea + "' order by t_entrer.numstock";
                st = new ConnectDataBase().getConnetion().createStatement();
                rs = st.executeQuery(req11);
                while (rs.next()) {
                    row[0] = rs.getObject(1);
                    row[1] = rs.getObject(2);
                    row[2] = rs.getObject(3);
                    row[3] = rs.getObject(4);
                    row[4] = rs.getObject(5);
                    row[5] = rs.getObject(6);
                    dtm.addRow(row);
                }
            }
        } catch (SQLException ex) {
            System.out.print(ex);
        }
    }
}
