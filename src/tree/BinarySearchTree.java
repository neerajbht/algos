package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

// Generic implementation for the BST 
public class BinarySearchTree<Key extends Comparable<Key>, Value> {

    private class Node {
        private Key key;
        private Value val;
        private Node left, right;
        private int size;

        Node(Key k, Value v, int size) {
            this.key = k;
            this.val = v;
            this.size = size;
        }
    }

    private Node root;

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return this.size(root);

    }

    public int size(Node node) {
        if (node == null)
            return 0;
        return node.size;
    }

    public Value get(Key k) {
        return this.get(root, k);
    }

    /** Get Value for Key */
    public Value get(Node node, Key k) {
        if (node == null)
            return null;
        if (k == null)
            return null; // throw IllegalArugmentException
        int cmp = k.compareTo(node.key);
        if (cmp > 0)
            return get(node.right, k);
        else if (cmp < 0)
            return get(node.left, k);
        else
            return node.val;

    }
    // non recursive

    public Value getIt(Key k) {
        Node x = root;
        while (x != null) {
            int cmp = k.compareTo(x.key);
            if (cmp > 0) {
                x = x.right;
            } else if (cmp < 0) {
                x = x.left;
            } else
                return x.val;

        }
        return null;

    }

    public void put(Key k, Value v) {
        if (k == null)
            throw new IllegalArgumentException("Invalid Key");
        if (v == null) {
            // we are tring to delete key
            this.delete(k);
            return;
        }
        root = this.put(this.root, k, v);
    }

    public Node put(Node node, Key k, Value v) {
        // case 1 new Node
        if (node == null)
            return new Node(k, v, 1);
        // case 2 subseeuent nodes
        int cmp = k.compareTo(node.key);
        if (cmp < 0)
            node.left = put(node.left, k, v);
        else if (cmp > 0)
            node.right = put(node.right, k, v);
        else // else key is same general behavior is over write value
            node.val = v;
        // update Node size
        node.size = 1 + this.size(node.left) + this.size(node.right);
        return node;

    }

    public void putIt(Key key, Value val) {
        Node z = new Node(key, val, 1);
        if (root == null) {
            root = z;
            return;
        }

        Node parent = null, x = root;
        while (x != null) {
            parent = x;
            int cmp = key.compareTo(x.key);
            if (cmp < 0)
                x = x.left;
            else if (cmp > 0)
                x = x.right;
            else {
                x.val = val;
                return;
            }
        }
        int cmp = key.compareTo(parent.key);
        if (cmp < 0)
            parent.left = z;
        else
            parent.right = z;
    }

    public Node min(Node node) {
        if (node.left == null)
            return node;
        return min(node.left);
    }

    public void delete(Key k) {
        if (k == null)
            throw new IllegalArgumentException("Invalid Key");

        root = delete(root, k);
    }

    public Node delete(Node node, Key k) {
        if (node == null)
            return null;
        int cmp = k.compareTo(node.key);
        if (cmp < 0)
            node.left = delete(node.left, k);
        else if (cmp > 0) {
            node.right = delete(node.right, k);
        } else {
            // this is current node to be deleted
            // step 1 if left node is null
            if (node.left == null)
                return node.right;
            if (node.right == null)
                return node.left;
            // case 2 has noth left and right node
            Node temp = node;
            // get the minimal right most node from node as make that as node.
            node = this.min(node.right);
            // now since we replaced the rightmost one ... we do the same for rightmost node
            // .i.e. recursively replace it corresponding right node as well
            node.right = this.delete(node.right, node.key);
            node.left = temp.left;
        }
        // re compute size
        node.size = this.size(node.left) + this.size(node.right);
        return node;
    }

    /** Non recurisive version of the put and delete */

    // Binary search Tree ---- Level order Traversal

    public Iterable<Key> levelOrder() {
        Queue<Key> keys = new LinkedList<Key>();
        Queue<Node> q = new LinkedList<Node>();
        q.offer(this.root);

        while (!q.isEmpty()) {
            Node n = q.poll();
            if (n == null)
                continue;
            keys.offer(n.key);
            q.offer(n.left);
            q.offer(n.right);
        }
        return keys;

    }
    // Inorder Traversal

    public Iterable<Key> inOrder() {

        Stack<Node> stack = new Stack<Node>();
        Queue<Key> queue = new LinkedList<Key>();

        Node x = this.root;
        while (x != null || !stack.empty()) {

            if (x != null) {
                stack.push(x); /// push current node in stack like start with root and then next
                x = x.left; // move temp
            } else {
                // we reached end of the x
                // get value
                x = stack.pop();
                // save thie key
                queue.offer(x.key);
                // add right
                x = x.right;
            }

        }
        return queue;
    }

}
