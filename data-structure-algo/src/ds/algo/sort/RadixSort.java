package ds.algo.sort;

/**
 * Radix Sort Algorithm:
 * ---------------------
 * Radix Sort is a non-comparative sorting algorithm that works by processing
 * individual digits of the numbers starting from the least significant digit (LSD)
 * to the most significant digit (MSD). It uses counting sort as a subroutine to sort
 * elements based on each digit.
 * <p>
 * Steps:
 * 1. Find the maximum number in the array to determine the number of digits (d).
 * 2. Starting from the least significant digit, use counting sort to sort the array
 * at each digit level.
 * 3. Repeat until all significant digits are processed.
 * <p>
 * Time Complexity: O(n * d) where:
 * - n is the number of elements in the array.
 * - d is the maximum number of digits in the largest element.
 * <p>
 * Space Complexity: O(n + k) where k is the base (10 for decimal numbers).
 */
public class RadixSort {

    /**
     * Performs Radix Sort on the given array.
     *
     * @param array The input array to be sorted.
     */
    public static void radixSort(int[] array) {
        int max = getMax(array); // Find the maximum number to determine the number of digits
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(array, exp); // Perform counting sort for each digit
        }
    }

    /**
     * Finds the maximum value in the array.
     *
     * @param array The input array.
     * @return The maximum value.
     */
    private static int getMax(int[] array) {
        int max = array[0];
        for (int num : array) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    /**
     * Performs Counting Sort based on the digit represented by exp.
     *
     * @param array The input array.
     * @param exp   The digit's place value to sort with (1, 10, 100, etc.).
     */
    private static void countingSort(int[] array, int exp) {
        int length = array.length;
        int[] output = new int[length]; // Output array for sorted values
        int[] count = new int[10]; // Count array for digits (0-9)

        // Count occurrences of each digit in the exp place
        for (int num : array) {
            count[(num / exp) % 10]++;
        }

        // Update count[] to contain positions of digits in output[]
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Build the output array in stable sorted order
        for (int i = length - 1; i >= 0; i--) {
            int digit = (array[i] / exp) % 10;
            output[count[digit] - 1] = array[i];
            count[digit]--;
        }

        // Copy the sorted values back into the original array
        for (int i = 0; i < length; i++) {
            array[i] = output[i];
        }
    }

    /**
     * Main method to demonstrate the Radix Sort with an example.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        int[] array = {170, 45, 75, 90, 802, 24, 2, 66};

        System.out.println("Original array:");
        for (int num : array) {
            System.out.print(num + " ");
        }

        radixSort(array);

        System.out.println("\n\nSorted array:");
        for (int num : array) {
            System.out.print(num + " ");
        }
    }
}
