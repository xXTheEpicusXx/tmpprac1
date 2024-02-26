class Node {
    int data;
    Node prev;
    Node next;

    public Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

class MyLinkedList {
    Node head;
    Node tail;

    public MyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void addToFront(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    public void addToEnd(int data) {
        Node newNode = new Node(data);
        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void removeFirst() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
    }

    public void removeAll(int value) {
        Node current = head;
        while (current != null) {
            if (current.data == value) {
                if (current == head) {
                    removeFirst();
                    current = head;
                } else if (current == tail) {
                    tail = tail.prev;
                    tail.next = null;
                    current = null;
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                    current = current.next;
                }
            } else {
                current = current.next;
            }
        }
    }
}
