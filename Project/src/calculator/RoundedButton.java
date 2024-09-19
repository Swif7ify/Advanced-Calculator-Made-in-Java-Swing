package calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class RoundedButton extends JButton {

    private static final long serialVersionUID = 1L;
    private int cornerRadius;  // Field to store the corner radius

    // Constructor with text and roundness
    public RoundedButton(String text, int cornerRadius) {
        setText(text);
        this.cornerRadius = cornerRadius;
        setFocusPainted(false); // Remove focus border
        // Remove the default button filling
        setOpaque(false); // Make the button transparent for custom painting
        setBorderPainted(false); // Remove border painting
        setBorder(null); // Make the button transparent for the custom painting
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        
        // Enable anti-aliasing for smoother edges
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        if (getModel().isPressed()) {
            g2.setColor(getBackground().darker());  // Darker background when pressed
        } else {
            g2.setColor(getBackground());  // Normal background when not pressed
        }
        
        // Draw the rounded button background
        g2.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), cornerRadius, cornerRadius));
        
        // If there's an icon, we draw it
        Icon icon = getIcon();
        if (icon != null) {
            int iconX = (getWidth() - icon.getIconWidth()) / 2;
            int iconY = (getHeight() - icon.getIconHeight()) / 2;
            icon.paintIcon(this, g2, iconX, iconY);
        }

        // Draw the text (if not empty)
        String text = getText();
        if (!text.isEmpty()) {
            FontMetrics fm = g2.getFontMetrics();
            int textWidth = fm.stringWidth(text);
            int textHeight = fm.getAscent() - (fm.getAscent() - fm.getDescent()) / 2;
            
            // Center the text horizontally and vertically
            int x = (getWidth() - textWidth) / 2;
            int y = (getHeight() + textHeight) / 2;
            
            // Set text color and draw the text
            g2.setColor(getForeground());
            g2.drawString(text, x, y);
        }

        g2.dispose(); // Dispose of the graphics object
    }
}
