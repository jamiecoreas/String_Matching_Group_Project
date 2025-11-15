package com.algorithms;

public class RabinKarp {
    // Prime number to reduce collisions in hash
    private final static int prime = 101;

    // Rabin-Karp Search Function
    public static int search(String text, String pattern) {
        int n = text.length();//length of text
        int m = pattern.length();//length of pattern

        long patternHash = createHash(pattern, m);//turn pattern into number
        long textHash = createHash(text, m);//hashes characters in text that are of m length (pattern length)



        for (int i = 0; i <= n - m; i++) {//slide pattern sized window over text
            // In the case that the hashes match, check the substring for confirmation
            if (patternHash == textHash && checkEqual(text, i, i + m - 1, pattern, 0, m - 1)) {
                return i; // Pattern found
            }

            // Slide the window — recompute rolling hash
            if (i < n - m) {
                textHash = recalculateHash(text, i, i + m, textHash, m);
            }
        }

        return -1; // Not found
    }

    // Create initial hash for substring
    private static long createHash(String str, int len) {
        long hash = 0;
        for (int i = 0; i < len; i++) {
            hash += str.charAt(i) * Math.pow(prime, i);
        }
        return hash;
    }

    // Recalculate hash when sliding the window
    private static long recalculateHash(String str, int oldIndex, int newIndex, long oldHash, int patternLen) {
        long newHash = oldHash - str.charAt(oldIndex);
        newHash /= prime;
        newHash += str.charAt(newIndex) * Math.pow(prime, patternLen - 1);
        return newHash;
    }

    // Check actual characters (in case of hash collision (false positive match))
    private static boolean checkEqual(String str1, int start1, int end1, String str2, int start2, int end2) {
        while (start1 <= end1 && start2 <= end2) {
            if (str1.charAt(start1) != str2.charAt(start2)) {
                return false;
            }
            start1++;
            start2++;
        }
        return true;
    }

}
