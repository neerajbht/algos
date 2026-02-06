package tree;

class MapNode {
    int key;
    int val;
    MapNode left;
    MapNode right;

    public MapNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
}