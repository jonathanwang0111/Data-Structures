import java.util.*;

public class RemoveDups {
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

        public void removeDuplicates() {
            Node n = this.head;
            while (n != null) {
                if (n.value == this.tail.value) {
                    this.tail = this.tail.prev;
                    this.tail.next = null;
                }
                Node temp = n.next;
                while (temp != null) {
                    if (temp.next != null && temp.prev != null) {
                        if (n.value == temp.value) {
                            temp.next.prev = temp.prev;
                            temp.prev.next = temp.next;
                            temp = temp.prev;
                        }
                    }
                    temp = temp.next;
                }
                n = n.next;
            }
        }
    }
    public static void main(String[] args) {
        LinkedList list = new LinkedList(0);
        list.addNode(1);
        list.addNode(2);
        list.addNode(1);
        list.addNode(2);
        list.addNode(3);
        list.addNode(3);
        list.addNode(2);
        list.removeDuplicates();
        list.printList();

    }
}