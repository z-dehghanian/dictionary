/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package midterm;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Monireh.S
 */
public class userInterface extends JFrame {

    protected JPanel panel1, panel2;
    protected JButton browse, TST, BST, Trie, OK, help3;
    protected JTextField text1, text2, text3;
    protected JTextArea result;
    protected JLabel help1, help2;
    protected JMenuItem help, reset, exit;
    private final fileChooser frame;
    private final cmd cmd1;
    private final Stack stack1, stack2;
    private final JScrollPane scroll;
    ReadFiles readFile;
    boolean tst = false, bst = false, trie = false;
    LinkedList l;
    public ArrayList<String> filesInFolder;
    public ArrayList<String> filesInFolder1;
    public ArrayList<String> filesInTree;
    public ArrayList<String> addedFiles;
    public ArrayList<String> updateFiles;
    public ArrayList<String> deletedFiles;
    public ArrayList<String> all;
    private MakeBST BSTree;
    private MakeTST TSTree;
    private MakeTrie trieTree;

    public userInterface() {
        this.readFile = new ReadFiles();
        this.filesInFolder = new ArrayList<>();
        this.filesInTree = new ArrayList<>();
        this.deletedFiles = new ArrayList<>();
        this.addedFiles = new ArrayList<>();
        this.updateFiles = new ArrayList<>();

        all = new ArrayList<>();
        KeyListener listener = new MyKeyListener();
        addKeyListener(listener);
        setFocusable(true);
        ////////menubar
        JMenuBar myMenu = new JMenuBar();
        JMenu file = new JMenu();

        help = new JMenuItem("help");
        reset = new JMenuItem("reset");
        exit = new JMenuItem("exit");
        file.add(help);
        file.add(reset);
        file.add(exit);
        myMenu.add(file);
        this.setJMenuBar(myMenu);
        /////////
        browse = new JButton("Browse");
        TST = new JButton("TST");
        BST = new JButton("BST");
        Trie = new JButton("Trie");
        OK = new JButton("OK");
        help3 = new JButton("help");
        text1 = new JTextField();
        text2 = new JTextField();
        text3 = new JTextField();
        panel1 = new JPanel();
        panel2 = new JPanel();
        help1 = new JLabel("plz choose your folder");
        help2 = new JLabel("plz write your comment");
        result = new JTextArea();
        scroll = new JScrollPane(result, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        stack1 = new Stack();
        stack2 = new Stack();
        cmd1 = new cmd();
        frame = new fileChooser();
        BSTree = new MakeBST();
        TSTree = new MakeTST();
        trieTree = new MakeTrie();
        l = new LinkedList();
        setComponent();
    }

    public void setComponent() {

        KeyListener listener = new MyKeyListener();
        addKeyListener(listener);
        KeyListener listener1 = new MyKeyListener();
        addKeyListener(listener1);

        getContentPane().setBackground(new Color(0, 102, 102));
        help1.setLocation(30, 20);
        help1.setSize(200, 20);
        text1.setLocation(30, 50);
        text1.setSize(250, 30);
        browse.setLocation(330, 50);
        browse.setSize(80, 30);
        scroll.setLocation(30, 90);
        scroll.setSize(400, 250);
        BST.setLocation(80, 350);
        BST.setSize(80, 30);
        TST.setLocation(300, 350);
        TST.setSize(80, 30);
        Trie.setLocation(190, 350);
        Trie.setSize(80, 30);
        help3.setLocation(320, 475);
        help3.setSize(80, 30);
        help2.setLocation(30, 400);
        help2.setSize(200, 20);
        text2.setLocation(30, 430);
        text2.setSize(250, 30);
        OK.setLocation(320, 430);
        OK.setSize(80, 30);
        result.setEditable(false);
        add(help1);
        add(text1);
        add(browse);
        add(scroll);
        add(BST);
        add(TST);
        add(Trie);
        add(help2);
        add(text2);
        add(OK);
        add(help3);
        add(text3);
        TST.setToolTipText("to make a TST tree press this button");
        BST.setToolTipText("to make a BST tree press this button");
        Trie.setToolTipText("to make a Trie tree press this button");

        browse.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String s = frame.returnPath();
                filesInFolder = frame.paths;
                filesInFolder1 = frame.paths;
                filesInTree = frame.paths;
                text1.setText(s);
            }
        });

        OK.addKeyListener(listener);
        help3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                Help h = new Help();
            }
        });

        OK.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                result.setText("");
                if (!all.isEmpty()) {
                    all.clear();
                }
                String cmd = text2.getText();
                if (cmd.equals("")) {
                    result.setText("Null");
                } else if (filesInFolder.isEmpty()) {
                    result.setText("plz choose a folder");
                } else {

                    String l = cmd1.check(cmd, filesInFolder);
                    result.append(l);
                    result.append("\n");
                    if (cmd.equals(l)) {
                        stack1.push(cmd);
                        printOnResult(l);
                    }
                }
            }
        }
        );

        TST.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e
                    ) {
                        readFile.readFile(false, true, false, text1.getText(), filesInFolder);
                        tst = true;
                        trie = false;
                        bst = false;
                        TSTree = readFile.TSTree;
                    }
                }
        );

        BST.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e
                    ) {
                        readFile.readFile(true, false, false, text1.getText(), filesInFolder);
                        tst = false;
                        trie = false;
                        bst = true;
                        BSTree = readFile.BSTree;
                    }
                }
        );

        Trie.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e
                    ) {
                        readFile.readFile(false, false, true, text1.getText(), filesInFolder);
                        tst = false;
                        trie = true;
                        bst = false;
                        trieTree = readFile.trieTree;
                    }
                }
        );

    }
    /**
     * show the result of user query on text area
     * @param luser command
     */
    private void printOnResult(String l) {
        String[] split = l.split(" ");
        if (l.equals("list -f")) {
            result.setText("");
            for (int i = 0; i < filesInFolder1.size(); i++) {
                result.append(filesInFolder1.get(i));
                result.append("\n");
            }
        } else if (l.equals("list -l")) {
            result.setText("");
            for (int i = 0; i < filesInTree.size(); i++) {
                result.append(filesInTree.get(i));
                result.append("\n");
            }
        } else if (l.equals("list -w")) {

            if (bst) {
                BSTree.print.clear();
                BSTree.print();
                for (int i = 0; i < BSTree.print.size(); i++) {
                    result.append((i+1)+ "-" + BSTree.print.get(i) + "->");
                    result.append("\n");
                    BSTree.files.get(i).printList();
                    for (int j = 0; j < BSTree.files.get(i).print.size(); j++) {
                        result.append(  BSTree.files.get(i).print.get(j) );
                    }
                    result.append("\n");
              
                }
                 result.append("number of words : " + BSTree.print.size());
            }
            if (tst) {
                all = TSTree.print();
                for (int i = 0; i < all.size(); i++) {
                    result.append(i + all.get(i) + "->");
                    result.append("\n");
                    TSTree.files.get(i).printList();
                    for (int j = 0; j < TSTree.files.get(i).print.size(); j++) {
                        result.append(TSTree.files.get(i).print.get(j));
                    }
                    result.append("\n");
                }result.append("number of words : " + all.size());
            }
            if (trie) {
                trieTree.print1();
                all = trieTree.print;
                for (int i = 0; i < all.size(); i++) {
                    result.append(i + all.get(i) + "->");
                    result.append("\n");
                    trieTree.files.get(i).printList();
                    for (int j = 0; j < trieTree.files.get(i).print.size(); j++) {
                        result.append(trieTree.files.get(i).print.get(j));
                    }
                    result.append("\n");
                    }
                result.append("number of words : " + trieTree.print.size());
            }

        } else if (split[0].equals("Search") && split[1].equals("-w")) {
            if (bst) {
                result.setText("");
                BSTNode finding = BSTree.find1(split[2]);
                if (!(finding == null)) {
                    result.append(finding.data + "->");
                    result.append("\n");
                    finding.files.print.clear();
                    finding.files.printList();
                    for (int j = 0; j < finding.files.print.size(); j++) {
                        result.append("(" + finding.files.repeat.get(j) + ")" +  finding.files.print.get(j));
                        for(int p = 0; p <finding.files.word.get(j).size(); p++){
                            result.append(finding.files.line.get(j).get(p) + " " + finding.files.word.get(j).get(p)+"th word ");
                        }
                        result.append("\n");
                        }result.append("the number in () shows the number of repetitions in each file");
                    
                } else {
                    result.append("not found :(");
                }
            }
            if (tst) {
                TSTNode finding = TSTree.find(split[2]);
                if (!(finding == null)) {
                    result.append(split[2] + "->");
                    result.append("\n");
                    finding.fileName.printList();
                    for (int j = 0; j < finding.fileName.print.size(); j++) {
                        result.append("(" + finding.fileName.repeat.get(j) + ")" +finding.fileName.print.get(j));
                         for(int p = 0; p <finding.fileName.word.get(j).size(); p++){
                            result.append(finding.fileName.line.get(j).get(p) + " " + finding.fileName.word.get(j).get(p)+"th word ");
                        }
                        result.append("\n");      
                    }result.append("the number in () shows the number of repetitions in each file");
                } else {
                    result.append("not found :(");
                }
            }

            if (trie) {
                TrieNode finding = trieTree.find(split[2]);
                if (!(finding == null)) {
                    result.append(finding.word + "->");
                    result.append("\n");
                    finding.fileName.printList();
                    for (int j = 0; j < finding.fileName.print.size(); j++) {
                        result.append("(" + finding.fileName.repeat.get(j) + ")" +finding.fileName.print.get(j));
                         for(int p = 0; p <finding.fileName.word.get(j).size(); p++){
                            result.append(finding.fileName.line.get(j).get(p) + " " + finding.fileName.word.get(j).get(p)+"th word ");
                        }
                        result.append("\n");
                        } result.append("the number in () shows the number of repetitions in each file");
                   
                } else {
                    result.append("not found :(");
                }
            }
        } else if (split[0].equals("add")) {
            if (!filesInFolder.contains(split[1] + ".txt")) {
                filesInFolder.add(split[1] + ".txt");
            }
            if (!filesInTree.contains(split[1] + ".txt")) {
                filesInTree.add(split[1] + ".txt");
            }
            addedFiles.add(split[1] + ".txt");
            readFile.readFile(bst, tst, trie, text1.getText(), addedFiles);
            if (bst) {
                BSTree = readFile.BSTree;
            } else if (tst) {
                TSTree = readFile.TSTree;
            } else if (trie) {
                trieTree = readFile.trieTree;
            }
        } else if (split[0].equals("update")) {

            updateFiles.add(split[1] + ".txt");
            readFile.readFile(bst, tst, trie, text1.getText(), updateFiles);
            if (bst) {
                BSTree = readFile.BSTree;
            } else if (tst) {
                TSTree = readFile.TSTree;
            } else if (trie) {
                trieTree = readFile.trieTree;
            }
        } else if (split[0].equals("del")) {
            int flag = 0;
            deletedFiles.add(split[1] + ".txt");
            for (int j = 0; j < filesInTree.size(); j++) {
                if ((split[1] + ".txt").equals(filesInTree.get(j))) {
                    flag = 1;
                    filesInTree.remove(j);
                    break;
                }
            }
            if (flag == 1) {
                if (bst) {
                    BSTree.del(split[1] + ".txt");
                } else if (tst) {
                    TSTree.del(split[1] + ".txt");
                } else if (trie) {
                    trieTree.del(split[1] + ".txt");
                }
            } else {
                result.append("this file doesn't exit");
            }
        } else if (split[0].equals("Search") && split[1].equals("-s")) {
            String[] findString = new String[split.length - 2];
            for (int i = 2; i < split.length; i++) {
                findString[i - 2] = split[i];
            }
            int flag = 0;
            if (bst) {
                ArrayList<BSTNode> words = new ArrayList<>();
                for (int i = 0; i < findString.length; i++) {
                    if (BSTree.find1(findString[i]) != null) {
                        words.add(BSTree.find1(findString[i]));
                    } else {
                        flag = 1;
                        break;
                    }

                }
                if (flag == 0) {
                    LinkedList res = words.get(0).files;
                    for (int j = 1; j < words.size(); j++) {

                        res = res.check(res, words.get(j).files);
                    }
                    res.printList();
                    for (int j = 0; j < res.print.size(); j++) {
                        result.append(res.print.get(j));
                    }
                } else {
                    result.append("nothing");
                }
            }
            if (tst) {
                ArrayList<TSTNode> words = new ArrayList<>();
                for (int i = 0; i < findString.length; i++) {
                    if (TSTree.find(findString[i]) != null) {
                        words.add(TSTree.find(findString[i]));
                    } else {
                        flag = 1;
                        break;
                    }
                }
                if (flag == 0) {
                    LinkedList res = words.get(0).fileName;
                    for (int j = 1; j < words.size(); j++) {

                        res = res.check(res, words.get(j).fileName);
                    }
                    res.printList();
                    for (int j = 0; j < res.print.size(); j++) {
                        result.append(res.print.get(j));
                    }
                } else {
                    result.append("nothing");
                }
            }

            if (trie) {
                ArrayList<TrieNode> words = new ArrayList<>();
                for (int i = 0; i < findString.length; i++) {
                    if (trieTree.find(findString[i]) != null) {
                        words.add(trieTree.find(findString[i]));
                    } else {
                        flag = 1;
                        break;
                    }
                }
                if (flag == 0) {
                    LinkedList res = words.get(0).fileName;
                    for (int j = 1; j < words.size(); j++) {

                        res = res.check(res, words.get(j).fileName);
                    }
                    res.printList();
                    for (int j = 0; j < res.print.size(); j++) {
                        result.append(res.print.get(j));
                    }
                } else {
                    result.append("nothing");
                }
            }
        }
    }

    /**
     * keyListener for up and down
     * use to show last command
     */
    public class MyKeyListener implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if ("Up".equals(KeyEvent.getKeyText(e.getKeyCode()))) {

                String s = stack1.pop();
                if (!s.equals("")) {
                    text2.setText(s);
                    stack2.push(s);
                }
            } else if ("Down".equals(KeyEvent.getKeyText(e.getKeyCode()))) {

                String s = stack2.pop();
                if (!s.equals("")) {
                    text2.setText(s);
                    stack1.push(s);
                }
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
        }
    }

}
