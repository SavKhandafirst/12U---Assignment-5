/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author khans4349
 */
public class IntNode {
    
    private int item;
    private IntNode next;
    
    public IntNode(int num){
        item = num;
        next = null;
    }
    
    public int getNum(){
        return item;
    }
    
    // return the node that comes after
    public IntNode getNext(){
        return next;
    }
    
    // sets the node that comes after
    public void setNext(IntNode node){
        next = node;
    }
}
