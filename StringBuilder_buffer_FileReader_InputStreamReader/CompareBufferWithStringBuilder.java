package StringBuilder_buffer_FileReader_InputStreamReader;

public class CompareBufferWithStringBuilder {
    public static void main(String[] args) {
        int count = 1000000;

        // StringBuilder
        StringBuilder builder = new StringBuilder();
        long startBuilder = System.nanoTime();
        for (int i = 0; i < count; i++) {
            builder.append("hello");
        }
        long endBuilder = System.nanoTime();
        long timeBuilder = endBuilder - startBuilder;

        // StringBuffer
        StringBuffer buffer = new StringBuffer();
        long startBuffer = System.nanoTime();
        for (int i = 0; i < count; i++) {
            buffer.append("hello");
        }
        long endBuffer = System.nanoTime();
        long timeBuffer = endBuffer - startBuffer;

        System.out.println("Time taken by StringBuilder: " + (timeBuilder / 1_000_000.0) + " ms");
        System.out.println("Time taken by StringBuffer: " + (timeBuffer / 1_000_000.0) + " ms");
    }
}

// StringBuffer Problem 2: Compare StringBuffer with StringBuilder for String
// Concatenation
// Problem:
// Write a program that compares the performance of StringBuffer and
// StringBuilder for concatenating strings. For large datasets (e.g.,
// concatenating 1 million strings), compare the execution time of both classes.
// Approach:
// Initialize two StringBuffer and StringBuilder objects.
// Perform string concatenation in both objects, appending 1 million strings
// (e.g., "hello").
// Measure the time taken to complete the concatenation using System.nanoTime()
// for both StringBuffer and StringBuilder.
// Output the time taken by both classes for comparison.
