import edu.duke.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
/**
 * Adalberto Machin
 * Finding genes in DNA strands complex
 */
public class Part1 {
    public int findStopCodon (String dna, int startIndex, String stopCodon) {
        // returns the index of the first ocurrence of stopCodon that appears past the startIndex and is a multiple of 3 away from the startIndex
        // if there is no such stopCodon, method returns the length of the DNA strand
        dna = dna.toLowerCase();
        String start_codon = "atg";
        stopCodon = stopCodon.toLowerCase();
        System.out.println("testing " + dna);
        System.out.println("stop codon of " + stopCodon);
        int current_index = 0;
        while (current_index != -1) {
            current_index = dna.indexOf(stopCodon, startIndex+3);
            if (current_index !=-1){
                if ((current_index - startIndex)%3==0){
                    return current_index;
                }
                else {
                    current_index = current_index+1;
                }
            }
        }
        return dna.length();
    }
    
    public void testFindStopCodon(){
        List<String> all_cases = new ArrayList<>();
        String fine = "cccatggtggtttaaataataataggagagagagagagagttt";
        String no_ATG = "gggtttaaataataatag";
        String no_TAA = "atggggtttatatatag";
        String neither = "gggtttatatatag";
        String no_multiple_of_3 = "cccatggggtttaattt";
        String assigment = "AAATGCCCTAACTAGATTAAGAAACC";
        all_cases.addAll(List.of(fine, no_ATG, no_TAA, neither,no_multiple_of_3, assigment));
        
        int result = findStopCodon(fine, 3, "TAA");
        System.out.println("stop codon found in index " + result + " DNA length was " + fine.length());
        result = findStopCodon(no_TAA, 3, "TAA");
        System.out.println("stop codon found in index " + result + " DNA length was " + no_TAA.length());
        //for (String case_example : all_cases) {
            //String result = findSimpleGene(a);
            //System.out.println("testing " + case_example);
            //System.out.println("Example " + case_example);
            //String result = findStopCodon(case_example, "ATG", "TAA");
            //System.out.println("DNA strand " + result + " length " + result.length());
        //}
    }
}
