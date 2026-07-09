import edu.duke.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
/**
 * Adalberto Machin
 * Finding genes in DNA strands complex
 */

public class DEBUG1 {
    
    public int howMany(String stringa, String stringb) {
    // method to determine how many occurrences of a string appear in another string
    // returns integer indicating ho wmany times stringa appears in string b
    // every occurrence of stringa should not overlap with another occurrence of stringa
        int index = 0; // initialize the index to be 0, then update wiht the found index
        int count = 0; //counts the number of times the index is found
        String result = "";
        while(index !=-1){
            int index_imm = stringb.indexOf(stringa, index);
            if (index_imm != -1)
            {
                index = index_imm + stringa.length();
                count = count + 1;
                result = stringb.substring((index+1), (stringa.length()+index));
                System.out.println("Beginning is " + (index + 1) + " ending is " + (stringa.length()+index));
                System.out.println("Result for " + stringa + " within " + stringb + " is " + result);
            }
            else {
                index = -1;
            }
    
        }
        return count;
    }
    
    public void testhowMany (){
    // this jsut tests the how many method
    String stringa = "a";
    String stringb = "bananaa";
    int result = howMany(stringa, stringb);
    System.out.println("Result for " + stringa + " within " + stringb + " is " + result);
    stringa = "ana";
    stringb = "bananaa";
    result = howMany(stringa, stringb);
    System.out.println("Result for " + stringa + " within " + stringb + " is " + result);
    stringa = "na";
    stringb = "bananaa";
    result = howMany(stringa, stringb);
    System.out.println("Result for " + stringa + " within " + stringb + " is " + result);
    stringa = "breath";
    stringb = "bananaa";
    result = howMany(stringa, stringb);
    System.out.println("Result for " + stringa + " within " + stringb + " is " + result);
    stringa = "breath";
    stringb = "breath000";
    result = howMany(stringa, stringb);
    System.out.println("Result for " + stringa + " within " + stringb + " is " + result);
    stringa = "breath";
    stringb = "breath000breath";
    result = howMany(stringa, stringb);
    System.out.println("Result for " + stringa + " within " + stringb + " is " + result);
    stringa = "abc";
    stringb = "abcdefabcghi";
    result = howMany(stringa, stringb);
    System.out.println("Result for " + stringa + " within " + stringb + " is " + result);
    }
    
}
