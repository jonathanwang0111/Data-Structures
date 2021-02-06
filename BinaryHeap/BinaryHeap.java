import java.util.*;

/**
 * This class is an implementation of a Binary Heap.
 */
public class BinaryHeap {
    /** 
     * A node corresponding to the root of the Binary Heap.
     */
    private Node root;

    /**
     * A integer corresponding to the number of nodes in the Binary Heap.
     */
    private int count;

    /**
     * An array of nodes that indicate the locations of the nodes with respect to each other.
     */
    private Node[] lastLocations;

    /**
     * Constructor that instantiates an empty Binary Heap.
     * @param size indicates the number of nodes that the Binary Heap can take in.
     */
    public BinaryHeap(int size) {
        this.root = null;
        this.count = 0;
        this.lastLocations = new Node[size];
    }
    
    /** 
     * Function to calculate the height of a given node in the Binary Heap.
     * @param n is the node to calculate the height of.
     * @return integer representing the height of the given node.
     */
    public int calculateHeight(Node n) {
        if (n == null) {
            return 0;
        }
        int leftHeight = calculateHeight(n.getLeftChild());
        int rightHeight = calculateHeight(n.getRightChild());
        int x = 0;
        int min = 0;
        if (leftHeight > rightHeight) {
            x = leftHeight + 1;
            if (n.getRightChild() == null) {
                min = 0;
            } else {
                min = n.getRightChild().getMinHeight() + 1;
            }
        } else {
            x = rightHeight + 1;
            if (n.getLeftChild() == null) {
                min = 0;
            } else {
                min = n.getLeftChild().getMinHeight() + 1;
            }
        }
        n.setHeight(x);
        n.setMinHeight(min);
        return x;
    }

    /**
     * Function to see if a given node is filled - if same number of left/right height.
     * @param n the node to be tested.
     * @return boolean indicating if the current node is "filled" - useful for insertion.
     */
    private Boolean filled(Node n) {
        if (n.getLeftChild() == null && n.getRightChild() == null) {
            return true;
        }
        if (n.getRightChild() == null){
            return false;
        }
    
        if (n.getLeftChild().getHeight() == n.getRightChild().getHeight()) {
            if (n.getLeftChild().getMinHeight() == n.getRightChild().getMinHeight()) {
                return true;
            } 
        }

        return false;
    }

    /**
     * Recursive Function to insert a new node in the next location of the heap.
     * @param n is the node to be inserted from.
     * @param val is the value to be inserted.
     * @return the inserted Node
     */
    private Node insertNextLocation(Node n, int val) {
        Node x = new Node(val);

        if (n.getLeftChild() == null) {
            n.setLeftChild(x);
            this.lastLocations[this.count] = x;
            return x;
        } 
        if (n.getRightChild() == null) {
            n.setRightChild(x);
            this.lastLocations[this.count] = x;
            return x;
        }

        if (filled(n) && n == this.root) {

            Node leftMost = this.root;
            while (leftMost.getLeftChild() != null) {
                leftMost = leftMost.getLeftChild();
            }
            leftMost.setLeftChild(x);
            this.lastLocations[this.count] = x;
            return x;
        }
        if (filled(n.getLeftChild())) {
            x = insertNextLocation(n.getRightChild(), val);
        } else {
            x = insertNextLocation(n.getLeftChild(), val);
        }

        this.lastLocations[this.count] = x;
        return x;
    }

    /**
     * Wrapper Function to insert a new node into the heap. 
     * @param val is the value of the inserted node.
     */
    public void insert(int val) {
        this.count++;
        if (this.root == null) {
            Node root = new Node(val);
            this.root = root;
            this.lastLocations[this.count] = root;
            return;
        }
        calculateHeight(this.root);
        Node x = insertNextLocation(this.root, val);
        while (x.getParent() != null && x.getParent().getValue() > val) {
            Node parent = x.getParent();
            x.setValue(parent.getValue());
            parent.setValue(val);
            x = parent;
        }
    }

    /**
     * Function that performs the bubble down feature of a binary heap deletion/
     * @param n the node to be bubbled down.
     */
    private void bubbleDown(Node n) {
        int val = n.getValue();
        if (n.getLeftChild() != null && n.getRightChild() != null) {
            int leftVal = n.getLeftChild().getValue();
            int rightVal = n.getRightChild().getValue();
            /** Case in which the node is in the correct location */
            if (val < leftVal && val < rightVal) {
                return;
            }
            if (leftVal < rightVal) {
                Node child = n.getLeftChild();
                n.setValue(leftVal);
                child.setValue(val);
                bubbleDown(child);
            }
            if (leftVal >= rightVal) {
                Node child = n.getRightChild();
                n.setValue(rightVal);
                child.setValue(val);
                bubbleDown(child);
            }
            return;
        }
        if (n.getLeftChild() != null) {
            if (n.getValue() >= n.getLeftChild().getValue()) {
                Node child = n.getLeftChild();
                n.setValue(child.getValue());
                child.setValue(val);
                bubbleDown(child);
            }
            return;
        }
        if (n.getRightChild() != null) {
            if (n.getValue() >= n.getRightChild().getValue()) {
                Node child = n.getRightChild();
                n.setValue(child.getValue());
                child.setValue(val);
                bubbleDown(child);
            }
            return;
        }
        return;
    }

    /**
     * Deletes the minimum of the heap.
     * @return the integer deleted (which is the minimum of the heap)
     */
    public int deleteMin() {
        int deletedVal = this.root.getValue();
        int bubbledVal = this.lastLocations[this.count].getValue();
        this.root.setValue(bubbledVal);
        Node x = this.lastLocations[this.count];
        this.lastLocations[this.count] = null;
        if (this.count > 0) {
            this.count--;
        }
        Node parent = x.getParent();
        if (parent.getRightChild() != null) {
            parent.setRightChild(null);
        } else {
            parent.setLeftChild(null);
        }
        bubbleDown(this.root);
        return deletedVal;
    }

    /**
     * Function to get minimum value.
     * @return the minimum value of the heap.
     */
    public int getMin() {
        return this.root.getValue();
    }

}