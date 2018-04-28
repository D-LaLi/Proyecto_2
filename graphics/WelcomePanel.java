/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics;


import java.util.TimerTask;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author user
 */
public class WelcomePanel extends JPanel{
     private JLabel image;
     private static int cont = 0;

    public WelcomePanel() {
        int speed = 2;
        int mil = speed*1000;
        Timer time;
        TimerTask timeTask;
        
        
        timeTask = new TimerTask() {
            @Override
            public void run() {
                Icon icon;
                
                switch(cont){
                    case 0:
                        cont =1;
                        icon = new ImageIcon(getClass().getResource("/icons/1.jpg"));
                        image.setIcon(icon);
                        break;
                        
                    case 1:
                        cont =2;
                        icon = new ImageIcon(getClass().getResource("/icons/2.jpg"));
                        image.setIcon(icon);
                        break;
                        
                    case 2:
                        cont =0;
                        icon = new ImageIcon(getClass().getResource("/icons/3.jpg"));
                        image.setIcon(icon);
                        break;
                
                }//fin swicht
            }
        };
        
        //time = new Timer(mil, al);
        
    }
     
     
    
}
