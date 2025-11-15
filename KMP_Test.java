package com.algorithms;
import java.nio.file.*;
import java.io.IOException;

public class KMP_Test {
    public static void main(String[] args) throws IOException {
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
        System.out.println("-----KMP Algorithm Demo-----");
        System.out.println();

        //testing best case scenario text
        System.out.println("------------------------------------------");
        System.out.println("Best Case Scenario Data:");
        System.out.println("Pattern test = 'xyz'");
        System.out.println("Text Pattern = 'abcdefghijklmnopqrstuvwxyz");

        test(textBest, patternBest, "Exact Pattern Match");
        System.out.println("------------------------------------------");
        //end testing best case scenario test


        //testing avg case scenario (Real (article)) text
        System.out.println("------------------------------------------");
        System.out.println("Average Case Scenario Data (Real text (article)):");
        System.out.println("Pattern test = 'the'");
        System.out.println("Text Pattern = article paragraph");

        test(textReal, patternReal, "Real text pattern (1 paragraph)");
        //test(textRealMedium, patternReal, "Real text pattern (50 paragraphs)");
        //test(textRealLarge, patternReal, "Real text pattern (500 paragraphs)");
        System.out.println("------------------------------------------");
        //end testing avg case scenario (Real (article)) text


        //testing avg case scenario random text
        System.out.println("------------------------------------------");
        System.out.println("Average Case Scenario Data (Random Text):");
        System.out.println("Pattern test = 'abcab'");
        System.out.println("Text Pattern = randomized text");

        test(textRandom, patternRand, "Random Text");

        System.out.println("------------------------------------------");
        //end testing avg case scenario random text



        //testing worst case scenario repeated text
        System.out.println("------------------------------------------");
        System.out.println("Worst Case Scenario Data (Repeated Text):");
        System.out.println("Pattern test = 'aaaab'");
        System.out.println("Text Pattern = 'a' character repeated * 100,000");

        test(textRepeated, patternRepSm, "Repeated Text (small size: a.repeat(5-1)+b) ");
        test(textRepeated, patternRepMd, "Repeated Text (small size: a.repeat(50-1)+b) ");
        System.out.println("------------------------------------------");
        //end testing worst case scenario repeated text
    }

    private static void test(String text, String pattern, String type) {
        long start = System.nanoTime();
        int index = KMP.KMPSearch(text, pattern);//Call KMP search method
        long end = System.nanoTime();

        System.out.println("---------");
        System.out.println("\nData Type: "+type);
        System.out.println("Results: "+index);
        System.out.println("Total Time: "+(end-start));
        System.out.println("---------");

    }
}
