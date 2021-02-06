import java.util.*;

/**
 * A class representing a Binary Search tree.
 */
public class BST {
    /**
     * A node object that represents the root of the BST.
     */
    private Node root;

    /**
     * An integer that represents the number of nodes in the BST.
     */
    private int count;

    /**
     * An array of all the nodes in the BST.
     */
    private ArrayList<Node> arr;

    /**
     * Constructor for the BST object.
     */
    public BST() {
        this.count = 0;
        this.arr = new ArrayList<>();
    }

    /**
     * Wrapper Function to insert nodes into the BST via the insertNode function.
     * @param val integer that is the value of the inserted Node.
     * @return the inserted node.
     */
    public Node insert(int val) {
        Node x = new Node(val);
        if (this.root == null) {
            this.root = x;
            return x;
        }

        insertNode(this.root, x);
        this.count++;
        this.arr.add(x);
        return x;
    }

    /**
     * Function that recursively insert.
     * @param ancestor the predecessor of the inserted node.
     * @param inserted the node to be inserted into the BST.
     */
    public void insertNode(Node ancestor, Node inserted) {
        if (inserted.getValue() < ancestor.getValue()) {
            if (ancestor.getLeftChild() == null) {
                ancestor.setLeftChild(inserted);
            } else {
                insertNode(ancestor.getLeftChild(), inserted);
            }
        } else {
            if (ancestor.getRightChild() == null) {
                ancestor.setRightChild(inserted);
            } else {
                insertNode(ancestor.getRightChild(), inserted);
            }
        }
    }

    /**
     * Function to calculate the height of a given node.
     * @param n is the node that we are calculating the height of.
     * @return height of the node n.
     */
    public int calculateHeight(Node n) {
        if (n == null) {
            return 0;
        }
        int leftHeight = calculateHeight(n.getLeftChild());
        int rightHeight = calculateHeight(n.getRightChild());
        int x = 0;
        if (leftHeight > rightHeight) {
            x = leftHeight + 1;
        } else {
            x = rightHeight + 1;
        }

        n.setHeight(x);
        return x;
    }

    /**
     * Finds the common ancestor of the two given nodes.
     * @param a one of the nodes.
     * @param b the other node.
     * @return the common node.
     */
    public Node commonAncestor(Node a, Node b) {
        if (a == this.root || b == this.root) {
            return this.root;
        }
        Node x = a;
        while (x != this.root) {
            Node y = b;
            while (y != this.root) {
                if (x == y) {
                    return x;
                }
                y = y.getParent();
            }
            x = x.getParent();
        }
        return this.root;
    }

    /**
     * Randomly returns a node.
     * @return a random node from the BST.
     */
    public Node getRandomNode() {
        Random r = new Random();
        int index = r.nextInt() % this.count;
        if (index < 0) {
            index = -index;
        }
        return this.arr.get(index);
    }

    public Boolean sumUpTo(Node n, int sum, int current_value) {
        int val = n.getValue();
        Node left = n.getLeftChild();
        Node right = n.getRightChild();
        current_value += val;

        if (left == null && right == null) {
            if (current_value != sum) {
                return false;
            }
            return true;
        }
        if (left == null) {
            return sumUpTo(right, sum, current_value);
        }
        if (right == null) {
            return sumUpTo(left, sum, current_value);
        }
        
        Boolean l = sumUpTo(left, sum, current_value);
        Boolean r = sumUpTo(right, sum, current_value);
        if (l || r) {
            return true;
        }
        return false;
    }

    public Node getRoot() {
        return this.root;
    }

    public static void main(String[] args) {
        BST b = new BST();
        b.insert(5);
        b.insert(3);
        b.insert(2);
        b.insert(4);
        b.insert(7);
        b.insert(6);
        b.insert(9);
        b.insert(1);
        System.out.println(b.sumUpTo(b.getRoot(), 18, 0));
    }
}