class Node {
    public int data;
    public Node next;

    Node() {
        this.data = 0;
        this.next = null;
    }
    // Constructor with only Data 
    Node(int data)
    {
        this.data = data;
    }

    // Constructor with Data and Pointer
    Node(int data, Node next)
    {
        this.data = data;
        this.next = next;
    }
}

public class Solution
{
    public static void main(String[] args)
    {
        int[] arr = {1,2,3,4,5};
        Node head = convertArrayToLL(arr); 
        Node dummyHead = head; 
        System.out.println("Original Linked List");
        printLinkedList(dummyHead);
        System.out.println();
        System.out.println();

        // Reverse Linked List Itreative
        Node inputList = convertArrayToLL(arr); 
        System.out.println("Reversed Linked List Itreative");
        Node newLL = reverseLinkedListItreative(inputList); 
        printLinkedList(newLL);
        System.out.println();
        System.out.println();

        // Reverse Linked List Revursive
        Node inputList1 = convertArrayToLL(arr); 
        System.out.println("Reversed Linked List recursive");
        Node newLL1 = reverseLinkedListRecursive(inputList1); 
        printLinkedList(newLL1);
    }

    // Convert array into the linked list.
    private static Node convertArrayToLL(int[] arr)
    {
        Node head = new Node(arr[0]);
        Node temp = head;

        for(int i=1; i<arr.length; i++)
        {
            Node newNode = new Node(arr[i]);
            temp.next = newNode;
            temp = newNode;
        } 
        return head;
    }
    
    // Print the Linked List
    private static void printLinkedList(Node head)
    {
        Node temp = head;  
        while(temp != null)
        {
            System.out.print(temp.data + " --> ");
            temp = temp.next;
        }
        System.out.print("Null");
    }

    // Reversed Linked List Itreative
    private static Node reverseLinkedListItreative(Node head)
    {
        Node prev = null;
        Node currentNode = head;

        while(currentNode != null)
        {
            Node front = currentNode.next;
            currentNode.next = prev;
            prev = currentNode;
            currentNode = front;
        }
        return prev;
    }
    // Reversed Linked List Recursive
    private static Node reverseLinkedListRecursive(Node head)
    {
        if(head == null || head.next == null)
        {
            return head;
        }

        Node newHead = reverseLinkedListRecursive(head.next);
        Node front = head.next;
        front.next = head;
        head.next = null;
        return newHead;
    }
}

