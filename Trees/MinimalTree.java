import java.util.*;


public class MinimalTree {

    /** Constructor and Instance Variables */
    private int[] arr;
    private Node root;
    public MinimalTree(int[] arr) {
        this.arr = arr;
        this.root = new Node(this.arr[this.arr.length/2]);
    }

    private int find_median_index(int i, int j) {
        return (j+i) / 2;
    }

    /**  */
    public void addChildNodes(Node parent, int parent_index, int left_index, int right_index) {
        
        int index_left_child = find_median_index(left_index, parent_index);
        int index_right_child = find_median_index(parent_index, right_index);

        if (parent == null || left_index == index_left_child || left) {
            return;
        }

        Node left_child = new Node(this.arr[index_left_child]);
        parent.setLeftChild(left_child);

        Node right_child = new Node(this.arr[index_right_child]);
        parent.setRightChild(right_child);

        addChildNodes(left_child, index_left_child, left_index, parent_index);
        addChildNodes(right_child, index_right_child, parent_index, right_index);

    }

    public Node createTree() {
        Node n = this.root;
        int root_index = this.arr[this.arr.length/2];
        addChildNodes(n, root_index, 0, this.arr.length);
        return n;
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
        int[] x = {0, 1, 2, 3, 4, 5, 6};
        MinimalTree t = new MinimalTree(x);
        Node root = t.createTree();
        t.print(root);
    }
}
