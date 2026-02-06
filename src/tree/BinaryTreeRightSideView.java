package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {
    /**
     * essential we are only taking right or the first node that pops out of queue
     * at each level
     * root level only one node --- add to list
     * level 1 -- case 1 only right node present gets added
     * level 1 - case 2 has both left and right so we need to add both left/right to
     * queue
     * next time when for loop run it will have both left and right andd so we store
     * node in variable
     * rightNode , rightNode is getting over written in for loop so if there were
     * left and right at that level final node reference will be of right
     * other wise final reference will be of left and we want that
     * once we exit for loop we read from rightNode since that value at tree level
     * of right view we want to see
     * 
     */

    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> data = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {

            TreeNode rightNode = null;

            for (int i = 0; i < q.size(); i++) {

                TreeNode node = q.poll();
                if (node != null) {
                    rightNode = node;
                    q.offer(node.left);
                    q.offer(node.right);
                }
            }
            if (rightNode != null) {
                data.add(rightNode.val);
            }
        }
        return data;

    }

}
