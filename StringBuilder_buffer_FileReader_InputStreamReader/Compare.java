package StringBuilder_buffer_FileReader_InputStreamReader;

import java.io.*;
import java.util.Scanner;

public class Compare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // StringBuilder vs StringBuffer ---

        String text = "hello";
        int times = 1000000;

        // Using StringBuilder
        StringBuilder sb = new StringBuilder();
        long startSB = System.nanoTime();
        for (int i = 0; i < times; i++) {
            sb.append(text);
        }
        long endSB = System.nanoTime();
        long timeSB = endSB - startSB;

        // Using StringBuffer
        StringBuffer sbuf = new StringBuffer();
        long startSBuf = System.nanoTime();
        for (int i = 0; i < times; i++) {
            sbuf.append(text);
        }
        long endSBuf = System.nanoTime();
        long timeSBuf = endSBuf - startSBuf;

        System.out.println("\n--- String Concatenation Comparison ---");
        System.out.println("StringBuilder time: " + (timeSB / 1_000_000.0) + " ms");
        System.out.println("StringBuffer time: " + (timeSBuf / 1_000_000.0) + " ms");

        // FileReader vs InputStreamReader ---

        System.out.print("\nEnter large file name (e.g., bigfile.txt): ");
        String fileName = sc.nextLine();

        // Using FileReader
        long startFR = System.nanoTime();
        int wordCountFR = countWordsUsingFileReader(fileName);
        long endFR = System.nanoTime();
        long timeFR = endFR - startFR;

        // Using InputStreamReader
        long startISR = System.nanoTime();
        int wordCountISR = countWordsUsingInputStreamReader(fileName);
        long endISR = System.nanoTime();
        long timeISR = endISR - startISR;

        System.out.println("\n--- File Reading and Word Count ---");
        System.out.println("FileReader word count: " + wordCountFR + ", Time: " + (timeFR / 1_000_000.0) + " ms");
        System.out.println(
                "InputStreamReader word count: " + wordCountISR + ", Time: " + (timeISR / 1_000_000.0) + " ms");

        sc.close();
    }

    // Helper method to count words using FileReader
    public static int countWordsUsingFileReader(String fileName) {
        int count = 0;
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.trim().split("\\s+");
                count += words.length;
            }
            br.close();
        } catch (Exception e) {
            System.out.println("Error in FileReader: " + e.getMessage());
        }
        return count;
    }

    // Helper method to count words using InputStreamReader
    public static int countWordsUsingInputStreamReader(String fileName) {
        int count = 0;
        try {
            FileInputStream fis = new FileInputStream(fileName);
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            BufferedReader br = new BufferedReader(isr);
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.trim().split("\\s+");
                count += words.length;
            }
            br.close();
        } catch (Exception e) {
            System.out.println("Error in InputStreamReader: " + e.getMessage());
        }
        return count;
    }
}

// Challenge Problem: Compare StringBuilder, StringBuffer, FileReader, and
// InputStreamReader
// Problem:
// Write a program that:
// Uses StringBuilder and StringBuffer to concatenate a list of strings
// 1,000,000 times.
// Uses FileReader and InputStreamReader to read a large file (e.g., 100MB) and
// print the number of words in the file.
// Approach:
// StringBuilder and StringBuffer:
// Create a list of strings (e.g., "hello").
// Concatenate the strings 1,000,000 times using both StringBuilder and
// StringBuffer.
// Measure and compare the time taken for each.
// FileReader and InputStreamReader:
// Read a large text file (100MB) using FileReader and InputStreamReader.
// Count the number of words by splitting the text on whitespace characters.
// Print the word count and compare the time taken for reading the file.
