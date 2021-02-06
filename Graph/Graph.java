import java.util.*;

/**
 * Class for a graph object.
 */
public class Graph {
    /**
     * An array of vertices that are in the graph.
     */
    private Vertex[] vertexList;

    /**
     * Integer representing the maximum number of vertices in the graph.
     */
    private int maxNumVertices;

    /**
     * Integer of the number of vertices in the graph.
     */
    private int numVertices;

    /**
     * Constructor for a graph object.
     * @param n the maximum number of vertices in the graph.
     */
    public Graph(int n) {
        this.vertexList = new Vertex[n];
        this.maxNumVertices = n;
        this.numVertices = 0;
    }

    /**
     * Function to add a vertex to the graph.
     * @param val integer for the value of the vertex.
     * @return the added vertex.
     */
    public Vertex addVertex(int val) {
        Vertex v = new Vertex(val, this.maxNumVertices);
        this.vertexList[this.numVertices] = v;
        this.numVertices++;
        return v;
    }

    /**
     * Function that adds an edge between two vertices in the graph.
     * @param f the vertex the edge has its tail at.
     * @param t the vertex the edge has its head at.
     * @param len integer that is the length of the edge.
     * @return an Edge object that is the inserted edge.
     */
    public Edge addEdge(Vertex f, Vertex t, int len) {
        Edge e = new Edge(f, t, len);
        f.appendOutEdge(e);
        t.appendInEdge(e);
        return e;
    }

    /**
     * Runs a DFS on a connected part of the graph.
     * @param x the reference vertex.
     * @param val the value of the vertex we are search for.
     * @return the vertex we are searching for, if it is actually in the graph.
     */
    private Vertex DFSConnected(Vertex x, int val) {
        if (x.checked() == true) {
            return null;
        }
        Stack<Vertex> stack = new Stack<>();
        stack.push(x);
        while (!stack.isEmpty()) {
            Vertex v = stack.pop();
            if (v.getVal() == val) {
                return v;
            }
            int outCount = v.getOutCount();
            Edge[] edgeList = v.getOutEdges();
            for (int i = 0; i < outCount; i++) {
                Edge e = edgeList[i];
                Vertex to = e.getTo();
                if (to.checked() == false) {
                    to.toggleChecked();
                    stack.push(to);
                }
            }
        }
        return null;
    }

    /**
     * Runs a DFS across the entire graph.
     * @param val the value of the vertex we are searching for.
     * @return the searched for vertex.
     */
    public Vertex DFS(int val) {
        for (int i = 0; i < this.numVertices; i++) {
            Vertex v = DFSConnected(this.vertexList[i], val);
            if (v != null) {
                return v;
            }
        }
        System.out.println("Cannot Find Vertex");
        return null;
    }

    /**
     * Runs a BFS on a connected part of the graph.
     * @param x the reference vertex.
     * @param val the value of the vertex we are search for.
     * @return the vertex we are searching for, if it is actually in the graph.
     */
    private Vertex BFSConnected(Vertex x, int val) {
        if (x.checked() == true) {
            return null;
        }
        ArrayDeque<Vertex> queue = new ArrayDeque<>();
        queue.add(x);
        while (queue.peek() != null) {
            Vertex v = queue.poll();
            if (v.getVal() == val) {
                return v;
            }
            int outCount = v.getOutCount();
            Edge[] edgeList = v.getOutEdges();
            for (int i = 0; i < outCount; i++) {
                Edge e = edgeList[i];
                Vertex to = e.getTo();
                if (to.checked() == false) {
                    to.toggleChecked();
                    queue.add(to);
                }
            }
        }
        return null;
    }

    /**
     * Runs a BFS across the entire graph.
     * @param val the value of the vertex we are searching for.
     * @return the searched for vertex.
     */
    public Vertex BFS(int val) {
        for (int i = 0; i < this.numVertices; i++) {
            Vertex v = BFSConnected(this.vertexList[i], val);
            if (v != null) {
                return v;
            }
        }
        System.out.println("Cannot Find Vertex");
        return null;
    }

    /**
     * Helper function that unchecks all vertices after DFS or BFS.
     */
    public void clearChecks() {
        for (int i = 0; i < this.numVertices; i++) {
            Vertex v = this.vertexList[i];
            if (v.checked()) {
                v.toggleChecked();
            }
        }
    }
}