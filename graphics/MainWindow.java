
package graphics;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Albin Hernández Rivera | Carnet: B68200
 *         
 */

/*
* Esta clase define el comportamiento de la ventana  principal
* en la cual iran todos lo componentes de la aplicacion.
*/
public class MainWindow extends JFrame {
    
    private final int SCREEN_WIDTH;
    private final int SCREEN_HEIGHT;
    private RootPanel root;
    
    //Constructor
    public MainWindow() {
        
        // Se define como se comporta el momento de cerrar la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //se captura el dispositivo de salida(monitor)
        Toolkit myScreen = Toolkit.getDefaultToolkit();
        
        //se captura la dimensión de la pantalla
        Dimension screenSize = myScreen.getScreenSize();
        
        SCREEN_WIDTH = screenSize.width;
        SCREEN_HEIGHT = screenSize.height;
        
        //se definen las dimensiones de la ventana de esta aplicación
        setSize(((SCREEN_WIDTH/2) + 200), (SCREEN_HEIGHT/2) + 200);
        
        //se define la posición de la aplicación en la pantalla
        setLocation(SCREEN_WIDTH/4 - 100, (SCREEN_HEIGHT/4) - 100);
        
        //se define un icono que represente la aplicación
        Image myIcon = myScreen.getImage("palette.png");
        setIconImage(myIcon);
        
        root = new RootPanel();
        
        //se carga el panel principal
        add(root);
        
        setVisible(true);
        
    }//fin constructor   
    
}
