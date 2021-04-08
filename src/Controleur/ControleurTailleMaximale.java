/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import java.awt.Toolkit;

/**
 *
 * @author Pascal_De_Marie
 */
public class ControleurTailleMaximale {

    public int xsize, ysize;

    public void TailleMaximale() {
        Toolkit tk = Toolkit.getDefaultToolkit();
        xsize = (int) tk.getScreenSize().getWidth();
        ysize = (int) tk.getScreenSize().getHeight()-38;
    }
}