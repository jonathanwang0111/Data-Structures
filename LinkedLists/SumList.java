import java.util.*;

public class SumList {

    public static class Node {
        private int value;
        private Node next;
        private Node prev;
        public Node(int value) {
            this.value = value;
        }
    }
    
    public static class LinkedList {

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
    }
    
    private LinkedList l1;
    private LinkedList l2;
    private LinkedList finalList;

    public SumList(LinkedList listOne, LinkedList listTwo) {
        this.l1 = listOne;
        this.l2 = listTwo;
    }

    public void addLists() {
        Node n1 = l1.head;
        Node n2 = l2.head;
        int carry = 0;
        while ((n1 != null || n2 != null) || carry == 1) {
            int digit1 = 0;
            int digit2 = 0;
            if (n1 != null) {
                digit1 = n1.value;
                n1 = n1.next;
            }
            if (n2 != null) {
                digit2 = n2.value;
                n2 = n2.next;
            }
            int sum = digit1 + digit2 + carry;

            carry = 0;
            if (sum > 9) {
                carry = 1;
                sum = sum - 10;
            }
            if (this.finalList == null) {
                this.finalList = new LinkedList(sum);
            } else {
                this.finalList.addNode(sum);
            }
        }
    }

    public void printFinalList() {
        this.finalList.printList();
    }

    public static void main(String[] args) {
        LinkedList list1 = new LinkedList(7);
        list1.addNode(1);
        list1.addNode(6);
        LinkedList list2= new LinkedList(5);
        list2.addNode(9);
        list2.addNode(2);
        SumList sum = new SumList(list1, list2);
        sum.addLists();
        sum.printFinalList();
    }
}