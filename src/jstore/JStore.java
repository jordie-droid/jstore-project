/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jstore;

import Forms.FrmAcc;
//import Forms.Log;
import javax.swing.UIManager;

/**
 *
 * @author BlackJKL
 */
public class JStore {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            //UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
            //UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
            UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
            //com.jtattoo.plaf.hifi.HiFiLookAndFeel
            //UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            //new Log().setVisible(true);
            new FrmAcc().setVisible(true);
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(FrmAcc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
}
