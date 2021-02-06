import java.util.*;

public class Partition {
    public static class LinkedList {
        public class Node {
            private int value;
            private Node next;
            private Node prev;
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
            n.prev = this.tail;
            this.tail = n;
        }

        public void printList() {
            Node n = this.head;
            while (n != null) {
                System.out.println(n.value);
                n = n.next;
            }
        }
        public void partitionUp(int k) {
            Node n = this.head.next;
            while (n != null) {
                Node temp = n.next;
                if (n.value < k) {
                    if (n.next != null) {
                        n.prev.next = n.next;
                        n.next.prev = n.prev;
                        n.next = this.head;
                        this.head.prev = n;
                        this.head = n;
                        n = temp;
                    } else {
                        // Last one
                        this.tail = n.prev;
                        n.prev.next = null;
                        n.next = this.head;
                        this.head.prev = n;
                        this.head = n;
                    }
                }
                n = temp;
            }


        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList(0);
        list.addNode(10);
        list.addNode(20);
        list.addNode(1);
        list.addNode(2);
        list.addNode(30);
        list.addNode(30);
        list.addNode(2);
        list.partitionUp(30);
        list.printList();
    }
}