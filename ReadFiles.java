/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package midterm;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Monireh.S
 */
public class ReadFiles {

    public final MakeBST BSTree;
    public final MakeTST TSTree;
    public final MakeTrie trieTree;
    public final MakeBST stopTree1;
    public final MakeTST stopTree2;
    public final MakeTrie stopTree3;

    private boolean bst = false, tst = false, trie = false;
    String path;
    int m = 0;
    ArrayList<String> files;

    public ReadFiles() {
        this.BSTree = new MakeBST();
        this.TSTree = new MakeTST();
        this.trieTree = new MakeTrie();
        this.stopTree1 = new MakeBST();
        this.stopTree2 = new MakeTST();
        this.stopTree3 = new MakeTrie();

    }

    public void readFile(boolean bst, boolean tst, boolean trie, String path, ArrayList<String> files) {
        this.bst = bst;
        this.tst = tst;
        this.trie = trie;
        this.path = path;
        makeStopwordTree();
        double start = System.currentTimeMillis();
        for (int i = 0; i < files.size(); i++) {
            int whichline = 0, whichword = 0, line1 = 0;
            String fileName = path + "\\" + files.get(i);
            String line = null;
            try {
                FileReader fileReader = new FileReader(fileName);
                BufferedReader bufferedReader = new BufferedReader(fileReader);

                while ((line = bufferedReader.readLine()) != null) {
                    whichline++;
                    line = line.replaceAll("[^a-zA-Z0-9]", " ");
                    line = line.toLowerCase();
                    String words[] = line.split(" ");

                    if (bst) {
                        for (int j = 0; j < words.length; j++) {
                            if (!words[j].equals("") && checkStopWord(words[j])) {
                                whichword = j + 1 + line1;
                                BSTree.add(words[j], files.get(i), whichline, whichword);
                            }
                        }
                        line1 = line1 + words.length;
                    } else if (tst) {
                        for (int j = 0; j < words.length; j++) {
                            if (!words[j].equals("") && checkStopWord(words[j])) {
                                whichword = j + 1 + line1;
                                TSTree.add(words[j], files.get(i),whichline, whichword);
                            }
                        }
                        line1 = line1 + words.length;
                    } else if (trie) {
                        for (int j = 0; j < words.length; j++) {
                            if (!words[j].equals("") && checkStopWord(words[j])) {
                                whichword = j + 1 + line1;
                                trieTree.add(words[j], files.get(i),whichline, whichword);
                            }
                        }
                        line1 = line1 + words.length;
                    }
                }
                bufferedReader.close();
            } catch (FileNotFoundException ex) {
                System.out.println(
                        "Unable to open file '"
                        + fileName + "'");
            } catch (IOException ex) {
                System.out.println(
                        "Error reading file '"
                        + fileName + "'");

            }
        }
        double end = System.currentTimeMillis();

        System.out.println("finish" + (end - start));
    }

    public boolean checkStopWord(String word) {
        if (bst) {
            if (stopTree1.find1(word) == null) {
                return true;
            }
        } else if (tst) {
            if (stopTree2.find(word) == null) {
                return true;
            }
        } else if (trie) {
            if (stopTree3.find(word) == null) {
                return true;
            }
        }

        return false;

    }

    public void makeStopwordTree() {

        String fileName = path + "\\" + "StopWords.txt";
        String line = null;
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {
                line = line.replaceAll("[^a-zA-Z0-9]", " ");
                String words[] = line.split(" ");
                    if (bst) {
                        for (int j = 0; j < words.length; j++) {
                            if (!words[j].equals("")) {
                                stopTree1.add(words[j],"", 0,0);
                            }
                        }
                      
                    } else if (tst) {
                        for (int j = 0; j < words.length; j++) {
                            if (!words[j].equals("")) {
                                stopTree2.add(words[j],"", 0,0);
                            }
                        }
                    } else if (trie) {
                        for (int j = 0; j < words.length; j++) {
                            if (!words[j].equals("")) {
                                stopTree3.add(words[j],"", 0,0);
                            }
                        }
                    }
            }
            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '"
                    + fileName + "'");
        } catch (IOException ex) {
            System.out.println(
                    "Error reading file '"
                    + fileName + "'");

        }
    }
}
