/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui.component;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author limingxia
 */
public class FuncItemBtn extends JButton {

    private float animate;
    private int index;

    public FuncItemBtn(int index) {
        this.index = index;
        setContentAreaFilled(false);
        setForeground(Color.WHITE);
        setHorizontalAlignment(SwingConstants.LEFT);
        // setBounds(0, 0, 200, 40);
        setBackground(new Color(255, 255, 255, 30));
        setBorder(new EmptyBorder(8, 20, 8, 15));
    }

    public float getAnimate() {
        return animate;
    }

    public void setAnimate(float animate) {
        this.animate = animate;
        repaint();
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        double width = getWidth();
        double height = getHeight();
        double x = animate * width - width;
        Area area = new Area(new RoundRectangle2D.Double(x, 0, width, height, height, height));
        area.add(new Area(new Rectangle2D.Double(x, 0, height, height)));
        g2.setColor(getBackground());
        g2.fill(area);
        g2.dispose();

        super.paint(g);
    }

}
