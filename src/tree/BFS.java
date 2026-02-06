package tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/** BFS or level order traversal */
/** Refer BinarySearchTree */
public class BFS {

    public void bfs(TreeNode root) {

        if (root == null)
            return;

        /** 1 create a queue and assign root */
        Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.add(root);
        int level = 0;
        List<Integer> data = new ArrayList<Integer>();
        /** step 2 iterate over root and add left /right to queue as we visit nodes */
        while (!queue.isEmpty()) {
            int levelLength = queue.size();
            for (int i = 0; i < levelLength; i++) {
                // Step 3 process queus from top level to bottom
                TreeNode curr = queue.removeFirst();
                System.out.print(curr.val + " "); // or we can add to list
                data.add(curr.val);
                // add left node at this level for further processing
                if (curr.left != null) {
                    queue.add(curr.left);
                }
                // add right node for futher processing
                if (curr.right != null) {
                    queue.add(curr.right);

                }
            }
            // level traveral done increment depth level
            level++;
        }

    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            List<Integer> level = new ArrayList<>();

            for (int i = q.size(); i > 0; i--) {
                TreeNode node = q.poll();
                if (node != null) {
                    level.add(node.val);
                    q.add(node.left);
                    q.add(node.right);
                }
            }
            if (level.size() > 0) {
                res.add(level);
            }
        }
        return res;
    }

}
