import java.util.*;

public class KthToLast {

    public static class LinkedList {
        public class Node {
            private int value;
            private Node next;
            public Node(int value) {
                this.value = value;
            }
        }
        public Node head;
        public Node tail;
        public LinkedList(int value) {
            Node n = new Node(value);
            this.head = n;
            this.tail = n;
        }

        public void addNode(int val) {
            Node n = new Node(val);
            this.tail.next = n;
            this.tail = n;
        }

        public int returnKth(int k) {
            Node n = this.head;
            int count = 0;
            while (n != null) {
                count++;
                n = n.next;
            }

            n = this.head;
            if (k < count) {
                for (int i = 0; i < count - k; i++) {
                    n = n.next;
                }
            }
            return n.value;
        }
    }
    public static void main(String[] args) {
        LinkedList list = new LinkedList(0);
        list.addNode(1);
        list.addNode(2);
        list.addNode(3);
        list.addNode(4);
        list.addNode(10);
        list.addNode(6);
        list.addNode(7);
        System.out.println(list.returnKth(5));
    } 
}