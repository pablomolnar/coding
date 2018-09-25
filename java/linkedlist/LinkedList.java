package linkedlist;

import java.util.HashSet;

public class LinkedList {
    class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    Node head = null;

    public LinkedList(int value) {
        this.head = new Node(value);
    }

    public LinkedList add(int value) {
        Node tail = this.head;
        while (tail.next != null) {
            tail = tail.next;
        }

        tail.next = new Node(value);

        return this;
    }

    public void remove(int value) {
        Node prev = null;
        Node n = this.head;
        while (n != null && n.value != value) {
            prev = n;
            n = n.next;
        }

        // n is null then we didn't found the value
        if (n == null) return;

        // n is head
        if (prev == null) {
            this.head = this.head.next;
        } else {
            prev.next = n.next;
        }
    }

    public void unique() {
        if (this.head == null) return;

        Node prev = null;
        Node n = this.head;
        var values = new HashSet<Integer>();
        while (n != null) {
            if (values.contains(n.value)) {
                prev.next = n.next;
            } else {
                prev = n;
                values.add(n.value);
            }

            n = n.next;
        }
    }

    public void print() {
        Node n = this.head;
        while (n != null) {
            System.out.format("%s -> ", n.value);
            n = n.next;
        }
        System.out.println("DONE!");
    }

    public Integer findKthLast(int pos) {
        Node n = this.head;
        Node kth = this.head;
        int i = 0;
        while (n != null) {
            if (++i > pos) {
                kth = kth.next;

            }

            n = n.next;
        }

        if (i >= pos) {
            return kth.value;
        }

        return null;
    }

    public static void main(String[] args) {
        var list = new LinkedList(1).add(1).add(2).add(3).add(3).add(1).add(2).add(1).add(2);

        System.out.println(list.findKthLast(8));
        System.out.println(list.findKthLast(50));

        // list.unique();
        // list.print();
    }
}

