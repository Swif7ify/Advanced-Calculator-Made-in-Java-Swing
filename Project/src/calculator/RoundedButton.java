package calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.util.HashMap;
import java.util.Map;

public class RoundedButton extends JButton {

    private static final long serialVersionUID = 1L;
    private int cornerRadius;
    private static final Map<String, ColorPair> colorMap = new HashMap<>();
    
    static {
    	Color orange = new Color(245, 155, 121);
    	Color red = new Color(241, 133, 141);
    	Color purple = new Color(133, 110, 167);
    	
    	Color black = new Color(59, 9, 24);
    	Color white = new Color(255, 255, 255);
    	
    	addColors(new ColorPair(orange, black), "DL", "AC", "PM", "FLR", "CEL", "IT", "INTD", "MOD", "FAC", "SQRT", "CBRT", "NMROOT", "SUM", "XY", "XYZ", "PRN", "ZRO", "PRD", "DSUM", "DNOT");
    	addColors(new ColorPair(red, white), "PLUS", "MN", "MUL", "DIV", "EQU");
    	addColors(new ColorPair(purple, white), "SVN", "EHT", "NN", "FR", "FV", "SX", "ON", "TWO", "THR", "ST", "LG2", "LGN", "LG", "A", "B", "C", "D", "a+b", "a/b", "XEY", "x+y", "x^y", "CEX", "x+c", "x^c", "ANS");
    }
    private static void addColors(ColorPair colorPair, String... identifiers) {
        for (String identifier : identifiers) {
        	colorMap.put(identifier, colorPair);
        }
    }
    
    public RoundedButton(String text, int cornerRadius, String identifier) {
        setText(text);
        this.cornerRadius = cornerRadius;
        setFocusPainted(false);
        setOpaque(false); 
        setBorderPainted(false);
        setBorder(null); 
        setFont(new Font("Tahoma", Font.BOLD, 15));
        
        ColorPair colorPair = colorMap.getOrDefault(identifier, new ColorPair(Color.WHITE, Color.BLACK));
        setBackground(colorPair.backgroundColor);
        setForeground(colorPair.foregroundColor);
    }
    
    private static class ColorPair {
    	Color backgroundColor;
    	Color foregroundColor;

    	ColorPair(Color backgroundColor, Color foregroundColor) {
    		this.backgroundColor = backgroundColor;
    		this.foregroundColor = foregroundColor;
    	}
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        if (getModel().isPressed()) {
            g2.setColor(getBackground().darker());
        } else {
            g2.setColor(getBackground()); 
        }
        
        g2.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), cornerRadius, cornerRadius));
        
        Icon icon = getIcon();
        if (icon != null) {
            int iconX = (getWidth() - icon.getIconWidth()) / 2;
            int iconY = (getHeight() - icon.getIconHeight()) / 2;
            icon.paintIcon(this, g2, iconX, iconY);
        }

        String text = getText();
        if (!text.isEmpty()) {
            FontMetrics fm = g2.getFontMetrics();
            int textWidth = fm.stringWidth(text);
            int textHeight = fm.getAscent() - (fm.getAscent() - fm.getDescent()) / 2;
            
            int x = (getWidth() - textWidth) / 2;
            int y = (getHeight() + textHeight) / 2;
            
            g2.setColor(getForeground());
            g2.drawString(text, x, y);
        }

        g2.dispose();
    }
}
