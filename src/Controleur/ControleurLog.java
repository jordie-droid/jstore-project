/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import ConnectDataBase.ConnectDataBase;
import Forms.Log;
import Forms.Menu;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;

/**
 *
 * @author Pascal_De_Marie
 */
public class ControleurLog {

    String type;
    String Noms;
    String Pass;
    Statement st;
    ResultSet rs;
    int i;
    private int mois;
    private int annee;
    private int jour;
    private int seconde;
    private int minute;
    private int heure;

    public ControleurLog(String type, String Noms, String Pass) {
        this.type = type;
        this.Noms = Noms;
        this.Pass = Pass;
        dateheure();
    }
    //renvois de resultat

    public String getType() {
        return type;
    }

    public String getNoms() {
        return Noms;
    }

    public String getPass() {
        return Pass;
    }

    public int Numfacture() {
        int numrow = 0;
        try {
            String raqselect = "select max(RowNum) from t_log";
            st = new ConnectDataBase().getConnetion().createStatement();
            rs = st.executeQuery(raqselect);
            if (rs.next()) {
                numrow = 0 + rs.getInt(1);
            }
        } catch (Exception ex) {
            System.out.print(ex);
        }
        return numrow + 1;
    }

    public void dateheure() {
        Thread clock = new Thread() {

            @Override
            public void run() {
                for (;;) {
                    Calendar cal = new GregorianCalendar();
                    mois = cal.get(Calendar.MONTH);
                    annee = cal.get(Calendar.YEAR);
                    jour = cal.get(Calendar.DAY_OF_MONTH);
                    seconde = cal.get(Calendar.SECOND);
                    minute = cal.get(Calendar.MINUTE);
                    heure = cal.get(Calendar.HOUR);
                    try {
                        sleep(1000);
                    } catch (Exception e) {
                    }
                }
            }
        };
        clock.start();
    }

    //log
    public void Log() {
        try {
            switch (getType()) {
                case "Administrateur": {
                    String reqint = "Select * from t_admi where Nomuser='" + getNoms() + "' and Pass='" + getPass() + "'";
                    st = new ConnectDataBase().getConnetion().createStatement();
                    rs = st.executeQuery(reqint);
                    if (rs.next()) {
                        JOptionPane.showMessageDialog(null, "Administrateur identifié.", "JStore : INFORMATION", JOptionPane.INFORMATION_MESSAGE);
                        Menu m=new Menu();
                        m.labus.setText("Utilisateur actuel : "+Noms);
                        m.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "Administrateur non identifié.", "JStore : ERREUR", JOptionPane.ERROR_MESSAGE);
                        type = "";
                        Noms = "";
                        Pass = "";
                    }
                    break;
                }
                case "Simple": {
                    String reqint = "Select * from t_user where Nomuser='" + getNoms() + "' and Pass='" + getPass() + "'";
                    String ref;
                    st = new ConnectDataBase().getConnetion().createStatement();
                    rs = st.executeQuery(reqint);
                    if (rs.next()) {
                        JOptionPane.showMessageDialog(null, "Utilisateur identifié.", "JStore : INFORMATION", JOptionPane.INFORMATION_MESSAGE);
                        ref = rs.getString("Refuser");
                        String sl = "in";
                        st = new ConnectDataBase().getConnetion().createStatement();
                        st.executeUpdate("Insert into t_log values('" + Numfacture() + "','" + ref + "','" + getType() + "','" + annee + "-" + (mois + 1) + "-" + jour + " " + heure + ":" + minute + ":" + seconde + "','" + sl + "')");
                        new Log().setVisible(false);
                        Menu m=new Menu();
                        m.labus.setText("Utilisateur actuel : "+Noms);
                        m.jMenu1.setVisible(false);
                        m.jMenu1.setEnabled(false);
                        m.jMenuItem5.setVisible(false);
                        m.jMenuItem5.setEnabled(false);
                        m.jMenu4.setVisible(false);
                        m.jMenu4.setEnabled(false);
                        m.jMenu5.setVisible(false);
                        m.jMenu5.setEnabled(false);
                        m.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "Uilisateur non identifié.", "JStore : ERREUR", JOptionPane.ERROR_MESSAGE);
                        type = "";
                        Noms = "";
                        Pass = "";
                    }
                    break;
                }
            }
        } catch (SQLException e) {
            System.out.print(e);
        }
    }
}
