// Binary Search Tree Node
package tree;

import java.util.ArrayList;
import java.util.List;

// Implementation for Binary Search Tree Map
class TreeMap {
    private MapNode root;

    public TreeMap() {
        root = null;
    }

    public void insert(int key, int val) {
        MapNode newNode = new MapNode(key, val);
        if (root == null) {
            root = newNode;
            return;
        }

        MapNode current = root;
        while (true) {
            if (key < current.key) {
                if (current.left == null) {
                    current.left = newNode;
                    return;
                }
                current = current.left;
            } else if (key > current.key) {
                if (current.right == null) {
                    current.right = newNode;
                    return;
                }
                current = current.right;
            } else {
                current.val = val;
                return;
            }
        }
    }

    public int get(int key) {
        MapNode current = root;
        while (current != null) {
            if (key < current.key) {
                current = current.left;
            } else if (key > current.key) {
                current = current.right;
            } else {
                return current.val;
            }
        }
        return -1;
    }

    public int getMin() {
        MapNode current = findMin(root);
        return (current != null) ? current.val : -1;
    }

    private MapNode findMin(MapNode node) {
        while (node != null && node.left != null) {
            node = node.left;
        }
        return node;
    }

    public int getMax() {
        MapNode current = root;
        while (current != null && current.right != null) {
            current = current.right;
        }
        return (current != null) ? current.val : -1;
    }

    public void remove(int key) {
        root = removeHelper(root, key);
    }

    private MapNode removeHelper(MapNode curr, int key) {
        if (curr == null) {
            return null;
        }

        if (key > curr.key) {
            curr.right = removeHelper(curr.right, key);
        } else if (key < curr.key) {
            curr.left = removeHelper(curr.left, key);
        } else {
            if (curr.left == null) {
                // Replace curr with right child
                return curr.right;
            } else if (curr.right == null) {
                // Replace curr with left child
                return curr.left;
            } else {
                // Swap curr with inorder successor
                MapNode minNode = findMin(curr.right);
                curr.key = minNode.key;
                curr.val = minNode.val;
                curr.right = removeHelper(curr.right, minNode.key);
            }
        }
        return curr;
    }

    public List<Integer> getInorderKeys() {
        List<Integer> result = new ArrayList<>();
        inorderTraversal(root, result);
        return result;
    }

    private void inorderTraversal(MapNode root, List<Integer> result) {
        if (root != null) {
            inorderTraversal(root.left, result);
            result.add(root.key);
            inorderTraversal(root.right, result);
        }
    }
}
