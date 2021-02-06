public class Node {
    private int val;
    private Node l;
    private Node r;
    private Node parent;

    public Node(int val) {
        this.val = val;
        this.l = null;
        this.r = null;
        this.parent = null;
    }

    public void setRightChild(Node n) {
        this.r = n;
        this.r.setParent(this);
    }

    public Node getParent() {
        return this.parent;
    }

    public void setParent(Node n) {
        this.parent = n;
    }

    public void setLeftChild(Node n) {
        this.l = n;
        this.l.setParent(this);
    }

    public int getValue() {
        return this.val;
    }

    public Node getLeft() {
        return this.l;
    }

    public Node getRight() {
        return this.r;
    }
}