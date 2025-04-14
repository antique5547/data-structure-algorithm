package ds.algo.sort;

/**
 * Bubble Sort Algorithm
 * <p>
 * Time Complexity:
 * - Best Case: O(n) [when the array is already sorted]
 * - Average Case: O(n^2)
 * - Worst Case: O(n^2)
 * <p>
 * Space Complexity:
 * - O(1) [only a constant amount of space is required]
 * <p>
 * Use Cases:
 * - Best suited for small datasets or when the input is nearly sorted.
 * - Not recommended for large datasets due to its inefficiency compared to other sorting algorithms like Quick Sort or Merge Sort.
 */
public class BubbleSort {

    public static void bubbleSort(int[] array) {
        int n = array.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    // Swap adjacent elements if they are in the wrong order
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }
            // If no two elements were swapped in the inner loop, the array is sorted
            if (!swapped) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {64, 34, 25, 12, 22, 11, 90};

        System.out.println("Original array:");
        for (int num : array) {
            System.out.print(num + " ");
        }

        bubbleSort(array);

        System.out.println("\n\nSorted array:");
        for (int num : array) {
            System.out.print(num + " ");
        }
    }
}
