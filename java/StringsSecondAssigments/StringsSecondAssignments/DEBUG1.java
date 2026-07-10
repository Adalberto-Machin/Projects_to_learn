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
        int index_to_gather = 0; // initialize the index to be 0, then update wiht the found index
        int index_to_extract = 0;
        int count = 0; //counts the number of times the index is found
        String result = "";
        while(index_to_extract !=-1){
            index_to_extract = stringb.indexOf(stringa, index_to_extract);
            if (index_to_extract != -1)
            {
                index_to_gather = index_to_extract;
                count = count + 1;
                result = stringb.substring((index_to_gather+1), (stringa.length()+index_to_gather));
                System.out.println("Beginning is " + (index_to_gather) + " ending is " + (stringa.length()+index_to_gather-1));
                System.out.println("Result for how many extracted word is wtih stringa: " + stringa + " within stringb: " + stringb + " is " + result);
                index_to_extract = index_to_extract + stringa.length();
            }
        }
        return count;
    }
    
    public void findAbc(String input) {
        int index = input.indexOf("abc");
        while (true) {
            if (index == -1) {
                break;
            }
            if (index >= input.length()-3){
                break;
            }
            String found = input.substring(index+1, index+4);
            System.out.println(found);
            index = input.indexOf("abc", index+4);
    }
}
   public void test() {
    //no code yet
    findAbc("abcd");
    findAbc("abcdabc");
}
    
    public void testhowMany (){
    // this jsut tests the how many method
    String stringa = "a";
    String stringb = "bananaa";
    int result = howMany(stringa, stringb);
    System.out.println("/////////////////////Result for " + stringa + " within " + stringb + " is " + result);
    stringa = "ana";
    stringb = "bananaa";
    result = howMany(stringa, stringb);
    System.out.println("////////////////////////Result for " + stringa + " within " + stringb + " is " + result);
    stringa = "na";
    stringb = "bananaa";
    result = howMany(stringa, stringb);
    System.out.println("///////////////////////Result for " + stringa + " within " + stringb + " is " + result);
    stringa = "breath";
    stringb = "bananaa";
    result = howMany(stringa, stringb);
    System.out.println("/////////////////////////Result for " + stringa + " within " + stringb + " is " + result);
    stringa = "breath";
    stringb = "breath000";
    result = howMany(stringa, stringb);
    System.out.println("//////////////////////////Result for " + stringa + " within " + stringb + " is " + result);
    stringa = "breath";
    stringb = "breath000breath";
    result = howMany(stringa, stringb);
    System.out.println("////////////////////////////Result for " + stringa + " within " + stringb + " is " + result);
    stringa = "abc";
    stringb = "abcdefabcghi";
    result = howMany(stringa, stringb);
    System.out.println("//////////////////////////////Result for " + stringa + " within " + stringb + " is " + result);
    }
    
}
