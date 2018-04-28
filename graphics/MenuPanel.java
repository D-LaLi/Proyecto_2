
package graphics;

import domain.Images;
import files.ImageFile;
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
    
    private JButton insert_button_btn;
    private JFileChooser fileChooser;
    private ImagePanel imagePanel;
    private MosaicPanel mosaicPanel;
    private JPanel toolBoxPanel;
    private JPanel projectOptionsPanel;
    private JButton saveProject_btn;
    private JButton openProject_btn;
    private JButton createProject_btn;
    private JButton rotateRight_btn;
    private JButton rotateLeft_btn;
    private JButton delete_btn;
    private JButton flipHorizontal_btn;
    private JButton flipVertical_btn;
    
    public MenuPanel() {
    	
    	initComponents();
        setProjectOptionsPanel();
        setToolBoxPanel();
           
        // Se selecciona el color
        Color color = new Color(28,96,119);
        setBackground(color);
        
        // Se define el layout para este panel
        FlowLayout fl = new FlowLayout();
        setLayout(fl);
        
        // Alineamiento de los componentes
        fl.setAlignment(FlowLayout.LEFT);
        
        // Se indica quien escuchará las acciones
        insert_button_btn.addActionListener(this);
        
        add(projectOptionsPanel);
        add(toolBoxPanel);
        
    }//fin constructor
    
    
    //Método que se utiliza para inicializar todos los componentes de la clase
    public void initComponents() {
    	
        
        //Se inicializan otros componentes necesarios
        projectOptionsPanel = new JPanel();
    	toolBoxPanel = new JPanel();
    	fileChooser = new JFileChooser();
        
        // Se inicializa el contenedor de imagenes y mosaico
        imagePanel = new ImagePanel();
        mosaicPanel = new MosaicPanel();
        
        // Se inicializan los botones
        saveProject_btn = new JButton(new ImageIcon("src/icons/save_p.png"));
        openProject_btn = new JButton(new ImageIcon("src/icons/open_p.png"));
        createProject_btn = new JButton(new ImageIcon("src/icons/new_p.png"));
    	insert_button_btn = new JButton(new ImageIcon("src/icons/search_image.png"));
    	rotateRight_btn = new JButton(new ImageIcon("src/icons/rotate_right.png"));
        rotateLeft_btn = new JButton(new ImageIcon("src/icons/rotate_left.png"));
        delete_btn = new JButton(new ImageIcon("src/icons/delete.png"));
        flipHorizontal_btn = new JButton(new ImageIcon("src/icons/flip_horizontal.png"));
        flipVertical_btn = new JButton(new ImageIcon("src/icons/flip_vertical.png")); 
        
        // Se agregan mensajes de indicación a cada botón
        saveProject_btn.setToolTipText("Guardar proyecto");
        openProject_btn.setToolTipText("Abrir proyecto");
        createProject_btn.setToolTipText("Crear nuevo projecto");
        insert_button_btn.setToolTipText("Buscar imagen");
        rotateRight_btn.setToolTipText("Rotar a la derecha");
        rotateLeft_btn.setToolTipText("Rotar a la izquierda");
        delete_btn.setToolTipText("Borrar");
        flipHorizontal_btn.setToolTipText("Voltear horizontalmente");
        flipVertical_btn.setToolTipText("Voltear verticalmente");
        
        // Posible configuración futura para botones(No borrar)
        /*createProject_btn.setOpaque(true);
        createProject_btn.setFocusPainted(false);
        createProject_btn.setBorderPainted(false);
        createProject_btn.setContentAreaFilled(false);
        createProject_btn.setBorder(BorderFactory.createEmptyBorder(0,5,0,5));*/
        
        // Se inicializa JFileChooser y valida que solo pueda cargar imagenes de
        // tipo jpg y png
        fileChooser.setFileFilter(new FileNameExtensionFilter("Imagenes", "jpg", "png"));
        fileChooser.setAcceptAllFileFilterUsed(false);
        
    } //fin initComponents
    
    //Se configura toolBox y se añaden sus componentes
    private void setToolBoxPanel() {
    	
    	Color color = new Color(12, 74, 95);
    	toolBoxPanel.setBackground(color);
    	
    	toolBoxPanel.add(rotateRight_btn);
    	toolBoxPanel.add(rotateLeft_btn);
    	toolBoxPanel.add(flipHorizontal_btn);
    	toolBoxPanel.add(flipVertical_btn);
    	toolBoxPanel.add(delete_btn);	
    }
    
    //Opciones para administrar los proyectos(Crear, Abrir, Guardar)
    private void setProjectOptionsPanel() {
        
        Color color = new Color(12, 74, 95);
    	projectOptionsPanel.setBackground(color);
        
        projectOptionsPanel.add(createProject_btn);
        projectOptionsPanel.add(openProject_btn);
        projectOptionsPanel.add(saveProject_btn);
        projectOptionsPanel.add(insert_button_btn);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        // Se pregunta quienn está ejecutando la acción
        if(e.getSource() == insert_button_btn) {
            int returnVal = fileChooser.showOpenDialog(null);
            
            if(returnVal == JFileChooser.APPROVE_OPTION) {
                ImageFile imageFile = new ImageFile(fileChooser.getSelectedFile().getPath());
                Images miImage = Images.getInstance();
                miImage.setImage(imageFile.loadAnImage());
                               
                // Se revalida el JPanel
                imagePanel.revalidate();
                imagePanel.repaint();     
            }
        }        
    }//fin actionPerformed
    
    //Métodos de acceso
    
    public ImagePanel getImagePanel() {
        return imagePanel;
    }

    public void setImagePanel(ImagePanel ic) {
        this.imagePanel = ic;
    } 

    public MosaicPanel getMosaicPanel() {
        return mosaicPanel;
    }

    public void setMosaicPanel(MosaicPanel mo) {
        this.mosaicPanel = mo;
    }
    
}//fin MenuPanel
