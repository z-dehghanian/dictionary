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
public class MakeTST {

    TSTNode root;
    TSTNode current;
    TSTNode find;
    ArrayList<String> print = new ArrayList<>();
    ArrayList<LinkedList> files = new ArrayList<>();

    public MakeTST() {

    }

    public void add(String data, String f,int line,int word) {
        char data1[] = data.toCharArray();
        root = add1(data1, root, 0, f,line,word);
    }

    public TSTNode add1(char word[], TSTNode current, int cur, String f,int line,int word1) {

        if (current == null) {
            current = new TSTNode(word[cur]);
        }
        if (word[cur] < current.data) {
            current.left = add1(word, current.left, cur, f,line,word1);
        } else if (word[cur] > current.data) {
            current.right = add1(word, current.right, cur, f,line,word1);
        } else {
            if (cur + 1 >= word.length) {
                current.isWord = 1;
                current.fileName.insert(f,line,word1);
            } else {
                current.equal = add1(word, current.equal, cur + 1, f,line,word1);
            }
        }
        return current;

    }

    public TSTNode find(String data) {
        char data1[] = data.toCharArray();
        return find1(data1, root, 0);
    }

    public TSTNode find1(char word[], TSTNode current, int cur) {

        if (isEmpty()) {
            return null;
        } else {
            if (current == null) {
                return null;
            }
            if (word[cur] < current.data) {
                return find1(word, current.left, cur);
            } else if (word[cur] > current.data) {
                return find1(word, current.right, cur);
            } else {
                if (cur + 1 == word.length) {
                    if (current.isWord == 1) {
                        return current;
                    } else {
                        return null;
                    }
                } else {
                    return find1(word, current.equal, cur + 1);
                }
            }
        }
    }

    private void traverse(TSTNode r, String str) {
        if (r != null) {
            traverse(r.left, str);
            str = str + r.data;
            if (r.isWord == 1) {
                print.add(str);
                files.add(r.fileName);
            }
            traverse(r.equal, str);
            str = str.substring(0, str.length() - 1);
            traverse(r.right, str);

        }

    }

    public void del(String file) {
        del1(root, file);
    }

    private void del1(TSTNode r, String file) {
        if (r != null) {
            del1(r.left, file);
            if (r.isWord == 1) {
               // System.out.print(r.data);
                r.fileName.checkList(file);
                if(r.fileName.isEmpty())
                    r.isWord = 0;
            }
            del1(r.equal, file);
            del1(r.right, file);
        }
    }

    public ArrayList<String> print() {
        print.clear();
        files.clear();
        traverse(root, "");
        return print;
    }

    public boolean isEmpty() {

        if (root == null) {
            return true;
        }
        return false;
    }

}
