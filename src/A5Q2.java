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

            // now copy the fully formed temporary array back into the original array 
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

            // now copy the fully formed temporary array back into the original array
            array = temporary;

        }

    }

    public int size() {
        return numItems;
    }

    public boolean isEmpty() {
        return numItems == 0;
    }

    public int get(int placement) {
        // making sure that placement only returned when it exists
        if (numItems > placement) {
            // return value requested
            return array[placement];
        }// the user asked for a the value at a postion that does notexist
        else {
            // return a value that does not make sense as they have asked for the value of a position that does not exist
            return 10000000;
        }
    }

    public void remove(int index) {
        // if one item in the list
        if (numItems == 1) {
            // decrease by one
            numItems--;
            // if no items in the array
        } else if (numItems == 0) {
            // that means we cant remove anythin
            System.out.println("Nothing to Remove!");
        } else if (index + 1 == numItems) {
            numItems--;
        } else {
            // make a temporary array to copy over
            int[] temporary = new int[array.length];

            // actually copy them over
            for (int i = 0; i < index; i++) {
                temporary[i] = array[i];

            }
            // move the remanining content exluding the index removed
            for (int i = index + 1; i < array.length - 1; i++) {
                temporary[i - 1] = array[i];
            }
            // reformat the original array
            array = temporary;
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Test the program
        A5Q2 list = new A5Q2();
        
        list.add(0, 1);
        list.add(1, 3);
        list.add(2, 15);
        
        
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        
        list.remove(1);
        
        System.out.println(list.get(1));
        
        
        
        
        
    }

}
