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
public class Link {
    
    String fileName;
    Link nextLink;
    int repeat = 1;
    ArrayList<Integer> lines;
    ArrayList<Integer> numWord;
    public Link(String fileName) {
        this.lines = new ArrayList<>();
        this.numWord = new ArrayList<>();
        this.fileName = fileName;
        this.nextLink = null;
    }
    
}
