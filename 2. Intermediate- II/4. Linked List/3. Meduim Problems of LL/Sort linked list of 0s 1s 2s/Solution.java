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
        int[] arr = {1,0,2,1,0,2,1};
        Node head = convertArrayToLL(arr); 
        Node dummyHead = head; 
        System.out.println("Original Linked List");
        printLinkedList(dummyHead);
        System.out.println();
        System.out.println();

        // Sort Linked List 0,1,2
        Node inputList = convertArrayToLL(arr); 
        System.out.println("Sorted List");
        Node sortedList = sortZeroOneTwoList(inputList); 
        printLinkedList(sortedList);
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

    //  Sort Linked List 0,1,2
    private static Node sortZeroOneTwoList(Node head)
    {
        if (head == null || head.next == null)
        return head;

    Node zeroHead = new Node();
    Node oneHead = new Node();
    Node twoHead = new Node();

    Node zeroTail = zeroHead;
    Node oneTail = oneHead;
    Node twoTail = twoHead;

    Node current = head;

    while (current != null) {
        if (current.data == 0) {
            zeroTail.next = current;
            zeroTail = current;
        } else if (current.data == 1) {
            oneTail.next = current;
            oneTail = current;
        } else {
            twoTail.next = current;
            twoTail = current;
        }
        current = current.next;
    }

    zeroTail.next = oneHead.next != null ? oneHead.next : twoHead.next;
    oneTail.next = twoHead.next;

    twoTail.next = null;

    return zeroHead.next;
    }
}

