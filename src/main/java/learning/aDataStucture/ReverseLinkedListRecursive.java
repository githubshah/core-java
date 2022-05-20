package learning.aDataStucture;// Recursive Java program to reverse
// a linked list

import java.io.IOException;
import java.util.Scanner;

public class ReverseLinkedListRecursive {

    private static final Scanner scanner = new Scanner(System.in);

    /* Function to print linked list */
    public static void printSinglyLinkedList(Node node,
                                             String sep) throws IOException {
        while (node != null) {
            System.out.print(String.valueOf(node.data) + sep);
            node = node.next;
        }
    }

    // Complete the reverse function below.
    static Node reverse(Node node) {
        if (node == null) {
            return node;
        }

        // last node or only one node
        if (node.next == null) {
            return node;
        }

        Node newHeadNode = reverse(node.next);

        // change references for middle chain
        node.next.next = node;
        node.next = null;

        // send back new node node in every recursion
        return newHeadNode;
    }

    public static void main(String[] args) throws IOException {
        LinkedList llist = new LinkedList();

        llist.insertNode(20);
        llist.insertNode(4);
        llist.insertNode(15);
        llist.insertNode(85);

        System.out.println("Given linked list:");
        printSinglyLinkedList(llist.head, " ");

        System.out.println();
        System.out.println("Reversed Linked list:");
        Node llist1 = reverse(llist.head);
        printSinglyLinkedList(llist1, " ");

        scanner.close();
    }

    /* Link list node */
    static class Node {
        public int data;
        public Node next;

        public Node(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class LinkedList {
        public Node head;

        public LinkedList() {
            this.head = null;
        }

        public void insertNode(int nodeData) {
            Node node = new Node(nodeData);

            if (this.head != null) {
                node.next = head;
            }
            this.head = node;
        }
    }
}
