import java.util.*;

public class MyStack {
    /** Node class for individual "plates" */
    public class Node {
        private int value;
        private Node next;
        public Node(int val) {
            this.value = val;
        }
    }

    /** Instance Variables and constructor */
    private Node top;
    private int count;
    public MyStack() {
        this.count = 0;
        this.top = null;
    }

    /** The four main functions of a stack */
    public boolean isEmpty() {
        return count == 0;
    }

    public int top() {
        return this.top.value;
    }

    public int pop() {
        int x = this.top.value;
        this.top = this.top.next;
        this.count--;
        return x;
    }

    public void push(int val) {
        Node n = new Node(val);
        n.next = this.top;
        this.top = n;
        this.count++;
    }
    
    public void printStack() {
        Node n = this.top;
        for (int i = 0; i < count; i++) {
            System.out.println(n.value);
            n = n.next;    
        }
    }
}