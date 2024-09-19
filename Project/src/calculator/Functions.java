//package calculator;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.image.BufferedImage;
//import java.awt.image.ImageObserver;
//import java.io.File;
//import java.io.IOException;
//import javax.imageio.ImageIO;
//
//public class Functions {
//    public static void main(String[] args) {
//        // Create the button
//        RoundedButton cuberootButton = new RoundedButton("", 50);
//
//        // Load and scale the image with anti-aliasing
//        ImageIcon scaledIcon = createScaledImageIcon("C:\\Users\\earlo\\OneDrive\\Desktop\\Calculator Project\\Project\\Picture\\cuberoot_icon.png", 50, 50);
//        cuberootButton.setIcon(scaledIcon);
//
//        // Set font and add action listener
//        cuberootButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
//        cuberootButton.addActionListener(e -> {
//            // Handle button click
//            JOptionPane.showMessageDialog(null, "Button Clicked");
//        });
//
//        // Example JFrame setup to display the button
//        JFrame frame = new JFrame();
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setLayout(new FlowLayout());
//        frame.add(cuberootButton);
//        frame.pack();
//        frame.setVisible(true);
//    }
//
//    private static ImageIcon createScaledImageIcon(String filePath, int width, int height) {
//        try {
//            BufferedImage originalImage = ImageIO.read(new File(filePath));
//            BufferedImage scaledImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
//            Graphics2D g2d = scaledImage.createGraphics();
//            
//            // Apply anti-aliasing
//            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//            g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
//            
//            // Draw the scaled image
//            g2d.drawImage(originalImage, 0, 0, width, height, null);
//            g2d.dispose();
//            
//            return new ImageIcon(scaledImage);
//        } catch (IOException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//}
