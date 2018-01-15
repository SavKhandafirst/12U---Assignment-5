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

    public void add(int number) {
        // start at the beginning of list
        IntNode node = head;

        // if there are no numbers in the list
        if (numItems == 0) {
            // create a node for the list
            IntNode createNode = new IntNode(number);
            // created node pointer must point at the start
            createNode.setNext(head);
            // move the head back to the beginning of the list
            head = createNode;

        } // if the number entered is the largest, place it in the ending
        else if (number >= get(numItems - 1)) {
            // go through the entire array till the last spot is found
            while (node.getNext() != null) {
                node = node.getNext();
            }
            // now that the spot is found...
            // node is the last node in the list
            IntNode temporary = new IntNode(number);
            // insert it into the list
            node.setNext(temporary);

        } // if the number entered is the smallest, place it in the beginning
        else if (number <= node.getNum()) {
            // create a new node
            IntNode temporary = new IntNode(number);
            // the new node points to the previous head
            temporary.setNext(head);
            // now the head is equal to the temp
            head = temporary;

        } else {
            // if the number should go somewhere between the linked list, place it in its right place
            // go through the array to see where the number should be inputted
            while (number < node.getNum()) {
                node = node.getNext();
            }

            // now that the spot is found...
            // create a node to temporary hold the given number
            IntNode temporary = new IntNode(number);
            // make the new node point to the node after it
            temporary.setNext(node.getNext());
            // changing the pointer of the new node
            node.setNext(temporary);

        }
        numItems++;
    }

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

    public void remove(int number) {
        // the method will only function if there are even any numbers to remove
        if (numItems != 0) {

            // set node to head
            IntNode node = head;

            // if its the first number being removed,
            // special process required
            // if the number asked for equals the head number
            if (numItems == node.getNum()) {
                // head is equal to the next number in the list
                head = head.getNext();
            }

            // looping till the number is found that is being searched for
            while (number != node.getNext().getNum()) {
                node = node.getNext();
            }

            // identified the number being removed
            IntNode removedNode = node.getNext();

            // setting the next node
            node.setNext(node.getNext().getNext());

            // removing the previous link
            removedNode.setNext(null);

            // decrease
            numItems--;
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        A5Q1 list = new A5Q1();

        // run test
        list.add(-10);
        list.add(5);
        list.add(-3);
        list.add(6);
        list.add(-11);
        list.add(-11);
        list.add(6);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        list.remove(-3);

        System.out.println("After removing -3");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
