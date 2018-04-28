
package graphics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javafx.scene.layout.FlowPane;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Albin Hernández Rivera | Carné: B68200
 *         
 */
public class RootPanel extends JPanel {
    
    private final MenuPanel menuPanel; 
    private ImagePanel imagePanel;
    private MosaicPanel mosaicPanel;
    private JPanel spaceWorkPanel;
    
    //Constructor
    public RootPanel() {
        
        // Layout es null de manera que la forma en que se acomoden los 
        // componentes en el panel sea definina directamente.
        setLayout(new BorderLayout());
        setBackground(Color.darkGray);
        
        //Se agrega menuPanel a este panel
        menuPanel = new MenuPanel();
        add(menuPanel, BorderLayout.PAGE_START);
        
        setSpaceWorkPanel(); 
        
        add(spaceWorkPanel, BorderLayout.CENTER);
        
    }//fin RootPanel
    
    public void setSpaceWorkPanel() {
        
        // Configuración del panel
        spaceWorkPanel = new JPanel();
        spaceWorkPanel.setBackground(Color.darkGray);
        spaceWorkPanel.setLayout(new BoxLayout(spaceWorkPanel, BoxLayout.X_AXIS));
        
        // Se carga el panel desde menuPanel
        imagePanel = menuPanel.getImagePanel();
        
        mosaicPanel = menuPanel.getMosaicPanel();
        
        // Se añaden componentes al panel. Box Funciona como una caja invisible 
        // que permite acomodar convenientemente los componentes dentro del panel
        spaceWorkPanel.add(Box.createRigidArea(new Dimension(150,0)));
        spaceWorkPanel.add(imagePanel);
        spaceWorkPanel.add(Box.createRigidArea(new Dimension(50,0)));
        spaceWorkPanel.add(mosaicPanel);
        //spaceWorkPanel.add(Box.createRigidArea(new Dimension(100,0)));
        
    }
    
}

/*  
    Nota: MenuPanel esta compuesto de ImagePanel y MosaicPanel. RootPanel simplemente
    se utiliza para indicar la posición en donde estos paneles estarán ubicados. 
    Sin embargo, es MenuPanel quien se encarga de cargar los dos paneles y 
    actualizarlos(revalidate(), repaint()) y pasarselos a RootPanel.
*/
