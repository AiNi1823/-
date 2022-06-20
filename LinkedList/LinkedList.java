package LinkedList;

public class LinkedList {
    Node head;

    static class Node {
        int value;
        Node next;

        Node(int d) {
            value = d;
            next = null;
        }
    }

    public void insertAtBeginning(int newData) {
        Node newNode = new Node(newData);
        newNode.next = head;
        head = newNode;
    }

    public void insertAfter(Node prevNode, int newData) {
        if (prevNode == null) {
            System.out.println("The given previous node cannot be null.");
            return;
        }
        Node newNode = new Node(newData);
        newNode.next = prevNode.next;
        prevNode.next = newNode;
    }

    public void insertAtEnd(int newData) {
        Node newNode = new Node(newData);
        if (head == null) {
            head = new Node(newData);
            return;
        }
        newNode.next = null;
        Node last = head;
        while (last.next != null) {
            last = last.next;
        }
        last.next = newNode;
        return;
    }

    void deleteNode(int position) {
        if (head == null) {
            return;
        }

        Node temp = head;

        if (position == 0) {
            head = temp.next;
            return;
        }

        for (int i = 0; temp != null && i < position - 1; i++) {
            temp = temp.next;
        }

        //If the key is not present
        if (temp == null || temp.next == null) {
            return;
        }

        Node next = temp.next.next;
        temp.next = next;
    }

    boolean search(Node head, int key) {
        Node current = head;
        while (current != null) {
            if (current.value == key) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    void sortLinkedList(Node head) {
        Node current = head;
        Node index = null;
        int temp;

        if (head == null) {
            return;
        } else {
            while (current != null) {
                //index = current.next;
                index = current.next;
                while (index != null) {
                    if (current.value > index.value) {
                        temp = current.value;
                        current.value = index.value;
                        index.value = temp;
                    }
                    index = index.next;
                }
                current = current.next;
            }
        }
    }

    public void printList() {
        Node tnode = head;
        while (tnode != null) {
            System.out.println(tnode.value + " ");
            tnode = tnode.next;
        }
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();

        linkedList.insertAtEnd(1);
        linkedList.insertAtBeginning(2);
        linkedList.insertAtBeginning(3);
        linkedList.insertAtEnd(4);
        linkedList.insertAfter(linkedList.head.next, 5);

        System.out.println("Linked list: ");
        linkedList.printList();

        System.out.println("\nAfter  deleting an element: ");
        linkedList.deleteNode(3);
        linkedList.printList();

        System.out.println();
        int itemToFind = 3;
        if (linkedList.search(linkedList.head, itemToFind)) {
            System.out.println(itemToFind + " is found");
        } else {
            System.out.println(itemToFind + " is not found");
        }

        linkedList.sortLinkedList(linkedList.head);
        System.out.println("\nSorted List: ");
        linkedList.printList();
    }
}
