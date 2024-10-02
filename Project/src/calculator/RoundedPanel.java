// RoundedPanel.java
package calculator;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;

public class RoundedPanel extends JPanel {

    private static final long serialVersionUID = 1L;
    private int cornerRadius;  // Add a variable for the corner radius

    // Constructor with color and roundness
    public RoundedPanel(int cornerRadius) {
        this.cornerRadius = cornerRadius;
		setBackground(new Color(213, 178, 224));
        setBounds(28, 36, 718, 136);
        setOpaque(false); // Make the panel transparent for custom painting
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        
        // Enable anti-aliasing for smoother edges
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        // Set background color and draw the rounded panel
        g2.setColor(getBackground());
        g2.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), cornerRadius, cornerRadius));
        
        super.paintComponent(g);
    }
}
