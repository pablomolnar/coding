package linkedlist;

public class LinkedList {
    class Node {
        int value;
    
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
        while(tail.next != null) {
            tail = tail.next;
        }

        tail.next = new Node(value);

        return this;
    }

    public void remove(int value) {
        Node prev = null;
        Node n = this.head;
        while(n != null && n.value != value) {
            prev = n;
            n = n.next;
        }

        // n is null then we didn't found the value
        if(n == null) return;

        // n is head
        if(prev == null) {
            this.head = this.head.next;
        } else {
            prev.next = n.next;
        }
    }

    public void unique() {
        if(this.head == null) return;
        Node n = this.head;
        var values = new HashSet<Integer>(n.value);
        while(n.next != null) {
            if(values.contains(n.next.value)) {
                n.next = n.next.next;
            }

            n = n.next;
        }
    }

    public void print() {
        Node n = this.head;
        while(n!= null) {
            System.out.format("%s -> ", n.value);
        }
        System.out.println("DONE!");
    }

    public static void main(String[] args)  { 
        var list = new LinkedList(1).add(1).add(2).add(3).add(2).add(1);
        list.unique();

        list.print();
    } 
}

