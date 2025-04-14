package ds.algo.sort;


/**
 * Sorts the array in ascending order using the QuickSort algorithm.
 * <p>
 * Time Complexity:
 * - Best and Average case: O(n log n) (occurs when the pivot divides the array roughly in half)
 * - Worst case: O(n^2) (occurs when the smallest or largest element is always chosen as pivot)
 * <p>
 * Space Complexity:
 * - O(log n) for recursive call stack (in-place algorithm, no additional data structures).
 * <p>
 * Real-World Use Cases:
 * - Efficient sorting of large datasets where average-case performance is sufficient,
 * e.g., in database query results, sorting files in-memory.
 * - Often used in systems and libraries that require in-place sorting.
 */

public class QuickSort {
    public static void main(String[] args) {
        int[] array = {10, 7, 8, 9, 1, 5};
        quickSort(array, 0, array.length - 1);
        System.out.println("Sorted array:");
        for (int num : array) {
            System.out.print(num + " ");
        }
    }

    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(array, low, high);
            quickSort(array, low, partitionIndex - 1);
            quickSort(array, partitionIndex + 1, high);
        }
    }

    private static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    }
}
