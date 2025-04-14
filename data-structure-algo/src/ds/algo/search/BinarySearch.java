package ds.algo.search;

public class BinarySearch {

    public static int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (array[mid] == target) {
                return mid; // Target found
            }

            if (array[mid] < target) {
                left = mid + 1; // Search the right half
            } else {
                right = mid - 1; // Search the left half
            }
        }

        return -1; // Target not found
    }

    public static void main(String[] args) {
        int[] array = {1, 3, 5, 7, 9, 11, 13}; // Example sorted array
        int target = 7; // Example target value
        int result = binarySearch(array, target); // Perform binary search
        System.out.println("Target found at index: " + result); // Display result
    }
}
