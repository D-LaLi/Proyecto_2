
package graphics;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;

/**
 *
 * @author Albin Hernández Rivera | Carnet: B68200
 *         
 */
public class RootPanel extends JPanel {
    
    private MenuPanel menuPanel;

    public RootPanel() {       
        
        // Se define el layout para este panel
        setLayout(new BorderLayout());
        
        menuPanel = new MenuPanel();
        
        // Se añade la barra del menu principal
        add(menuPanel, BorderLayout.PAGE_START);
        
        // Se instancia el contenedor de imagenes
        ImageContainer ic = menuPanel.getIc();
        
        add(ic,  BorderLayout.CENTER);     
    }
    
}
