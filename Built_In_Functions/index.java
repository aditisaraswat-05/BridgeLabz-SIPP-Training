package Built_In_Functions;

public class index {
    public static void main(String[] args) {
        int arr[] = { 34, 4, 6, 11, -77, 23, 98, 76 };
        int large = arr[0];
        int small = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > large) {
                large = arr[i];
            } else if (arr[i] < small) {
                small = arr[i];
            }

        }
        System.out.println(large);
        System.out.println(small);
    }
}

// 34,4,6,11,-77,23,98,76-find largest and smallest number