import java.util.*;

/**
 * Class that describes what a node object is - for use in the Binary Heap.
 */
public class Node {
    /**
     * Integer indicating the value of the node.
     */
    private int val;

    /**
     * Integer indicating the height of the node.
     */
    private int height;

    /**
     * Integer indicating the minimum height of the node (between left and right children).
     */
    private int minHeight;

    /**
     * Left Child of the current node.
     */
    private Node left;

    /**
     * Right Child of the current node.
     */
    private Node right;

    /**
     * Parent of the current node.
     */
    private Node parent;

    /**
     * Constructor for the node class.
     * @param val the value of the instantiated node.
     */
    public Node(int val) {
        this.val = val;
        this.height = 0;
    }

    /**
     * @return the value of the node.
     */
    public int getValue() {
        return this.val;
    }

    /**
     * @return the right child of the node.
     */
    public Node getRightChild() {
        return this.right;
    }

    /**
     * @return the left child of the node.
     */
    public Node getLeftChild() {
        return this.left;
    }

    /**
     * @return the parent of the node.
     */
    public Node getParent() {
        return this.parent;
    }

    /**
     * @return the height of the node.
     */
    public int getHeight() {
        return this.height;
    }

    /**
     * @return the minimum height of the node.
     */
    public int getMinHeight() {
        return this.minHeight;
    }

    /**
     * Sets the height of the node.
     * @param height the set height of the node.
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * Sets the minimum height of the node.
     * @param height the set minumum height of the node.
     */
    public void setMinHeight(int height) {
        this.minHeight = height;
    }

    /**
     * Sets the parent of the node.
     * @param n the set parent of the node.
     */
    private void setParent(Node n) {
        this.parent = n;
    }

    /**
     * Sets the left child of the node.
     * @param n the set left child of the node.
     */
    public void setLeftChild(Node n) {
        this.left = n;
        if (n != null) {
            n.setParent(this);
        }
    }

    /**
     * Sets the right child of the node.
     * @param n the set right child of the node.
     */
    public void setRightChild(Node n) {
        this.right = n;
        if (n != null) {
            n.setParent(this);
        }
    }

    /**
     * Sets the value of the node.
     * @param val the set value of the node.
     */
    public void setValue(int val) {
        this.val = val;
    }
}