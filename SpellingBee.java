import java.io.File;
import java.util.Scanner;

public class SpellingBee {
    public static final int WORDLENGTH = 7;
    public static void printArray(String [] dictionary) {
        for (String word : dictionary)
            System.out.print(word + " ");
        System.out.println();
    }

    public static boolean isPanagram(String dWord, String pWord) {
        for (int i = 0; i < WORDLENGTH; i++) {
            if (!dWord.contains(pWord.substring(i,i+1) ) ) {
                return false;
            }
        }
        return true;
    }

    public static boolean isValid(String dWord, String pWord) {
        // first letter must be in the word
        if (!dWord.contains(pWord.substring(0,1))) return false;
        for (int i = 0; i < dWord.length(); i++) {
            if (!pWord.contains(dWord.substring(i,i+1) ) ) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) throws Exception {

        File f = new File("SampleInputP2.txt");
        Scanner scanner = new Scanner(f);
        String line = null;
        line = scanner.nextLine();
        int dictSize = Integer.parseInt(line);
        line = scanner.nextLine();
        int puzSize = Integer.parseInt(line);
        String[] dictionary = new String[dictSize];
        for (int i = 0; i < dictSize; i++) {
            dictionary[i] = scanner.nextLine();
        }
        // printArray(dictionary); // debug

        int totalValid = 0;
        int totalPanagrams = 0;
        for (int i = 0; i < puzSize; i++) {
            String pWord = scanner.nextLine();
            //System.out.println("processing puzzle: " + pWord); // debug
            // process the next word
            int valid = 0;
            int pana = 0;
            for (String dWord : dictionary) {
                if (isPanagram(dWord, pWord)) {
                    ++pana;
                    ++totalPanagrams;
                }
                if (isValid(dWord, pWord)) {
                    ++valid;
                    ++totalValid;
                }
            }
            System.out.println(pana + " " + valid);
        }
        System.out.println(totalPanagrams + " " + totalValid);
    }
}
