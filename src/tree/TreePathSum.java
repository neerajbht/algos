package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreePathSum {

    /**
     * check if sum exists in Treepath
     * 
     */

    public boolean hasSum(TreeNode root, int targetSum) {

        return checkSum(root, 0, targetSum);

    }

    private boolean checkSum(TreeNode node, int cur, int target) {

        if (node == null)
            return false;
        // compute sum
        cur += target;
        // if its leaf node varify if sum matches
        if (node.left == null && node.right == null) {
            return cur == target;
        }
        return checkSum(node.left, cur, target) ||
                checkSum(node.right, cur, target);
    }

    // iterative approach using stack .. dfs
    public boolean hasPathSumDFS(TreeNode root, int targetSum) {
        if (root == null)
            return false;

        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> sumStack = new Stack<>();
        stack.push(root);
        sumStack.push(targetSum - root.val);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            int currSum = sumStack.pop();

            if (node.left == null && node.right == null && currSum == 0) {
                return true;
            }

            if (node.right != null) {
                stack.push(node.right);
                sumStack.push(currSum - node.right.val);
            }

            if (node.left != null) {
                stack.push(node.left);
                sumStack.push(currSum - node.left.val);
            }
        }

        return false;
    }

    // iterative bfs
    public boolean hasPathSumBFS(TreeNode root, int targetSum) {
        if (root == null)
            return false;

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> sumQueue = new LinkedList<>();
        nodeQueue.add(root);
        sumQueue.add(targetSum - root.val);

        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            int currSum = sumQueue.poll();

            if (node.left == null && node.right == null && currSum == 0) {
                return true;
            }

            if (node.left != null) {
                nodeQueue.add(node.left);
                sumQueue.add(currSum - node.left.val);
            }

            if (node.right != null) {
                nodeQueue.add(node.right);
                sumQueue.add(currSum - node.right.val);
            }
        }

        return false;
    }

}
