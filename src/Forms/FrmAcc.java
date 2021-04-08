/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

//import Frames.Accueil;
import ConnectDataBase.ConnectDataBase;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Pascal_De_Marie
 */
public class FrmAcc extends javax.swing.JFrame {

    private Statement st;
    private ResultSet rs;
    private DefaultTableModel dtm;

    /**
     * Creates new form FrmAcc
     */
    public FrmAcc() {
        initComponents();
        //this.getContentPane().setBackground(Color.white);
        //imagePanel1.setImage(new ImageIcon(this.getClass().getResource("/Icons/B1.PNG")).getImage());
        this.setIconImage(new ImageIcon(getClass().getResource("/Icons/viewoptions.png")).getImage());
        setLocationRelativeTo(null);
        info1.setVisible(false);
        info2.setVisible(false);
        info3.setVisible(false);
        info4.setVisible(false);
        info5.setVisible(false);
    }

    /*
     * public void Go() { new Thread(new Runnable() {
     *
     * @Override public void run() { for (int num = 1; num <= 100; num++) {
     * customerPanel1.UpdateProgress(num); customerPanel1.repaint(); if (num ==
     * 5) { jLabel1.setText("Veuillez patienter svp..."); } else if (num == 15)
     * { jLabel1.setText("Chargement des données..."); } else if (num == 30) {
     * jLabel1.setText("Veuillez patienter svp..."); } else if (num == 45) {
     * jLabel1.setText("Ouverture de fichier..."); } else if (num == 60) {
     * jLabel1.setText("Veuillez patienter svp..."); } else if (num == 70) {
     * jLabel1.setText(""); } else if (num == 80) { jLabel1.setText("Ouverture
     * du programme..."); } else if (num == 85) { jLabel1.setText(""); } else if
     * (num == 90) { jLabel1.setText("Ouverture du programme..."); } else if
     * (num == 95) { jLabel1.setText(""); } if (num == 100) { setVisible(false);
     * new Log().show(true); } try { Thread.sleep(100); } catch
     * (InterruptedException ex) {
     * Logger.getLogger(Accueil.class.getName()).log(Level.SEVERE, null, ex); }
     * } } }).start(); }
     */
    public void premierUtilisateur() {
        new Thread(new Runnable() {

            @Override
            public void run() {
                for (int num = 1; num <= 100; num++) {
                    //customerPanel1.UpdateProgress(num);
                    //customerPanel1.repaint();
                    if (num == 5) {
                        jLabel1.setText("Veuillez patienter svp...");
                        info1.setVisible(true);
                    } else if (num == 15) {
                        jLabel1.setText("Chargement des données...");
                        info2.setVisible(true);
                    } else if (num == 30) {
                        jLabel1.setText("Veuillez patienter svp...");
                        info3.setVisible(true);
                    } else if (num == 45) {
                        jLabel1.setText("Ouverture de fichier...");
                        info4.setVisible(true);
                    } else if (num == 60) {
                        jLabel1.setText("Veuillez patienter svp...");
                        info5.setVisible(true);
                    } else if (num == 70) {
                        jLabel1.setText("Ouverture du programme...");
                    } else if (num == 80) {
                        jLabel1.setText("Ouverture du programme...");
                    } else if (num == 85) {
                        jLabel1.setText("");
                    } else if (num == 90) {
                        jLabel1.setText("Ouverture du programme...");
                    } else if (num == 95) {
                        jLabel1.setText("");
                    }
                    if (num == 100) {
                        Object row[] = new Object[1];
                        try {
                            String req = "Select * from t_jstore";
                            st = new ConnectDataBase().getConnetion().createStatement();
                            rs = st.executeQuery(req);
                            while (rs.next()) {
                                row[0] = rs.getObject(1);
                            }
                            if (row[0] == null) {
                                setVisible(false);
                                F_JStorever Ulog = new F_JStorever(new javax.swing.JFrame(), true);
                                Ulog.show();
                            } else {
                                String req1 = "Select * from t_admi";
                                st = new ConnectDataBase().getConnetion().createStatement();
                                rs = st.executeQuery(req1);
                                while (rs.next()) {
                                    row[0] = rs.getObject(1);
                                }
                                if (row[0] == null) {
                                    setVisible(false);
                                    F_admiver Ulog = new F_admiver(new javax.swing.JFrame(), true);
                                    Ulog.show();
                                } else {
                                    setVisible(false);
                                    Log log =new Log();
                                    log.setVisible(true);
                                }
                            }
                        } catch (SQLException ex) {
                            System.out.print(ex);
                        }
                    }
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(FrmAcc.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }).start();
    }

    /*
     * public void Progress() { new Thread(new Runnable() {
     *
     * @Override public void run() { for (int num = 1; num <= 100; num++) {
     * Progress.setValue(num); if (num == 5) { jLabel1.setText("Veuillez
     * patienter svp..."); } else if (num == 15) { jLabel1.setText("Chargement
     * des données..."); } else if (num == 30) { jLabel1.setText("Veuillez
     * patienter svp..."); } else if (num == 45) { jLabel1.setText("Ouverture de
     * fichier..."); } else if (num == 60) { jLabel1.setText("Veuillez patienter
     * svp..."); } else if (num == 70) { jLabel1.setText(""); } else if (num ==
     * 80) { jLabel1.setText("Ouverture du programme..."); } else if (num == 85)
     * { jLabel1.setText(""); } else if (num == 90) { jLabel1.setText("Ouverture
     * du programme..."); } else if (num == 95) { jLabel1.setText(""); } if (num
     * == 100) { setVisible(false); new Log().show(true); } try {
     * Thread.sleep(100); } catch (InterruptedException ex) {
     * Logger.getLogger(FrmAcc.class.getName()).log(Level.SEVERE, null, ex); } }
     * } }).start(); }
     */
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        info1 = new javax.swing.JLabel();
        info3 = new javax.swing.JLabel();
        info4 = new javax.swing.JLabel();
        info5 = new javax.swing.JLabel();
        info2 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        setForeground(new java.awt.Color(0, 102, 153));
        setUndecorated(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N

        info1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        info1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        info1.setText("JStore est un logiciel spécialisé pour la gestion de stock en gerant :");

        info3.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        info3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        info3.setText("le mouvement de sortie ;");

        info4.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        info4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        info4.setText("le mouvement de stock.");

        info5.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        info5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        info5.setText("JStore a pour outil principal la comptabilité générale .");

        info2.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        info2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        info2.setText("le mouvement d'entrée ;");

        jLabel2.setBackground(new java.awt.Color(204, 255, 255));
        jLabel2.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 153));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("JStore: Gestion");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(info5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(info4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(info3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(info2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(info1, javax.swing.GroupLayout.DEFAULT_SIZE, 453, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(32, 32, 32)
                .addComponent(info1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(info2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(info3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(info4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(info5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        //Go();
        premierUtilisateur();// TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmAcc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmAcc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmAcc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmAcc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new FrmAcc().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel info1;
    private javax.swing.JLabel info2;
    private javax.swing.JLabel info3;
    private javax.swing.JLabel info4;
    private javax.swing.JLabel info5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
