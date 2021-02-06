/**
 * Class for a node object.
 */
public class Node {
    
    /** Instance variables and Constructor */
    private int val;
    private int height;
    private Node left;
    private Node right;
    private Node parent;

    public Node(int val) {
        this.val = val;
        this.height = 0;
    }

    /** Get Functions */
    public int getValue() {
        return this.val;
    }

    public Node getRightChild() {
        return this.right;
    }

    public Node getLeftChild() {
        return this.left;
    }

    public Node getParent() {
        return this.parent;
    }

    public int getHeight() {
        return this.height;
    }

    /** Set Functions */
    public void setHeight(int height) {
        this.height = height;
    }

    private void setParent(Node n) {
        this.parent = n;
    }

    public void setLeftChild(Node n) {
        this.left = n;
        n.setParent(this);
    }

    public void setRightChild(Node n) {
        this.right = n;
        n.setParent(this);
    }

    public void setValue(int val) {
        this.val = val;
    }
}