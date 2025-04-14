package ds.algo.sort;

/**
 * MergeSort is an efficient, stable, and Divide-and-Conquer based sorting algorithm.
 * <p>
 * Time complexity:
 * - Worst case: O(n log n)
 * - Average case: O(n log n)
 * - Best case: O(n log n)
 * <p>
 * Space complexity:
 * - O(n) due to the temporary arrays required for merging.
 * <p>
 * Use cases:
 * - Suitable for sorting large data sets where stability (preserving the relative order of equal elements) is important.
 * - Commonly used in external sorting algorithms to handle large data that cannot fit into memory.
 * - Preferred for linked lists since it doesn't require random access to elements.
 */
public class MergeSort {

    public static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            // Recursively sort the left and right halves
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);

            // Merge the sorted halves
            merge(array, left, mid, right);
        }
    }

    private static void merge(int[] array, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        // Copy data to temporary arrays
        for (int i = 0; i < n1; i++) {
            leftArray[i] = array[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArray[j] = array[mid + 1 + j];
        }

        // Merge the temporary arrays
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of leftArray if any
        while (i < n1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        // Copy remaining elements of rightArray if any
        while (j < n2) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        int[] array = {38, 27, 43, 3, 9, 82, 10};

        System.out.println("Original array:");
        for (int num : array) {
            System.out.print(num + " ");
        }

        mergeSort(array, 0, array.length - 1);

        System.out.println("\n\nSorted array:");
        for (int num : array) {
            System.out.print(num + " ");
        }
    }
}
