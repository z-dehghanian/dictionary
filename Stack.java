/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package midterm;

import java.util.ArrayList;
import javax.swing.JTextField;

/**
 *
 * @author Monireh.S
 */
public class Stack {
    
    private String cmd;
    private ArrayList<String> stack;
    int top = 0;
    public Stack(){
         stack = new ArrayList<>();
    }
    
    public void push(String cmd){
        if(!cmd.equals("")){
            stack.add(cmd);
            top++;
    }}
    
    public String pop(){
        if(!isEmpty()){
            top--;
            return stack.remove(top);
        }
        else
            return "";
    }
   
    public boolean isEmpty(){
        if(top == 0)
            return true;
        return false;
        
    }
    
}
