package StringBuilder_buffer_FileReader_InputStreamReader;

import java.io.*;

public class WriteUserInputToFile {
    public static void main(String[] args) {
        try {
            // Input stream
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);

            // Output stream to file
            FileWriter writer = new FileWriter("output.txt");

            String inputLine;

            System.out.println("Type something (type 'exit' to stop):");

            while (true) {
                inputLine = br.readLine();

                // Check if user wants to stop
                if (inputLine.equalsIgnoreCase("exit")) {
                    break;
                }

                // Write the line to file
                writer.write(inputLine + "\n");
            }

            writer.close();
            br.close();
            isr.close();

            System.out.println("Input saved to output.txt");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

// InputStreamReader Problem 2: Read User Input and Write to File Using
// InputStreamReader
// Problem:
// Write a program that uses InputStreamReader to read user input from the
// console and write the input to a file. Each input should be written as a new
// line in the file.
// Approach:
// Create an InputStreamReader to read from System.in (the console).
// Wrap the InputStreamReader in a BufferedReader for efficient reading.
// Create a FileWriter to write to the file.
// Read user input using readLine() and write the input to the file.
// Repeat the process until the user enters "exit" to stop inputting.
// Close the file after the input is finished.
