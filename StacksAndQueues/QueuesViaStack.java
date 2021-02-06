import java.util.*;

public class QueuesViaStack {
    /** Instance variables and Constructor */
    private MyStack s1;
    private MyStack s2;
    public QueuesViaStack() {
        this.s1 = new MyStack();
        this.s2 = new MyStack();
    }

    public void push(int val) {
        this.s1.push(val);
    }

    public boolean isEmpty() {
        return this.s1.isEmpty() && this.s2.isEmpty();
    }

    private void toggle() {
        if (this.s1.isEmpty()) {
            while(!this.s2.isEmpty()) {
                int x = this.s2.pop();
                this.s1.push(x);
            }
        } else {
            while(!this.s1.isEmpty()) {
                int x = this.s1.pop();
                this.s2.push(x);
            }
        }
    }

    public int remove() {
        toggle();
        int x = this.s2.pop();
        toggle();
        return x;
    }

    public int peek() {
        toggle();
        int x = this.s2.top();
        toggle();
        return x;
    }

    public void printQueue() {
        toggle();
        this.s2.printStack();
    }

    public static void main(String[] args) {
        QueuesViaStack q = new QueuesViaStack();
        q.push(0);
        q.push(1);
        q.push(2);
        q.push(3);
        q.push(4);
        q.push(5);
        q.remove();
        q.remove();
        q.printQueue();
    }
}