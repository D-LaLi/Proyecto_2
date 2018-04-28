package graphics;

import domain.Images;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

/**
 *
 * @author Albin Hernández Rivera | Carné: B68200
 */
public class MosaicPanel extends JPanel {

    private int pixels;
    private BufferedImage subImage;
    private int mX,mY; //codenadas donde fue dado el click

    // Constructor
    public MosaicPanel() {
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(500, 500));
        setMaximumSize(new Dimension(500, 500));
        subImage = null;
        //pixels = 600;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Se llama la instancia global de Image y se le configura un tamaño de bloque
        // Esto es temporal como forma de prueba, el tamaño de cada bloque deber ser
        // definido al momento de crear un nuevo proyecto.
        Images myImage = Images.getInstance();

        myImage.setN(50);

        pixels = myImage.getN();
        
        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
               // if(myImage.getSubImage()!=null)
                mX = e.getX() / pixels;
                mY = e.getY() / pixels;
                myImage.listOfMosaicImages(mY, mX);
                revalidate();
                repaint();
            }
        });
        
        if (myImage.getSubImageMosaic() != null) {
            for (int i = 0; i < myImage.getSubImageMosaic().length; i++) {
                for (int j = 0; j < myImage.getSubImageMosaic()[0].length; j++) {
                    g.drawImage(myImage.getSelectedBufered(i, j), j * pixels, i* pixels,this);
                }
            }
        }
        
        // Se dibujan las lineas basado en el tamaño de cada bloque 
        for (int i = 0; i < 600; i += pixels) {
            g.drawLine(0, i, 600, i);
            g.drawLine(i, 0, i, 600);
        }
    }
}
