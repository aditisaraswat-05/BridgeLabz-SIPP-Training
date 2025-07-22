package StringBuilder_buffer_FileReader_InputStreamReader;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class ReadFile {
    public static void main(String[] args) {
        try {
            // Create FileReader and wrap it with BufferedReader
            FileReader fr = new FileReader("sample.txt");
            BufferedReader br = new BufferedReader(fr);

            String line;
            // Read each line until end of file
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            // Close the file
            br.close();
            fr.close();

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}

// FileReader Problem 1: Read a File Line by Line Using FileReader
// Problem:
// Write a program that uses FileReader to read a text file line by line and
// print each line to the console.
// Approach:
// Create a FileReader object to read from the file.
// Wrap the FileReader in a BufferedReader to read lines efficiently.
// Use a loop to read each line using the readLine() method and print it to the
// console.
// Close the file after reading all the lines.
