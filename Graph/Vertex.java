import java.util.*;

/**
 * Class representing a vertex.
 */
public class Vertex {
    /** Instance variables */
    private int value;
    private Edge[] inEdges;
    private Edge[] outEdges;
    private int inCount;
    private int outCount;
    private boolean checked;

    /**
     * Constructor for the vertex object.
     * @param val integer that is the value of the vertex.
     * @param n the maximum number of other vertices in the graph possible.
     */
    public Vertex(int val, int n) {
        this.value = val;
        this.inEdges = new Edge[n];
        this.outEdges = new Edge[n];
        this.inCount = 0;
        this.outCount = 0;
        this.checked = false;
    }

    /** Functions that get instance variables. */
    public int getVal() {
        return this.value;
    }

    public boolean checked() {
        return this.checked;
    }

    public Edge[] getInEdges() {
        return this.inEdges;
    }

    public Edge[] getOutEdges() {
        return this.outEdges;
    }

    public int getOutCount() {
        return this.outCount;
    }

    public int getInCount() {
        return this.inCount;
    }

    /** Function that toggles the checked instance variable */
    public void toggleChecked() {
        this.checked = !this.checked;
    }

    /** Adds in edge to vertex. */
    public void appendInEdge(Edge e) {
        this.inEdges[this.inCount] = e;
        this.inCount++;
        return;
    }

    /** Adds out edge to vertex. */
    public void appendOutEdge(Edge e) {
        this.outEdges[this.outCount] = e;
        this.outCount++;
        return;
    }

    /** Prints the edges associated with this vertex. */
    public void printEdges(String inOrOut) {
        Edge[] arr;
        int x;
        if (inOrOut.equals("in")) {
            arr = this.inEdges;
            x = this.inCount;
        } else if (inOrOut.equals("out")) {
            arr = this.outEdges;
            x = this.outCount;
        } else {
            return;
        }
        for (int i = 0; i < x; i++) {
            Edge e = arr[i];
            int fromVal = e.getFrom().getVal();
            int toVal = e.getTo().getVal();
            int length = e.getLength();
            System.out.println(fromVal + " --> " + toVal + " Length: " + length);
        }
    }

}