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


        public double cgRatio (String dna){
            // this method returns ratio of C’s and G’s in dna as a fraction of the entire strand of DNA
            // make sure you convert the count of Cs and Gs into float to make sure you get a float result in the division
            int c_index = 0;
            int g_index = 0;
            int found_index = 0; // temporary index holder used to see if an index is found in the data
            dna = dna.toLowerCase();
            int c_count = 0;
            int g_count = 0;
            
            System.out.println("DNA strand to analyze is  " + dna);
            // find the number of times C occurs
            while (found_index != -1){
                found_index = dna.indexOf("c", c_index);
                c_index = found_index + 1;
                if (found_index != -1){
                    c_count = c_count + 1;
                }
                
                System.out.println("C count is  " + c_count);
            }
            
            // reset found index back to 0 to find G
            found_index = 0; 
            
            // find the number of times G occurs
            while (found_index != -1){
                found_index = dna.indexOf("g", g_index);
                g_index = found_index + 1;
                if (found_index != -1){
                    g_count = g_count + 1;
                }
                
                System.out.println("G count is  " + g_count);
            }
            
            double cgratio_result = ((double) (c_count + g_count)) / dna.length();
            
            return cgratio_result;
        }
        
        public int countCTG(String dna){
            // returns the number of times the codon CTG appears in DNA
            int ctg_index = 0;
            int found_index = 0; // temporary index holder used to see if an index is found in the data
            dna = dna.toLowerCase();
            int ctg_count = 0;
            
            System.out.println("DNA strand to analyze is  " + dna);
            // find the number of times C occurs
            while (found_index != -1){
                found_index = dna.indexOf("ctg", ctg_index);
                ctg_index = found_index + 1;
                if (found_index != -1){
                    ctg_count = ctg_count + 1;
                }
                
                //System.out.println("CTG count is  " + ctg_count);
            }
            
            return ctg_count;
        }
    
        public StorageResource getAllGenes (String dna){
        // this method will find all of the genes in the DNA strand
        StorageResource geneList = new StorageResource();
        String gene = ""; // this is the gene we have identified after finding the start and stop codons 
        int startIndex = 0;
        //System.out.println("testing DNA of " + dna);
        while (true){
            // Find the gene
            gene = findGene(dna, startIndex);
            if (gene.isEmpty()){
                System.out.println("No more genes to find with last startIndex of " + startIndex);
                break;
            }
            //System.out.println("Found a gene starting at " +  dna.indexOf(gene, startIndex) + " and value of " + gene);
            // add the gene to the storage resource
            geneList.add(gene);
            startIndex = dna.indexOf(gene, startIndex) + gene.length();
        }
        return geneList;
    }
    
    public void processGenes (StorageResource sr){
        int count_9 = 0;
        int count_cg_ratio = 0;
        int current_length = 0;
        int max_length = 0;
        double cg_ratio_result = 0;
        for (String dna: sr.data()){
            if (dna.length() > 9){
                count_9 = count_9 + 1;
                System.out.println("String with count greater than 9 found, which is " + dna);
            }
            // get the C-G ratio 
            cg_ratio_result = cgRatio(dna);
            if (cg_ratio_result > 0.35){
                System.out.println("String with c-g ratio greater than 0.35 found, which is " + dna);
                count_cg_ratio = count_cg_ratio + 1;
            }
            //track the length of the longest gene in sr
            current_length = dna.length();
            if (current_length > max_length){
                max_length = current_length;            
            }
        }
        System.out.println("number of Strings in sr that are longer than 9 characters is " + count_9);
        System.out.println("number of Strings in sr that have c-g ratio higher than 0.35 " + count_cg_ratio);
        System.out.println("Longest gene is " + max_length);
    }
    
        public void testgetAllGenes(){
        List<String> all_cases = new ArrayList<>();
        String fine = "cccatggtggtttaaataataataggagagagagagagagttt";
        String no_ATG = "gggtttaaataataatag";
        String no_TAA = "atggggtttatatatag";
        String neither = "gggtttatatatag";
        String no_multiple_of_3 = "cccatggggtttaattt";
        String assigment = "AAATGCCCTAACTAGATTAAGAAACC";
        String fine_TAG = "cccatggtggtttagatagtagtaggagagagagagagagttt";
        String multiple_stop = "cccatggtggtttaaatagtaataggagatgagagagagagttagtttatgjhgkeowfodrgjtga";
        String multiple_easy = "atgabccdabcdabcccctaaatguuuuuutagjjjjjjjjjjjjjjjjjjjjjjatgjjjjjjjjjjjjjjjjjjtga";
        all_cases.addAll(List.of(fine, no_ATG, no_TAA, neither,no_multiple_of_3, assigment, fine_TAG, multiple_stop, multiple_easy));
        
        
        
        System.out.println("Testing getAllGenes ");
        // test the method printAllGenes
        for (String case_example : all_cases) {
            StorageResource gene_stored = getAllGenes(case_example);
            // iterate over the things in the storage resource
            System.out.println("in this case, the found genes are");
            for (String g: gene_stored.data()){
                System.out.println("gene is: " + g);
            }
        }
        System.out.println("Complete ");

    }
    
    public void test_cgRatio(){
        String test_dna = "ATGCCATAG";
        
        System.out.println("Testing cgRatio");
        double ratio = cgRatio(test_dna);
        System.out.println("G and C ratio in this DNA is  " + ratio);
        
        System.out.println("Testing countCTG");
        int ctg_count = countCTG(test_dna);
        System.out.println("GTC count is  " + ctg_count);
        
        test_dna = "ATGCCATAGCTGCTGwsijurghbsiugbCTG";
        ctg_count = countCTG(test_dna);
        System.out.println("CTG count is  " + ctg_count);
    }
    
    public void testProcessGenes(){
    // this method will test the process genes method
    }
}

