/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import ConnectDataBase.ConnectDataBase;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Pascal_De_Marie
 */
public class ControleurStatStock {

    String article;
    double qte;
    Statement st;
    ResultSet rs;

    public ControleurStatStock(String article, double qte) {

        this.article = article;
        this.qte = qte;

    }
        
}
