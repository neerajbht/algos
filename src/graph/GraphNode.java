package graph;

import java.util.ArrayList;
import java.util.List;

public class GraphNode {
    int val;
    List<GraphNode> neighbours;

    public GraphNode(int val) {
        this.val = val;
        this.neighbours = new ArrayList<>();
    }

}
