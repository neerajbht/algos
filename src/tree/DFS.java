package tree;

import java.util.Stack;

/**
 * Traversal, Key Strength, Real-World Analogy :
 * 
 * In-Order, Sorting, "Reading a book page by page (1, 2, 3...)."
 * 
 * * Order: Left --> Root --> Right ->>>>>>>>>>LDR
 * 
 * Pre-Order,Structure,An organizational chart (Boss → Manager → Intern).
 * 
 * * Order: Root --> Left --> Right->>>>>>>> DLR
 * 
 * Post-Order,Dependencies,Mathematics (solving (3+5)×2 requires solving 3+5
 * first).
 * 
 * Order: Left --> Right --> Root --------->>>>>>> LRD
 */
public class DFS {
    // Order: Left --> Root --> Right
    // Result: This visits nodes in ascending order (sorted).
    // Use Case: Printing sorted data. If you need to display all elements in your
    // BST from smallest to largest, this is the only way to do it.
    // Use Case: Validation. To check if a binary tree is actually a valid "Binary
    // Search Tree," you can perform an In-Order traversal and verify if the
    // resulting list is sorted.

    public void inOrder(TreeNode root) {
        if (root == null)
            return;
        inOrder(root.left);
        System.out.println(root.val);
        inOrder(root.right);
    }

    // LDR ( left Data Right)
    public void iterativeInOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            // 1. Reach the left-most node of the current node
            while (current != null) {
                stack.push(current);
                current = current.left; //// Step 1 ---- Left
            }

            // 2. Current must be null at this point, so pop from stack
            current = stack.pop();
            System.out.print(current.val + " ");///// step 2 vist Root

            // 3. Now visit the right subtree
            current = current.right;/////////////// Step 3 move Right
        }
    }

    // Order: Root --> Left --> Right
    // Use Case: Good for creating a copy of the tree.
    // Use Case: Creating a copy of the tree. If you want to duplicate a tree, you
    // need to create the root node first before you can attach its children.
    // Use Case: Serialization. When saving a tree to a file or sending it over a
    // network, Pre-Order is often used so that when you "re-build" it, the root is
    // established first, maintaining the original structure.
    // Preorder traversal is also used to get prefix expression on of an expression
    // tree
    public void preOrder(TreeNode root) {
        if (root == null)
            return;
        System.out.println(root.val);
        preOrder(root.left);
        preOrder(root.right);

    }
    // DLR

    // The logic here is "Root, then Left, then Right." Because a Stack is Last-In,
    // First-Out (LIFO), we push the Right child first so that the Left child stays
    // on top and gets processed next.
    public void iterativePreOrder(TreeNode root) {
        if (root == null)
            return;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            // 1. Pop the top node and print it
            TreeNode current = stack.pop(); //
            System.out.print(current.val + " "); //////// ?Step 1

            // 2. Push the Right child first (so Left is processed first)
            if (current.right != null) {
                stack.push(current.right); ////// Step 2
            }

            // 3. Push the Left child
            if (current.left != null) {
                stack.push(current.left);/// Step 3
            }
        }
    }

    // Order: Left --> Right --> Root
    // Use Case: Good for deleting a tree or calculating file sizes in a directory.
    // Postorder traversal is also useful to get the postfix expression of an
    // expression tree.
    public void postOrder(TreeNode root) {
        if (root == null)
            return;

        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.val);

    }

    /// . LRD
    /**
     * terative Post-Order is notoriously the hardest one to implement.
     * Because the order is Left → Right → Root, you have to visit the children but
     * only "process" the root after both children are done.
     * The cleanest way to do this is to
     * use two stacks: one to traverse the tree and
     * another to reverse the order so the root ends up at the bottom.
     * 
     * @param root
     */
    // Use Case: Deleting or Deleting memory.
    // In languages like C++, you must delete the child nodes before you delete the
    // parent to avoid "orphaning" nodes in memory.
    // Use Case: Calculating Folder Size. Think of a file system. To find the total
    // size of a "Root" folder,
    // you must first calculate the size of all files in the "Left" and "Right"
    // sub-folders. Only then can you sum them up at the Root level.
    public void iterativePostOrder(TreeNode root) {
        if (root == null)
            return;

        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();

        s1.push(root);

        // Run while first stack is not empty
        while (!s1.isEmpty()) {
            TreeNode temp = s1.pop();
            s2.push(temp);

            // Push left and right children of removed item to s1
            if (temp.left != null) {
                s1.push(temp.left);
            }
            if (temp.right != null) {
                s1.push(temp.right);
            }
        }

        // Print all elements of second stack
        while (!s2.isEmpty()) {
            TreeNode temp = s2.pop();
            System.out.print(temp.val + " ");
        }
    }

    public static void main(String[] argds) {
        BST tree = new BST();
        DFS dfs = new DFS();

        tree.addNode(null, 7);
        tree.addNode(null, 4);

        tree.addNode(null, 5);
        tree.addNode(null, 6);
        tree.addNode(null, 1);
        tree.addNode(null, 11);
        tree.addNode(null, 8);
        tree.addNode(null, 9);

    }
}
