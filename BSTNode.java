/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package midterm;

/**
 *
 * @author Monireh.S
 */
public class BSTNode {

    BSTNode leftChild, rightChild;
    LinkedList files;
    String data;
    
    public BSTNode(String data){
        this.files = new LinkedList();
        this.leftChild = null;
        this.rightChild = null;
        this.data = data;
        
    }

}
