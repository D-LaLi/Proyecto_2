
package graphics;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Albin Hernández Rivera | Carné: B68200
 *         
 */

public class MenuPanel extends JPanel implements ActionListener {
    
    private JButton insert_button;
    private JFileChooser fileChooser;
    private ImageContainer ic;
    private JPanel toolBox;
    private JButton rotateRight;
    private JButton rotateLeft;
    private JButton delete;
    private JButton flipHorizontal;
    private JButton flipVertical;
    
    public MenuPanel() {
    	
    	initComponents();
           
        // Se inicializa el contenedor de imagenes
        ic = new ImageContainer();
        
        
        // Se selecciona el color
        Color color = new Color(28,96,119);
        setBackground(color);
        
        // Se define el layout para este panel
        FlowLayout fl = new FlowLayout();
        setLayout(fl);
        
        // Alineamiento de los componentes
        fl.setAlignment(FlowLayout.LEFT);
        
        // Se indica quien escuchará las acciones
        insert_button.addActionListener(this);
        
        setToolBoxPanel();
        
        add(insert_button);
        add(toolBox);
    }//fin constructor
    
    
    public void initComponents() {
    	
    	toolBox = new JPanel();
    	fileChooser = new JFileChooser();
    	insert_button = new JButton(new ImageIcon("src/icons/add_image.png"));
    	rotateRight = new JButton(new ImageIcon("src/icons/rotate_right.png"));
        rotateLeft = new JButton(new ImageIcon("src/icons/rotate_left.png"));
        delete = new JButton(new ImageIcon("src/icons/delete.png"));
        flipHorizontal = new JButton(new ImageIcon("src/icons/flip_horizontal.png"));
        flipVertical = new JButton(new ImageIcon("src/icons/flip_vertical.png")); 
        
        // Se agregan mensajes de indicaci�n a cada boton
        insert_button.setToolTipText("Insertar imagen");
        rotateRight.setToolTipText("Rotar a la derecha");
        rotateLeft.setToolTipText("Rotar a la izquierda");
        delete.setToolTipText("Borrar");
        flipHorizontal.setToolTipText("Voltear horizontalmente");
        flipVertical.setToolTipText("Voltear verticalmente");
        
        // Se inicializa JFileChooser y valida que solo pueda cargar imagenes de
        // tipo jpg y png
        fileChooser.setFileFilter(new FileNameExtensionFilter("Imagenes", "jpg", "png"));
        fileChooser.setAcceptAllFileFilterUsed(false);
    }
    
    //Se configura toolBox y se a�aden sus componentes
    private void setToolBoxPanel() {
    	
    	Color color = new Color(12, 74, 95);
    	toolBox.setBackground(color);
    	
    	toolBox.add(rotateRight);
    	toolBox.add(rotateLeft);
    	toolBox.add(flipHorizontal);
    	toolBox.add(flipVertical);
    	toolBox.add(delete);	
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        
        // Se pregunta quienn est� ejecutando la acci�n
        if(e.getSource() == insert_button) {
            int returnVal = fileChooser.showOpenDialog(new MainPanel());
            
            if(returnVal == JFileChooser.APPROVE_OPTION){
                ic.setPath(fileChooser.getSelectedFile().getPath());
                
                // Se revalida el JPanel
                ic.revalidate();
                ic.repaint();     
            }
        }        
    }//fin actionPerformed
    
    //M�todos de acceso
    public ImageContainer getIc() {
        return ic;
    }

    public void setIc(ImageContainer ic) {
        this.ic = ic;
    } 
    
}//fin MenuPanel
