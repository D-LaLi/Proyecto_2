package graphics;

import domain.Images;
import java.awt.Image;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javax.swing.Box;
import javax.swing.JPanel;

/**
 *
 * @author Albin Hernández Rivera | Carné: B68200
 */
 
// Esta clase representa el panel en el que se cargará la imagen
// que el usuario necesite para trabajar

public class ImagePanel extends JPanel {

    BufferedImage img;

    public ImagePanel() {
		
        Color color = new Color(110, 106, 123);
        setBackground(color);

        setPreferredSize(new Dimension(500, 500));
        setMaximumSize(new Dimension(500, 500));

    }

    
    @Override // Implementación del método paintComponent
    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        // Se dibuja la imagen en el panel
        Images myImage = Images.getInstance();

        int pixels = myImage.getN();

        try {
			// Se dibuja la imagen en el panel
            Image newImage = myImage.getImage().getScaledInstance(500, 500, Image.SCALE_DEFAULT);
            g.drawImage(myImage.getImage(), 0, 0, null);
            myImage.arrayOfImages();
            
            // Se dibujan las lineas sobre la imagen
            for (int i = 0; i < 600; i += pixels) {
                g.drawLine(0, i, 600, i);
                g.drawLine(i, 0, i, 600);
            }

            addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    myImage.copyImage(e.getX(), e.getY());
                }
            });
        } catch (NullPointerException e) {
            
        }
    }// fin paintComponent 

}
