package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class VerticalOrder {

    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;

        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<TreeNode> nodes = new LinkedList<>();
        Queue<Integer> cols = new LinkedList<>();

        nodes.add(root);
        cols.add(0);

        int min = 0, max = 0;

        while (!nodes.isEmpty()) {
            TreeNode node = nodes.poll();
            int col = cols.poll();

            map.computeIfAbsent(col, k -> new ArrayList<>()).add(node.val);
            min = Math.min(min, col);
            max = Math.max(max, col);

            if (node.left != null) {
                nodes.add(node.left);
                cols.add(col - 1);
            }
            if (node.right != null) {
                nodes.add(node.right);
                cols.add(col + 1);
            }
        }

        for (int i = min; i <= max; i++) {
            res.add(map.get(i));
        }
        return res;
    }

}
