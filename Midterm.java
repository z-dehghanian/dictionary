/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package midterm;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import javax.swing.JFrame;
import javax.swing.UIManager;

/**
 *
 * @author Monireh.S
 */
public class Midterm {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {

        
        
        String s = "d.txt";
        String [] s1 = s.split("txt");
        System.out.println(s1[0]);
        
        userInterface frame = new userInterface();
        frame.addWindowListener(
                new WindowAdapter() {
                    public void windowClosing(WindowEvent e) {
                        System.exit(0);
                    }
                }
        );
          try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
            } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
          
        
        frame.setVisible(true);
        frame.setLayout(null);
        frame.setSize(460, 590);
        frame.setLocation(230, 120);
        frame.setResizable(false);
        
    }
   
}
