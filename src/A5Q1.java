/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author khans4349
 */
public class A5Q1 {

    private IntNode head;
    private int numItems;

    public A5Q1() {
        head = null;
        numItems = 0;
    }

    public void add(int num) {
        // start at the beginning of list
        IntNode node = head;

        // determine what the number at head is...
        int headNum = node.getNum();

        // determine what the number at the end of the linked list is
        int tailNum = get(numItems - 1);

        // if there are no numbers in the list
        if (numItems == 0) {
            // create a node for the list
            IntNode createNode = new IntNode(num);
            // created node pointer must point at the start
            createNode.setNext(head);
            // move the head back to the beginning of the list
            head = createNode;
        } 
        
        // if the number entered is the smallest, place it in the beginning
        else if (num < headNum) {
            // create a new node
            IntNode temporary = new IntNode(num);
            // the new node points to the previous head
            temporary.setNext(head);
            // now the head is equal to the temp
            head = temporary;
        }

        // if the number entered is the largest, place it in the ending
        else if (num > tailNum) {
            // go through the entire array till the last spot is found
            while(node.getNext() != null){
                node = node.getNext();
            }
            // now that the spot is found...
            // node is the last node in the list
            IntNode temporary = new IntNode(num);
            // insert it into the list
            node.setNext(temporary);
        }else{
            // if the number should go somewhere between the linked list, place it in its right place
            // go through the array to see where the number should be inputted
            while(num < node.getNum()){
                node = node.getNext();
            }
            // now that the spot is found...
            // create a node to temporary hold the given number
            IntNode temporary = new IntNode(num);
            // make the new node point to the node after it
            temporary.setNext(node.getNext());
            // changing the pointer of the new node
            node.setNext(temporary);
        }
        
        
      
        
        
        
        
        
//        // start at beginning of list
//        IntNode node = head;
//        // see if it is first item
//        if(node == null){
//            IntNode temp = new IntNode(num);
//            head = temp;
//        }else{
//            // travel to the end
//            while(node.getNext() != null){
//                // travel to the next node
//                node = node.getNext();
//            }
//            // node is the last node in the list
//            IntNode temp = new IntNode(num);
//            // insert it into the list
//            node.setNext(temp);
//            
//        }
//        // increase the size counter
//        numItems++;
    }

//    public void add(int pos, int num) {
//        // at the front
//        if(pos == 0){                   
//            // create the node
//            IntNode temp = new IntNode(num);
//            // the new node points to the start
//            temp.setNext(head);
//            // reassign the head node
//            head = temp;
//        }else if(pos == numItems){
//            add(num);
//        // anywhere else
//        }else{
//            // start at the beginning
//            IntNode node = head;
//            // move to the node before the insert
//            for(int i = 0; i < pos - 1; i++){
//                node = node.getNext();
//                             
//            }
//            // mode just before the insert
//            IntNode temp = new IntNode(num);
//            // create the after link first!
//            temp.setNext(node.getNext());
//            // change node pointer
//            node.setNext(temp);
//            
//        }
//        // increase item counter
//        numItems++;
//    }
    public int size() {
        return numItems;
    }

    public boolean isEmpty() {
        return numItems == 0;
    }

    public int get(int position) {
        IntNode node = head;
        // move the number of times
        for (int i = 0; i < position; i++) {
            node = node.getNext();
        }
        return node.getNum();
    }

    public void remove(int pos) {
        // if removing from the start 
        if (pos == 0) {
            head = head.getNext();
        } else if (pos == numItems - 1) {
            // removing from the end
            IntNode node = head;
            for (int i = 0; i < numItems; i++) {
                node = node.getNext();
            }
            // sever the link
            node.setNext(null);
        } else {
            IntNode node = head;
            for (int i = 0; i < pos - 1; i++) {
                node = node.getNext();
            }
            // the node to remove
            IntNode toRemove = node.getNext();
            // its next node
            IntNode next = toRemove.getNext();
            // set all the links
            node.setNext(next);
            toRemove.setNext(null);
        }
        numItems--;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        A5Q1 list = new A5Q1();
        list.add(2);
        list.add(-5);
        // list.add(0, 13);
        list.remove(1);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
