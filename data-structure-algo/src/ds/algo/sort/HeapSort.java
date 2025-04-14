package ds.algo.sort;

/**
 * HeapSort Algorithm
 * <p>
 * HeapSort is a comparison-based sorting algorithm that uses a binary heap data structure.
 * It leverages the max heap property to repeatedly extract the maximum element and reduce the heap size,
 * effectively sorting the array in-place.
 * <p>
 * Steps:
 * 1. Build a max heap from the input array.
 * 2. Swap the largest element (root of the heap) with the last element of the heap.
 * 3. Reduce the heap size and heapify to restore the max heap property.
 * 4. Repeat steps 2-3 for the remaining elements.
 * <p>
 * Time Complexity:
 * - Building the max heap: O(n).
 * - Extracting elements and heapifying: O(n log n) (heapify is called log n times for each of n elements).
 * - Overall: O(n log n).
 * <p>
 * Space Complexity:
 * - O(1) as heap sort is an in-place sorting algorithm.
 * <p>
 * Use Cases:
 * - Suitable for cases where O(n log n) complexity is acceptable but additional memory usage (like in merge sort) is undesirable.
 * - Widely used in embedded systems with memory constraints.
 */
public class HeapSort {
    public static void heapSort(int[] array) {
        int n = array.length;

        // Build max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i);
        }

        // One by one extract elements from the heap
        for (int i = n - 1; i > 0; i--) {
            // Move current root to the end
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            // Apply heapify to the reduced heap
            heapify(array, i, 0);
        }
    }

    private static void heapify(int[] array, int n, int i) {
        int largest = i; // Initialize largest as root
        int left = 2 * i + 1; // Left child
        int right = 2 * i + 2; // Right child

        // Check if left child is larger than the root
        if (left < n && array[left] > array[largest]) {
            largest = left;
        }

        // Check if right child is larger than the largest so far
        if (right < n && array[right] > array[largest]) {
            largest = right;
        }

        // Swap and continue heapifying if the root is not the largest
        if (largest != i) {
            int swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(array, n, largest);
        }
    }

    public static void main(String[] args) {
        int[] array = {12, 11, 13, 5, 6, 7};

        System.out.println("Original array:");
        for (int num : array) {
            System.out.print(num + " ");
        }

        heapSort(array);

        System.out.println("\n\nSorted array:");
        for (int num : array) {
            System.out.print(num + " ");
        }
    }
}
