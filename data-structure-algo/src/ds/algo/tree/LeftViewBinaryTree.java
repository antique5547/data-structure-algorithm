package ds.algo.tree;

import java.util.LinkedList;
import java.util.Queue;

public class LeftViewBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        printLeftView(root);
    }

    /**
     * Prints the nodes visible from the left view of a binary tree using iteration.
     * <p>
     * Time Complexity: O(n), where n is the number of nodes in the tree
     * (each node is processed once).
     * Space Complexity: O(w), where w is the maximum width of the tree
     * (largest level size in the queue).
     */
    public static void printLeftView(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();

                // Print the first node of each level
                if (i == 0) {
                    System.out.print(current.val + " ");
                }

                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
        }
    }

    /**
     * Helper method to print the nodes visible from the left view of a binary tree using recursion.
     * <p>
     * Time Complexity: O(n), where n is the number of nodes in the tree
     * (each node is visited once).
     * Space Complexity: O(h), where h is the height of the tree
     * (due to recursive function calls on the stack).
     */
    private static void printLeftViewRecursive(TreeNode node, int level, int[] maxLevel) {
        if (node == null) {
            return;
        }
        if (level > maxLevel[0]) {
            System.out.print(node.val + " ");
            maxLevel[0] = level;
        }
        printLeftViewRecursive(node.left, level + 1, maxLevel);
        printLeftViewRecursive(node.right, level + 1, maxLevel);
    }
}



class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}
