import java.util.*;

/** 
 * Class for the edge object in the graph.
 */
public class Edge {
    /** Instance variables of an edge object. */
    private Vertex from;
    private Vertex to;
    private int length;
    
    /**
     * Constructor for an edge object.
     * @param f the vertex associated to the tail of the edge.
     * @param t the vertex associated to the head of the edge.
     * @param len the integer that is the length of the edge.
     */
    public Edge(Vertex f, Vertex t, int len) {
        this.from = f;
        this.to = t;
        this.length = len;
    }

    /** Functions that get instance variables. */
    public Vertex getFrom() {
        return this.from;
    }

    public Vertex getTo() {
        return this.to;
    }

    public int getLength() {
        return this.length;
    }
}