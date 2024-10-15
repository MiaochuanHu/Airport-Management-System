package ui.Ticketing;


import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import model.Flight;
import ui.Ticketing.AFlight;

public class ResultPanel extends JPanel {

    public ResultPanel() {
        BoxLayout layout = new BoxLayout(this, BoxLayout.Y_AXIS);
        this.setLayout(layout);
        setOpaque(false);
    }
    
    // method to iterate over the results from the database
    // construct an EnquiryPanel and add that EnquiryPanel to ourselves
    public void layoutResults(List<Flight> results) {
        for (Flight f : results) {
            AFlight fPanel = new AFlight(f);
            System.out.println(f);
            add(fPanel);
        }
        revalidate();
    }

    @Override
    public void paint(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int width = getWidth();
        int height = getHeight();
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, width, height, 15, 15);
        g2.dispose();
        super.paint(grphcs);
    }
}