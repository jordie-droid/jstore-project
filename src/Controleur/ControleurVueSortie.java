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
public class ControleurVueSortie {

    private Statement st;
    private String termea;
    private String ter, NClie, Nprod;
    boolean Une, Deux, Inf, sup, Cli, Pro;
    private DefaultTableModel dtm;
    private ResultSet rs;

    public ControleurVueSortie(String terme, String tera, boolean Une, boolean Deux, boolean Inf, boolean sup, boolean Four, boolean Pro, String NClie, String NPro) {
        termea = terme;
        ter = tera;
        this.Une = Une;
        this.Deux = Deux;
        this.Inf = Inf;
        this.sup = sup;
        this.Cli = Four;
        this.Pro = Pro;
        this.NClie = NClie;
        this.Nprod = NPro;
    }

    public DefaultTableModel getDtm() {
        return dtm;
    }
    
    public void detDtm() {
        dtm.setRowCount(0);
    }

    public void remplirTableau() {
        String entete[] = {"Numéro", "Date", "Quantité", "Prix unitaire", "Numéro commande", "Numéro facture", "Client", "Article"};
        dtm = new DefaultTableModel(null, entete);
        Object row[] = new Object[8];
        String req = "select t_sortie.RowNum,t_sortie.DateSortie,t_sortie.QteSortie,t_sortie.PrixUnitaire,t_sortie.Numcom,t_sortie.NumFacture,t_client.nomscli,t_article.design from t_sortie,t_article,t_client where t_article.refart=t_sortie.refart and t_client.refcli=t_sortie.refcli order by t_sortie.RowNum asc";
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
                row[6] = rs.getObject(7);
                row[7] = rs.getObject(8);
                dtm.addRow(row);
            }
        } catch (SQLException ex) {
            System.out.print(ex);
        }
    }

    public void Rechercher() {
        String entete[] = {"Numéro", "Date", "Quantité", "Prix unitaire", "Numéro commande", "Numéro facture", "Client", "Article"};
        dtm = new DefaultTableModel(null, entete);
        Object row[] = new Object[8];
        try {
            dtm = new DefaultTableModel(null, entete);
            String req1 = "select t_sortie.RowNum,t_sortie.DateSortie,t_sortie.QteSortie,t_sortie.PrixUnitaire,t_sortie.Numcom,t_sortie.NumFacture,t_client.nomscli,t_article.design from t_sortie,t_article,t_client where t_article.refart=t_sortie.refart and t_client.refcli=t_sortie.refcli and t_sortie.DateSortie = '" + termea + "' order by t_sortie.NumFacture";
            if (Une == true && Cli == false && Pro == false) {
                st = new ConnectDataBase().getConnetion().createStatement();
                rs = st.executeQuery(req1);
                while (rs.next()) {
                    row[0] = rs.getObject(1);
                    row[1] = rs.getObject(2);
                    row[2] = rs.getObject(3);
                    row[3] = rs.getObject(4);
                    row[4] = rs.getObject(5);
                    row[5] = rs.getObject(6);
                    row[6] = rs.getObject(7);
                    row[7] = rs.getObject(8);
                    dtm.addRow(row);
                }
            } else if (Deux == true && Cli == false && Pro == false) {
                String req = "select t_sortie.RowNum,t_sortie.DateSortie,t_sortie.QteSortie,t_sortie.PrixUnitaire,t_sortie.Numcom,t_sortie.NumFacture,t_client.nomscli,t_article.design from t_sortie,t_article,t_client where t_article.refart=t_sortie.refart and t_client.refcli=t_sortie.refcli and t_sortie.DateSortie between '" + termea + "' and '" + ter + "' order by t_sortie.RowNum asc";
                st = new ConnectDataBase().getConnetion().createStatement();
                rs = st.executeQuery(req);
                while (rs.next()) {
                    row[0] = rs.getObject(1);
                    row[1] = rs.getObject(2);
                    row[2] = rs.getObject(3);
                    row[3] = rs.getObject(4);
                    row[4] = rs.getObject(5);
                    row[5] = rs.getObject(6);
                    row[6] = rs.getObject(7);
                    row[7] = rs.getObject(8);
                    dtm.addRow(row);
                }
            } else if (Inf == true && Cli == false && Pro == false) {
                String req3 = "select t_sortie.RowNum,t_sortie.DateSortie,t_sortie.QteSortie,t_sortie.PrixUnitaire,t_sortie.Numcom,t_sortie.NumFacture,t_client.nomscli,t_article.design from t_sortie,t_article,t_client where t_article.refart=t_sortie.refart and t_client.refcli=t_sortie.refcli and t_sortie.DateSortie < '" + termea + "' order by t_sortie.NumFacture";
                st = new ConnectDataBase().getConnetion().createStatement();
                rs = st.executeQuery(req3);
                while (rs.next()) {
                    row[0] = rs.getObject(1);
                    row[1] = rs.getObject(2);
                    row[2] = rs.getObject(3);
                    row[3] = rs.getObject(4);
                    row[4] = rs.getObject(5);
                    row[5] = rs.getObject(6);
                    row[6] = rs.getObject(7);
                    row[7] = rs.getObject(8);
                    dtm.addRow(row);
                }
            } else if (sup == true && Cli == false && Pro == false) {
                String req3 = "select t_sortie.RowNum,t_sortie.DateSortie,t_sortie.QteSortie,t_sortie.PrixUnitaire,t_sortie.Numcom,t_sortie.NumFacture,t_client.nomscli,t_article.design from t_sortie,t_article,t_client where t_article.refart=t_sortie.refart and t_client.refcli=t_sortie.refcli and t_sortie.DateSortie > '" + termea + "' order by t_sortie.NumFacture";
                st = new ConnectDataBase().getConnetion().createStatement();
                rs = st.executeQuery(req3);
                while (rs.next()) {
                    row[0] = rs.getObject(1);
                    row[1] = rs.getObject(2);
                    row[2] = rs.getObject(3);
                    row[3] = rs.getObject(4);
                    row[4] = rs.getObject(5);
                    row[5] = rs.getObject(6);
                    row[6] = rs.getObject(7);
                    row[7] = rs.getObject(8);
                    dtm.addRow(row);
                }
            } else if (Une == true && Pro == true && Cli == false) {
                String req3 = "select t_sortie.RowNum,t_sortie.DateSortie,t_sortie.QteSortie,t_sortie.PrixUnitaire,t_sortie.Numcom,t_sortie.NumFacture,t_client.nomscli,t_article.design from t_sortie,t_article,t_client where t_article.refart=t_sortie.refart and t_client.refcli=t_sortie.refcli and t_article.design='" + Nprod + "' and t_sortie.DateSortie = '" + termea + "' order by t_sortie.NumFacture";
                st = new ConnectDataBase().getConnetion().createStatement();
                rs = st.executeQuery(req3);
                while (rs.next()) {
                    row[0] = rs.getObject(1);
                    row[1] = rs.getObject(2);
                    row[2] = rs.getObject(3);
                    row[3] = rs.getObject(4);
                    row[4] = rs.getObject(5);
                    row[5] = rs.getObject(6);
                    row[6] = rs.getObject(7);
                    row[7] = rs.getObject(8);
                    dtm.addRow(row);
                }
            } else if (Deux == true && Pro == true && Cli == false) {
                String req3 = "select t_sortie.RowNum,t_sortie.DateSortie,t_sortie.QteSortie,t_sortie.PrixUnitaire,t_sortie.Numcom,t_sortie.NumFacture,t_client.nomscli,t_article.design from t_sortie,t_article,t_client where t_article.refart=t_sortie.refart and t_client.refcli=t_sortie.refcli and t_article.design='" + Nprod + "' and t_sortie.DateSortie between '" + termea + "' and '" + ter + "' order by t_sortie.NumFacture";
                st = new ConnectDataBase().getConnetion().createStatement();
                rs = st.executeQuery(req3);
                while (rs.next()) {
                    row[0] = rs.getObject(1);
                    row[1] = rs.getObject(2);
                    row[2] = rs.getObject(3);
                    row[3] = rs.getObject(4);
                    row[4] = rs.getObject(5);
                    row[5] = rs.getObject(6);
                    row[6] = rs.getObject(7);
                    row[7] = rs.getObject(8);
                    dtm.addRow(row);
                }
            } else if (sup == true && Pro == true && Cli == false) {
                String req3 = "select t_sortie.RowNum,t_sortie.DateSortie,t_sortie.QteSortie,t_sortie.PrixUnitaire,t_sortie.Numcom,t_sortie.NumFacture,t_client.nomscli,t_article.design from t_sortie,t_article,t_client where t_article.refart=t_sortie.refart and t_client.refcli=t_sortie.refcli and t_article.design='" + Nprod + "' and t_sortie.DateSortie > '" + termea + "' order by t_sortie.NumFacture";
                st = new ConnectDataBase().getConnetion().createStatement();
                rs = st.executeQuery(req3);
                while (rs.next()) {
                    row[0] = rs.getObject(1);
                    row[1] = rs.getObject(2);
                    row[2] = rs.getObject(3);
                    row[3] = rs.getObject(4);
                    row[4] = rs.getObject(5);
                    row[5] = rs.getObject(6);
                    row[6] = rs.getObject(7);
                    row[7] = rs.getObject(8);
                    dtm.addRow(row);
                }
            } else if (Inf == true && Pro == true && Cli == false) {
                String req3 = "select t_sortie.RowNum,t_sortie.DateSortie,t_sortie.QteSortie,t_sortie.PrixUnitaire,t_sortie.Numcom,t_sortie.NumFacture,t_client.nomscli,t_article.design from t_sortie,t_article,t_client where t_article.refart=t_sortie.refart and t_client.refcli=t_sortie.refcli and t_article.design='" + Nprod + "' and t_sortie.DateSortie < '" + termea + "' order by t_sortie.NumFacture";
                st = new ConnectDataBase().getConnetion().createStatement();
                rs = st.executeQuery(req3);
                while (rs.next()) {
                    row[0] = rs.getObject(1);
                    row[1] = rs.getObject(2);
                    row[2] = rs.getObject(3);
                    row[3] = rs.getObject(4);
                    row[4] = rs.getObject(5);
                    row[5] = rs.getObject(6);
                    row[6] = rs.getObject(7);
                    row[7] = rs.getObject(8);
                    dtm.addRow(row);
                }
            } else if (Une == true && Pro == true && Cli == true) {
                String req3 = "select t_sortie.RowNum,t_sortie.DateSortie,t_sortie.QteSortie,t_sortie.PrixUnitaire,t_sortie.Numcom,t_sortie.NumFacture,t_client.nomscli,t_article.design from t_sortie,t_article,t_client where t_article.refart=t_sortie.refart and t_client.refcli=t_sortie.refcli and t_article.design='" + Nprod + "' and t_client.nomscli='" + NClie + "' and t_sortie.DateSortie = '" + termea + "' order by t_sortie.NumFacture";
                st = new ConnectDataBase().getConnetion().createStatement();
                rs = st.executeQuery(req3);
                while (rs.next()) {
                    row[0] = rs.getObject(1);
                    row[1] = rs.getObject(2);
                    row[2] = rs.getObject(3);
                    row[3] = rs.getObject(4);
                    row[4] = rs.getObject(5);
                    row[5] = rs.getObject(6);
                    row[6] = rs.getObject(7);
                    row[7] = rs.getObject(8);
                    dtm.addRow(row);
                }
            } else if (Deux == true && Pro == true && Cli == true) {
                String req3 = "select t_sortie.RowNum,t_sortie.DateSortie,t_sortie.QteSortie,t_sortie.PrixUnitaire,t_sortie.Numcom,t_sortie.NumFacture,t_client.nomscli,t_article.design from t_sortie,t_article,t_client where t_article.refart=t_sortie.refart and t_client.refcli=t_sortie.refcli and t_article.design='" + Nprod + "' and t_client.nomscli='" + NClie + "' and t_sortie.DateSortie between '" + termea + "' and '" + ter + "' order by t_sortie.NumFacture";
                st = new ConnectDataBase().getConnetion().createStatement();
                rs = st.executeQuery(req3);
                while (rs.next()) {
                    row[0] = rs.getObject(1);
                    row[1] = rs.getObject(2);
                    row[2] = rs.getObject(3);
                    row[3] = rs.getObject(4);
                    row[4] = rs.getObject(5);
                    row[5] = rs.getObject(6);
                    row[6] = rs.getObject(7);
                    row[7] = rs.getObject(8);
                    dtm.addRow(row);
                }
            } else if (sup == true && Pro == true && Cli == true) {
                String req3 = "select t_sortie.RowNum,t_sortie.DateSortie,t_sortie.QteSortie,t_sortie.PrixUnitaire,t_sortie.Numcom,t_sortie.NumFacture,t_client.nomscli,t_article.design from t_sortie,t_article,t_client where t_article.refart=t_sortie.refart and t_client.refcli=t_sortie.refcli and t_article.design='" + Nprod + "' and t_client.nomscli='" + NClie + "' and t_sortie.DateSortie > '" + termea + "' order by t_sortie.NumFacture";
                st = new ConnectDataBase().getConnetion().createStatement();
                rs = st.executeQuery(req3);
                while (rs.next()) {
                    row[0] = rs.getObject(1);
                    row[1] = rs.getObject(2);
                    row[2] = rs.getObject(3);
                    row[3] = rs.getObject(4);
                    row[4] = rs.getObject(5);
                    row[5] = rs.getObject(6);
                    row[6] = rs.getObject(7);
                    row[7] = rs.getObject(8);
                    dtm.addRow(row);
                }
            } else if (Inf == true && Pro == true && Cli == true) {
                String req3 = "select t_sortie.RowNum,t_sortie.DateSortie,t_sortie.QteSortie,t_sortie.PrixUnitaire,t_sortie.Numcom,t_sortie.NumFacture,t_client.nomscli,t_article.design from t_sortie,t_article,t_client where t_article.refart=t_sortie.refart and t_client.refcli=t_sortie.refcli and t_article.design='" + Nprod + "' and t_client.nomscli='" + NClie + "' and t_sortie.DateSortie < '" + termea + "' order by t_sortie.NumFacture";
                st = new ConnectDataBase().getConnetion().createStatement();
                rs = st.executeQuery(req3);
                while (rs.next()) {
                    row[0] = rs.getObject(1);
                    row[1] = rs.getObject(2);
                    row[2] = rs.getObject(3);
                    row[3] = rs.getObject(4);
                    row[4] = rs.getObject(5);
                    row[5] = rs.getObject(6);
                    row[6] = rs.getObject(7);
                    row[7] = rs.getObject(8);
                    dtm.addRow(row);
                }
            }else if (Une == true && Pro == false && Cli == true) {
                String req3 = "select t_sortie.RowNum,t_sortie.DateSortie,t_sortie.QteSortie,t_sortie.PrixUnitaire,t_sortie.Numcom,t_sortie.NumFacture,t_client.nomscli,t_article.design from t_sortie,t_article,t_client where t_article.refart=t_sortie.refart and t_client.refcli=t_sortie.refcli and t_client.nomscli='" + NClie + "' and t_sortie.DateSortie = '" + termea + "' order by t_sortie.NumFacture";
                st = new ConnectDataBase().getConnetion().createStatement();
                rs = st.executeQuery(req3);
                while (rs.next()) {
                    row[0] = rs.getObject(1);
                    row[1] = rs.getObject(2);
                    row[2] = rs.getObject(3);
                    row[3] = rs.getObject(4);
                    row[4] = rs.getObject(5);
                    row[5] = rs.getObject(6);
                    row[6] = rs.getObject(7);
                    row[7] = rs.getObject(8);
                    dtm.addRow(row);
                }
            } else if (Deux == true && Pro == false && Cli == true) {
                String req3 = "select t_sortie.RowNum,t_sortie.DateSortie,t_sortie.QteSortie,t_sortie.PrixUnitaire,t_sortie.Numcom,t_sortie.NumFacture,t_client.nomscli,t_article.design from t_sortie,t_article,t_client where t_article.refart=t_sortie.refart and t_client.refcli=t_sortie.refcli and t_client.nomscli='" + NClie + "' and t_sortie.DateSortie between '" + termea + "' and '" + ter + "' order by t_sortie.NumFacture";
                st = new ConnectDataBase().getConnetion().createStatement();
                rs = st.executeQuery(req3);
                while (rs.next()) {
                    row[0] = rs.getObject(1);
                    row[1] = rs.getObject(2);
                    row[2] = rs.getObject(3);
                    row[3] = rs.getObject(4);
                    row[4] = rs.getObject(5);
                    row[5] = rs.getObject(6);
                    row[6] = rs.getObject(7);
                    row[7] = rs.getObject(8);
                    dtm.addRow(row);
                }
            } else if (sup == true && Pro == false && Cli == true) {
                String req3 = "select t_sortie.RowNum,t_sortie.DateSortie,t_sortie.QteSortie,t_sortie.PrixUnitaire,t_sortie.Numcom,t_sortie.NumFacture,t_client.nomscli,t_article.design from t_sortie,t_article,t_client where t_article.refart=t_sortie.refart and t_client.refcli=t_sortie.refcli and t_client.nomscli='" + NClie + "' and t_sortie.DateSortie > '" + termea + "' order by t_sortie.NumFacture";
                st = new ConnectDataBase().getConnetion().createStatement();
                rs = st.executeQuery(req3);
                while (rs.next()) {
                    row[0] = rs.getObject(1);
                    row[1] = rs.getObject(2);
                    row[2] = rs.getObject(3);
                    row[3] = rs.getObject(4);
                    row[4] = rs.getObject(5);
                    row[5] = rs.getObject(6);
                    row[6] = rs.getObject(7);
                    row[7] = rs.getObject(8);
                    dtm.addRow(row);
                }
            } else if (Inf == true && Pro == false && Cli == true) {
                String req3 = "select t_sortie.RowNum,t_sortie.DateSortie,t_sortie.QteSortie,t_sortie.PrixUnitaire,t_sortie.Numcom,t_sortie.NumFacture,t_client.nomscli,t_article.design from t_sortie,t_article,t_client where t_article.refart=t_sortie.refart and t_client.refcli=t_sortie.refcli and t_client.nomscli='" + NClie + "' and t_sortie.DateSortie < '" + termea + "' order by t_sortie.NumFacture";
                st = new ConnectDataBase().getConnetion().createStatement();
                rs = st.executeQuery(req3);
                while (rs.next()) {
                    row[0] = rs.getObject(1);
                    row[1] = rs.getObject(2);
                    row[2] = rs.getObject(3);
                    row[3] = rs.getObject(4);
                    row[4] = rs.getObject(5);
                    row[5] = rs.getObject(6);
                    row[6] = rs.getObject(7);
                    row[7] = rs.getObject(8);
                    dtm.addRow(row);
                }
            }
        } catch (SQLException ex) {
            System.out.print(ex);
        }
    }
}
