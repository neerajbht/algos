package tree;

import java.util.ArrayList;
import java.util.List;

public class BST {

    public boolean search(TreeNode root, int target) {
        if (root == null)
            return false;

        if (target > root.val) {
            return search(root.right, target);
        } else if (target < root.val) {
            return search(root.left, target);
        } else {
            return true;
        }

    }

    /** consider no duplicates */
    public TreeNode searchNode(TreeNode root, int target) {
        if (root == null)
            return null;

        if (target > root.val) {
            return searchNode(root.right, target);
        } else if (target < root.val) {
            return searchNode(root.left, target);
        } else {
            return root;
        }

    }

    public List<Integer> nodeTraversal(TreeNode root, int target) {

        TreeNode node = this.searchNode(root, target);
        List<Integer> child = new ArrayList<>();
        if (node != null) {
            child = this.getChild(node, child);
        }
        return child;

    }

    public List<Integer> getChild(TreeNode node, List<Integer> child) {
        if (node == null)
            return null;
        child.add(node.val);
        getChild(node.left, child);
        getChild(node.right, child);
        return child;

    }

    public TreeNode addNode(TreeNode root, int val) {

        if (root == null)
            return new TreeNode(val);

        if (val < root.val) {
            root.left = addNode(root.left, val);
        } else if (val > root.val) {
            root.right = addNode(root.right, val);
        }
        return root;
    }

    public TreeNode min(TreeNode root) {
        if (root == null)
            return null;
        TreeNode temp = root;
        /// iteratively traverse
        while (temp != null && temp.left != null) {
            temp = temp.left;
        }
        return temp;

    }

    public TreeNode removeNode(TreeNode root, int data) {
        if (root == null)
            return null;

        if (data < root.val) {
            root.left = removeNode(root.left, data);
        } else if (data > root.val) {
            root.right = removeNode((root.right), data);
        } else {
            /**
             * case where node has left and right child
             * check left node
             */

            // if no left child present
            if (root.left == null) {
                // we have to remove root.data wihout any left node
                // so riht node becomes root
                return root.right;

            } else if (root.right == null) {
                // same as above clase
                return root.left;
            } else {
                // case where root has both left node and right node
                /** 1 so we get min Node from right node */
                TreeNode min = this.min(root.right);
                // 2 update root with min node
                root.val = min.val;
                // 3 repalace the min node in step 1 above with its minmimumm down the line
                root.right = removeNode(root.right, min.val);

            }
        }
        return root;

    }

}
