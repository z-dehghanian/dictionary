/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package midterm;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Monireh.S
 */
public class Help extends JFrame {

    public JLabel cmdHelp, update, add, del, list1,list2,list3, search1,search2, makeTree;

    public Help() {

        setVisible(true);
        setLayout(null);
        setSize(460, 500);
        setLocation(230, 120);
        setResizable(false);
        makeHelp();
    }

    private void makeHelp() {

        cmdHelp = new JLabel("correct form of cmd");
        update = new JLabel("update cmd : update file name");
        add = new JLabel("add cmd : add file name");
        del = new JLabel("del cmd : del file name");
        list1 = new JLabel("list cmds : list -f (show all files in folder) ");
        list2 = new JLabel( " list -w (show all words ) ");
        list3 = new JLabel(" list -l (show all files that are in tree)");
        search1 = new JLabel("search cmds : Search -w word   ");
        search2 = new JLabel("Search -s String ");
        
        makeTree = new JLabel("to make bst tree just click on the bst button (same for tst and bst)");

        cmdHelp.setLocation(30, 20);
        cmdHelp.setSize(200, 20);
        add(cmdHelp);
        update.setLocation(40, 45);
        update.setSize(200, 20);
        add(update);
        add.setLocation(40, 70);
        add.setSize(200, 20);
        add(add);
        del.setLocation(40, 95);
        del.setSize(200, 20);
        add(del);
        list1.setLocation(40, 120);
        list1.setSize(300, 20);
        add(list1);
        list2.setLocation(40, 145);
        list2.setSize(300, 20);
        add(list2);
        list3.setLocation(40, 170);
        list3.setSize(300, 20);
        add(list3);
        search1.setLocation(40, 195);
        search1.setSize(300, 20);
        add(search1);
        search2.setLocation(40, 220);
        search2.setSize(300, 20);
        add(search2);
        
        
        
        getContentPane().setBackground(new Color(32,178,170));
       
        //add(del);
    }

}
