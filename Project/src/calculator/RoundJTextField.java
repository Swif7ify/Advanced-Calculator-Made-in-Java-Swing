package calculator;

import javax.swing.JTextField;
import java.awt.*;

public class RoundJTextField extends JTextField {
    private static final long serialVersionUID = 1L;
    private Shape shape;

    public RoundJTextField(int size) {
        super(size);
        setOpaque(false); // As we will paint the background
        setBorder(null);  // Remove the border outline
        setColumns(10);
        setBackground(new Color(213, 178, 224));
        
        
        
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(getBackground());
        g.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 15, 15); // Making round corners
        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {
        // Do nothing to avoid drawing any border
    }

    @Override
    public boolean contains(int x, int y) {
        if (shape == null || !shape.getBounds().equals(getBounds())) {
            shape = new java.awt.geom.RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), 15, 15);
        }
        return shape.contains(x, y);
    }
}
