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
public class LinkedList {

    Link firstNode;
    Link current,head;
    ArrayList<String> print = new ArrayList<>();
    ArrayList<Integer> repeat = new ArrayList<>();
    ArrayList<ArrayList<Integer>>word = new ArrayList<>();
    ArrayList<ArrayList<Integer>> line = new ArrayList<>();
    int size = 0;

    public LinkedList() {
        head = new Link("");
        head.nextLink = firstNode;
    }

    //public Link get(){
      //  return 
    //} 
    public void insert(String data,int line,int word) {
        Link m = new Link(data);
        m.lines.add(line);m.numWord.add(word);
        if (current == null) {
            current = this.firstNode;
        }
        if (this.firstNode == null) {
            this.firstNode = m;
            this.current = this.firstNode;
            size++;
        } else {
            if (/*!getLastNode().fileName.equals(data)*/checkadd(data) == null) {
                int i = 0;
                try {
                    if (this.current.nextLink == null) {
                        this.current.nextLink = m;
                        size++;
                    } else {
                        this.current = this.current.nextLink;
                        this.insert(data,line,word);
                    }
                } catch (NullPointerException x) {
                    System.out.println("error");
                }
            }else{
                checkadd(data).repeat++;
                checkadd(data).lines.add(line);
                checkadd(data).numWord.add(word);
            }
        }
    }

    public void del(String data){
        current = firstNode;
        del1(data);
    }
    public void del1(String data) {
        if (this.firstNode.fileName.equals(data)) {
            this.firstNode = this.firstNode.nextLink;
            size--;
            return ;
        } else if (current.nextLink == null) {
            return ; 
        } else {
           if(current.nextLink.fileName.equals(data)){
               current.nextLink = current.nextLink.nextLink;
               size--;
               return;
           }
           current = current.nextLink; 
           del1(data);
        }
    }

    public boolean isEmpty() {
        return this.firstNode == null;
    }

    public void printList() {
        print.clear();
        word.clear();
        line.clear();
        repeat.clear();
        for (this.current = this.firstNode; this.current != null; this.current = this.current.nextLink) {
            String[] name = current.fileName.split(".txt");
            print.add(name[0] + ",");
            repeat.add(current.repeat);
            word.add(current.numWord);
            line.add(current.lines);
        }

    }

    public void checkList(String file) {

        for (this.current = this.firstNode; this.current != null; this.current = this.current.nextLink) {
            if (current.fileName.equals(file)) {
                //System.out.println("*");
                del(current.fileName);
                return;
            }
        }

    }

   
     public LinkedList check(LinkedList first,LinkedList second) {
        Link fCur = first.firstNode,sCur = second.firstNode;
        LinkedList result = new LinkedList();
        for(int i = 0;i < first.size ; i++){
            for(int j = 0;j < second.size;j++){
                if(sCur.fileName.equals(fCur.fileName)){
                    result.insert(fCur.fileName,0,0);
                }
                sCur = sCur.nextLink;
            }
            fCur = fCur.nextLink;
            sCur = second.firstNode;
        }
        return result;
     }
      
     
     public Link checkadd(String fileName) {
        Link fCur = firstNode;
        //bo result = new LinkedList();
        for(int i = 0;i < size ; i++){
                if(fileName.equals(fCur.fileName)){
                    return fCur;
                }
            fCur = fCur.nextLink;
            //sCur = second.firstNode;
        }
        return null;
     }  

    
        

    public void remove(String toRemove) {
        Link currNode = firstNode;
        while (currNode != null) {
            if (currNode.fileName.equals(toRemove)) {
                currNode = currNode.nextLink;
                break;
            }
            currNode = currNode.nextLink;
        }
    }


private Link getLastNode() {
        if (firstNode == null) {
            return null;
        }
        Link tmpNode = firstNode;
        while (tmpNode.nextLink != null) {
            tmpNode = tmpNode.nextLink;
        }
        return tmpNode;
    }

}
