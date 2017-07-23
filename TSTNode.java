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
public class TSTNode {
    
    char data;
    TSTNode left,right,equal;
    LinkedList fileName;
    int isWord;
    public TSTNode(char data){
        fileName = new LinkedList();
        this.isWord = 0;
        this.left = null;
        this.right = null;
        this.equal = null;
        this.data = data;
    }
    
}
