
package graphics;

import java.awt.BorderLayout;
import javax.swing.JPanel;

/**
 *
 * @author Albin HernÃ¡ndez Rivera | Carné: B68200
 *         
 */
public class MainPanel extends JPanel {
    
    private MenuPanel menuPanel;

    public MainPanel() {       
        
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
