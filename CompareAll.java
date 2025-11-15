package com.algorithms;
import java.nio.file.*;
import java.io.IOException;

public class CompareAll {
    public static void main(String[] args) throws IOException {
        //algorithm name

        String KMP = "KMP";
        String RK = "Rabin-Karp";
        String BM = "Boyer-Moore";

        //end algorithm name


        //pattern strings
        String patternBest = "xyz";//tests performance best case

        String patternReal = "the";//this is the pattern that tests real world text

        String patternRand = "abcab";//this is the pattern that tests randomized text

        String patternRepSm = "a".repeat(5-1)+"b";//this is the pattern that tests worst case (small pattern size of 5)

        String patternRepMd = "a".repeat(50-1)+"b";//(medium size pattern = 50) (worst case)

        //String patternRepLg = "a".repeat(500-1)+"b";//(large size pattern = 500) (worst case)

        //end of pattern strings



        // Load data
        String textBest = Files.readString(Path.of("bestCaseText.txt"));//best case text file (English alphabet)

        String textReal = Files.readString(Path.of("realText.txt"));//real world (article) text file

        String textRandom = Files.readString(Path.of("random.txt"));//random text file

        String textRepeated = Files.readString(Path.of("repeated.txt"));//repeated text file

        String textRealMedium = Files.readString(Path.of("real_medium.txt"));//article text file (medium size)

        String textRealLarge = Files.readString(Path.of("real_large.txt"));//article text file (large size)

        //end load data



        // Start run tests
        System.out.println("-----Comparing All Algorithms-----");
        System.out.println();

        //testing best case scenario text
        System.out.println("------------------------------------------");
        System.out.println("Best Case Scenario Data:");
        System.out.println("Pattern test = 'xyz'");
        System.out.println("Text Pattern = 'abcdefghijklmnopqrstuvwxyz");

        System.out.println("\nKMP:");
        testKMP(KMP,textBest, patternBest, "Exact Pattern Match");

        System.out.println("\nRabin-Karp:");
        testRK(RK,textBest, patternBest, "Exact Pattern Match");

        System.out.println("\nBoyer-Moore:");
        testBM(BM,textBest, patternBest, "Exact Pattern Match");
        System.out.println("------------------------------------------");
        //end testing best case scenario test


        //testing avg case scenario (Real (article)) text
        System.out.println("------------------------------------------");
        System.out.println("Average Case Scenario Data (Real text (article)):");
        System.out.println("Pattern test = 'the'");
        System.out.println("Text Pattern = article paragraph");

        System.out.println("\nKMP:");
        testKMP(KMP,textReal, patternReal, "Real text pattern (1 paragraph)");

        System.out.println("\nRabin-Karp:");
        testRK(RK,textReal, patternReal, "Real text pattern (1 paragraph)");

        System.out.println("\nBoyer-Moore:");
        testBM(BM,textReal, patternReal, "Real text pattern (1 paragraph)");
        //test(textRealMedium, patternReal, "Real text pattern (50 paragraphs)");
        //test(textRealLarge, patternReal, "Real text pattern (500 paragraphs)");
        System.out.println("------------------------------------------");
        //end testing avg case scenario (Real (article)) text


        //testing worst case scenario repeated text
        System.out.println("------------------------------------------");
        System.out.println("Worst Case Scenario Data (Repeated Text):");
        System.out.println("Pattern test = 'aaaab'");
        System.out.println("Text Pattern = 'a' character repeated * 100,000");

        System.out.println("\nKMP:");
        testKMP(KMP,textRepeated, patternRepMd, "Repeated Text (small size: a.repeat(50-1)+b) ");

        System.out.println("\nRabin-Karp:");
        testRK(RK,textRepeated, patternRepMd, "Repeated Text (small size: a.repeat(50-1)+b) ");

        System.out.println("\nBoyer-Moore:");
        testBM(BM,textRepeated, patternRepMd, "Repeated Text (small size: a.repeat(50-1)+b) ");
        System.out.println("------------------------------------------");
        //end testing worst case scenario repeated text
    }

    private static void testKMP(String algorithm, String text, String pattern, String type) {
        long start = System.nanoTime();
        int index = KMP.KMPSearch(text, pattern);//Call KMP search method
        long end = System.nanoTime();

        System.out.println("---------");
        //System.out.println("\nData Type: "+type);
        System.out.println("Results: "+index);
        System.out.println("Total Time: "+(end-start));
        System.out.println("---------");

    }

    private static void testRK(String algorithm, String text, String pattern, String type) {
        long start = System.nanoTime();
        int index = RabinKarp.search(text, pattern);//Call Rabin-Karp search method
        long end = System.nanoTime();

        System.out.println("---------");
        //System.out.println("\nData Type: "+type);
        System.out.println("Results: "+index);
        System.out.println("Total Time: "+(end-start));
        System.out.println("---------");

    }

    private static void testBM(String algorithm, String text, String pattern, String type) {
        long start = System.nanoTime();
        int index = BoyerMoore.search(text, pattern);//Call Boyer-Moore search method
        long end = System.nanoTime();

        System.out.println("---------");
        //System.out.println("\nData Type: "+type);
        System.out.println("Results: "+index);
        System.out.println("Total Time: "+(end-start));
        System.out.println("---------");

    }
}
