package leetcode;

import java.util.LinkedList;
import java.util.Queue;
//TreeNode is in source folder  

public class InvertBSTTree {

    public TreeNode invertTreeRec(TreeNode root) {
        if (root == null)
            return null;

        TreeNode right = invertTreeRec(root.right);
        TreeNode left = invertTreeRec(root.left);
        root.left = right;
        root.right = left;
        return root;

    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            TreeNode temp = current.left;
            current.left = current.right;
            current.right = temp;
            if (current.left != null)
                queue.add(current.left);
            if (current.right != null)
                queue.add(current.right);
        }
        return root;
    }

}
