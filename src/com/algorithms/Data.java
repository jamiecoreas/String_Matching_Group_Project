package com.algorithms;
import java.util.Random;
import java.nio.file.*;
import java.io.IOException;

public class Data {
    public static String generateRandomText(int length) {
        Random rand = new Random();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            char c = (char) ('a' + rand.nextInt(26));
            sb.append(c);
            }
        return sb.toString();
        }

        public static void saveToFile(String text, String filename) throws IOException {
            Files.writeString(Path.of(filename), text);
        }



        public static void main(String[] args) throws IOException {

            //---------------------------------------------------------------------------
            // Text to generate random text (tests average case)
            String randomText = generateRandomText(100000); // 100k characters
            saveToFile(randomText, "random.txt");
            //End random text
            //----------------------------------------------------------------------------




            //----------------------------------------------------------------------------
            //Test for real text from an article (tests average case)

            //This paragraph text was retrieved from: "KMP Algorithm for Pattern Searching"
            //on: https://www.geeksforgeeks.org/dsa/kmp-algorithm-for-pattern-searching/
            //cited in references

            String realText = "The KMP algorithm avoids this inefficiency by preprocessing the pattern using an auxiliary " +
                    "array called LPS (Longest Prefix Suffix). This array stores the length of the longest proper prefix " +
                    "which is also a suffix for every prefix of the pattern. When a mismatch occurs, KMP uses this information " +
                    "to shift the pattern intelligently, skipping over positions that are guaranteed not to match — " +
                    "instead of starting over. This ensures that each character in the text is compared at most once, " +
                    "reducing the time complexity to O(n + m). The LPS array stores, for every position in the pattern, " +
                    "the length of the longest proper prefix which is also a suffix of the substring ending at that position.\n" +
                    "It helps the KMP algorithm determine how much to shift the pattern when a mismatch occurs, without " +
                    "rechecking matched characters.The value of lps[0] is always 0 because a string of length one has no " +
                    "non-empty proper prefix that is also a suffix. We maintain a variable len, initialized to 0, which " +
                    "keeps track of the length of the previous longest prefix suffix. As we traverse the pattern from " +
                    "index 1 onward, we compare the current character pat[i] with pat[len]. Based on this comparison, we " +
                    "have three possible cases.";

            saveToFile(realText,"realText.txt");


            String medium = realText.repeat(50);//repeats paragraph 50 times to create medium size text
            saveToFile(medium, "real_medium.txt");

            String large = realText.repeat(500);//repeats paragraph 500 times to create large size text
            saveToFile(large, "real_large.txt");

            //end real text
            //----------------------------------------------------------------------------


            //----------------------------------------------------------------------------
            //Tests repeated string of characters (tests worst case)
            String repeated = "a".repeat(100000);
            saveToFile(repeated, "repeated.txt");

            //end worst case repeated text
            //----------------------------------------------------------------------------


            //tests best case
            //----------------------------------------------------------------------------
            String bestCaseText = "abcdefghijklmnopqrstuvwxyz";//English Alphabet
            saveToFile(bestCaseText,"bestCaseText.txt");

            //end best case text
            //----------------------------------------------------------------------------


            System.out.println("Files generated.");
        }

}
