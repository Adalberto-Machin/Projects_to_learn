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
        //System.out.println("testing " + dna);
        //System.out.println("stop codon of " + stopCodon);
        int current_index = dna.indexOf(stopCodon, startIndex+3);
        while (current_index != -1) {
            if ((current_index - startIndex)%3==0){
                //System.out.println("stop codon found in index " + current_index + " and value of " + stopCodon);
                return current_index;
            }
            else {
                current_index = dna.indexOf(stopCodon, current_index+1);
            }

        }
        return dna.length();
    }
    
    public String findGene(String dna, int where){
        String gene = ""; // this is the gene we have identified after finding the start and stop codons
        dna = dna.toLowerCase();
        String start_codon = "atg";
        int startIndex = dna.indexOf(start_codon, where);
        if (startIndex == -1){
            return ""; // return empty spring if there is no start codon that can be identified
        }
        else{
            // proceed to find the stop codon with the startIndex information
            int stopIndex_TAA = findStopCodon(dna, startIndex, "TAA");
            int stopIndex_TAG = findStopCodon(dna, startIndex, "TAG");
            int stopIndex_TGA = findStopCodon(dna, startIndex, "TGA");
            int stop_min_index = Math.min(stopIndex_TAA, Math.min(stopIndex_TAG,stopIndex_TGA));
            if (stop_min_index == dna.length()){
                // we did not find any of the stop codons so return empty string
                return "";
            }
            else {
                // set gene to be equal to the info from the start and stop codons
                gene = dna.substring(startIndex, stop_min_index+ 3);
            }
        }
        
        return gene;
    }

    public void printAllGenes (String dna){
        // this method will find all of the genes in the DNA strand
        String gene = ""; // this is the gene we have identified after finding the start and stop codons 
        int startIndex = 0;
        System.out.println("testing DNA of " + dna);
        while (true){
            // Find the gene
            gene = findGene(dna, startIndex);
            if (gene.isEmpty()){
                System.out.println("No more genes to find with last startIndex of " + startIndex);
                break;
            }
            System.out.println("Found a gene starting at " +  dna.indexOf(gene, startIndex) + " and value of " + gene);
            startIndex = dna.indexOf(gene, startIndex) + gene.length();
        }
    }
    public void testFindStopCodon(){
        List<String> all_cases = new ArrayList<>();
        String fine = "cccatggtggtttaaataataataggagagagagagagagttt";
        String no_ATG = "gggtttaaataataatag";
        String no_TAA = "atggggtttatatatag";
        String neither = "gggtttatatatag";
        String no_multiple_of_3 = "cccatggggtttaattt";
        String assigment = "AAATGCCCTAACTAGATTAAGAAACC";
        String fine_TAG = "cccatggtggtttagatagtagtaggagagagagagagagttt";
        String multiple_stop = "cccatggtggtttaaatagtaataggagatgagagagagagttagtttatgjhgkeowfodrgjtga";
        all_cases.addAll(List.of(fine, no_ATG, no_TAA, neither,no_multiple_of_3, assigment, fine_TAG, multiple_stop));
        
        System.out.println("test the method findStopCodon");
        //test the method findStopCodon
        int result = findStopCodon(fine, 3, "TAA");
        System.out.println("stop codon found in index " + result + " DNA length was " + fine.length());
        result = findStopCodon(no_TAA, 3, "TAA");
        System.out.println("stop codon found in index " + result + " DNA length was " + no_TAA.length());
        System.out.println("Complete");
    }
        
    public void testFindGene(){
        List<String> all_cases = new ArrayList<>();
        String fine = "cccatggtggtttaaataataataggagagagagagagagttt";
        String no_ATG = "gggtttaaataataatag";
        String no_TAA = "atggggtttatatatag";
        String neither = "gggtttatatatag";
        String no_multiple_of_3 = "cccatggggtttaattt";
        String assigment = "AAATGCCCTAACTAGATTAAGAAACC";
        String fine_TAG = "cccatggtggtttagatagtagtaggagagagagagagagttt";
        String multiple_stop = "cccatggtggtttaaatagtaataggagatgagagagagagttagtttatgjhgkeowfodrgjtga";
        all_cases.addAll(List.of(fine, no_ATG, no_TAA, neither,no_multiple_of_3, assigment, fine_TAG, multiple_stop));
        
        System.out.println("test the method findGene");
        // test the method findGene
        for (String case_example : all_cases) {
            String result_dna = findGene(case_example, 0);
            System.out.println("testing " + case_example);
            System.out.println("Gene strand " + result_dna + " length of total DNA " + case_example.length());
        }
        System.out.println("Complete");
        
        System.out.println("Testing print all genes ");
        // test the method printAllGenes
        for (String case_example : all_cases) {
            printAllGenes(case_example);             
        }
        System.out.println("Complete ");

    }
}

