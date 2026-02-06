package tree;

public class BinaryTreeFromPreInOrder {
    static int preIdx = 0, inIdx = 0;

    /**
     * using dfs approach
     * 
     * * int[] preOrder = { 1, 2, 3, 4 }; *
     * * int[] inOrder = { 2, 1, 3, 4 };
     * 
     * Preorder (Root → Left → Right): The very first element is always the Root of
     * the current tree or subtree.
     * 
     * Inorder (Left → Root → Right): Once you find the Root here, everything to its
     * left belongs to the left subtree, and everything to its right belongs to the
     * right subtree.
     */

    static TreeNode buildTree(int[] preOrder, int[] inOrder) {

        return dfs(preOrder, inOrder, Integer.MAX_VALUE);

    }

    /**
     * 
     * 
     * 1 Maintain two global indices: preIdx for preorder and inIdx for inorder.
     * 2 Define a recursive function dfs(limit) that builds a subtree until it hits
     * the limit value.
     * 3 If preIdx >= n, return null (no more nodes).
     * 4 If inorder[inIdx] == limit, increment inIdx and return null (subtree
     * complete).
     * 5 Create a root node with preorder[preIdx], increment preIdx.
     * 6 Build the left subtree with dfs(root.val) since nodes less than root appear
     * before it in inorder.
     * 7 Build the right subtree with dfs(limit) using the original limit.
     * 8 Return the root node. Start with dfs(infinity) or a value larger than any
     * node.
     */
    static TreeNode dfs(int[] preOrder, int[] inOrder, int limit) {
        // base condition to terminate recursion
        if (preIdx >= preOrder.length)
            return null;

        if (inOrder[inIdx] == limit) {
            inIdx++;
            return null;
        }
        // create root
        TreeNode root = new TreeNode(preOrder[preIdx++]);

        root.left = dfs(preOrder, inOrder, root.val);
        root.right = dfs(preOrder, inOrder, limit);

        return root;

    }

    /*
     * using moris traversal
     * 4. Morris Traversal
     * Algorithm
     * 1 Create a dummy head node and set curr to point to it.
     * 2 Iterate through preorder with index i and inorder with index j.
     * 3 Create a new node for preorder[i] and attach it as curr's right child, then
     * move curr to this new node.
     * 4 While preorder[i] does not match inorder[j], keep creating left children
     * (storing parent in right pointer).
     * 
     * 5 When a match is found, increment j. While curr.right exists and matches
     * inorder[j], clear the temporary right link and move up.
     * 6 Continue until all nodes are processed.
     * 7 Return head.right as the actual root.
     * 
     * int[] inOrder = { 2, 1, 3, 4 };
     * int[] preOrder = { 1, 2, 3, 4 };
     */
    public TreeNode buildTreeTravis(int[] preorder, int[] inorder) {
        TreeNode head = new TreeNode(0);
        TreeNode curr = head;
        int i = 0, j = 0, n = preorder.length;
        // step 2 -
        while (i < n && j < n) {

            curr.right = new TreeNode(preorder[i], null, curr.right);
            curr = curr.right;
            i++;

            // step 4 While preorder[i] does not match inorder[j], keep creating left
            // childre * (storing parent in right pointer).
            while (i < n && curr.val != inorder[j]) {
                curr.left = new TreeNode(preorder[i], null, curr); // parent in rigth
                curr = curr.left;
                i++;
            }
            j++;

            // step 5 When a match is found, increment j. While curr.right exists and
            // matches inorder[j], clear the temporary right link and move up.

            while (curr.right != null && j < n && curr.right.val == inorder[j]) {
                TreeNode prev = curr.right;
                curr.right = null;
                curr = prev;
                j++;
            }
        }
        return head.right;
    }

    public static void main(String[] args) {
        int[] inOrder = { 2, 1, 3, 4 };
        int[] preOrder = { 1, 2, 3, 4 };

        BinaryTreeFromPreInOrder.buildTree(preOrder, inOrder);

    }
}