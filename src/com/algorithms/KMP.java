package com.algorithms;

public class KMP {
    //What suffix means
    //For example say we have pattern: abcdabc
    //Prefix(characters starting from right side): a, ab, abc, abcd, abcda, abcdab, abcdabc
    //Suffix(characters starting from left side of pattern): c, bc, abc, dabc, cdabc, bcdabc, abcdabc
    //comparing if suffix and prefix match anywhere





    // Build the LPS (Longest Prefix Suffix) array
    private static int[] createLPS(String pattern) {
        int m = pattern.length();
        int[] lps = new int[m];//an array of size m, which is the length of the pattern
        int len = 0; // length of the previous longest prefix suffix
        //also keeps track of how many characters of the prefix matched so far

        int i = 1;//current character index being checked since lps[0] is always 0

        //i is = to the current index being checked
        //m is the length of the pattern
        //while (i<m) is to make sure we check through the entire pattern
        while (i < m) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                //if current character matches pattern
                len++;//then extend prefix suffix length
                lps[i] = len;//record this in the array
                i++;//move onto the next character
            } else {//if there is a mismatch
                if (len != 0) {
                    len = lps[len - 1];//fall back to smaller prefix
                    //to avoid rechecking characters
                } else {
                    //if we are already at 0, then ,move forward within the text string and check from the beginning
                    //of pattern string
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

    // KMP search function
    public static int KMPSearch(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();
        int[] lps = createLPS(pattern);

        int i = 0; // index for text
        int j = 0; // index for pattern

        while (i < n) {//loop through text
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
                //if both characters match move both pointers forward
            }

            if (j == m) {//if a full match is found
                return i - j; // match found at index i-j
                //return the starting index in the text where the pattern was found

            } else if (i < n && text.charAt(i) != pattern.charAt(j)) {//if mismatch occurs
                if (j != 0) {
                    j = lps[j - 1];
                    //moves back to previous partial match
                } else {
                    i++;
                }
            }
        }
        return -1; // not found
    }
}


    /*
    //initial testing
    public static void main(String[] args) {
        String text = "ABABDABACDABABCABAB";
        String pattern = "ABABCABAB";

        long startTime = System.nanoTime();
        int result = KMPSearch(text, pattern);
        long endTime = System.nanoTime();

        if (result != -1)
            System.out.println("Pattern found at index: " + result);
        else
            System.out.println("Pattern not found.");

        System.out.println("Execution time (ns): " + (endTime - startTime));
    }

     */
