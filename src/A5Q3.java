
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
    
    public boolean inLang(String word){
        // make a char stack
        Stack<Character> stackOne = new Stack<Character>();
        
        // make another char stack
        Stack<Character> stackTwo = new Stack<Character>();
        
        // if the word length is even (which is impossible for this format) then return false
        if(word.length() % 2 == 0){
            return false;
        }
        
        // if word length is less than 3 (which is impossible for this format) then return false
        if(word.length() < 3){
            return false;
        }
        
        // the dollar symbol char
        char dollar = '$';
        
        // check to see if the dollar symbol is in the middle of the word format
        if(word.charAt(word.length() / 2) != dollar){
            return false;
        }else{
            // now we will start checking if the word inputted actually follows the format
            
            // make a char to store the letters in the first part
            char[] stackListOne = new char[word.length()/2];
            
            // make a char to store the letters in the second part
            char[] stackListTwo = new char[word.length()/2];
            
            // make a for loop to input the characters of the word onto stackOne
            for(int i = 0; i < word.length()/2; i++){
                // copy onto the char array
                stackListOne[i] = word.charAt(i);
                // push onto stack
                stackOne.push(stackListOne[i]);                
            }
            
            // make a for loop to input the characters of the word onto stackTwo
            for(int z = word.length(); z > word.length()/2; z--){
                // copy onto the char aray
                stackListTwo[z] = word.charAt(z);
                // push onto stack
                stackTwo.push(stackListTwo[z]);
                
            }
            // check whether the two stacks match
            for(int j = 0; j < word.length()/2; j++){     
                if(stackListOne[j] != stackListTwo[j]){
                    return false;
                    
                }
            }
        
        }
        // if all conditions above are acceptable than return true
        return true;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // run test
        A5Q3 test = new A5Q3();
        
        // system out
        System.out.println(test.inLang("cat$tac"));
    }
}
