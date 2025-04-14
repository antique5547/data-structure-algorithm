package ds.algo.sort;

/**
 * Implements the Selection Sort algorithm.
 * <p>
 * Time Complexity: O(n^2) in all cases (best, average, and worst) due to nested loops.
 * Space Complexity: O(1) as it sorts the array in-place.
 * <p>
 * Usage: Selection Sort is suitable for small arrays or scenarios where memory
 * usage is critical, as it does not require additional space for sorting.
 */
public class SelectionSort {

    public static void selectionSort(int[] array) {
        int n = array.length;

        // Move the boundary of unsorted subarray one by one
        for (int i = 0; i < n - 1; i++) {
            // Find the minimum element in the unsorted part
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap the found minimum element with the first element
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] array = {29, 10, 14, 37, 14};

        System.out.println("Original array:");
        for (int num : array) {
            System.out.print(num + " ");
        }

        selectionSort(array);

        System.out.println("\n\nSorted array:");
        for (int num : array) {
            System.out.print(num + " ");
        }
    }
}
