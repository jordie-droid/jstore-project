/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import java.awt.*;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;

/**
 *
 * @author Pascal_De_Marie
 */
public class CustomerPanel extends JPanel {

    int value = 0;

    public void UpdateProgress(int Progress) {
        value = Progress;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        this.setOpaque(false);
        //this.setBackground(Color.WHITE);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.translate(this.getWidth() / 2, this.getHeight() / 2);
        g2.rotate(Math.toRadians(270));
        Arc2D.Float arc = new Arc2D.Float(Arc2D.PIE);
        Ellipse2D cercle = new Ellipse2D.Float(0, 0, 65, 65);
        arc.setFrameFromCenter(new Point(0, 0), new Point(70, 70));
        cercle.setFrameFromCenter(new Point(0, 0), new Point(65, 65));
        arc.setAngleStart(1);
        arc.setAngleExtent(-value * 3.6);
        g2.setColor(Color.red);
        g2.draw(arc);
        g2.fill(arc);
        g2.setColor(Color.white);
        g2.draw(cercle);
        g2.fill(cercle);
        g2.setColor(Color.red);
        g2.rotate(Math.toRadians(90));
        g.setFont(new Font("Verdana", Font.PLAIN, 30));
        FontMetrics fm = g2.getFontMetrics();
        Rectangle2D r = fm.getStringBounds(value + "%", g);
        int x = (0 - (int) r.getWidth()) / 2;
        int y = (0 - (int) r.getHeight()) / 2 + fm.getAscent();
        g2.drawString(value + "%", x, y);
    }
}
