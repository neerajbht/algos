package tree;

import java.util.ArrayList;
import java.util.List;

public class TreeMaze {

    /** from root can we reach to leaf node there should be no 0 value based node */
    public boolean canReachLeaf(TreeNode root) {
        if (root == null || root.val == 0)
            return false;
        /** we recursively traverse left and right */
        // 1 -leaf node has no left/right nodes
        if (root.left == null || root.right == null)
            return true;
        // check left
        if (canReachLeaf(root.left))
            return true;
        // check right
        if (canReachLeaf(root.right))
            return true;

        return false;
    }

    public boolean getLeafPath(TreeNode root) {

        List<Integer> path = new ArrayList<>();

        path = this.leafPath(root, path);

        return path.size() > 0;

    }

    private List<Integer> leafPath(TreeNode root, List<Integer> path) {

        if (root == null || root.val == 0)
            return path;
        // 1 add value to path
        path.add(root.val);
        // base case
        if (root.left == null || root.right == null)
            return path;
        // traverse left
        if (leafPath(root.left, path).size() > 0)
            return path;
        // traverse right
        if (leafPath(root.right, path).size() > 0)
            return path;
        // we are here that me that means path is not there at node level so we pop this
        // node out of list

        path.remove(path.size() - 1);
        return path;

    }

}
