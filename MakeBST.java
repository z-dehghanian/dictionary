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
public class MakeBST {

    BSTNode root;
    BSTNode current = root;
    ArrayList<String> print = new ArrayList<>();
    ArrayList<LinkedList> files = new ArrayList<>();
    public MakeBST() {

    }

    public void add(String a,String f,int line,int word) {

        BSTNode curNode = root;
        BSTNode m = new BSTNode(a);
        m.files.insert(f,line,word);
        if (root == null) {
            root = m;
            return;
        }
        while (true) {
            if (a.compareToIgnoreCase(curNode.data) < 0) {
                if (curNode.leftChild == null) {
                    curNode.leftChild = m;
                    return;
                }
                curNode = curNode.leftChild;
            } else if (a.compareToIgnoreCase(curNode.data) > 0) {
                if (curNode.rightChild == null) {
                    curNode.rightChild = m;
                    return;
                }
                curNode = curNode.rightChild;
            }else {
              //  if(!curNode.files.search(f))
              //  System.out.println(f + curNode.data);
                curNode.files.insert(f,line,word);
                return;
            }
        }
    }
    
    
    public BSTNode find1(String data){
        
        return find(root,data);
    
    }
    
    
    public BSTNode find(BSTNode current ,String data){
        if (current == null)
            return null;
        if (current.data.equals(data))
            return current;
        
        else if(data.compareToIgnoreCase(current.data) < 0){
              
                return find(current.leftChild,data);
            }
        else if(data.compareToIgnoreCase(current.data) > 0){
                return find(current.rightChild,data);
            }       
        return null;
    }
    
    public void print() {
        print.clear();
        files.clear();
        print1(root);
    
    }
    
    public void del(String file){
        del1(file,root);
        del2(file,root);
    }
    public void del1(String file,BSTNode root){
        
        if(root!=null){
            del1(file,root.leftChild);
            root.files.checkList(file);
            del1(file,root.rightChild);
        }
    }
    
    public void del2(String file,BSTNode root){
        
        if(root!=null){
            del2(file,root.leftChild);
            if(root.files.isEmpty())
                delete(this.root,root.data);
            del2(file,root.rightChild);
        }
    }
   
    public void print1(BSTNode root) {
       
        if(root!=null){
            print1(root.leftChild);
            print.add(root.data);
            files.add(root.files);
            print1(root.rightChild);

        }
    }
    
    public BSTNode delete(BSTNode node, String value) {
    if(node.data.compareToIgnoreCase(value) < 0) {
        node.rightChild = delete(node.rightChild, value);
    } else if(node.data.compareToIgnoreCase(value) > 0) {
        node.leftChild = delete(node.leftChild, value);
    } else {
        if(node.rightChild == null) {
            return node.leftChild;
        }
        if(node.leftChild == null) {
            return node.rightChild;
        }
        BSTNode temp = node;
        node = min(temp.rightChild);
        node.rightChild = deleteMin(temp.rightChild);
        node.leftChild = temp.leftChild;
    }
    return node;
}
    
    private BSTNode min(BSTNode node) {
    if(node.leftChild == null) {
        return node;
    } else {
        return min(node.leftChild);
    }
}
    private BSTNode deleteMin(BSTNode node) {
    if(node.leftChild == null) {
        return node.rightChild;
    }
    node.leftChild = deleteMin(node.leftChild);
    return node;
}
    
}
