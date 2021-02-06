import java.util.*;

public class MaxDepth {
    private Node root;
    private int depth;
    public MaxDepth() {
        this.root = null;
    }
    public Node setRoot(int val) {
        this.root = new Node(val);
        return this.root;
    }

    /** dir = -1 --> left
     *  dir = 1 --> right
     *  Returns child node
     */
    public Node addChild(Node n, int val, int dir) {
        Node x = new Node(val);
        if (dir == -1) {
            n.setLeftChild(x);
        } else if (dir == 1) {
            n.setRightChild(x);
        } else {
            x = null;
        }
        return x;
    }

    public int findHeightOfNode(Node n) {
        if (n == null) {
            return -1;
        }

        int height = 0;
        int leftHeight = findHeightOfNode(n.getLeft());
        int rightHeight = findHeightOfNode(n.getRight());
        
        if (leftHeight > rightHeight) {
            height = leftHeight + 1;
        } else if (leftHeight <= rightHeight) {
            height = rightHeight + 1;
        }
        return height;
    }

    public int findHeight() {
        return findHeightOfNode(this.root);
    }

    public void print(Node n) {
        if (n == null) {
            return;
        }
        print(n.getLeft());
        System.out.print(n.getValue() + " ");
        print(n.getRight());
    }
    public static void main(String[] args) {
        MaxDepth tree = new MaxDepth();
        Node root = tree.setRoot(0);
        Node x = tree.addChild(root, 1, -1);
        x = tree.addChild(x, 4, -1);
        x = tree.addChild(x, 6, -1);
        x = tree.addChild(x.getParent(), 5, 1);
        x = tree.addChild(root, 2, 1);
        x = tree.addChild(x, 7, 1);
        x = tree.addChild(x, 9, 1);
        x = tree.addChild(x.getParent(), 8, -1);
        x = tree.addChild(x, 10, 1);
        x = tree.addChild(x.getParent(), 11, 1);
        System.out.println(tree.findHeight());
        tree.print(root);
    }
}