import edu.duke.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
/**
 * Adalberto Machin
 * Finding genes in DNA strands simple
 */
public class Part4 {
    public String string_parser (String URL_link){
        // program that reads lines from the file at this URL location
        // prints each URL on the page that is a link to youtube.com
        //Assume that a link to youtube.com has no spaces in it 
        //and would be in the format (where [stuff] represents characters that are not verbatim): “http:[stuff]youtube.com[stuff]”
        // use URL resource to read file at http://www.dukelearntoprogram.com/course2/data/manylinks.html
        URLResource ur = new URLResource(URL_link);
        String to_check = "youtube.com";
        // strategy
        // check each line in the URL
        // make it lower case
        // check if youtube.com” is in it
        // extract the string
        // print the string
        
        String line_to_be_checked = null;
        String extracted_line = null;
        int extracted_line_beg = 0;
        int extracted_line_end = 0;
        for (String line_example : ur.lines()){
            // make the string lower case
            line_to_be_checked = line_example.toLowerCase();
            int youtube_presence = line_to_be_checked.indexOf(to_check);
            if (youtube_presence != -1){
                // just return the lines in quotation marks
                extracted_line_beg = line_example.lastIndexOf("\"",youtube_presence);
                extracted_line_end= line_example.indexOf("\"",youtube_presence);
                System.out.println(line_example.substring(extracted_line_beg,extracted_line_end+1));
            }
        }
        return null;
    }
    
    public void testing(){
    String result = string_parser("https://www.dukelearntoprogram.com/course2/data/manylinks.html");
    //System.out.println("Result is " + result);
    }   
}
