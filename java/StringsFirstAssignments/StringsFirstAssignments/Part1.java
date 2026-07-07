
import edu.duke.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
/**
 * Adalberto Machin
 * Finding genes in DNA strands simple
 */
public class Part1 {
    public String findSimpleGene (String DNA){
        System.out.println("testing " + DNA);
        int start = DNA.indexOf("atg");
        System.out.println("start " + start);
        if (start == -1){
        return "";
        }
        int stop = DNA.indexOf("taa", start+3);
        System.out.println("stop " + stop);
        if (stop == -1){
            return "";
        }
        else if ((stop - start)%3==0){
            return DNA.substring(start, stop+3);
        }
        else {
            return "";
        }
    }
    public void testSimpleGene(){
        List<String> all_cases = new ArrayList<>();
        String fine = "cccatggtggtttaaataataataggagagagagagagagttt";
        String no_ATG = "gggtttaaataataatag";
        String no_TAA = "atggggtttatatatag";
        String neither = "gggtttatatatag";
        String no_multiple_of_3 = "cccatggggtttaattt";
        String assigment = "AAATGCCCTAACTAGATTAAGAAACC";
        all_cases.addAll(List.of(fine, no_ATG, no_TAA, neither,no_multiple_of_3, assigment));
        
        for (String case_example : all_cases) {
            //String result = findSimpleGene(a);
            //System.out.println("testing " + case_example);
            String result = findSimpleGene(case_example);
            System.out.println("DNA strand " + result + " length " + result.length());
        }
    }
}
