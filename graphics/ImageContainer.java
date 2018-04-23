
package graphics;

import files.ImageFile;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author Albin Hernánndez Rivera | Carné: B68200
 */

//Esta clase representa el panel en el que se cargarÃ¡ la imagen
//que el usuario necesite para trabajar
public class ImageContainer extends JPanel {
    
    private String path;
    
    public ImageContainer() {       
        Color color = new Color(110, 106, 123);
        setBackground(color);         
    }  
    
    
    
    // Implementación del método paintComponent
    @Override
    public void paintComponent(Graphics g) {
        
        super.paintComponent(g);
        
        ImageFile imageFile = new ImageFile(path);
 
        g.drawImage(imageFile.loadAnImage(), 5, 5,  null);  
        
        //g.drawLine(5, 5, 5, 300);
        
    }// fin paintComponent   

    
    // MÃ©todos de acceso
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
    
}
