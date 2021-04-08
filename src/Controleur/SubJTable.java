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
 * @author Pascal_De_Marie
 */
public class SubJTable extends DefaultTableCellRenderer {

    Component component;

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        //table.getTableHeader().setDefaultRenderer(new CouleurDentet());
        setForeground(new Color(0, 0, 0));
        if (row % 2 == 0) {
            component.setBackground(new Color(255, 255, 255));
        } else {
            component.setBackground(new Color(0, 153, 204));
        }
        if (isSelected) {
            component.setBackground(new Color(204, 204, 204));
        }
        return component;
    }
}
