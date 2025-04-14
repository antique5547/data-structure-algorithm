package ds.algo.tree.bst;

/**
 * The BinarySearchTree class implements a basic Binary Search Tree (BST).
 * <p>
 * Approach:
 * - Each node in the BST contains a key, and the left child contains keys less than the parent node,
 * while the right child contains keys greater than or equal to the parent node.
 * - Insertion: Traverse the tree starting from the root and place the new node in the correct position
 * based on its value.
 * - Search: Traverse the tree based on comparisons with the current node's value to either go left or right.
 * <p>
 * Example: The provided main method demonstrates insertion and search operations in the BST.
 * <p>
 *     Complexity
 *     Time Complexity: O(h), where h is the height of the tree (O(log n) for balanced trees, O(n) for skewed trees).
 *     Space Complexity: O(h) due to recursion stack space.
 * </p>
 */


public class BinarySearchTree {

    // Class representing a node in the BST
    private static class Node {
        int key;
        Node left, right;

        Node(int key) {
            this.key = key;
            left = right = null;
        }
    }

    private Node root;

    /**
     * Inserts a key into the binary search tree.
     *
     * @param key the value to be inserted into the tree
     */
    public void insert(int key) {
        root = insertRec(root, key);
    }

    private Node insertRec(Node root, int key) {
        // If the tree is empty, create a new node
        if (root == null) {
            root = new Node(key);
            return root;
        }

        // Recursively traverse the tree to find the correct position
        if (key < root.key) {
            root.left = insertRec(root.left, key);
        } else if (key >= root.key) {
            root.right = insertRec(root.right, key);
        }

        return root;
    }

    /**
     * Searches for a key in the binary search tree.
     *
     * @param key the value to search for
     * @return true if the key is found, false otherwise
     * <p>
     * Time Complexity: O(h), where h is the height of the tree (O(log n) for balanced trees, O(n) for skewed trees).
     * Space Complexity: O(h) due to recursion stack space.
     */
    public boolean search(int key) {
        return searchRec(root, key);
    }

    private boolean searchRec(Node root, int key) {
        // Base cases: root is null or key is present at root
        if (root == null) {
            return false;
        }
        if (root.key == key) {
            return true;
        }

        // Recursively search in the left or right subtree
        if (key < root.key) {
            return searchRec(root.left, key);
        } else {
            return searchRec(root.right, key);
        }
    }

    /**
     * Main method to demonstrate BST operations.
     */
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        // Insert keys into the BST
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);

        // Search for keys in the BST
        System.out.println("Is 40 present in the BST? " + bst.search(40)); // Output: true
        System.out.println("Is 25 present in the BST? " + bst.search(25)); // Output: false
    }
}
