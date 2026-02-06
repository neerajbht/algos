package tree;

import java.util.Stack;

public class KthSmallest {
    /**
     * this is O(N) time and O(N) space
     * using iterative inorder traversal
     * 
     * Initialize an empty stack and set curr = root.
     * While either stack is not empty or curr is not null:
     * Push all left nodes into the stack (curr = curr.left).
     * Pop from the stack - this is the next smallest node.
     * Decrement k. If k == 0, return that node's value.
     * Move to the right subtree (curr = curr.right).
     * The popped k-th node is the answer.
     */
    public int ksmall(TreeNode root, int k) {

        Stack<TreeNode> stack = new Stack<>();

        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            {
                while (cur != null) {
                    cur = cur.left;

                }
                cur = stack.pop();
                k--;
                if (k == 0) {
                    // this is Kth smallest
                    return cur.val;
                }

                cur = cur.right;

            }

        }

        return -1;
    }

    /**
     * 5. Morris Traversal
     * norder traversal of a BST gives values in sorted order, so the k-th visited
     * node is the k-th smallest.
     * But recursion and stacks use extra space.
     * 
     * Morris Traversal allows us to perform inorder traversal using O(1) extra
     * space, by temporarily creating
     * a "thread" (a right pointer) from a node's predecessor back to the node.
     * 
     * For each node:
     * 
     * If it has no left child - visit it directly.
     * If it has a left child - find its inorder predecessor.
     * If the predecessor's right pointer is empty - create a temporary link to the
     * current node and move left.
     * If the predecessor's right pointer already points to the current node -
     * remove the link, visit the node, and move right.
     * We decrement k each time we "visit" a node.
     * The node where k becomes 0 is the k-th smallest.
     * 
     * This works because we simulate the inorder order without extra memory.
     * 
     * Set curr = root.
     * While curr is not null:
     * Case 1: No left child
     * Visit curr (decrement k).
     * If k == 0, return curr.val.
     * Move to curr.right.
     * Case 2: Has a left child
     * Find the inorder predecessor (pred = rightmost node in left subtree).
     * If pred.right is null:
     * Create a temporary thread: pred.right = curr.
     * Move curr to its left child.
     * Else (thread already exists):
     * Remove the thread: pred.right = null.
     * Visit curr (decrement k).
     * If k == 0, return curr.val.
     * Move to curr.right.
     * If traversal ends without finding k nodes, return -1.
     * 
     */

    public int ksmallestMorris(TreeNode root, int k) {
        TreeNode curr = root;

        while (curr != null) {
            // Case 1: No left child
            /**
             * Visit curr (decrement k).
             * If k == 0, return curr.val.
             * Move to curr.right.
             * 
             */
            if (curr.left == null) {
                k--;
                if (k == 0)
                    return curr.val;
                curr = curr.right;
            } else {
                // Case 2: Has a left child

                TreeNode pred = curr.left;
                // * Find the inorder predecessor (pred = rightmost node in left subtree).
                while (pred.right != null && pred.right != curr)
                    pred = pred.right;
                // * If pred.right is null:
                if (pred.right == null) {
                    // * Create a temporary thread: pred.right = curr.
                    // * Move curr to its left child.
                    pred.right = curr;
                    curr = curr.left;
                } else {
                    // * Else (thread already exists):
                    /*
                     * Remove the thread: pred.right = null.
                     * Visit curr (decrement k).
                     * If k == 0, return curr.val.
                     * Move to curr.right.
                     * 
                     */
                    pred.right = null;
                    k--;
                    if (k == 0)
                        return curr.val;
                    curr = curr.right;
                }
            }
        }
        // If traversal ends without finding k nodes, return -1.

        return -1;
    }

}
