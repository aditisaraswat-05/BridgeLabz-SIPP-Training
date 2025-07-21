package Workshop;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = { 1, 4, 6, 12, 23, 45, 78 };
        int target = 45;

        int start = 0;
        int end = arr.length - 1;
        boolean found = false;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (arr[mid] == target) {
                System.out.println("Target " + target + " found at index " + mid);
                found = true;
                break;
            } else if (arr[mid] < target) {
                start = mid + 1; // Move to right
            } else {
                end = mid - 1; // Move to left
            }
        }

        if (!found) {
            System.out.println("Target " + target + " not found in the array.");
        }
    }
}

// 1,4,6,12,23,45,78
// Target Value:45
// 1- Firstly I want to find the mid and then check from the targeted values.
// 2- if the target value is greater than from the mid value then move to the
// right node otherwise we move to the left node if the mid value is smaller
// than the targeted value