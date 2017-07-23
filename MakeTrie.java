/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package midterm;

import java.util.ArrayList;

/**
 *
 * @author Monireh.S
 */
public class MakeTrie {

    TrieNode root;
    TrieNode current;
    int flag = 0;

    public MakeTrie() {
        root = new TrieNode('0');

    }

    public void add(String data, String file,int line,int word1) {

        char word[] = data.toCharArray();
        TrieNode m = null;
        
        current = root;
        //m2 = current;
        for (int i = 0; i < word.length; i++) {
            flag = 0;
            m = new TrieNode(word[i]);
            if (current.childnodes.isEmpty()) {
                current.childnodes.add(m);
                current = m;
            } else {
                for (int j = 0; j < current.childnodes.size(); j++) {
                    if (current.childnodes.get(j).data == word[i]) {
                        flag = 1;
                        current = current.childnodes.get(j);
                        break;
                    }
                }
                if (flag == 0) {
                    current.childnodes.add(m);
                    current = m;
                }
            }
            if (i == word.length - 1) {
                current.word = data;
            }
            current.fileName.insert(file,line,word1);
            //System.out.print(current.word);
        }

    }

    public TrieNode find(String word) {
        int flag = 0;
        if (isEmpty()) {
            return null;
        } else {
            char word1[] = word.toCharArray();
            current = root;
            for (int i = 0; i < word1.length; i++) {
                flag = 0;
                for (int j = 0; j < current.childnodes.size(); j++) {
                    if (current.childnodes.get(j).data == word1[i]) {
                        current = current.childnodes.get(j);
                        flag = 1;
                        break;
                    }
                }
                if (flag == 0) {
                    return null;
                }
            }
            if (current.word == null) {
                return null;
            }
            return current;
        }
    }

    public boolean isEmpty() {
        return root == null;
    }

    ArrayList<String> print = new ArrayList<>();
    ArrayList<LinkedList> files = new ArrayList<>();

    public void print1() {
        print.clear();
        files.clear();
        print(root);
    }

    public void print(TrieNode r) {
        if (r.word != null) {
            print.add(r.word);
            files.add(r.fileName);
        }
        for (int i = 0; i < r.childnodes.size(); i++) {
            print(r.childnodes.get(i));
        }
    }
    
    public void del1(TrieNode r, String file) {
        if (r.word != null) {
            r.fileName.checkList(file);
             if(r.fileName.isEmpty())
                    r.word = null;
        }
        for (int i = 0; i < r.childnodes.size(); i++) {
            del1(r.childnodes.get(i),file);
        }
    }

    public void del(String file) {
        del1(root, file);
    }

    
}
