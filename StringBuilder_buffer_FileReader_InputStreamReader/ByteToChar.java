package StringBuilder_buffer_FileReader_InputStreamReader;

import java.io.*;

public class ByteToChar {
    public static void main(String[] args) {
        try {
            // Read binary file
            FileInputStream fis = new FileInputStream("data.txt");

            // Convert byte stream to character stream using UTF-8
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");

            // Read characters efficiently
            BufferedReader br = new BufferedReader(isr);

            String line;

            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            // Close all readers
            br.close();
            isr.close();
            fis.close();

        } catch (Exception e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }
}

// InputStreamReader Problem 1: Convert Byte Stream to Character Stream Using
// InputStreamReader
// Problem:
// Write a program that uses InputStreamReader to read binary data from a file
// and print it as characters. The file contains data encoded in a specific
// charset (e.g., UTF-8).
// Approach:
// Create a FileInputStream object to read the binary data from the file.
// Wrap the FileInputStream in an InputStreamReader to convert the byte stream
// into a character stream.
// Use a BufferedReader to read characters efficiently from the
// InputStreamReader.
// Read the file line by line and print the characters to the console.
// Handle any encoding exceptions as needed.
