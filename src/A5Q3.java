
import java.util.Stack;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author khans4349
 */
public class A5Q3 {

    public boolean inLang(String word) {
        // SIDE NOTE: ASSUMING THAT THERE MUST BE A 
        // MINIMUM OF ONE LETTER BEFORE AND AFTER THE DOLLAR SIGN  

        // make a char stack
        Stack<Character> stackOne = new Stack<Character>();

        // if the word length is even (which is impossible for this format) then return false
        if (word.length() % 2 == 0) {
            return false;
        }

        // if word length is less than 3 (which is impossible for this format) then return false
        if (word.length() < 3) {
            return false;
        }

        // the dollar symbol char
        char dollar = '$';

        // determine the length of the word
        int wordLength = word.length();

        // check to see if the dollar symbol is in the middle of the word format
        if (word.charAt(wordLength / 2) != dollar) {
            return false;
        } else {
            // now we will start checking if the word inputted actually follows the format

            // make a char to store the letters in the first part
            char[] stackListOne = new char[wordLength / 2];

            // make a for loop to input the characters of the word onto stackOne
            for (int i = 0; i < wordLength / 2; i++) {
                // copy onto the char array
                stackListOne[i] = word.charAt(i);
                // push onto stack
                stackOne.push(stackListOne[i]);                
            }

            // create a count variable to go through the word
            int count = wordLength / 2 + 1;

            // while count is less than the word length
            while (count < wordLength) {
                // store the letter at the top of the stack
                char letter = stackOne.peek();
                // if the letter at count position is not equal to the top letter in stack
                if (word.charAt(count) != letter) {
                    // return false
                    return false;
                } else {
                    // otherwise remove the top letter and increase counter by one
                    stackOne.pop();
                    count++;
                }
            }
            // if all conditions above are acceptable than return true
            return true;
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // run test
        A5Q3 test = new A5Q3();

        // system out
        System.out.println(test.inLang("fish$hsif"));
        
        // system out
        System.out.println(test.inLang("y$y"));
        
        // system out
        System.out.println(test.inLang("yuh$yuh"));
        
        // system out
        System.out.println(test.inLang("a$"));
    }
}
