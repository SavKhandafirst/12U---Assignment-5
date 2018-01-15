/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author khans4349
 */
public class A5Q2 {

    // array
    private int[] array;

    // number of items
    private int numItems;

    public A5Q2() {
        // numItems equal to 0
        numItems = 0;
        // set the array for an inital ten spots (may be increased later on)
        array = new int[10];
    }

    public void add(int index, int num) {

        numItems++;

        // TWO cases: Either there is enough room or there isn't
        // if there is not enough room
        if (numItems >= array.length) {
            // double the spots in the array
            int arraySpots = array.length * 2;

            // making an array for temporary basis to transition over
            int[] temporary = new int[arraySpots];

            // must move items that come before index
            for (int posBefore = 0; posBefore < index; posBefore++) {
                temporary[posBefore] = array[posBefore];
            }

            // place the number in its proper index
            temporary[index] = num;

            // now place the rest of the numbers in its appropriate index
            for (int posAfter = index + 1; posAfter <= numItems - index + 2; posAfter++) {
                temporary[posAfter] = array[posAfter - 1];
            }

            // now copy the fully formed temporary array beack into the original array // forloop
            array = temporary;

        } else {
            // if there is enough room
            int arraySpots = array.length;

            // making an array for temporary basis to transition over
            int[] temporary = new int[arraySpots];

            // must move items that come before index
            for (int posBefore = 0; posBefore < index; posBefore++) {
                temporary[posBefore] = array[posBefore];
            }

            // place the number in its proper index
            temporary[index] = num;

            // now place the rest of the numbers in its appropriate index
            for (int posAfter = index + 1; posAfter <= numItems - index + 2; posAfter++) {
                temporary[posAfter] = array[posAfter - 1];
            }

            // now copy the fully formed temporary array beack into the original array // forloop
            array = temporary;

        }

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

//        // the method will only function if there are even any numbers to remove
//        if (numItems != 0) {
//
//            // set node to head
//            IntNode node = head;
//
//            // if its the first number being removed,
//            // special process required
//            // if the number asked for equals the head number
//            if (numItems == node.getNum()) {
//                // head is equal to the next number in the list
//                head = head.getNext();
//            }
//
//            // looping till the number is found that is being searched for
//            while (number != node.getNext().getNum()) {
//                node = node.getNext();
//            }
//
//            // identified the number being removed
//            IntNode removedNode = node.getNext();
//
//            // setting the next node
//            node.setNext(node.getNext().getNext());
//
//            // removing the previous link
//            removedNode.setNext(null);
//
//            // decrease
//            numItems--;
//        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
}
