package Part3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphWithAdjacencyList {

    //undirected graph
    private Map<GraphNode, List<GraphNode>> adjNodes;
    private ArrayList<Integer> directory;

    /** Constructor that initializes mapping of graph
     * represented and maintained by an adjacency list ds. */
    GraphWithAdjacencyList() {
        adjNodes = new HashMap<>();
        directory = new ArrayList<>();
    }

    /** Adds a new node with int key to the graph. */
    void addNode(int key) {
        if (directory.contains(key)) {
            System.out.println("Node with passed in key value already exists");
        } else {
            directory.add(key);
            adjNodes.put(new GraphNode(key), new ArrayList<>());
        }
    }

    /** Removes the node with int key from the graph. */
    void removeNode(int key) {
        if (!directory.contains(key)) {
            System.out.println("Graph does not contain a node with key value");
        } else {
            directory.remove((Integer) key);
            List<GraphNode> removeAdj = adjNodes.remove(key);

            //for each adj node n, remove node (key) in n's adjacency list
            while (!removeAdj.isEmpty()) {

            }
        }
    }

    /** Adds an edge between node1 and node2. */
    void addEdge(int node1, int node2) {

    }

    /** Removes and edge between node1 and node2. */
    void removeEdge(int node1, int node2) {

    }

    /** Get nodes that are connected to the node represented by 'key'. */
    List<GraphNode> getAdjNodes(int key) {

    }
}
