package AlgoRunTimeAnalysis;

public class StringConcatenationPerformance {

    // Function to test using String
    public static void usingString(int count) {
        long start = System.currentTimeMillis();
        String result = "";

        for (int i = 0; i < count; i++) {
            result += "a";
        }

        long end = System.currentTimeMillis();
        System.out.println("String Time for " + count + ": " + (end - start) + " ms");
    }

    // Function to test using StringBuilder
    public static void usingStringBuilder(int count) {
        long start = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < count; i++) {
            sb.append("a");
        }

        long end = System.currentTimeMillis();
        System.out.println("StringBuilder Time for " + count + ": " + (end - start) + " ms");
    }

    // Function to test using StringBuffer
    public static void usingStringBuffer(int count) {
        long start = System.currentTimeMillis();
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < count; i++) {
            sb.append("a");
        }

        long end = System.currentTimeMillis();
        System.out.println("StringBuffer Time for " + count + ": " + (end - start) + " ms");
    }

    public static void main(String[] args) {

        int[] sizes = { 1000, 10000, 1000000 };

        for (int size : sizes) {
            System.out.println("\n--- Testing with " + size + " operations ---");
            usingString(size);
            usingStringBuilder(size);
            usingStringBuffer(size);
        }
    }
}

// 3. Problem Statement: String Concatenation Performance
// Objective:
// Compare the performance of String (O(N²)), StringBuilder (O(N)), and
// StringBuffer (O(N)) when concatenating a million strings.
// Approach:
// Using String (Immutable, creates new object each time)
// Using StringBuilder (Fast, mutable, thread-unsafe)
// Using StringBuffer (Thread-safe, slightly slower than StringBuilder)
// Expected Result:
// StringBuilder & StringBuffer are much more efficient than String.
// Use StringBuilder for single-threaded operations and StringBuffer for
// multi-threaded.