package com.algorithms;

public class BoyerMoore {
    //Only using the bad character heuristic
    private final static int size = 256; // ASCII characters

    // Boyer–Moore algorithm search function
    public static int search(String text, String pattern) {
        int n = text.length();//length of text
        int m = pattern.length();//length of pattern

        // Creates the bad character table (array)
        int[] badChar = createBadCharTable(pattern);

        int shift = 0; // How far left the pattern is shifted on text
        while (shift <= (n - m)) {
            int j = m - 1;  //Boyer-Moore compares from right to left.


            while (j >= 0 && pattern.charAt(j) == text.charAt(shift + j)) {
                j--;

                //while the characters match keep moving j towards the left
                //stop if characters don't match
                //or if j = -1
            }

            // If we reached -1, pattern found
            if (j < 0) {
                return shift; // Pattern found at index = shift
            }

            else {

                //when mismatch happens:
                // Shift pattern according to the bad character rule

                //j = index in pattern where mismatch occurred
                //badChar = last place mismatched character appears in bad character table
                //text.charAt(shift + j)] = the mismatched character
                //Math.max ensures that we always move one step
                shift += Math.max(1, j - badChar[text.charAt(shift + j)]);
            }
        }

        return -1; // If pattern not found at all return -1
    }



    // Builds the bad character table of size 256
    private static int[] createBadCharTable(String pattern) {
        int[] badChar = new int[size];

        // Initialize all occurrences as -1
        //if the character doesn't appear at all in pattern then it stays at -1
        for (int i = 0; i < size; i++) {
            badChar[i] = -1;
        }

        // Fill actual value of last occurrence for each character
        for (int i = 0; i < pattern.length(); i++) {
            badChar[pattern.charAt(i)] = i;
        }

        return badChar;
    }
}
