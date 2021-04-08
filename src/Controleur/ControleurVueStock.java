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
public class ControleurVueStock {
    
    Statement st = null;
    ResultSet rs = null;
    DefaultTableModel dtm;
    int yes;
    String termea;
    String ter;

    public ControleurVueStock(String terme) {
        termea = terme;
    }

    public DefaultTableModel getDtm() {
        return dtm;
    }

    public void remplirTableau() {
        String entete[] = {"Article", "Quantité en stock"};
        dtm = new DefaultTableModel(null, entete);
        Object row[] = new Object[2];
        String req = "select t_article.design,t_stock.QteStock from t_article, t_stock where t_stock.refart=t_article.refart";
        try {
            st = new ConnectDataBase().getConnetion().createStatement();
            rs = st.executeQuery(req);
            while (rs.next()) {
                row[0] = rs.getObject(1);
                row[1] = rs.getObject(2);
                dtm.addRow(row);
            }
        } catch (SQLException ex) {
            System.out.print(ex);
        }
    }

    public void Rechercher() {
        String entete[] = {"Article", "Quantité en stock"};
        dtm = new DefaultTableModel(null, entete);
        Object row[] = new Object[2];
        String r="select * from t_article where design='"+termea+"'";
        try {
            st = new ConnectDataBase().getConnetion().createStatement();
            rs = st.executeQuery(r);
            if(rs.next()){                
        String req = "select t_article.design,t_stock.QteStock from t_article, t_stock where t_stock.refart=t_article.refart and t_stock.refart='"+rs.getString("refart")+"'";
            rs=st.executeQuery(req);
            if(rs.next()){
                row[0]=rs.getObject(1);
                row[1]=rs.getObject(2);
                dtm.addRow(row);
            }
            }
        } catch (SQLException ex) {
            System.out.print(ex);
        }}
    }
    

