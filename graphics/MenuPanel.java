
package graphics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Albin Hernández Rivera | Carnet: B68200
 *         
 */
public class MenuPanel extends JPanel implements ActionListener {
    
    private final JButton insert_button;
    private final ImageIcon insert_icon;
    private JFileChooser fileChooser;
    private ImageContainer ic;
    
    @SuppressWarnings("LeakingThisInConstructor")
    public MenuPanel() {
        
        //Se inicializa el contenedor de imagenes
        ic = new ImageContainer();
        
        // Se inicializa JFileChooser y valida que solo pueda cargar imagenes de
        // tipo jpg y png
        fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter("Imagenes", "jpg", "png"));
        fileChooser.setAcceptAllFileFilterUsed(false);
        
        // Se selecciona el color
        Color color = new Color(66, 48, 117);
        setBackground(color);
        
        // Se define el layout para este panel
        FlowLayout fl = new FlowLayout();
        setLayout(fl);
        
        // Alineamiento de los componentes
        fl.setAlignment(FlowLayout.LEFT);
        
        // Icono para el insert_button
        insert_icon = new ImageIcon("insert_icon.png");
        
        // Boton para insertar una nueva imagen
        insert_button = new JButton("Insert image");
        
        // Se indica quien escuchará las acciones
        insert_button.addActionListener(this);
        
        add(insert_button);
        
    }//fin constructor

    @Override
    public void actionPerformed(ActionEvent e) {
        
        // Se pregunta quién está ejecutando la acción
        if(e.getSource() == insert_button) {
            int returnVal = fileChooser.showOpenDialog(new RootPanel());
            
            if(returnVal == JFileChooser.APPROVE_OPTION){
                ic.setPath(fileChooser.getSelectedFile().getPath());
                
                // Se actualiza el panel con la imagen cargada
                ic.revalidate();
                ic.repaint();
            }
        }        
    }//fin actionPerformed
    
    //Métodos de acceso
    public ImageContainer getIc() {
        return ic;
    }

    public void setIc(ImageContainer ic) {
        this.ic = ic;
    }      
}
