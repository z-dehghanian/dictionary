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
public class TrieNode {
    
    char data;
    ArrayList<TrieNode> childnodes; 
    String word = null;
    LinkedList fileName;
    public TrieNode(char data) {
        this.fileName = new LinkedList();
        this.childnodes = new ArrayList<>();
        this.data = data;
    }
    
}
