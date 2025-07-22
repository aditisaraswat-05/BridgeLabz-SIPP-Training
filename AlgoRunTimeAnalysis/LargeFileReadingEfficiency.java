package AlgoRunTimeAnalysis;

import java.io.*;

public class LargeFileReadingEfficiency {

    public static void readUsingFileReader(String filePath) {
        long start = System.currentTimeMillis();

        try {
            FileReader reader = new FileReader(filePath);
            while (reader.read() != -1) {

            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error reading file with FileReader: " + e.getMessage());
        }

        long end = System.currentTimeMillis();
        System.out.println("FileReader Time: " + (end - start) + " ms");
    }

    public static void readUsingInputStreamReader(String filePath) {
        long start = System.currentTimeMillis();

        try {
            InputStream input = new FileInputStream(filePath);
            InputStreamReader reader = new InputStreamReader(input);
            while (reader.read() != -1) {

            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error reading file with InputStreamReader: " + e.getMessage());
        }

        long end = System.currentTimeMillis();
        System.out.println("InputStreamReader Time: " + (end - start) + " ms");
    }

    public static void main(String[] args) {
        String filePath = "largefile.txt";

        System.out.println("Reading file: " + filePath);
        readUsingFileReader(filePath);
        readUsingInputStreamReader(filePath);
    }
}

// Objective:
// Compare FileReader (Character Stream) and InputStreamReader (Byte Stream)
// when reading a large file (500MB).
// Approach:
// FileReader: Reads character by character (slower for binary files).
// InputStreamReader: Reads bytes and converts to characters (more efficient).
// Expected Result:
// InputStreamReader is more efficient for large files.
// FileReader is preferable for text-based data.
