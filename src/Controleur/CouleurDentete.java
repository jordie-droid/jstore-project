/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author BlackJKL
 */
public class CouleurDentete {

    static public class CouleurDentet extends DefaultTableCellRenderer {

        public CouleurDentet() {
            setOpaque(true);
        }

        @Override
        public Component getTableCellRendererComponent(JTable maTable, Object valuer, boolean selectionne, boolean curseur, int ligne, int colonne) {
            super.getTableCellRendererComponent(maTable, valuer, selectionne, curseur, TOP, colonne);
            setBackground(new Color(240, 240, 240));
            return this;
        }
    }
}
