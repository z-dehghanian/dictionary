/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package midterm;

import java.awt.Dimension;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 *
 * @author Monireh.S
 */
public class fileChooser extends JFrame{

    JFileChooser chooser;
    String path;
   
    ArrayList<String> paths; 
    public fileChooser() {
        this.paths = new ArrayList<>();
    }

    public String returnPath() {
        
        this.paths = new ArrayList<>();
        chooser = new JFileChooser();
        chooser.setDialogTitle("choose a file");
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            path = "" + chooser.getSelectedFile();
            File f = null;
            String[] paths;
            try {
                int i = 0;
                f = new File(path);
                paths = f.list();
                for (String path : paths) {
                   this.paths.add(path);
                    i++;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("No Selection ");
        }
        return path;
    } 
}
