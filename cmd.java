/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package midterm;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JTextField;

/**
 *
 * @author Monireh.S
 */
public class cmd {
/// "" 

    String cmd;
    public ArrayList<String> filesSelected;
    public ArrayList<String> deletedFiles;

    public cmd() {
        this.filesSelected = new ArrayList<>();
        this.deletedFiles = new ArrayList<>();
    }

    private String[] split(String cmd) {

        String[] split = cmd.split(" ");
        return split;

    }

    public String check(String cmd, ArrayList<String> filesInFolder) {
        String m;
        String[] check = split(cmd);

        if (check.length > 1) {
            if (check[0].equals("Search") && check[1].equals("-w")) {
                if (check.length == 2) {
                    return m = "ERROR (missing word)";
                } else {
                    return cmd;
                }
            }
            if (check[0].equals("Search") && check[1].equals("-s")) {
                if (check.length == 2) {
                    return m = "ERROR ";
                } else {
                    return cmd;
                }
            } else if (cmd.equals("list -f")) {
                return cmd;
            } else if (cmd.equals("list -l")) {
                return cmd;
            } else if (cmd.equals("list -w")) {
                return cmd;
            } else if (check[0].equals("update") || check[0].equals("del") || check[0].equals("add")) {
                if (check.length == 1) {
                    return "missing file name";
                } else {
                    if (filesInFolder == null) {
                        return "no files in folder";
                    }
                    return cmd;
                }
            }
        }
        return m = "ERROR (wrong cmd)";

    }

    public void updateFilesSelected() {
        for (int i = 0; i < filesSelected.size(); i++) {
            for (int j = 0; j < deletedFiles.size(); j++) {
                if (deletedFiles.get(j).equals(filesSelected.get(i))) {
                    filesSelected.remove(i);
                }
            }
        }

    }
}
