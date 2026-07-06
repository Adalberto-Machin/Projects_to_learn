import edu.duke.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
/**
 * Adalberto Machin
 * Finding genes in DNA strands simple
 */
public class Part3 {
    public boolean twoOccurrences (String stringa, String stringb){
        int index = 0; // initialize the index to be 0, then update wiht the found index
        int count = 0; //counts the number of times the index is found
        while(index !=-1){
            int index_imm = stringb.indexOf(stringa, index);
            if (index_imm != -1)
            {
                index = index_imm + stringa.length();
                count = count + 1;
            }
            else {
                index = -1;
            }
    
        }
        if (count>=2){return true;}
        else {return false;}
    }
    
    public String lastPart (String stringa, String stringb){
    int index_of_occurrence = stringb.indexOf(stringa);
    if (index_of_occurrence != -1){
        // go ahead and get section of string b after this index
        return stringb.substring(index_of_occurrence + stringa.length());
    }
    else{
        return stringb;
    }
    }
    
    public void testing(){
    String stringa = "a";
    String stringb = "bananaa";
    boolean result = twoOccurrences(stringa, stringb);
    System.out.println("Result for " + stringa + " within " + stringb + " is " + result);
    stringa = "breath";
    stringb = "bananaa";
    result = twoOccurrences(stringa, stringb);
    System.out.println("Result for " + stringa + " within " + stringb + " is " + result);
    stringa = "breath";
    stringb = "breath000";
    result = twoOccurrences(stringa, stringb);
    System.out.println("Result for " + stringa + " within " + stringb + " is " + result);
    stringa = "breath";
    stringb = "breath000breath";
    result = twoOccurrences(stringa, stringb);
    System.out.println("Result for " + stringa + " within " + stringb + " is " + result);
    // testing the second method
    System.out.println("second method testing");
    stringa = "breath";
    stringb = "bananaa";
    String result_2 = lastPart(stringa, stringb);
    System.out.println("Result for " + stringa + " within " + stringb + " is " + result_2);
    stringa = "an";
    stringb = "bananaa";
    result_2 = lastPart(stringa, stringb);
    System.out.println("Result for " + stringa + " within " + stringb + " is " + result_2);
    }   
}